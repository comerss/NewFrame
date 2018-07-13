/*     */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*     */ 
/*     */ import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
/*     */ public class h
/*     */ {
/*     */   private int a;
/*     */   private g b;
/*     */   private String c;
/*  19 */   private List<g> d = new ArrayList();
/*     */   private String e;
/*  21 */   private List<String> f = new ArrayList();
/*  22 */   private List<String> g = new ArrayList();
/*     */   private String h;
/*     */   private String i;
/*  25 */   private String j = "0";
/*     */   
/*     */   private b k;
/*     */   private d l;
/*     */   private int m;
/*     */   private String n;
/*     */   private String o;
/*  32 */   private List<f> p = new ArrayList();
/*     */   
/*     */ 
/*     */   private long q;
/*     */   
/*     */   private int r;
/*     */   
/*     */   private com.bytedance.sdk.openadsdk.core.nibuguan.m s;
/*     */   
/*     */   private boolean t;
/*     */   
/*     */   private boolean u;
/*     */   
/*     */ 
/*     */   public com.bytedance.sdk.openadsdk.core.nibuguan.m a()
/*     */   {
/*  48 */     return this.s;
/*     */   }
/*     */   
/*     */   public void a(com.bytedance.sdk.openadsdk.core.nibuguan.m paramk) {
/*  52 */     this.s = paramk;
/*     */   }
/*     */   
/*     */   public void a(String paramString) {
/*  56 */     this.n = paramString;
/*     */   }
/*     */   
/*     */   public String b() {
/*  60 */     return this.n;
/*     */   }
/*     */   
/*     */   public int c() {
/*  64 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(int paramInt) {
/*  68 */     this.a = paramInt;
/*     */   }
/*     */   
/*     */   public g d() {
/*  72 */     return this.b;
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/*  76 */     this.b = paramg;
/*     */   }
/*     */   
/*     */   public String e() {
/*  80 */     return this.c;
/*     */   }
/*     */   
/*     */   public void b(String paramString) {
/*  84 */     this.c = paramString;
/*     */   }
/*     */   
/*     */   public List<g> f() {
/*  88 */     return this.d;
/*     */   }
/*     */   
/*     */   public void b(g paramg) {
/*  92 */     this.d.add(paramg);
/*     */   }
/*     */   
/*     */   public String g() {
/*  96 */     return this.e;
/*     */   }
/*     */   
/*     */   public void c(String paramString) {
/* 100 */     this.e = paramString;
/*     */   }
/*     */   
/*     */   public List<String> h() {
/* 104 */     return this.f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<String> i()
/*     */   {
/* 112 */     return this.g;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String j()
/*     */   {
/* 120 */     return this.h;
/*     */   }
/*     */   
/*     */   public void d(String paramString) {
/* 124 */     this.h = paramString;
/*     */   }
/*     */   
/*     */   public String k() {
/* 128 */     return this.i;
/*     */   }
/*     */   
/*     */   public void e(String paramString) {
/* 132 */     this.i = paramString;
/*     */   }
/*     */   
/*     */   public String l() {
/* 136 */     return this.j;
/*     */   }
/*     */   
/*     */   public void f(String paramString) {
/* 140 */     this.j = paramString;
/*     */   }
/*     */   
/*     */   public b m() {
/* 144 */     return this.k;
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/* 148 */     this.k = paramb;
/*     */   }
/*     */   
/*     */   public d n() {
/* 152 */     return this.l;
/*     */   }

    @Override
    public String toString() {
        return "ImageHelper{" +
                "OnLoadImage=" + a +
                ", fbbb=" + b +
                ", fccc='" + c + '\'' +
                ", TTSplashAdImpl=" + d +
                ", e='" + e + '\'' +
                ", AppAdViewHolder=" + f +
                ", DownloadNotifier=" + g +
                ", ImageHelper='" + h + '\'' +
                ", i='" + i + '\'' +
                ", mTTFeedAd='" + j + '\'' +
                ", k=" + k +
                ", MyDownloadManager=" + l +
                ", m=" + m +
                ", n='" + n + '\'' +
                ", o='" + o + '\'' +
                ", p=" + p +
                ", q=" + q +
                ", ToolUtils=" + r +
                ", ViewWather=" + s +
                ", t=" + t +
                ", u=" + u +
                '}';
    }

    /*     */
/*     */   public void a(d paramd) {
/* 156 */     this.l = paramd;
/*     */   }
/*     */   
/*     */   public String o() {
/* 160 */     return this.o;
/*     */   }
/*     */   
/*     */   public void g(String paramString) {
/* 164 */     this.o = paramString;
/*     */   }
/*     */   
/*     */   public int p() {
/* 168 */     return this.m;
/*     */   }
/*     */   
/*     */   public void b(int paramInt) {
/* 172 */     this.m = paramInt;
/*     */   }
/*     */   
/*     */   public List<f> q() {
/* 176 */     return this.p;
/*     */   }
/*     */   
/*     */   public void a(f paramf) {
/* 180 */     this.p.add(paramf);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long r()
/*     */   {
/* 192 */     return this.q;
/*     */   }
/*     */   
/*     */   public void a(long paramLong) {
/* 196 */     this.q = paramLong;
/*     */   }
/*     */   
/*     */   public int s() {
/* 200 */     return this.r;
/*     */   }
/*     */   
/*     */   public void c(int paramInt) {
/* 204 */     this.r = paramInt;
/*     */   }
/*     */   
/*     */   public boolean t() {
/* 208 */     return this.t;
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/* 212 */     this.t = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean u() {
/* 216 */     return this.u;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/* 220 */     this.u = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean equals(Object paramObject)
/*     */   {
/* 225 */     if (this == paramObject) return true;
/* 226 */     if ((paramObject == null) || (getClass() != paramObject.getClass())) { return false;
/*     */     }
/* 228 */     h localh = (h)paramObject;
/*     */     
/* 230 */     if (!this.j.equals(localh.j)) return false;
/* 231 */     return this.o.equals(localh.o);
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 237 */     int i1 = this.j.hashCode();
/* 238 */     i1 = 31 * i1 + this.o.hashCode();
/* 239 */     return i1;
/*     */   }
/*     */   
/*     */   public boolean v() {
/* 243 */     if (this.d.isEmpty()) {
/* 244 */       return false;
/*     */     }
/* 246 */     if ((this.m == 4) && (this.d.size() < 3)) {
/* 247 */       return false;
/*     */     }
/* 249 */     for (g localg : this.d) {
/* 250 */       if (!localg.d()) {
/* 251 */         return false;
/*     */       }
/*     */     }
/* 254 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(JSONObject paramJSONObject)
/*     */   {
/* 261 */     if (paramJSONObject == null) {
/* 262 */       return;
/*     */     }
/* 264 */     this.j = paramJSONObject.optString("id");
/* 265 */     this.n = paramJSONObject.optString("source");
/* 266 */     this.k = new b();
/* 267 */     this.k.c(paramJSONObject.optString("pkg_name"));
/* 268 */     this.k.b(paramJSONObject.optString("name"));
/* 269 */     this.k.a(paramJSONObject.optString("download_url"));
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LocationUtils\ImageHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */