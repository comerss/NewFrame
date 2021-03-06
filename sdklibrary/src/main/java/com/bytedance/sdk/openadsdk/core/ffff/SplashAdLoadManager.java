/*     */ package com.bytedance.sdk.openadsdk.core.ffff;
/*     */ 
/*     */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.core.ApiException;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeData;
import com.bytedance.sdk.openadsdk.core.nibuguan.SplashNative;
import com.bytedance.sdk.openadsdk.core.AdNativeListener;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.ImageHelper;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

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
public class SplashAdLoadManager implements MineHandler.OnResult {
    private static volatile SplashAdLoadManager a;
    private AdSlot b;
    private com.bytedance.sdk.openadsdk.core.nibuguan.i c;
    private WeakReference<TTAdNative.SplashAdListener> d;
    private AdNativeListener mAdNativeListener = n.c();
    private Context f;
    private MineHandler mHandler;
    private volatile boolean h;
    private long i;
    private long j;

    private SplashAdLoadManager(Context var1) {
        if (var1 != null) {
            this.f = var1.getApplicationContext();
        }

        this.mHandler = new MineHandler(Looper.myLooper(), this);
    }

    public static SplashAdLoadManager a(Context var0) {
        if (a == null) {
            Class var1 = SplashAdLoadManager.class;
            synchronized(SplashAdLoadManager.class) {
                if (a == null) {
                    a = new SplashAdLoadManager(var0);
                }
            }
        }

        return a;
    }

    public void loadSpalsh(AdSlot var1, @NonNull TTAdNative.SplashAdListener var2, int var3) {
        this.b = var1;
        this.d = new WeakReference(var2);
        this.h = false;
//        var3 = var3 <= 0 ? 800 : var3;
        this.mHandler.sendEmptyMessageDelayed(2, (long)5000);
        this.c = new com.bytedance.sdk.openadsdk.core.nibuguan.i();
        com.bytedance.sdk.openadsdk.hhh.a().b(SplashNative.a().a(3).b(this.b.getCodeId()).d(c.a));
        this.c();
    }

    private void a(AdSlot var1, final TTAdNative.SplashAdListener adListener, final boolean var3, final boolean var4) {
        int var5 = var4 ? 4 : 3;
        this.i = System.currentTimeMillis();
        final SplashNative var6 = SplashNative.a().a(3).b(this.b.getCodeId()).d(this.c.a);
        this.mAdNativeListener.getAds(var1, c, var5, new AdNativeListener.OnAdLoad() {

            public void onError(int var1, String var2x) {
                if (!var4) {
                    com.bytedance.sdk.openadsdk.hhh.a().d(var6.b(var1).e(var2x));
                    adListener.onError(var1, var2x);
                    SplashAdLoadManager.this.a();
                }

                LogUtils.b("SplashAdLoadManager", var2x + var1);
            }
            public void onSuccess(final NativeData var1) {
                LogUtils.b("SplashAdLoadManager", var1.toString());
                String var3x;
                if (var1 != null && var1.b() != null && !var1.b().isEmpty() && var1.b().get(0) != null && !TextUtils.isEmpty((var1.b().get(0)).o())) {
                    var6.f(((NativeAdData)var1.b().get(0)).o());
                    var6.c((var1.b().get(0)).l());

                    try {
                        JSONObject var2x = new JSONObject((var1.b().get(0)).o());
                        var3x = var2x.getString("req_id");
                        var6.d(var3x);
                    } catch (JSONException var5) {
                        var5.printStackTrace();
                    }
                }

                if (var1 != null && var1.b() != null && !var1.b().isEmpty()) {
                    final NativeAdData var6x = var1.b().get(0);
                    if (var6x.v()) {
                        AdEvent.a(var6x, "splash_ad", "load_ad_duration", System.currentTimeMillis() - SplashAdLoadManager.this.i);
                        SplashAdLoadManager.this.i = 0L;
                        var3x = (var6x.f().get(0)).a();
                        SplashAdLoadManager.this.j = System.currentTimeMillis();
                        final String finalVar3x = var3x;
                        ImageHelper.loadImage(SplashAdLoadManager.this.f, var3x, new ImageHelper.OnLoadImage() {
                            @MainThread
                            public void onsuccess(@NonNull byte[] var1x) {
                                AdEvent.a(var6x, "splash_ad", "download_creative_duration", System.currentTimeMillis() - SplashAdLoadManager.this.j);
                                SplashAdLoadManager.this.j = 0L;
                                if (!var3 && !SplashAdLoadManager.this.h) {
                                    SplashAdLoadManager.this.h = true;
                                    int var2x = (var6x.f().get(0)).b();
                                    Drawable drawable = ImageHelper.loadImage(var1x, var2x);
                                    if (drawable != null) {
                                        com.bytedance.sdk.openadsdk.hhh.a().c(var6);
                                        TTSplashAdImpl var4x = new TTSplashAdImpl(SplashAdLoadManager.this.f, var6x);
                                        var4x.a(drawable);
                                        adListener.onSplashAdLoad(var4x);
                                        LogUtils.b("SplashAdLoadManager", "从网络加载成功并回调出去");
                                    } else {
                                        com.bytedance.sdk.openadsdk.hhh.a().e(var6.b(-7).e(ApiException.a(-7)).g(finalVar3x));
                                        com.bytedance.sdk.openadsdk.hhh.a().d(var6.b(-7).e(ApiException.a(-7)));
                                        adListener.onError(-7, ApiException.a(-7));
                                        LogUtils.b("SplashAdLoadManager", "图片加载失败");
                                    }

                                    SplashAdLoadManager.this.a();
                                } else {
                                    LogUtils.b("SplashAdLoadManager", "加载的广告缓存到本地");
                                    OnResultImpl.getDefault(f).a(new com.bytedance.sdk.openadsdk.core.nibuguan.j(var1, var6x, var1x));
                                }

                            }

                            @MainThread
                            public void onFail() {
                                if (!var4) {
                                    com.bytedance.sdk.openadsdk.hhh.a().e(var6.b(-7).e(ApiException.a(-7)).g(finalVar3x));
                                    com.bytedance.sdk.openadsdk.hhh.a().d(var6.b(-7).e(ApiException.a(-7)));
                                    adListener.onError(-7, ApiException.a(-7));
                                    SplashAdLoadManager.this.a();
                                }

                                LogUtils.b("SplashAdLoadManager", "图片加载失败");
                            }
                        });
                    } else {
                        if (!var4) {
                            com.bytedance.sdk.openadsdk.hhh.a().d(var6.b(-3).e(ApiException.a(-3)));
                            adListener.onError(-3, ApiException.a(-3));
                            SplashAdLoadManager.this.a();
                        }

                        LogUtils.b("SplashAdLoadManager", "网络请求的广告解析失败");
                    }
                } else {
                    if (!var4) {
                        com.bytedance.sdk.openadsdk.hhh.a().d(var6.b(-3).e(ApiException.a(-3)));
                        adListener.onError(-3, ApiException.a(-3));
                        SplashAdLoadManager.this.a();
                    }

                    LogUtils.b("SplashAdLoadManager", "网络请求的广告解析失败");
                }

            }
        });
    }

    private void c() {
        final TTAdNative.SplashAdListener adListener = this.d == null ? null : (TTAdNative.SplashAdListener)this.d.get();
        if (adListener != null) {
            OnResultImpl var2 = OnResultImpl.getDefault(this.f);
            if (!var2.a()) {
                LogUtils.b("SplashAdLoadManager", "缓存中没有开屏广告");
                this.a(this.b, adListener, false, false);
            } else if (var2.b()) {
                var2.c();
                LogUtils.b("SplashAdLoadManager", "缓存过期");
                this.a(this.b, adListener, false, false);
            } else {
                var2.a(new OnResultImpl.a() {
                    public void a(@NonNull final com.bytedance.sdk.openadsdk.core.nibuguan.j var1x) {
                        if (var1x.a() != null && var1x.a().v() && var1x.b() != null && var1x.b().length != 0) {
                            int var2 = (var1x.a().f().get(0)).b();
                            final Drawable var3 = ImageHelper.loadImage(var1x.b(), var2);
                            if (var3 != null) {
                                var1x.a().b(true);
                                final TTSplashAdImpl var4 = new TTSplashAdImpl(SplashAdLoadManager.this.f, var1x.a());
                                n.c().a(var1x.a().l(), var1x.a().o(), new SplashAdLoadManager.a() {
                                    public void a(boolean var1xx) {
                                        if (var1xx && !SplashAdLoadManager.this.h) {
                                            String var2 = SplashAdLoadManager.this.c.a;
                                            String var3x = var1x.a().l();
                                            String var4x = var1x.a().o();
                                            if (!TextUtils.isEmpty(var1x.a().o())) {
                                                try {
                                                    JSONObject var5 = new JSONObject(var1x.a().o());
                                                    var2 = var5.getString("req_id");
                                                } catch (JSONException var6) {
                                                    var6.printStackTrace();
                                                }
                                            }

                                            com.bytedance.sdk.openadsdk.hhh.a().c(SplashNative.a().c(var3x).a(4).b(SplashAdLoadManager.this.b.getCodeId()).d(var2).f(var4x));
                                            SplashAdLoadManager.this.h = true;
                                            var4.a(var3);
                                            adListener.onSplashAdLoad(var4);
                                            SplashAdLoadManager.this.a();
                                            LogUtils.b("SplashAdLoadManager", "缓存广告获取成功");
                                        } else {
                                            LogUtils.b("SplashAdLoadManager", "缓存广告不在投放期或本次调用已回调出去");
                                            SplashAdLoadManager.this.a(SplashAdLoadManager.this.b, adListener, false, false);
                                        }

                                    }
                                });
                            } else {
                                LogUtils.b("SplashAdLoadManager", "缓存广告图片素材解析出错");
                                SplashAdLoadManager.this.a(SplashAdLoadManager.this.b, adListener, false, false);
                            }
                        } else {
                            LogUtils.b("SplashAdLoadManager", "缓存广告素材解析出错");
                            SplashAdLoadManager.this.a(SplashAdLoadManager.this.b, adListener, false, false);
                        }

                    }

                    public void a() {
                        LogUtils.b("SplashAdLoadManager", "缓存广告对象解析出错");
                        SplashAdLoadManager.this.a(SplashAdLoadManager.this.b, adListener, false, false);
                    }
                });
            }
        }
    }

    void a() {
        this.a(this.b, (TTAdNative.SplashAdListener)null, true, true);
    }

    void timeOut() {
        TTAdNative.SplashAdListener var1 = (TTAdNative.SplashAdListener)this.d.get();
        if (var1 != null) {
            var1.onTimeout();
        }
    }

    public void doResult(Message var1) {
        if (var1.what == 1) {
            if (!this.h) {
                this.h = true;
                this.c();
                LogUtils.b("SplashAdLoadManager", "尝试从缓存中取");
            } else {
                this.a();
                LogUtils.b("SplashAdLoadManager", "开始预加载");
            }

            this.mHandler.removeCallbacksAndMessages((Object)null);
        }

        if (var1.what == 2 && !this.h) {
            this.h = true;
//            this.timeOut();
            this.mHandler.removeCallbacksAndMessages((Object)null);
        }

    }

    public interface a {
        void a(boolean var1);
    }
}
