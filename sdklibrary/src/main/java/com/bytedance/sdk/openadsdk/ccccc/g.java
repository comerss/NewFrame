/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.widget.RemoteViews;

import com.androidquery.callback.AQuery2;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTAppDownloadInfo;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.ccccc.asasa.b;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.s;
import com.bytedance.sdk.openadsdk.service.TTDownloadHandlerService;

import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

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

@SuppressLint({"UseSparseArrays"})
public class g {
    private Map<Long, WeakHashMap<e, Boolean>> a = new ConcurrentHashMap();
    private Map<Long, com.bytedance.sdk.openadsdk.core.nibuguan.e> b = new ConcurrentHashMap();
    private Map<Long, y> c = new ConcurrentHashMap();
    private AQuery2 d;
    private LruCache<String, Bitmap> e;
    private final Context f;
    private final NotificationManager g;
    private static g h;
    private final Set<String> i = new HashSet();
    private static final Object j = new Object();
    private final HashMap<String, Long> k = new HashMap();
    private final q l = new q();
    private final q m = new q();

    public void a(Long var1, e var2, com.bytedance.sdk.openadsdk.core.nibuguan.e var3) {
        WeakHashMap var4 = (WeakHashMap)this.a.get(var1);
        if (var4 == null) {
            var4 = new WeakHashMap();
            this.a.put(var1, var4);
        }

        if (var2 != null) {
            var2.a(var1);
            var4.put(var2, Boolean.TRUE);
            y var5 = new y();
            this.c.put(var1, var5);
        }

        if (var3 != null && var3.c()) {
            this.b.put(var1, var3);
        }

    }

    public com.bytedance.sdk.openadsdk.core.nibuguan.e a(long var1) {
        return this.b != null ? (com.bytedance.sdk.openadsdk.core.nibuguan.e)this.b.get(var1) : null;
    }

    public void b(long var1) {
        if (this.b != null) {
            this.b.remove(var1);
        }

    }

    private void a(String var1, Bitmap var2) {
        if (this.b(var1) == null) {
            this.e.put(var1, var2);
        }

    }

    private Bitmap b(String var1) {
        return (Bitmap)this.e.get(var1);
    }

    private Bitmap c(String var1) {
        if (this.b(var1) == null) {
            this.d.ajax(var1, Bitmap.class, new AjaxCallback<Bitmap>() {
                public void a(String var1, Bitmap var2, AjaxStatus var3) {
                    super.callback(var1, var2, var3);
                    if (var3 != null && var2 != null && var3.getCode() == 200) {
                        float var4 = s.a(g.this.f, 44.0F);
                        g.this.a(var1, com.bytedance.sdk.openadsdk.ggg.f.a(var2, var4, var4));
                    }

                }
            });
        }

        return this.b(var1);
    }

    public void a(Long var1, e var2) {
        WeakHashMap var3 = (WeakHashMap)this.a.get(var1);
        if (var3 != null) {
            var3.remove(var2);
            this.c.remove(var1);
        }

        if (var3 == null || var3.isEmpty()) {
            this.a.remove(var1);
        }

    }

    public static synchronized g a(Context var0) {
        if (h == null) {
            h = new g(var0);
        }

        return h;
    }

    @SuppressLint("WrongConstant")
    private g(Context var1) {
        this.f = var1.getApplicationContext();
        this.g = (NotificationManager)this.f.getSystemService("notification");
        this.e();
        this.d = new AQuery2(this.f);
        long var2 = Runtime.getRuntime().maxMemory();
        int var4 = (int)(var2 / 8L);
        this.e = new LruCache<String, Bitmap>(var4) {
            protected int a(String var1, Bitmap var2) {
                return var2.getByteCount();
            }
        };
    }

    public void a() {
        Object var1 = j;
        synchronized(j) {
            Iterator var2 = this.i.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                this.g.cancel(var3, 0);
                var2.remove();
            }

        }
    }

    public void a(long var1, long var3) {
        q var5 = this.l;
        synchronized(this.l) {
            if (var3 != 0L) {
                this.l.b(var1, var3);
                this.m.b(var1, SystemClock.elapsedRealtime());
            } else {
                this.l.b(var1);
                this.m.b(var1);
            }

        }
    }

    public void a(Collection<d> var1, boolean var2) {
        HashMap var3 = this.k;
        synchronized(this.k) {
            this.b(var1, var2);
        }
    }

    private void b(Collection<d> var1, boolean var2) {
        Resources var3 = this.f.getResources();
        HashMap var4 = new HashMap();
        Iterator var5 = var1.iterator();

        while(var5.hasNext()) {
            d var6 = (d)var5.next();
            String var7 = a(var6);
            byte var8 = 0;
            if (var7 != null) {
                var4.put(var7, var6);
            }

            if (var6.j == 192) {
                this.a(var6, 1, 0L);
                var8 = 1;
            } else if (var6.j != 196 && var6.j != 193 && var6.j != 194 && var6.j != 195) {
                if (var6.j != 199 && var6.j != 198) {
                    if (com.bytedance.sdk.openadsdk.ccccc.m.a.c(var6.j)) {
                        this.a(var6, 3, 0L);
                        var8 = 3;
                    }
                } else {
                    this.a(var6, 4, 0L);
                    var8 = 4;
                }
            } else {
                this.a(var6, 2, 0L);
                var8 = 2;
            }

            if (!var2 && var6.j != 201) {
                this.a(var8, this.d(var6));
            }
        }

        var5 = var4.keySet().iterator();

        String var31;
        while(var5.hasNext()) {
            var31 = (String)var5.next();
            if (!com.bytedance.sdk.openadsdk.core.h.a().j()) {
                return;
            }

            int var32 = d(var31);
            d var34 = (d)var4.get(var31);
            if (var34 != null) {
                r var9 = new r(this.f);
                long var10;
                if (this.k.containsKey(var31)) {
                    var10 = (Long)this.k.get(var31);
                } else {
                    var10 = System.currentTimeMillis();
                    this.k.put(var31, var10);
                }

                int var12 = 0;
                int var13 = 0;
                int var14 = 0;
                if (var32 == 1) {
                    var12 = 17301633;
                    var13 = this.f.getResources().getColor(R.color.tt_download_action_active);
                    var14 = R.drawable.tt_download_active;
                } else if (var32 == 2) {
                    var12 = 17301642;
                    var13 = this.f.getResources().getColor(R.color.tt_download_action_pause);
                    var14 = R.drawable.tt_download_pause;
                    this.a(var34, 2, 0L);
                } else if (var32 == 3) {
                    var12 = 17301634;
                    var13 = this.f.getResources().getColor(R.color.tt_download_action_active);
                    var14 = R.drawable.tt_download_active;
                    this.a(var34, 3, 0L);
                }

                Uri var15;
                Intent var18;
                if (var32 != 1 && var32 != 2) {
                    if (var32 == 3) {
                        var15 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.a);
                        var9.b(true);
                        String var36;
                        if (!com.bytedance.sdk.openadsdk.ccccc.m.a.b(var34.j) && !b(var34)) {
                            var36 = "android.ss.intent.action.DOWNLOAD_OPEN";
                        } else {
                            var36 = "android.ss.intent.action.DOWNLOAD_DELETE";
                        }

                        Intent var17 = new Intent(var36, var15, this.f, TTDownloadHandlerService.class);
                        var17.putExtra("extra_click_download_ids", var34.a);
                        var9.a(PendingIntent.getService(this.f, 0, var17, 134217728));
                        var18 = new Intent("android.ss.intent.action.DOWNLOAD_HIDE", var15, this.f, TTDownloadHandlerService.class);
                        var9.b(PendingIntent.getService(this.f, 0, var18, 0));
                    }
                } else {
                    var15 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.a);
                    Intent var16 = new Intent("android.ss.intent.action.DOWNLOAD_DELETE", var15, this.f, TTDownloadHandlerService.class);
                    var9.a(PendingIntent.getService(this.f, 0, var16, 134217728));
                    if (var32 == 1) {
                        var9.a(true);
                    } else {
                        var9.b(true);
                    }
                }

                int var35 = 0;
                Uri var37 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.a);
                String var38 = "android.ss.intent.action.DOWNLOAD_CLICK";
                var18 = new Intent(var38, var37, this.f, TTDownloadHandlerService.class);
                var18.putExtra("extra_click_download_ids", var34.a);
                var18.putExtra("extra_notification_tag", var31);
                if (var32 == 1 || var32 == 2) {
                    long var19 = 0L;
                    long var21 = 0L;
                    long var23 = 0L;
                    q var25 = this.l;
                    synchronized(this.l) {
                        if (var34.s != -1L) {
                            var19 += var34.t;
                            var21 += var34.s;
                            var23 += this.l.a(var34.a);
                        }
                    }

                    if (var21 > 0L) {
                        var35 = (int)(var19 * 100L / var21);
                    } else {
                        var35 = 0;
                    }

                    if (var32 == 1) {
                        this.a(var34, 1, var23);
                    }
                }

                if (!var2) {
                    var9.a(var10);
                    var9.a(var12);
                    RemoteViews var20 = new RemoteViews(this.f.getPackageName(), R.layout.tt_ttopenad_download_notification_layout);
                    String var40 = null;
                    String var22 = null;
                    Long var41 = var34.m;
                    var40 = var34.C;
                    if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.a().c())) {
                        var22 = this.f.getResources().getString(R.string.tt_download_source) + this.f.getResources().getString(R.string.tt_open_ad_sdk_source);
                    } else {
                        var22 = this.f.getResources().getString(R.string.tt_download_source) + com.bytedance.sdk.openadsdk.core.h.a().c();
                    }

                    if (TextUtils.isEmpty(var40)) {
                        var20.setImageViewResource(R.id.icon, var12);
                    } else if (this.c(var40) != null) {
                        var20.setImageViewBitmap(R.id.icon, this.c(var40));
                    } else {
                        var20.setImageViewResource(R.id.icon, R.drawable.tt_ad_logo_small);
                    }

                    try {
                        var20.setTextViewText(R.id.tt_download_time, com.bytedance.sdk.openadsdk.ggg.r.a(var41, "HH:mm"));
                    } catch (ParseException var28) {
                        var28.printStackTrace();
                    }

                    var20.setProgressBar(R.id.tt_download_progress, 100, var35, false);
                    var20.setImageViewResource(R.id.action_download_img, var14);
                    var20.setTextViewText(R.id.tt_download_source, var22);
                    var20.setOnClickPendingIntent(R.id.ll_action, PendingIntent.getService(this.f, 0, var18, 134217728));
                    var20.setTextViewText(R.id.desc, this.c(var34));
                    String var24 = "";
                    String var42 = "";
                    if (var32 == 1) {
                        var24 = com.bytedance.sdk.openadsdk.ggg.q.a(var34.t) + "/" + com.bytedance.sdk.openadsdk.ggg.q.a(var34.s);
                        var42 = this.f.getResources().getString(R.string.tt_downloading);
                    } else if (var32 == 2) {
                        var24 = com.bytedance.sdk.openadsdk.ggg.q.a(var34.t) + "/" + com.bytedance.sdk.openadsdk.ggg.q.a(var34.s);
                        var42 = this.f.getResources().getString(R.string.tt_download_pause);
                    } else if (var32 == 3) {
                        if (!com.bytedance.sdk.openadsdk.ccccc.m.a.b(var34.j) && !b(var34)) {
                            if (com.bytedance.sdk.openadsdk.ccccc.m.a.a(var34.j)) {
                                var24 = this.f.getResources().getString(R.string.tt_download_finish);
                                if (com.bytedance.sdk.openadsdk.ggg.r.c(this.f, var34.e)) {
                                    var42 = this.f.getResources().getString(R.string.tt_download_open);
                                } else {
                                    var42 = this.f.getResources().getString(R.string.tt_download_install);
                                }
                            }
                        } else {
                            var24 = this.f.getResources().getString(R.string.tt_download_failed);
                            if (b(var34)) {
                                var42 = this.f.getResources().getString(R.string.tt_download_size_off);
                            } else {
                                var42 = this.f.getResources().getString(R.string.tt_download_restart);
                            }
                        }
                    }

                    var20.setTextViewText(R.id.download_size, var24);
                    var20.setTextViewText(R.id.action, var42);
                    var20.setTextColor(R.id.action, var13);
                    Notification var39 = var9.a();
                    var39.contentView = var20;
                    this.g.notify(var31, 0, var39);
                }
            }
        }

        if (!var2) {
            var5 = this.k.keySet().iterator();

            while(true) {
                do {
                    if (!var5.hasNext()) {
                        return;
                    }

                    var31 = (String)var5.next();
                } while(var4.containsKey(var31));

                this.g.cancel(var31, 0);
                Object var33 = j;
                synchronized(j) {
                    if (this.i.contains(var31)) {
                        this.i.remove(var31);
                        this.d();
                    }
                }

                var5.remove();
            }
        }
    }

    private CharSequence c(d var1) {
        return !TextUtils.isEmpty(var1.A) ? var1.A : this.f.getResources().getString(R.string.tt_download_title_unnamed);
    }

    public void a(String var1) {
        if (!TextUtils.isEmpty(var1)) {
            this.g.cancel(var1, 0);
            Object var2 = j;
            synchronized(j) {
                if (this.i.contains(var1)) {
                    this.i.remove(var1);
                    this.d();
                }
            }
        }

    }

    private void a(d var1, int var2, long var3) {
        if (this.a.get(var1.a) != null) {
            Map var5 = (Map)this.a.get(var1.a);
            y var6 = (y)this.c.get(var1.a);
            if (var6 == null) {
                var6 = new y();
                this.c.put(var1.a, var6);
            }

            var6.a = var1.a;
            var6.b = com.bytedance.sdk.openadsdk.ccccc.f.aaaaaa(var1.j);
            var6.c = var1.s;
            var6.d = var1.t;
            var6.e = var1.e;
            if (var6.b == 16) {
                b var7 = n.a();
                if (var7 != null) {
                    var7.a(var1.a, 5, "");
                }
            }

            try {
                if (var5 != null && !var5.isEmpty()) {
                    Set var11 = var5.keySet();
                    Iterator var8 = var11.iterator();

                    while(var8.hasNext()) {
                        e var9 = (e)var8.next();
                        if (var9 != null) {
                            var9.a(var6, var2, var1.s, var1.t, var3);
                        }
                    }
                }
            } catch (Throwable var10) {
                ;
            }
        }

    }

    private TTAppDownloadInfo d(d var1) {
        if (var1 == null) {
            return null;
        } else {
            TTAppDownloadInfo var2 = new TTAppDownloadInfo();
            var2.setId(var1.a);
            var2.setAppName(var1.A);
            var2.setTotalBytes(var1.s);
            var2.setCurrBytes(var1.t);
            var2.setFileName(var1.e);
            var2.setInternalStatusKey(var1.j);
            return var2;
        }
    }

    private void a(int var1, TTAppDownloadInfo var2) {
        TTGlobalAppDownloadListener var3 = com.bytedance.sdk.openadsdk.core.h.a().l();
        if (var2 != null && var3 != null) {
            switch(var1) {
                case 1:
                    var3.onDownloadActive(var2);
                    break;
                case 2:
                    var3.onDownloadPaused(var2);
                    break;
                case 3:
                    var3.onDownloadFinished(var2);
                    c(this.f, var2.getId());
                    break;
                case 4:
                    var3.onDownloadFailed(var2);
            }

        }
    }

    public void b() {
        q var1 = this.l;
        synchronized(this.l) {
            for(int var2 = 0; var2 < this.l.b(); ++var2) {
                long var3 = this.l.b(var2);
                long var5 = SystemClock.elapsedRealtime() - this.m.a(var3);
                Log.d("DownloadNotifier", "Download " + var3 + " speed " + this.l.c(var2) + "bps, " + var5 + "ms ago");
            }

        }
    }

    public static String a(d var0) {
        if (f(var0)) {
            return "2:" + var0.a;
        } else if (e(var0)) {
            return "1:" + var0.a;
        } else {
            return !b(var0) && !g(var0) ? null : "3:" + var0.a;
        }
    }

    void a(long var1, int var3, int var4) {
        if (b(var3, var4)) {
            String var5 = "3:" + var1;
            this.a(var5);
        }

    }

    static boolean b(d var0) {
        return a(var0.j, var0.h);
    }

    static boolean a(int var0, int var1) {
        return (var0 == 199 || var0 == 198) && a(var1);
    }

    static boolean b(int var0, int var1) {
        return com.bytedance.sdk.openadsdk.ccccc.m.a.c(var0) && a(var1);
    }

    static boolean a(int var0) {
        return var0 == 1 || var0 == 3;
    }

    static boolean b(int var0) {
        return var0 == 1 || var0 == 0;
    }

    private static int d(String var0) {
        return Integer.parseInt(var0.substring(0, var0.indexOf(58)));
    }

    private static boolean e(d var0) {
        return var0.j == 192 && b(var0.h);
    }

    private static boolean f(d var0) {
        return (var0.j == 196 || var0.j == 193 || var0.j == 194 || var0.j == 195) && b(var0.h);
    }

    private static boolean g(d var0) {
        return b(var0.j, var0.h);
    }

    void a(Context var1, long var2, int var4, int var5) {
        if (b(var4, var5) || a(var4, var5)) {
            ContentValues var6 = new ContentValues();
            var6.put("visibility", 200);
            var6.put("visibility", 0);
            Uri var7 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var2);
            com.bytedance.sdk.openadsdk.ccccc.i.a(var1).a(var7, var6, (String)null, (String[])null);
        }

    }

    public void a(Context var1, long var2) {
        Uri var6 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var2);
        Cursor var7 = com.bytedance.sdk.openadsdk.ccccc.i.a(var1).a(var6, (String[])null, (String)null, (String[])null, (String)null);

        int var4;
        int var5;
        label97: {
            try {
                if (var7.moveToFirst()) {
                    var4 = a(var7, "status");
                    var5 = a(var7, "visibility");
                    break label97;
                }

                Log.w("DownloadNotifier", "Missing details for download " + var2);
            } catch (Exception var19) {
                return;
            } finally {
                try {
                    if (var7 != null) {
                        var7.close();
                    }
                } catch (Exception var18) {
                    ;
                }

            }

            return;
        }

        this.a(var1, var2, var4, var5);
        this.a(var2, var4, var5);
    }

    public static int a(Cursor var0, String var1) {
        return var0.getInt(var0.getColumnIndexOrThrow(var1));
    }

    private void d() {
        if (this.i != null) {
            try {
                StringBuilder var1 = new StringBuilder();
                Object var2 = j;
                synchronized(j) {
                    Iterator var3 = this.i.iterator();
                    int var4 = 0;

                    while(true) {
                        if (!var3.hasNext()) {
                            break;
                        }

                        String var5 = (String)var3.next();
                        if (var4 != this.i.size() - 1) {
                            var1.append(var5).append("|");
                        } else {
                            var1.append(var5);
                        }

                        ++var4;
                    }
                }

                final String var9 = var1.toString();
                com.bytedance.sdk.openadsdk.ccccc.h.a(this.f, new com.bytedance.sdk.openadsdk.ccccc.h.b() {
                    public void a(SharedPreferences.Editor var1) {
                        if (LogUtils.a()) {
                            LogUtils.b("DownloadNotifier saveToMiscConfig", var9);
                        }

                        var1.putString("notifs_string", var9);
                    }
                });
            } catch (Exception var8) {
                ;
            }
        }

    }

    private void e() {
        try {
            com.bytedance.sdk.openadsdk.ccccc.h.a(this.f, new com.bytedance.sdk.openadsdk.ccccc.h.a() {
                public void a(SharedPreferences var1) {
                    String var2 = var1.getString("notifs_string", "");
                    if (LogUtils.a()) {
                        LogUtils.b("DownloadNotifier loadFromMiscConfig", var2);
                    }

                    String[] var3 = var2.split("\\|");
                    if (var3 != null) {
                        synchronized(com.bytedance.sdk.openadsdk.ccccc.g.j) {
                            for(int var5 = 0; var5 < var3.length; ++var5) {
                                if (TextUtils.isEmpty(var3[var5])) {
                                    g.this.i.add(var3[var5]);
                                }
                            }
                        }
                    }

                }
            });
        } catch (Exception var2) {
            ;
        }

    }

    public static void b(Context var0, long var1) {
        if (var0 != null && var1 >= 0L) {
            ContentValues var3 = new ContentValues();
            var3.put("visibility", 2);
            Uri var4 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var1);
            com.bytedance.sdk.openadsdk.ccccc.i.a(var0).a(var4, var3, (String)null, (String[])null);
        }
    }

    public static void c(Context var0, long var1) {
        if (var0 != null && var1 >= 0L) {
            ContentValues var3 = new ContentValues();
            var3.put("visibility", 200);
            Uri var4 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var1);
            com.bytedance.sdk.openadsdk.ccccc.i.a(var0).a(var4, var3, (String)null, (String[])null);
            ContentValues var5 = new ContentValues();
            var5.put("status", 201);
            com.bytedance.sdk.openadsdk.ccccc.i.a(var0).a(var4, var5, (String)null, (String[])null);
        }
    }
}