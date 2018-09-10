package com.donews.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.donews.sdk.bean.SizeEntity;
import com.donews.sdk.interfaces.MyCallBack;
import com.donews.sdk.view.NativeData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujuan on 2018/4/3.
 */

public class XingYouURL {
    public static final int ADTYPE_OPEN=1;//开屏广告
    public static final int ADTYPE_FLOW=2;//信息流
    public static final int ADTYPE_BANNER=3;//通栏（banner）
    public static final int ADTYPE_CAROUSEL=4;//轮播广告
    private static final String XINGYOU_AD_URL=URLUtils.AD_SERVER+"xingyou/app/req1";
    private static Map<String,Object> getParams(Activity activity, int adType, int adWidth, int adHeight, String channel, String position,String appname){
        Map<String,Object> datas=new HashMap<String,Object>();
        Map<String,String> impData=new HashMap<String,String>();//描述广告位的对象
        impData.put("ad_type",adType+"");
        impData.put("w",adWidth+"");
        impData.put("h",adHeight+"");
        if(!TextUtils.isEmpty(channel)){
            impData.put("channel",channel);
        }
        if(!TextUtils.isEmpty(position)){
            impData.put("position",position);
        }
        if(!TextUtils.isEmpty(appname)){
            impData.put("app_name",appname);
        }
        datas.put("imp",URLUtils.map2json2(impData));
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
        deviceData.put("geo",URLUtils.map2json2(geoData));
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
        datas.put("device", URLUtils.map2json2(deviceData));
        return datas;
    }
    private static String getUrl(Context mContext){
        long signTime=System.currentTimeMillis()/1000;
        String key= Contants.getDonewsKey(mContext);
        String secret=Contants.getDonewsSecret(mContext);
        String token=MD5.getMD5((signTime + secret).getBytes());
        return XINGYOU_AD_URL+"?authKey="+key+"&signTime="+signTime+"&token="+token;
    }
    public static void getXingYouAD(Activity mActivity, int adType, int adWidth, int adHeight, String channel, String position, String appname, final MyCallBack callBack){
        Log.e("xingyouad","start"+adWidth+",,"+adHeight+",,"+adType);
        if(adType==ADTYPE_OPEN){
//            int width=PhoneInfoUtils.getScreenWidth(mActivity);
//            int height=PhoneInfoUtils.getScreenHeight(mActivity);
//            SplashSizeModel model=new SplashSizeModel(mActivity);
//            List<SizeEntity> entities=model.querySize();
            List<SizeEntity> entities=ADFileUtils.getSplashSizes();
            if(entities!=null && entities.size()>0){
                for(int i=0;i<entities.size();i++){
                    SizeEntity entity=entities.get(i);
                    Log.e("xingyouad","size from db"+entity.getH());
                    int w=entity.getW();
                    if(w>=adWidth){
                        adWidth=w;
                        adHeight=entity.getH();
                        break;
                    }
                }
            }
        }
        Log.e("xingyouad","end size"+adWidth+",,"+adHeight);
        HttpUtils.startHttpPost(getUrl(mActivity), getParams(mActivity, adType,adWidth , adHeight, channel, position, appname), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                Log.e("getXingYouAD","LLLL"+jsonStr);
                if(isResult){
                    if(!TextUtils.isEmpty(jsonStr)){
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
                                String click_url=JSONParser.getString(msg, "click_url");
                                String monitor_wn_url=JSONParser.getString(msg,"monitor_wn_url");
                                String monitor_cl_url=JSONParser.getString(msg,"monitor_cl_url");
                                int isDefaultad=JSONParser.getInt(msg,"is_default_ad");
                                String des=JSONParser.getString(msg,"description");
                                String ad_from=JSONParser.getString(msg,"ad_from");
                                NativeData nativeEntity=new NativeData();
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
                                nativeEntity.setIs_default_ad(isDefaultad);
                                nativeEntity.setDescription(des);
                                nativeEntity.setAd_from(ad_from);
                                callBack.setNative(nativeEntity);
                            }else {
                                callBack.setNative(null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            callBack.setNative(null);
                        }
                    }else {
                        callBack.setNative(null);
                    }
                }else {
                    callBack.setNative(null);
                }
            }
        });
    }

    public interface XingYouCallBack {
        public void setResult(String result);
    }
}
