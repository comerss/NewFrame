package com.comers.baselibrary.http;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

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
    public static void init(String baseUrl){
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
}
