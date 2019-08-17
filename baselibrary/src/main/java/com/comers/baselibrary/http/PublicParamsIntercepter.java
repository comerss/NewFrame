package com.comers.baselibrary.http;

import java.io.IOException;
import java.nio.channels.Channel;

import okhttp3.Interceptor;
import okhttp3.Response;

/*
 * 设置公共请求参数的intercept
 * */
public class PublicParamsIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
