package com.donews.frame.camera

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.*
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.donews.frame.R
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.File


/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class SplashActivity : RxBaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        setWebParam()
    }

    private fun setWebParam() {
        webview.settings.javaScriptEnabled = true
        webview.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webview.settings.setGeolocationEnabled(true)
        webview.settings.setGeolocationDatabasePath(filesDir.path)
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                if (url.startsWith(":tel") || url.startsWith(":sms")) {
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    return true
                }
                return false
            }
        }
        webview.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback) {
                callback.invoke(origin, true, false)
            }
        }
    }

    override fun initListener() {

    }

    override fun initData() {
        getAppList()
    }

    fun getAppList() {
        var list = packageManager.getInstalledApplications(0)
        list.forEach {
            Log.i("info", "------->" + it.packageName)
        }
    }

    private fun canShowWeb() {
        var canShow = true
        RxPermissions(this).requestEach(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe {
                    if (!it.granted) {
                        canShow = false
                    }
                }
        if (canShow) {
            webview.loadUrl("https://jumpluna.58.com/i/2ctjq7a1n97pnc4f21")
        }
    }

    private fun copyFile() {
        var stream = assets.open("ss.txt")
        var sourse = File(filesDir.path + File.separator + "sss.txt")
        var destination = File(filesDir.path + File.separator + "sss111.txt")
        sourse.writeBytes(stream.readBytes())
        sourse.readLines().forEach {
            destination.canWrite()
            destination.appendText("<item>$it</item>\r\n")
        }
    }

}