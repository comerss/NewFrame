/*     */ package com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.androidquery.callback.AQuery2;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.video.a.ADViewLayout;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;

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
/*     */ public class TTVideoLandingPageActivity
/*     */   extends Activity
/*     */ {
/*  48 */   private static final String a = TTVideoLandingPageActivity.class.getSimpleName();
/*     */   
/*     */   private SSWebView b;
/*     */   
/*     */   private ImageView c;
/*     */   
/*     */   private ImageView d;
/*     */   
/*     */   private TextView e;
/*     */   
/*     */   private Context f;
/*     */   
/*     */   private int g;
/*     */   
/*     */   private String h;
/*     */   private String i;
/*     */   private TTAndroidObject j;
/*     */   private int k;
/*     */   private RelativeLayout l;
/*     */   private FrameLayout m;
/*     */   private int n;
/*     */   private ADViewLayout o;
/*     */   private Long p;
/*     */   private com.bytedance.sdk.openadsdk.core.video.a.c r;
/*  73 */   private int s = 0;
/*  74 */   private int t = 0;
/*  75 */   private int u = 0;
/*  76 */   private int v = 0;
/*     */   
/*     */   private RelativeLayout w;
/*     */   
/*     */   private TextView x;
/*     */   
/*     */   private RoundImageView y;
/*     */   
/*     */   private TextView z;
/*     */   private TextView A;
/*     */   private AQuery2 C;
/*  88 */   private boolean D = false;
/*     */   
/*     */ 
/*     */   protected void onCreate(@Nullable Bundle paramBundle)
/*     */   {
/*  93 */     super.onCreate(paramBundle);
/*     */     
/*     */ 
/*  96 */     if (com.bytedance.sdk.openadsdk.core.h.a().k()) {
/*  97 */       getWindow().addFlags(2621440);
/*     */     }
/*     */     
/* 100 */     setContentView(R.layout.tt_activity_videolandingpage);
/* 101 */     this.f = this;
/* 102 */     Intent localIntent = getIntent();
/* 103 */     this.g = localIntent.getIntExtra("sdk_version", 1);
/* 104 */     this.h = localIntent.getStringExtra("adid");
/* 105 */     this.i = localIntent.getStringExtra("log_extra");
/* 106 */     this.k = localIntent.getIntExtra("source", -1);
/* 107 */     String str1 = localIntent.getStringExtra("url");
/* 108 */     String str2 = localIntent.getStringExtra("web_title");
/* 109 */     this.n = localIntent.getIntExtra("imageMode", -1);
/* 110 */     this.p = Long.valueOf(localIntent.getLongExtra("video_play_position", 0L));
/*     */     
/* 112 */     if ((paramBundle != null) && (paramBundle.getLong("video_play_position") > 0L)) {
/* 113 */       this.p = Long.valueOf(paramBundle.getLong("video_play_position", 0L));
/*     */     }
/*     */     
///* 116 */     this.mQ = com.bytedance.sdk.openadsdk.core.ViewWather.intera().cc();
/* 117 */     this.r = com.bytedance.sdk.openadsdk.core.s.a().b();
/* 118 */     com.bytedance.sdk.openadsdk.core.s.a().f();
/* 119 */     this.C = new AQuery2(this.f);
///* 120 */     intera();
///* 121 */     LocationUtils();
///* 122 */     TTBannerAdImpl();
/* 123 */     boolean bool = Build.VERSION.SDK_INT >= 16;
/* 124 */     com.bytedance.sdk.openadsdk.core.q.a(this.f).a(bool).a(this.b);
/* 125 */     this.b.setWebViewClient(new MineWebViewClient(this.f, this.j, this.h));
///* 126 */     this.TTAdDislikeImpl.getSettings().setUserAgentString(mTTFeedAd.intera(this.TTAdDislikeImpl, this.ApiException));
/*     */     
/* 128 */     if (Build.VERSION.SDK_INT >= 21) {
/* 129 */       this.b.getSettings().setMixedContentMode(0);
/*     */     }
/* 131 */     this.b.loadUrl(str1);
/* 132 */     this.b.setWebChromeClient(new MineWebChromeClient(this.j));
/* 133 */    /* this.TTAdDislikeImpl.setDownloadListener(new DownloadListener()
*//*     *//*     {
*//*     *//*       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
*//* 136 *//*         String str = null;
*//* 137 *//*         if (TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this) != null) {
*//* 138 *//*           str = TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this).LocationUtils() == null ? null : TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this).LocationUtils().intera();
*//*     *//*         }
*//* 140 *//*         MyDownloadManager.intera(TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this), paramAnonymousString1, null, str);
*//*     *//*       }
*//*     *//*     });
*//* 143 *//*     if (this.TTBannerAdImpl != null) {
*//* 144 *//*       this.TTBannerAdImpl.setText(com.bytedance.sdk.openadsdk.ApiException.mQ.intera(str2) ? getBaseContext().getString(R.string.tt_web_title_default) : str2);
*//*     *//*     }*/
///* 146 */     TTAdDislikeImpl();
/*     */   }
/*     */   
/*     */   /*private void intera() {
*//* 150 *//*     this.TTAdDislikeImpl = ((SSWebView)findViewById(R.id.browser_webview));
*//* 151 *//*     this.cc = ((ImageView)findViewById(R.id.titlebar_back));
*//* 152 *//*     if (this.cc != null) {
*//* 153 *//*       this.cc.setOnClickListener(new OnClickListener()
*//*     *//*       {
*//*     *//*         public void onClick(View paramAnonymousView) {
*//* 156 *//*           if (TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this) != null) {
*//* 157 *//*             if (TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this).canGoBack()) {
*//* 158 *//*               TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this).goBack();
*//*     *//*             } else {
*//* 160 *//*               TTVideoLandingPageActivity.this.finish();
*//*     *//*             }
*//*     *//*           }
*//*     *//*         }
*//*     *//*       });
*//*     *//*     }
*//* 166 *//*     this.LocationUtils = ((ImageView)findViewById(R.id.titlebar_close));
*//* 167 *//*     if (this.LocationUtils != null) {
*//* 168 *//*       this.LocationUtils.setOnClickListener(new OnClickListener()
*//*     *//*       {
*//*     *//*         public void onClick(View paramAnonymousView) {
*//* 171 *//*           TTVideoLandingPageActivity.this.finish();
*//*     *//*         }
*//*     *//*       });
*//*     *//*     }
*//* 175 *//*     this.TTBannerAdImpl = ((TextView)findViewById(R.id.titlebar_title));
*//* 176 *//*     this.LogUtils = ((FrameLayout)findViewById(R.id.native_video_container));
*//* 177 *//*     this.MyDownloadManager = ((RelativeLayout)findViewById(R.id.native_video_titlebar));
*//* 178 *//*     this.w = ((RelativeLayout)findViewById(R.id.tt_rl_download));
*//* 179 *//*     this.DownLoadListenerImpl = ((TextView)findViewById(R.id.tt_video_btn_ad_image_tv));
*//* 180 *//*     this.y = ((RoundImageView)findViewById(R.id.video_ad_logo_image));
*//* 181 *//*     this.z = ((TextView)findViewById(R.id.tt_video_ad_name));
*//* 182 *//*     this.A = ((TextView)findViewById(R.id.tt_video_ad_button));
*//*     *//*
*//* 184 *//*     cc();
*//*     *//*   }
*//*     *//*
*//*     *//*   private void TTAdDislikeImpl() {
*//* 188 *//*     if (this.mN == 5) {
*//*     *//*       try {
*//* 190 *//*         if ((this.mR != null) && (this.mR.mTTFeedAd())) {
*//* 191 *//*           this.mP = Long.valueOf(0L);
*//*     *//*         }
*//* 193 *//*         this.mO = new HandleInitEvent(this.HandleInitEvent, this.mQ);
*//* 194 *//*         this.mO.setIsInDetail(true);
*//* 195 *//*         if (this.mO.intera(this.mP.longValue())) {
*//* 196 *//*           this.LogUtils.setVisibility(0);
*//* 197 *//*           this.LogUtils.removeAllViews();
*//* 198 *//*           this.LogUtils.addView(this.mO);
*//*     *//*         }
*//* 200 *//*         if (this.mO.getNativeVideoController() != null) {
*//* 201 *//*           this.mO.getNativeVideoController().intera(false);
*//* 202 *//*           this.mO.getNativeVideoController().intera(this.E);
*//* 203 *//*           if (this.mR != null) {
*//* 204 *//*             this.mO.getNativeVideoController().TTAdDislikeImpl(this.mR.TTBannerAdImpl());
*//* 205 *//*             this.mO.getNativeVideoController().TTAdDislikeImpl(this.mR.mOnClick());
*//*     *//*           }
*//*     *//*         }
*//*     *//*       } catch (Exception localException) {
*//* 209 *//*         localException.printStackTrace();
*//*     *//*       }
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   private void cc()
*//*     *//*   {
*//* 216 *//*     if ((this.mQ == null) || (this.mQ.cc() != 4)) {
*//* 217 *//*       return;
*//*     *//*     }
*//* 219 *//*     com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.w, 0);
*//* 220 *//*     String str = "";
*//* 221 *//*     if (!com.bytedance.sdk.openadsdk.ApiException.mQ.intera(this.mQ.mTTFeedAd())) {
*//* 222 *//*       str = this.mQ.mTTFeedAd();
*//* 223 *//*     } else if (!com.bytedance.sdk.openadsdk.ApiException.mQ.intera(this.mQ.LogUtils())) {
*//* 224 *//*       str = this.mQ.LogUtils();
*//* 225 *//*     } else if (!com.bytedance.sdk.openadsdk.ApiException.mQ.intera(this.mQ.TTAdDislikeImpl())) {
*//* 226 *//*       str = this.mQ.TTAdDislikeImpl();
*//*     *//*     }
*//* 228 *//*     if ((this.mQ.LocationUtils() != null) && (this.mQ.LocationUtils().intera() != null)) {
*//* 229 *//*       com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.y, 0);
*//* 230 *//*       com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.DownLoadListenerImpl, 4);
*//* 231 *//*       ((AQuery)this.C.id(this.y)).image(this.mQ.LocationUtils().intera());
*//* 232 *//*     } else if (!com.bytedance.sdk.openadsdk.ApiException.mQ.intera(str)) {
*//* 233 *//*       com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.y, 4);
*//* 234 *//*       com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.DownLoadListenerImpl, 0);
*//* 235 *//*       this.DownLoadListenerImpl.setText(str.substring(0, 1));
*//*     *//*     }
*//*     *//*
*//* 238 *//*     if (!com.bytedance.sdk.openadsdk.ApiException.mQ.intera(str)) {
*//* 239 *//*       this.z.setText(str);
*//*     *//*     }
*//* 241 *//*     com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.z, 0);
*//*     *//*
*//* 243 *//*     com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(this.A, 0);
*//*     *//*   }
*//*     *//*
*//*     *//*   private void LocationUtils() {
*//* 247 *//*     if ((this.mQ == null) || (this.mQ.cc() != 4)) {
*//* 248 *//*       return;
*//*     *//*     }
*//* 250 *//*     this.B = new DownLoadListenerImpl(this, this.mQ, "embeded_ad");
*//* 251 *//*     com.bytedance.sdk.openadsdk.core.intera.intera locala = new com.bytedance.sdk.openadsdk.core.intera.intera(this, this.mQ, "embeded_ad", 1);
*//*     *//*
*//* 253 *//*     locala.intera(false);
*//* 254 *//*     locala.intera(this.mR);
*//* 255 *//*     this.A.setOnClickListener(locala);
*//* 256 *//*     this.A.setOnTouchListener(locala);
*//* 257 *//*     locala.intera(this.B);
*//* 258 *//*     this.B.intera(new DownLoadListenerImpl.TTAdDislikeImpl()
*//*     *//*     {
*//*     *//*       public void intera() {
*//* 261 *//*         com.bytedance.sdk.openadsdk.LocationUtils.cc.intera(TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_start_detail");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void TTAdDislikeImpl()
*//*     *//*       {
*//* 266 *//*         com.bytedance.sdk.openadsdk.LocationUtils.cc.TTAdDislikeImpl(TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_pause");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void cc()
*//*     *//*       {
*//* 271 *//*         com.bytedance.sdk.openadsdk.LocationUtils.cc.cc(TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_continue");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void LocationUtils()
*//*     *//*       {
*//* 276 *//*         com.bytedance.sdk.openadsdk.LocationUtils.cc.ImageHelper(TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_open_detail");
*//*     *//*       }
*//*     *//*     });
*//*     *//*   }
*//*     *//*
*//*     *//*   private void TTBannerAdImpl() {
*//* 282 *//*     this.mTTFeedAd = new TTAndroidObject(this);
*//* 283 *//*     this.mTTFeedAd.intera(this.TTAdDislikeImpl)
*//* 284 *//*       .intera(this.ImageHelper)
*//* 285 *//*       .TTAdDislikeImpl(this.mOnClick)
*//* 286 *//*       .intera(this.LogUtils);
*//*     *//*   }
*//*     *//*
*//*     *//*   public void onBackPressed()
*//*     *//*   {
*//* 291 *//*     if ((this.D) && (this.mO != null) && (this.mO.getNativeVideoController() != null)) {
*//* 292 *//*       ((com.bytedance.sdk.openadsdk.core.video.intera.intera)this.mO.getNativeVideoController()).TTBannerAdImpl(null, null);
*//* 293 *//*       this.D = false;
*//* 294 *//*       return;
*//*     *//*     }
*//* 296 *//*     super.onBackPressed();
*//*     *//*   }
*//*     *//*
*//* 299 *//*   private TTBannerAdImpl E = new TTBannerAdImpl()
*//*     *//*   {
*//*     *//*     public void intera(boolean paramAnonymousBoolean) {
*//* 302 *//*       TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this, paramAnonymousBoolean);
*//* 303 *//*       if (!TTVideoLandingPageActivity.this.isFinishing()) {
*//*     *//*         ViewGroup.MarginLayoutParams localMarginLayoutParams;
*//* 305 *//*         if (paramAnonymousBoolean) {
*//* 306 *//*           com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this), 8);
*//* 307 *//*           com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(TTVideoLandingPageActivity.LocationUtils(TTVideoLandingPageActivity.this), 8);
*//*     *//*
*//* 309 *//*           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.TTBannerAdImpl(TTVideoLandingPageActivity.this).getLayoutParams();
*//* 310 *//*           TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this, localMarginLayoutParams.leftMargin);
*//* 311 *//*           TTVideoLandingPageActivity.TTAdDislikeImpl(TTVideoLandingPageActivity.this, localMarginLayoutParams.topMargin);
*//* 312 *//*           TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this, localMarginLayoutParams.width);
*//* 313 *//*           TTVideoLandingPageActivity.LocationUtils(TTVideoLandingPageActivity.this, localMarginLayoutParams.height);
*//* 314 *//*           localMarginLayoutParams.width = -1;
*//* 315 *//*           localMarginLayoutParams.height = -1;
*//* 316 *//*           localMarginLayoutParams.topMargin = 0;
*//* 317 *//*           localMarginLayoutParams.leftMargin = 0;
*//* 318 *//*           TTVideoLandingPageActivity.TTBannerAdImpl(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
*//*     *//*         }
*//*     *//*         else {
*//* 321 *//*           com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(TTVideoLandingPageActivity.cc(TTVideoLandingPageActivity.this), 0);
*//* 322 *//*           com.bytedance.sdk.openadsdk.ApiException.ViewWather.intera(TTVideoLandingPageActivity.LocationUtils(TTVideoLandingPageActivity.this), 0);
*//* 323 *//*           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.TTBannerAdImpl(TTVideoLandingPageActivity.this).getLayoutParams();
*//* 324 *//*           localMarginLayoutParams.width = TTVideoLandingPageActivity.doErrorHelper(TTVideoLandingPageActivity.this);
*//* 325 *//*           localMarginLayoutParams.height = TTVideoLandingPageActivity.ApiException(TTVideoLandingPageActivity.this);
*//* 326 *//*           localMarginLayoutParams.leftMargin = TTVideoLandingPageActivity.ImageHelper(TTVideoLandingPageActivity.this);
*//* 327 *//*           localMarginLayoutParams.topMargin = TTVideoLandingPageActivity.mOnClick(TTVideoLandingPageActivity.this);
*//* 328 *//*           TTVideoLandingPageActivity.TTBannerAdImpl(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
*//*     *//*         }
*//*     *//*       }
*//*     *//*     }
*//*     *//*   };
*//*     *//*
*//*     *//*   protected void onSaveInstanceState(Bundle paramBundle)
*//*     *//*   {
*//* 336 *//*     super.onSaveInstanceState(paramBundle);
*//* 337 *//*     if (this.mO != null) {
*//* 338 *//*       paramBundle.putLong("video_play_position", this.mO.getNativeVideoController().LocationUtils());
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   protected void onResume()
*//*     *//*   {
*//* 344 *//*     super.onResume();
*//* 345 *//*     if (this.mTTFeedAd != null) {
*//* 346 *//*       this.mTTFeedAd.TTAdDislikeImpl();
*//*     *//*     }
*//* 348 *//*     if (this.B != null) {
*//* 349 *//*       this.B.TTBannerAdImpl();
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*
*//*     *//*   protected void onPause()
*//*     *//*   {
*//* 365 *//*     super.onPause();
*//* 366 *//*     if (this.mTTFeedAd != null) {
*//* 367 *//*       this.mTTFeedAd.cc();
*//*     *//*     }
*//* 369 *//*     if (this.mO != null) {
*//* 370 *//*       this.mO.getNativeVideoController().intera();
*//*     *//*     }
*//* 372 *//*     if (this.B != null) {
*//* 373 *//*       this.B.doErrorHelper();
*//*     *//*     }
*//* 375 *//*     if ((this.mO != null) && (this.mO.getNativeVideoController() != null) && (this.mR != null))
*//*     *//*     {
*//* 377 *//*       this.mP = Long.valueOf(this.mO.getNativeVideoController().LocationUtils());
*//* 378 *//*       this.mR.TTAdDislikeImpl(this.mO.getNativeVideoController().TTBannerAdImpl());
*//* 379 *//*       this.mR.cc(this.mO.getNativeVideoController().doErrorHelper());
*//* 380 *//*       this.mR.intera(this.mP.longValue());
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   protected void onDestroy()
*//*     *//*   {
*//* 386 *//*     super.onDestroy();
*//* 387 *//*     ab.intera(this.doErrorHelper, this.TTAdDislikeImpl);
*//* 388 *//*     ab.intera(this.TTAdDislikeImpl);
*//* 389 *//*     this.TTAdDislikeImpl = null;
*//*     *//*
*//* 391 *//*     if (this.mTTFeedAd != null) {
*//* 392 *//*       this.mTTFeedAd.LocationUtils();
*//*     *//*     }
*//* 394 *//*     if ((this.mO != null) && (this.mO.getNativeVideoController() != null)) {
*//* 395 *//*       this.mO.getNativeVideoController().cc();
*//*     *//*     }
*//* 397 *//*     this.mR = null;
*//* 398 *//*     this.mO = null;
*//* 399 *//*     this.mQ = null;
*//*     *//*   }*/
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\TTVideoLandingPageActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */