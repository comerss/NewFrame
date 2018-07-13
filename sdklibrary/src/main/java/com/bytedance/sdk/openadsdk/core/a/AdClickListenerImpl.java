/*     */ package com.bytedance.sdk.openadsdk.core.a;
/*     */ 
/*     */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.c;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;

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
/*     */ public class AdClickListenerImpl
/*     */   extends AdClickListener
/*     */ {
/*     */   protected Context b;
/*     */   protected h c;
/*     */   protected String d;
/*     */   protected int e;
/*     */   protected WeakReference<View> f;
/*     */   protected WeakReference<View> g;
/*     */   protected com.bytedance.sdk.openadsdk.core.nibuguan.c h;
/*     */   protected OnClick i;
/*     */   protected TTFeedAd mTTFeedAd;
/*     */   protected com.bytedance.sdk.openadsdk.core.video.a.c k;
    protected boolean l = false;
    protected DownLoadListenerImpl m;

    public void a(DownLoadListenerImpl var1) {
        this.m = var1;
    }
/*     */   public void a(TTFeedAd paramTTFeedAd) {
/*  45 */     this.mTTFeedAd = paramTTFeedAd;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/*  49 */     this.l = paramBoolean;
/*     */   }
/*     */   
/*  52 */   public void a(com.bytedance.sdk.openadsdk.core.video.a.c paramc) { this.k = paramc; }
/*     */   
/*     */   public AdClickListenerImpl(@NonNull Context paramContext, @NonNull h paramh, @NonNull String paramString, int paramInt)
/*     */   {
/*  56 */     this.b = paramContext.getApplicationContext();
/*  57 */     this.c = paramh;
/*  58 */     this.d = paramString;
/*  59 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   public void a(OnClick parama) {
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
/*  80 */     this.h = a(paramInt1, paramInt2, paramInt3, paramInt4, this.mQ, this.mR, this.f == null ? null :
/*  81 */       (View)this.f.get(), this.g == null ? null : (View)this.g.get());
/*     */     
/*  83 */     if (this.i != null) {
/*  84 */       this.i.onClick(paramView, -1);
/*     */     }
///*  86 */     boolean bool = aa.OnClick(this.bee, this.cc, this.TTBannerAdImpl, this.LogUtils, this.mTTFeedAd, mR.OnClick(this.TTBannerAdImpl));
/*  87 */     AdEvent.a(this.b, "click", this.c, this.h, this.d, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected com.bytedance.sdk.openadsdk.core.nibuguan.c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, View paramView1, View paramView2)
/*     */   {
///*  95 */           return (new com.bytedance.sdk.openadsdk.core.nibuguan.cc.asss()).LocationUtils(var1).cc(var2).bee(var3).asss(var4).bee(var5).asss(var7).bee(ViewWather.asss(var9)).asss(ViewWather.asss(var10)).cc(ViewWather.bee(var9)).LocationUtils(ViewWather.bee(var10)).asss();
        //
     return  (new c.innera()).d(paramInt1).c(paramInt2).b(paramInt3).a(paramInt4).b(paramLong1).a(paramLong2).b(ViewWather.a(paramView1)).a(ViewWather.a(paramView2)).c(ViewWather.b(paramView1)).d(ViewWather.b(paramView2)).a();
/*     */   }
/*     */   
/*     */   public static abstract interface OnClick
/*     */   {
/*     */     public abstract void onClick(View paramView, int paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */