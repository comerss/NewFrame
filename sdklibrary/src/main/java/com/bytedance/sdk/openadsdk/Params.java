package com.bytedance.sdk.openadsdk;

/**
 * Created by 79653 on 2018/7/13.
 * 描述：
 */
public class Params {

    public String id;//postionId
    public int adtype;//广告类型
    public int pos;//广告位置类型  (后台不需要有)
    public  int width;//屏幕宽
    public  int height;//屏幕高
    public  int ad_count;//请求的广告数量最大3
    public boolean is_support_dpl =true;//是否接受深沉link

    public String request_id ;//请求id
    public String ad_sdk_version = "1.9.2";//sdk版本号
    public String source_type = "app";//（后台不需要有）
    public String gender = "0";//（后台不需要有）
    public String ua ;//userAgent

    public String ip ;
    /*
    * appid: 5001622
		name: 引力资讯-android_android
		package_name: com.donews.firsthot
		version: 1
    * */
    public boolean is_paid_app = false;
    public String appid; //申请的应用ID
    public String name;//申请的应用name

    /*	"imei": "864454033357660",
		"android_id": "c1cfb21ac36e1dee",
		"uuid": "faff6438-e2b1-4cf5-bf3a-98e8149bae3b",
		"ssid": "\"donews-z\"",
		"wifi_mac": "02:00:00:00:00:00",
		"power_on_time": "326071149",
		"rom_version": "MIUI-8.4.28",
		"sys_compiling_time": "Fri Jun 8 21:10:20 CST 2018",
		"type": 1,
		"os": 1,
		"os_version": "24",
		"vendor": "Xiaomi",
		"model": "MI 5s",
		"language": "zh",
		"conn_type": 1,
		"mac": "00:EC:0A:1B:CC:42",
		"screen_width": 1080,
		"screen_height": 1920,
		"orientation": 0*/
    public String imei;
    public String android_id;
    public String uuid;
    public String ssid;
    public String wifi_mac;
    public String imsi;
    public String power_on_time;//已经开机时间
    public String rom_version;
    public String sys_compiling_time;
    public String type;
    public String os="1";
    public String os_version;//sdk 版本
    public String vendor;//Build.MANUFACTURER
    public String model;//Build.MODEL
    public String language;
    public String conn_type;//连接网络类型
    public String mac;
    public int screen_width;
    public int screen_height;


    public String package_name;//包名，必须和申请的包名一致
    public String version;

    public String latitude;
    public String longitude;

    //app
    public int accept_width;//期望接受的素材大小
    public int accept_height;


}
