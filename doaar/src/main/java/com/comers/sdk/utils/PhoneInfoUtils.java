package com.comers.sdk.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class PhoneInfoUtils {
    public static String getPhoneNumber(Context c) {
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null)
            return "";
        @SuppressLint("MissingPermission") String number = tm.getLine1Number();
        if (TextUtils.isEmpty(number)) {
            return "";
        }
        return number;
    }

    public static String getMeid(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String meid = "";
        if (tm == null) {
            return meid;
        }
        if (!PermissionUtils.checkPermission(context, PermissionUtils.PERMISSIONS_PHONE)) {
            return meid;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!TextUtils.isEmpty(tm.getDeviceId(0))) {
                meid = tm.getDeviceId(0);
                if (!TextUtils.isEmpty(tm.getDeviceId(1))) {
                    meid += "," + tm.getDeviceId(1);
                }
            }
        } else {
            meid = tm.getDeviceId();
        }
        return meid;
    }

    public static String getIMEI(Context c) {
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = "864454033357660";
        if (tm == null)
            return "";
        if (!PermissionUtils.checkPermission(c, PermissionUtils.PERMISSIONS_PHONE)) {
        } else {
            imei = tm.getDeviceId();
        }
        return imei;
    }

    public static String getIMSI(Context c) {
        TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = "";
        if (tm == null)
            return imsi;

        if (!PermissionUtils.checkPermission(c, PermissionUtils.PERMISSIONS_PHONE)) {
        } else {
            imsi = tm.getSubscriberId();
        }
        return imsi;
    }

    /**
     * 获取手机mac地址 错误返回12个0
     */
//	public static String getMacAddress(Context context) {
//		// 获取mac地址：
//		String macAddress = "000000000000";
//		try {
//			WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//			WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
//			if (null != info) {
//				if (!TextUtils.isEmpty(info.getMacAddress()))
//					macAddress = info.getMacAddress().replace(":", "");
//				else
//					return macAddress;
//			}
//		} catch (Exception e) {
//			return macAddress;
//		}
//
//		return macAddress;
//	}

    /**
     * 获取手机型号
     */
    public static String getPhoneModel(Context c) {
        String model = (String) SPUtils.get(c, SPUtils.PHONE_MODEL, "");
        if (TextUtils.isEmpty(model)) {
            model = Build.MODEL;
            SPUtils.put(c, SPUtils.PHONE_MODEL, model);
        }
        return model;
    }

    /**
     * 获取系统版本号
     */
    public static String getRelease() {
        return Build.VERSION.RELEASE;
    }

    /**
     * 获取SDK版本号
     */
    public static int getSDK() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            return "2.0";
        }
    }

    /**
     * 获取版本号 versioncode
     *
     * @return 当前应用的版本号 versioncode
     */
    public static String getVersionCode(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = String.valueOf(info.versionCode);
            return version;
        } catch (Exception e) {
            return "110";
        }
    }

    public static String getAndroidID(Context activity) {
        String ANDROID_ID = Settings.System.getString(activity.getContentResolver(), Settings.System.ANDROID_ID);
        return ANDROID_ID;
    }

    /**
     * 获取设备类型平板 5/手机2
     *
     * @param context
     * @return
     */
    public static String getIsTabletDevice(Context context) {
        String device = "";
        if ((context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE) {
            device = "5";
        } else {
            device = "2";
        }
        return device;
    }

    @SuppressLint("MissingPermission")
    public static String getMyUUID(Context c) {
        String uniqueId = (String) SPUtils.get(c, SPUtils.UUID, "");
        try {
            if (TextUtils.isEmpty(uniqueId)) {
                final TelephonyManager tm = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
                if (tm == null) {
                    uniqueId = getID();
                    SPUtils.put(c, SPUtils.UUID, uniqueId);
                    return uniqueId;
                }
                final String tmDevice, tmSerial, tmPhone, androidId;
                tmDevice = tm.getDeviceId();
                tmSerial = tm.getSimSerialNumber();
                androidId = Settings.Secure.getString(c.getContentResolver(), Settings.Secure.ANDROID_ID);
                UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
                uniqueId = deviceUuid.toString();
                SPUtils.put(c, SPUtils.UUID, uniqueId);
                return uniqueId;
            } else {
                return uniqueId;
            }
        } catch (Exception e) {

        }
        return uniqueId == null ? "" : uniqueId;
    }

    public static String toUtf8(String str) {
        String result = null;
        try {
            result = new String(str.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public static String getAppName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    private static String getID() {
        String m_szDevIDShort = "35"  //we make this look like setText valid IMEI
                + Build.BOARD.length() % 10
                + Build.BRAND.length() % 10
                + Build.CPU_ABI.length() % 10
                + Build.DEVICE.length() % 10
                + Build.DISPLAY.length() % 10
                + Build.HOST.length() % 10
                + Build.ID.length() % 10
                + Build.MANUFACTURER.length() % 10
                + Build.MODEL.length() % 10
                + Build.PRODUCT.length() % 10
                + Build.TAGS.length() % 10
                + Build.TYPE.length() % 10
                + Build.USER.length() % 10;
        return m_szDevIDShort;
    }

    /**
     * 获取当前IP地址
     */
    private static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
        }
        return null;
    }

    public static String getLocalIpAddress(Context context) {
        String ip = (String) SPUtils.get(context, SPUtils.CUR_IP, "");
        if (TextUtils.isEmpty(ip)) {
            AUtils.getIp(context, "");
        }
        return ip;
    }

    public static int getScreenWidth(Context c) {
        int width = (Integer) SPUtils.get(c, SPUtils.PHONE_WIDTH, 0);
        if (width == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            width = wm.getDefaultDisplay().getWidth();
            SPUtils.put(c, SPUtils.PHONE_WIDTH, width);
        }
        return width;
    }

    public static int getScreenHeight(Context c) {
        int height = (Integer) SPUtils.get(c, SPUtils.PHONE_HEIGHT, 0);
        if (height == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            height = wm.getDefaultDisplay().getHeight();
            SPUtils.put(c, SPUtils.PHONE_HEIGHT, height);
        }
        return height;
    }

    public static String getUserAgent(Context c) {
        WebView webview = new WebView(c);
        WebSettings settings = webview.getSettings();
        return settings.getUserAgentString();
    }

    public static String getMake() {
        return Build.MANUFACTURER;
    }

    public static String getLang() {
        return Locale.getDefault().getLanguage();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static String getPPI(Activity c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Point point = new Point();
            c.getWindowManager().getDefaultDisplay().getRealSize(point);
            DisplayMetrics dm = c.getResources().getDisplayMetrics();
            double x = Math.pow(point.x / dm.xdpi, 2);
            double y = Math.pow(point.y / dm.ydpi, 2);
            double screenInches = Math.sqrt(x + y);
            return screenInches + "";
        } else {
            return "";
        }
    }

    public static float getDensity(Context c) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = c.getResources().getDisplayMetrics();
        return dm.density;
    }

    /**
     * 返回当前屏幕是否为竖屏。
     *
     * @param context
     * @return 当且仅当当前屏幕为竖屏时返回true, 否则返回false。
     */
    public static int getOriatation(Context context) {
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            return 1;
        } else {
            return 2;
        }
    }

    public static String getCountryId(Context context) {
        return context.getResources().getConfiguration().locale.getISO3Country();

    }

    public static String getProvider(Context c) {
        LocationManager locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);   //高精度
        criteria.setAltitudeRequired(true);    //不要求海拔
        criteria.setBearingRequired(true); //不要求方位
        criteria.setCostAllowed(true); //不允许有话费
        criteria.setPowerRequirement(Criteria.POWER_HIGH);   //低功耗
        criteria.setSpeedRequired(true);//手机位置移动
        String provider = locationManager.getBestProvider(criteria, true);
        return provider;
    }

    public static String getLocLong(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String provider = getProvider(context);
//		if (!checkPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) && !checkPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION)){
//			return "0.0";
//		}
        if (!PermissionUtils.checkPermission(context, PermissionUtils.PERMISSION_LOCATION)) {
            return "0.0";
        }
        Location location = null;
        if (!TextUtils.isEmpty(provider)) {
            location = locationManager.getLastKnownLocation(provider);
        }
        String lon = "116°21′59″";
        if (location != null) {
            lon = location.getLongitude() + "";//经度
        }
        return lon;
    }

    public static String getLocLat(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String provider = getProvider(context);
//		if (!checkPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) || !checkPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION)) {
//			return "0.0";
//		}
        if (!PermissionUtils.checkPermission(context, PermissionUtils.PERMISSION_LOCATION)) {
            return "0.0";
        }
        Location location = null;
        if (!TextUtils.isEmpty(provider)) {
            location = locationManager.getLastKnownLocation(provider);
        }

        String lat = "46°1′46″";
        if (location != null) {
            lat = location.getLatitude() + "";//纬度
        }
        return lat;
    }

    public static String getCityId(Context context) {
        Geocoder geocoder = new Geocoder(context);
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String provider = LocationManager.NETWORK_PROVIDER;
        //通过最后一次的地理位置来获得Location对象
//		if (!checkPermission(context,Manifest.permission.ACCESS_FINE_LOCATION) && !checkPermission(context,Manifest.permission.ACCESS_COARSE_LOCATION)) {
//			return "";
//		}
        if (!PermissionUtils.checkPermission(context, PermissionUtils.PERMISSION_LOCATION)) {
            return "";
        }
        Location location = null;
        if (!TextUtils.isEmpty(provider)) {
            location = locationManager.getLastKnownLocation(provider);
        }
        String mcityName = "";
        double lat = 0;
        double lng = 0;
        List<Address> addList = null;
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
        } else {
//			System.out.println("无法获取地理信息");
        }
        try {
            addList = geocoder.getFromLocation(lat, lng, 1);    //解析经纬度
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (addList != null && addList.size() > 0) {
            for (int i = 0; i < addList.size(); i++) {
                Address add = addList.get(i);
                mcityName += add.getLocality();
            }
        }
        if (mcityName.length() != 0) {
            return mcityName.substring(0, (mcityName.length() - 1));
        } else {
            return mcityName;
        }
    }

    public static String getPostalCode(Context c) {
        LocationManager locationManager = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        Geocoder geocoder = new Geocoder(c);
        String provider = LocationManager.NETWORK_PROVIDER;
        //通过最后一次的地理位置来获得Location对象
//		if (!checkPermission(isScreenOn,Manifest.permission.ACCESS_FINE_LOCATION) && !checkPermission(isScreenOn,Manifest.permission.ACCESS_COARSE_LOCATION)) {
//			return "116";
//		}
        if (!PermissionUtils.checkPermission(c, PermissionUtils.PERMISSION_LOCATION)) {
            return "116";
        }
        Location location = null;
        if (!TextUtils.isEmpty(provider)) {
            location = locationManager.getLastKnownLocation(provider);
        }
        String postal = "";
        double lat = 0;
        double lng = 0;
        List<Address> addresses = null;
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
        } else {
            System.out.println("无法获取地理信息");
        }
        if (lat != 0 && lng != 0)
//			try {
//				addresses=geocoder.getFromLocation(lat, lng, 1);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}


            if (addresses != null && addresses.size() > 0) {
                for (int i = 0; i < addresses.size(); i++) {
                    Address address = addresses.get(i);
                    postal += address.getPostalCode();
                }
            }
        return postal;
    }

    //获取控件高度
    public static int getViewHeight(View v) {
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        v.measure(w, h);
        int height = v.getMeasuredHeight();
        return height;
    }

    //-------------------------------------------------------------------
    public static String getAppVersion(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getVersionChannel(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(c.getPackageName(), PackageManager.GET_META_DATA);
            String channel = String.valueOf(info.metaData.get("DONEWS_CHANNEL"));
            return channel;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getAppKey(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(c.getPackageName(), PackageManager.GET_META_DATA);
            String channel = String.valueOf(info.metaData.get("DONEWS_KEY"));
            return channel;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getInvenoAppName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String channel = String.valueOf(info.metaData.get("INVENO_APPNAME"));
            return channel;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getInvenoAppId(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            String channel = String.valueOf(info.metaData.get("INVENO_APPID"));
            return channel;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDeviceSDK() {
        return Build.VERSION.SDK;
    }

    public static int getDeviceSDK_INT() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDisplay(Context c) {
        return getScreenWidth(c) + "x" + getScreenHeight(c);
    }

    public static String getCarrierName(Context c) {
        String ProvidersName = "0";
        try {

            TelephonyManager telephonyManager = (TelephonyManager) c
                    .getSystemService(Context.TELEPHONY_SERVICE);
            // 返回唯一的用户ID;就是这张卡的编号神马的
            @SuppressLint("MissingPermission") String IMSI = telephonyManager.getSubscriberId();
            // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
            if (!TextUtils.isEmpty(IMSI)) {
                if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
                    ProvidersName = "70120";
                } else if (IMSI.startsWith("46001")) {
                    ProvidersName = "70123";
                } else if (IMSI.startsWith("46003")) {
                    ProvidersName = "70121";
                }
            }
        } catch (Exception e) {

        }
        return ProvidersName;
    }

    public static String getProvidersName(Context c) {
        String ProvidersName = "";
//        TelephonyManager telephonyManager = (TelephonyManager) isScreenOn
//                .getSystemService(Context.TELEPHONY_SERVICE);
//        // 返回唯一的用户ID;就是这张卡的编号神马的
//        String IMSI = telephonyManager.getSubscriberId();
//        // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
//        if(!TextUtils.isEmpty(IMSI)) {
//            if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
//                ProvidersName = "cmcc";
//            } else if (IMSI.startsWith("46001")) {
//                ProvidersName = "unicom";
//            } else if (IMSI.startsWith("46003")) {
//                ProvidersName = "chinaNet";
//            }
//        }
        TelephonyManager telManager = (TelephonyManager) c.getSystemService(Context.TELEPHONY_SERVICE);
        String operator = telManager.getSimOperator();
        if (!TextUtils.isEmpty(operator)) {
//			if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
//				ProvidersName = "中国移动";//中国移动
//			} else if (operator.equals("46001")) {
//				ProvidersName = "中国联通";//中国联通
//			} else if (operator.equals("46003")) {
//				ProvidersName = "中国电信";//中国电信
//			}
            ProvidersName = operator.substring(0, 3) + "#" + operator.substring(3, operator.length());
        }
        return ProvidersName;
    }

    /**
     * 获取手机mac地址 错误返回12个0
     */
    public static String getMacAddress(Context context) {
        // 获取mac地址：
        String macAddress = "02:00:00:00:00:00";
        try {
            WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
            if (null != info) {
                if (!TextUtils.isEmpty(info.getMacAddress()))
                    macAddress = info.getMacAddress().replace(":", "");
                else
                    return macAddress;
            }
        } catch (Exception e) {
            return macAddress;
        }

        return macAddress;
    }

    public static String getMacAddress2(Context context) {
        // 获取mac地址：
        String macAddress = "02:00:00:00:00:00";
        try {
            WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
            if (null != info) {
                if (!TextUtils.isEmpty(info.getMacAddress()))
                    macAddress = info.getMacAddress();
                else
                    return macAddress;
            }
        } catch (Exception e) {
            return macAddress;
        }

        return macAddress;
    }

    public static String getPkg(Context c) {
        try {
            String pkName = c.getPackageName();
            return pkName;
        } catch (Exception e) {
        }
        return "";
    }

    public static String getNetType(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        String type = "";
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                type = "WIFI";
            }
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        type = "2G";
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
                        type = "3G";
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        type = "4G";
                        break;
                    case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                    default:
                        type = "蜂窝数据-未知";
                        break;
                }
            }
        }
        return type;
    }

    public static int getNetTypeInt(Context c) {
        ConnectivityManager cm = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        int type = 0;
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                type = 1;
            }
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                switch (info.getSubtype()) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN:
                        type = 2;
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
                        type = 3;
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        type = 4;
                        break;
                    case TelephonyManager.NETWORK_TYPE_UNKNOWN:
                    default:
                        type = 0;
                        break;
                }
            }
        }
        return type;
    }

    // View宽，高
    public static int[] getLocation(View v) {
        int[] loc = new int[4];
        int[] location = new int[2];
        v.getLocationInWindow(location);
        loc[0] = location[0];
        loc[1] = location[1];
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        v.measure(w, h);

        loc[2] = v.getMeasuredWidth();
        loc[3] = v.getMeasuredHeight();
        Log.e("location", "LLL" + loc[0] + "," + loc[1] + "," + loc[2] + "," + loc[3]);
        return loc;
    }

    public static int bannerHeight(Context c) {
        int bannerHeight = 100;
        int screenWidth = PhoneInfoUtils.getScreenWidth(c);
        if (screenWidth < 800) {
            bannerHeight = 100;
        } else {
            bannerHeight = 166;
        }
        return bannerHeight;
    }

    public static int bannerWidth(Context c) {
        int screenWidth = PhoneInfoUtils.getScreenWidth(c);
        int bannerWidth = 640;
        if (screenWidth < 800) {
            bannerWidth = 640;
        } else {
            bannerWidth = 1080;
        }
        return bannerWidth;
    }

    public static boolean isViewCovered(Context context, final View view) {
        View currentView = view;

        Rect currentViewRect = new Rect();
        boolean partVisible = currentView.getGlobalVisibleRect(currentViewRect);
        boolean totalHeightVisible = (currentViewRect.bottom - currentViewRect.top) >= bannerHeight(context);
        boolean totalWidthVisible = (currentViewRect.right - currentViewRect.left) >= bannerWidth(context);
        boolean totalViewVisible = partVisible && totalHeightVisible && totalWidthVisible;
        if (!totalViewVisible) {//if any part of the view is clipped by any of its parents,return true
            return true;
        }
        while (currentView.getParent() instanceof ViewGroup) {
            ViewGroup currentParent = (ViewGroup) currentView.getParent();
            if (currentParent.getVisibility() != View.VISIBLE) {//if the parent of view is not visible,return true
                return true;
            }

            int start = indexOfViewInParent(currentView, currentParent);
            for (int i = start + 1; i < currentParent.getChildCount(); i++) {
                Rect viewRect = new Rect();
                view.getGlobalVisibleRect(viewRect);
                View otherView = currentParent.getChildAt(i);
                Rect otherViewRect = new Rect();
                otherView.getGlobalVisibleRect(otherViewRect);
                if (Rect.intersects(viewRect, otherViewRect)) {//if view intersects its older brother(covered),return true

                    return true;
                }
            }
            currentView = currentParent;
        }
        return false;
    }


    private static int indexOfViewInParent(View view, ViewGroup parent) {
        int index;
        for (index = 0; index < parent.getChildCount(); index++) {
            if (parent.getChildAt(index) == view)
                break;
        }
        return index;
    }

    public static boolean classJPushExit() {
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            return false;
        }
    }

    /**
     * 判断activity是否存在
     *
     * @param activity
     * @return
     */
    public static boolean isLiving(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }

        if (activity.isFinishing()) {
            return false;
        }
        return true;
    }

    /**
     * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
     *
     * @param context
     * @return 平板返回 True，手机返回 False
     */
    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}
