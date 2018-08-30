package com.donews.frame.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.comers.baselibrary.base.GlobalApplication;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Created by 79653 on 2018/7/5.
 * 描述：
 */
public class DoApplication extends GlobalApplication {
    static TTAdManager manager;

    @Override
    public void onCreate() {
        super.onCreate();
        manager = TTAdManagerFactory.getInstance(this)
                .setAppId("5001622")//申请到的应用ID
                .setName("引力资讯-android_android")
                .setTitleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
                .setAllowShowNotifiFromSDK(true)
                .setAllowLandingPageShowWhenScreenLock(true)
                .setDirectDownloadNetworkType(TTAdConstant.NETWORK_STATE_WIFI, TTAdConstant.NETWORK_STATE_3G);
//        BaiduManager.init(this);
//        AdView.setAppSid(this, "b792a33a");
//        AdSettings.setSupportHttps(true);
//        SophixManager.getInstance().queryAndLoadNewPatch();

    }

    public static TTAdManager getManage() {
        return manager;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        initAli(base);
    }

    private void initAli(Context base) {
        SophixManager.getInstance().setContext(this)
                .setAppVersion(getAppVersion(base))
                .setSecretMetaData("249891-1","99077949b406f7bef242cd0ee0e",
                        "MIIBADANBgkqhkiG9w0BQEFAASCBKgwgAgEAAoIBAQc6znQ1inKa35IcF5zgxVEbI78p3m1eVgWmT5DuKjXJMqWw5/v4eGhGoYZ4SbUgdu4z6o6sXctiaWIQNvKsDHVJZKCW7CYxgIkXLeqSYJYmZ5QzQt3uVhleZxKnFIQ4lmFbrJk6T+6bvdFFdzQkGK4c9MH6tKFlWaOAOPFk9terLRfUn4Cg6f2HmCBc6hy1So5cacacvLHogIDwGcEBk1KbbhIHdCIjELKGqUTnylgTI911dwwCOhQdGWe9OffPN7DLeF0rTYqj2P4Y6zX4iRvRs9dM64hkNrBHemD6oPuu2gIYGaovpGfqDkwNAgMBAAECggEAGuBRcRzVpO3ahQBq8NZCe5hjWDjDxd0zYLDeKVS1ZOcUQMuK1Pi4wVzoGRsoGmVxpsD1hLBj/CxXe7fx9UL8U2UwUPIIhIik6BQkOptZvEEHXC1Ku1fAk4vZCyOI/xYvcgBsZCN/GXJCQJg0lvYaKXoWST3vNEavwLR6OgTimajptISv3zjPpGXNJqUjEZSv4vgpBvakh+8Uv28D6UaaVDxi7XtNCWJNRQjBO142KMsDAWXNzE42Mp0scrhTzrAq4YX8BMU4Ryo2BUCt1HQwo4sJ1ucCWMTb95DOoUoRCIuGFTYIr221ew83auzuEVAe3K3fsO0hOdRW2YfqR4wqFQKBgQDUH5cIqdiC6ENYu7Zzibne6sYMjH/qDNXNW7tq2XMI5tHNlVUp7PF5L92atODWLEI3rbDg+OJxiLbJSbA2jIcbRqqHmGy6vsSyAx7rfxm6rwxFtuWjXh9/1XwW/setAutoCancel+6la6qW9m1k+ixv8VYVN2GSBh0RxRHU7TlNwr8H4GyuyItuwKBgQCg58zh99+sjXGzE6rJ+6fVgIa28fV8tuDryQhzPmwFowmeF4ZY+Eo6kG3hYxwts14UkYxiIW5WW+kZ1akkClVx0VHHeTMEUmNEZpHnd2rLbPEw2KXlNAEWm5Uk7zKVkNQ0Apwtug5A9L+rg1s80/3zgcD6huJVgHeszlVJlr1s1wKBgQCaxo4CgUN8iRKSzSyccxLPR4jIoT+4PDNIizVeCln4Vcsh8WNZmwy6eyV7+5zOSS7rx213ScKYSsPsbTsJIlJ2oYJOO/ah8A4/QS2vcWcJoy4WNBSstkHPmarYb8AU2aC/pxNcfRbdk2rgP9P/Zd2KAk8WmEo2sYnvWuHc0tRmfwKBgGLj06GVS9yq2ZQrpC2bAt1OrnzFXBCX/Mgst4rMdGtKdmC5KJKJlmVD2qRI20qjEFEn2tV8omlk93AvRlKmHzliYhZsQJSJZgTl3Qoa9IGtpNZWcC7btUeFuzYF5FrTtfd5Gy9nR9dYFGx+wJYz28HKnyXZvES8PdDwxq4BfM3lAoGBAJ6qi/A8CQhdI+Pa9KfugeKwB0Ql4LJnOAKrr5KPUgbHLYEkQZjLtEAdJGj8oIxRxYGXjTbI8BAm9CXhf/WW1KVuDsH0V49sb/MUXlmNOX7wrggfNdpuGMrnsGD7Z0lUu/CTCzW6qnS1+YYxwHBh901PLr4KVEZBr5P/lEf9Bh7E"
                        )
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                            Log.i("Sophix","表明补丁加载成功");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁，详见1.3.2.3
                            Log.i("Sophix","表明新补丁生效需要重启. 开发者可提示用户或者强制重启");
                            SophixManager.getInstance().killProcessSafely();

                        } else {
                            Log.i("Sophix"," 其它错误信息, 查看PatchStatus类说明"+code);
                            // 其它错误信息, 查看PatchStatus类说明
                        }
                    }
                }).initialize();
// queryAndLoadNewPatch不可放在attachBaseContext 中，否则无网络权限，建议放在后面任意时刻，如onCreate中
    }

    public String getAppVersion(Context base) {
        PackageManager packageManager = base.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(base.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageManager != null) {
            return packInfo.versionName;
        } else {
            return "";
        }
    }
}
