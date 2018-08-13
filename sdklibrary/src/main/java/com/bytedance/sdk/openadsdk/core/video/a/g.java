/*     */ package com.bytedance.sdk.openadsdk.core.video.a;
/*     */ 
/*     */

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.core.video.c.SSMediaPlayeWrapper;
import com.bytedance.sdk.openadsdk.core.widget.VedioManager;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.NetUtils;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class g implements c, d, MineHandler.OnResult {
    private static final String c = g.class.getSimpleName();
    private NewLiveViewLayout mLiveViewLayout;
    private ViewGroup e;
    private MineHandler mMineHandler = new MineHandler(this);
    private long g = 0L;
    private long h = 0L;
    private SSMediaPlayeWrapper mPlayeWrapper;
    private com.bytedance.sdk.openadsdk.core.video.a.c.a j;
    private long k = 0L;
    private long l = 0L;
    private long m;
    private ArrayList<Runnable> mRunnableArrayList;
    private boolean o;
    private WeakReference<Context> mContextWeakReference;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private final NativeAdData t;
    private boolean u = true;
    private boolean v = false;
    private WeakReference<e> w;
    private long x = 0L;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private Runnable B = new Runnable() {
        public void run() {
            if (g.this.mPlayeWrapper != null) {
                g.this.mPlayeWrapper.d();
            }

        }
    };
    private Runnable C = new Runnable() {
        public void run() {
            if (g.this.j != null) {
                g.this.j.a();
            }

        }
    };
    private Runnable D = new Runnable() {
        public void run() {
            if (g.this.mPlayeWrapper != null) {
                if (g.this.m <= 0L) {
                    g.this.mPlayeWrapper.d();
                }

                g.this.mPlayeWrapper.e();
            }

            g.this.mMineHandler.postDelayed(this, 200L);
        }
    };
    protected boolean a = false;
    protected long b;
    private final BroadcastReceiver E = new BroadcastReceiver() {
        public void onReceive(Context var1, Intent var2) {
            String var3 = var2.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(var3)) {
                g.this.a();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
                g.this.a(var1);
            }

        }
    };
    private NetUtils.a F = NetUtils.b(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext());
    private boolean G = false;

    private void b(Context var1) {
        EnumSet var2 = EnumSet.noneOf(com.bytedance.sdk.openadsdk.core.video.a.b.a.class);
        var2.add(com.bytedance.sdk.openadsdk.core.video.a.b.a.a);
        var2.add(com.bytedance.sdk.openadsdk.core.video.a.b.a.e);
        this.mLiveViewLayout = new NewLiveViewLayout(var1, LayoutInflater.from(var1.getApplicationContext()).inflate(R.layout.tt_video_play_layout_for_live, (ViewGroup)null, false), true, var2, this.t, this);
        this.mLiveViewLayout.a(this);
    }

    public g(Context var1, ViewGroup var2, NativeAdData var3) {
        this.e = var2;
        this.mContextWeakReference = new WeakReference(var1);
        this.t = var3;
        this.b(var1);
        this.q = Build.VERSION.SDK_INT >= 17;
    }

    public boolean a(String var1, String var2, int var3, int var4, List<String> var5, String var6, long var7, boolean var9) {
        LogUtils.b(c, "video local url " + var1);
        if (StringUtils.isEmpty(var1)) {
            LogUtils.e(c, "No video info");
            return false;
        } else {
            this.v = var9;
            if (var7 > 0L) {
                this.k = var7;
                this.l = this.l > this.k ? this.l : this.k;
            }

            if (this.mLiveViewLayout != null) {
                this.mLiveViewLayout.f();
                this.mLiveViewLayout.e();
                this.mLiveViewLayout.c(var3, var4);
                this.mLiveViewLayout.a(this.e);
                this.mLiveViewLayout.a(var3, var4);
            }

            if (this.mPlayeWrapper == null) {
                this.mPlayeWrapper = new SSMediaPlayeWrapper(this.mMineHandler);
            }

            this.h = 0L;

            try {
                this.a(var1);
                return true;
            } catch (Exception var11) {
                return false;
            }
        }
    }

    public SSMediaPlayeWrapper h() {
        return this.mPlayeWrapper;
    }

    public long d() {
        return this.k;
    }

    public void a(long var1) {
        this.k = var1;
        this.l = this.l > this.k ? this.l : this.k;
    }

    public void a(boolean var1) {
        this.u = var1;
        this.mLiveViewLayout.a(var1);
    }

    public boolean g() {
        return this.y;
    }

    public void b(long var1) {
        this.x = var1;
    }

    public long f() {
        return this.m;
    }

    public void c(long var1) {
        this.m = var1;
    }

    public long e() {
        return this.mPlayeWrapper == null ? 0L : this.mPlayeWrapper.p() + this.x;
    }

    public boolean i() {
        return this.v;
    }

    public void b(boolean var1) {
        this.v = var1;
        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a(var1);
        }

    }

    public boolean j() {
        return this.A;
    }

    public int k() {
        return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.l, this.m);
    }

    private void a(String var1) throws Exception {
        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a(var1);
        }

        this.g = System.currentTimeMillis();
        if (!StringUtils.isEmpty(var1)) {
            this.mLiveViewLayout.a(8);
            this.mLiveViewLayout.a(0);
            this.a(new Runnable() {
                public void run() {
                    g.this.g = System.currentTimeMillis();
                    g.this.mLiveViewLayout.d(0);
                    if (g.this.mPlayeWrapper != null && g.this.k == 0L) {
                        g.this.mPlayeWrapper.a(true, 0L, !g.this.v);
                    } else if (g.this.mPlayeWrapper != null) {
                        g.this.mPlayeWrapper.a(true, g.this.k, !g.this.v);
                    }

                    if (g.this.mMineHandler != null) {
                        g.this.mMineHandler.postDelayed(g.this.B, 100L);
                    }

                    g.this.l();
                }
            });
        }

        this.q();
    }

    public void l() {
        this.m();
        this.mMineHandler.postDelayed(this.D, 800L);
    }

    public void m() {
        this.mMineHandler.removeCallbacks(this.D);
    }

    public void a(e var1) {
        this.w = new WeakReference(var1);
    }

    private void c(int var1) {
        if (this.s()) {
            if (this.mLiveViewLayout != null) {
                this.mLiveViewLayout.h();
                if (this.j != null) {
                    this.j.a(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
                }

                this.h = System.currentTimeMillis() - this.g;
                this.mLiveViewLayout.a(this.t, this.mContextWeakReference, true);
                if (!this.s) {
                    AdEvent.a((Context)this.mContextWeakReference.get(), this.t, "embeded_ad", "feed_over", this.e(), 100);
                    this.s = true;
                    this.a(this.m, this.m);
                    this.l = this.k = this.m;
                }

                if (!this.u && this.a) {
                    this.e(this.mLiveViewLayout, (View)null);
                }

                this.A = true;
            }
        }
    }

    private boolean s() {
        return this.mContextWeakReference != null && this.mContextWeakReference.get() != null;
    }

    public void a(Runnable var1) {
        if (var1 != null) {
            if (this.mLiveViewLayout.n() && this.o) {
                var1.run();
            } else {
                this.b(var1);
            }

        }
    }

    private void
    b(Runnable var1) {
        if (this.mRunnableArrayList == null) {
            this.mRunnableArrayList = new ArrayList();
        }

        this.mRunnableArrayList.add(var1);
    }

    private void t() {
        if (this.mRunnableArrayList != null && !this.mRunnableArrayList.isEmpty()) {
            ArrayList var1 = new ArrayList(this.mRunnableArrayList);
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
                Runnable var3 = (Runnable)var2.next();
                var3.run();
            }

            this.mRunnableArrayList.clear();
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.a.c.a var1) {
        this.j = var1;
    }

    public void a() {
        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a();
        }

    }

    public void b() {
        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.f();
        }

        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.g();
        }

        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a(false, this.k, !this.v);
            this.l();
        }

    }

    public void e(long var1) {
        this.k = var1;
        this.l = this.l > this.k ? this.l : this.k;
        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.f();
        }

        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a(true, this.k, !this.v);
            this.l();
        }

    }

    public void c() {
        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.b();
        }

        this.mLiveViewLayout.a(this.t, this.mContextWeakReference, true);
        if (this.mMineHandler != null) {
            this.mMineHandler.removeCallbacks(this.C);
            this.mMineHandler.removeCallbacks(this.B);
        }

        this.m();
        this.r();
        if (!this.s && this.r) {
            AdEvent.a(mContextWeakReference.get(), this.t, "embeded_ad", "feed_break", this.e(), this.k());
            this.s = true;
        }

    }

    public void doResult(Message var1) {
        if (this.mLiveViewLayout != null && var1 != null && this.mContextWeakReference != null && this.mContextWeakReference.get() != null) {
            switch(var1.what) {
                case 108:
                    if (var1.obj instanceof Long && (Long)((Long)var1.obj) > 0L) {
                        this.m = (Long)((Long)var1.obj);
                    }
                    break;
                case 109:
                    if (var1.obj instanceof Long) {
                        this.k = (Long)((Long)var1.obj);
                        this.l = this.l > this.k ? this.l : this.k;
                        this.a(this.k, this.m);
                    }
                    break;
                case 302:
                    this.c(var1.what);
                    break;
                case 303:
                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.h();
                    }

                    if (this.j != null) {
                        this.j.b(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
                    }
                    break;
                case 304:
                    int var2 = var1.arg1;
                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.h();
                    }

                    if (this.q && var2 == 3 && !this.r) {
                        if (this.u) {
                            AdEvent.f((Context)this.mContextWeakReference.get(), this.t, "embeded_ad", "feed_auto_play");
                        } else {
                            AdEvent.f((Context)this.mContextWeakReference.get(), this.t, "embeded_ad", "feed_play");
                        }

                        this.r = true;
                    }
                    break;
                case 305:
                    if (this.mMineHandler != null) {
                        this.mMineHandler.removeCallbacks(this.C);
                    }

                    if (!this.q && !this.r) {
                        if (this.u) {
                            AdEvent.f((Context)this.mContextWeakReference.get(), this.t, "embeded_ad", "feed_auto_play");
                        } else {
                            AdEvent.f((Context)this.mContextWeakReference.get(), this.t, "embeded_ad", "feed_play");
                        }

                        this.r = true;
                    }

                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.h();
                    }
                    break;
                case 306:
                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.h();
                    }
            }

        }
    }

    public void a(b var1, View var2) {
        if (this.mPlayeWrapper != null && this.s()) {
            if (this.mPlayeWrapper.f()) {
                this.a();
                this.mLiveViewLayout.a(true, false);
                this.mLiveViewLayout.d();
            } else if (!this.mPlayeWrapper.h()) {
                if (this.mLiveViewLayout != null) {
                    this.mLiveViewLayout.a(this.e);
                }

                this.e(this.k);
                if (this.mLiveViewLayout != null) {
                    this.mLiveViewLayout.a(false, false);
                }
            } else {
                this.b();
                if (this.mLiveViewLayout != null) {
                    this.mLiveViewLayout.a(false, false);
                }
            }

        }
    }

    public void a(b var1, int var2) {
        if (this.mPlayeWrapper != null) {
            this.l();
            this.a(this.b, this.d(var2));
        }
    }

    public void b(b var1, int var2) {
        if (this.mPlayeWrapper != null) {
            this.m();
        }

        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.d();
        }

    }

    public void a(b var1, int var2, boolean var3) {
        if (this.s()) {
            Context var4 = (Context)this.mContextWeakReference.get();
            long var5 = (long)((float)((long)var2 * this.m) * 1.0F / (float)var4.getResources().getInteger(R.integer.video_progress_max));
            if (this.m > 0L) {
                this.b = (long)((int)var5);
            } else {
                this.b = 0L;
            }

            if (this.mLiveViewLayout != null) {
                this.mLiveViewLayout.a(this.b);
            }

        }
    }

    public void a(long var1, long var3) {
        this.k = var1;
        this.m = var3;
        this.mLiveViewLayout.a(var1, var3);
        int var5 = com.bytedance.sdk.openadsdk.core.video.d.a.a(var1, var3);
        this.mLiveViewLayout.b(var5);
    }

    public void b(b var1, View var2) {
        this.a(var1, var2, false, false);
    }

    public void a(b var1, View var2, boolean var3, boolean var4) {
        if (this.s()) {
            this.c(!this.a);
            if (!(this.mContextWeakReference.get() instanceof Activity)) {
                LogUtils.b(c, "context is not activity, not support this function.");
            } else {
                if (this.a) {
                    this.a(var3 ? 8 : 0);
                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.b(this.e);
                        this.mLiveViewLayout.c(false);
                    }
                } else {
                    this.a(1);
                    if (this.mLiveViewLayout != null) {
                        this.mLiveViewLayout.c(this.e);
                        this.mLiveViewLayout.c(false);
                    }
                }

                e var5 = this.w != null ? (e)this.w.get() : null;
                if (var5 != null) {
                    var5.a(this.a);
                }

            }
        }
    }

    public void a(int var1) {
        if (this.s()) {
            boolean var2 = var1 == 0 || var1 == 8;
            Context var3 = (Context)this.mContextWeakReference.get();
            if (var3 instanceof Activity) {
                Activity var4 = (Activity)var3;

                try {
                    var4.setRequestedOrientation(var1);
                } catch (Throwable var6) {
                    ;
                }

                if (this.mLiveViewLayout != null) {
                    this.mLiveViewLayout.p();
                }

                if (!var2) {
                    var4.getWindow().setFlags(1024, 1024);
                } else {
                    var4.getWindow().clearFlags(1024);
                }

            }
        }
    }

    public void c(b var1, View var2) {
        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.j();
        }

        this.c();
    }

    public void b(b var1, View var2, boolean var3, boolean var4) {
        if (this.u) {
            this.a();
        }

        if (var3 && !this.u && !this.n()) {
            this.mLiveViewLayout.a(!this.o(), false);
            this.mLiveViewLayout.a(var4, true, false);
        }

        if (this.mPlayeWrapper != null && this.mPlayeWrapper.f()) {
            this.mLiveViewLayout.d();
            this.mLiveViewLayout.c();
        } else {
            this.mLiveViewLayout.d();
        }

    }

    public void d(b var1, View var2) {
        if (this.a) {
            this.c(false);
            if (this.mLiveViewLayout != null) {
                this.mLiveViewLayout.c(this.e);
            }

            this.a(1);
        } else {
            this.c();
        }

    }

    public void e(b var1, View var2) {
        this.a(var1, var2, false);
    }

    public void a(b var1, View var2, boolean var3) {
        this.u();
    }

    private void u() {
        if (this.s()) {
            this.c(!this.a);
            if (!(this.mContextWeakReference.get() instanceof Activity)) {
                LogUtils.b(c, "context is not activity, not support this function.");
            } else {
                if (this.mLiveViewLayout != null) {
                    this.mLiveViewLayout.c(this.e);
                    this.mLiveViewLayout.c(false);
                }

                this.a(1);
                e var1 = this.w != null ? (e)this.w.get() : null;
                if (var1 != null) {
                    var1.a(this.a);
                }

            }
        }
    }

    protected void c(boolean var1) {
        this.a = var1;
    }

    public void f(b var1, View var2) {
    }

    public void a(b var1, SurfaceHolder var2) {
        this.o = true;
        if (this.mPlayeWrapper != null) {
            this.mPlayeWrapper.a(var2);
            this.t();
        }
    }

    public void a(b var1, SurfaceHolder var2, int var3, int var4, int var5) {
    }

    public void b(b var1, SurfaceHolder var2) {
        this.o = false;
    }

    public boolean n() {
        return this.mPlayeWrapper.k();
    }

    public boolean o() {
        return this.mPlayeWrapper != null ? this.mPlayeWrapper.f() : false;
    }

    public void d(long var1) {
        if (this.mLiveViewLayout != null) {
            if (this.mLiveViewLayout.p()) {
                if (var1 == this.m || !this.a || this.m <= 0L) {
                    return;
                }

                this.b = var1;
                this.a(this.b, this.d((int)(this.k * 100L / this.m)));
            }

        }
    }

    protected void a(long var1, boolean var3) {
        if (this.mPlayeWrapper != null) {
            if (var3) {
                this.p();
            }

            this.mPlayeWrapper.a(var1);
        }
    }

    private boolean d(int var1) {
        return this.mLiveViewLayout.c(var1);
    }

    public void p() {
        if (this.mLiveViewLayout != null) {
            this.mLiveViewLayout.d(0);
            this.mLiveViewLayout.b(false, false);
            this.mLiveViewLayout.c(false);
            this.mLiveViewLayout.c();
            this.mLiveViewLayout.e();
        }

    }

    public void a(com.bytedance.sdk.openadsdk.core.widget.a var1, float var2, boolean var3) {
        if (this.s()) {
            if (var1 != null && this.mPlayeWrapper != null && (this.mPlayeWrapper.f() || this.mPlayeWrapper.h())) {
                var1.a((Context)this.mContextWeakReference.get(), var2, var3, this.k, this.m);
            }

        }
    }

    public void a(VedioManager.enume var1, String var2) {
        switch(var1.ordinal()) {
            case 1:
                this.a();
                break;
            case 2:
                this.c();
                break;
            case 3:
                this.b();
                this.y = false;
                this.z = true;
        }

    }

    protected boolean b(int var1) {
        NetUtils.a var2 = NetUtils.b(com.bytedance.sdk.openadsdk.core.n.a());
        if (var2 == NetUtils.a.a) {
            this.mLiveViewLayout.a(this.t, this.mContextWeakReference, false);
        }

        if (var2 != NetUtils.a.e && var2 != NetUtils.a.a) {
            this.a();
            this.y = true;
            this.z = false;
            if (this.mLiveViewLayout != null && this.t != null) {
                return this.mLiveViewLayout.a(var1, this.t.a());
            }
        } else if (var2 == NetUtils.a.e) {
            this.y = false;
            if (this.mLiveViewLayout != null) {
                this.mLiveViewLayout.a();
            }
        }

        return true;
    }

    protected void a(Context var1) {
        if (this.s()) {
            NetUtils.a var2 = NetUtils.b(var1);
            if (this.F != var2) {
                if (!this.z) {
                    this.b(2);
                }

                this.F = var2;
                if (var2 == NetUtils.a.e) {
                    this.b();
                }

            }
        }
    }

    protected void q() {
        if (!this.G) {
            Context var1 = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
            this.G = true;
            IntentFilter var2 = new IntentFilter();
            var2.addAction("android.net.conn.CONNECTIVITY_CHANGE");

            try {
                var1.registerReceiver(this.E, var2);
            } catch (Exception var4) {
                ;
            }

        }
    }

    protected void r() {
        if (this.G) {
            Context var1 = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
            this.G = false;

            try {
                var1.unregisterReceiver(this.E);
            } catch (Exception var3) {
                ;
            }

        }
    }
}
