package com.comers.shenwu.sdk;

import android.content.Context;

import com.comers.baselibrary.base.GlobalApplication;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.internal.HeapAnalyzerService;

/**
 * Created by 79653 on 2018/7/5.
 * 描述：
 */
public class DoApplication extends GlobalApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

}
