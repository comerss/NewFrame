/*     */ package com.bytedance.sdk.openadsdk.core.ffff;
/*     */ 
/*     */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.core.nibuguan.j;
import com.bytedance.sdk.openadsdk.ggg.m;
import com.bytedance.sdk.openadsdk.ggg.q;
import com.bytedance.sdk.openadsdk.ggg.t;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
class afff implements com.bytedance.sdk.openadsdk.ggg.t.a {
    private static volatile afff a;
    private Context mContext;
    private t c = new t(Looper.getMainLooper(), this);
    private afff.a d;
    private afff.b e;
    private afff.c f;
    private ScheduledExecutorService g = Executors.newSingleThreadScheduledExecutor();

    private afff(Context var1) {
        if (var1 != null) {
            this.mContext = var1.getApplicationContext();
        }

    }

    static afff a(Context var0) {
        if (a == null) {
            synchronized(a.class) {
                if (a == null) {
                    a = new afff(var0);
                }
            }
        }

        return a;
    }

    void a(com.bytedance.sdk.openadsdk.core.nibuguan.j var1) {
        if (var1 != null) {
            File var2 = this.a(this.mContext, "/splash_ad_cache/", "tt_splash_image_cache");
            if (var2 != null) {
                this.a(var1.a().r());
                this.a(var1, var2);
            }
        }
    }

    private void a(com.bytedance.sdk.openadsdk.core.nibuguan.j var1, File var2) {
        if (this.f == null) {
            this.f = new afff.c(var1, var2);
        } else {
            this.f.a(var1);
            this.f.a(var2);
        }

        this.g.execute(this.f);
    }

    private void a(long var1) {
        SharedPreferences var3 = this.mContext.getSharedPreferences("tt_splash", 0);
        SharedPreferences.Editor var4 = var3.edit();
        var4.putLong("expiration", var1).putLong("update", System.currentTimeMillis() / 1000L).putBoolean("has_ad_cache", true).apply();
    }

    void a(@NonNull afff.a var1) {
        File var2 = this.a(this.mContext, "/splash_ad_cache/", "tt_splash_image_cache");
        if (var2 == null) {
            var1.a();
        }

        this.d = var1;
        this.g.execute(this.a(var2));
    }

    private Runnable a(File var1) {
        if (this.e == null) {
            this.e = new afff.b(var1);
        } else {
            this.e.a(var1);
        }

        return this.e;
    }

    boolean a() {
        SharedPreferences var1 = this.mContext.getSharedPreferences("tt_splash", 0);
        boolean var2 = var1.getBoolean("has_ad_cache", false);
        return var2;
    }

    boolean b() {
        SharedPreferences var1 = this.mContext.getSharedPreferences("tt_splash", 0);
        long var2 = var1.getLong("expiration", 0L);
        long var4 = var1.getLong("update", 0L);
        long var6 = System.currentTimeMillis() / 1000L;
        return var6 < var4 || var6 >= var2;
    }

    private File a(Context var1, String var2, String var3) {
        return com.bytedance.sdk.openadsdk.ggg.f.a(var1, var2, var3);
    }

    public void a(Message var1) {
        if (var1.what == 1) {
            if (this.d != null) {
                if (var1.obj != null && var1.obj instanceof j) {
                    this.d.a((j)var1.obj);
                    m.b("SplashAdCacheManager", "缓存反序列化成功");
                } else {
                    this.d.a();
                    m.b("SplashAdCacheManager", "缓存反序列化失败");
                }
            }

            this.c.removeCallbacksAndMessages((Object)null);
        }

    }

    void c() {
        SharedPreferences var1 = this.mContext.getSharedPreferences("tt_materialMeta", 0);
        var1.edit().clear().apply();
        SharedPreferences var2 = this.mContext.getSharedPreferences("tt_splash", 0);
        var2.edit().clear().apply();
    }

    interface a {
        void a(@NonNull j var1);

        void a();
    }

    private static class c implements Runnable {
        private com.bytedance.sdk.openadsdk.core.nibuguan.j a;
        private File b;

        public c(com.bytedance.sdk.openadsdk.core.nibuguan.j var1, File var2) {
            this.a = var1;
            this.b = var2;
        }

        public void a(com.bytedance.sdk.openadsdk.core.nibuguan.j var1) {
            this.a = var1;
        }

        public void a(File var1) {
            this.b = var1;
        }

        public void run() {
            this.a();
            this.b();
        }

        private void a() {
            BufferedOutputStream var1 = null;

            try {
                var1 = new BufferedOutputStream(new FileOutputStream(this.b));
                var1.write(this.a.b());
                var1.flush();
            } catch (IOException var11) {
                ;
            } finally {
                try {
                    if (var1 != null) {
                        var1.close();
                    }
                } catch (IOException var10) {
                    ;
                }

            }

        }

        private void b() {
            SharedPreferences var1 = n.a().getSharedPreferences("tt_materialMeta", 0);
            SharedPreferences.Editor var2 = var1.edit();
            var2.putString("materialMeta", this.a.c().c()).apply();
        }
    }

    private class b implements Runnable {
        private File b;

        public b(File var2) {
            this.b = var2;
        }

        public void a(File var1) {
            this.b = var1;
        }

        public void run() {
            Message var1 = c.obtainMessage();
            var1.what = 1;

            try {
                h var2 = this.a();
                if (var2 != null) {
                    byte[] var3 = this.b(this.b);
                    if (var3 != null && var3.length != 0) {
                        var1.obj = new j(var2, var3);
                    }
                }

                c();
            } catch (Exception var7) {
                ;
            } finally {
               c.sendMessage(var1);
            }

        }

        public byte[] b(File var1) {
            ByteArrayOutputStream var2 = new ByteArrayOutputStream();
            byte[] var4 = new byte[1024];
            FileInputStream var5 = null;

            try {
                var5 = new FileInputStream(var1);

                int var3;
                while((var3 = var5.read(var4, 0, var4.length)) != -1) {
                    var2.write(var4, 0, var3);
                }

                var2.flush();
            } catch (Exception var15) {
                ;
            } finally {
                try {
                    if (var2 != null) {
                        var2.close();
                    }

                    if (var5 != null) {
                        var5.close();
                    }
                } catch (IOException var14) {
                    ;
                }

            }

            return var2.toByteArray();
        }

        private h a() {
            SharedPreferences var1 = mContext.getSharedPreferences("tt_materialMeta", 0);
            String var2 = var1.getString("materialMeta", (String)null);
            if (!q.a(var2)) {
                try {
                    com.bytedance.sdk.openadsdk.core.p.aClass var3 = com.bytedance.sdk.openadsdk.core.p.aClass.a(new JSONObject(var2));
                    if (var3 != null && var3.d != null && var3.d.b() != null && !var3.d.b().isEmpty()) {
                        h var4 = (h)var3.d.b().get(0);
                        if (var4.v()) {
                            return var4;
                        }
                    }
                } catch (JSONException var5) {
                    ;
                }
            }

            return null;
        }
    }
}
