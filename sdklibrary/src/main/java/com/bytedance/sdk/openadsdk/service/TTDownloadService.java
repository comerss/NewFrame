/*     */ package com.bytedance.sdk.openadsdk.service;
/*     */ 
/*     */

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

import com.bytedance.sdk.openadsdk.ccccc.DownloadNotifier;
import com.bytedance.sdk.openadsdk.ccccc.SsAndroidDownloadManager;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadDatas;
import com.bytedance.sdk.openadsdk.ccccc.i;
import com.bytedance.sdk.openadsdk.ccccc.j;
import com.bytedance.sdk.openadsdk.ccccc.p;
import com.bytedance.sdk.openadsdk.ccccc.t;
import com.bytedance.sdk.openadsdk.ccccc.v;
import com.bytedance.sdk.openadsdk.ccccc.w;

import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
public class TTDownloadService extends Service {
    w a;
    private AlarmManager b;
    private v c;
    private TTDownloadService.a d;
    private DownloadNotifier e;
    @SuppressLint({"UseSparseArrays"})
    private final Map<Long, DownLoadDatas> f = new HashMap();
    private final ExecutorService g = a();
    private j h;
    private HandlerThread i;
    private Handler j;
    private volatile int k;
    private Handler.Callback l = new Handler.Callback() {
        @TargetApi(5)
        public boolean handleMessage(Message var1) {
            Process.setThreadPriority(10);
            int var2 = var1.arg1;
            boolean var3;
            synchronized(TTDownloadService.this.f) {
                int var5 = var1.arg2;
                var3 = TTDownloadService.this.b(var5 > 0);
            }

            if (var1.what == 2) {
                Iterator var4 = Thread.getAllStackTraces().entrySet().iterator();

                while(var4.hasNext()) {
                    Map.Entry var8 = (Map.Entry)var4.next();
                    if (((Thread)var8.getKey()).getName().startsWith("pool")) {
                        Log.d("SsAndroidDownloadManager", var8.getKey() + ": " + Arrays.toString((Object[])var8.getValue()));
                    }
                }

                TTDownloadService.this.e.b();
                Log.w("SsAndroidDownloadManager", "Final update pass triggered, isActive=" + var3 + "; someone didn'MineHandler update correctly.");
            }

            if (var3) {
                TTDownloadService.this.b();
            } else if (TTDownloadService.this.stopSelfResult(var2)) {
                if (TTDownloadService.this.d != null) {
                    TTDownloadService.this.getContentResolver().unregisterContentObserver(TTDownloadService.this.d);
                }

                if (TTDownloadService.this.h != null) {
                    TTDownloadService.this.h.a();
                }

                if (TTDownloadService.this.i != null) {
                    TTDownloadService.this.i.quit();
                }

                if (TTDownloadService.this.g != null) {
                    TTDownloadService.this.g.shutdown();
                }
            }

            return true;
        }
    };

    public TTDownloadService() {
    }

    @TargetApi(9)
    private static ExecutorService a() {
        boolean var0 = true;
        ThreadPoolExecutor var1 = new ThreadPoolExecutor(5, 5, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (Build.VERSION.SDK_INT >= 9) {
            var1.allowCoreThreadTimeOut(true);
        }

        return var1;
    }

    public static void a(Context var0) {
        try {
            var0.startService(new Intent(var0, TTDownloadService.class));
        } catch (Exception var2) {
            ;
        }

    }

    public IBinder onBind(Intent var1) {
        throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
    }

    @SuppressLint("WrongConstant")
    @TargetApi(3)
    public void onCreate() {
        super.onCreate();
        if (SsAndroidDownloadManager.d) {
            Log.v("SsAndroidDownloadManager", "Service onCreate");
        }

        if (this.a == null) {
            this.a = t.a(this);
        }

        this.b = (AlarmManager)this.getSystemService("alarm");
        this.c = new v(this);
        this.i = new HandlerThread("SsAndroidDownloadManager-UpdateThread");
        this.i.start();
        this.j = new Handler(this.i.getLooper(), this.l);
        this.h = new j(this);
        this.e = DownloadNotifier.getDefault(this);
        this.e.removeAll();
        this.d = new TTDownloadService.a();
        this.getContentResolver().registerContentObserver(com.bytedance.sdk.openadsdk.ccccc.m.a.a, true, this.d);
    }

    @TargetApi(5)
    public int onStartCommand(Intent var1, int var2, int var3) {
        int var4 = super.onStartCommand(var1, var2, var3);
        if (SsAndroidDownloadManager.d) {
            Log.v("SsAndroidDownloadManager", "Service onStart");
        }

        this.k = var3;
        boolean var5 = false;
        if (var1 != null) {
            var5 = var1.getBooleanExtra("isFirstStart", false);
        }

        this.a(var5);
        return var4;
    }

    @TargetApi(5)
    public void onDestroy() {
        try {
            if (this.d != null) {
                this.getContentResolver().unregisterContentObserver(this.d);
            }

            if (this.h != null) {
                this.h.a();
            }

            if (this.i != null) {
                this.i.quit();
            }

            if (this.g != null) {
                this.g.shutdown();
            }

            if (SsAndroidDownloadManager.d) {
                Log.v("SsAndroidDownloadManager", "Service onDestroy");
            }
        } catch (Exception var2) {
            ;
        }

        super.onDestroy();
    }

    private void a(boolean var1) {
        this.j.removeMessages(1);
        this.j.obtainMessage(1, this.k, var1 ? 1 : 0).sendToTarget();
    }

    private void b() {
        this.j.removeMessages(2);
        this.j.sendMessageDelayed(this.j.obtainMessage(2, this.k, -1), 300000L);
    }

    @SuppressLint("WrongConstant")
    private boolean b(boolean var1) {
        long var2 = this.a.a();
        boolean var4 = false;
        long var5 = 9223372036854775807L;
        HashSet var7 = new HashSet(this.f.keySet());
        i var8 = com.bytedance.sdk.openadsdk.ccccc.i.a(this.getApplicationContext());
        Cursor var9 = var8.a(com.bytedance.sdk.openadsdk.ccccc.m.a.a, (String[])null, (String)null, (String[])null, (String)null);
        DownLoadDatas var10 = null;

        try {
            DownLoadDatas.b var11 = new DownLoadDatas.b(var8, var9);

            for(int var12 = var9.getColumnIndexOrThrow("_id"); var9.moveToNext(); var5 = Math.min(var10.b(var2), var5)) {
                long var13 = var9.getLong(var12);
                var7.remove(var13);
                var10 = (DownLoadDatas)this.f.get(var13);
                if (var10 != null) {
                    this.a(var11, var10, var2);
                } else {
                    var10 = this.a(var11, var2);
                }

                if (var10.w) {
                    if (!TextUtils.isEmpty(var10.x)) {
                        this.getContentResolver().delete(Uri.parse(var10.x), (String)null, (String[])null);
                    }

                    this.f.remove(var10.id);
                    this.a(var10.fileName);
                    var8.a(var10.d(), (String)null, (String[])null);
                    this.e.a(DownloadNotifier.a(var10));
                } else {
                    var10.c();
                    boolean var15 = var10.a(this.g);
                    boolean var16 = var10.a(this.h);
                    var4 |= var15;
                    var4 |= var16;
                }
            }
        } catch (Exception var27) {
            if (var10 != null && var10.w) {
                this.f.remove(var10.id);
                this.a(var10.fileName);
                var8.a(var10.d(), (String)null, (String[])null);
                this.e.a(DownloadNotifier.a(var10));
            }

            var27.printStackTrace();
        } finally {
            try {
                if (var9 != null) {
                    var9.close();
                }
            } catch (Exception var25) {
                ;
            }

        }

        Iterator var29 = var7.iterator();

        while(var29.hasNext()) {
            Long var31 = (Long)var29.next();
            this.a(var31);
        }

        this.e.a(this.f.values(), var1);
        if (var5 > 0L && var5 < 9223372036854775807L) {
            if (SsAndroidDownloadManager.c) {
                Log.v("SsAndroidDownloadManager", "scheduling start in " + var5 + "ms");
            }

            Intent var30 = new Intent("android.ss.intent.action.DOWNLOAD_WAKEUP");
            var30.setClass(this, TTDownloadHandlerService.class);
            byte var32 = 1;

            try {
                bb.a(this.b, var32, var2 + var5, PendingIntent.getService(this, 0, var30, 1073741824));
            } catch (Throwable var26) {
                ;
            }
        }

        return var4;
    }

    private DownLoadDatas a(DownLoadDatas.b var1, long var2) {
        DownLoadDatas var4 = var1.a(this, this.a, this.c, this.e);
        this.f.put(var4.id, var4);
        if (SsAndroidDownloadManager.d) {
            Log.v("SsAndroidDownloadManager", "processing inserted download " + var4.id);
        }

        return var4;
    }

    private void a(DownLoadDatas.b var1, DownLoadDatas var2, long var3) {
        var1.a(var2);
        if (SsAndroidDownloadManager.d) {
            Log.v("SsAndroidDownloadManager", "processing updated download " + var2.id + ", status: " + var2.j);
        }

    }

    private void a(long var1) {
        DownLoadDatas var3 = (DownLoadDatas)this.f.get(var1);
        if (var3.j == 192) {
            var3.j = 490;
        }

        if (var3.g != 0 && var3.fileName != null) {
            if (SsAndroidDownloadManager.d) {
                Log.d("SsAndroidDownloadManager", "deleteDownloadLocked() deleting " + var3.fileName);
            }

            this.a(var3.fileName);
        }

        this.e.a(DownloadNotifier.a(var3));
        this.f.remove(var3.id);
    }

    private void a(String var1) {
        if (!TextUtils.isEmpty(var1)) {
            if (SsAndroidDownloadManager.d) {
                Log.d("SsAndroidDownloadManager", "deleteFileIfExists() deleting " + var1);
            }

            File var2 = new File(var1);
            if (var2.exists() && !var2.delete()) {
                Log.w("SsAndroidDownloadManager", "file: '" + var1 + "' couldn'MineHandler be deleted");
            }
        }

    }

    protected void dump(FileDescriptor var1, PrintWriter var2, String[] var3) {
        p var4 = new p(var2, "  ");
        Map var5 = this.f;
        synchronized(this.f) {
            ArrayList var6 = new ArrayList(this.f.keySet());
            Collections.sort(var6);
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
                Long var8 = (Long)var7.next();
                DownLoadDatas var9 = (DownLoadDatas)this.f.get(var8);
                var9.a(var4);
            }

        }
    }

    private static class bb {
        static final bb.a a;

        public static void a(AlarmManager var0, int var1, long var2, PendingIntent var4) {
            a.a(var0, var1, var2, var4);
        }

        static {
            if (Build.VERSION.SDK_INT >= 19) {
                a = new bb.b();
            } else {
                a = new bb.a();
            }

        }

        @TargetApi(19)
        public static class b extends bb.a {
            private b() {
                super();
            }

            public void a(AlarmManager var1, int var2, long var3, PendingIntent var5) {
                try {
                    if (var1 != null) {
                        var1.setExact(var2, var3, var5);
                    }
                } catch (Throwable var9) {
                    if (var9 instanceof NoSuchMethodError) {
                        try {
                            if (var1 != null) {
                                var1.set(var2, var3, var5);
                            }
                        } catch (Throwable var8) {
                        }
                    }
                }

            }
        }

        private static class a {
            private a() {
            }

            public void a(AlarmManager var1, int var2, long var3, PendingIntent var5) {
                try {
                    if (var1 != null) {
                        var1.set(var2, var3, var5);
                    }
                } catch (Throwable var7) {
                    ;
                }

            }
        }
    }

    private class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        public void onChange(boolean var1) {
            TTDownloadService.this.a(false);
        }
    }
}