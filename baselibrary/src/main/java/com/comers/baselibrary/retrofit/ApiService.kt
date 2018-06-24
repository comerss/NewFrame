package com.comers.baselibrary.retrofit

import com.comers.baselibrary.http.HttpResult
import com.comers.market.base.Data
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by 79653 on 2018/6/24.
 * 描述：
 */
interface ApiService {
    @GET("kkk")
    fun getData(): Observable<HttpResult<List<Data>>>
}