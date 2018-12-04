package com.comers.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

public class NetUtils {

	/**
	 *  判断当前的网络状态
	 *<br>0 ---- 离线状态
	 *<br>1 ---- 移动网络
	 *<br>2 ---- 只是wifi连接
	 */
	public static int netstate(Context context) {
		int i = 0;
		if (isMobileConnected(context) && !isWifiConnected(context)) {
			i = 1;
		} else if (isWifiConnected(context)) {
			i = 2;
		} else if (!isMobileConnected(context) && !isWifiConnected(context)) {
			i = 0;
		}
		return i;
	}

	/** 是否是wifi连接状态*/
	private static boolean isWifiConnected(Context c) {
		ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		State wifi = State.DISCONNECTED;
		if (ni != null) {
			wifi = ni.getState();
		}
		return (wifi == State.CONNECTED);
	}


	/**
	 * 主要功能:
	 * <br> 判断移动网络连接的状态
	 * @return
	 */
	private static boolean isMobileConnected(Context c) {
		ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		State wifi = State.DISCONNECTED;
		if (ni != null) {
			wifi = ni.getState();
		}
		return (wifi == State.CONNECTED);
	}
	public static String getNetType(Context c){
		ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		String type = "未知";
		if(info != null){
			if(info.getType() == ConnectivityManager.TYPE_WIFI){
				type = "WIFI网络";
			}
			if(info.getType() == ConnectivityManager.TYPE_MOBILE){
				switch(info.getSubtype()){
					case TelephonyManager.NETWORK_TYPE_GPRS:
					case TelephonyManager.NETWORK_TYPE_EDGE:
					case TelephonyManager.NETWORK_TYPE_CDMA:
					case TelephonyManager.NETWORK_TYPE_1xRTT:
					case TelephonyManager.NETWORK_TYPE_IDEN:
						type = "蜂窝数据网络 - 2G";
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
						type = "蜂窝数据网络-3G";
						break;
					case TelephonyManager.NETWORK_TYPE_LTE:
						type = "蜂窝数据网络-4G";
						break;
					case TelephonyManager.NETWORK_TYPE_UNKNOWN:
					default:
						type = "蜂窝数据网络-未知";
						break;
				}
			}
		}
		return type;
	}
	public static int getNetType2(Context c){
		ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		int type = 0;
		if(info != null){
			if(info.getType() == ConnectivityManager.TYPE_WIFI){
				type = 1;
			}
			if(info.getType() == ConnectivityManager.TYPE_MOBILE){
				switch(info.getSubtype()){
					case TelephonyManager.NETWORK_TYPE_GPRS:
					case TelephonyManager.NETWORK_TYPE_EDGE:
					case TelephonyManager.NETWORK_TYPE_CDMA:
					case TelephonyManager.NETWORK_TYPE_1xRTT:
					case TelephonyManager.NETWORK_TYPE_IDEN:
						type = 3;
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
						type = 4;
						break;
					case TelephonyManager.NETWORK_TYPE_LTE:
						type = 5;
						break;
					case TelephonyManager.NETWORK_TYPE_UNKNOWN:
					default:
						type = 2;
						break;
				}
			}
		}
		return type;
	}
}
