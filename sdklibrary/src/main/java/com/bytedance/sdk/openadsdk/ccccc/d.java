/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/*     */
/*     */ public class d {
    public long a;
    public String b;
    public boolean c;
    public String d;
    public String e;
    public String f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public long m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public long s;
    public long t;
    public String u;
    public int v;
    public boolean w;
    public String x;
    public int y;
    public boolean z;
    public String A;
    public String B;
    public String C;
    public int D;
    public int E;
    private List<Pair<String, String>> F;
    private Future<?> G;
    private k H;
    private final Context I;
    private NotificationManager J;
    private final w K;
    private final v L;
    private final DownloadNotifier M;

    private d(Context var1, w var2, v var3, DownloadNotifier var4) {
        this.F = new ArrayList();
        this.I = var1;
        this.J = (NotificationManager)this.I.getSystemService("notification");
        this.K = var2;
        this.L = var3;
        this.M = var4;
        this.E = com.bytedance.sdk.openadsdk.ccccc.n.a.nextInt(1001);
    }

    public Collection<Pair<String, String>> a() {
        return Collections.unmodifiableList(this.F);
    }

    @TargetApi(4)
    public void a(int var1) {
        if (this.n != null) {
            Intent var2 = new Intent("android.ss.intent.action.DOWNLOAD_COMPLETE");

            try {
                if (this.e != null) {
                    PackageManager var3 = this.I.getPackageManager();
                    PackageInfo var4 = var3.getPackageArchiveInfo(this.e, PackageManager.GET_ACTIVITIES);
                    String var5 = var4 == null ? null : var4.packageName;
                    if (var5 != null) {
                        var2.putExtra("extra_app_package", var5);
                    }
                }
            } catch (Exception var6) {
                var6.printStackTrace();
            }

            var2.setPackage(this.n);
            var2.putExtra("extra_download_id", this.a);
            var2.putExtra("extra_download_visibility", this.h);
            var2.putExtra("status", var1);
            this.K.a(var2);
        }
    }

    public long a(long var1) {
        if (this.k == 0) {
            return var1;
        } else {
            return this.l > 0 ? this.m + (long)this.l : this.m + (long)(30 * (1000 + this.E) * (1 << this.k - 1));
        }
    }

    private boolean f() {
        if (this.i == 1) {
            return false;
        } else {
            switch(this.j) {
                case 0:
                case 190:
                case 192:
                    return true;
                case 194:
                    long var1 = this.K.a();
                    return !this.h() && this.a(var1) <= var1;
                case 195:
                case 196:
                    return !this.h() && this.b() == aenumse.a;
                case 198:
                    return false;
                case 199:
                    return Environment.getExternalStorageState().equals("mounted");
                default:
                    return false;
            }
        }
    }

    public aenumse b() {
        NetworkInfo var1 = this.K.b();
        if (var1 != null && var1.isConnected()) {
            return this.K.c() && !this.g() ? aenumse.e : this.b(var1.getType());
        } else {
            return aenumse.b;
        }
    }

    private boolean g() {
        return this.z;
    }

    private aenumse b(int var1) {
        int var2 = this.c(var1);
        boolean var3 = this.y == -1;
        return !var3 && (var2 & this.y) == 0 ? aenumse.f : this.d(var1);
    }

    private int c(int var1) {
        switch(var1) {
            case 0:
                return 1;
            case 1:
                return 2;
            default:
                return 0;
        }
    }

    private boolean h() {
        NetworkInfo var1 = this.K.b();
        return var1 != null && var1.isConnected() && this.c(var1.getType()) == 1;
    }

    private aenumse d(int var1) {
        if (this.s <= 0L) {
            return aenumse.a;
        } else if (var1 == 1) {
            return aenumse.a;
        } else {
            Long var2 = this.K.d();
            if (var2 != null && this.s > var2) {
                return aenumse.c;
            } else {
                if (this.D == 0) {
                    Long var3 = this.K.e();
                    if (var3 != null && this.s > var3) {
                        return aenumse.d;
                    }
                }

                return aenumse.a;
            }
        }
    }

    public boolean a(ExecutorService var1) {
        synchronized(this) {
            boolean var3 = this.f();
            boolean var4 = this.G != null && !this.G.isDone();
            if (var3 && !var4) {
                if (this.j != 192) {
                    this.j = 192;
                    ContentValues var5 = new ContentValues();
                    var5.put("status", this.j);
                    com.bytedance.sdk.openadsdk.ccccc.i.a(this.I).a(this.d(), var5, (String)null, (String[])null);
                }

                this.H = new k(this.I, this.K, this, this.L, this.M);
                this.G = var1.submit(this.H);
            }

            return var3;
        }
    }

    public boolean a(j var1) {
        synchronized(this) {
            boolean var3 = this.e();
            if (var3) {
                var1.a(this);
            }

            return var3;
        }
    }

    public void c() {
        String var1 = this.e;
        if (this.e != null) {
            File var2 = new File(var1);
            if (this.j == 200 && !var2.exists()) {
                String var3 = DownloadNotifier.a(this);
                DownloadNotifier.a(this.I).a(var3);
                com.bytedance.sdk.openadsdk.ccccc.i.a(this.I).a(this.d(), (String)null, (String[])null);
            }
        }

    }

    public Uri d() {
        return ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, this.a);
    }

    public void a(p var1) {
        var1.println("DownloadInfo:");
        var1.a();
        var1.a("mId", this.a);
        var1.a("mLastMod", this.m);
        var1.a("mPackage", this.n);
        var1.println();
        var1.a("mUri", this.b);
        var1.println();
        var1.a("mMimeType", this.f);
        var1.a("mCookies", this.p != null ? "yes" : "no");
        var1.a("mReferer", this.r != null ? "yes" : "no");
        var1.a("mUserAgent", this.q);
        var1.println();
        var1.a("mFileName", this.e);
        var1.a("mDestination", this.g);
        var1.println();
        var1.a("mStatus", com.bytedance.sdk.openadsdk.ccccc.m.a.d(this.j));
        var1.a("mCurrentBytes", this.t);
        var1.a("mTotalBytes", this.s);
        var1.println();
        var1.a("mNumFailed", this.k);
        var1.a("mRetryAfter", this.l);
        var1.a("mETag", this.u);
        var1.println();
        var1.a("mAllowedNetworkTypes", this.y);
        var1.a("mAllowRoaming", this.z);
        var1.println();
        var1.b();
    }

    public long b(long var1) {
        if (com.bytedance.sdk.openadsdk.ccccc.m.a.c(this.j)) {
            return 9223372036854775807L;
        } else if (this.j != 194) {
            return 0L;
        } else {
            long var3 = this.a(var1);
            return var3 <= var1 ? 0L : var3 - var1;
        }
    }

    public boolean e() {
        return this.v == 0 && (this.g == 0 || this.g == 1) && com.bytedance.sdk.openadsdk.ccccc.m.a.a(this.j);
    }

    public static int a(i var0, long var1) {
        Cursor var3 = var0.a(ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, var1), new String[]{"status"}, (String)null, (String[])null, (String)null);

        short var4;
        try {
            if (var3.moveToFirst()) {
                int var14 = var3.getInt(0);
                return var14;
            }

            var4 = 190;
        } finally {
            try {
                if (var3 != null) {
                    var3.close();
                }
            } catch (Exception var12) {
                ;
            }

        }

        return var4;
    }

    public static enum aenumse {
        a,
        b,
        c,
        d,
        e,
        f;

        private aenumse() {
        }
    }

    public static class b {
        private i a;
        private Cursor b;

        public b(i var1, Cursor var2) {
            this.a = var1;
            this.b = var2;
        }

        public d a(Context var1, w var2, v var3, DownloadNotifier var4) {
            d var5 = new d(var1, var2, var3, var4);
            this.a(var5);
            this.b(var5);
            return var5;
        }

        public void a(d var1) {
            var1.a = this.c("_id");
            var1.b = this.a("uri");
            var1.c = this.b("no_integrity") == 1;
            var1.d = this.a("hint");
            var1.e = this.a("_data");
            var1.f = this.a("mimetype");
            var1.g = this.b("destination");
            var1.h = this.b("visibility");
            var1.j = this.b("status");
            var1.k = this.b("numfailed");
            int var2 = this.b("method");
            var1.l = var2 & 268435455;
            var1.m = this.c("lastmod");
            var1.n = this.a("notificationpackage");
            var1.o = this.a("notificationextras");
            var1.p = this.a("cookiedata");
            var1.q = this.a("useragent");
            var1.r = this.a("referer");
            var1.s = this.c("total_bytes");
            var1.t = this.c("current_bytes");
            var1.u = this.a("etag");
            var1.v = this.b("scanned");
            var1.w = this.b("deleted") == 1;
            var1.x = this.a("mediaprovider_uri");
            var1.y = this.b("allowed_network_types");
            var1.z = this.b("allow_roaming") != 0;
            var1.A = this.a("title");
            var1.B = this.a("description");
            var1.C = this.a("icon_url");
            var1.D = this.b("bypass_recommended_size_limit");
            synchronized(this) {
                var1.i = this.b("control");
            }
        }

        private void b(d var1) {
            var1.F.clear();
            Uri var2 = Uri.withAppendedPath(var1.d(), "headers");
            Cursor var3 = this.a.a(var2, (String[])null, (String)null, (String[])null, (String)null);

            try {
                int var4 = var3.getColumnIndexOrThrow("header");
                int var5 = var3.getColumnIndexOrThrow("value");
                var3.moveToFirst();

                while(!var3.isAfterLast()) {
                    this.a(var1, var3.getString(var4), var3.getString(var5));
                    var3.moveToNext();
                }
            } catch (Exception var14) {
                ;
            } finally {
                try {
                    if (var3 != null) {
                        var3.close();
                    }
                } catch (Exception var13) {
                    ;
                }

            }

            if (var1.p != null) {
                this.a(var1, "Cookie", var1.p);
            }

            if (var1.r != null) {
                this.a(var1, "Referer", var1.r);
            }

        }

        @TargetApi(5)
        private void a(d var1, String var2, String var3) {
            var1.F.add(Pair.create(var2, var3));
        }

        private String a(String var1) {
            int var2 = this.b.getColumnIndexOrThrow(var1);
            String var3 = this.b.getString(var2);
            return TextUtils.isEmpty(var3) ? null : var3;
        }

        private Integer b(String var1) {
            return this.b.getInt(this.b.getColumnIndexOrThrow(var1));
        }

        private Long c(String var1) {
            return this.b.getLong(this.b.getColumnIndexOrThrow(var1));
        }
    }
}
