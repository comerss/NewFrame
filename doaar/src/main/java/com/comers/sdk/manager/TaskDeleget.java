package com.comers.sdk.manager;

import android.app.Application;
import android.text.TextUtils;

import com.comers.sdk.base.LogUtils;
import com.comers.sdk.bean.AdParams;
import com.comers.sdk.bean.AdPosition;
import com.comers.sdk.bean.DeviceInfo;
import com.comers.sdk.bean.Native;
import com.comers.sdk.bean.Positions;
import com.comers.sdk.interfaces.Advertisement;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.utils.HttpUtils;
import com.comers.sdk.utils.JSONParser;
import com.comers.sdk.utils.MD5;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79653 on 2018/8/21.
 * 描述：
 */
 enum  TaskDeleget {
    INSTANCE;
    private int isInit = -1;
    private Application mApplication;
    private String URL=AdvertiseManager.getInstance().isDebug()?"http://182.92.203.215:9001":"http://g1.tagtic.cn";
    public void getAd(final AdParams slot, final Advertisement advertisement) {
        if (isInit != 1) {
            LogUtils.i("info", "SDK初始化失败，暂时无法获取广告，请稍后请求或者重启应用");
            return;
        }
        DeviceInfo info = new DeviceInfo(slot.getContext());
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("device", info);
        objectMap.put("imp", new Positions(slot.getAdPosition()));
        String url = URL+"/v1/union/ads/get";
        HttpUtils.startHttpPost(getUrl(url, AuthKeyManager.INSTANCE.getAuthKey(), AuthKeyManager.INSTANCE.getAuthSecret()), objectMap, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                LogUtils.i("info", jsonStr);
                if (isResult && !TextUtils.isEmpty(jsonStr)) {
                    DoSlot.Builder doSlot = new DoSlot.Builder();
                    doSlot.setContext(slot.getContext())
                            .setSupportDeepLink(slot.isSupportDeepLink())
                            .setAdCount(slot.getAdCount())
                            .setApplication(mApplication)
                            .setImageAcceptedSize(slot.getWidth(), slot.getHeight());
                    String result = parseResult(jsonStr);
                    Native data = new Native(result);
                    //[ 0:直客（非联盟） 1:百度 2:google 3:今日头条 4:英威诺 5:广点通 ]
                    AdvertiseType type = AdvertiseType.DEFAULT;
                    if (TextUtils.equals(data.ad_from, "1")) {
                        doSlot.setAppID(AuthKeyManager.INSTANCE.getBaiDuKey());
                        doSlot.setAdvertiseId(AuthKeyManager.INSTANCE.mPositionMap.get(slot.getAdPosition()).BaiDu);
                        type = AdvertiseType.BAI_DU;
                    } else if (TextUtils.equals(data.ad_from, "3")) {
                        doSlot.setAppID(AuthKeyManager.INSTANCE.getTouTiaoKey());
                        doSlot.setAppName(AuthKeyManager.INSTANCE.getAppName());
                        doSlot.setAdvertiseId(AuthKeyManager.INSTANCE.mPositionMap.get(slot.getAdPosition()).TouTiao);
                        type = AdvertiseType.TOU_TIAO;
                    } else if (TextUtils.equals(data.ad_from, "5")) {
                        doSlot.setAppID(AuthKeyManager.INSTANCE.getGuangDTKey());
                        doSlot.setAdvertiseId(AuthKeyManager.INSTANCE.mPositionMap.get(slot.getAdPosition()).GDTong);
                        type = AdvertiseType.GUANG_DIAN_TONG;
                    }
                    doSlot.setNative(data);
                    if (advertisement instanceof InterfaceManager.OnSplashListener) {
                        AdvertiseHelper.INSTANCE.loadSplash(type, doSlot.build(), (InterfaceManager.OnSplashListener) advertisement);
                    } else if (advertisement instanceof InterfaceManager.OnFeedListener) {
                        AdvertiseHelper.INSTANCE.loadFeed(type, doSlot.build(), (InterfaceManager.OnFeedListener) advertisement);
                    }
                }
            }
        });
    }

    private String parseResult(String jsonStr) {
        String jsonArray = JSONParser.getString(jsonStr, "msg");
        JSONArray array = JSONParser.getJSONArray(jsonArray);
        if (array != null) {
            try {
                return array.getString(0);
            } catch (JSONException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return "";
        }
    }
    public void getPosition(final AdParams slot, final Advertisement splashListener) {
        String url = URL + "/v1/union/ads/positionInfo" ;
        DeviceInfo info = new DeviceInfo(slot.getContext());
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("device", info);
        objectMap.put("imp", new Positions(slot.getAdPosition()));
        HttpUtils.startHttpPost(getUrl(url, AuthKeyManager.INSTANCE.getAuthKey(), AuthKeyManager.INSTANCE.getAuthSecret()), objectMap, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                if (isResult && !TextUtils.isEmpty(jsonStr)) {
                    AdPosition adPosition = new AdPosition();
                    adPosition.BaiDu = JSONParser.getString(jsonStr, "baidu_position_id");
                    adPosition.TouTiao = JSONParser.getString(jsonStr, "toutiao_position_id");
                    adPosition.GDTong = JSONParser.getString(jsonStr, "gdt_position_id");
                    AuthKeyManager.INSTANCE.mPositionMap.put(slot.getAdPosition(),adPosition);
                    getAd(slot, splashListener);
                }
            }
        });
    }

    private String getUrl(String url, String authKey, String authSecret) {
        long signTime = System.currentTimeMillis() / 1000L;
        String token = MD5.getMD5((signTime + authSecret).getBytes());
        return url + "?authKey=" + authKey + "&signTime=" + signTime + "&token=" + token;
    }
    public void init(final Application application, String authKey, String authSecret) {
        String url =URL+"/v1/union/ads/appInfo";
        mApplication = application;
        AuthKeyManager.INSTANCE.setAuth(authKey, authSecret);
        DonewsAgent.registDonewsSDK(application, "");
        if (TextUtils.isEmpty(authKey) || TextUtils.isEmpty(authSecret)) {
            LogUtils.i("info", "authKey or authSecret can't be null !");
            return;
        }
        DeviceInfo info = new DeviceInfo(application);
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("device", info);
        objectMap.put("imp", "{}");
        HttpUtils.startHttpPost(getUrl(url, authKey, authSecret), objectMap, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                LogUtils.i("result", jsonStr);
                if (isResult && !TextUtils.isEmpty(jsonStr)) {
                    isInit = 1;
                    AuthKeyManager.INSTANCE.setBaiDuKey(application, JSONParser.getString(jsonStr, "baidu_media_id"));
                    AuthKeyManager.INSTANCE.setTouTiaoKey(application, JSONParser.getString(jsonStr, "toutiao_media_id"), JSONParser.getString(jsonStr, "app_pack_name"));
                    AuthKeyManager.INSTANCE.setGuangDTKey(application, JSONParser.getString(jsonStr, "gdt_media_id"));
                    AuthKeyManager.INSTANCE.setAppName(JSONParser.getString(jsonStr,"app_pack_name"));

                } else {
                    isInit = 0;
                }
            }
        });

    }
}
