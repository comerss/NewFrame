package com.donews.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.donews.sdk.base.JsonParseHelper;
import com.donews.sdk.bean.EventBean;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YJ on 2016/5/13.
 */
public class AUtils {
//    public static final String URL_SERVER="http://c.tagtic.cn/minfo/";
    public static final String URL_SERVER="http://log.tagtic.cn/mininfo/v1/logs/";
//    public static final String URL_SERVER_REGISTER=URL_SERVER+"reg";
//    public static final String URL_SERVER_REGISTER=URL_SERVER+"v1/logs/$"+PhoneInfoUtils.getAppKey();
//public static final String URL_SERVER_REGISTER="http://101.200.186.240:4062";
    public static final String URL_SERVER_APPRUN=URL_SERVER+"startup";
    public static final String URL_SERVER_PAGEACCESS=URL_SERVER+"page";
    public static final String URL_SERVER_EVENT=URL_SERVER+"user_event";

    public static final String URL_GETIP="http://log.tagtic.cn/mininfo/v1/ip";

    public static String getURL(Context context){
        return URL_SERVER+PhoneInfoUtils.getAppKey(context);
    }
    /**
     * 将map数据转换成json格式
     * @param map
     * @return
     */
    public static String map2json(Map<String, Object> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                String value=map.get(key).toString();
                if(TextUtils.isEmpty(value)){
                    continue;
                }
                json.append("\"" + key + "\"");
                json.append(":");
                if(key.equals("register_days")|| key.equals("use_duration")||key.equals("use_interval")||key.equals("money")){
                    json.append( map.get(key) );
                }else {
                    json.append("\"" + map.get(key) + "\"");
                }
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    public static String map2json3(Map<String, String> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                if(key.equals("data")){
                    String result=map.get(key);
                    result=result.replace("},", "}\n");
                    result=result.substring(1, result.length() - 1);
                    return  result;
                }
                json.append("\"" + key + "\"");
                json.append(":");
                if(key.equals("register_days")){
                    json.append(map.get(key));
                }else {
                    json.append("\"" + map.get(key) + "\"");
                }
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * 将list数据转化成json格式
     * @param list
     * @return
     */
    public static String list2json(List<Map<String,Object>> list) {
        StringBuilder json=new StringBuilder();
        json.append("[");
        for(int i=0;i<list.size();i++){
            Map<String,Object> map=list.get(i);
            json.append(JsonParseHelper.parse(map));
            json.append(",");
        }
        json.setCharAt(json.length() - 1, ']');
        return json.toString();
    }
    private static Map<String,Object> getPara(Context c,String account){
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        Map<String, Object> mMaps = new HashMap<String, Object>();
        mMaps.put("appkey", PhoneInfoUtils.getAppKey(c));
        mMaps.put("app_version", PhoneInfoUtils.getAppVersion(c));
        mMaps.put("os_type", "Android");
        mMaps.put("device_type", PhoneInfoUtils.getPhoneModel(c));
        mMaps.put("os_version", PhoneInfoUtils.getRelease());
        mMaps.put("display", PhoneInfoUtils.getDisplay(c));
        mMaps.put("lang", PhoneInfoUtils.getLang());
        mMaps.put("network", PhoneInfoUtils.getProvidersName(c));
        mMaps.put("suuid", PhoneInfoUtils.getMyUUID(c));
        mMaps.put("channel", PhoneInfoUtils.getVersionChannel(c));
        mMaps.put("timestamp",FileUtils.getCurTime());
        mMaps.put("ip",PhoneInfoUtils.getLocalIpAddress(c));
        mMaps.put("mac",PhoneInfoUtils.getMacAddress(c));
        mMaps.put("nettype",PhoneInfoUtils.getNetType(c));
        mMaps.put("device_id",PhoneInfoUtils.getMeid(c));
        mMaps.put("account",account);
        return mMaps;
    }
    //------------------1.1应用注册接口-----------------------------------------------------
    //************************************************************************************
    private static Map<String, Object> getRegistPara(Context c,String account) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        Map<String, Object> map = new HashMap<>();
        map=getPara(c,account);
        map.put("register_days", "0");
        map.put("event", "Register");
        return map;
    }

    /**
     *客户端注册数据
     * @param activity
     */
    public static void doRegist2Server(final Context activity,String account){
        if(activity==null){
            return;
        }
        if(activity instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) activity)){
                return;
            }
        }
        SPUtils.put(activity,SPUtils.REGIST_TIME,(long)System.currentTimeMillis());
        final Map<String,Object> registPara=getRegistPara(activity,account);
        HttpUtils.startHttpPost(getURL(activity), registPara, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {
                    if (!TextUtils.isEmpty(jsonStr)) {
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            SharedPreferences spf = activity.getSharedPreferences("donews",
                                    Activity.MODE_PRIVATE);
                            SharedPreferences.Editor editor = spf.edit();
                            editor.putBoolean("IsRegisted", true);
                            editor.commit();
                        }

                    }
                }
            }
        });
    }
    //--------------1.2应用启动接口-------------------------------------------------------------------
    //**********************************************************************************************
    private static Map<String, Object> getLaunchPara(Context c,List<EventBean> appLaunchs) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<appLaunchs.size();i++){
            EventBean appLaunch=appLaunchs.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", appLaunch.getAppkey());
            data.put("app_version", appLaunch.getAppversion());
            data.put("os_version", appLaunch.getOsversion());
            data.put("lang", appLaunch.getLang());
            data.put("timestamp",appLaunch.getTimestamp());
            data.put("device_id",appLaunch.getDevice_id());
            data.put("account",appLaunch.getAccount());
//            data.put("starttime", appLaunch.getStarttime()+"");
//            data.put("endtime", appLaunch.getEndtime()+"");
            data.put("channel", appLaunch.getChannel());
            data.put("display",PhoneInfoUtils.getDisplay(c));
            data.put("suuid",appLaunch.getSuuid());
            data.put("network",appLaunch.getNetwork());
            data.put("device_type", appLaunch.getDeviceType());
            data.put("os_type","Android");
            if(TextUtils.isEmpty(appLaunch.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", appLaunch.getIp());
            }
            data.put("mac",appLaunch.getMac());
            data.put("event","Startup");
            data.put("register_days",appLaunch.getRegister_days()+"");
            data.put("use_interval",appLaunch.getUse_interval()+"");
            data.put("nettype",appLaunch.getNettype());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doLaunch2Server(final Context c, final List<EventBean> appLaunchs){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getLaunchPara(c, appLaunchs), new HttpUtils
                .HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("apprun.dn");
                            SPUtils.put(c, SPUtils.TAB_APPRUN, false);
                        } else {
                            FileUtils.saveAppRunFile(c, appLaunchs.get(appLaunchs.size() - 1));
                        }
                    } else {
                        FileUtils.saveAppRunFile(c, appLaunchs.get(appLaunchs.size() - 1));
                    }
                } else {
                    FileUtils.saveAppRunFile(c, appLaunchs.get(appLaunchs.size() - 1));
                }
            }
        });
    }
    private static Map<String, Object> getShundownPara(Context c,List<EventBean> appLaunchs) {
        if(c==null){
            return null;
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<appLaunchs.size();i++){
            EventBean appLaunch=appLaunchs.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", appLaunch.getAppkey());
            data.put("app_version", appLaunch.getAppversion());
            data.put("os_version", appLaunch.getOsversion());
            data.put("lang", appLaunch.getLang());
            data.put("timestamp",appLaunch.getTimestamp());
            data.put("device_id",appLaunch.getDevice_id());
            data.put("account",appLaunch.getAccount());
//            data.put("starttime", appLaunch.getStarttime()+"");
//            data.put("endtime", appLaunch.getEndtime()+"");
            data.put("channel", appLaunch.getChannel());
            data.put("display",PhoneInfoUtils.getDisplay(c));
            data.put("suuid",appLaunch.getSuuid());
            data.put("network",appLaunch.getNetwork());
            data.put("device_type",appLaunch.getDeviceType());
            data.put("os_type","Android");
            if(TextUtils.isEmpty(appLaunch.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", appLaunch.getIp());
            }
            data.put("mac",appLaunch.getMac());
            data.put("event","Shutdown");
            data.put("register_days",appLaunch.getRegister_days()+"");
            data.put("use_duration",appLaunch.getUse_duration()+"");
            data.put("nettype",appLaunch.getNettype());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }
    public static void doShutDown2Server(final Context c, final List<EventBean> appLaunchs){
        if(c==null){
            return;
        }
        Log.e("shutdown","LLL"+getShundownPara(c,appLaunchs).toString());
        HttpUtils.startHttpPost(getURL(c), getShundownPara(c, appLaunchs), new HttpUtils
                .HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                Log.e("BI SHUTDOWN", "LLL" +url+","+isResult+","+ jsonStr);
                if (isResult) {
//                    if (MyApp.DEBUG) {
                        Log.e("BI SHUTDOWN", "LLL" + jsonStr);
//                    }
                    if (!TextUtils.isEmpty(jsonStr)) {
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("shutdown.dn");
                            SPUtils.put(c, SPUtils.TAB_SHUNDOWN, false);
                        } else {
                            FileUtils.saveShutdownFile(c, appLaunchs.get(appLaunchs.size() - 1));
                        }
                    } else {
                        FileUtils.saveShutdownFile(c, appLaunchs.get(appLaunchs.size() - 1));
                    }
                } else {
                    FileUtils.saveShutdownFile(c, appLaunchs.get(appLaunchs.size() - 1));
                }
            }
        });
    }
    //--------------1.3页面访问接口------------------------------------------------------------------
    //*********************************************************************************************
    private static Map<String, Object> getAccessPara(Context c,List<EventBean> entities) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<entities.size();i++){
            EventBean entity=entities.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", entity.getAppkey());
            data.put("app_version", entity.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", entity.getDeviceType());
            data.put("os_version", entity.getOsversion());
            data.put("display", entity.getDisplay());
            data.put("lang", entity.getLang());
            data.put("network", entity.getNetwork());
            data.put("suuid", entity.getSuuid());
            data.put("channel", entity.getChannel());
            data.put("timestamp",entity.getTimestamp());
            if(TextUtils.isEmpty(entity.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", entity.getIp());
            }
            data.put("mac",entity.getMac());
            data.put("register_days",entity.getRegister_days()+"");
            data.put("event","PageView");
            data.put("page_name", entity.getPagename());
            data.put("last_page_name", entity.getLastpage());
            data.put("page_num",entity.getPagenum()+"");
            data.put("nettype",entity.getNettype());
            data.put("device_id",entity.getDevice_id());
            data.put("account",entity.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doAccess2Server(final Context c, final List<EventBean> entities){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getAccessPara(c, entities), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("pageaccess.dn");
                            SPUtils.put(c, SPUtils.TAB_PAGEACCESS, false);
                        } else {
                            FileUtils.savePageFile(c, entities.get(entities.size() - 1));
                        }
                    } else {
                        FileUtils.savePageFile(c, entities.get(entities.size() - 1));
                    }
                } else {
                    FileUtils.savePageFile(c, entities.get(entities.size() - 1));
                }
            }
        });
    }
    //-------------1.4事件回调接口------------------------------------------------------------------------
    //*************************************************************************************************
    private static Map<String, Object> getEventPara(Context c,List<EventBean> events) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<events.size();i++){
            EventBean event=events.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", event.getAppkey());
            data.put("app_version", event.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", event.getDeviceType());
            data.put("os_version", event.getOsversion());
            data.put("display", event.getDisplay());
            data.put("lang", event.getLang());
            data.put("network", event.getNetwork());
            data.put("suuid", event.getSuuid());
            data.put("channel", event.getChannel());
            data.put("timestamp",event.getTimestamp());
            if(TextUtils.isEmpty(event.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", event.getIp());
            }
            data.put("mac",event.getMac());
            data.put("event",event.getEvent());
            data.put("event_name",event.getEventname());
            data.put("register_days",event.getRegister_days()+"");
            data.put("nettype",event.getNettype());
            data.put("device_id",event.getDevice_id());
            data.put("account",event.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doEvent2Server(final Context c, final List<EventBean> events){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getEventPara(c, events), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
//
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("events.dn");
                            SPUtils.put(c, SPUtils.TAB_EVENTS, false);
                        } else {
                            FileUtils.saveEventFile(c, events.get(events.size() - 1));
                        }
                    } else {
                        FileUtils.saveEventFile(c, events.get(events.size() - 1));
                    }
                } else {
                    FileUtils.saveEventFile(c, events.get(events.size() - 1));
                }
            }
        });
    }
    //--------------1.5 app是否更新----------------------------------------------------
    private static Map<String, Object> getAppUpdatePara(Context c,String oldAppVersion,String account) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map=getPara(c,account);
        map.put("app_upgrade_from",oldAppVersion);
        map.put("event", "AppUpgrade");
        return map;
    }
    public static void doAppUpdate(final Context context,String account){
        if(context==null){
            return;
        }
        if(context instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) context)){
                return;
            }
        }
        final String curVersion=PhoneInfoUtils.getAppVersion(context);
        String oldVersion=(String)SPUtils.get(context,SPUtils.APP_VERSION,"");
        if(!TextUtils.isEmpty(curVersion)){
            if(!curVersion.equals(oldVersion)){
                HttpUtils.startHttpPost(getURL(context), getAppUpdatePara(context, oldVersion,account), new HttpUtils.HttpResultCallback() {
                    @Override
                    public void result(String url, boolean isResult, String jsonStr) {
                        if(isResult){

                            if(!TextUtils.isEmpty(jsonStr)){
                                JSONObject result = JSONParser.getJSONObject(jsonStr);
                                int code = JSONParser.getInt(result, "code");
                                if (code == 0) {
                                    SPUtils.put(context,SPUtils.APP_VERSION,curVersion);
                                }
                            }
                        }
                    }
                });
            }
        }else{
            SPUtils.put(context, SPUtils.APP_VERSION, curVersion);
        }
    }
    //--------操作系统是否更新-----------------------------------------
    private static Map<String, Object> getOsUpdatePara(Context c,String oldOsVersion,String account) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map=getPara(c,account);
        map.put("os_upgrade_from",oldOsVersion);
        map.put("event", "OSUpgrade");
        return map;
    }
    public static void doOsUpdate(final Context context,String account){
        if(context==null){
            return;
        }
        if(context instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) context)){
                return;
            }
        }
        final String curVersion=PhoneInfoUtils.getRelease();
        String oldVersion=(String)SPUtils.get(context,SPUtils.OS_VERSION,"");
        if(!TextUtils.isEmpty(curVersion)){
            if(!curVersion.equals(oldVersion)){
                HttpUtils.startHttpPost(getURL(context), getOsUpdatePara(context, oldVersion,account), new HttpUtils.HttpResultCallback() {
                    @Override
                    public void result(String url, boolean isResult, String jsonStr) {
                        if(isResult){
                            if(!TextUtils.isEmpty(jsonStr)){
                                JSONObject result = JSONParser.getJSONObject(jsonStr);
                                int code = JSONParser.getInt(result, "code");
                                if (code == 0) {
                                    SPUtils.put(context,SPUtils.OS_VERSION,curVersion);
                                }
                            }
                        }
                    }
                });
            }
        }else{
            SPUtils.put(context, SPUtils.OS_VERSION, curVersion);
        }
    }
    //========充值===============================================
    private static Map<String, Object> getRechargePara(Context c,List<EventBean> rechargeEntities) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<rechargeEntities.size();i++){
            EventBean recharge=rechargeEntities.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", recharge.getAppkey());
            data.put("app_version", recharge.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", recharge.getDeviceType());
            data.put("os_version", recharge.getOsversion());
            data.put("display", recharge.getDisplay());
            data.put("lang", recharge.getLang());
            data.put("network", recharge.getNetwork());
            data.put("suuid", recharge.getSuuid());
            data.put("channel", recharge.getChannel());
            data.put("timestamp",recharge.getTimestamp());
            if(TextUtils.isEmpty(recharge.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", recharge.getIp());
            }
            data.put("mac",recharge.getMac());
            data.put("event","Recharge");
            data.put("payment_method",recharge.getPayment_method());
            data.put("money",recharge.getMoney()+"");
            data.put("register_days",recharge.getRegister_days()+"");
            data.put("nettype",recharge.getNettype());
            data.put("device_id",recharge.getDevice_id());
            data.put("account",recharge.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doRecharge2Server(final Context c, final List<EventBean> rechargeEntities){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getRechargePara(c, rechargeEntities), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("recharge.dn");
                            SPUtils.put(c, SPUtils.TAB_RECHARGE, false);
                        } else {
                            FileUtils.saveRechargeFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                        }
                    } else {
                        FileUtils.saveRechargeFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                    }
                } else {
                    FileUtils.saveRechargeFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                }
            }
        });
    }
    //========消费===============================================
    private static Map<String, Object> getConsumPara(Context c,List<EventBean> rechargeEntities) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<rechargeEntities.size();i++){
            EventBean recharge=rechargeEntities.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", recharge.getAppkey());
            data.put("app_version", recharge.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", recharge.getDeviceType());
            data.put("os_version", recharge.getOsversion());
            data.put("display", recharge.getDisplay());
            data.put("lang", recharge.getLang());
            data.put("network", recharge.getNetwork());
            data.put("suuid", recharge.getSuuid());
            data.put("channel", recharge.getChannel());
            data.put("timestamp",recharge.getTimestamp());
            if(TextUtils.isEmpty(recharge.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", recharge.getIp());
            }
            data.put("mac",recharge.getMac());
            data.put("event","Consumption");
            data.put("consumption_point",recharge.getConsumption_point());
            data.put("money",recharge.getMoney()+"");
            data.put("register_days",recharge.getRegister_days()+"");
            data.put("nettype",recharge.getNettype());
            data.put("device_id",recharge.getDevice_id());
            data.put("account",recharge.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doConsum2Server(final Context c, final List<EventBean> rechargeEntities){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getConsumPara(c, rechargeEntities), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
//
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("consumption.dn");
                            SPUtils.put(c, SPUtils.TAB_CONSUMPTION, false);
                        } else {
                            FileUtils.saveConsumFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                        }
                    } else {
                        FileUtils.saveConsumFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                    }
                } else {
                    FileUtils.saveConsumFile(c, rechargeEntities.get(rechargeEntities.size() - 1));
                }
            }
        });
    }
    //========错误===============================================
    private static Map<String, Object> getErrorPara(Context c,List<EventBean> errors) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<errors.size();i++){
            EventBean recharge=errors.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", recharge.getAppkey());
            data.put("app_version", recharge.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", recharge.getDeviceType());
            data.put("os_version", recharge.getOsversion());
            data.put("display", recharge.getDisplay());
            data.put("lang", recharge.getLang());
            data.put("network", recharge.getNetwork());
            data.put("suuid", recharge.getSuuid());
            data.put("channel", recharge.getChannel());
            data.put("timestamp",recharge.getTimestamp());
            if(TextUtils.isEmpty(recharge.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", recharge.getIp());
            }
            data.put("mac",recharge.getMac());
            data.put("event","Error");
            data.put("error_type",recharge.getError_type());
            data.put("register_days",recharge.getRegister_days()+"");
            data.put("nettype",recharge.getNettype());
            data.put("device_id",recharge.getDevice_id());
            data.put("account",recharge.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }

    public static void doError2Server(final Context c, final List<EventBean> errors){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getErrorPara(c, errors), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
//
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("error.dn");
                            SPUtils.put(c, SPUtils.TAB_ERROR, false);
                        } else {
                            FileUtils.saveErrorFile(c, errors.get(errors.size() - 1));
                        }
                    } else {
                        FileUtils.saveErrorFile(c, errors.get(errors.size() - 1));
                    }
                } else {
                    FileUtils.saveErrorFile(c, errors.get(errors.size() - 1));
                }
            }
        });
    }
    //---------------------------------------------------------------------------
    private static Map<String, Object> getRoleUpgradePara(Context c,List<EventBean> roleUpgrades) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<roleUpgrades.size();i++){
            EventBean roleUpgrade=roleUpgrades.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", roleUpgrade.getAppkey());
            data.put("app_version", roleUpgrade.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", roleUpgrade.getDeviceType());
            data.put("os_version", roleUpgrade.getOsversion());
            data.put("display", roleUpgrade.getDisplay());
            data.put("lang", roleUpgrade.getLang());
            data.put("network", roleUpgrade.getNetwork());
            data.put("suuid", roleUpgrade.getSuuid());
            data.put("channel", roleUpgrade.getChannel());
            data.put("timestamp",roleUpgrade.getTimestamp());
            if(TextUtils.isEmpty(roleUpgrade.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", roleUpgrade.getIp());
            }
            data.put("mac",roleUpgrade.getMac());
            data.put("event","RoleUpgrade");
            data.put("account_level",roleUpgrade.getAccount_level());
            data.put("register_days",roleUpgrade.getRegister_days()+"");
            data.put("nettype",roleUpgrade.getNettype());
            data.put("device_id",roleUpgrade.getDevice_id());
            data.put("account",roleUpgrade.getAccount());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }
    public static void doRoleUpgrade2Server(final Context c, final List<EventBean> roleUpgrades){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getRoleUpgradePara(c, roleUpgrades), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {

                    if (!TextUtils.isEmpty(jsonStr)) {
//
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("roleupgrade.dn");
                            SPUtils.put(c, SPUtils.TAB_ROLEUPGRADE, false);
                        } else {
                            FileUtils.saveRoleUpgradeFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                        }
                    } else {
                        FileUtils.saveRoleUpgradeFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                    }
                } else {
                    FileUtils.saveRoleUpgradeFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                }
            }
        });
    }
    //---------------------------------------------------------------------------
    private static Map<String, Object> getCompleteConsumptionPara(Context c,List<EventBean> roleUpgrades) {
        if(c==null){
            return null;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return null;
            }
        }
        List<Map<String,Object>> datas=new ArrayList<Map<String, Object>>();
        for(int i=0;i<roleUpgrades.size();i++){
            EventBean roleUpgrade=roleUpgrades.get(i);
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("appkey", roleUpgrade.getAppkey());
            data.put("app_version", roleUpgrade.getAppversion());
            data.put("os_type", "Android");
            data.put("device_type", roleUpgrade.getDeviceType());
            data.put("os_version", roleUpgrade.getOsversion());
            data.put("display", roleUpgrade.getDisplay());
            data.put("lang", roleUpgrade.getLang());
            data.put("network", roleUpgrade.getNetwork());
            data.put("suuid", roleUpgrade.getSuuid());
            data.put("channel", roleUpgrade.getChannel());
            data.put("timestamp",roleUpgrade.getTimestamp());
            if(TextUtils.isEmpty(roleUpgrade.getIp())){
                data.put("ip",(String)SPUtils.get(c,SPUtils.CUR_IP,""));
            }else {
                data.put("ip", roleUpgrade.getIp());
            }
            data.put("mac",roleUpgrade.getMac());
            data.put("event",roleUpgrade.getEvent());
            data.put("payment_method",roleUpgrade.getPayment_method());
            data.put("register_days",roleUpgrade.getRegister_days()+"");
            data.put("nettype",roleUpgrade.getNettype());
            data.put("consumption_point",roleUpgrade.getConsumption_point());
            data.put("money",roleUpgrade.getMoney()+"");
            data.put("account",roleUpgrade.getAccount());
            data.put("device_id",roleUpgrade.getDevice_id());
            datas.add(data);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", list2json(datas));
        return map;
    }
    public static void doCompleteConsumption2Server(final Context c, final List<EventBean> roleUpgrades){
        if(c==null){
            return;
        }
        if(c instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) c)){
                return;
            }
        }
        HttpUtils.startHttpPost(getURL(c), getCompleteConsumptionPara(c, roleUpgrades), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {
                    if (!TextUtils.isEmpty(jsonStr)) {
//
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code = JSONParser.getInt(result, "code");
                        String msg = JSONParser.getString(result, "msg");
                        if (code == 0) {
                            FileUtils.delFile("completeconsumption.dn");
                            SPUtils.put(c, SPUtils.TAB_CONSUMPTION_COMPLETE, false);
                        } else {
                            FileUtils.saveCompleteConsumptionFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                        }
                    } else {
                        FileUtils.saveCompleteConsumptionFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                    }
                } else {
                    FileUtils.saveCompleteConsumptionFile(c, roleUpgrades.get(roleUpgrades.size() - 1));
                }
            }
        });
    }
    public static void getIp(final Context context, final String netName){
        if(context==null){
            return;
        }
        if(context instanceof Activity){
            if(!PhoneInfoUtils.isLiving((Activity) context)){
                return;
            }
        }
        HttpUtils.startHttpGet(URL_GETIP, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(!TextUtils.isEmpty(jsonStr)){
                    JSONObject jo=JSONParser.getJSONObject(jsonStr);
                    int code=JSONParser.getInt(jo,"code");
                    if(code==0){
                        String msg=JSONParser.getString(jo,"msg");
                        SPUtils.put(context,SPUtils.CUR_IP,msg);
                        if(!TextUtils.isEmpty(netName))
                            SPUtils.put(context,SPUtils.NET_NAME,netName);
                    }
                }
            }
        });
    }
}
