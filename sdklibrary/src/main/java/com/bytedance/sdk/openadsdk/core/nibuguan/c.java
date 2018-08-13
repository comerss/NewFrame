/*     */ package com.bytedance.sdk.openadsdk.core.nibuguan;

import android.support.annotation.NonNull;

import org.json.JSONObject;

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
public class c {
    private int[] a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private long i;
    private long j;

    private c(@NonNull Builder var1) {
        this.a = var1.h;
        this.b = var1.i;
        this.d = var1.j;
        this.c = var1.g;
        this.e = var1.f;
        this.f = var1.e;
        this.g = var1.d;
        this.h = var1.c;
        this.i = var1.b;
        this.j = var1.a;
    }

    public JSONObject a() {
        JSONObject var1 = new JSONObject();

        try {
            if (this.a != null && this.a.length == 2) {
                var1.putOpt("ad_x", this.a[0]).putOpt("ad_y", this.a[1]);
            }

            if (this.b != null && this.b.length == 2) {
                var1.putOpt("width", this.b[0]).putOpt("height", this.b[1]);
            }

            if (this.c != null && this.c.length == 2) {
                var1.putOpt("button_x", this.c[0]).putOpt("button_y", this.c[1]);
            }

            if (this.d != null && this.d.length == 2) {
                var1.putOpt("button_width", this.d[0]).putOpt("button_height", this.d[1]);
            }

            var1.putOpt("down_x", this.e).putOpt("down_y", this.f).putOpt("up_x", this.g).putOpt("up_y", this.h).putOpt("down_time", this.i).putOpt("up_time", this.j);
        } catch (Exception var3) {
            ;
        }

        return var1;
    }

    public static class Builder {
        private long a;
        private long b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int[] g;
        private int[] h;
        private int[] i;
        private int[] j;

        public Builder() {
        }

        public Builder a(long var1) {
            this.a = var1;
            return this;
        }

        public Builder b(long var1) {
            this.b = var1;
            return this;
        }

        public Builder a(int var1) {
            this.c = var1;
            return this;
        }

        public Builder b(int var1) {
            this.d = var1;
            return this;
        }

        public Builder c(int var1) {
            this.e = var1;
            return this;
        }

        public Builder d(int var1) {
            this.f = var1;
            return this;
        }

        public Builder a(int[] var1) {
            this.g = var1;
            return this;
        }

        public Builder b(int[] var1) {
            this.h = var1;
            return this;
        }

        public Builder c(int[] var1) {
            this.i = var1;
            return this;
        }

        public Builder d(int[] var1) {
            this.j = var1;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }
}
