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
import com.bytedance.sdk.openadsdk.core.a.AdClickListerReal;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
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
/*  35 */   private static String TAG = "TTSplashAdImpl";
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */   private int b = 3;
/*     */   
/*     */   private Context mContext;
/*     */   
/*     */   private NativeAdData d;
/*     */   
/*     */   private SplashLayout mSplashLayout;
/*     */   private TTSplashAd.AdInteractionListener mInteractionListener;
/*     */   private boolean g;
/*  51 */   private MineHandler mHandler = new MineHandler(Looper.getMainLooper(), this);
/*     */   
/*     */   private DownLoadListenerImpl mLoadListener;
/*     */   
/*     */   TTSplashAdImpl(@NonNull Context paramContext, @NonNull NativeAdData paramh)
/*     */   {
/*  57 */     this.mContext = paramContext;
/*  58 */     this.d = paramh;
/*  59 */     a();
/*     */   }
/*     */   
/*     */   void a() {
/*  63 */     this.mSplashLayout = new SplashLayout(this.mContext);
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
/*  82 */     this.mLoadListener = getDownLoadListenerImpl(this.d);
/*  83 */     SplashManager splashManager = new SplashManager(this.mContext, this.mSplashLayout);
/*  84 */     splashManager.setAdType(3);
/*  85 */     this.mSplashLayout.addView(splashManager);
/*  86 */     splashManager.setCallback(new SplashManager.SplashListener()
/*     */     {
/*     */       public void onWindowFocusChanged(boolean paramAnonymousBoolean) {
/*  89 */         if (mLoadListener != null) {
/*  90 */           if (paramAnonymousBoolean) {
/*  91 */            mLoadListener.e();
/*     */           } else {
/*  93 */             mLoadListener.f();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void onAttachedToWindow() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void onDetachedFromWindow() {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void onShow(View paramAnonymousView)
/*     */       {
/* 110 */         AdEvent.show(mContext, d, "splash_ad");
/* 111 */         if (!g) {
/* 112 */           mHandler.sendEmptyMessage(1);
/*     */         }
/* 114 */         if (mInteractionListener != null) {
/* 115 */          mInteractionListener.onAdShow(mSplashLayout, d.c());
/*     */         }
/* 117 */         if (d.t()) {
/* 118 */           ToolUtils.a(d, paramAnonymousView);
/*     */         }
/* 120 */         LogUtils.b(d.b(), "开屏广告展示");
/*     */       }
/* 122 */     });
/* 123 */     splashManager.setNeedCheckingShow(true);
/*     */     
/*     */ 
/* 126 */     AdClickListerReal adClickListerReal = new AdClickListerReal(this.mContext, this.d, "splash_ad", 4);
/* 127 */     adClickListerReal.a(this.mSplashLayout);
/* 128 */     adClickListerReal.b(this.mSplashLayout.getDislikeView());
/* 129 */     adClickListerReal.a(this.mLoadListener);
/* 130 */     adClickListerReal.setOnClickLister(new AdClickListenerImpl.OnClick()
/*     */     {
/*     */       public void onClick(View paramAnonymousView, int paramAnonymousInt) {
/* 133 */         if (mInteractionListener != null) {
/* 134 */           mInteractionListener.onAdClicked(paramAnonymousView, paramAnonymousInt);
/*     */         }
/*     */         
/* 137 */         if ((paramAnonymousInt != 4) && (paramAnonymousInt != -1)) {
/* 138 */           mHandler.removeCallbacksAndMessages(null);
/* 139 */           b=0;
/*     */         }
/*     */       }
/*     */     });
/* 143 */     if (this.mLoadListener != null) {
/* 144 */       this.mLoadListener.a(new com.bytedance.sdk.openadsdk.core.a.c(this.mContext, this.d, "splash_ad"));
/*     */     }
/* 146 */     this.mSplashLayout.setOnClickListenerInternal(adClickListerReal);
/* 147 */     this.mSplashLayout.setOnTouchListenerInternal(adClickListerReal);
/* 148 */     this.mSplashLayout.setSkipListener(new View.OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView)
/*     */       {
/* 152 */       if (!StringUtils.isEmpty(TTSplashAdImpl.this.d.o())) {
        AdEvent.c(TTSplashAdImpl.this.d);
    }

    if (TTSplashAdImpl.this.mInteractionListener != null) {
        TTSplashAdImpl.this.mHandler.removeCallbacksAndMessages((Object)null);
        TTSplashAdImpl.this.b = 0;
        TTSplashAdImpl.this.mInteractionListener.onAdSkip();
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
/* 177 */     this.mInteractionListener = paramAdInteractionListener;
/*     */   }
/*     */   
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/* 182 */     if (this.mLoadListener != null) {
/* 183 */       this.mLoadListener.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   private DownLoadListenerImpl getDownLoadListenerImpl(NativeAdData paramh) {
/* 188 */     if (paramh.c() == 4) {
/* 189 */       return new DownLoadListenerImpl(this.mContext, paramh, "splash_ad");
/*     */     }
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public void setNotAllowSdkCountdown()
/*     */   {
/* 196 */     this.g = true;
/* 197 */     this.mSplashLayout.setSkipIconVisibility(8);
/* 198 */     this.mHandler.removeCallbacksAndMessages(null);
/*     */   }
/*     */   
/*     */   private void a(int paramInt) {
/* 202 */     SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramInt + "ViewWather | 跳过");
/* 203 */     localSpannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.color.tt_skip_red)), 0, 2, 33);
/* 204 */     this.mSplashLayout.setSkipText(localSpannableStringBuilder);
/*     */   }
/*     */   
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 209 */     if (paramMessage.what == 1) {
/* 210 */       this.b -= 1;
/* 211 */       if (this.b == 0) {
/* 212 */         if (this.mInteractionListener != null) {
/* 213 */           this.mInteractionListener.onAdTimeOver();
/*     */         }
/* 215 */         LogUtils.b(TAG, "播放时间到");
/* 216 */         this.mHandler.removeCallbacksAndMessages(null);
/* 217 */       } else if (this.b > 0) {
/* 218 */         a(this.b);
/* 219 */         this.mHandler.sendEmptyMessageDelayed(1, 1000L);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\doErrorHelper\LocationUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */