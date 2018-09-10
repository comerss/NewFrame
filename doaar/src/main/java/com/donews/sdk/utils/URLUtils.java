package com.donews.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.donews.sdk.base.JsonParseHelper;
import com.donews.sdk.bean.SizeEntity;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.interfaces.MyCallBack;
import com.donews.sdk.view.AppCenterView;
import com.donews.sdk.view.NativeData;
import com.donews.sdk.zhike.ZhiFeedHelper;
import com.donews.sdk.zhike.ZhiSplashHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by YJ on 2015/10/28.
 */
public class URLUtils {
//    public static final String URL_AD_SERVER = "http://r.dsp.tagtic.cn/api/mobile/req1";
//    public static final String URL_AD_SERVER="http://x6gn4t.natappfree.cc/mobile/req1";
//    public static final String AD_SERVER="http://182.92.203.215:9001/v1/";//测试版
    public static final String AD_SERVER="http://g1.tagtic.cn/v1/";//正式版
//    public static final String AD_SERVER="http://xc3h6g.natappfree.cc/v1/";
    public static final String URL_AD_SERVER=AD_SERVER+"nra/req1";

    public static final String UPLOAD_BLACKAD=AD_SERVER+"nra/black";
    public static final String GET_SPLASH_SIZE=AD_SERVER+"nra/size";



    //值为对象的时候不加引号不加引号
    public static String map2json2(Map<String, String> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append("\"" + key + "\"");
                json.append(":");
                String value=map.get(key);
                if(!TextUtils.isEmpty(value) && value.startsWith("{")){
                    json.append(map.get(key));
                }else{
                    json.append("\""+map.get(key)+"\"");
                }

                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }
//    public static void getADfromServer(final Context isScreenOn,final BannerView view) {
//        HttpUtils.startHttpGet(URL_AD_SERVER, new HttpUtils.HttpResultCallback() {
//            @Override
//            public void result(String url, boolean isResult, String jsonStr) {
//                if (isResult) {
//                    if(!TextUtils.isEmpty(jsonStr)) {
//                        JSONObject result = JSONParser.getJSONObject(jsonStr);
//                        String content = JSONParser.getString(result, "htmladcontent");
//                        int start=content.lastIndexOf("src=");
//                        String imgUrl=content.substring(start+5,content.length()-2);
//                        if(!TextUtils.isEmpty(imgUrl) && isScreenOn!=null) {
////                            Glide.with(isScreenOn).load(imgUrl).into(view);
//                            Method method0;
//                            String methodName0 = "with";//with 为隐藏类的隐藏method
//                            Method method1;
//                            String methodName1="load";
//                            Method method2;
//                            String methodName2="into";
//                            try {
//                                Class class0=Class.forName("com.bumptech.glide.Glide");
//                                method0 = class0.getMethod(methodName0, Context.class);
//
//                                Object object1=method0.invoke(class0, isScreenOn);
//                                method1=Class.forName("com.bumptech.glide.RequestManager").getMethod(methodName1,String.class);
//
//                                Object object2=method1.invoke(object1, imgUrl);
//                                method2 = Class.forName("com.bumptech.glide.DrawableRequestBuilder").getMethod(methodName2, BannerView.class);
//                                method2.invoke(object2, view);
//                            } catch (NoSuchMethodException e) {
//                                e.printStackTrace();
//                            } catch (ClassNotFoundException e) {
//                                e.printStackTrace();
//                            } catch (InvocationTargetException e) {
//                                e.printStackTrace();
//                            } catch (IllegalAccessException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        });
//    }
    public static String getUrl(String url,String authKey, String authSecret){
//        String url=URL_AD_SERVER;
//        String token=MD5.getMD5((authKey+authSecret).getBytes());
        long signTime=System.currentTimeMillis()/1000;
        String token=MD5.getMD5((signTime + authSecret).getBytes());
        Log.e("getgravity","LLL"+signTime+","+token);
        return url+"?authKey="+authKey+"&signTime="+signTime+"&token="+token;
    }

    /**
     *牛耳热点添加渠道广告，新的接口数据
     *
     * @param activity
     * @param adType open:开屏广告；channel:频道信息流广告；content_info:内文信息流广告； content_banner:内文页banner; quit:退出广告
     * @param adWidth 广告素材宽度
     * @param adHeight 广告素材高度
     * @param channel 频道id
     * @param position 位置id
     * @return
     */
    private static Map<String,Object> getNewADParams(Activity activity,String userid,String adType,int adWidth,int adHeight,String channel,String position,int black_flag){
        Map<String,Object> datas=new HashMap<String,Object>();
        Map<String,String> impData=new HashMap<String,String>();//描述广告位的对象
        impData.put("ad_type",adType);
        impData.put("w",adWidth+"");
        impData.put("h",adHeight+"");
        impData.put("userid",userid);
        if(!TextUtils.isEmpty(channel)){
            impData.put("channel",channel);
        }
        if(!TextUtils.isEmpty(position)){
            impData.put("position",position);
        }
        if(black_flag!=-1) {
            impData.put("black_flag", black_flag + "");
        }
//        impData.put("sex","男");
//        impData.put("age","20");
//        impData.put("tags","");
        datas.put("imp",map2json2(impData));
        Map<String,String> deviceData=new HashMap<String,String>();
        deviceData.put("os","2");
        deviceData.put("imei",PhoneInfoUtils.getIMEI(activity));
        deviceData.put("dpid",PhoneInfoUtils.getAndroidID(activity));
        deviceData.put("mac",PhoneInfoUtils.getMacAddress(activity));
        deviceData.put("ua", PhoneInfoUtils.getUserAgent(activity));

        //Geo对象
        Map<String,String> geoData=new HashMap<String,String>();
        geoData.put("lat","");
        geoData.put("lon", "");
        geoData.put("type",PhoneInfoUtils.getProvider(activity));
        geoData.put("country", PhoneInfoUtils.getCountryId(activity));
        geoData.put("region","");
        geoData.put("city", "");
        geoData.put("zip", PhoneInfoUtils.getPostalCode(activity));
        deviceData.put("geo",map2json2(geoData));
        deviceData.put("ip",PhoneInfoUtils.getLocalIpAddress(activity));
        deviceData.put("devicetype",PhoneInfoUtils.getIsTabletDevice(activity));
        deviceData.put("model",PhoneInfoUtils.getPhoneModel(activity));
        deviceData.put("osv",PhoneInfoUtils.getRelease());
        deviceData.put("connectiontype",NetUtils.getNetType2(activity)+"");
        deviceData.put("carrier",PhoneInfoUtils.getProvidersName(activity));
        deviceData.put("language",PhoneInfoUtils.getLang());
        deviceData.put("w",PhoneInfoUtils.getScreenWidth(activity)+"");
        deviceData.put("h",PhoneInfoUtils.getScreenHeight(activity)+"");
        deviceData.put("ppi",PhoneInfoUtils.getPPI(activity));
        deviceData.put("pxratio",PhoneInfoUtils.getDensity(activity)+"");
        deviceData.put("orientation",String.valueOf(PhoneInfoUtils.getOriatation(activity)));
        deviceData.put("appName",PhoneInfoUtils.toUtf8(PhoneInfoUtils.getAppName(activity)));
        deviceData.put("suuid",PhoneInfoUtils.getMyUUID(activity));
        deviceData.put("appv",PhoneInfoUtils.getAppVersion(activity));
        deviceData.put("appv2",PhoneInfoUtils.getVersionCode(activity));
        datas.put("device", map2json2(deviceData));
        return datas;
    }
    private static Map<String,Object> getADParams(Activity c, boolean isBanner,boolean isSplash,boolean isAppCenter,boolean isSwitch,boolean isExit){

        Map<String,Object> datas=new HashMap<String,Object>();
        Map<String,Object> impData=new HashMap<String,Object>();//Impression对象
        if(isBanner) {
            int screenWidth=PhoneInfoUtils.getScreenWidth(c);
            int bannerHeight=100;
            int bannerWidth=640;
            if(screenWidth<800){
                bannerHeight=100;
                bannerWidth=640;
            }else{
                bannerHeight=166;
                bannerWidth=1080;
            }
            Map<String,String> bannerData=new HashMap<String,String>();//Banner对象
            bannerData.put("w", String.valueOf(bannerWidth));//banner的宽为屏幕的宽
            bannerData.put("h",String.valueOf(bannerHeight));//高度为开发者自定义的高度
            bannerData.put("pos","3");//页面其他位置
            impData.put("banner",map2json2(bannerData));
        }else{
            impData.put("banner","");
        }
        if(!isBanner && !isSplash && !isAppCenter && !isExit && !isSwitch) {
            impData.put("native","1");
        }else {
            impData.put("native", "0");//不是原生广告
        }
        impData.put("instl", "0");//不是全插屏广告
        Map<String,String> ext=new HashMap<String,String>();
        if(isSplash){
//            impData.put("ext.splash","1");
            ext.put("splash","1");
        }else{
//            impData.put("ext.splash","0");
            ext.put("splash","0");
        }
        impData.put("ext",map2json2(ext));
        if(isAppCenter) {
            impData.put("appCenter", "1");
        }else{
            impData.put("appCenter", "0");
        }
        if(isSwitch){
            impData.put("return", "1");
        }else{
            impData.put("return", "0");
        }
        if(isExit){
            impData.put("exit", "1");
        }else {
            impData.put("exit", "0");
        }
        datas.put("imp", JsonParseHelper.parse(impData));
        //Device对象
        Map<String,Object> deviceData=new HashMap<String,Object>();

            deviceData.put("imei", PhoneInfoUtils.getIMEI(c));
            deviceData.put("dpid", PhoneInfoUtils.getMyUUID(c));
        deviceData.put("mac",PhoneInfoUtils.getMacAddress(c));
        deviceData.put("ua",PhoneInfoUtils.getUserAgent(c));
        deviceData.put("ip",PhoneInfoUtils.getLocalIpAddress(c));
        deviceData.put("devicetype","2");
        deviceData.put("make",PhoneInfoUtils.getMake());
        deviceData.put("model",PhoneInfoUtils.getPhoneModel(c));
        deviceData.put("os","android");
        deviceData.put("osv",PhoneInfoUtils.getRelease());
        deviceData.put("connectiontype",NetUtils.getNetType(c));
        deviceData.put("carrier",PhoneInfoUtils.getIMSI(c));
        deviceData.put("language",PhoneInfoUtils.getLang());
        deviceData.put("w",PhoneInfoUtils.getScreenWidth(c)+"");
        deviceData.put("h",PhoneInfoUtils.getScreenHeight(c)+"");
        deviceData.put("ppi",PhoneInfoUtils.getPPI(c));
        deviceData.put("pxratio",PhoneInfoUtils.getDensity(c)+"");
        deviceData.put("suuid",PhoneInfoUtils.getMyUUID(c));
        deviceData.put("appName",PhoneInfoUtils.getAppName(c));
//        deviceData.put("ext.orientation",PhoneInfoUtils.getOriatation(isScreenOn)+"");
        Map<String,Object> ext2=new HashMap<String,Object>();
        ext2.put("orientation",String.valueOf(PhoneInfoUtils.getOriatation(c)));
        deviceData.put("ext",JsonParseHelper.parse(ext2));
        //Geo对象
        Map<String,String> geoData=new HashMap<String,String>();
//        geoData.put("lat",PhoneInfoUtils.getLocLat(isScreenOn));
//        geoData.put("lon", PhoneInfoUtils.getLocLong(isScreenOn));
        geoData.put("lat","");
        geoData.put("lon", "");
        geoData.put("type",PhoneInfoUtils.getProvider(c));
        geoData.put("country", PhoneInfoUtils.getCountryId(c));
//        geoData.put("region",PhoneInfoUtils.getCityId(isScreenOn));
//        geoData.put("city", PhoneInfoUtils.getCityId(isScreenOn));
        geoData.put("region","");
        geoData.put("city", "");
        geoData.put("zip", PhoneInfoUtils.getPostalCode(c));
        deviceData.put("geo",map2json2(geoData));
        datas.put("device", JsonParseHelper.parse(deviceData));
        Log.e("para", "LLL" + datas.toString());
        return  datas;
    }
    public static void getAD(final Activity c, final String authKey, final String authSecret,final Handler handler){
        Map<String,Object> paras=getADParams(c, true, false, false, false, false);
        if(paras==null){
            return;
        }
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
//                        Log.e("banner","LLL"+",,,,"+jsonStr);
                    if(!TextUtils.isEmpty(jsonStr)){
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        String content = JSONParser.getString(result, "htmladcontent");
                        if(!TextUtils.isEmpty(content)) {
                            if( handler!=null) {
                                handler.obtainMessage(Contants.GETAD_SUCCESS, content).sendToTarget();
                            }
                        }
                    }
                }
            }
        });
    }
    public static void getSplashAd(Activity c,String authKey,String authSecret,final Handler handler){
        Map<String,Object> paras=getADParams(c, false, true, false, false, false);
        if(paras==null){
            return;
        }
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
                    if(!TextUtils.isEmpty(jsonStr)){
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        String content = JSONParser.getString(result, "htmladcontent");
                        if(!TextUtils.isEmpty(content)) {
                            if( handler!=null) {
                                handler.obtainMessage(Contants.GETSPLASHAD_SUCCESS, content).sendToTarget();
                            }
                        }
                    }
                }
            }
        });
    }
    public static void getNiuerSplashAd(Activity activity,String useid,String authKey,String authSecret,final Handler handler){
        int width=PhoneInfoUtils.getScreenWidth(activity);
        int height=PhoneInfoUtils.getScreenHeight(activity);
        Map<String,Object> params=getNewADParams(activity, useid,"open", width, height, "", "", -1);
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), params, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
                    if(!TextUtils.isEmpty(jsonStr)){
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        int code=JSONParser.getInt(result, "result");
                        if(code==1) {
                            JSONObject msg = JSONParser.getJSONObject(result, "msg");
                            String content = JSONParser.getString(msg, "adHtml");
                            if (!TextUtils.isEmpty(content)) {
                                if (handler != null) {
                                    handler.obtainMessage(Contants.GETSPLASHAD_SUCCESS, content).sendToTarget();
                                }
                            }
                        }
                    }
                }
            }
        });
    }

//    private static NativeData aNative=null;
    public static void getNativeAD(final Activity c, final String authKey, final String authSecret,final MyCallBack callBack){
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), getADParams(c,false,false,false,false,false), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
//                        Log.i("json","LLL"+jsonStr);
                    if(!TextUtils.isEmpty(jsonStr)){
                        NativeData aNative=new NativeData();
                        try {
                            aNative=new NativeData();
                            JSONObject result = JSONParser.getJSONObject(jsonStr);
                            if(result!=null) {
                                int w=JSONParser.getInt(result,"w");
                                int h=JSONParser.getInt(result,"h");
                                JSONObject nativedata = JSONParser.getJSONObject(result, "native_data");
                                if(nativedata!=null) {
                                    String icon = JSONParser.getString(nativedata, "icon");
                                    String click_url = JSONParser.getString(nativedata, "click_url");
                                    String pic = JSONParser.getString(nativedata, "pic");
                                    String title = JSONParser.getString(nativedata, "title");
                                    String text = JSONParser.getString(nativedata, "text");
                                    JSONArray impurls = JSONParser.getJSONArray(nativedata, "impurls");
                                    List<String> impurlss = new ArrayList<String>();
                                    if (impurls.length() > 0) {
                                        for (int i = 0; i < impurls.length(); i++) {
                                            String impurl = (String) impurls.get(i);
                                            impurlss.add(impurl);
                                        }
                                    }
                                    aNative = new NativeData(impurlss, click_url, icon, title, text, pic,w,h);
//                                    mHandler.obtainMessage(Contants.GETNATIVEAD_SUCCESS, aNative).sendToTarget();
                                    callBack.setNative(aNative);
                                }else{
                                    callBack.setNative(null);
                                }
                            }else{
                                callBack.setNative(null);
                            }
                        }catch (JSONException e) {
                            callBack.setNative(null);
                        }
                    }else{
                        callBack.setNative(null);
                    }

                }else{
                    callBack.setNative(null);
                }
            }
        });
    }
    // feed
    public static void getNiuerNativeAd(final Activity activity, String useid, String authKey, String authSecret, String adType, String channelid, String position, int black_flag, final InterfaceManager.OnFeedListener callBack){
        Map<String,Object> paras=getNewADParams(activity,useid,adType,300,200,channelid,position,black_flag);
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult) {
                    if (!TextUtils.isEmpty(jsonStr)) {
                        try {
                            JSONObject object = JSONParser.getJSONObject(jsonStr);
                            int code = JSONParser.getInt(object, "result");
                            if (code == 1) {
                                JSONObject msg = JSONParser.getJSONObject(object, "msg");
                                String mid = JSONParser.getString(msg, "mid");
                                String aid = JSONParser.getString(msg, "aid");
                                JSONArray array = JSONParser.getJSONArray(msg, "pic");
                                List<String> impurls = new ArrayList<String>();
                                if (array.length() > 0) {
                                    for (int i = 0; i < array.length(); i++) {
                                        String impurl = (String) array.get(i);
                                        impurls.add(impurl);
                                    }
                                }
                                int w = JSONParser.getInt(msg, "w");
                                int h = JSONParser.getInt(msg, "h");
                                String title=JSONParser.getString(msg, "title");
                                String urls = JSONParser.getString(msg, "url");
                                int info=JSONParser.getInt(msg, "information");
                                int m_play=JSONParser.getInt(msg, "m_play");
                                String wn_url=JSONParser.getString(msg, "wn_url");
                                String click_url=JSONParser.getString(msg,"click_url");
                                String monitor_wn_url=JSONParser.getString(msg,"monitor_wn_url");
                                String monitor_cl_url=JSONParser.getString(msg,"monitor_cl_url");
                                String ad_from=JSONParser.getString(msg,"ad_from");
                                NativeData nativeEntity=new NativeData();
                                nativeEntity.setAd_from(ad_from);
                                nativeEntity.setMid(mid);
                                nativeEntity.setAid(aid);
                                nativeEntity.setImpurls(impurls);
                                nativeEntity.setW(w);
                                nativeEntity.setH(h);
                                nativeEntity.setTitle(title);
                                nativeEntity.setUrl(urls);
                                nativeEntity.setInformation(info);
                                nativeEntity.setM_play(m_play);
                                nativeEntity.setWn_url(wn_url);
                                nativeEntity.setClick_url(click_url);
                                nativeEntity.setMonitor_wn_url(monitor_wn_url);
                                nativeEntity.setMonitor_cl_url(monitor_cl_url);
                               new ZhiFeedHelper(activity,callBack,nativeEntity);
                            }else {
                               callBack.onError(code,"广告获取失败");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            callBack.onError(1003,"数据解析异常");
                        }
                    }else {
                        callBack.onError(1004,"暂无广告");
                    }
                }else {
                    callBack.onError(1004,"暂无广告");
                }
            }
        });
    }

    //splash
    public static void getGravitySplashAd(final Activity activity, String userid, final String authKey, String authSecret, final InterfaceManager.OnSplashListener callBack){
        int width=PhoneInfoUtils.getScreenWidth(activity);
        int height=PhoneInfoUtils.getScreenHeight(activity);
        Log.e("getgravity","LLL"+width+",,"+height);
//        SplashSizeModel model=new SplashSizeModel(activity);
//        List<SizeEntity> entities=model.querySize();
        List<SizeEntity> entities=ADFileUtils.getSplashSizes();
        if(entities!=null && entities.size()>0){
            for(int i=0;i<entities.size();i++){
                SizeEntity entity=entities.get(i);
                int w=entity.getW();
                if(w>=width){
                    width=w;
                    height=entity.getH();
                    break;
                }
            }
        }
        Map<String,Object> params=getNewADParams(activity, userid,"open", width, height, "", "",-1);

        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), params, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
                    if(!TextUtils.isEmpty(jsonStr)){
                        try {
                            JSONObject object = JSONParser.getJSONObject(jsonStr);
                            int code = JSONParser.getInt(object, "result");
                            JSONObject msg = JSONParser.getJSONObject(object, "msg");
                            if (code == 1) {
                                String mid = JSONParser.getString(msg, "mid");
                                String aid = JSONParser.getString(msg, "aid");
                                JSONArray array = JSONParser.getJSONArray(msg, "pic");
                                List<String> impurls = new ArrayList<String>();
                                if (array.length() > 0) {
                                    for (int i = 0; i < array.length(); i++) {
                                        String impurl = (String) array.get(i);
                                        impurls.add(impurl);
                                    }
                                }
                                int w = JSONParser.getInt(msg, "w");
                                int h = JSONParser.getInt(msg, "h");
                                String title=JSONParser.getString(msg, "title");
                                String urls = JSONParser.getString(msg, "url");
                                int info=JSONParser.getInt(msg, "information");
                                int m_play=JSONParser.getInt(msg, "m_play");
                                String wn_url=JSONParser.getString(msg, "wn_url");
                                String click_url=JSONParser.getString(msg, "click_url");
                                String monitor_wn_url=JSONParser.getString(msg,"monitor_wn_url");
                                String monitor_cl_url=JSONParser.getString(msg,"monitor_cl_url");
                                String ad_from=JSONParser.getString(msg,"ad_from");
                                NativeData nativeEntity=new NativeData();
                                nativeEntity.setAd_from(ad_from);
                                nativeEntity.setMid(mid);
                                nativeEntity.setAid(aid);
                                nativeEntity.setImpurls(impurls);
                                nativeEntity.setW(w);
                                nativeEntity.setH(h);
                                nativeEntity.setTitle(title);
                                nativeEntity.setUrl(urls);
                                nativeEntity.setInformation(info);
                                nativeEntity.setM_play(m_play);
                                nativeEntity.setWn_url(wn_url);
                                nativeEntity.setClick_url(click_url);
                                nativeEntity.setMonitor_wn_url(monitor_wn_url);
                                nativeEntity.setMonitor_cl_url(monitor_cl_url);
                                new ZhiSplashHelper(activity,authKey,callBack,nativeEntity);
                            }else {
                               callBack.onError(code,"请求失败");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            callBack.onError(1003,"数据解析异常");
                        }
                    }else {
                        callBack.onError(1004,"暂无广告数据");
                    }
                }else {
                    callBack.onError(1004,"暂无广告数据");
                }
            }
        });
    }
    public static void getAppCenterAD(final Activity c, final String authKey, final String authSecret, final AppCenterView.AppCenterCallBack callBack){
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), getADParams(c,false,false,true,false,false), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
//                        Log.e("json","LLL"+jsonStr);
                    if(!TextUtils.isEmpty(jsonStr)){
                        NativeData aNative=new NativeData();
                        try {
                            aNative=new NativeData();
                            JSONObject result = JSONParser.getJSONObject(jsonStr);
                            if(result!=null) {
                                JSONObject nativedata = JSONParser.getJSONObject(result, "native_data");
                                if(nativedata!=null) {
                                    String icon = JSONParser.getString(nativedata, "icon");
                                    String click_url = JSONParser.getString(nativedata, "click_url");
                                    String pic = JSONParser.getString(nativedata, "pic");
                                    String title = JSONParser.getString(nativedata, "title");
                                    String text = JSONParser.getString(nativedata, "text");
                                    JSONArray impurls = JSONParser.getJSONArray(nativedata, "impurls");
                                    List<String> impurlss = new ArrayList<String>();
                                    if (impurls.length() > 0) {
                                        for (int i = 0; i < impurls.length(); i++) {
                                            String impurl = (String) impurls.get(i);
                                            impurlss.add(impurl);
                                        }
                                    }
                                    aNative = new NativeData(impurlss, click_url, icon, title, text, pic);
//                                    mHandler.obtainMessage(Contants.GETNATIVEAD_SUCCESS, aNative).sendToTarget();
                                    callBack.getAppCenter(aNative);
                                }else{
                                    callBack.getAppCenter(null);
                                }
                            }else{
                                callBack.getAppCenter(null);
                            }
                        }catch (JSONException e) {
                            callBack.getAppCenter(null);
                        }
                    }else{
                        callBack.getAppCenter(null);
                    }

                }else{
                    callBack.getAppCenter(null);
                }
            }
        });
    }

    /**
     * 获取app切换广告
     * @param c
     * @param authKey
     * @param authSecret
     * @param handler
     */
    public static void getSwitchAd(Activity c,String authKey,String authSecret,final Handler handler){
        Map<String,Object> paras=getADParams(c,false,false,false,true,false);
        if(paras==null){
            return;
        }
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){
                    if(!TextUtils.isEmpty(jsonStr)){
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        String content = JSONParser.getString(result, "htmladcontent");
                        if(!TextUtils.isEmpty(content)) {
                            if( handler!=null) {
                                handler.obtainMessage(Contants.GETSWITCHAD_SUCCESS, content).sendToTarget();
                            }
                        }
                    }
                }
            }
        });
    }

    /**
     * 获取退出广告
     * @param c
     * @param authKey
     * @param authSecret
     * @param handler
     */
    public static void getExitAd(Activity c,String authKey,String authSecret,final Handler handler){
        Map<String,Object> paras=getADParams(c,false,false,false,false,true);
        if(paras==null){
            return;
        }
        HttpUtils.startHttpPost(getUrl(URL_AD_SERVER,authKey,authSecret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if(isResult){

                    if(!TextUtils.isEmpty(jsonStr)){
                        JSONObject result = JSONParser.getJSONObject(jsonStr);
                        String content = JSONParser.getString(result, "htmladcontent");
                        if(!TextUtils.isEmpty(content)) {
                            if( handler!=null) {
                                handler.obtainMessage(Contants.GETEXITAD_SUCCESS, content).sendToTarget();
                            }
                        }
                    }
                }
            }
        });
    }


    /**
     * 上传黑名单广告
     * @param activity
     * @param aid 广告id
     * @param mid 素材id
     */
    public static void sendBlackAD(Activity activity,String aid,String mid){
        Map<String,Object> paras=new HashMap<>();
        Map<String,String> impData=new HashMap<String,String>();//描述广告位的对象
        impData.put("aid",aid);
        impData.put("mid",mid);
        paras.put("imp",map2json2(impData));
        Map<String,String> deviceData=new HashMap<String,String>();
        deviceData.put("os","2");
        deviceData.put("imei",PhoneInfoUtils.getIMEI(activity));
        deviceData.put("dpid",PhoneInfoUtils.getAndroidID(activity));
        deviceData.put("mac",PhoneInfoUtils.getMacAddress(activity));
        deviceData.put("ua", PhoneInfoUtils.getUserAgent(activity));

        //Geo对象
        Map<String,String> geoData=new HashMap<String,String>();
        geoData.put("lat","");
        geoData.put("lon", "");
        geoData.put("type",PhoneInfoUtils.getProvider(activity));
        geoData.put("country", PhoneInfoUtils.getCountryId(activity));
        geoData.put("region","");
        geoData.put("city", "");
        geoData.put("zip", PhoneInfoUtils.getPostalCode(activity));
        deviceData.put("geo",map2json2(geoData));
        deviceData.put("ip",PhoneInfoUtils.getLocalIpAddress(activity));
        deviceData.put("devicetype",PhoneInfoUtils.getIsTabletDevice(activity));
        deviceData.put("model",PhoneInfoUtils.getPhoneModel(activity));
        deviceData.put("osv",PhoneInfoUtils.getRelease());
        deviceData.put("connectiontype",NetUtils.getNetType2(activity)+"");
        deviceData.put("carrier",PhoneInfoUtils.getProvidersName(activity));
        deviceData.put("language",PhoneInfoUtils.getLang());
        deviceData.put("w",PhoneInfoUtils.getScreenWidth(activity)+"");
        deviceData.put("h",PhoneInfoUtils.getScreenHeight(activity)+"");
        deviceData.put("ppi",PhoneInfoUtils.getPPI(activity));
        deviceData.put("pxratio",PhoneInfoUtils.getDensity(activity)+"");
        deviceData.put("orientation",String.valueOf(PhoneInfoUtils.getOriatation(activity)));
        deviceData.put("appName",PhoneInfoUtils.toUtf8(PhoneInfoUtils.getAppName(activity)));
        deviceData.put("suuid",PhoneInfoUtils.getMyUUID(activity));
        deviceData.put("appv",PhoneInfoUtils.getAppVersion(activity));
        deviceData.put("appv2",PhoneInfoUtils.getVersionCode(activity));
        paras.put("device", map2json2(deviceData));
        String key= Contants.getDonewsKey(activity);
        String secret=Contants.getDonewsSecret(activity);
        HttpUtils.startHttpPost(getUrl(UPLOAD_BLACKAD,key,secret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                Log.e("sendblackad","LLL"+jsonStr);
            }
        });

    }
    public static void getSplashSize(final Context activity){
        Map<String,Object> paras=new HashMap<>();
        Map<String,String> deviceData=new HashMap<String,String>();
        deviceData.put("os","2");
        paras.put("device", map2json2(deviceData));
        String key= Contants.getDonewsKey(activity);
        String secret=Contants.getDonewsSecret(activity);
        HttpUtils.startHttpPost(getUrl(GET_SPLASH_SIZE,key,secret), paras, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                Log.e("getsplashsize","LLL"+jsonStr);
                ADFileUtils.saveSlashSizeFile(jsonStr);
//                if(isResult && !TextUtils.isEmpty(jsonStr)){
//                    JSONArray result = JSONParser.getJSONArray(jsonStr);
//                    if(result!=null) {
//                        if (result.length() > 0) {
//                            SplashSizeModel model = new SplashSizeModel(activity);
//                            model.deleteSplashSizeTable();
//                            for (int i = 0; i < result.length(); i++) {
//                                try {
//                                    JSONObject object = result.getJSONObject(i);
//                                    int w = object.getInt("w");
//                                    int h = object.getInt("h");
//                                    SizeEntity entity = new SizeEntity(w, h, (int) (System.currentTimeMillis() / 1000 / 60));
//                                    model.insertSplashSize(entity);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    }
//                }
            }
        });

    }
}
