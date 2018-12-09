package com.comers.sdk.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.LruCache;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yujuan on 2017/11/15.
 */
public class ImageLoader {
    /**
     * 缓存Image的类，当存储Image的大小大于LruCache设定的值，系统自动释放内存
     */
    private LruCache<String, Bitmap> mMemoryCache;
    /**
     * 操作文件相关类对象的引用
     */
    private ImageFileUtils fileUtils;
    /**
     * 下载Image的线程池
     */
    private ExecutorService mImageThreadPool = null;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public ImageLoader(Context context){
        //获取系统分配给每个应用程序的最大内存，每个应用系统分配32M
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int mCacheSize = maxMemory / 8;
        //给LruCache分配1/8 4M
        mMemoryCache = new LruCache<String, Bitmap>(mCacheSize){

            //必须重写此方法，来测量Bitmap的大小
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }

        };

        fileUtils = new ImageFileUtils(context);
    }


    /**
     * 获取线程池的方法，因为涉及到并发的问题，我们加上同步锁
     * @return
     */
    public ExecutorService getThreadPool(){
        if(mImageThreadPool == null){
            synchronized(ExecutorService.class){
                if(mImageThreadPool == null){
                    //为了下载图片更加的流畅，我们用了2个线程来下载图片
                    mImageThreadPool = Executors.newFixedThreadPool(2);
                }
            }
        }

        return mImageThreadPool;

    }

    /**
     * 添加Bitmap到内存缓存
     * @param key
     * @param bitmap
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemCache(key) == null && bitmap != null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * 从内存缓存中获取一个Bitmap
     * @param key
     * @return
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    public Bitmap getBitmapFromMemCache(String key) {
        return mMemoryCache.get(key);
    }

    /**
     * 先从内存缓存中获取Bitmap,如果没有就从SD卡或者手机缓存中获取，SD卡或者手机缓存
     * 没有就去下载
     * @param url
     * @param listener
     * @return
     */
    public Bitmap downloadImage(final String url, final onImageLoaderListener listener){
        //替换Url中非字母和非数字的字符，这里比较重要，因为我们用Url作为文件名，比如我们的Url
        //是Http://xiaanming/abc.jpg;用这个作为图片名称，系统会认为xiaanming为一个目录，
        //我们没有创建此目录保存文件就会报错
        final String subUrl = url.replaceAll("[^\\w]", "");
        Bitmap bitmap = showCacheBitmap(url);
        if(bitmap != null){
            return bitmap;
        }else{

            final Handler handler = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    listener.onImageLoader((Bitmap)msg.obj, url);
                }
            };

            getThreadPool().execute(new Runnable() {

                @Override
                public void run() {
//                    Bitmap bitmap = getBitmapFormUrl(url);
                    Bitmap bitmap = loadImage(url);
                    Message msg = handler.obtainMessage();
                    msg.obj = bitmap;
                    handler.sendMessage(msg);

                    try {
//                        保存在SD卡或者手机目录
                        fileUtils.savaBitmap(subUrl, bitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //将Bitmap 加入内存缓存
                    addBitmapToMemoryCache(subUrl, bitmap);
                }
            });
        }

        return null;
    }

    /**
     * 获取Bitmap, 内存中没有就去手机或者sd卡中获取，这一步在getView中会调用，比较关键的一步
     * @param url
     * @return
     */
    public Bitmap showCacheBitmap(String url){
        if(getBitmapFromMemCache(url) != null){
            return getBitmapFromMemCache(url);
        }else if(fileUtils.isFileExists(url) && fileUtils.getFileSize(url) != 0){
            //从SD卡获取手机里面获取Bitmap
            Bitmap bitmap = fileUtils.getBitmap(url);

            //将Bitmap 加入内存缓存
            addBitmapToMemoryCache(url, bitmap);
            return bitmap;
        }

        return null;
    }


    /**
     * 从Url中获取Bitmap
     * @param url
     * @return
     */
    private Bitmap getBitmapFormUrl(String url) {
        Bitmap bitmap = null;
        HttpURLConnection con = null;
        try {
            URL mImageUrl = new URL(url);
            con = (HttpURLConnection) mImageUrl.openConnection();
            con.setConnectTimeout(10 * 1000);
            con.setReadTimeout(10 * 1000);
            con.setDoInput(true);
            con.setDoOutput(true);
            bitmap = BitmapFactory.decodeStream(con.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return bitmap;
    }

    /**
     * 取消正在下载的任务
     */
    public synchronized void cancelTask() {
        if(mImageThreadPool != null){
            mImageThreadPool.shutdownNow();
            mImageThreadPool = null;
        }
    }


    /**
     * 异步下载图片的回调接口
     * @author len
     *
     */
    public interface onImageLoaderListener{
        void onImageLoader(Bitmap bitmap, String url);
    }
    public static Bitmap loadImage(String url) {
        URL imgUrl = null;
        Bitmap bitmap = null;
        try {
            url=toUtf8String(url);
            imgUrl = new URL(url);
            // 使用HttpURLConnection打开连接
            HttpURLConnection urlConn = (HttpURLConnection) imgUrl
                    .openConnection();
            urlConn.setDoInput(true);
            urlConn.setRequestProperty("Charset", "UTF-8");
            urlConn.connect();
            // 将得到的数据转化成InputStream
            InputStream is = urlConn.getInputStream();
            // 将InputStream转换成Bitmap
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    public static String toUtf8String(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            } else {
                byte[] b;
                try {
                    b = String.valueOf(c).getBytes("utf-8");
                } catch (Exception ex) {
                    System.out.println(ex);
                    b = new byte[0];
                }
                for (int j = 0; j < b.length; j++) {
                    int k = b[j];
                    if (k < 0)
                        k += 256;
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }
}
