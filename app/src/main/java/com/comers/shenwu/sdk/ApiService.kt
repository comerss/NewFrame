package com.comers.shenwu.sdk

import com.comers.baselibrary.http.HttpResult
import io.reactivex.Single

/**
 * Created by 79653 on 2018/8/9.
 * 描述：
 */
interface ApiService {
    fun getData(): Single<HttpResult<ListData>>
}