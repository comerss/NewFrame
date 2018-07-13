/*     */ package com.bytedance.sdk.openadsdk.core.video.c;
/*     */ 
/*     */

/*     */

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.Surface;
import android.view.SurfaceHolder;

import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SSMediaPlayeWrapper implements cc.a, cc.b, cc.c, cc.d, cc.e, cc.f, MineHandler.OnResult {
    private cc a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private long f;
    private Handler g;
    private Handler h;
    private ArrayList<Runnable> i;
    private int j;
    private int k;
    private static boolean l = false;
    private String m;
    private static Map<Integer, Integer> n = new HashMap();
    private boolean o;
    private final Set<SurfaceTexture> p;
    private final Object q;
    private StringBuilder r;
    private boolean s;
    private long t;
    private long u;
    private boolean v;

    public SSMediaPlayeWrapper(Handler var1) {
        this(var1, -1);
    }

    public SSMediaPlayeWrapper(Handler var1, int var2) {
        this.a = null;
        this.b = false;
        this.c = false;
        this.e = 201;
        this.f = -1L;
        this.j = 0;
        this.m = "0";
        this.p = new HashSet();
        this.q = new Object();
        this.r = null;
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.j = 0;
        this.h = var1;
        HandlerThread var3 = new HandlerThread("VideoManager");
        var3.start();
        this.g = new MineHandler(var3.getLooper(), this);
        this.v = Build.VERSION.SDK_INT >= 17;
        this.q();
    }

    private void q() {
        if (this.a == null) {
            LogUtils.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            this.a = new com.bytedance.sdk.openadsdk.core.video.c.b();
            this.m = "0";
            this.a.a((cc.a) this);
            this.a.a((cc.b)this);
            this.a.a((cc.c)this);
            this.a.a((cc.d)this);
            this.a.a((cc.e)this);
            this.a.a((cc.f)this);
            this.a.b(this.b);
            this.c = false;
        }

    }

    public void a(boolean var1, long var2, boolean var4) {
        this.o = false;
        if (!var4) {
            if (this.a != null) {
                this.a(true);
            }
        } else if (this.a != null) {
            this.a(false);
        }

        if (var1) {
            this.c();
            this.f = var2;
        } else {
            this.s();
            if (this.a != null) {
                this.f = var2 > this.a.i() ? var2 : this.a.i();
            }

            this.a(new Runnable() {
                public void run() {
                    SSMediaPlayeWrapper.this.g.sendEmptyMessageDelayed(100, 0L);
                }
            });
        }

    }

    public void a() {
        this.g.removeMessages(100);
        this.o = true;
        this.g.sendEmptyMessage(101);
        this.t();
    }

    public void b() {
        this.e = 203;
        this.t();
        if (this.a != null) {
            this.r();
            if (this.g != null) {
                try {
                    this.b("release");
                    this.g.removeCallbacksAndMessages((Object)null);
                    this.d = true;
                    this.g.sendEmptyMessage(103);
                } catch (Throwable var2) {
                    ;
                }
            }

        }
    }

    public void c() {
        this.a(new Runnable() {
            public void run() {
                if (SSMediaPlayeWrapper.this.g != null) {
                    SSMediaPlayeWrapper.this.g.sendEmptyMessage(104);
                }

            }
        });
    }

    public void a(final long var1) {
        this.t();
        if (this.e == 207 || this.e == 206 || this.e == 209) {
            this.a(new Runnable() {
                public void run() {
                    if (SSMediaPlayeWrapper.this.g != null) {
                        SSMediaPlayeWrapper.this.g.obtainMessage(106, var1).sendToTarget();
                    }

                }
            });
        }

    }

    private boolean a(@NonNull SurfaceTexture var1) {
        Set var2 = this.p;
        synchronized(this.p) {
            return this.p.contains(var1);
        }
    }

    public void a(final SurfaceHolder var1) {
        this.a(new Runnable() {
            public void run() {
                SSMediaPlayeWrapper.this.q();
                if (SSMediaPlayeWrapper.this.g != null) {
                    SSMediaPlayeWrapper.this.g.obtainMessage(110, var1).sendToTarget();
                }

            }
        });
    }

    public void d() {
        if (this.g != null) {
            this.g.obtainMessage(108).sendToTarget();
        }

    }

    public void e() {
        if (this.g != null) {
            this.g.obtainMessage(109).sendToTarget();
        }

    }

    public void a(final String var1) {
        this.a(new Runnable() {
            public void run() {
                SSMediaPlayeWrapper.this.q();
                if (SSMediaPlayeWrapper.this.g != null) {
                    SSMediaPlayeWrapper.this.g.obtainMessage(107, var1).sendToTarget();
                }

            }
        });
    }

    public boolean f() {
        return (this.e == 206 || this.g.hasMessages(100)) && !this.o;
    }

    public boolean g() {
        return this.j() || this.f() || this.h();
    }

    public boolean h() {
        return (this.e == 207 || this.o) && !this.g.hasMessages(100);
    }

    public boolean i() {
        return this.e == 203;
    }

    public boolean j() {
        return this.e == 205;
    }

    public boolean k() {
        return this.e == 209;
    }

    public void doResult(Message var1) {
        boolean var2 = false;
        int var3 = var1.what;
        Integer var4 = null;
        if (this.a != null) {
            switch(var1.what) {
                case 100:
                    if (this.e != 205 && this.e != 206 && this.e != 207 && this.e != 209) {
                        var2 = true;
                    } else {
                        try {
                            this.a.f();
                            this.e = 206;
                            if (this.f > 0L) {
                                this.a.a(this.f);
                                this.f = -1L;
                            }
                        } catch (Exception var19) {
                            var4 = 1004;
                        }
                    }
                    break;
                case 101:
                    if (this.e != 206 && this.e != 207 && this.e != 209) {
                        var2 = true;
                    } else {
                        try {
                            this.a.h();
                            this.e = 207;
                            this.o = false;
                        } catch (Exception var18) {
                            var4 = 1005;
                        }
                    }
                    break;
                case 102:
                    try {
                        this.a.l();
                        this.e = 201;
                    } catch (Exception var15) {
                        var4 = 1006;
                    }
                    break;
                case 103:
                    try {
                        this.a.k();
                    } catch (Exception var16) {
                        var16.printStackTrace();
                        var4 = 1009;
                    }

                    this.d = false;
                    this.a(309, (Object)null);
                    this.e = 203;
                    this.a = null;
                    break;
                case 104:
                    if (this.e != 202 && this.e != 208) {
                        var2 = true;
                    } else {
                        try {
                            ((com.bytedance.sdk.openadsdk.core.video.c.b)this.a).e().prepareAsync();
                        } catch (Exception var17) {
                            var17.printStackTrace();
                            var4 = 1003;
                        }
                    }
                    break;
                case 105:
                    if (this.e != 205 && this.e != 206 && this.e != 208 && this.e != 207 && this.e != 209) {
                        var2 = true;
                    } else {
                        try {
                            this.a.g();
                            this.e = 208;
                        } catch (Exception var12) {
                            var4 = 1008;
                        }
                    }
                    break;
                case 106:
                    if (this.e != 206 && this.e != 207 && this.e != 209) {
                        var2 = true;
                    } else {
                        try {
                            this.a.a((Long)var1.obj);
                        } catch (Exception var14) {
                            var4 = 1007;
                        }
                    }
                    break;
                case 107:
                    if (this.e != 201 && this.e != 203) {
                        var2 = true;
                    } else {
                        try {
                            String var26 = (String)var1.obj;
                            if (var26 != null && var26.startsWith("/")) {
                                this.a.a(var26);
                            } else {
                                Uri var25 = Uri.parse(var26);
                                this.a.a(var26);
                            }

                            this.e = 202;
                        } catch (Exception var22) {
                            var22.printStackTrace();
                            var4 = 1001;
                        }
                    }
                    break;
                case 108:
                    long var24 = 0L;
                    if (this.e == 206 || this.e == 207) {
                        try {
                            var24 = this.a.j();
                        } catch (Exception var11) {
                            var4 = 1010;
                        }
                    }

                    this.a(108, var24);
                    break;
                case 109:
                    long var7 = 0L;
                    if (this.e == 206 || this.e == 207) {
                        try {
                            var7 = this.a.i();
                        } catch (Exception var10) {
                            var10.printStackTrace();
                            var4 = 1011;
                        }
                    }

                    if (var7 > 0L) {
                        this.a(109, var7);
                    }
                    break;
                case 110:
                    try {
                        SurfaceHolder var23 = (SurfaceHolder)var1.obj;
                        this.a.a(var23);
                        if (this.j == 2) {
                            this.a.a(com.bytedance.sdk.openadsdk.core.n.a(), 10);
                        }

                        this.a.a(true);
                    } catch (Exception var13) {
                        var4 = 1002;
                        LogUtils.e("SSMediaPlayeWrapper", var13.getMessage());
                    }
                    break;
                case 111:
                    try {
                        SurfaceTexture var5 = (SurfaceTexture)var1.obj;
                        Set var6 = this.p;
                        synchronized(this.p) {
                            if (!this.a(var5)) {
                                this.a.a(new Surface(var5));
                            }
                        }

                        this.a.a(true);
                        this.a.a(com.bytedance.sdk.openadsdk.core.n.a(), 10);
                    } catch (Exception var21) {
                        var4 = 1002;
                        LogUtils.e("SSMediaPlayeWrapper", var21.getMessage());
                    }
                case 201:
            }
        }

        if (var4 != null) {
            this.a(310, var4);
        }

        if (var2) {
            this.e = 200;
            if (!this.c) {
                this.a(308, var3);
                this.c = true;
            }
        }

    }

    private void a(int var1, Object var2) {
        if (var1 == 309) {
            this.o();
        }

        if (this.h != null) {
            this.h.obtainMessage(var1, var2).sendToTarget();
        }

    }

    public void a(cc var1, int var2) {
        if (this.a == var1) {
            if (this.h != null) {
                this.h.obtainMessage(301, var2).sendToTarget();
            }

        }
    }

    public void l() {
        Integer var1 = (Integer)n.get(this.j);
        if (var1 == null) {
            n.put(this.j, 1);
        } else {
            n.put(this.j, var1 + 1);
        }

    }

    public void a(cc var1) {
        this.e = !this.b ? 209 : 206;
        n.remove(this.j);
        if (this.h != null) {
            this.h.obtainMessage(302).sendToTarget();
        }

        this.b("completion");
        this.t();
    }

    public boolean a(cc var1, int var2, int var3) {
        this.e = 200;
        this.l();
        if (this.h != null) {
            this.h.obtainMessage(303, var2, var3).sendToTarget();
        }

        return true;
    }

    public boolean b(cc var1, int var2, int var3) {
        if (this.a != var1) {
            return false;
        } else {
            if (this.h != null) {
                this.h.obtainMessage(304, var2, var3).sendToTarget();
            }

            this.a(var2, var3);
            return false;
        }
    }

    protected void a(int var1, int var2) {
        if (var1 == 701) {
            this.t();
        } else if (var1 == 702) {
            if (this.u <= 0L) {
                this.u = System.currentTimeMillis();
            }
        } else if (this.v && var1 == 3 && this.u <= 0L) {
            this.u = System.currentTimeMillis();
        }

    }

    public void b(cc var1) {
        this.e = 205;
        if (this.o) {
            this.g.post(new Runnable() {
                public void run() {
                    try {
                        SSMediaPlayeWrapper.this.a.h();
                        SSMediaPlayeWrapper.this.e = 207;
                        SSMediaPlayeWrapper.this.o = false;
                    } catch (Exception var2) {
                        ;
                    }

                }
            });
        } else {
            this.g.sendMessage(this.g.obtainMessage(100, -1, -1));
        }

        n.remove(this.j);
        if (this.h != null) {
            this.h.sendEmptyMessage(305);
        }

        this.m();
    }

    protected void m() {
        if (!this.v && this.u <= 0L) {
            this.u = System.currentTimeMillis();
        }

    }

    public void c(cc var1) {
        if (this.h != null) {
            this.h.sendEmptyMessage(306);
        }

    }

    private void b(Runnable var1) {
        if (this.i == null) {
            this.i = new ArrayList();
        }

        this.i.add(var1);
    }

    private void r() {
        if (this.i != null && !this.i.isEmpty()) {
            this.i.clear();
        }
    }

    public void a(Runnable var1) {
        if (var1 != null) {
            if (!this.d) {
                var1.run();
            } else {
                this.b(var1);
            }

        }
    }

    public void a(int var1, boolean var2) {
        if (var2) {
            int var3 = this.n();
            if (var3 != var1) {
                l = true;
                this.k = var3;
            }
        }

        @SuppressLint("WrongConstant") AudioManager var4 = (AudioManager)com.bytedance.sdk.openadsdk.core.n.a().getSystemService("audio");
        var4.setStreamVolume(3, var1, 0);
    }

    public int n() {
        @SuppressLint("WrongConstant") AudioManager var1 = (AudioManager)com.bytedance.sdk.openadsdk.core.n.a().getSystemService("audio");
        return var1.getStreamVolume(3);
    }

    public void o() {
        if (l) {
            this.a(this.k, false);
            l = false;
        }

    }

    public void a(boolean var1) {
        try {
            if (var1) {
                this.a.a(0.0F, 0.0F);
            } else {
                this.a.a(1.0F, 1.0F);
            }
        } catch (Throwable var3) {
            ;
        }

    }

    private void b(String var1) {
        if (this.g != null) {
            this.g.removeMessages(201);
        }

        Object var2 = this.q;
        synchronized(this.q) {
            if (this.r != null) {
                this.r = null;
            }

        }
    }

    private void s() {
        if (this.u <= 0L) {
            this.u = System.currentTimeMillis();
        }

    }

    private void t() {
        if (this.u > 0L) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = 0L;
        }

    }

    public long p() {
        this.t();
        return this.t;
    }
}