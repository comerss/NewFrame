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
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.SplashManager;
import com.bytedance.sdk.openadsdk.core.a.AdClickListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.h;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

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
/*     */ public class TTSplashAdImpl
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
/*     */   private SplashLayout mSplashLayout;
/*     */   private TTSplashAd.AdInteractionListener f;
/*     */   private boolean g;
/*  51 */   private MineHandler h = new MineHandler(Looper.getMainLooper(), this);
/*     */   
/*     */   private DownLoadListenerImpl i;
/*     */   
/*     */   TTSplashAdImpl(@NonNull Context paramContext, @NonNull h paramh)
/*     */   {
/*  57 */     this.c = paramContext;
/*  58 */     this.d = paramh;
/*  59 */     a();
/*     */   }
/*     */   
/*     */   void a() {
/*  63 */     this.mSplashLayout = new SplashLayout(this.c);
/*  64 */     AdEvent.a(this.d);
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
/*  78 */     this.mSplashLayout.setDrawable(paramDrawable);
/*     */   }
/*     */   
/*     */   private void c() {
/*  82 */     this.i = a(this.d);
/*  83 */     SplashManager localf = new SplashManager(this.c, this.mSplashLayout);
/*  84 */     localf.setAdType(3);
/*  85 */     this.mSplashLayout.addView(localf);
/*  86 */     localf.setCallback(new SplashManager.SplashListener()
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
/*     */       public void onShow(View paramAnonymousView)
/*     */       {
/* 110 */         AdEvent.show(c, d, "splash_ad");
/* 111 */         if (!g) {
/* 112 */           h.sendEmptyMessage(1);
/*     */         }
/* 114 */         if (f != null) {
/* 115 */          f.onAdShow(mSplashLayout, d.c());
/*     */         }
/* 117 */         if (d.t()) {
/* 118 */           ToolUtils.a(d, paramAnonymousView);
/*     */         }
/* 120 */         LogUtils.b(d.b(), "开屏广告展示");
/*     */       }
/* 122 */     });
/* 123 */     localf.setNeedCheckingShow(true);
/*     */     
/*     */ 
/* 126 */     com.bytedance.sdk.openadsdk.core.a.a locala = new com.bytedance.sdk.openadsdk.core.a.a(this.c, this.d, "splash_ad", 4);
/* 127 */     locala.a(this.mSplashLayout);
/* 128 */     locala.b(this.mSplashLayout.getDislikeView());
/* 129 */     locala.a(this.i);
/* 130 */     locala.a(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
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
/* 146 */     this.mSplashLayout.setOnClickListenerInternal(locala);
/* 147 */     this.mSplashLayout.setOnTouchListenerInternal(locala);
/* 148 */     this.mSplashLayout.setSkipListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/* 152 */       if (!StringUtils.isEmpty(TTSplashAdImpl.this.d.o())) {
        AdEvent.c(TTSplashAdImpl.this.d);
    }

    if (TTSplashAdImpl.this.f != null) {
        TTSplashAdImpl.this.h.removeCallbacksAndMessages((Object)null);
        TTSplashAdImpl.this.b = 0;
        TTSplashAdImpl.this.f.onAdSkip();
    }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   @NonNull
/*     */   public View getSplashView()
/*     */   {
/* 167 */     return this.mSplashLayout;
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
/*     */   private DownLoadListenerImpl a(h paramh) {
/* 188 */     if (paramh.c() == 4) {
/* 189 */       return new DownLoadListenerImpl(this.c, paramh, "splash_ad");
/*     */     }
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public void setNotAllowSdkCountdown()
/*     */   {
/* 196 */     this.g = true;
/* 197 */     this.mSplashLayout.setSkipIconVisibility(8);
/* 198 */     this.h.removeCallbacksAndMessages(null);
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 202 */     SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramInt + "ViewWather | 跳过");
/* 203 */     localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.c.getResources().getColor(R.color.tt_skip_red)), 0, 2, 33);
/* 204 */     this.mSplashLayout.setSkipText(localSpannableStringBuilder);
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