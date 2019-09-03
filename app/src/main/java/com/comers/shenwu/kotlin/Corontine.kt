package com.comers.shenwu.kotlin

import android.arch.lifecycle.LifecycleOwner
import android.provider.Contacts
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

object Corontine {

    @JvmStatic
    fun main(args: Array<String>) {
        var job: Job = GlobalScope.launch(Dispatchers.IO) {
            launch(Dispatchers.Main) {
                //更新UI
            }
        }

        //可以获取返回值
        var defer = GlobalScope.async {
            "000"
        }
        defer.getCompleted()


        //Dispatchers.Default 是默认的后台线程池
        //Dispatchers.Unconfined 不受限 将工作在主线程中


        var joob = CoroutineScope(Dispatchers.Main).launch {
            //与launch 区别是 可以获取返回值
            async(context = EmptyCoroutineContext) {

            }.await()  //挂起 会继续往下执行 否则需要等待里面的代码执行完成之后才会继续往下执行
            "0000000"
        }
        job.invokeOnCompletion {

        }

        joob?.let {
            7
        }.run {
            6
        }.takeIf {
            it == 5
        }
        //不同于上面的是这个会阻塞当前线程 直到协程执行结束
        runBlocking {

        }


    }

    suspend fun getData() {
        1 + 3

    }
}
