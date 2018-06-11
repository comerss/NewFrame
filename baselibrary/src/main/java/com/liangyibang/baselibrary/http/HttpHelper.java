package com.liangyibang.baselibrary.http;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

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

    public static FormRequest doForm(String url) {
        return new FormRequest(Constant.Host + url);
    }

    public static PostRequest doPost(String url) {
        return new PostRequest(Constant.Host + url);
    }

    public static GetRequest doGet(String url) {
        return new GetRequest(Constant.Host + url);
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

    private static class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //这个chain里面包含了request和response，所以你要什么都可以从这里拿
            Request request = chain.request();

            StringBuffer reqBuffer = new StringBuffer();
            reqBuffer.append("-----------------------------------------------------------------------------")
                    .append("\n")
                    .append("请求方式：" + request.method())
                    .append("\n")
                    .append(request.url())
                    .append(request.body().toString())
                    ;

            Response response = chain.proceed(request);

            ResponseBody responseBody = response.peekBody(1024 * 1024);
            StringBuffer resBuffer = new StringBuffer();
            resBuffer.append("请求返回：")
                    .append("\n")
                    .append(responseBody.string())
                    .append("\n")
                    .append("-----------------------------------------------------------------------------------");
            Log.i("HttpInfo", reqBuffer.toString());
            return response;
        }
    }
}
