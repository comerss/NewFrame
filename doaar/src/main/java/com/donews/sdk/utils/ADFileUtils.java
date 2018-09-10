package com.donews.sdk.utils;

import android.content.Context;
import android.text.TextUtils;

import com.donews.sdk.bean.SizeEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujuan on 2018/5/7.
 */

public class ADFileUtils {
    public static void saveSlashSizeFile(String json) {
        String jsonStr = json+"#"+System.currentTimeMillis()/1000/60;
        try {
            File file = new File(FileUtils.sdPath(), "splashsize.dn");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            FileOutputStream outStream = new FileOutputStream(file);
            // 获取字符串对象的byte数组并写入文件流
            outStream.write(jsonStr.getBytes());
            // 最后关闭文件输出流
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    /**
     * 读取文件里面的内容
     *
     * @return
     */
    public static String getSplshsizeFile() {
        try {
            // 创建文件
            File file = new File(FileUtils.sdPath(), "splashsize.dn");
            // 创建FileInputStream对象
            FileInputStream fis = new FileInputStream(file);
            // 创建字节数组 每次缓冲1M
            byte[] b = new byte[1024];
            int len = 0;// 一次读取1024字节大小，没有数据后返回-1.
            // 创建ByteArrayOutputStream对象
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 一次读取1024个字节，然后往字符输出流中写读取的字节数
            while ((len = fis.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            // 将读取的字节总数生成字节数组
            byte[] data = baos.toByteArray();
            // 关闭字节输出流
            baos.close();
            // 关闭文件输入流
            fis.close();
            // 返回字符串对象
            return new String(data);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public static int getOldTime(Context c) {
        int oldTime=0;
        String datas=getSplshsizeFile();
        if(!TextUtils.isEmpty(datas)){
            String[] hahas=datas.split("#");
            if(hahas.length>1){
                oldTime=Integer.parseInt(hahas[1]);
            }
        }
        return oldTime;
    }

    public static List<SizeEntity> getSplashSizes(){
        List<SizeEntity> entities=new ArrayList<>();
        String datas=getSplshsizeFile();
        if(!TextUtils.isEmpty(datas)){
            String[] hahas=datas.split("#");
            if(hahas.length>1) {
                String json = hahas[0];
                JSONArray result = JSONParser.getJSONArray(json);
                if (result != null) {
                    if (result.length() > 0) {
                        for (int i = 0; i < result.length(); i++) {
                            try {
                                JSONObject object = result.getJSONObject(i);
                                int w = object.getInt("w");
                                int h = object.getInt("h");
                                SizeEntity entity = new SizeEntity(w, h);
                                entities.add(entity);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

            }
        return entities;
    }

}
