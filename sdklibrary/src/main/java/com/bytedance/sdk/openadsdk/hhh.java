package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nibuguan.SplashNative;
import com.bytedance.sdk.openadsdk.core.AdNativeListener;

import org.json.JSONObject;

/**
 * Created by 79653 on 2018/7/11.
 * 描述：
 */
public class hhh {
    private static volatile hhh a;

    private hhh() {
    }

    public static hhh a() {
        if (a == null) {
            Class var0 = hhh.class;
            synchronized(hhh.class) {
                if (a == null) {
                    a = new hhh();
                }
            }
        }

        return a;
    }

    public boolean a(SplashNative var1) {
        return var1 == null;
    }

    public void b(SplashNative var1) {
        if (!this.a(var1)) {
            var1.a("outer_call");
            var1.a(System.currentTimeMillis() / 1000L);
            this.a(var1.b());
        }
    }

    public void c(SplashNative var1) {
        if (!this.a(var1)) {
            var1.a("outer_call_send");
            var1.a(System.currentTimeMillis() / 1000L);
            this.a(var1.b());
        }
    }

    public void d(SplashNative var1) {
        if (!this.a(var1)) {
            var1.a("outer_call_no_rsp");
            var1.a(System.currentTimeMillis() / 1000L);
            this.a(var1.b());
        }
    }

    public void e(SplashNative var1) {
        if (!this.a(var1)) {
            var1.a("load_creative_error");
            var1.a(System.currentTimeMillis() / 1000L);
            this.a(var1.b());
        }
    }

    protected void a(JSONObject var1) {
        if (var1 != null) {
            AdNativeListener var2 = n.c();
            var2.a(var1);
        }
    }
}
