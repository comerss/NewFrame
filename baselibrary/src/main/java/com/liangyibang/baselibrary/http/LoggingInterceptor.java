package com.liangyibang.baselibrary.http;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by 79653 on 2018/6/12.
 * 描述：
 */
public class LoggingInterceptor implements Interceptor {
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
