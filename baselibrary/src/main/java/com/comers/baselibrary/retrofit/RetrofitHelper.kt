package com.comers.baselibrary.retrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 79653 on 2018/6/22.
 * 描述：
 */
class RetrofitHelper private constructor() {
    private lateinit var mOkHttpClient: OkHttpClient
    private lateinit var mRetrofit: Retrofit

    companion object {
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder {
        val holder = RetrofitHelper()
    }
    //进行数据的初始化，可以添加公共头部，公共参数等等
    init {
        initClient()
        initRetrofit()
    }

    //初始化Okhttp
    private fun initClient() {
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(6000, TimeUnit.MILLISECONDS)
                .readTimeout(6000, TimeUnit.MILLISECONDS)
                .writeTimeout(6000, TimeUnit.MILLISECONDS)
                .addInterceptor(LoggingInterceptor())
                .build()
    }
    private fun initRetrofit() {
        mRetrofit=Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
    }
}
