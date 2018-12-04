package com.comers.sdk.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.comers.sdk.utils.AUtils;
import com.comers.sdk.utils.SPUtils;


/**
 * Created by YJ on 2016/6/24.
 */
public class NetStateReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            if (info != null && info.isAvailable()) {
                String name = info.getTypeName();
                if("WIFI".equalsIgnoreCase(name)){
                    WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                    WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
                    name = wifiInfo != null ? wifiInfo.getSSID() : "WIFI";
                }else if(info.getType() == ConnectivityManager.TYPE_MOBILE){
                        switch(info.getSubtype()){
                            case TelephonyManager.NETWORK_TYPE_GPRS:
                            case TelephonyManager.NETWORK_TYPE_EDGE:
                            case TelephonyManager.NETWORK_TYPE_CDMA:
                            case TelephonyManager.NETWORK_TYPE_1xRTT:
                            case TelephonyManager.NETWORK_TYPE_IDEN:
                                name = "2G";
                                break;
                            case TelephonyManager.NETWORK_TYPE_UMTS:
                            case TelephonyManager.NETWORK_TYPE_EVDO_0:
                            case TelephonyManager.NETWORK_TYPE_EVDO_A:
                            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                            case TelephonyManager.NETWORK_TYPE_HSDPA:
                            case TelephonyManager.NETWORK_TYPE_HSPA:
                            case TelephonyManager.NETWORK_TYPE_HSPAP:
                            case TelephonyManager.NETWORK_TYPE_HSUPA:
                            case TelephonyManager.NETWORK_TYPE_EHRPD:
                                name = "3G";
                                break;
                            case TelephonyManager.NETWORK_TYPE_LTE:
                                name = "4G";
                                break;
                            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                            default:
                                name = "MOBILE";
                                break;
                        }
                }
                if(!TextUtils.isEmpty(name)){
                    if(!name.equals(SPUtils.get(context,SPUtils.NET_NAME,""))){
                        AUtils.getIp(context,name);
                    }
                }
//                Log.e("receiver","LLL网络状态改变"+name);
            } else {
            }
        }
    }
}
