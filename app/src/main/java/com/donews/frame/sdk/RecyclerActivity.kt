package com.donews.frame.sdk

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.comers.baselibrary.imooc.http.HttpManager
import com.comers.baselibrary.imooc.service.MoocRequest
import com.comers.baselibrary.imooc.service.MoocResponse
import com.comers.baselibrary.imooc.service.WorkStation
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.donews.frame.R
import kotlinx.android.synthetic.main.activity_recycler.*

/**
 * Created by 79653 on 2018/7/31.
 * 描述：
 */
class RecyclerActivity : RxBaseActivity() {
    lateinit var adapter: RecyclerAdapter;
    override fun getLayoutId(): Int {
        return R.layout.activity_recycler
    }

    override fun initView() {
        adapter = RecyclerAdapter(this)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = adapter
        adapter.bindToRecyclerView(mRecyclerView)
        var layout = LinearLayout(this)
        adapter.addHeaderView(layout)
        adapter.setNewData(dataList)
//        download("http://donewsdata.donews.com/DonewsHot_tuiguang_008.apk")
//        download("http://donewsdata.donews.com/DonewsHot_tuiguang_006.apk")
//        doRequest()
//        DownLoadHelper.instance().download(this,"http://a.de0.cc/qyiqau")
        doHttp()
    }

    private fun doHttp() {
        /*HttpManager.INSTANCE.doGet("http://www.wanandroid.com/friend/json", object : MoocResponse<String>() {
            override fun success(request: MoocRequest?, data: String?) {
                Log.i("info", data)
            }

            override fun fail(errorCode: Int, errorMsg: String?) {
                Log.i("info", errorMsg)
            }

        })*/
        var map = mutableMapOf<String, Any?>()
        map["username"] = "comers"
        map["password"] = "123456"
        map["repassword"]="123456"
        HttpManager.INSTANCE.doPost("http://www.wanandroid.com/user/register",map, object : MoocResponse<String>() {
            override fun success(request: MoocRequest?, data: String?) {
                Log.i("info", data)
            }

            override fun fail(errorCode: Int, errorMsg: String?) {
                Log.i("info", errorMsg)
            }

        })
    }

    private var sWorkStation = WorkStation()


    var mDistance = 0
    override fun initListener() {
        mRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var manager = mRecyclerView.layoutManager
                var first = (manager as LinearLayoutManager).findFirstVisibleItemPosition()
                var last = (manager as LinearLayoutManager).findLastVisibleItemPosition()

                Log.i("position", "first---->$first")
                Log.i("position", "last---->$last")
                var isDown = true
                if (first == 0) {
                    isDown = true
                } else {
                    if (mDistance > 20 && isDown) {
                        isDown = false
                        mDistance = 0
                    } else if (mDistance < -20 && !isDown) {
                        isDown = true
                        mDistance = 0
                    }
                }
                if (isDown && dy > 0 || !isDown && dy < 0) {
                    mDistance += dy
                }

                if (first == 10) {
                    dataList.removeAt(7)
                    dataList.add(7, ListData("0000000", 9990))
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }

    var dataList: MutableList<ListData> = arrayListOf()
    override fun initData() {
        var int = 0
        while (true) {
            int++
            dataList.add(ListData("009090909", int))
            if (int > 100) {
                break
            }
        }
        adapter.notifyDataSetChanged()

    }

    fun download(url: String) {
        var request = DownloadManager.Request(Uri.parse(url))
        //移动网络情况下是否允许漫游
        request.setAllowedOverRoaming(false);

        //在通知栏中显示，默认就是显示的
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        request.setTitle("新版本Apk")
        request.setDescription("Apk Downloading")
        request.setVisibleInDownloadsUi(true)
        //获取DownloadManager
        var downloadManager = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        //将下载请求加入下载队列，加入下载队列后会给该任务返回一个long型的id，通过该id可以取消任务，重启任务、获取下载的文件等等
        var downloadId = downloadManager.enqueue(request)
    }

}