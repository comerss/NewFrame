package com.comers.baselibrary.http;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Comers on 2017/10/24.
 */

public class HttpHelper {

    private static HttpHelper mSingleton;
    private static long CONNECT_TIME_OUT = 30;
    private static long WRITE_TIME_OUT = 60;
    private static long READ_TIME_OUT = 60;
    private volatile static OkHttpClient mOkHttpClient;
    public static Activity mContext;

    public static HttpHelper getInstance() {
        if (mSingleton == null) {
            synchronized (HttpHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new HttpHelper();
                }
            }
        }
        return mSingleton;
    }

    public static FormRequest doForm(@NonNull String url) {
        return new FormRequest(url);
    }
    public static PostRequest doPost(@NonNull String url) {
        return new PostRequest(url);
    }
    public static GetRequest doGet(@NonNull String url) {
        return new GetRequest(url);
    }
    public static PostRequest doPostStr(String url ,String content){
        return new PostRequest(url,content);
    }
    public  void init(String baseUrl){
        HttpConfig.baseUrl=baseUrl;
    }
    public static OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            synchronized (HttpHelper.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                            .addInterceptor(new LoggingInterceptor())
                            .build();
                }
            }
        }
        return mOkHttpClient;
    }

    public HttpHelper connectTimeout(long connectTimeout) {
        CONNECT_TIME_OUT = connectTimeout;
        return this;
    }

    public HttpHelper writeTimeout(long writeTimeout) {
        WRITE_TIME_OUT = writeTimeout;
        return this;
    }

    public HttpHelper readTimeout(long readTimeout) {
        READ_TIME_OUT = readTimeout;
        return this;
    }
    public static void downLoad(String url, final String filePath, final ProgressResponseListener listener){
        if(listener==null)
            throw new IllegalArgumentException("ProgressResponseListener may not be null");
        if(TextUtils.isEmpty(filePath)||TextUtils.isEmpty(url)){
            throw new IllegalArgumentException("url or filePath  may not be null");
        }
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(url).build();
        ProgressHelper.addProgressResponseListener(listener).newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                File file1 = new File(filePath);
                long totalLength=response.body().contentLength();
                if (file1.exists()) {
                    if (totalLength == file1.length()) {
                        // 下载完成
                        listener.onLoad(file1,true);
                        return;
                    } else {
                        file1.delete();
                    }
                } else {
                    file1.createNewFile();
                }
                int len;
                byte[] buf = new byte[1024*1024];
                InputStream inputStream = response.body().byteStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                while ((len = inputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, len);
                }
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                listener.onLoad(file1,false);
            }
        });
    }

}
