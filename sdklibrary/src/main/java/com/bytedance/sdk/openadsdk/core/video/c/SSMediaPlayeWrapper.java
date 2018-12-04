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

public class SSMediaPlayeWrapper implements VideoManager.a, VideoManager.b, VideoManager.c, VideoManager.d, VideoManager.e, VideoManager.f, MineHandler.OnResult {
    private VideoManager mVideoManager;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private long f;
    private Handler mineHandler;
    private Handler mHandler;
    private ArrayList<Runnable> mRunnables;
    private int j;
    private int k;
    private static boolean l = false;
    private String m;
    private static Map<Integer, Integer> sHashMap = new HashMap();
    private boolean o;
    private final Set<SurfaceTexture> mSurfaceTextures;
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
        this.mVideoManager = null;
        this.b = false;
        this.c = false;
        this.e = 201;
        this.f = -1L;
        this.j = 0;
        this.m = "0";
        this.mSurfaceTextures = new HashSet();
        this.q = new Object();
        this.r = null;
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.j = 0;
        this.mHandler = var1;
        HandlerThread var3 = new HandlerThread("VideoManager");
        var3.start();
        this.mineHandler = new MineHandler(var3.getLooper(), this);
        this.v = Build.VERSION.SDK_INT >= 17;
        this.q();
    }

    private void q() {
        if (this.mVideoManager == null) {
            LogUtils.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            this.mVideoManager = new MediaPlayerManager();
            this.m = "0";
            this.mVideoManager.a((VideoManager.a) this);
            this.mVideoManager.a((VideoManager.b)this);
            this.mVideoManager.a((VideoManager.c)this);
            this.mVideoManager.a((VideoManager.d)this);
            this.mVideoManager.a((VideoManager.e)this);
            this.mVideoManager.a((VideoManager.f)this);
            this.mVideoManager.b(this.b);
            this.c = false;
        }

    }

    public void a(boolean var1, long var2, boolean var4) {
        this.o = false;
        if (!var4) {
            if (this.mVideoManager != null) {
                this.a(true);
            }
        } else if (this.mVideoManager != null) {
            this.a(false);
        }

        if (var1) {
            this.c();
            this.f = var2;
        } else {
            this.s();
            if (this.mVideoManager != null) {
                this.f = var2 > this.mVideoManager.i() ? var2 : this.mVideoManager.i();
            }

            this.a(new Runnable() {
                public void run() {
                    SSMediaPlayeWrapper.this.mineHandler.sendEmptyMessageDelayed(100, 0L);
                }
            });
        }

    }

    public void a() {
        this.mineHandler.removeMessages(100);
        this.o = true;
        this.mineHandler.sendEmptyMessage(101);
        this.t();
    }

    public void b() {
        this.e = 203;
        this.t();
        if (this.mVideoManager != null) {
            this.r();
            if (this.mineHandler != null) {
                try {
                    this.b("release");
                    this.mineHandler.removeCallbacksAndMessages((Object)null);
                    this.d = true;
                    this.mineHandler.sendEmptyMessage(103);
                } catch (Throwable var2) {
                    ;
                }
            }

        }
    }

    public void c() {
        this.a(new Runnable() {
            public void run() {
                if (SSMediaPlayeWrapper.this.mineHandler != null) {
                    SSMediaPlayeWrapper.this.mineHandler.sendEmptyMessage(104);
                }

            }
        });
    }

    public void a(final long var1) {
        this.t();
        if (this.e == 207 || this.e == 206 || this.e == 209) {
            this.a(new Runnable() {
                public void run() {
                    if (SSMediaPlayeWrapper.this.mineHandler != null) {
                        SSMediaPlayeWrapper.this.mineHandler.obtainMessage(106, var1).sendToTarget();
                    }

                }
            });
        }

    }

    private boolean a(@NonNull SurfaceTexture var1) {
        Set var2 = this.mSurfaceTextures;
        synchronized(this.mSurfaceTextures) {
            return this.mSurfaceTextures.contains(var1);
        }
    }

    public void a(final SurfaceHolder var1) {
        this.a(new Runnable() {
            public void run() {
                SSMediaPlayeWrapper.this.q();
                if (SSMediaPlayeWrapper.this.mineHandler != null) {
                    SSMediaPlayeWrapper.this.mineHandler.obtainMessage(110, var1).sendToTarget();
                }

            }
        });
    }

    public void d() {
        if (this.mineHandler != null) {
            this.mineHandler.obtainMessage(108).sendToTarget();
        }

    }

    public void e() {
        if (this.mineHandler != null) {
            this.mineHandler.obtainMessage(109).sendToTarget();
        }

    }

    public void a(final String var1) {
        this.a(new Runnable() {
            public void run() {
                SSMediaPlayeWrapper.this.q();
                if (SSMediaPlayeWrapper.this.mineHandler != null) {
                    SSMediaPlayeWrapper.this.mineHandler.obtainMessage(107, var1).sendToTarget();
                }

            }
        });
    }

    public boolean f() {
        return (this.e == 206 || this.mineHandler.hasMessages(100)) && !this.o;
    }

    public boolean g() {
        return this.j() || this.f() || this.start();
    }

    public boolean start() {
        return (this.e == 207 || this.o) && !this.mineHandler.hasMessages(100);
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
        if (this.mVideoManager != null) {
            switch(var1.what) {
                case 100:
                    if (this.e != 205 && this.e != 206 && this.e != 207 && this.e != 209) {
                        var2 = true;
                    } else {
                        try {
                            this.mVideoManager.start();
                            this.e = 206;
                            if (this.f > 0L) {
                                this.mVideoManager.a(this.f);
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
                            this.mVideoManager.pause();
                            this.e = 207;
                            this.o = false;
                        } catch (Exception var18) {
                            var4 = 1005;
                        }
                    }
                    break;
                case 102:
                    try {
                        this.mVideoManager.l();
                        this.e = 201;
                    } catch (Exception var15) {
                        var4 = 1006;
                    }
                    break;
                case 103:
                    try {
                        this.mVideoManager.k();
                    } catch (Exception var16) {
                        var16.printStackTrace();
                        var4 = 1009;
                    }

                    this.d = false;
                    this.a(309, (Object)null);
                    this.e = 203;
                    this.mVideoManager = null;
                    break;
                case 104:
                    if (this.e != 202 && this.e != 208) {
                        var2 = true;
                    } else {
                        try {
                            ((MediaPlayerManager)this.mVideoManager).getMediaPlayer().prepareAsync();
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
                            this.mVideoManager.stop();
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
                            this.mVideoManager.a((Long)var1.obj);
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
                                this.mVideoManager.setDataSource(var26);
                            } else {
                                Uri var25 = Uri.parse(var26);
                                this.mVideoManager.setDataSource(var26);
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
                            var24 = this.mVideoManager.j();
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
                            var7 = this.mVideoManager.i();
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
                        this.mVideoManager.setSurfaceHolder(var23);
                        if (this.j == 2) {
                            this.mVideoManager.a(com.bytedance.sdk.openadsdk.core.n.a(), 10);
                        }

                        this.mVideoManager.setScreenOnWhilePlaying(true);
                    } catch (Exception var13) {
                        var4 = 1002;
                        LogUtils.e("SSMediaPlayeWrapper", var13.getMessage());
                    }
                    break;
                case 111:
                    try {
                        SurfaceTexture var5 = (SurfaceTexture)var1.obj;
                        Set var6 = this.mSurfaceTextures;
                        synchronized(this.mSurfaceTextures) {
                            if (!this.a(var5)) {
                                this.mVideoManager.setSurface(new Surface(var5));
                            }
                        }

                        this.mVideoManager.setScreenOnWhilePlaying(true);
                        this.mVideoManager.a(com.bytedance.sdk.openadsdk.core.n.a(), 10);
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

        if (this.mHandler != null) {
            this.mHandler.obtainMessage(var1, var2).sendToTarget();
        }

    }

    public void a(VideoManager var1, int var2) {
        if (this.mVideoManager == var1) {
            if (this.mHandler != null) {
                this.mHandler.obtainMessage(301, var2).sendToTarget();
            }

        }
    }

    public void l() {
        Integer var1 = (Integer) sHashMap.get(this.j);
        if (var1 == null) {
            sHashMap.put(this.j, 1);
        } else {
            sHashMap.put(this.j, var1 + 1);
        }

    }

    public void a(VideoManager var1) {
        this.e = !this.b ? 209 : 206;
        sHashMap.remove(this.j);
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(302).sendToTarget();
        }

        this.b("completion");
        this.t();
    }

    public boolean a(VideoManager var1, int var2, int var3) {
        this.e = 200;
        this.l();
        if (this.mHandler != null) {
            this.mHandler.obtainMessage(303, var2, var3).sendToTarget();
        }

        return true;
    }

    public boolean b(VideoManager var1, int var2, int var3) {
        if (this.mVideoManager != var1) {
            return false;
        } else {
            if (this.mHandler != null) {
                this.mHandler.obtainMessage(304, var2, var3).sendToTarget();
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

    public void b(VideoManager var1) {
        this.e = 205;
        if (this.o) {
            this.mineHandler.post(new Runnable() {
                public void run() {
                    try {
                        SSMediaPlayeWrapper.this.mVideoManager.pause();
                        SSMediaPlayeWrapper.this.e = 207;
                        SSMediaPlayeWrapper.this.o = false;
                    } catch (Exception var2) {
                        ;
                    }

                }
            });
        } else {
            this.mineHandler.sendMessage(this.mineHandler.obtainMessage(100, -1, -1));
        }

        sHashMap.remove(this.j);
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(305);
        }

        this.m();
    }

    protected void m() {
        if (!this.v && this.u <= 0L) {
            this.u = System.currentTimeMillis();
        }

    }

    public void c(VideoManager var1) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(306);
        }

    }

    private void b(Runnable var1) {
        if (this.mRunnables == null) {
            this.mRunnables = new ArrayList();
        }

        this.mRunnables.add(var1);
    }

    private void r() {
        if (this.mRunnables != null && !this.mRunnables.isEmpty()) {
            this.mRunnables.clear();
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
                this.mVideoManager.a(0.0F, 0.0F);
            } else {
                this.mVideoManager.a(1.0F, 1.0F);
            }
        } catch (Throwable var3) {
            ;
        }

    }

    private void b(String var1) {
        if (this.mineHandler != null) {
            this.mineHandler.removeMessages(201);
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