package com.comers.shenwu.xunfei;

import android.app.Activity;
import android.content.Context;

/**
 * Created by 79653 on 2018/11/1.
 * 描述：
 */
public class DeviceInfo {
    //imei,ua,dpid,osv,mac,pxratio,orentation,make,model,appv,w,h
    public String os = "2";
    public String dpid = "";
    public String ua = "";
    public String imei = "";
    public String suuid = "";
    public String connectiontype = "";
    public String mac = "";
    public String osv = "";
    public String pxratio = "";
    public String orientation = "";
    public String make = "Android";
    public String model = "";
    public String appv;
    public String w;
    public String h;
    public String ip = "";
    public String devicetype = "";
    public String language = "";
    public String appv2;
    public String appName="";
    public String ppi;
    public DeviceInfo(Context context) {
        dpid = PhoneInfoUtils.getAndroidID(context);
        ua = PhoneInfoUtils.getUserAgent(context);
        imei = PhoneInfoUtils.getIMEI(context);
        suuid = PhoneInfoUtils.getMyUUID(context);
        connectiontype = PhoneInfoUtils.getNetType(context);
        mac = PhoneInfoUtils.getMacAddress(context);
        osv = PhoneInfoUtils.getRelease();
        pxratio = String.valueOf(PhoneInfoUtils.getDensity(context));
        orientation = String.valueOf(PhoneInfoUtils.getOriatation(context));
        model = PhoneInfoUtils.getPhoneModel(context);
        appv = PhoneInfoUtils.getAppVersion(context);
        w = String.valueOf(PhoneInfoUtils.getScreenWidth(context));
        h = String.valueOf(PhoneInfoUtils.getScreenHeight(context));
        ip = "192.168.10.174";
        devicetype = PhoneInfoUtils.getIsTabletDevice(context);
        language = PhoneInfoUtils.getLang();
        appv2 = PhoneInfoUtils.getVersionCode(context);
        appName=PhoneInfoUtils.toUtf8(PhoneInfoUtils.getAppName(context));
        if(context instanceof Activity){
            ppi=PhoneInfoUtils.getPPI((Activity) context);
        }else{
            ppi="400";
        }

    }
    /* if (adType != 0) {
            impData.put("ad_type", adType + "");
        }

        if (adWidth != 0) {
            impData.put("w", adWidth + "");
        }

        if (adHeight != 0) {
            impData.put("h", adHeight + "");
        }

        if (!TextUtils.isEmpty(channel)) {
            impData.put("channel", channel);
        }

        if (!TextUtils.isEmpty(position)) {
            impData.put("position", position);
        }

        if (!TextUtils.isEmpty(appname)) {
            impData.put("app_name", appname);
        }

        impData.put("promotion_channel", PhoneInfoUtils.getVersionChannel(activity));
        datas.put("imp", URLUtils.map2json2(impData));
        Map<String, String> deviceData = new HashMap();
        deviceData.put("os", "2");
        deviceData.put("imei", PhoneInfoUtils.getIMEI(activity));
        deviceData.put("dpid", PhoneInfoUtils.getAndroidID(activity));
        deviceData.put("mac", PhoneInfoUtils.getMacAddress(activity));
        deviceData.put("ua", PhoneInfoUtils.getUserAgent(activity));
        Map<String, String> geoData = new HashMap();
        geoData.put("lat", "");
        geoData.put("lon", "");
        geoData.put("type", PhoneInfoUtils.getProvider(activity));
        geoData.put("country", PhoneInfoUtils.getCountryId(activity));
        geoData.put("region", "");
        geoData.put("city", "");
        geoData.put("zip", PhoneInfoUtils.getPostalCode(activity));
        deviceData.put("geo", URLUtils.map2json2(geoData));
        deviceData.put("ip", PhoneInfoUtils.getLocalIpAddress(activity));
        deviceData.put("devicetype", PhoneInfoUtils.getIsTabletDevice(activity));
        deviceData.put("model", PhoneInfoUtils.getPhoneModel(activity));
        deviceData.put("osv", PhoneInfoUtils.getRelease());
        deviceData.put("connectiontype", NetUtils.getNetType2(activity) + "");
        deviceData.put("carrier", PhoneInfoUtils.getProvidersName(activity));
        deviceData.put("language", PhoneInfoUtils.getLang());
        deviceData.put("w", PhoneInfoUtils.getScreenWidth(activity) + "");
        deviceData.put("h", PhoneInfoUtils.getScreenHeight(activity) + "");
        deviceData.put("ppi", PhoneInfoUtils.getPPI(activity));
        deviceData.put("pxratio", PhoneInfoUtils.getDensity(activity) + "");
        deviceData.put("orientation", String.valueOf(PhoneInfoUtils.getOriatation(activity)));
        deviceData.put("appName", PhoneInfoUtils.toUtf8(PhoneInfoUtils.getAppName(activity)));
        deviceData.put("suuid", PhoneInfoUtils.getMyUUID(activity));
        deviceData.put("appv", PhoneInfoUtils.getAppVersion(activity));
        deviceData.put("appv2", PhoneInfoUtils.getVersionCode(activity));*/

    /*
    * {
    device =     {
        appName = Donews;
        appv = "2.3.0";
        appv2 = 230;
        connectiontype = 1;
        devicetype = 1;
        dpid = "2F1963EC-7914-4786-90AD-989AB4A2D71C";
        h = 2436;
        idfv = "027141CD-9D3A-4706-86B8-DBB7EC2BB8D7";
        imei = "2F1963EC-7914-4786-90AD-989AB4A2D71C";
        ip = "fe80::144e:74e9:3a56:43d9";
        language = en;
        mac = "02:00:00:00:00:00";
        make = Apple;
        model = iPhone;
        openudid = "027141CD-9D3A-4706-86B8-DBB7EC2BB8D7";
        orientation = 2;
        os = 1;
        osv = "11.4";
        ppi = 401;
        pxratio = 2;
        suuid = "2F1963EC-7914-4786-90AD-989AB4A2D71C";
        ua = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15F79";
        w = 1125;
    };
    imp =     {
        h = 320;
        positionId = 392B2CBFF10B0F587138F415C9257FD9;
        w = 480;
    };
}
    *
    *
    *
    * */
}
