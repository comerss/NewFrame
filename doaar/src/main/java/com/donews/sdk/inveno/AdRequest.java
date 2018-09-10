package com.donews.sdk.inveno;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.donews.sdk.bean.EventTrack;
import com.donews.sdk.bean.ImageInfo;
import com.donews.sdk.bean.InteractionObject;
import com.donews.sdk.interfaces.Advertisement;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.utils.HttpUtils;
import com.donews.sdk.utils.MD5;
import com.donews.sdk.utils.PhoneInfoUtils;
import com.donews.sdk.view.NativeData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by yujuan on 2018/6/4.
 */

public class AdRequest {
    public static final String INVENO_AD_URL = "https://malacca.inveno.com/malacca/sdkPullAds.do";

    public enum ADTYPE {
        BANNER,//横幅广告
        OPENING,//开屏广告
        INTERSTITIAL,//插屏广告
        NATIVE,//信息流广告
        TEXT//文字链广告
    }

    ;

    private static int getAdType(ADTYPE adtype) {
        int type = 0;
        switch (adtype) {
            case BANNER:
                type = 1;
                break;
            case TEXT:
                type = 5;
                break;
            case NATIVE:
                type = 4;
                break;
            case OPENING:
                type = 2;
                break;
            case INTERSTITIAL:
                type = 3;
                break;
        }
        return type;
    }

    private static Map<String, Object> getParams(Context mContext, String adid, ADTYPE adType, int adWidth, int adHeight) {
        Map<String, Object> params = new HashMap<>();
        params.put("bid", MD5.getMD5((PhoneInfoUtils.getMeid(mContext) + PhoneInfoUtils.getPkg(mContext) + System.currentTimeMillis()).getBytes()));
        params.put("api_version", "2.1.0");
        params.put("ua", PhoneInfoUtils.getUserAgent(mContext));
        params.put("app", map2json(getAppParams(mContext)));
        params.put("device", map2json(getDeviceParams(mContext)));
        params.put("network", map2json(getNetworkParams(mContext)));
        params.put("user", map2json(getUserParams(mContext)));
        params.put("adspaces", "[" + map2json(getAdspacesParams(adid, adType, adWidth, adHeight)) + "]");
        return params;
    }

    private static Map<String, String> getAppParams(Context mContext) {
        Map<String, String> params = new HashMap<>();
        params.put("app_id", PhoneInfoUtils.getInvenoAppId(mContext));
        params.put("channel_id", PhoneInfoUtils.getVersionChannel(mContext));
        params.put("app_name", PhoneInfoUtils.getInvenoAppName(mContext));
        params.put("package_name", PhoneInfoUtils.getPkg(mContext));
        params.put("app_version", PhoneInfoUtils.getVersion(mContext));
        params.put("report_pv_method", 1 + "");
        return params;
    }

    private static Map<String, String> getDeviceParams(Context mContext) {
        Map<String, String> params = new HashMap<>();
//        params.put("device_id","["+URLUtils.map2json2(getDeviceIdParams(mContext,1))+","+URLUtils.map2json2(getDeviceIdParams(mContext,3))+","+URLUtils.map2json2(getDeviceIdParams(mContext,4))+","+URLUtils.map2json2(getDeviceIdParams(mContext,8))+"]");
        List<String> list = new ArrayList<>();
        list.add(map2json(getDeviceIdParams(mContext, 1)));
        list.add(map2json(getDeviceIdParams(mContext, 3)));
        list.add(map2json(getDeviceIdParams(mContext, 4)));
//        list.add(map2json(getDeviceIdParams(mContext,8)));
        params.put("device_id", list.toString());

        Log.e("invenoad", "LLL" + params.get("device_id"));
        params.put("os_type", 2 + "");
        params.put("os_version", PhoneInfoUtils.getDeviceSDK());
        params.put("brand", PhoneInfoUtils.getBrand());
        params.put("model", PhoneInfoUtils.getPhoneModel(mContext));
        params.put("device_type", (PhoneInfoUtils.isPad(mContext) ? 1 : 2) + "");
        params.put("language", PhoneInfoUtils.getLang());
        params.put("screen_width", PhoneInfoUtils.getScreenWidth(mContext) + "");
        params.put("screen_height", PhoneInfoUtils.getScreenHeight(mContext) + "");
        params.put("screen_density", PhoneInfoUtils.getDensity(mContext) + "");
        params.put("screen_orientation", PhoneInfoUtils.getOriatation(mContext) + "");
        return params;
    }

    private static Map<String, String> getDeviceIdParams(Context mContext, int deviceType) {
        String deviceId = "";
        switch (deviceType) {
            case 1:
                deviceId = PhoneInfoUtils.getIMEI(mContext);
                break;
            case 3:
                deviceId = PhoneInfoUtils.getAndroidID(mContext);
                break;
            case 4:
                deviceId = PhoneInfoUtils.getMacAddress2(mContext);
                break;
            case 8:
                deviceId = PhoneInfoUtils.getIMSI(mContext);
                break;
        }
        Map<String, String> params = new HashMap<>();
        params.put("device_id", deviceId);
        params.put("device_id_type", deviceType + "");
        params.put("hash_type", "0");
        return params;
    }

    private static Map<String, String> getNetworkParams(Context mContext) {
        Map<String, String> params = new HashMap<>();
        params.put("network_type", PhoneInfoUtils.getNetTypeInt(mContext) + "");
        params.put("carrier_id", PhoneInfoUtils.getCarrierName(mContext));
        return params;
    }

    private static Map<String, String> getUserParams(Context mContext) {
        Map<String, String> params = new HashMap<>();
        params.put("user_id", PhoneInfoUtils.getIMEI(mContext));
        return params;
    }

    private static Map<String, String> getAdspacesParams(String adid, ADTYPE adType, int adWidth, int adHeight) {
        Map<String, String> params = new HashMap<>();
        params.put("adspace_id", adid);
        params.put("adspace_type", getAdType(adType) + "");
        params.put("allowed_html", "false");
        params.put("width", adWidth + "");
        params.put("height", adHeight + "");
        params.put("impression_num", "1");
        params.put("open_type", "0");
        params.put("interaction_type", "[1,2,3,4]");
        params.put("support_deeplink", "1");
        params.put("assets", "[1,2,3]");
        params.put("impression_time", "5");
        return params;
    }

    public static String decompress(InputStream inputStream) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while ((len = inputStream.read(buf)) != -1) {
                baos.write(buf, 0, len);
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
            GZIPInputStream gzip = new GZIPInputStream(in);//
            byte[] buffer = new byte[250];
            int n = 0;
            while ((n = gzip.read(buffer, 0, buffer.length)) > 0) {
                out.write(buffer, 0, n);
            }
            gzip.close();
            in.close();
            out.close();
            baos.close();
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String map2json(Map<String, String> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append("\"" + key + "\"");
                json.append(":");
                String value = map.get(key);
                if (!TextUtils.isEmpty(value) && (value.startsWith("{") || value.startsWith("["))) {
                    json.append(map.get(key));
                } else if ("true".equals(value) || "false".equals(value)) {
                    json.append(value);
                } else {
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

    public static void getInvenoAd(final Context mContext, String adid, ADTYPE adType, int adWidth, int adHeight, final Advertisement callBack) {
        getData(mContext, adid, adType, adWidth, adHeight, callBack);
    }

    private static void getData(final Context mContext, String adid, ADTYPE adType, int adWidth, int adHeight, final Advertisement callBack) {
        HttpUtils.startHttpPost(INVENO_AD_URL, getParams(mContext, adid, adType, adWidth, adHeight), new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {
                Log.e("invenoad", "LLL" + jsonStr);
                if (TextUtils.isEmpty(jsonStr)) {
                    return;
                }
                try {
                    JSONObject object = new JSONObject(jsonStr);
                    int code = object.getInt("error_code");
                    if (code == 0) {
                        JSONArray array = object.getJSONArray("ads");
                        if (array != null && array.length() > 0) {
                            JSONObject object1 = (JSONObject) array.get(0);
                            JSONArray array1 = object1.getJSONArray("creative");
                            if (array1 != null && array1.length() > 0) {
                                NativeData nativeAd = new NativeData();
                                JSONObject object2 = array1.getJSONObject(0);
                                String ad_id = object2.getString("ad_id");
                                nativeAd.setAid(ad_id);
//                                String adm_type=object2.getString("adm_type");
//                                int adspace_slot_seq=object2.getInt("adspace_slot_seq");
//                                String banner_id=object2.getString("banner_id");
//                                int expiration_duration=object2.getInt("expiration_duration");
//                                int expiration_time=object2.getInt("expiration_time");
                                String interaction_type = object2.getString("interaction_type");
                                nativeAd.setInteraction_type(interaction_type);
//                                int open_type=object2.getInt("open_type");

                                JSONObject admObject = object2.getJSONObject("adm");
//                                String adm_source=admObject.getString("adm_source");
                                JSONObject admNativeObject = admObject.getJSONObject("adm_native");
                                String ad_title = admNativeObject.getString("ad_title");
                                nativeAd.setTitle(ad_title);
//                                String adtag=admNativeObject.getString("adtag");
                                if (jsonStr.contains("description")) {
                                    String description = admNativeObject.getString("description");
                                    nativeAd.setDescription(description);
                                }
//                                String logo=admNativeObject.getString("logo");
                                JSONArray imgsArray = admNativeObject.getJSONArray("imgs");
                                if (imgsArray != null && imgsArray.length() > 0) {
                                    List<String> imgList = new ArrayList<>();
                                    List<ImageInfo> imgs = new ArrayList<>();
                                    for (int i = 0; i < imgsArray.length(); i++) {
                                        JSONObject imgsObject = imgsArray.getJSONObject(i);
                                        int width = imgsObject.getInt("width");
                                        int height = imgsObject.getInt("height");
                                        String imgurl = imgsObject.getString("url");
                                        ImageInfo info=new ImageInfo(height,width,imgurl);
                                        imgs.add(info);
//                                        nativeAd.setH(height);
//                                        nativeAd.setW(width);
                                        imgList.add(imgurl);
                                    }
                                    nativeAd.setImpurls(imgList);
                                    nativeAd.setImgs(imgs);
                                }
                                if (jsonStr.contains("event_track")) {
                                    JSONArray eventArray = object2.getJSONArray("event_track");
                                    if (eventArray != null && eventArray.length() > 0) {
                                        List<EventTrack> eventTracks = new ArrayList<>();
                                        for (int i = 0; i < eventArray.length(); i++) {
                                            JSONObject eventObject = eventArray.getJSONObject(i);
                                            String eventType = eventObject.getString("event_type");
                                            String notify_url = eventObject.getString("notify_url");
                                            EventTrack eventTrack = new EventTrack();
                                            eventTrack.setEvent_type(eventType);
                                            eventTrack.setNotify_url(notify_url);
                                            eventTracks.add(eventTrack);
                                        }
                                        nativeAd.setEventTracks(eventTracks);

                                    }
                                }
                                if (jsonStr.contains("interaction_object")) {
                                    JSONObject interactionObject = object2.getJSONObject("interaction_object");
                                    InteractionObject interactionObject1 = new InteractionObject();
                                    if (interactionObject.toString().contains("package_name")) {
                                        String package_name = interactionObject.getString("package_name");
                                        interactionObject1.setPackage_name(package_name);
                                    }
                                    String linkurl = interactionObject.getString("url");
                                    interactionObject1.setUrl(linkurl);
                                    if (jsonStr.contains("deep_link")) {
                                        String deep_link = interactionObject.getString("deep_link");
                                        interactionObject1.setDeep_link(deep_link);
                                    }
                                    if (jsonStr.contains("phone")) {
                                        String phone = interactionObject.getString("phone");
                                        interactionObject1.setPhone(phone);
                                    }
                                    if (jsonStr.contains("mail")) {
                                        String mail = interactionObject.getString("mail");
                                        interactionObject1.setMail(mail);
                                    }
                                    if (jsonStr.contains("msg")) {
                                        String msg = interactionObject.getString("msg");
                                        interactionObject1.setMsg(msg);
                                    }
                                    nativeAd.setInteractionObject(interactionObject1);
                                }
                                if (callBack instanceof InterfaceManager.OnSplashListener) {
                                    new InvenoSplashHolder(mContext, (InterfaceManager.OnSplashListener) callBack, nativeAd);
                                } else {
                                    new InvenoFeedHolder(mContext,(InterfaceManager.OnFeedListener)callBack,nativeAd);
                                }
                            } else {
                                callBack.onError(100, "");
                            }
                        } else {
                            callBack.onError(100, "暂无广告数据");
                        }
                    } else {
                        callBack.onError(100, "获取失败");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    callBack.onError(104, e.getMessage());
                    Log.e("invenoad", e.getMessage());
                }
            }
        });
    }
}
