/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.a;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.view.View;
/*     */ import com.bytedance.sdk.openadsdk.TTFeedAd;
/*     */ import com.bytedance.sdk.openadsdk.core.aa;
/*     */ import com.bytedance.sdk.openadsdk.core.d.c.a;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
/*     */ import java.lang.ref.WeakReference;
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
/*     */ public class b
/*     */   extends d
/*     */ {
/*     */   protected Context b;
/*     */   protected h c;
/*     */   protected String d;
/*     */   protected int e;
/*     */   protected WeakReference<View> f;
/*     */   protected WeakReference<View> g;
/*     */   protected com.bytedance.sdk.openadsdk.core.d.c h;
/*     */   protected a i;
/*     */   protected TTFeedAd j;
/*     */   protected com.bytedance.sdk.openadsdk.core.video.a.c k;
/*  42 */   protected boolean l = false;
/*     */   
/*     */   public void a(TTFeedAd paramTTFeedAd) {
/*  45 */     this.j = paramTTFeedAd;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/*  49 */     this.l = paramBoolean;
/*     */   }
/*     */   
/*  52 */   public void a(com.bytedance.sdk.openadsdk.core.video.a.c paramc) { this.k = paramc; }
/*     */   
/*     */   public b(@NonNull Context paramContext, @NonNull h paramh, @NonNull String paramString, int paramInt)
/*     */   {
/*  56 */     this.b = paramContext.getApplicationContext();
/*  57 */     this.c = paramh;
/*  58 */     this.d = paramString;
/*  59 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   public void a(a parama) {
/*  63 */     this.i = parama;
/*     */   }
/*     */   
/*     */   public void a(View paramView) {
/*  67 */     this.f = new WeakReference(paramView);
/*     */   }
/*     */   
/*     */   public void b(View paramView) {
/*  71 */     this.f = new WeakReference(paramView);
/*     */   }
/*     */   
/*     */   public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/*  76 */     if (this.b == null) {
/*  77 */       return;
/*     */     }
/*     */     
/*  80 */     this.h = a(paramInt1, paramInt2, paramInt3, paramInt4, this.q, this.r, this.f == null ? null : 
/*  81 */       (View)this.f.get(), this.g == null ? null : (View)this.g.get());
/*     */     
/*  83 */     if (this.i != null) {
/*  84 */       this.i.a(paramView, -1);
/*     */     }
/*  86 */     boolean bool = aa.a(this.b, this.c, this.e, this.k, this.j, r.a(this.e));
/*  87 */     com.bytedance.sdk.openadsdk.d.c.a(this.b, "click", this.c, this.h, this.d, bool);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected com.bytedance.sdk.openadsdk.core.d.c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, View paramView1, View paramView2)
/*     */   {
/*  95 */     return 
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
/* 106 */       new c.a().d(paramInt1).c(paramInt2).b(paramInt3).a(paramInt4).b(paramLong1).a(paramLong2).b(s.a(paramView1)).a(s.a(paramView2)).c(s.b(paramView1)).d(s.b(paramView2)).a();
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(View paramView, int paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\a\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */