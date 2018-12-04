package com.comers.shenwu.camera

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Handler
import android.util.Log
import android.webkit.*
import com.comers.annotation.MainThread
import com.comers.baselibrary.base.LogUtils
import com.comers.baselibrary.retrofit.RxBaseActivity
import com.comers.shenwu.R
import kotlinx.android.synthetic.main.activity_splash.*
import java.lang.reflect.Modifier

/**
 * Created by 79653 on 2018/7/16.
 * 描述：
 */
class SplashActivity : RxBaseActivity() {
    var mHandler = Handler()
    var task = object : Runnable {
        override fun run() {
            checkVisible()
            mHandler.postDelayed(this, 1000)
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
//        setWebParam()
        mHandler.postDelayed(task,1000)
        tvShowCheck.setOnClickListener {
            toActivity(HomeActivity::class.java)
        }
    }

    private fun checkVisible() {
        LogUtils.i("可见否",tvShowCheck.visibility.toString())
    }

    private fun setWebParam() {

        webview.settings.javaScriptEnabled = true
        webview.settings.setAppCacheEnabled(true)
        webview.settings.cacheMode = WebSettings.LOAD_DEFAULT
        webview.settings.domStorageEnabled = true
        webview.settings.databaseEnabled = true
//        webview.settings.safeBrowsingEnabled=true
        webview.settings.allowFileAccess = true
        webview.settings.allowContentAccess = true
        webview.settings.setGeolocationDatabasePath(applicationContext.getDir("database", Context.MODE_PRIVATE).path)
        webview.settings.setAppCachePath(applicationContext.getDir("database", Context.MODE_PRIVATE).path)
        webview.settings.javaScriptCanOpenWindowsAutomatically = true

        webview.settings.setGeolocationEnabled(true)
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                if (url.startsWith(":tel") || url.startsWith(":sms")) {
                    var intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(intent)
                    return true
                }
                return false
            }

            override fun onPageFinished(view: WebView, url: String?) {
                super.onPageFinished(view, url)
                /*var js="document.getElementById(\"supernatant\").style.display=\"none\""
                view.loadUrl("javascript:$js")*/
            }
        }
        webview.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(origin: String?, callback: GeolocationPermissions.Callback) {
                callback.invoke(origin, true, false)
                super.onGeolocationPermissionsShowPrompt(origin, callback)
            }
        }
    }

    override fun initListener() {

    }

    override fun initData() {
//        getInMobiAd()
        processAnnotation()

    }

    private val BRIDGE = 0x40
    private val SYNTHETIC = 0x1000
    private val MODIFIERS_IGNORE = Modifier.ABSTRACT or Modifier.STATIC or BRIDGE or SYNTHETIC
    fun processAnnotation() {
        var list = javaClass.declaredMethods
        list.forEach {
            if (it.modifiers and Modifier.PUBLIC != 0 && it.modifiers and MODIFIERS_IGNORE == 0) {
                var main = it.getAnnotation(MainThread::class.java)
                if (main != null && main.isMainThread) {
                    it.invoke(SplashActivity@ this)
                }
            }
        }
        toActivity(HomeActivity::class.java)
    }

    @MainThread(isMainThread = true)
    fun getAppList() {
        var list = packageManager.getInstalledApplications(0)
        list.forEach {
            Log.i("info", "------->" + it.packageName)
        }
    }


}


