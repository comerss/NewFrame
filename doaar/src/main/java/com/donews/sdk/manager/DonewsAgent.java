package com.donews.sdk.manager;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.donews.sdk.base.CrashHelper;
import com.donews.sdk.base.NetStateReceiver;
import com.donews.sdk.bean.EventBean;
import com.donews.sdk.utils.AUtils;
import com.donews.sdk.utils.FileUtils;
import com.donews.sdk.utils.NetUtils;
import com.donews.sdk.utils.PhoneInfoUtils;
import com.donews.sdk.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by YJ on 2015/10/29.
 */
 public  final class DonewsAgent {
//    private static AppLaunchEntity appLaunchEntity=null;
    private static Context mContext=null;
    private static SharedPreferences spf;
    private static int count=0;
    //------------1.1注册接口-----------------------------------------------------------------------
    //此方法写在Application的onCreate()方法中，当app启动的时候调用
    public static void registDonewsSDK(final Application act, final String account) {
        mContext = act;
        NetStateReceiver netStateReceiver = new NetStateReceiver();
        IntentFilter mFilter = new IntentFilter();
        mFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        act.registerReceiver(netStateReceiver, mFilter);
        spf = act.getSharedPreferences("donews",
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = spf.edit();
        editor.putBoolean("IsRegisted", false);
        editor.commit();

        CrashHelper.INSTANCE.init();
        if (NetUtils.netstate(act) != 0) {

            String ip = (String) SPUtils.get(act, SPUtils.CUR_IP, "");
            if (!TextUtils.isEmpty(ip))
                AUtils.doRegist2Server(act,account);
        }
        //判断APP在前台还是退到后台，Android4.0以上才能用此方法判断
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                act.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    @Override
                    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

                    }

                    @Override
                    public void onActivityStarted(Activity activity) {
                        if(count<=0){
                            onAppResumeA(activity,account);
                        }
                        count++;
                    }

                    @Override
                    public void onActivityResumed(Activity activity) {
                        if(PhoneInfoUtils.classJPushExit()){
//                            JPushInterface.onResume(activity);
                        }
                    }

                    @Override
                    public void onActivityPaused(Activity activity) {
                        if(PhoneInfoUtils.classJPushExit()){
//                            JPushInterface.onPause(activity);
                        }
                    }

                    @Override
                    public void onActivityStopped(Activity activity) {
                        count--;
                        Log.e("BI ONSTOP","LLL"+count);
                        if(count==0){

                            onAppPauseA(activity,account);
                        }
                    }

                    @Override
                    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

                    }

                    @Override
                    public void onActivityDestroyed(Activity activity) {

                    }
                });
        }
    }
    //---------1.2应用启动接口----------------------------------------------------------------
    //*************************************************************************************
    //Android4.0以下用此方法计算使用时长
    public static void onAppResume(Context context,String account){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            onAppResumeA(context,account);
        }
    }
    private static String appKey,appversion,versionchannel,display,myuuid,phonemodel,providername,localip,macadress,nettype,meid,mAccount;
    private static int registerday;
    private static long starttime,shutdown;
    private static String ip;
    //统计应用使用时长
    public static void onAppResumeA(Context context,String account){
        if(context==null){
            return;
        }
        if(context instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) context)){
                return;
            }
        }
        if(!TextUtils.isEmpty((String)SPUtils.get(context,SPUtils.CUR_IP,""))) {
            AUtils.doOsUpdate(context,account);
        }
        appKey=PhoneInfoUtils.getAppKey(context);
        appversion=PhoneInfoUtils.getAppVersion(context);
        versionchannel=PhoneInfoUtils.getVersionChannel(context);
        display=PhoneInfoUtils.getDisplay(context);
        myuuid=PhoneInfoUtils.getMyUUID(context);
        phonemodel=PhoneInfoUtils.getPhoneModel(context);
        providername=PhoneInfoUtils.getPhoneModel(context);
        localip=PhoneInfoUtils.getLocalIpAddress(context);
        macadress=PhoneInfoUtils.getMacAddress(context);
//        registerday=getRegistDay(context);
        nettype=PhoneInfoUtils.getNetType(context);
        meid=PhoneInfoUtils.getMeid(context);
        mAccount=account;

        EventBean appLaunchEntity=new EventBean();
        appLaunchEntity.setAppkey(appKey);
        appLaunchEntity.setAppversion(appversion);
        appLaunchEntity.setChannel(versionchannel);
        appLaunchEntity.setLang(PhoneInfoUtils.getLang());
        appLaunchEntity.setOsversion(PhoneInfoUtils.getRelease());
        appLaunchEntity.setTimestamp(FileUtils.getCurTime());
        appLaunchEntity.setDisplay(display);
        appLaunchEntity.setSuuid(myuuid);
        appLaunchEntity.setOsType("Android");
        appLaunchEntity.setDeviceType(phonemodel);
        appLaunchEntity.setNetwork(providername);
        appLaunchEntity.setIp(localip);
        appLaunchEntity.setMac(macadress);
        appLaunchEntity.setEvent("Startup");
        appLaunchEntity.setRegister_days(registerday);
        appLaunchEntity.setNettype(nettype);
        appLaunchEntity.setDevice_id(meid);
        appLaunchEntity.setAccount(account);
        int interval=0;
//        SPUtils.put(context, SPUtils.STARTUP_TIME, System.currentTimeMillis());
//        starttime=(Long)SPUtils.get(context,SPUtils.STARTUP_TIME,0L);//本地记录的开启时间
//        shutdown=(Long)SPUtils.get(context,SPUtils.SHUTDOWN_TIME,0L);//本地记录的结束时间
        starttime=System.currentTimeMillis();
        if(shutdown==0) {
            interval = 0;
        }else {
            interval = (int) (starttime - shutdown) / 1000;
            if(interval<0) {//如果检测到数据出错，那么重新开始计算
                interval=0;
//                SPUtils.put(context, SPUtils.STARTUP_TIME, System.currentTimeMillis());
//                SPUtils.put(context,SPUtils.SHUTDOWN_TIME,0L);
                starttime=System.currentTimeMillis();
                shutdown=0L;
            }
        }
        appLaunchEntity.setUse_interval(interval);
        if(NetUtils.netstate(context)!=0){
            ip=(String)SPUtils.get(context,SPUtils.CUR_IP,"");

            if(!TextUtils.isEmpty(ip)) {
                List<EventBean> appLaunchs = new ArrayList<EventBean>();
                if ((Boolean) SPUtils.get(context, SPUtils.TAB_APPRUN, false)) {
                    appLaunchs = FileUtils.readAppRunFile(context);
                }
                if (appLaunchs == null) {
                    appLaunchs = new ArrayList<EventBean>();
                }
                appLaunchs.add(appLaunchEntity);
                AUtils.doLaunch2Server(context, appLaunchs);
            }else{
                FileUtils.saveAppRunFile(context, appLaunchEntity);
            }
        }else {
            FileUtils.saveAppRunFile(context, appLaunchEntity);
        }
    }
    public static void onAppPause(Context context,String account){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH){
            onAppPauseA(context,account);
        }
    }
    public static void onAppPauseA(Context context,String account){
        if(context==null){
            return;
        }
//        if(context instanceof Activity){
//            if(!PhoneInfoUtils.isLiving((Activity) context)){
//                return;
//            }
//        }
//        if(!TextUtils.isEmpty((String)SPUtils.get(context,SPUtils.CUR_IP,""))) {
//            AUtils.doAppUpdate(context,account);
//        }
        EventBean appLaunchEntity=new EventBean();
        appLaunchEntity.setAppkey(appKey);
        appLaunchEntity.setAppversion(appversion);
        appLaunchEntity.setChannel(versionchannel);
        appLaunchEntity.setLang(PhoneInfoUtils.getLang());
        appLaunchEntity.setOsversion(PhoneInfoUtils.getRelease());
        appLaunchEntity.setTimestamp(FileUtils.getCurTime());
        appLaunchEntity.setDisplay(display);
        appLaunchEntity.setSuuid(myuuid);
        appLaunchEntity.setOsType("Android");
        appLaunchEntity.setDevice_id(meid);
        appLaunchEntity.setAccount(mAccount);
        appLaunchEntity.setDeviceType(phonemodel);
        appLaunchEntity.setNetwork(providername);
        appLaunchEntity.setIp(localip);
        appLaunchEntity.setMac(macadress);
        appLaunchEntity.setEvent("Shutdown");
//        SPUtils.put(context,SPUtils.SHUTDOWN_TIME,System.currentTimeMillis());
        shutdown=System.currentTimeMillis();
//        long shutdown=(Long)SPUtils.get(context,SPUtils.SHUTDOWN_TIME,0L);
//        long startup=(Long)SPUtils.get(context,SPUtils.STARTUP_TIME,0L);
        int interval=0;
        interval=(int)(shutdown-starttime)/1000;
        if(interval<0) {
            interval=0;
        }
        appLaunchEntity.setUse_duration(interval);
        appLaunchEntity.setRegister_days(registerday);

            if(NetUtils.netstate(context)!=0) {
                String ip = (String) SPUtils.get(context, SPUtils.CUR_IP, "");
                if (!TextUtils.isEmpty(ip)){
                    List<EventBean> appLaunchs = new ArrayList<EventBean>();
                    if ((Boolean) SPUtils.get(context, SPUtils.TAB_SHUNDOWN, false)) {
                        appLaunchs = FileUtils.readShutdownFile(context);
                    }
                    if (appLaunchs == null) {
                        appLaunchs = new ArrayList<EventBean>();
                    }
                    appLaunchs.add(appLaunchEntity);
                    AUtils.doShutDown2Server(context, appLaunchs);
                }else {
                    FileUtils.saveShutdownFile(context, appLaunchEntity);
                }
            }else {
                FileUtils.saveShutdownFile(context, appLaunchEntity);
            }

    }
    //------------1.3页面访问接口上报-------------------------------------------------------------------
    //***********************************************************************************************
    public static void onPageAccess(Context act,String pageName,String lastPageName,int pageNum,String account){//在activity的onResume()方法里调用
        if(act==null){
            return;
        }
        if(act instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) act)){
                return;
            }
        }
        EventBean pageEntity=null;
        if(!TextUtils.isEmpty(pageName)) {
            pageEntity = new EventBean();
            pageEntity.setAppkey(PhoneInfoUtils.getAppKey(act));
            pageEntity.setAppversion(PhoneInfoUtils.getAppVersion(act));
            pageEntity.setChannel(PhoneInfoUtils.getVersionChannel(act));
            pageEntity.setLang(PhoneInfoUtils.getLang());
            pageEntity.setOsversion(PhoneInfoUtils.getRelease());
            pageEntity.setTimestamp(FileUtils.getCurTime());
            pageEntity.setLastpage(lastPageName);
            pageEntity.setPagename(pageName);
            pageEntity.setPagenum(pageNum);
            pageEntity.setDisplay(PhoneInfoUtils.getDisplay(act));
            pageEntity.setDeviceType(PhoneInfoUtils.getPhoneModel(act));
            pageEntity.setOsType("Android");
            pageEntity.setNetwork(PhoneInfoUtils.getProvidersName(act));
            pageEntity.setEvent("PageView");
            pageEntity.setSuuid(PhoneInfoUtils.getMyUUID(act));
            pageEntity.setIp(PhoneInfoUtils.getLocalIpAddress(act));
            pageEntity.setMac(PhoneInfoUtils.getMacAddress(act));
//            pageEntity.setRegister_days(getRegistDay(act));
            pageEntity.setNettype(PhoneInfoUtils.getNetType(act));
            pageEntity.setDevice_id(PhoneInfoUtils.getMeid(act));
            pageEntity.setAccount(account);
        }

        if(NetUtils.netstate(act)!=0){
            if(!TextUtils.isEmpty((String)SPUtils.get(act,SPUtils.CUR_IP,""))) {
                List<EventBean> pageAccess = new ArrayList<EventBean>();
                if ((Boolean) SPUtils.get(act, SPUtils.TAB_PAGEACCESS, false)) {
                    pageAccess = FileUtils.readPageFile(act);
                }
                if (pageAccess == null) {
                    pageAccess = new ArrayList<EventBean>();
                }
                if (pageEntity != null) {
                    pageAccess.add(pageEntity);
                }
                if (pageAccess.size() > 0)
                    AUtils.doAccess2Server(act, pageAccess);
            }else{
                if(pageEntity!=null) {
                    FileUtils.savePageFile(act, pageEntity);
                }
            }
        }else {
            if(pageEntity!=null) {
                FileUtils.savePageFile(act, pageEntity);
            }
        }
    }
    //------------1.4事件回调接口上报-------------------------------------------------------------------
    //***********************************************************************************************
    public static void onEvents(Context c,String eventname,String account) {
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        EventBean eventEntity = null;
        if (!TextUtils.isEmpty(eventname)){
            eventEntity=new EventBean();
            eventEntity.setAppkey(PhoneInfoUtils.getAppKey(c));
            eventEntity.setAppversion(PhoneInfoUtils.getAppVersion(c));
            eventEntity.setChannel(PhoneInfoUtils.getVersionChannel(c));
            eventEntity.setLang(PhoneInfoUtils.getLang());
            eventEntity.setTimestamp(FileUtils.getCurTime());
            eventEntity.setEvent("ExEvent");
            eventEntity.setEventname(eventname);
            eventEntity.setOsversion(PhoneInfoUtils.getRelease());
            eventEntity.setDisplay(PhoneInfoUtils.getDisplay(c));
            eventEntity.setSuuid(PhoneInfoUtils.getMyUUID(c));
            eventEntity.setNetwork(PhoneInfoUtils.getProvidersName(c));
            eventEntity.setDeviceType(PhoneInfoUtils.getPhoneModel(c));
            eventEntity.setOsType("Android");
            eventEntity.setIp(PhoneInfoUtils.getLocalIpAddress(c));
            eventEntity.setMac(PhoneInfoUtils.getMacAddress(c));
//            eventEntity.setRegister_days(getRegistDay(isScreenOn));
            eventEntity.setNettype(PhoneInfoUtils.getNetType(c));
            eventEntity.setDevice_id(PhoneInfoUtils.getMeid(c));
            eventEntity.setAccount(account);
        }

        if(NetUtils.netstate(c)!=0){
            if(!TextUtils.isEmpty((String)SPUtils.get(c,SPUtils.CUR_IP,""))) {
                List<EventBean> events = new ArrayList<EventBean>();
                if ((Boolean) SPUtils.get(c, SPUtils.TAB_EVENTS, false)) {
                    events = FileUtils.readEventFile(c);
                }
                if (events == null) {
                    events = new ArrayList<EventBean>();
                }
                if (eventEntity != null) {
                    events.add(eventEntity);
                }
                if (events.size() > 0)
                    AUtils.doEvent2Server(c, events);
            }else{
                if(eventEntity!=null) {
                    FileUtils.saveEventFile(c, eventEntity);
                }
            }
        }else {
            if(eventEntity!=null) {
                FileUtils.saveEventFile(c, eventEntity);
            }
        }
    }


    //------------1.7错误日志信息接口上报-------------------------------------------------------------------
    //***********************************************************************************************
    public static void onError(Context c,String error_type,String account) {
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        EventBean eventEntity = null;
        if (!TextUtils.isEmpty(error_type)){
            eventEntity=new EventBean();
            eventEntity.setAppkey(PhoneInfoUtils.getAppKey(c));
            eventEntity.setAppversion(PhoneInfoUtils.getAppVersion(c));
            eventEntity.setChannel(PhoneInfoUtils.getVersionChannel(c));
            eventEntity.setLang(PhoneInfoUtils.getLang());
            eventEntity.setTimestamp(FileUtils.getCurTime());
            eventEntity.setEvent("Error");
            eventEntity.setError_type(error_type);
            eventEntity.setOsversion(PhoneInfoUtils.getRelease());
            eventEntity.setDisplay(PhoneInfoUtils.getDisplay(c));
            eventEntity.setSuuid(PhoneInfoUtils.getMyUUID(c));
            eventEntity.setNetwork(PhoneInfoUtils.getProvidersName(c));
            eventEntity.setDeviceType(PhoneInfoUtils.getPhoneModel(c));
            eventEntity.setOsType("Android");
            eventEntity.setIp(PhoneInfoUtils.getLocalIpAddress(c));
            eventEntity.setMac(PhoneInfoUtils.getMacAddress(c));
//            eventEntity.setRegister_days(getRegistDay(isScreenOn));
            eventEntity.setNettype(PhoneInfoUtils.getNetType(c));
            eventEntity.setAccount(account);
            eventEntity.setDevice_id(PhoneInfoUtils.getMeid(c));
        }

        if(NetUtils.netstate(c)!=0){
            if(!TextUtils.isEmpty((String)SPUtils.get(c,SPUtils.CUR_IP,""))) {
                List<EventBean> events = new ArrayList<EventBean>();
                if ((Boolean) SPUtils.get(c, SPUtils.TAB_ERROR, false)) {
                    events = FileUtils.readErrorFile(c);
                }
                if (events == null) {
                    events = new ArrayList<EventBean>();
                }
                if (eventEntity != null) {
                    events.add(eventEntity);
                }
                if (events.size() > 0) {
                    AUtils.doError2Server(c, events);
                }
            }else{
                if(eventEntity!=null) {
                    FileUtils.saveErrorFile(c, eventEntity);
                }
            }
        }else {
            if(eventEntity!=null) {
                FileUtils.saveErrorFile(c, eventEntity);
            }
        }
    }

}
