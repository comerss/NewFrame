package com.comers.baselibrary.retrofit

import com.comers.baselibrary.http.HttpResult
import com.comers.market.base.Data
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
interface ApiService {
    @GET("www.baidu.com{age}")
    fun getData(@Path("age") age: Int): Single<HttpResult<List<Data>>>
}