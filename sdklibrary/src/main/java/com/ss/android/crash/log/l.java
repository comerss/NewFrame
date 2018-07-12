//
// Source code recreated from aa .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ss.android.crash.log;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class l {
    private static String a = null;
    private static Set<String> b = new HashSet();
    private static Set<String> c = new HashSet();

    static boolean a(Context var0) {
        String var1 = b(var0);
        if (var1 != null && var1.contains(":")) {
            return false;
        } else {
            return var1 != null && var1.equals(var0.getPackageName());
        }
    }

    static String b(Context var0) {
        String var1 = a;
        if (!TextUtils.isEmpty(var1)) {
            return var1;
        } else {
            try {
                int var2 = Process.myPid();
                @SuppressLint("WrongConstant") ActivityManager var3 = (ActivityManager)var0.getSystemService("activity");
                Iterator var4 = var3.getRunningAppProcesses().iterator();

                while(var4.hasNext()) {
                    RunningAppProcessInfo var5 = (RunningAppProcessInfo)var4.next();
                    if (var5.pid == var2) {
                        a = var5.processName;
                        return a;
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            a = a();
            return a;
        }
    }

    private static String a() {
        BufferedReader var0 = null;

        try {
            var0 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            StringBuilder var2 = new StringBuilder();

            int var1;
            while((var1 = var0.read()) > 0) {
                var2.append((char)var1);
            }

            String var3 = var2.toString();
            return var3;
        } catch (Throwable var13) {
            ;
        } finally {
            if (var0 != null) {
                try {
                    var0.close();
                } catch (Exception var12) {
                    ;
                }
            }

        }

        return null;
    }

    static String c(Context var0) throws NullPointerException {
        if (var0 == null) {
            throw new NullPointerException("Context is NUll");
        } else {
            String var1 = null;

            try {
                if (var0.getCacheDir() != null) {
                    var1 = var0.getCacheDir().getPath();
                } else {
                    File var2 = var0.getDir("/data/data/" + var0.getPackageName() + "/cache/", 0);
                    if (var2 != null) {
                        var1 = var2.getPath();
                    } else {
                        var1 = null;
                    }
                }
            } catch (Throwable var3) {
                ;
            }

            if (TextUtils.isEmpty(var1)) {
                throw new NullPointerException("Cannot Create Cache Dir");
            } else {
                return var1;
            }
        }
    }

    @SuppressLint("WrongConstant")
    static void a(Context var0, JSONObject var1) {
        try {
            if (var1 == null) {
                return;
            }

            if (var0 != null) {
                var0 = var0.getApplicationContext();
            }

            MemoryInfo var2 = new MemoryInfo();
            Debug.getMemoryInfo(var2);
            JSONObject var3 = new JSONObject();
            var3.put("dalvikPrivateDirty", var2.dalvikPrivateDirty);
            var3.put("dalvikPss", var2.dalvikPss);
            var3.put("dalvikSharedDirty", var2.dalvikSharedDirty);
            var3.put("nativePrivateDirty", var2.nativePrivateDirty);
            var3.put("nativePss", var2.nativePss);
            var3.put("nativeSharedDirty", var2.nativeSharedDirty);
            var3.put("otherPrivateDirty", var2.otherPrivateDirty);
            var3.put("otherPss", var2.otherPss);
            var3.put("otherSharedDirty", var2.otherSharedDirty);
            var3.put("totalPrivateClean", m.a(var2));
            var3.put("totalPrivateDirty", var2.getTotalPrivateDirty());
            var3.put("totalPss", var2.getTotalPss());
            var3.put("totalSharedClean", m.b(var2));
            var3.put("totalSharedDirty", var2.getTotalSharedDirty());
            var3.put("totalSwappablePss", m.c(var2));
            var1.put("memory_info", var3);
            ActivityManager var4 = null;
            if (var0 != null) {
                var3 = new JSONObject();
                android.app.ActivityManager.MemoryInfo var5 = new android.app.ActivityManager.MemoryInfo();
                var4 = (ActivityManager)var0.getSystemService("activity");
                var4.getMemoryInfo(var5);
                var3.put("availMem", var5.availMem);
                var3.put("lowMemory", var5.lowMemory);
                var3.put("threshold", var5.threshold);
                var3.put("totalMem", o.a(var5));
                var1.put("sys_memory_info", var3);
            }

            var3 = new JSONObject();
            var3.put("native_heap_size", Debug.getNativeHeapSize());
            var3.put("native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
            var3.put("native_heap_free_size", Debug.getNativeHeapFreeSize());
            Runtime var7 = Runtime.getRuntime();
            var3.put("max_memory", var7.maxMemory());
            var3.put("free_memory", var7.freeMemory());
            var3.put("total_memory", var7.totalMemory());
            if (var4 != null) {
                var3.put("memory_class", var4.getMemoryClass());
                var3.put("large_memory_class", a(var4));
            }

            var1.put("app_memory_info", var3);
        } catch (Throwable var6) {
            ;
        }

    }

    static int a(ActivityManager var0) {
        if (VERSION.SDK_INT >= 11) {
            try {
                return var0.getLargeMemoryClass();
            } catch (Throwable var2) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    static boolean a(long var0, String var2, byte[] var3, aa var4, String var5) throws Throwable {
        if (var2 == null) {
            return false;
        } else {
            if (var3 == null) {
                var3 = new byte[0];
            }

            int var6 = var3.length;
            byte[] var7 = var3;
            String var8 = null;
            boolean var9 = true;
            ByteArrayOutputStream var10;
            Deflater var11;
            if (l.aa.b == var4 && var6 > 128) {
                var10 = new ByteArrayOutputStream(8192);
                GZIPOutputStream var19 = new GZIPOutputStream(var10);

                label92: {
                    boolean var21;
                    try {
                        var19.write(var3);
                        break label92;
                    } catch (Throwable var17) {
                        var21 = false;
                    } finally {
                        var19.close();
                    }

                    return var21;
                }

                var11 = null;
                var7 = var10.toByteArray();
                var8 = "gzip";
            } else if (l.aa.c == var4 && var6 > 128) {
                var10 = new ByteArrayOutputStream(8192);
                var11 = new Deflater();
                var11.setInput(var3);
                var11.finish();
                byte[] var12 = new byte[8192];

                while(!var11.finished()) {
                    int var13 = var11.deflate(var12);
                    var10.write(var12, 0, var13);
                }

                var11.end();
                Object var20 = null;
                var11 = null;
                var7 = var10.toByteArray();
                var8 = "deflate";
            }

            return a(var2, var7, var5, var8, "POST", true);
        }
    }

    static boolean a(String var0, byte[] var1, String var2, String var3, String var4, boolean var5) throws Throwable {
        try {
            URL var6 = new URL(var0);
            HttpURLConnection var7 = (HttpURLConnection)var6.openConnection();
            if (var5) {
                var7.setDoOutput(true);
            } else {
                var7.setDoOutput(false);
            }

            if (var2 != null) {
                var7.setRequestProperty("Content-Type", var2);
            }

            if (var3 != null) {
                var7.setRequestProperty("Content-Encoding", var3);
            }

            var7.setRequestProperty("Accept-Encoding", "gzip");
            if (var4 == null) {
                throw new IllegalArgumentException("request method is not null");
            } else {
                var7.setRequestMethod(var4);
                DataOutputStream var8;
                if (var1 != null && var1.length > 0) {
                    var8 = new DataOutputStream(var7.getOutputStream());
                    var8.write(var1);
                    var8.flush();
                    var8.close();
                }

                InputStream var14 = var7.getInputStream();
                int var9 = var7.getResponseCode();
                if (var9 == 200) {
                    String var11 = var7.getContentEncoding();
                    byte[] var10;
                    if (var11.equalsIgnoreCase("gzip")) {
                        GZIPInputStream var12 = new GZIPInputStream(var14);
                        var10 = a((InputStream)var12);
                        if (var12 != null) {
                            var12.close();
                            var12 = null;
                        }
                    } else {
                        var10 = a(var14);
                    }

                    if (var14 != null) {
                        var14.close();
                        var8 = null;
                    }

                    return true;
                } else {
                    if (var14 != null) {
                        var14.close();
                        var8 = null;
                    }

                    return false;
                }
            }
        } catch (Throwable var13) {
            return false;
        }
    }

    static boolean a(String var0, Map var1) {
        try {
            if (TextUtils.isEmpty(var0)) {
                return false;
            } else {
                String var2 = b("http://log.snssdk.com/service/2/app_log_exception/", var1);
                return a(2097152L, var2, var0.getBytes(), aa.b, "application/json; charset=utf-8");
            }
        } catch (Throwable var3) {
            return false;
        }
    }

    private static String b(String var0, Map var1) {
        if (!TextUtils.isDigitsOnly(var0) && var1 != null) {
            if (var0.indexOf("?") < 0) {
                var0 = var0 + "?";
            }

            if (var1 != null && var1.size() > 0) {
                Iterator var2 = var1.entrySet().iterator();

                while(var2.hasNext()) {
                    Entry var3 = (Entry)var2.next();
                    if (var1.get(var3.getKey()) != null) {
                        if (var0.endsWith("?")) {
                            var0 = var0 + a(var3.getKey().toString(), "UTF-8") + "=" + a(var1.get(var3.getKey()).toString(), "UTF-8");
                        } else {
                            var0 = var0 + "&" + a(var3.getKey().toString(), "UTF-8") + "=" + a(var1.get(var3.getKey()).toString(), "UTF-8");
                        }
                    }
                }
            }

            return var0;
        } else {
            return var0;
        }
    }

    private static String a(String var0, String var1) {
        try {
            return URLEncoder.encode(var0, var1 != null ? var1 : "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    static byte[] a(InputStream var0) throws IOException {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        byte[] var2 = new byte[8192];
        boolean var3 = false;

        int var4;
        while(-1 != (var4 = var0.read(var2))) {
            var1.write(var2, 0, var4);
        }

        if (var0 != null) {
            var0.close();
            var0 = null;
        }

        return var1.toByteArray();
    }

    static void a(Closeable var0) {
        if (var0 != null) {
            try {
                var0.close();
            } catch (IOException var2) {
                ;
            }

        }
    }

    static JSONObject a(Context var0, Thread var1, Throwable var2) {
        if (var2 == null) {
            return null;
        } else {
            JSONObject var3 = new JSONObject();

            try {
                if (var0 != null) {
                    var0 = var0.getApplicationContext();
                }

                String var5 = null;
                StringWriter var6 = new StringWriter();
                PrintWriter var7 = new PrintWriter(var6);
                var2.printStackTrace(var7);
                Throwable var4 = var2.getCause();
                if (var4 != null) {
                    var4.printStackTrace(var7);
                    var4 = var4.getCause();
                    if (var4 != null) {
                        var4.printStackTrace(var7);
                    }
                }

                var5 = var6.toString();
                var7.close();
                if (var5 == null) {
                    return var3;
                }

                var3.put("data", var5);
                var3.put("crash_time", System.currentTimeMillis());
                String var8 = "";
                if (var0 != null) {
                    var8 = b(var0);
                    var3.put("process_name", var8);
                    if (!a(var0)) {
                        var3.put("remote_process", 1);
                    }
                }

                if (var0 != null) {
                    a(var0, var3);
                }

                if (a(var2) || a(var8, var2)) {
                    if (var8 != null && var8.endsWith(":ad")) {
                        var3.put("data_files", d(var0));
                    }

                    var3.put("all_thread_stacks", b());
                }
            } catch (Throwable var9) {
                ;
            }

            return var3;
        }
    }

    private static String d(Context var0) {
        if (var0 == null) {
            return "";
        } else {
            try {
                File var1 = var0.getFilesDir();
                return a(var1).toString();
            } catch (Throwable var2) {
                var2.printStackTrace();
                return "";
            }
        }
    }

    private static JSONArray a(File var0) {
        JSONArray var1 = new JSONArray();
        if (var0 != null && var0.exists()) {
            if (var0.isFile()) {
                var1.put(var0.getName());
                return var1;
            } else {
                File[] var2 = var0.listFiles();
                if (var2 == null) {
                    return var1;
                } else {
                    File[] var3 = var2;
                    int var4 = var2.length;

                    for(int var5 = 0; var5 < var4; ++var5) {
                        File var6 = var3[var5];
                        if (var6.isFile()) {
                            var1.put(var6.getName());
                        } else if (var6.isDirectory()) {
                            try {
                                JSONObject var7 = new JSONObject();
                                var7.put(var6.getName(), a(var6));
                                var1.put(var7);
                            } catch (JSONException var8) {
                                var8.printStackTrace();
                            }
                        }
                    }

                    return var1;
                }
            }
        } else {
            return var1;
        }
    }

    private static boolean a(String var0, Throwable var1) {
        if (var0 != null && var0.endsWith(":ad")) {
            try {
                Throwable var2 = var1;

                for(int var3 = 0; var2 != null; var2 = var2.getCause()) {
                    if (var2 instanceof NullPointerException) {
                        return true;
                    }

                    if (var3 > 20) {
                        return false;
                    }

                    ++var3;
                }
            } catch (Throwable var4) {
                ;
            }

            return false;
        } else {
            return false;
        }
    }

    private static boolean a(Throwable var0) {
        if (var0 == null) {
            return false;
        } else {
            try {
                Throwable var1 = var0;

                for(int var2 = 0; var1 != null; var1 = var1.getCause()) {
                    if (var1 instanceof OutOfMemoryError) {
                        return true;
                    }

                    if (var2 > 20) {
                        return false;
                    }

                    ++var2;
                }
            } catch (Throwable var3) {
                ;
            }

            return false;
        }
    }

    private static String b() {
        try {
            Map var0 = Thread.getAllStackTraces();
            JSONObject var1 = new JSONObject();
            if (var0 != null) {
                var1.put("tr_all_count", var0.size());
            }

            JSONArray var2 = new JSONArray();
            Iterator var3 = var0.entrySet().iterator();

            while(true) {
                while(true) {
                    if (!var3.hasNext()) {
                        String var19 = var1.toString();
                        return var19;
                    }

                    Entry var4 = (Entry)var3.next();
                    if (var4 == null) {
                        break;
                    }

                    JSONObject var5 = new JSONObject();
                    Thread var6 = (Thread)var4.getKey();
                    String var7 = var6.getName();
                    boolean var8 = false;
                    if (b.contains(var7)) {
                        var8 = true;
                    } else {
                        Iterator var9 = b.iterator();

                        while(var9.hasNext()) {
                            String var10 = (String)var9.next();
                            if (!TextUtils.isEmpty(var7) && var7.startsWith(var10)) {
                                var8 = true;
                                break;
                            }
                        }
                    }

                    if (!var8) {
                        var5.put("tr_n", var6.getName());
                        StackTraceElement[] var20 = (StackTraceElement[])var4.getValue();
                        if (var20 != null) {
                            JSONArray var21 = new JSONArray();
                            StackTraceElement[] var11 = var20;
                            int var12 = var20.length;

                            for(int var13 = 0; var13 < var12; ++var13) {
                                StackTraceElement var14 = var11[var13];
                                String var15 = var14.getClassName();
                                if (c.contains(var15)) {
                                    var8 = true;
                                    break;
                                }

                                Iterator var16 = c.iterator();

                                while(var16.hasNext()) {
                                    String var17 = (String)var16.next();
                                    if (!TextUtils.isEmpty(var15) && var15.startsWith(var17)) {
                                        var8 = true;
                                        break;
                                    }
                                }

                                String var22 = var15 + "." + var14.getMethodName() + "(" + var14.getLineNumber() + ")";
                                var21.put(var22);
                            }

                            if (var8) {
                                continue;
                            }

                            var5.put("tr_st", var21);
                        }

                        if (!var8) {
                            var2.put(var5);
                            break;
                        }
                    }
                }

                var1.put("tr_stacks", var2);
            }
        } catch (Throwable var18) {
            return "";
        }
    }

    static {
        b.add("ThreadPlus");
        b.add("ApiDispatcher");
        b.add("ApiLocalDispatcher");
        b.add("AsyncLoader");
        b.add("AsyncTask");
        b.add("Binder");
        b.add("PackageProcessor");
        b.add("SettingsObserver");
        b.add("WifiManager");
        b.add("JavaBridge");
        b.add("Compiler");
        b.add("Signal Catcher");
        b.add("GC");
        b.add("ReferenceQueueDaemon");
        b.add("FinalizerDaemon");
        b.add("FinalizerWatchdogDaemon");
        b.add("CookieSyncManager");
        b.add("RefQueueWorker");
        b.add("CleanupReference");
        b.add("VideoManager");
        b.add("DBHelper-AsyncOp");
        b.add("InstalledAppTracker2");
        b.add("AppData-AsyncOp");
        b.add("IdleConnectionMonitor");
        b.add("LogReaper");
        b.add("ActionReaper");
        b.add("Okio Watchdog");
        b.add("CheckWaitingQueue");
        c.add("com.facebook.imagepipeline.core.PriorityThreadFactory");
        c.add("com.ss.android.common.util.SimpleThreadFactory");
    }

    static enum aa {
        a(0),
        b(1),
        c(2);

        final int d;

        private aa(int var3) {
            this.d = var3;
        }
    }
}
