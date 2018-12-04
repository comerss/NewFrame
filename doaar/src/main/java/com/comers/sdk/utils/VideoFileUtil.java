package com.comers.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yujuan on 2018/3/13.
 */

public class VideoFileUtil {
    /**
     * 设置视频广告的缓存根目录
     * @param mContext
     * @return
     */
    public static String getVideoRootPath(Context mContext){
        String rootPath = mContext.getFilesDir().getAbsolutePath();
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            rootPath = Environment.getExternalStorageDirectory() + "";
        }
        return rootPath + File.separator + "Donews" + File.separator + "VideoCache"+File.separator;
    }
    public static String getVideoPath(Context mContext ,String videoUrl){
        String[] fileNames=videoUrl.split("/");
        String fileName=fileNames[fileNames.length-1];
        String path = getVideoRootPath(mContext)+System.currentTimeMillis()/1000/60/60/24+File.separator+fileName;
        return path;
    }
    /**
     * 判断视频广告是否已经缓存
     * @param mContext
     * @param videoUrl
     * @return
     */
    public static boolean videoIsExits(Context mContext ,String videoUrl){
        String path=getVideoPath(mContext,videoUrl);
        File file = new File(path);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 获取VideoCache目录下所有文件名
     */
    public static JSONArray getVideoCacheFiles(Context mContext) {
        String dirPath=getVideoRootPath(mContext);
        File f = new File(dirPath);
        if (!f.exists()) {//判断路径是否存在
            return null;
        }

        File[] files = f.listFiles();

        if(files==null){//判断权限
            Log.e("download","getVideoCacheFilesLLL  not file");
            return null;
        }

        JSONArray fileList = new JSONArray();
        for (File _file : files) {//遍历目录
            if(_file.isDirectory()){
                String _name=_file.getName();
                Log.e("download","getVideoCacheFilesLLL"+_name);
                String filePath = _file.getAbsolutePath();//获取文件路径
                try {
                    JSONObject _fInfo = new JSONObject();
                    _fInfo.put("name", _name);
                    _fInfo.put("path", filePath);
                    fileList.put(_fInfo);
                }catch (Exception e){
                }
            } else{
            }
        }
        return fileList;
    }

    public static void delOverTimeFile(Context context){
        JSONArray dats=getVideoCacheFiles(context);
        if(dats!=null && dats.length()>0){
            for(int i=0;i<dats.length();i++){
                try {
                    JSONObject object= (JSONObject) dats.get(i);
                    String pathname=object.getString("name");
                    Log.e("download","delOverTimeFileLLL"+pathname);
                    if(!TextUtils.isEmpty(pathname)) {
                        long curTime = System.currentTimeMillis() / 1000 / 60 / 60 / 24;
                        long oldTime=Long.parseLong(pathname);
                        if(curTime-oldTime>2){//两天之前的都删除
                            Log.e("download","delOverTimeFileLLL"+object.getString("path"));
                            delete(object.getString("path"));
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName
     *            要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }
    }
    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }
    /**
     * 删除目录及目录下的文件
     *
     * @param dir
     *            要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator))
            dir = dir + File.separator;
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            System.out.println("删除目录失败：" + dir + "不存在！");
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag)
                    break;
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag)
                    break;
            }
        }
        if (!flag) {
            System.out.println("删除目录失败！");
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            System.out.println("删除目录" + dir + "成功！");
            return true;
        } else {
            return false;
        }
    }


    private static boolean isready = false;
    private static int errorCnt = 0;
    private static long mediaLength = 0;
    private static long readSize = 0;
    public final static int CACHE_VIDEO_READY = 314;
    public final static int CACHE_VIDEO_UPDATE =315;
    public final static int CACHE_VIDEO_END = 316;
    private static final int READY_BUFF = 2000 * 1024;
    private static final int CACHE_BUFF = 500 * 1024;
    public static void loadVideo2File(Context mContext, String videoUrl, Handler mHandler){
        if(TextUtils.isEmpty(videoUrl)){
            return;
        }
        if(videoIsExits(mContext,videoUrl)){//如果存在就不缓存
            return;
        }
        String filename=getVideoPath(mContext,videoUrl);
        FileOutputStream out = null;
        InputStream is = null;

        try {
            URL url = new URL(videoUrl);
            HttpURLConnection httpConnection = (HttpURLConnection) url
                    .openConnection();

            File cacheFile = new File(filename);

            if (!cacheFile.exists()) {
                cacheFile.getParentFile().mkdirs();
                cacheFile.createNewFile();
            }

            readSize = cacheFile.length();
            out = new FileOutputStream(cacheFile, true);

            httpConnection.setRequestProperty("User-Agent", "NetFox");
            httpConnection.setRequestProperty("RANGE", "bytes="
                    + readSize + "-");

            is = httpConnection.getInputStream();

            mediaLength = httpConnection.getContentLength();
            if (mediaLength == -1) {
                return;
            }

            mediaLength += readSize;

            byte buf[] = new byte[4 * 1024];
            int size = 0;
            long lastReadSize = 0;
            while ((size = is.read(buf)) != -1) {
                try {
                    out.write(buf, 0, size);
                    readSize += size;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (!isready) {
                    if ((readSize - lastReadSize) > READY_BUFF) {
                        lastReadSize = readSize;
                        if(mHandler!=null)
                        mHandler.sendEmptyMessage(CACHE_VIDEO_READY);
                    }
                } else {
                    if ((readSize - lastReadSize) > CACHE_BUFF
                            * (errorCnt + 1)) {
                        lastReadSize = readSize;
                        if(mHandler!=null)
                        mHandler.sendEmptyMessage(CACHE_VIDEO_UPDATE);
                    }
                }
            }
            if(mHandler!=null)
            mHandler.sendEmptyMessage(CACHE_VIDEO_END);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    //
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    //
                }
            }
        }
    }


}
