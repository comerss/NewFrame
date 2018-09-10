package com.donews.sdk.bean;

import android.content.Context;

import com.donews.sdk.utils.PhoneInfoUtils;


/**
 * Created by 79653 on 2018/8/16.
 * 描述：
 */
public class DeviceInfo {
    /* //必传参数
        "os"       : "系统类型（数字）", //1 ios 2 Android
        "dpid"     : "苹果端",        //idfa 或者 androidD 必传

        "ua"       : "user-agent 基本信息，这里面我才能拿到手机品牌", //区别品牌
        "imei"     : "设备的IMEI",
        "suuid"    : "设备suuid 标识符",

        //选传
        "connectiontype" : "联网方式",*/
    public String os = "2";
    public String dpid = "";
    public String ua = "";
    public String imei = "";
    public String suuid = "";
    public String connectiontype = "";
    public DeviceInfo(Context context){
        dpid= PhoneInfoUtils.getAndroidID(context);
        ua=PhoneInfoUtils.getUserAgent(context);
        imei=PhoneInfoUtils.getIMEI(context);
        suuid=PhoneInfoUtils.getMyUUID(context);
        connectiontype=PhoneInfoUtils.getNetType(context);
    }
}
