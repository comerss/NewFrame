package com.bytedance.sdk.openadsdk.core.nibuguan;

import android.text.TextUtils;

import org.json.JSONObject;

/**
 * Created by 79653 on 2018/7/11.
 * 描述：
 */
public class k {
    private String a;
    private String b;
    private String c;
    private String d = "1.9.2";
    private long e = System.currentTimeMillis() / 1000L;
    private int f = 0;
    private String g;
    private int h;
    private String i;
    private String j;
    private String k;

    public k() {
    }

    public static k a() {
        return new k();
    }

    public JSONObject b() {
        JSONObject var1 = new JSONObject();

        try {
            if (!TextUtils.isEmpty(this.d())) {
                var1.put("type", this.d());
            }

            if (!TextUtils.isEmpty(this.e())) {
                var1.put("rit", this.e());
            }

            if (!TextUtils.isEmpty(this.f())) {
                var1.put("creative_id", this.f());
            }

            if (!TextUtils.isEmpty(this.g())) {
                var1.put("ad_sdk_version", this.g());
            }

            if (this.h() > 0L) {
                var1.put("timestamp", this.h());
            }

            if (this.i() > 0) {
                var1.put("adtype", this.i());
            }

            if (!TextUtils.isEmpty(this.j())) {
                var1.put("req_id", this.j());
            }

            if (!TextUtils.isEmpty(this.l())) {
                var1.put("error_code", this.k());
                var1.put("error_msg", this.l());
            }

            if (!TextUtils.isEmpty(this.m())) {
                var1.put("extra", this.m());
            }

            if (!TextUtils.isEmpty(this.n())) {
                var1.put("image_url", this.n());
            }
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return var1;
    }

    protected k c() {
        return this;
    }

    public String d() {
        return this.a;
    }

    public k a(String var1) {
        this.a = var1;
        return this.c();
    }

    public String e() {
        return this.b;
    }

    public k b(String var1) {
        this.b = var1;
        return this.c();
    }

    public String f() {
        return this.c;
    }

    public k c(String var1) {
        this.c = var1;
        return this.c();
    }

    public String g() {
        return this.d;
    }

    public long h() {
        return this.e;
    }

    public k a(long var1) {
        this.e = var1;
        return this.c();
    }

    public int i() {
        return this.f;
    }

    public k a(int var1) {
        this.f = var1;
        return this.c();
    }

    public String j() {
        return this.g;
    }

    public k d(String var1) {
        this.g = var1;
        return this.c();
    }

    public int k() {
        return this.h;
    }

    public k b(int var1) {
        this.h = var1;
        return this.c();
    }

    public String l() {
        return this.i;
    }

    public k e(String var1) {
        this.i = var1;
        return this.c();
    }

    public String m() {
        return this.j;
    }

    public k f(String var1) {
        this.j = var1;
        return this.c();
    }

    public String n() {
        return this.k;
    }

    public k g(String var1) {
        this.k = var1;
        return this.c();
    }
}

