/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ToolUtils {
    public static boolean a = false;
    public static boolean b = false;
    private static String c = null;

    @SuppressLint("WrongConstant")
    public static Intent a(Context var0, String var1) {
        Intent var2 = var0.getPackageManager().getLaunchIntentForPackage(var1);
        if (var2 == null) {
            return null;
        } else {
            if (!var2.hasCategory("android.intent.category.LAUNCHER")) {
                var2.addCategory("android.intent.category.LAUNCHER");
            }

            var2.setPackage((String)null);
            var2.addFlags(2097152);
            var2.addFlags(268435456);
            return var2;
        }
    }

    public static boolean b(Context var0, String var1) {
        boolean var2 = false;
        if (null != var0 && !StringUtils.isEmpty(var1)) {
            PackageManager var3 = var0.getPackageManager();

            try {
                if (var3.getPackageInfo(var1, 0) != null) {
                    var2 = true;
                }
            } catch (Exception var5) {
                ;
            }
        }

        return var2;
    }

    public static boolean a(Context var0, Intent var1) {
        if (var1 == null) {
            return false;
        } else {
            PackageManager var2 = var0.getPackageManager();
            List var3 = var2.queryIntentActivities(var1, 65536);
            return var3 != null && var3.size() > 0;
        }
    }

    public static boolean a() {
        boolean var0 = false;

        try {
            var0 = !StringUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei") || !StringUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        } catch (Throwable var2) {
            ;
        }

        return var0;
    }

    public static boolean a(String var0) {
        if (TextUtils.isEmpty(var0)) {
            var0 = b();
        }

        if (!TextUtils.isEmpty(var0) && var0.toLowerCase().startsWith("emotionui")) {
            return true;
        } else {
            return a();
        }
    }

    public static String b() {
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
            LogUtils.a("ToolUtils", "Unable to read sysprop " + var0, var14);
            var4 = var1;
        } finally {
            if (var2 != null) {
                try {
                    var2.close();
                } catch (IOException var13) {
                    LogUtils.a("ToolUtils", "Exception while closing InputStream", var13);
                }
            }

        }

        return (String)var4;
    }

    public static boolean c() {
        if (!b) {
            try {
                Class var0 = Class.forName("miui.os.Build");
                if (var0 != null) {
                    a = true;
                    b = true;
                    return a;
                }
            } catch (Exception var1) {
                ;
            }

            b = true;
        }

        return a;
    }

    public static boolean d() {
        return Build.DISPLAY.indexOf("Flyme") >= 0 || Build.USER.equals("flyme");
    }

    public static boolean c(Context var0, String var1) {
        boolean var2 = false;
        if (var0 != null && var1 != null && !StringUtils.isEmpty(var1)) {
            try {
                File var3 = new File(var1);
                if (var3.exists()) {
                    PackageManager var4 = var0.getPackageManager();
                    PackageInfo var5 = var4.getPackageArchiveInfo(var3.getAbsolutePath(), 1);
                    if (var5 == null) {
                        return var2;
                    }

                    String var6 = var5.packageName;
                    int var7 = var5.versionCode;
                    PackageInfo var8 = null;

                    try {
                        var8 = var0.getPackageManager().getPackageInfo(var6, 1);
                    } catch (PackageManager.NameNotFoundException var10) {
                        var8 = null;
                    }

                    if (var8 == null) {
                        var2 = false;
                    } else {
                        int var9 = var8.versionCode;
                        if (var7 <= var9) {
                            var2 = true;
                        }
                    }
                }
            } catch (Exception var11) {
                var11.printStackTrace();
            }

            return var2;
        } else {
            return var2;
        }
    }

    public static boolean d(Context var0, String var1) {
        if (var0 != null && !StringUtils.isEmpty(var1)) {
            try {
                ActivityManager var2 = (ActivityManager)var0.getSystemService("activity");
                List var3;
                if (Build.VERSION.SDK_INT < 21) {
                    var3 = var2.getRunningTasks(1);
                    if (!var3.isEmpty()) {
                        ComponentName var4 = ((ActivityManager.RunningTaskInfo)var3.get(0)).topActivity;
                        if (var4 != null && var1.equals(var4.getPackageName())) {
                            return true;
                        }
                    }
                } else {
                    var3 = var2.getRunningAppProcesses();
                    Iterator var7 = var3.iterator();

                    while(var7.hasNext()) {
                        ActivityManager.RunningAppProcessInfo var5 = (ActivityManager.RunningAppProcessInfo)var7.next();
                        if (var5.importance == 100) {
                            return var1.equals(var5.pkgList[0]);
                        }
                    }
                }

                return false;
            } catch (Exception var6) {
                return false;
            }
        } else {
            return false;
        }
    }

    @SuppressLint("WrongConstant")
    public static boolean e(Context var0, String var1) {
        if (var0 != null && !StringUtils.isEmpty(var1)) {
            try {
                Uri var2 = Uri.parse("tel:" + Uri.encode(var1));
                Intent var3 = new Intent("android.intent.action.DIAL", var2);
                if (!(var0 instanceof Activity)) {
                    var3.setFlags(268435456);
                }

                var0.startActivity(var3);
                return true;
            } catch (Exception var4) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean a(Context var0) {
        try {
            @SuppressLint("WrongConstant") ConnectivityManager var1 = (ConnectivityManager)var0.getSystemService("connectivity");
            NetworkInfo var2 = var1.getActiveNetworkInfo();
            return var2 != null && var2.isAvailable();
        } catch (Exception var3) {
            return false;
        }
    }

    @Nullable
    public static String b(Context var0) {
        if (var0 == null) {
            return null;
        } else {
            String var1 = var0.getPackageName();

            try {
                String var2 = var0.getPackageManager().getPackageInfo(var1, 0).versionName + "";
                return var2;
            } catch (Exception var3) {
                return null;
            }
        }
    }

    public static String a(long var0, String var2) throws ParseException {
        Date var3 = b(var0, var2);
        return a(var3, var2);
    }

    public static Date b(long var0, String var2) throws ParseException {
        Date var3 = new Date(var0);
        String var4 = a(var3, var2);
        return a(var4, var2);
    }

    public static String a(Date var0, String var1) {
        return (new SimpleDateFormat(var1)).format(var0);
    }

    public static Date a(String var0, String var1) throws ParseException {
        SimpleDateFormat var2 = new SimpleDateFormat(var1);
        return var2.parse(var0);
    }

    public static String a(int var0) {
        switch(var0) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            default:
                return null;
        }
    }

    public static JSONObject b(String var0) {
        JSONObject var1 = null;
        if (var0 != null) {
            try {
                var1 = new JSONObject(var0);
            } catch (JSONException var3) {
                var3.printStackTrace();
            }
        }

        return var1;
    }

    public static void a(@NonNull h var0, @NonNull View var1) {
        JSONObject var2 = b(var0.o());
        if (var2 != null) {
            int var3 = var2.optInt("rit", 0);
            String var4 = var2.optString("req_id", "");
            n.c().a(var3, var4, var0.l(), ViewWather.d(var1.getRootView()));
        }

    }

    public static String e() {
        String var0 = "";

        try {
            var0 = System.getProperty("http.agent");
        } catch (Exception var5) {
            var0 = "unKnow";
        }

        StringBuffer var1 = new StringBuffer();
        if (var0 == null) {
            return "";
        } else {
            int var2 = 0;

            for(int var3 = var0.length(); var2 < var3; ++var2) {
                char var4 = var0.charAt(var2);
                if (var4 > 31 && var4 < 127) {
                    var1.append(var4);
                } else {
                    var1.append(String.format("\\u%04x", Integer.valueOf(var4)));
                }
            }

            return var1.toString();
        }
    }

    public static String f() {
        return UUID.randomUUID().toString();
    }
}
