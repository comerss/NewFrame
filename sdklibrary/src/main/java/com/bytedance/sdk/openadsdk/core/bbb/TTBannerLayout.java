/*     */ package com.bytedance.sdk.openadsdk.core.bbb;
/*     */ 
/*     */

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.b.TTAdDislikeImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;

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
/*     */ class TTBannerLayout
/*     */   extends FrameLayout
/*     */ {
/*     */   private Context a;
/*     */   private c b;
/*     */   private c c;
/*     */   private ImageView d;
/*     */   private TTAdDislikeImpl e;
/*     */   private int f;
/*     */   private boolean g;
/*  42 */   private boolean h = false;
/*     */   
/*     */   public TTBannerLayout(@NonNull Context paramContext) {
/*  45 */     super(paramContext);
/*  46 */     this.a = paramContext;
/*  47 */     g();
/*     */   }
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
/*     */   private void g()
/*     */   {
/*  63 */     this.b = new c(this.a);
/*  64 */     addView(this.b, new FrameLayout.LayoutParams(-1, -1));
/*  65 */     i();
/*     */   }
/*     */   
/*     */   private void h() {
/*  69 */     this.h = true;
/*  70 */     this.d = new ImageView(this.a);
/*  71 */     this.d.setImageResource(R.drawable.tt_dislike_icon);
/*  72 */     this.d.setScaleType(ImageView.ScaleType.FIT_XY);
/*  73 */     this.d.setOnClickListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/*  76 */         if (e != null) {
/*  77 */          e.showDislikeDialog();
/*     */         }
/*     */         
/*     */       }
/*  81 */     });
/*  82 */     int i = (int) ViewWather.dp2px(this.a, 15.0F);
/*  83 */     int j = (int) ViewWather.dp2px(this.a, 10.0F);
/*  84 */     FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
/*  85 */     localLayoutParams.gravity = 53;
/*  86 */     localLayoutParams.topMargin = j;
/*  87 */     localLayoutParams.rightMargin = j;
/*  88 */     addView(this.d, localLayoutParams);
/*     */     
/*  90 */     ViewWather.setTouchDelegate(this.d, i, i, i, i);
/*     */   }
/*     */   
/*     */   private void i() {
/*  94 */     ImageView localImageView = new ImageView(this.a);
/*  95 */     localImageView.setImageResource(R.drawable.tt_ad_logo_small);
/*  96 */     localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
/*  97 */     int i = (int) ViewWather.dp2px(this.a, 20.0F);
/*  98 */     int j = (int) ViewWather.dp2px(this.a, 10.0F);
/*  99 */     FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i, i);
/* 100 */     localLayoutParams.gravity = 85;
/* 101 */     localLayoutParams.rightMargin = j;
/* 102 */     localLayoutParams.bottomMargin = j;
/* 103 */     addView(localImageView, localLayoutParams);
/*     */   }
/*     */   
/*     */   public void a() {
/* 107 */     this.c = new c(this.a);
/* 108 */     this.c.setVisibility(View.GONE);
/* 109 */     addView(this.c, new FrameLayout.LayoutParams(-1, -1));
/* 110 */     i();
/* 111 */     if (this.h) {
/* 112 */       h();
/*     */     }
/*     */   }
/*     */   
/*     */   void a(TTAdDislikeImpl paramb) {
/* 117 */     this.e = paramb;
/* 118 */     h();
/*     */   }
/*     */   
/*     */   public c b() {
/* 122 */     return this.b;
/*     */   }
/*     */   
/*     */   public c c() {
/* 126 */     return this.c;
/*     */   }
/*     */   
/*     */   public View d() {
/* 130 */     return this.d;
/*     */   }
/*     */   
/*     */   public void a(int paramInt) {
/* 134 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ObjectAnimator a(c paramc)
/*     */   {
/* 143 */     int i = getWidth();
/* 144 */     ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramc, "translationX", new float[] { 0.0F, -i });
/* 145 */     return localObjectAnimator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ObjectAnimator b(final c paramc)
/*     */   {
/* 154 */     int i = getWidth();
/* 155 */     ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramc, "translationX", new float[] { i, 0.0F });
/* 156 */     localObjectAnimator.addListener(new Animator.AnimatorListener()
/*     */     {
/*     */       public void onAnimationStart(Animator paramAnonymousAnimator) {
/* 159 */         LogUtils.b("TTBannerAd", "SLIDE START");
/*     */       }
/*     */       
/*     */       public void onAnimationEnd(Animator paramAnonymousAnimator)
/*     */       {
/* 164 */       g= false;
/* 165 */      j();
/* 166 */         if (paramc != null) {
/* 167 */          a( paramc.a());
/*     */         }
/*     */         
/* 170 */         LogUtils.b("TTBannerAd", "SLIDE END");
/* 171 */         if (LogUtils.isDebug) {
///* 172 */           Toast.makeText(LocationUtils.PhoneUtils(LocationUtils.this).getApplicationContext(), "END", 0).show();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onAnimationCancel(Animator paramAnonymousAnimator) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       public void onAnimationRepeat(Animator paramAnonymousAnimator) {}
/* 185 */     });
/* 186 */     return localObjectAnimator;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void e()
/*     */   {
/* 193 */     if (!this.g) {
/* 194 */       AnimatorSet localAnimatorSet = new AnimatorSet();
/* 195 */       localAnimatorSet.play(a(this.b)).with(b(this.c));
/* 196 */       localAnimatorSet.setDuration(this.f).start();
/* 197 */       this.c.setVisibility(View.VISIBLE);
/* 198 */       this.g = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(NativeAdData paramh)
/*     */   {
/* 206 */     if ((this.e != null) && (paramh != null)) {
/* 207 */       this.e.a(paramh);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean f()
/*     */   {
/* 216 */     return (this.c != null) && (this.c.a() != null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void j()
/*     */   {
/* 223 */     c localc = this.b;
/* 224 */     this.b = this.c;
/* 225 */     this.c = localc;
/* 226 */     this.c.b();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\result\LocationUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */