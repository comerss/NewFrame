package com.bytedance.sdk.openadsdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.bytedance.sdk.openadsdk.core.AESHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

/**
 * Created by 79653 on 2018/7/13.
 * 描述：根据服务器返回的参数 生成服务器请求的 参数
 */
public enum ParamHelper {
    INSTANVE;

    public String getParamStr(Params params) {
        JSONObject var4 = new JSONObject();

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("request_id", params.request_id);
            jsonObject.put("ad_sdk_version", params.ad_sdk_version);
            jsonObject.put("source_type", "app");
            jsonObject.put("app", getAppInfo(params));
            jsonObject.put("device", getDeviceInfo(params));
            jsonObject.put("user", getUser(params));
            jsonObject.put("ua", params.ua);
            jsonObject.put("ip", params.ip);
            JSONArray var8 = new JSONArray();
            var8.put(getObject(params));
            jsonObject.put("adslots", var8);
            Log.i("Look", "get_ads参数--->" + jsonObject.toString());
            String var9 = AESHelper.encrypt(jsonObject.toString(), "b0458c2b262949b8");
            if (!TextUtils.isEmpty(var9)) {
                var4.put("message", var9);
                var4.put("cipher", 1);
            } else {
                var4.put("message", jsonObject.toString());
                var4.put("cipher", 0);
            }

            var4.put("ad_sdk_version", params.ad_sdk_version);
        } catch (JSONException var10) {
            ;
        }

        return var4.toString();
    }

    private String getObject(Params params) {
        JSONObject var3 = new JSONObject();

        try {
            var3.put("id", params.id);
            var3.put("adtype", params.adtype);
            var3.put("pos", AdSlot.getPosition(params.adtype));
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("width",params.accept_width);
            jsonObject.put("height",params.accept_height);
            var3.put("accepted_size", jsonObject);
            var3.put("is_support_dpl", params.is_support_dpl);
            int var4 = params.ad_count;
            if (var4 < 1) {
                var4 = 1;
            }

            if (var4 > 3) {
                var4 = 3;
            }

            var3.put("ad_count", var4);
        } catch (JSONException var5) {
            ;
        }

        return var3.toString();
    }

    private String getUser(Params params) {
        JSONObject json = new JSONObject();
        try {
            json.put("gender", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    private String getDeviceInfo(Params params) {
        JSONObject localJSONObject = new JSONObject();
        try {
            localJSONObject.put("imei", params.imei);
            localJSONObject.put("android_id", params.android_id);
            localJSONObject.put("uuid", params.uuid);
            localJSONObject.put("ssid", params.ssid);
            localJSONObject.put("wifi_mac", params.wifi_mac);
            localJSONObject.put("imsi", params.imsi);
            localJSONObject.put("power_on_time", params.power_on_time);
            localJSONObject.put("rom_version", params.rom_version);
            localJSONObject.put("sys_compiling_time", params.sys_compiling_time);
            localJSONObject.put("type", params.type);
            localJSONObject.put("os", params.os);
            localJSONObject.put("os_version", params.os_version);
            localJSONObject.put("vendor", Build.MANUFACTURER);
            localJSONObject.put("model", Build.MODEL);
            localJSONObject.put("language", Locale.getDefault().getLanguage());
            localJSONObject.put("conn_type", params.conn_type);
            localJSONObject.put("mac", params.mac);
            localJSONObject.put("screen_width", params.screen_width);
            localJSONObject.put("screen_height", params.screen_height);
        } catch (JSONException localJSONException) {
        }
        return localJSONObject.toString();
    }

    private JSONObject getAppInfo(Params params) {
        JSONObject localJSONObject = new JSONObject();
        try {

            localJSONObject.put("appid", params.appid);

            localJSONObject.put("name", params.name);
            localJSONObject.put("package_name", params.package_name);
            localJSONObject.put("version", params.version);
            localJSONObject.put("is_paid_app", false);

            JSONObject locala = new JSONObject();
            /* 517 */
            locala.put("latitude", params.longitude);
            /* 518 */
            locala.put("longitude", params.latitude);
            /* 519 */
            localJSONObject.put("geo", locala);


        } catch (JSONException localJSONException) {
        }
        return localJSONObject;
    }


}
