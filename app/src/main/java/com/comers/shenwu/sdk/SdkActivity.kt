package com.comers.shenwu.sdk

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.os.SystemClock
import android.telephony.TelephonyManager
import android.text.TextUtils
import android.util.Base64
import com.comers.baselibrary.http.HttpResult
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.comers.shenwu.R
import com.comers.shenwu.sdk.Utils.c
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.*
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

/**
 * Created by 79653 on 2018/7/5.
 * 描述：
 */
class SdkActivity : RxBaseActivity() {
    override fun initView() {
        var response = ""
    }

    override fun initListener() {
    }

    override fun initData() {
//        getAd()
//        downLoad()
//        getDas()
//        Download()
        Single.just(0).subscribe({

        },{

        })
        Single.just(HttpResult<ListData>()).subscribe { t1, t2 ->
            t1.data
            t2.message
        }
        Single.just(HttpResult<ListData>()).subscribe(object :SingleObserver<HttpResult<ListData>>{
            override fun onSuccess(t: HttpResult<ListData>) {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {

            }

        })
    }

    private fun Download() {

    }



    //获取广告的方法
    private fun getAd() {
        var url = "https://mOnClick.snssdk.com/api/ad/union/sdk/get_ads/"
        /*HttpManager.doPost(url)//这里只存在  3或者 4
                .execute(getParams(3).toString(), object : ICallBack<Data>() {
                    override fun onSuccess(sResult: HttpResult<Data>?, json: String?) {
                        showToast(json)
                    }
                })*/

    }


    override fun getLayoutId(): Int {
        return R.layout.activity_sdk
    }

    fun getPosition(var0: Int): Int {
        return when (var0) {
            1 -> 2
            2 -> 4
            3, 4, 7 -> 5
            5 -> 3
            6 -> 3
            else -> 3
        }
    }

    private fun getParams(var3: Int): JSONObject {
        val var4 = JSONObject()

        try {
            val var5 = JSONObject()
            val var6 = UUID.randomUUID()
            var5.put("request_id", UUID.randomUUID().toString())
            var5.put("ad_sdk_version", "1.9.2")
            var5.put("source_type", "app")
            var5.put("app", doParams())
            val var7 = doParams(this)
            if (var7 != null) {
//                var7.put("orientation", var1.getOrientation())
            }

            var5.put("device", var7)
            var5.put("user", getUser())
            var5.put("ua", getUa())
            var5.put("ip", getIp(true))
            val var8 = JSONArray()
            var8.put(initParam(var3))
            var5.put("adslots", var8)
            val var9 = getSecret(var5.toString(), "b0458c2b262949b8")
            if (!TextUtils.isEmpty(var9)) {
                var4.put("message", var9)
                var4.put("cipher", 1)
            } else {
                var4.put("message", var5.toString())
                var4.put("cipher", 0)
            }

            var4.put("ad_sdk_version", "1.9.2")
        } catch (var10: JSONException) {
        }

        return var4
    }

    fun getSecret(var0: String, var1: String): String? {
        try {
            val var2 = SecretKeySpec(var1.toByteArray(), "AES")
            val var3 = Cipher.getInstance("AES/ECB/PKCS5Padding")
            var3.init(1, var2)
            val var4 = var3.doFinal(var0.toByteArray(charset("utf-8")))
            return Base64.encodeToString(var4, 0)
        } catch (var6: Exception) {
            var6.printStackTrace()
            return null
        }

    }

    private fun initParam(var2: Int): JSONObject {
        val var3 = JSONObject()
        try {
            var3.put("id", "801622501")
            var3.put("adtype", var2)
            var3.put("pos", getPosition(var2))
//            this.UIUtils(var3, "accepted_size", var1.getImgAcceptedWidth(), var1.getImgAcceptedHeight())
            var3.put("is_support_dpl", true)
            var var4 = 1
            if (var4 < 1) {
                var4 = 1
            }

            if (var4 > 3) {
                var4 = 3
            }

            var3.put("ad_count", var4)
        } catch (var5: JSONException) {
        }

        return var3
    }

    fun getIp(var0: Boolean): String {
        try {
            val var1 = Collections.list(NetworkInterface.getNetworkInterfaces())
            val var2 = var1.iterator()

            while (var2.hasNext()) {
                val var3 = var2.next() as NetworkInterface
                val var4 = Collections.list(var3.inetAddresses)
                val var5 = var4.iterator()

                while (var5.hasNext()) {
                    val var6 = var5.next() as InetAddress
                    if (!var6.isLoopbackAddress) {
                        val var7 = var6 is Inet4Address
                        val var8 = var6.hostAddress.toUpperCase()
                        if (var0) {
                            if (var7) {
                                return var8
                            }
                        } else if (!var7) {
                            val var9 = var8.codePointAt(37)
                            return if (var9 < 0) var8 else var8.substring(0, var9)
                        }
                    }
                }
            }
        } catch (var10: Exception) {
        }

        return ""
    }

    //   .setAppID("5001622")
//    .setAdvertiseId("901622650")//901622650   801622501  801622501
    fun getUa(): String {
        var var0: String? = ""

        try {
            var0 = System.getProperty("http.agent")
        } catch (var5: Exception) {
            var0 = "unKnow"
        }

        val var1 = StringBuffer()
        if (var0 == null) {
            return ""
        } else {
            var var2 = 0

            val var3 = var0.length
            while (var2 < var3) {
                val var4 = var0[var2]
                if (var4.toInt() > 31 && var4.toInt() < 127) {
                    var1.append(var4)
                } else {
                    var1.append(String.format("\\u%04x", Integer.valueOf(var4.toInt())))
                }
                ++var2
            }

            return var1.toString()
        }
    }

    private fun doParams(): JSONObject {
        val var1 = JSONObject()
        try {
            var1.put("appid", "5001622")
            var1.put("name", "引力资讯-android_android")
            var1.put("package_name", this.packageName)
            var1.put("version", this.packageManager.getPackageInfo(this.packageName, 0).versionCode)
            var1.put("is_paid_app", false)
        } catch (var3: JSONException) {
        }

        return var1
    }

    @SuppressLint("MissingPermission", "WrongConstant")
    private fun getPhoneNub(): String? {
        try {
            val var1 = this.getSystemService("phone") as TelephonyManager?
            return var1!!.line1Number
        } catch (var2: Throwable) {
            return null
        }

    }

    private fun getUser(): JSONObject {
        val var1 = JSONObject()

        try {
            var1.put("gender", 1)
            var1.put("phone_nub", getPhoneNub())
//            var1.put( "keywords", com.bytedance.sdk.openadsdk.core.ImageHelper.UIUtils().ApiException())
            /* val var2 = com.bytedance.sdk.openadsdk.ImageHelper.mOnClick.UIUtils(this.UIUtils, this.PhoneUtils)
             if (var2 != null) {
                 var1.put("app_list", var2)//已经装的app  集合
             }*/

            var1.put("data", "")
        } catch (var3: JSONException) {
        }

        return var1
    }

    fun doParams(var0: Context): JSONObject {
        val var1 = JSONObject()

        try {
            var1.put("imei", Utils.d(var0))
            var1.put("android_id", Utils.c(var0))
            var1.put("uuid", Utils.e(var0))
            var1.put("ssid", Utils.g(var0))
            var1.put("wifi_mac", Utils.i(var0))
            var1.put("imsi", Utils.f(var0))
            var1.put("power_on_time", SystemClock.elapsedRealtime().toString() + "")
            var1.put("rom_version", Utils.h(var0))
            var1.put("sys_compiling_time", Utils.b(var0))
            var1.put("type", c(var0))
            var1.put("os", 1)
            var1.put("os_version", Build.VERSION.SDK_INT.toString() + "")
            var1.put("vendor", Build.MANUFACTURER)
            var1.put("model", Build.MODEL)
            var1.put("language", Locale.getDefault().language)
            var1.put("conn_type", conect(var0))
            var1.put("mac", b())
            val var2 = var0.resources.displayMetrics
            var1.put("screen_width", var2.widthPixels)
            var1.put("screen_height", var2.heightPixels)
        } catch (var3: JSONException) {
        }

        return var1
    }

    fun b(): String {
        var var0 = "" /*= UIUtils("wlan0")
        if (TextUtils.isEmpty(var0)) {
            var0 = UIUtils("eth0")
        }*/

        if (TextUtils.isEmpty(var0)) {
            var0 = "DU:MM:YA:DD:RE:SS"
        }

        return var0
    }

    @SuppressLint("WrongConstant")
    fun conect(var0: Context): Int {
        var var1: Byte = 0

        try {
            val var2 = var0.getSystemService("connectivity") as ConnectivityManager
            val var3 = var2.activeNetworkInfo
            if (var3 != null && var3.isConnected) {
                val var4 = var3.typeName
                if (var4.equals("WIFI", ignoreCase = true)) {
                    var1 = 1
                } else if (var4.equals("MOBILE", ignoreCase = true)) {
                    val var5 = var0.getSystemService("phone") as TelephonyManager
                    when (var5.networkType) {
                        0 -> {
                        }
                        1, 2, 4, 7, 11 -> var1 = 2
                        3, 5, 6, 8, 9, 10, 12, 14, 15 -> var1 = 3
                        13 -> var1 = 4
                        else -> {
                        }
                    }
                }
            } else {
                var1 = 0
            }
        } catch (var6: Throwable) {
        }

        return var1.toInt()
    }

}