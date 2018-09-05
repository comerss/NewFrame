/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.ggg.ObjectHelper;
/*     */ import java.util.HashSet;
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
/*     */ public class h
/*     */ {
/*     */   @NonNull
/*     */   private String a;
/*     */   @NonNull
/*     */   private String b;
/*     */   private boolean c;
/*     */   private int d;
/*  29 */   private int e = 0;
/*     */   
/*     */   @Nullable
/*     */   private String f;
/*     */   @Nullable
/*     */   private String g;
/*  35 */   private int h = 0;
/*     */   
/*  37 */   private boolean i = true;
/*     */   
/*  39 */   private boolean j = false;
/*     */   
/*     */   private TTGlobalAppDownloadListener k;
/*     */   
/*  43 */   private HashSet<Integer> l = new HashSet();
/*     */   
/*     */   private h() {
/*  46 */     this.l.add(Integer.valueOf(4));
/*     */   }
/*     */   
/*  49 */   private static h m = new h();
/*     */   
/*     */   public static h a() {
/*  52 */     return m;
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public String b()
/*     */   {
/*  58 */     return this.a;
/*     */   }
/*     */   
/*     */   public void a(@NonNull String paramString) {
/*  62 */     e(paramString);
/*  63 */     this.a = paramString;
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public String c() {
/*  68 */     return this.b;
/*     */   }
/*     */   
/*     */   public void b(@NonNull String paramString) {
/*  72 */     f(paramString);
/*  73 */     this.b = paramString;
/*     */   }
/*     */   
/*     */   public boolean d() {
/*  77 */     return this.c;
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/*  81 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */   public int e() {
/*  85 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(int paramInt) {
/*  89 */     e(paramInt);
/*  90 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public int f() {
/*  94 */     return this.e;
/*     */   }
/*     */   
/*     */   public void b(int paramInt) {
/*  98 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String g() {
/* 103 */     return this.f;
/*     */   }
/*     */   
/*     */   public void c(@Nullable String paramString) {
/* 107 */     g(paramString);
/* 108 */     this.f = paramString;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public String h() {
/* 113 */     return this.g;
/*     */   }
/*     */   
/*     */   public void d(@Nullable String paramString) {
/* 117 */     h(paramString);
/* 118 */     this.g = paramString;
/*     */   }
/*     */   
/*     */   public void c(int paramInt) {
/* 122 */     this.h = paramInt;
/*     */   }
/*     */   
/*     */   public int i() {
/* 126 */     return this.h;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/* 130 */     this.i = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean j() {
/* 134 */     return this.i;
/*     */   }
/*     */   
/*     */   public void c(boolean paramBoolean) {
/* 138 */     this.j = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean k() {
/* 142 */     return this.j;
/*     */   }
/*     */   
/*     */   public TTGlobalAppDownloadListener l() {
/* 146 */     return this.k;
/*     */   }
/*     */   
/*     */   public void a(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener) {
/* 150 */     this.k = paramTTGlobalAppDownloadListener;
/*     */   }
/*     */   
/*     */   public boolean d(int paramInt) {
/* 154 */     return this.l.contains(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public void a(int... paramVarArgs) {
/* 158 */     this.l.clear();
/* 159 */     for (int n = 0; n < paramVarArgs.length; n++) {
/* 160 */       this.l.add(Integer.valueOf(paramVarArgs[n]));
/*     */     }
/*     */   }
/*     */   
/*     */   public void m() {
/* 165 */     e(this.a);
/* 166 */     f(this.b);
/*     */   }
/*     */   
/*     */   private static void e(String paramString) {
/* 170 */     ObjectHelper.checkIllegal(paramString, "appid不能为空");
/*     */   }
/*     */   
/*     */   private static void f(String paramString) {
/* 174 */     ObjectHelper.checkIllegal(paramString, "name不能为空");
/*     */   }
/*     */   
/*     */   private static void e(int paramInt) {
/* 178 */     ObjectHelper.a(paramInt >= 0, "年龄不能为负数");
/*     */   }
/*     */   
/*     */   private static void g(String paramString) {
/* 182 */     if (!TextUtils.isEmpty(paramString)) {
/* 183 */       ObjectHelper.a(paramString.length() <= 1000, "keyword超长, 最长为1000");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void h(String paramString)
/*     */   {
/* 189 */     if (!TextUtils.isEmpty(paramString)) {
/* 190 */       ObjectHelper.a(paramString.length() <= 1000, "data超长, 最长为1000");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\ImageHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */