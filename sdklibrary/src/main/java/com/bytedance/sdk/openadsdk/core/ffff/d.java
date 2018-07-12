/*     */ package com.bytedance.sdk.openadsdk.core.ffff;
/*     */ 
/*     */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.ccccc.x;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.q;
import com.bytedance.sdk.openadsdk.ggg.r;

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
/*     */ public class d
/*     */   implements TTSplashAd, MineHandler.OnResult
/*     */ {
/*  35 */   private static String a = "TTSplashAdImpl";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */   private int b = 3;
/*     */   
/*     */   private Context c;
/*     */   
/*     */   private h d;
/*     */   
/*     */   private c e;
/*     */   private TTSplashAd.AdInteractionListener f;
/*     */   private boolean g;
/*  51 */   private MineHandler h = new MineHandler(Looper.getMainLooper(), this);
/*     */   
/*     */   private x i;
/*     */   
/*     */   d(@NonNull Context paramContext, @NonNull h paramh)
/*     */   {
/*  57 */     this.c = paramContext;
/*  58 */     this.d = paramh;
/*  59 */     a();
/*     */   }
/*     */   
/*     */   void a() {
/*  63 */     this.e = new c(this.c);
/*  64 */     com.bytedance.sdk.openadsdk.dddd.c.a(this.d);
/*     */     
/*     */ 
/*  67 */     if (this.d.s() <= 0) {
/*  68 */       a(3);
/*     */     } else {
/*  70 */       this.b = this.d.s();
/*  71 */       a(this.b);
/*     */     }
/*     */     
/*  74 */     c();
/*     */   }
/*     */   
/*     */   void a(Drawable paramDrawable) {
/*  78 */     this.e.setDrawable(paramDrawable);
/*     */   }
/*     */   
/*     */   private void c() {
/*  82 */     this.i = a(this.d);
/*  83 */     f localf = new f(this.c, this.e);
/*  84 */     localf.setAdType(3);
/*  85 */     this.e.addView(localf);
/*  86 */     localf.setCallback(new com.bytedance.sdk.openadsdk.core.f.a()
/*     */     {
/*     */       public void a(boolean paramAnonymousBoolean) {
/*  89 */         if (i != null) {
/*  90 */           if (paramAnonymousBoolean) {
/*  91 */            i.e();
/*     */           } else {
/*  93 */             i.f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void a() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void b() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void a(View paramAnonymousView)
/*     */       {
/* 110 */         com.bytedance.sdk.openadsdk.dddd.c.a(c, d, "splash_ad");
/* 111 */         if (!g) {
/* 112 */           h.sendEmptyMessage(1);
/*     */         }
/* 114 */         if (f != null) {
/* 115 */          f.onAdShow(e, d.c());
/*     */         }
/* 117 */         if (d.t()) {
/* 118 */           r.a(d, paramAnonymousView);
/*     */         }
/* 120 */         LogUtils.b(d.b(), "开屏广告展示");
/*     */       }
/* 122 */     });
/* 123 */     localf.setNeedCheckingShow(true);
/*     */     
/*     */ 
/* 126 */     com.bytedance.sdk.openadsdk.core.a.a locala = new com.bytedance.sdk.openadsdk.core.a.a(this.c, this.d, "splash_ad", 4);
/* 127 */     locala.a(this.e);
/* 128 */     locala.b(this.e.getDislikeView());
/* 129 */     locala.a(this.i);
/* 130 */     locala.a(new com.bytedance.sdk.openadsdk.core.a.a.bb()
/*     */     {
/*     */       public void a(View paramAnonymousView, int paramAnonymousInt) {
/* 133 */         if (f != null) {
/* 134 */           f.onAdClicked(paramAnonymousView, paramAnonymousInt);
/*     */         }
/*     */         
/* 137 */         if ((paramAnonymousInt != 4) && (paramAnonymousInt != -1)) {
/* 138 */           h.removeCallbacksAndMessages(null);
/* 139 */           b=0;
/*     */         }
/*     */       }
/*     */     });
/* 143 */     if (this.i != null) {
/* 144 */       this.i.a(new com.bytedance.sdk.openadsdk.core.a.c(this.c, this.d, "splash_ad"));
/*     */     }
/* 146 */     this.e.setOnClickListenerInternal(locala);
/* 147 */     this.e.setOnTouchListenerInternal(locala);
/* 148 */     this.e.setSkipListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/* 152 */       if (!q.a(d.this.d.o())) {
        com.bytedance.sdk.openadsdk.dddd.c.c(d.this.d);
    }

    if (d.this.f != null) {
        d.this.h.removeCallbacksAndMessages((Object)null);
        d.this.b = 0;
        d.this.f.onAdSkip();
    }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public View getSplashView()
/*     */   {
/* 167 */     return this.e;
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/* 172 */     return this.d == null ? -1 : this.d.c();
/*     */   }
/*     */   
/*     */   public void setSplashInteractionListener(TTSplashAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/* 177 */     this.f = paramAdInteractionListener;
/*     */   }
/*     */   
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/* 182 */     if (this.i != null) {
/* 183 */       this.i.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   private x a(h paramh) {
/* 188 */     if (paramh.c() == 4) {
/* 189 */       return new x(this.c, paramh, "splash_ad");
/*     */     }
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public void setNotAllowSdkCountdown()
/*     */   {
/* 196 */     this.g = true;
/* 197 */     this.e.setSkipIconVisibility(8);
/* 198 */     this.h.removeCallbacksAndMessages(null);
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 202 */     SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramInt + "s | 跳过");
/* 203 */     localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(R.color.tt_skip_red)), 0, 2, 33);
/* 204 */     this.e.setSkipText(localSpannableStringBuilder);
/*     */   }
/*     */   
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 209 */     if (paramMessage.what == 1) {
/* 210 */       this.b -= 1;
/* 211 */       if (this.b == 0) {
/* 212 */         if (this.f != null) {
/* 213 */           this.f.onAdTimeOver();
/*     */         }
/* 215 */         LogUtils.b(a, "播放时间到");
/* 216 */         this.h.removeCallbacksAndMessages(null);
/* 217 */       } else if (this.b > 0) {
/* 218 */         a(this.b);
/* 219 */         this.h.sendEmptyMessageDelayed(1, 1000L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\doErrorHelper\LocationUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */