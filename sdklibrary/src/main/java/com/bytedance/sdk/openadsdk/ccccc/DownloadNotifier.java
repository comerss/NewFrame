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
import com.bytedance.sdk.openadsdk.core.nibuguan.DownLoadInfo;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;
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
public class DownloadNotifier {
    private Map<Long, WeakHashMap<DownLoadListener, Boolean>> mMap = new ConcurrentHashMap();
    private Map<Long, DownLoadInfo> mLongeMap = new ConcurrentHashMap();
    private Map<Long, DownLoadData> mHashMap = new ConcurrentHashMap();
    private AQuery2 mQuery2;
    private LruCache<String, Bitmap> mLruCache;
    private final Context mContext;
    private final NotificationManager mManager;
    private static DownloadNotifier sNotifier;
    private final Set<String> i = new HashSet();
    private static final Object j = new Object();
    private final HashMap<String, Long> mStringLongHashMap = new HashMap();
    private final q l = new q();
    private final q m = new q();

    public void a(Long var1, DownLoadListener listener, DownLoadInfo var3) {
        WeakHashMap weakHashMap = (WeakHashMap)this.mMap.get(var1);
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.mMap.put(var1, weakHashMap);
        }

        if (listener != null) {
            listener.load(var1);
            weakHashMap.put(listener, Boolean.TRUE);
            DownLoadData var5 = new DownLoadData();
            this.mHashMap.put(var1, var5);
        }

        if (var3 != null && var3.c()) {
            this.mLongeMap.put(var1, var3);
        }

    }

    public DownLoadInfo getDownloadInfo(long var1) {
        return this.mLongeMap != null ? (DownLoadInfo)this.mLongeMap.get(var1) : null;
    }

    public void remove(long var1) {
        if (this.mLongeMap != null) {
            this.mLongeMap.remove(var1);
        }

    }

    private void add(String var1, Bitmap var2) {
        if (this.getBitmap(var1) == null) {
            this.mLruCache.put(var1, var2);
        }

    }

    private Bitmap getBitmap(String var1) {
        return (Bitmap)this.mLruCache.get(var1);
    }

    private Bitmap download(String var1) {
        if (this.getBitmap(var1) == null) {
            this.mQuery2.ajax(var1, Bitmap.class, new AjaxCallback<Bitmap>() {
                @Override
                public void callback(String var1, Bitmap var2, AjaxStatus var3) {
                    super.callback(var1, var2, var3);
                    if (var3 != null && var2 != null && var3.getCode() == 200) {
                        float var4 = ViewWather.dp2px(DownloadNotifier.this.mContext, 44.0F);
                        DownloadNotifier.this.add(var1, com.bytedance.sdk.openadsdk.ggg.f.a(var2, var4, var4));
                    }

                }
            });
        }

        return this.getBitmap(var1);
    }

    public void addListener(Long var1, DownLoadListener var2) {
        WeakHashMap var3 = (WeakHashMap)this.mMap.get(var1);
        if (var3 != null) {
            var3.remove(var2);
            this.mHashMap.remove(var1);
        }

        if (var3 == null || var3.isEmpty()) {
            this.mMap.remove(var1);
        }

    }

    public static synchronized DownloadNotifier getDefault(Context var0) {
        if (sNotifier == null) {
            sNotifier = new DownloadNotifier(var0);
        }

        return sNotifier;
    }

    @SuppressLint("WrongConstant")
    private DownloadNotifier(Context var1) {
        this.mContext = var1.getApplicationContext();
        this.mManager = (NotificationManager)this.mContext.getSystemService("notification");
        this.e();
        this.mQuery2 = new AQuery2(this.mContext);
        long var2 = Runtime.getRuntime().maxMemory();
        int var4 = (int)(var2 / 8L);
        this.mLruCache = new LruCache<String, Bitmap>(var4) {
            protected int a(String var1, Bitmap var2) {
                return var2.getByteCount();
            }
        };
    }

    public void removeAll() {
        Object var1 = j;
        synchronized(j) {
            Iterator var2 = this.i.iterator();

            while(var2.hasNext()) {
                String var3 = (String)var2.next();
                this.mManager.cancel(var3, 0);
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

    public void a(Collection<DownLoadDatas> var1, boolean var2) {
        HashMap var3 = this.mStringLongHashMap;
        synchronized(this.mStringLongHashMap) {
            this.b(var1, var2);
        }
    }

    private void b(Collection<DownLoadDatas> var1, boolean var2) {
        Resources resources = this.mContext.getResources();
        HashMap hashMap = new HashMap();
        Iterator iterator = var1.iterator();

        while(iterator.hasNext()) {
            DownLoadDatas var6 = (DownLoadDatas)iterator.next();
            String var7 = a(var6);
            byte var8 = 0;
            if (var7 != null) {
                hashMap.put(var7, var6);
            }

            if (var6.j == 192) {
                this.a(var6, 1, 0L);
                var8 = 1;
            } else if (var6.j != 196 && var6.j != 193 && var6.j != 194 && var6.j != 195) {
                if (var6.j != 199 && var6.j != 198) {
                    if (com.bytedance.sdk.openadsdk.ccccc.m.a.isDone(var6.j)) {
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

        iterator = hashMap.keySet().iterator();

        String var31;
        while(iterator.hasNext()) {
            var31 = (String)iterator.next();
            if (!com.bytedance.sdk.openadsdk.core.h.a().j()) {
                return;
            }

            int var32 = d(var31);
            DownLoadDatas var34 = (DownLoadDatas)hashMap.get(var31);
            if (var34 != null) {
                NotificationListenerImpl notificationListener = new NotificationListenerImpl(this.mContext);
                long var10;
                if (this.mStringLongHashMap.containsKey(var31)) {
                    var10 = (Long)this.mStringLongHashMap.get(var31);
                } else {
                    var10 = System.currentTimeMillis();
                    this.mStringLongHashMap.put(var31, var10);
                }

                int var12 = 0;
                int var13 = 0;
                int var14 = 0;
                if (var32 == 1) {
                    var12 = 17301633;
                    var13 = this.mContext.getResources().getColor(R.color.tt_download_action_active);
                    var14 = R.drawable.tt_download_active;
                } else if (var32 == 2) {
                    var12 = 17301642;
                    var13 = this.mContext.getResources().getColor(R.color.tt_download_action_pause);
                    var14 = R.drawable.tt_download_pause;
                    this.a(var34, 2, 0L);
                } else if (var32 == 3) {
                    var12 = 17301634;
                    var13 = this.mContext.getResources().getColor(R.color.tt_download_action_active);
                    var14 = R.drawable.tt_download_active;
                    this.a(var34, 3, 0L);
                }

                Uri var15;
                Intent var18;
                if (var32 != 1 && var32 != 2) {
                    if (var32 == 3) {
                        var15 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.id);
                        notificationListener.setAutoCancel(true);
                        String var36;
                        if (!com.bytedance.sdk.openadsdk.ccccc.m.a.b(var34.j) && !b(var34)) {
                            var36 = "android.ss.intent.action.DOWNLOAD_OPEN";
                        } else {
                            var36 = "android.ss.intent.action.DOWNLOAD_DELETE";
                        }

                        Intent var17 = new Intent(var36, var15, this.mContext, TTDownloadHandlerService.class);
                        var17.putExtra("extra_click_download_ids", var34.id);
                        notificationListener.setContentIntent(PendingIntent.getService(this.mContext, 0, var17, 134217728));
                        var18 = new Intent("android.ss.intent.action.DOWNLOAD_HIDE", var15, this.mContext, TTDownloadHandlerService.class);
                        notificationListener.setDeleteIntent(PendingIntent.getService(this.mContext, 0, var18, 0));
                    }
                } else {
                    var15 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.id);
                    Intent var16 = new Intent("android.ss.intent.action.DOWNLOAD_DELETE", var15, this.mContext, TTDownloadHandlerService.class);
                    notificationListener.setContentIntent(PendingIntent.getService(this.mContext, 0, var16, 134217728));
                    if (var32 == 1) {
                        notificationListener.setOngoing(true);
                    } else {
                        notificationListener.setAutoCancel(true);
                    }
                }

                int var35 = 0;
                Uri var37 = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var34.id);
                String var38 = "android.ss.intent.action.DOWNLOAD_CLICK";
                var18 = new Intent(var38, var37, this.mContext, TTDownloadHandlerService.class);
                var18.putExtra("extra_click_download_ids", var34.id);
                var18.putExtra("extra_notification_tag", var31);
                if (var32 == 1 || var32 == 2) {
                    long var19 = 0L;
                    long var21 = 0L;
                    long var23 = 0L;
                    q var25 = this.l;
                    synchronized(this.l) {
                        if (var34.totalBytes != -1L) {
                            var19 += var34.currBytes;
                            var21 += var34.totalBytes;
                            var23 += this.l.a(var34.id);
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
                    notificationListener.setWhen(var10);
                    notificationListener.setSmallIcon(var12);
                    RemoteViews remoteViews = new RemoteViews(this.mContext.getPackageName(), R.layout.tt_ttopenad_download_notification_layout);
                    String var40 = null;
                    String var22 = null;
                    Long var41 = var34.m;
                    var40 = var34.C;
                    if (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.h.a().c())) {
                        var22 = this.mContext.getResources().getString(R.string.tt_download_source) + this.mContext.getResources().getString(R.string.tt_open_ad_sdk_source);
                    } else {
                        var22 = this.mContext.getResources().getString(R.string.tt_download_source) + com.bytedance.sdk.openadsdk.core.h.a().c();
                    }

                    if (TextUtils.isEmpty(var40)) {
                        remoteViews.setImageViewResource(R.id.icon, var12);
                    } else if (this.download(var40) != null) {
                        remoteViews.setImageViewBitmap(R.id.icon, this.download(var40));
                    } else {
                        remoteViews.setImageViewResource(R.id.icon, R.drawable.tt_ad_logo_small);
                    }

                    try {
                        remoteViews.setTextViewText(R.id.tt_download_time, ToolUtils.a(var41, "HH:mm"));
                    } catch (ParseException var28) {
                        var28.printStackTrace();
                    }

                    remoteViews.setProgressBar(R.id.tt_download_progress, 100, var35, false);
                    remoteViews.setImageViewResource(R.id.action_download_img, var14);
                    remoteViews.setTextViewText(R.id.tt_download_source, var22);
                    remoteViews.setOnClickPendingIntent(R.id.ll_action, PendingIntent.getService(this.mContext, 0, var18, 134217728));
                    remoteViews.setTextViewText(R.id.desc, this.c(var34));
                    String var24 = "";
                    String var42 = "";
                    if (var32 == 1) {
                        var24 = StringUtils.isEmpty(var34.currBytes) + "/" + StringUtils.isEmpty(var34.totalBytes);
                        var42 = this.mContext.getResources().getString(R.string.tt_downloading);
                    } else if (var32 == 2) {
                        var24 = StringUtils.isEmpty(var34.currBytes) + "/" + StringUtils.isEmpty(var34.totalBytes);
                        var42 = this.mContext.getResources().getString(R.string.tt_download_pause);
                    } else if (var32 == 3) {
                        if (!com.bytedance.sdk.openadsdk.ccccc.m.a.b(var34.j) && !b(var34)) {
                            if (com.bytedance.sdk.openadsdk.ccccc.m.a.isSuccess(var34.j)) {
                                var24 = this.mContext.getResources().getString(R.string.tt_download_finish);
                                if (ToolUtils.c(this.mContext, var34.fileName)) {
                                    var42 = this.mContext.getResources().getString(R.string.tt_download_open);
                                } else {
                                    var42 = this.mContext.getResources().getString(R.string.tt_download_install);
                                }
                            }
                        } else {
                            var24 = this.mContext.getResources().getString(R.string.tt_download_failed);
                            if (b(var34)) {
                                var42 = this.mContext.getResources().getString(R.string.tt_download_size_off);
                            } else {
                                var42 = this.mContext.getResources().getString(R.string.tt_download_restart);
                            }
                        }
                    }

                    remoteViews.setTextViewText(R.id.download_size, var24);
                    remoteViews.setTextViewText(R.id.action, var42);
                    remoteViews.setTextColor(R.id.action, var13);
                    Notification notification = notificationListener.build();
                    notification.contentView = remoteViews;
                    this.mManager.notify(var31, 0, notification);
                }
            }
        }

        if (!var2) {
            iterator = this.mStringLongHashMap.keySet().iterator();

            while(true) {
                do {
                    if (!iterator.hasNext()) {
                        return;
                    }

                    var31 = (String)iterator.next();
                } while(hashMap.containsKey(var31));

                this.mManager.cancel(var31, 0);
                Object var33 = j;
                synchronized(j) {
                    if (this.i.contains(var31)) {
                        this.i.remove(var31);
                        this.d();
                    }
                }

                iterator.remove();
            }
        }
    }

    private CharSequence c(DownLoadDatas var1) {
        return !TextUtils.isEmpty(var1.appName) ? var1.appName : this.mContext.getResources().getString(R.string.tt_download_title_unnamed);
    }

    public void a(String var1) {
        if (!TextUtils.isEmpty(var1)) {
            this.mManager.cancel(var1, 0);
            Object var2 = j;
            synchronized(j) {
                if (this.i.contains(var1)) {
                    this.i.remove(var1);
                    this.d();
                }
            }
        }

    }

    private void a(DownLoadDatas var1, int var2, long var3) {
        if (this.mMap.get(var1.id) != null) {
            Map var5 = (Map)this.mMap.get(var1.id);
            DownLoadData var6 = (DownLoadData)this.mHashMap.get(var1.id);
            if (var6 == null) {
                var6 = new DownLoadData();
                this.mHashMap.put(var1.id, var6);
            }

            var6.a = var1.id;
            var6.b = AppAdViewHolder.aaaaaa(var1.j);
            var6.c = var1.totalBytes;
            var6.d = var1.currBytes;
            var6.e = var1.fileName;
            if (var6.b == 16) {
                b var7 = n.a();
                if (var7 != null) {
                    var7.a(var1.id, 5, "");
                }
            }

            try {
                if (var5 != null && !var5.isEmpty()) {
                    Set var11 = var5.keySet();
                    Iterator var8 = var11.iterator();

                    while(var8.hasNext()) {
                        DownLoadListener var9 = (DownLoadListener)var8.next();
                        if (var9 != null) {
                            var9.progress(var6, var2, var1.totalBytes, var1.currBytes, var3);
                        }
                    }
                }
            } catch (Throwable var10) {
                ;
            }
        }

    }

    private TTAppDownloadInfo d(DownLoadDatas var1) {
        if (var1 == null) {
            return null;
        } else {
            TTAppDownloadInfo var2 = new TTAppDownloadInfo();
            var2.setId(var1.id);
            var2.setAppName(var1.appName);
            var2.setTotalBytes(var1.totalBytes);
            var2.setCurrBytes(var1.currBytes);
            var2.setFileName(var1.fileName);
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
                    c(this.mContext, var2.getId());
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

    public static String a(DownLoadDatas var0) {
        if (f(var0)) {
            return "2:" + var0.id;
        } else if (e(var0)) {
            return "1:" + var0.id;
        } else {
            return !b(var0) && !g(var0) ? null : "3:" + var0.id;
        }
    }

    void a(long var1, int var3, int var4) {
        if (b(var3, var4)) {
            String var5 = "3:" + var1;
            this.a(var5);
        }

    }

    static boolean b(DownLoadDatas var0) {
        return a(var0.j, var0.h);
    }

    static boolean a(int var0, int var1) {
        return (var0 == 199 || var0 == 198) && a(var1);
    }

    static boolean b(int var0, int var1) {
        return com.bytedance.sdk.openadsdk.ccccc.m.a.isDone(var0) && a(var1);
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

    private static boolean e(DownLoadDatas var0) {
        return var0.j == 192 && b(var0.h);
    }

    private static boolean f(DownLoadDatas var0) {
        return (var0.j == 196 || var0.j == 193 || var0.j == 194 || var0.j == 195) && b(var0.h);
    }

    private static boolean g(DownLoadDatas var0) {
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
                com.bytedance.sdk.openadsdk.ccccc.h.a(this.mContext, new com.bytedance.sdk.openadsdk.ccccc.h.b() {
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
            com.bytedance.sdk.openadsdk.ccccc.h.a(this.mContext, new com.bytedance.sdk.openadsdk.ccccc.h.a() {
                public void a(SharedPreferences var1) {
                    String var2 = var1.getString("notifs_string", "");
                    if (LogUtils.a()) {
                        LogUtils.b("DownloadNotifier loadFromMiscConfig", var2);
                    }

                    String[] var3 = var2.split("\\|");
                    if (var3 != null) {
                        synchronized(DownloadNotifier.j) {
                            for(int var5 = 0; var5 < var3.length; ++var5) {
                                if (TextUtils.isEmpty(var3[var5])) {
                                    DownloadNotifier.this.i.add(var3[var5]);
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