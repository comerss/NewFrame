package com.liangyibang.baselibrary.base;

import android.content.Context;
import android.os.Build;
import android.os.Looper;

import com.liangyibang.baselibrary.http.Constant;
import com.liangyibang.baselibrary.http.HttpHelper;
import com.liangyibang.baselibrary.http.HttpResult;
import com.liangyibang.baselibrary.http.ICallBack;
import com.liangyibang.baselibrary.utils.ConstantsPool;
import com.liangyibang.baselibrary.utils.LogUtil;
import com.liangyibang.baselibrary.utils.SharedHelper;
import com.liangyibang.baselibrary.utils.UIUtils;
import com.liangyibang.market.base.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Comers on 2017/8/21.
 */

public class CrashHelper {
    Context mContext;
    static CrashHelper instance;

    public void init(Context context) {
        mContext = context;
        initData();
    }

    private CrashHelper() {

    }

    public static CrashHelper getDefault() {
        if (instance == null) {
            synchronized (CrashHelper.class) {
                instance = new CrashHelper();
            }
        }
        return instance;
    }

    private void initData() {
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
        UIUtils.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                //主线程异常拦截
                while (true) {
                    try {
                        Looper.loop();//主线程的异常会从这里抛出
                    } catch (final Throwable ex) {
//                        Toast.makeText(mContext, "程序异常,工程师正在努力强救中。。。", Toast.LENGTH_LONG).show();
                        UIUtils.getMainHandler().post(new Runnable() {
                            @Override
                            public void run() {
                                sendErrorToServer(ex);
                            }
                        });
                    }
                }
            }
        });
    }

    /**
     * 全局捕获异常类
     */
    class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread thread, final Throwable ex) {
            ex.printStackTrace();
            UIUtils.getMainHandler().post(new Runnable() {
                @Override
                public void run() {
                    sendErrorToServer(ex);
                }
            });
        }
    }

    private void sendErrorToServer(Throwable ex) {
        Map<String, Object> mObjectMap = new HashMap();
        StringBuffer buffer = new StringBuffer();
        buffer.append("app:" + "android")
                .append("\n")
                .append("version" + UIUtils.getVersionCode())
                .append("\n")
                .append("time:" + (new Date().getTime()))
                .append("\n")
                .append("手机制造商:" + Build.MANUFACTURER)
                .append("\n")
                .append("android版本号：" + Build.VERSION.RELEASE)
                .append("\n")
                .append("手机型号：" + Build.MODEL)
                .append("\n");

        //收集错误信息
        StringBuffer exceptionStr = new StringBuffer();
        exceptionStr.append(buffer.toString());
        exceptionStr.append("\n");
        exceptionStr.append(ex.getLocalizedMessage());
        exceptionStr.append("\n");
        exceptionStr.append(ex.getMessage());
        StackTraceElement[] elements = ex.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            exceptionStr.append(elements[i].toString());
            exceptionStr.append("\n");
        }
        mObjectMap.put("token", SharedHelper.get(ConstantsPool.TOKEN,""));
        mObjectMap.put("app", "android");
        mObjectMap.put("version", UIUtils.getVersionCode());
        mObjectMap.put("eurl", SharedHelper.get(ConstantsPool.DOCTOR_PHONE, ""));
        mObjectMap.put("eparam", buffer.toString());
        mObjectMap.put("estack", exceptionStr.toString());
        LogUtil.i("erroe",buffer.toString());
        HttpHelper.doForm(Constant.CRASH_LOG)
                .params(mObjectMap)
                .showLoading(false)
                .execute(new ICallBack<Data>() {
                    @Override
                    public void onSuccess(HttpResult<Data> sResult, String json) {

                    }
                });
    }
}
