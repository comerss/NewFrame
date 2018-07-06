package com.donews.frame.camera

import android.util.Base64
import com.comers.baselibrary.base.BaseActivity
import com.donews.frame.R
import okhttp3.*
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.util.zip.GZIPOutputStream


class HomeActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {

    }

    override fun initListener() {


    }

    override fun initData() {

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
            val body = RequestBody.create(MediaType.parse("application/octet-stream"), buffer)//file 可以上传一个文件
            val request = Request.Builder()
                    .url("http://minio-db.xy.huijitrans.com/put/yinli/2199777/log_yyyyMMddhhmmssSSS.txt")
                    .put(body)
                    .build()
            response = client.newCall(request).execute()
//            Log.Utils(FragmentActivity.TAG, response!!.code() + ":" + response!!.body().string())

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                response!!.close()
            } catch (e: Exception) {

            }

        }
    }

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
