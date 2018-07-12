package com.donews.frame.sdk;

/**
 * Created by 79653 on 2018/7/5.
 * 描述：
 */
//
// Source code recreated from UIUtils .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.comers.baselibrary.utils.SharedHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Utils {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static boolean j;
    private static boolean k;

    public Utils() {
    }

    private static Context k(Context var0) {
        return var0 ;
    }

    public static String a(Context var0) {
        if (TextUtils.isEmpty(a) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return a;
    }

    public static String b(Context var0) {
        if (h == null && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return h;
    }

    public static String c(Context var0) {
        if (TextUtils.isEmpty(b) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return b;
    }

    public static String d(Context var0) {
        if (TextUtils.isEmpty(c) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return c;
    }

    public static String e(Context var0) {
        if (TextUtils.isEmpty(i) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return i;
    }

    public static String f(Context var0) {
        if (TextUtils.isEmpty(f) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return f;
    }

    public static String g(Context var0) {
        if (TextUtils.isEmpty(d) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return d;
    }

    public static String h(Context var0) {
        if (TextUtils.isEmpty(g) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return g;
    }

    public static String i(Context var0) {
        if (TextUtils.isEmpty(e) && !j) {
            Class var1 = Utils.class;
            synchronized(Utils.class) {
                if (!j) {
                    l(var0);
                }
            }
        }

        return e;
    }

    public static void a(Context var0, String var1) {
        if (!TextUtils.isEmpty(var1) && !var1.equals(a)) {
            SharedHelper.put("did", var1);
            a = var1;
        }

    }

    @RequiresPermission(
            anyOf = {"android.permission.ACCESS_WIFI_STATE"}
    )
    private static void l(Context var0) {
        if (!j) {
            Context var1 = k(var0);
            if (var1 != null) {
                try {
                    TelephonyManager var2 = (TelephonyManager)var1.getSystemService("phone");
                    c = var2.getDeviceId();
                    f = var2.getSubscriberId();
                } catch (Exception var5) {
                    ;
                }

                try {
                    WifiManager var6 = (WifiManager)var1.getSystemService("wifi");
                    WifiInfo var3 = var6.getConnectionInfo();
                    if (var3 != null) {
                        d = var3.getSSID();
                        e = var3.getMacAddress();
                    }
                } catch (Exception var4) {
                    ;
                }

                b = a(var1, true);
                a = SharedHelper.get("did", (String)null);
                g = a();
                h = b();
                i =SharedHelper.get("uuid", (String)null);
                j = true;
            }
        }
    }

    public static void j(Context var0) {
        if (!k) {
            Context var1 = k(var0);
            if (var1 != null) {
                try {
                    TelephonyManager var2 = (TelephonyManager)var1.getSystemService("phone");
                    c = var2.getDeviceId();
                    f = var2.getSubscriberId();
                    k = true;
                } catch (Exception var3) {

                }

            }
        }
    }

    @SuppressLint({"TrulyRandom"})
    private static synchronized String a(Context var0, boolean var1) {
        Context var2 = k(var0);
        if (var2 == null) {
            return null;
        } else {
            String var3 = null;

            try {
                var3 = Secure.getString(var2.getContentResolver(), "android_id");
            } catch (Exception var9) {
                ;
            }

            try {
                if (var3 == null || var3.equals("9774d56d682e549c") || var3.length() < 13) {
//                    PhoneUtils var4 = com.bytedance.sdk.openadsdk.core.PhoneUtils.UIUtils(var2);
                    String var5 = SharedHelper.get("openudid", (String)null);
                    if (!a(var5)) {
                        SecureRandom var6 = new SecureRandom();
                        var5 = (new BigInteger(64, var6)).toString(16);
                        if (var5.charAt(0) == '-') {
                            var5 = var5.substring(1);
                        }

                        int var7 = 13 - var5.length();
                        if (var7 > 0) {
                            StringBuilder var8;
                            for(var8 = new StringBuilder(); var7 > 0; --var7) {
                                var8.append('F');
                            }

                            var8.append(var5);
                            var5 = var8.toString();
                        }

                        if (var1) {
                            String var11 = a("openudid.dat", var5);
                            if (a(var11)) {
                                var5 = var11;
                            }
                        }

                        SharedHelper.put("openudid", var5);
                    }

                    var3 = var5;
                }
            } catch (Exception var10) {
                ;
            }

            return var3;
        }
    }

    private static String a(String var0, String var1) {
        String var2 = Environment.getExternalStorageState();
        if (!"mounted".equals(var2)) {
            return var1;
        } else {
            String var3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
            String var4 = var3 + "/" + var0;
            FileLock var5 = null;
            RandomAccessFile var6 = null;

            String var8;
            try {
                File var7 = new File(var3);
                if (var7.exists() || var7.mkdirs()) {
                    File var33 = new File(var4);
                    var6 = new RandomAccessFile(var33, "rwd");
                    var5 = var6.getChannel().lock();
                    if (var33.isFile()) {
                        short var9 = 129;
                        byte[] var10 = new byte[var9];
                        int var11 = var6.read(var10, 0, var9);
                        if (var11 > 0 && var11 < var9) {
                            String var12 = new String(var10, 0, var11, "UTF-8");
                            if (a(var12)) {
                                String var13 = var12;
                                return var13;
                            }
                        }
                    }

                    byte[] var34 = var1.getBytes("UTF-8");
                    var6.setLength(0L);
                    var6.write(var34);
                    String var35 = var1;
                    return var35;
                }

                var8 = var1;
            } catch (Exception var31) {
                return var1;
            } finally {
                try {
                    if (var5 != null) {
                        var5.release();
                    }
                } catch (Exception var30) {
                    ;
                }

                try {
                    if (var6 != null) {
                        var6.close();
                    }
                } catch (Exception var29) {
                    ;
                }

            }

            return var8;
        }
    }

    private static boolean a(String var0) {
        if (var0 == null) {
            return false;
        } else {
            int var1 = var0.length();
            if (var1 >= 13 && var1 <= 128) {
                for(int var2 = 0; var2 < var1; ++var2) {
                    char var3 = var0.charAt(var2);
                    if ((var3 < '0' || var3 > '9') && (var3 < 'a' || var3 > 'f') && (var3 < 'A' || var3 > 'F') && var3 != '-') {
                        return false;
                    }
                }

                return true;
            } else {
                return false;
            }
        }
    }
    public static boolean isHuawei() {
        boolean var0 = false;

        try {
            var0 =  Build.BRAND.toLowerCase().startsWith("huawei") || Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        } catch (Throwable var2) {
            ;
        }

        return var0;
    }
    public static boolean so(String var0) {
        if (TextUtils.isEmpty(var0)) {
            var0 = b();
        }

        if (!TextUtils.isEmpty(var0) && var0.toLowerCase().startsWith("emotionui")) {
            return true;
        } else {
            return isHuawei();
        }
    }
    private static String a() {
        StringBuilder var0 = new StringBuilder();

        try {
            if (isMiui()) {
                var0.append("MIUI-");
            } else if (isFlyme()) {
                var0.append("FLYME-");
            } else {
                String var1 = isEMUI();
                if (so(var1)) {
                    var0.append("EMUI-");
                }

                if (!TextUtils.isEmpty(var1)) {
                    var0.append(var1).append("-");
                }
            }

            var0.append(VERSION.INCREMENTAL);
        } catch (Exception var2) {
            ;
        }

        return var0.toString();
    }
    public static String isEMUI() {
        return c("ro.build.version.emui");
    }
    private static String c(String var0) {
        String var1 = null;
        BufferedReader var2 = null;

        Object var4;
        try {
            Process var3 = Runtime.getRuntime().exec("getprop " + var0);
            var2 = new BufferedReader(new InputStreamReader(var3.getInputStream()), 1024);
            var1 = var2.readLine();
            var2.close();
            return var1;
        } catch (Throwable var14) {
//            LogUtils.UIUtils("ToolUtils", "Unable to read sysprop " + var0, var14);
            var4 = var1;
        } finally {
            if (var2 != null) {
                try {
                    var2.close();
                } catch (IOException var13) {
//                    LogUtils.UIUtils("ToolUtils", "Exception while closing InputStream", var13);
                }
            }

        }

        return (String)var4;
    }
    public static boolean isFlyme(){
        return Build.DISPLAY.indexOf("Flyme") >= 0 || Build.USER.equals("flyme");
    }
    public static boolean isMiui() {
        if (true) {
            try {
                Class var0 = Class.forName("miui.os.Build");
                if (var0 != null) {
                    return true;
                }
            } catch (Exception var1) {
                return false;
            }
        }
        return false;
    }
    public static boolean c() {
        return d().toLowerCase().contains("oneplus");
    }

    public static String d() {
        return Build.MANUFACTURER != null ? Build.MANUFACTURER.trim() : "unKnow";
    }
    private static String b() {
        String var0 = "/proc/version";
        if (c() && VERSION.SDK_INT > 24) {
            return "";
        } else {
            try {
                FileReader var2 = new FileReader(var0);
                BufferedReader var3 = new BufferedReader(var2, 8192);
                String[] var1 = var3.readLine().split("\\s+");
                if (var1 != null && var1.length >= 6) {
                    StringBuilder var4 = new StringBuilder();

                    for(int var5 = var1.length - 1; var5 >= var1.length - 6 && var5 >= 0; --var5) {
                        var4.insert(0, var1[var5] + " ");
                    }

                    var3.close();
                    String var8 = var4.toString().trim();
                    SimpleDateFormat var6 = new SimpleDateFormat("EEE MMM doParams HH:mm:ss z yyyy", Locale.US);
                    var6.parse(var8);
                    return var8;
                } else {
                    return "";
                }
            } catch (Exception var7) {
                return "";
            }
        }
    }
}

