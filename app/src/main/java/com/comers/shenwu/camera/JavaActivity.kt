package com.comers.shenwu.camera

import android.Manifest
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v13.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.comers.baselibrary.base.CrashHelper
import com.comers.baselibrary.http.ClientConfig
import io.reactivex.Single
import okhttp3.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.zip.GZIPOutputStream


/**
 * Created by 79653 on 2018/7/2.
 * 描述：
 */
class JavaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CrashHelper.getDefault().init(this)
        initData()
    }

    @MainThread
    private fun initData() {
        //        sendReport();
        //        ex();
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 1)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

    }

    private fun ex() {
        Single.just("999")
                .subscribe({ },
                        { }
                )

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    private fun sendReport() {

    }

    fun uploadlog() {
        val username = "cm9vdA=="
        val password = "ZG9uZXdzMTIz"
        /*
        oss_userinfo
        https://api.g.com.cn/oss_userinfo?appid&version
        default:
        {username: "cm9vdA==", password = "ZG9uZXdzMTIz", uploadaddress =  http://minio-db.xy.huijitrans.com/put"}
        */
        val busername = Base64.decode(username, Base64.DEFAULT)
        val bpasword = Base64.decode(password, Base64.DEFAULT)
        val name = String(busername)
        val passwd = String(bpasword)

        val client = OkHttpClient.Builder()
                .authenticator { route, response ->
                    val credential = Credentials.basic(name, passwd, Charset.forName("UTF-8"))
                    response.request().newBuilder().header("Authorization", credential).build()
                }
                .build()

        var sb: StringBuilder? = null
        try {
            sb = StringBuilder()
            for (n in 0..999) {
                sb.append(n)
                sb.append(",")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var response: Response? = null
        try {
            //压缩一下，效果更好
            //Gzip
            val buffer = gzip(sb!!.toString())
            val body = RequestBody.create(MediaType.parse("application/octet-stream"), buffer!!)//file 可以上传一个文件
            val request = Request.Builder()
                    .url("http://minio-db.xy.huijitrans.com/put/yinli/2199777/log_yyyyMMddhhmmssSSS.txt")
                    .put(body)
                    .build()
            response = client.newCall(request).execute()
            Log.i("TAG", response!!.code().toString() + ":" + response.body()!!.string())

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                response!!.close()
            } catch (e: Exception) {

            }

        }
    }

    companion object {

        fun gzip(unGzipStr: String): ByteArray? {
            try {
                val baos = ByteArrayOutputStream()
                val gzip = GZIPOutputStream(baos)
                gzip.write(unGzipStr.toByteArray())
                gzip.close()
                val encode = baos.toByteArray()
                baos.flush()
                baos.close()
                return encode
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null
        }
    }

    fun okhttpGet() {
        var request = Request.Builder().url("www.baidu.com")
                .get().build()
        var call = ClientConfig.getClient().newCall(request)
//        call.execute()
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
            }

        })
    }

    fun glide(){
        Glide.with(this).load("").into(ImageView(this))
    }

}
