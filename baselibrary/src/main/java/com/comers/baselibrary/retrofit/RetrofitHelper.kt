package com.comers.baselibrary.retrofit

import android.util.Log
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 79653 on 2018/6/22.
 * 描述：
 */
object RetrofitHelper {
    private lateinit var mOkHttpClient: OkHttpClient
    private lateinit var mRetrofit: Retrofit

    //进行数据的初始化，可以添加公共头部，公共参数等等
    init {
        initClient()
        initRetrofit()
        Log.i("TAG", "complete")
    }

    //初始化Okhttp
    private fun initClient() {
        mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(6000, TimeUnit.MILLISECONDS)
                .readTimeout(6000, TimeUnit.MILLISECONDS)
                .writeTimeout(6000, TimeUnit.MILLISECONDS)
                .addInterceptor(LoggingInterceptor())
                .build()
        Log.i("TAG", "initClient")
    }

    private fun initRetrofit() {
        mRetrofit = Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun create(): ApiService {
        return mRetrofit.create(ApiService::class.java)
    }

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }

}
