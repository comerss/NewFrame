package com.liangyibang.baselibrary.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import android.support.v4.content.PermissionChecker;
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

/**
 * Created by Comers on 2018/5/28.
 * 描述：
 */
public class PhoneInfoUtils {
    public PhoneInfoUtils() {
    }

    public static String getPhoneNumber(Context c) {
        TelephonyManager tm = (TelephonyManager)c.getSystemService("phone");
        if (tm == null) {
            return "";
        } else {
            String number = tm.getLine1Number();
            return TextUtils.isEmpty(number) ? "" : number;
        }
    }

    /*public static String getMeid(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService("phone");
        if (tm == null) {
            return "";
        } else {
            if (Build.VERSION.SDK_INT > 22) {
                PermissionChecker permissionChecker = new PermissionChecker(context);
//                if (permissionChecker.lacksPermissions(PermissionChecker.PERMISSIONS_PHONE)) {
                    return "";
                }
            }

            String meid = "";
            if (Build.VERSION.SDK_INT >= 23) {
                if (!TextUtils.isEmpty(tm.getDeviceId(0))) {
                    meid = tm.getDeviceId(0);
                    if (!TextUtils.isEmpty(tm.getDeviceId(1))) {
                        meid = meid + "," + tm.getDeviceId(1);
                    }
                }
            } else {
                meid = tm.getDeviceId();
            }

            return meid;
        }
    }*/

   /* public static String getIMEI(Context c) {
        TelephonyManager tm = (TelephonyManager)c.getSystemService("phone");
        if (tm == null) {
            return "";
        } else {
            String imei = "";
            if (Build.VERSION.SDK_INT > 22) {
                PermissionChecker permissionChecker = new PermissionChecker(c);
                if (permissionChecker.lacksPermissions(PermissionChecker.PERMISSIONS_PHONE)) {
                    imei = "";
                } else {
                    imei = tm.getDeviceId();
                }
            } else {
                imei = tm.getDeviceId();
            }

            return imei;
        }
    }*/

    /*public static String getIMSI(Context c) {
        TelephonyManager tm = (TelephonyManager)c.getSystemService("phone");
        if (tm == null) {
            return "未知";
        } else {
            String imsi = "未知";
            if (Build.VERSION.SDK_INT > 22) {
                PermissionChecker permissionChecker = new PermissionChecker(c);
                if (permissionChecker.lacksPermissions(PermissionChecker.PERMISSIONS_PHONE)) {
                    imsi = "未知";
                } else {
                    imsi = tm.getSubscriberId();
                }
            } else {
                imsi = tm.getSubscriberId();
            }

            return imsi;
        }
    }*/

/*    public static String getPhoneModel(Context c) {
        String model = (String)SPUtils.get(c, "phone_model", "");
        if (TextUtils.isEmpty(model)) {
            model = Build.MODEL;
            SPUtils.put(c, "phone_model", model);
        }

        return model;
    }*/

    public static String getRelease() {
        return Build.VERSION.RELEASE;
    }

    public static int getSDK() {
        return Build.VERSION.SDK_INT;
    }

    public static String getVersion(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception var4) {
            return "2.0";
        }
    }

    public static String getVersionCode(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = String.valueOf(info.versionCode);
            return version;
        } catch (Exception var4) {
            return "110";
        }
    }

    public static String getAndroidID(Activity activity) {
        String ANDROID_ID = Settings.System.getString(activity.getContentResolver(), "android_id");
        return ANDROID_ID;
    }

    public static String getIsTabletDevice(Context context) {
        String device = "";
        if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
            device = "5";
        } else {
            device = "2";
        }

        return device;
    }

    public static String getMyUUID(Context c) {
        String uniqueId = "";//(String)SPUtils.get(c, "uuid", "");
        if (TextUtils.isEmpty(uniqueId)) {
            TelephonyManager tm = (TelephonyManager)c.getSystemService("phone");
            if (tm == null) {
                uniqueId = getID();
//                SPUtils.put(c, "uuid", uniqueId);
                return uniqueId;
            } else {
                String tmDevice = "" + tm.getDeviceId();
                String tmSerial = "" + tm.getSimSerialNumber();
                String androidId = "" + Settings.Secure.getString(c.getContentResolver(), "android_id");
                UUID deviceUuid = new UUID((long)androidId.hashCode(), (long)tmDevice.hashCode() << 32 | (long)tmSerial.hashCode());
                uniqueId = deviceUuid.toString();
//                SPUtils.put(c, "uuid", uniqueId);
                return uniqueId;
            }
        } else {
            return uniqueId;
        }
    }

    public static String toUtf8(String str) {
        String result = null;

        try {
            result = new String(str.getBytes("UTF-8"), "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }

        return result;
    }

    public static String getAppName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;

        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException var4) {
            applicationInfo = null;
        }

        String applicationName = (String)packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    public static String getID() {
        String m_szDevIDShort = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
        return m_szDevIDShort;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration en = NetworkInterface.getNetworkInterfaces();

            while(en.hasMoreElements()) {
                NetworkInterface intf = (NetworkInterface)en.nextElement();
                Enumeration enumIpAddr = intf.getInetAddresses();

                while(enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress)enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException var4) {
            ;
        }

        return null;
    }

    /*public static String getLocalIpAddress(Context context) {
        String ip = (String)SPUtils.get(context, "cur_ip", "");
        if (TextUtils.isEmpty(ip)) {
            AUtils.getIp(context, "");
        }

        return ip;
    }*/

    public static int getScreenWidth(Context c) {
        int width = 0;//(Integer)SPUtils.get(c, "phone_width", 0);
        if (width == 0) {
            WindowManager wm = (WindowManager)c.getSystemService("window");
            width = wm.getDefaultDisplay().getWidth();
//            SPUtils.put(c, "phone_width", width);
        }

        return width;
    }

    public static int getScreenHeight(Context c) {
        int height = 0;//(Integer)SPUtils.get(c, "phone_height", 0);
        if (height == 0) {
            WindowManager wm = (WindowManager)c.getSystemService("window");
            height = wm.getDefaultDisplay().getHeight();
//            SPUtils.put(c, "phone_height", height);
        }

        return height;
    }

    public static String getUserAgent(Context c) {
        WebView webview = new WebView(c);
        webview.layout(0, 0, 0, 0);
        WebSettings settings = webview.getSettings();
        return settings.getUserAgentString();
    }

    public static String getMake() {
        return Build.MANUFACTURER;
    }

    public static String getLang() {
        return Locale.getDefault().getLanguage();
    }

    @TargetApi(17)
    public static String getPPI(Activity c) {
        if (Build.VERSION.SDK_INT >= 17) {
            Point point = new Point();
            c.getWindowManager().getDefaultDisplay().getRealSize(point);
            DisplayMetrics dm = c.getResources().getDisplayMetrics();
            double x = Math.pow((double)((float)point.x / dm.xdpi), 2.0D);
            double y = Math.pow((double)((float)point.y / dm.ydpi), 2.0D);
            double screenInches = Math.sqrt(x + y);
            return screenInches + "";
        } else {
            return "";
        }
    }

    public static float getDensity(Context c) {
        new DisplayMetrics();
        DisplayMetrics dm = c.getResources().getDisplayMetrics();
        return dm.density;
    }

    public static int getOriatation(Context context) {
        return context.getResources().getConfiguration().orientation == 1 ? 1 : 2;
    }

    public static String getCountryId(Context context) {
        return context.getResources().getConfiguration().locale.getISO3Country();
    }

    private static boolean checkPermission(Context c, String permission) {
        PackageManager pm = c.getPackageManager();
        boolean hasPermission = 0 == pm.checkPermission(permission, c.getPackageName());
        return hasPermission;
    }

    public static String getProvider(Context c) {
        LocationManager locationManager = (LocationManager)c.getSystemService("location");
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(3);
        criteria.setSpeedRequired(true);
        String provider = locationManager.getBestProvider(criteria, true);
        return provider;
    }

    public static String getLocLong(Context context) {
        LocationManager locationManager = (LocationManager)context.getSystemService("location");
        String provider = getProvider(context);
        if (!checkPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "0.0";
        } else {
            Location location = null;
            if (!TextUtils.isEmpty(provider)) {
                location = locationManager.getLastKnownLocation(provider);
            }

            String lon = "116°21′59″";
            if (location != null) {
                lon = location.getLongitude() + "";
            }

            return lon;
        }
    }

    public static String getLocLat(Context context) {
        LocationManager locationManager = (LocationManager)context.getSystemService("location");
        String provider = getProvider(context);
        if (checkPermission(context, "android.permission.ACCESS_FINE_LOCATION") && checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            Location location = null;
            if (!TextUtils.isEmpty(provider)) {
                location = locationManager.getLastKnownLocation(provider);
            }

            String lat = "46°1′46″";
            if (location != null) {
                lat = location.getLatitude() + "";
            }

            return lat;
        } else {
            return "0.0";
        }
    }

    public static String getCityId(Context context) {
        Geocoder geocoder = new Geocoder(context);
        LocationManager locationManager = (LocationManager)context.getSystemService("location");
        String provider = "network";
        if (!checkPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "";
        } else {
            Location location = null;
            if (!TextUtils.isEmpty(provider)) {
                location = locationManager.getLastKnownLocation(provider);
            }

            String mcityName = "";
            double lat = 0.0D;
            double lng = 0.0D;
            List<Address> addList = null;
            if (location != null) {
                lat = location.getLatitude();
                lng = location.getLongitude();
            }

            try {
                addList = geocoder.getFromLocation(lat, lng, 1);
            } catch (IOException var13) {
                var13.printStackTrace();
            }

            if (addList != null && addList.size() > 0) {
                for(int i = 0; i < addList.size(); ++i) {
                    Address add = (Address)addList.get(i);
                    mcityName = mcityName + add.getLocality();
                }
            }

            return mcityName.length() != 0 ? mcityName.substring(0, mcityName.length() - 1) : mcityName;
        }
    }

    public static String getPostalCode(Context c) {
        LocationManager locationManager = (LocationManager)c.getSystemService("location");
        new Geocoder(c);
        String provider = "network";
        if (!checkPermission(c, "android.permission.ACCESS_FINE_LOCATION") && !checkPermission(c, "android.permission.ACCESS_COARSE_LOCATION")) {
            return "116";
        } else {
            Location location = null;
            if (!TextUtils.isEmpty(provider)) {
                location = locationManager.getLastKnownLocation(provider);
            }

            String postal = "";
            double lat = 0.0D;
            double lng = 0.0D;
            List<Address> addresses = null;
            if (location != null) {
                lat = location.getLatitude();
                lng = location.getLongitude();
            } else {
                java.lang.System.out.println("无法获取地理信息");
            }

            if (lat != 0.0D && lng != 0.0D && addresses != null && ((List)addresses).size() > 0) {
                for(int i = 0; i < ((List)addresses).size(); ++i) {
                    Address address = (Address)((List)addresses).get(i);
                    postal = postal + address.getPostalCode();
                }
            }

            return postal;
        }
    }

    public static int getViewHeight(View v) {
        int w = View.MeasureSpec.makeMeasureSpec(0, 0);
        int h = View.MeasureSpec.makeMeasureSpec(0, 0);
        v.measure(w, h);
        int height = v.getMeasuredHeight();
        return height;
    }

    public static String getAppVersion(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            PackageInfo info = manager.getPackageInfo(c.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception var4) {
            return "";
        }
    }

    public static String getVersionChannel(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(c.getPackageName(), 128);
            String channel = String.valueOf(info.metaData.get("DONEWS_CHANNEL"));
            return channel;
        } catch (Exception var4) {
            return "";
        }
    }

    public static String getAppKey(Context c) {
        try {
            PackageManager manager = c.getPackageManager();
            ApplicationInfo info = manager.getApplicationInfo(c.getPackageName(), 128);
            String channel = String.valueOf(info.metaData.get("DONEWS_KEY"));
            return channel;
        } catch (Exception var4) {
            return "";
        }
    }

    public static String getDeviceType() {
        return Build.MODEL;
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

    public static String getProvidersName(Context c) {
        String ProvidersName = "";
        TelephonyManager telManager = (TelephonyManager)c.getSystemService("phone");
        String operator = telManager.getSimOperator();
        if (!TextUtils.isEmpty(operator)) {
            ProvidersName = operator.substring(0, 3) + "#" + operator.substring(3, operator.length());
        }

        return ProvidersName;
    }

    public static String getMacAddress(Context context) {
        String macAddress = "";

        try {
            WifiManager wifiMgr = (WifiManager)context.getSystemService("wifi");
            @SuppressLint("MissingPermission") WifiInfo info = null == wifiMgr ? null : wifiMgr.getConnectionInfo();
            if (null != info) {
                if (TextUtils.isEmpty(info.getMacAddress())) {
                    return macAddress;
                }

                macAddress = info.getMacAddress().replace(":", "");
            }

            return macAddress;
        } catch (Exception var4) {
            return macAddress;
        }
    }

    public static String getPkg(Context c) {
        try {
            String pkName = c.getPackageName();
            return pkName;
        } catch (Exception var2) {
            return "";
        }
    }

    public static String getNetType(Context c) {
        ConnectivityManager cm = (ConnectivityManager)c.getSystemService("connectivity");
        NetworkInfo info = cm.getActiveNetworkInfo();
        String type = "";
        if (info != null) {
            if (info.getType() == 1) {
                type = "WIFI";
            }

            if (info.getType() == 0) {
                switch(info.getSubtype()) {
                    case 0:
                    default:
                        type = "蜂窝数据-未知";
                        break;
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        type = "2G";
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        type = "3G";
                        break;
                    case 13:
                        type = "4G";
                }
            }
        }

        return type;
    }

    public static int[] getLocation(View v) {
        int[] loc = new int[4];
        int[] location = new int[2];
        v.getLocationInWindow(location);
        loc[0] = location[0];
        loc[1] = location[1];
        int w = View.MeasureSpec.makeMeasureSpec(0, 0);
        int h = View.MeasureSpec.makeMeasureSpec(0, 0);
        v.measure(w, h);
        loc[2] = v.getMeasuredWidth();
        loc[3] = v.getMeasuredHeight();
        Log.e("location", "LLL" + loc[0] + "," + loc[1] + "," + loc[2] + "," + loc[3]);
        return loc;
    }

    public static int bannerHeight(Context c) {
        int screenWidth = getScreenWidth(c);
        short bannerHeight;
        if (screenWidth < 800) {
            bannerHeight = 100;
        } else {
            bannerHeight = 166;
        }

        return bannerHeight;
    }

    public static int bannerWidth(Context c) {
        int screenWidth = getScreenWidth(c);
        short bannerWidth;
        if (screenWidth < 800) {
            bannerWidth = 640;
        } else {
            bannerWidth = 1080;
        }

        return bannerWidth;
    }

    public static boolean isViewCovered(Context context, View view) {
        View currentView = view;
        Rect currentViewRect = new Rect();
        boolean partVisible = view.getGlobalVisibleRect(currentViewRect);
        boolean totalHeightVisible = currentViewRect.bottom - currentViewRect.top >= bannerHeight(context);
        boolean totalWidthVisible = currentViewRect.right - currentViewRect.left >= bannerWidth(context);
        boolean totalViewVisible = partVisible && totalHeightVisible && totalWidthVisible;
        if (!totalViewVisible) {
            return true;
        } else {
            while(((View)currentView).getParent() instanceof ViewGroup) {
                ViewGroup currentParent = (ViewGroup)((View)currentView).getParent();
                if (currentParent.getVisibility() != 0) {
                    return true;
                }

                int start = indexOfViewInParent((View)currentView, currentParent);

                for(int i = start + 1; i < currentParent.getChildCount(); ++i) {
                    Rect viewRect = new Rect();
                    view.getGlobalVisibleRect(viewRect);
                    View otherView = currentParent.getChildAt(i);
                    Rect otherViewRect = new Rect();
                    otherView.getGlobalVisibleRect(otherViewRect);
                    if (Rect.intersects(viewRect, otherViewRect)) {
                        return true;
                    }
                }

                currentView = currentParent;
            }

            return false;
        }
    }

    private static int indexOfViewInParent(View view, ViewGroup parent) {
        int index;
        for(index = 0; index < parent.getChildCount() && parent.getChildAt(index) != view; ++index) {
            ;
        }

        return index;
    }

    public static boolean classJPushExit() {
        try {
            Class.forName("cn.jpush.android.api.JPushInterface");
            return true;
        } catch (ClassNotFoundException var1) {
            return false;
        }
    }

    public static boolean isLiving(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            return !activity.isFinishing();
        } else {
            return false;
        }
    }
}
