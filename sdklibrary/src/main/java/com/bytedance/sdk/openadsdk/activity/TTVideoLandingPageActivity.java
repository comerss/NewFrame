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
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.a.f;
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
/*     */   private v j;
/*     */   private int k;
/*     */   private RelativeLayout l;
/*     */   private FrameLayout m;
/*     */   private int n;
/*     */   private f o;
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
///* 116 */     this.mQ = com.bytedance.sdk.openadsdk.core.s.intera().c();
/* 117 */     this.r = com.bytedance.sdk.openadsdk.core.s.a().b();
/* 118 */     com.bytedance.sdk.openadsdk.core.s.a().f();
/* 119 */     this.C = new AQuery2(this.f);
///* 120 */     intera();
///* 121 */     d();
///* 122 */     eee();
/* 123 */     boolean bool = Build.VERSION.SDK_INT >= 16;
/* 124 */     com.bytedance.sdk.openadsdk.core.q.a(this.f).a(bool).a(this.b);
/* 125 */     this.b.setWebViewClient(new b(this.f, this.j, this.h));
///* 126 */     this.dislike.getSettings().setUserAgentString(j.intera(this.dislike, this.g));
/*     */     
/* 128 */     if (Build.VERSION.SDK_INT >= 21) {
/* 129 */       this.b.getSettings().setMixedContentMode(0);
/*     */     }
/* 131 */     this.b.loadUrl(str1);
/* 132 */     this.b.setWebChromeClient(new a(this.j));
/* 133 */    /* this.dislike.setDownloadListener(new DownloadListener()
*//*     *//*     {
*//*     *//*       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
*//* 136 *//*         String str = null;
*//* 137 *//*         if (TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this) != null) {
*//* 138 *//*           str = TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this).d() == null ? null : TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this).d().intera();
*//*     *//*         }
*//* 140 *//*         l.intera(TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this), paramAnonymousString1, null, str);
*//*     *//*       }
*//*     *//*     });
*//* 143 *//*     if (this.eee != null) {
*//* 144 *//*       this.eee.setText(com.bytedance.sdk.openadsdk.g.mQ.intera(str2) ? getBaseContext().getString(R.string.tt_web_title_default) : str2);
*//*     *//*     }*/
///* 146 */     dislike();
/*     */   }
/*     */   
/*     */   /*private void intera() {
*//* 150 *//*     this.dislike = ((SSWebView)findViewById(R.id.browser_webview));
*//* 151 *//*     this.c = ((ImageView)findViewById(R.id.titlebar_back));
*//* 152 *//*     if (this.c != null) {
*//* 153 *//*       this.c.setOnClickListener(new OnClickListener()
*//*     *//*       {
*//*     *//*         public void onClick(View paramAnonymousView) {
*//* 156 *//*           if (TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this) != null) {
*//* 157 *//*             if (TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this).canGoBack()) {
*//* 158 *//*               TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this).goBack();
*//*     *//*             } else {
*//* 160 *//*               TTVideoLandingPageActivity.this.finish();
*//*     *//*             }
*//*     *//*           }
*//*     *//*         }
*//*     *//*       });
*//*     *//*     }
*//* 166 *//*     this.d = ((ImageView)findViewById(R.id.titlebar_close));
*//* 167 *//*     if (this.d != null) {
*//* 168 *//*       this.d.setOnClickListener(new OnClickListener()
*//*     *//*       {
*//*     *//*         public void onClick(View paramAnonymousView) {
*//* 171 *//*           TTVideoLandingPageActivity.this.finish();
*//*     *//*         }
*//*     *//*       });
*//*     *//*     }
*//* 175 *//*     this.eee = ((TextView)findViewById(R.id.titlebar_title));
*//* 176 *//*     this.m = ((FrameLayout)findViewById(R.id.native_video_container));
*//* 177 *//*     this.l = ((RelativeLayout)findViewById(R.id.native_video_titlebar));
*//* 178 *//*     this.w = ((RelativeLayout)findViewById(R.id.tt_rl_download));
*//* 179 *//*     this.x = ((TextView)findViewById(R.id.tt_video_btn_ad_image_tv));
*//* 180 *//*     this.y = ((RoundImageView)findViewById(R.id.video_ad_logo_image));
*//* 181 *//*     this.z = ((TextView)findViewById(R.id.tt_video_ad_name));
*//* 182 *//*     this.A = ((TextView)findViewById(R.id.tt_video_ad_button));
*//*     *//*
*//* 184 *//*     c();
*//*     *//*   }
*//*     *//*
*//*     *//*   private void dislike() {
*//* 188 *//*     if (this.mN == 5) {
*//*     *//*       try {
*//* 190 *//*         if ((this.mR != null) && (this.mR.j())) {
*//* 191 *//*           this.mP = Long.valueOf(0L);
*//*     *//*         }
*//* 193 *//*         this.mO = new f(this.f, this.mQ);
*//* 194 *//*         this.mO.setIsInDetail(true);
*//* 195 *//*         if (this.mO.intera(this.mP.longValue())) {
*//* 196 *//*           this.m.setVisibility(0);
*//* 197 *//*           this.m.removeAllViews();
*//* 198 *//*           this.m.addView(this.mO);
*//*     *//*         }
*//* 200 *//*         if (this.mO.getNativeVideoController() != null) {
*//* 201 *//*           this.mO.getNativeVideoController().intera(false);
*//* 202 *//*           this.mO.getNativeVideoController().intera(this.E);
*//* 203 *//*           if (this.mR != null) {
*//* 204 *//*             this.mO.getNativeVideoController().dislike(this.mR.eee());
*//* 205 *//*             this.mO.getNativeVideoController().dislike(this.mR.i());
*//*     *//*           }
*//*     *//*         }
*//*     *//*       } catch (Exception localException) {
*//* 209 *//*         localException.printStackTrace();
*//*     *//*       }
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   private void c()
*//*     *//*   {
*//* 216 *//*     if ((this.mQ == null) || (this.mQ.c() != 4)) {
*//* 217 *//*       return;
*//*     *//*     }
*//* 219 *//*     com.bytedance.sdk.openadsdk.g.s.intera(this.w, 0);
*//* 220 *//*     String str = "";
*//* 221 *//*     if (!com.bytedance.sdk.openadsdk.g.mQ.intera(this.mQ.j())) {
*//* 222 *//*       str = this.mQ.j();
*//* 223 *//*     } else if (!com.bytedance.sdk.openadsdk.g.mQ.intera(this.mQ.m())) {
*//* 224 *//*       str = this.mQ.m();
*//* 225 *//*     } else if (!com.bytedance.sdk.openadsdk.g.mQ.intera(this.mQ.dislike())) {
*//* 226 *//*       str = this.mQ.dislike();
*//*     *//*     }
*//* 228 *//*     if ((this.mQ.d() != null) && (this.mQ.d().intera() != null)) {
*//* 229 *//*       com.bytedance.sdk.openadsdk.g.s.intera(this.y, 0);
*//* 230 *//*       com.bytedance.sdk.openadsdk.g.s.intera(this.x, 4);
*//* 231 *//*       ((AQuery)this.C.id(this.y)).image(this.mQ.d().intera());
*//* 232 *//*     } else if (!com.bytedance.sdk.openadsdk.g.mQ.intera(str)) {
*//* 233 *//*       com.bytedance.sdk.openadsdk.g.s.intera(this.y, 4);
*//* 234 *//*       com.bytedance.sdk.openadsdk.g.s.intera(this.x, 0);
*//* 235 *//*       this.x.setText(str.substring(0, 1));
*//*     *//*     }
*//*     *//*
*//* 238 *//*     if (!com.bytedance.sdk.openadsdk.g.mQ.intera(str)) {
*//* 239 *//*       this.z.setText(str);
*//*     *//*     }
*//* 241 *//*     com.bytedance.sdk.openadsdk.g.s.intera(this.z, 0);
*//*     *//*
*//* 243 *//*     com.bytedance.sdk.openadsdk.g.s.intera(this.A, 0);
*//*     *//*   }
*//*     *//*
*//*     *//*   private void d() {
*//* 247 *//*     if ((this.mQ == null) || (this.mQ.c() != 4)) {
*//* 248 *//*       return;
*//*     *//*     }
*//* 250 *//*     this.B = new x(this, this.mQ, "embeded_ad");
*//* 251 *//*     com.bytedance.sdk.openadsdk.core.intera.intera locala = new com.bytedance.sdk.openadsdk.core.intera.intera(this, this.mQ, "embeded_ad", 1);
*//*     *//*
*//* 253 *//*     locala.intera(false);
*//* 254 *//*     locala.intera(this.mR);
*//* 255 *//*     this.A.setOnClickListener(locala);
*//* 256 *//*     this.A.setOnTouchListener(locala);
*//* 257 *//*     locala.intera(this.B);
*//* 258 *//*     this.B.intera(new x.dislike()
*//*     *//*     {
*//*     *//*       public void intera() {
*//* 261 *//*         com.bytedance.sdk.openadsdk.d.c.intera(TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_start_detail");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void dislike()
*//*     *//*       {
*//* 266 *//*         com.bytedance.sdk.openadsdk.d.c.dislike(TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_pause");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void c()
*//*     *//*       {
*//* 271 *//*         com.bytedance.sdk.openadsdk.d.c.c(TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_continue");
*//*     *//*       }
*//*     *//*
*//*     *//*       public void d()
*//*     *//*       {
*//* 276 *//*         com.bytedance.sdk.openadsdk.d.c.h(TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this), "embeded_ad", "click_open_detail");
*//*     *//*       }
*//*     *//*     });
*//*     *//*   }
*//*     *//*
*//*     *//*   private void eee() {
*//* 282 *//*     this.j = new v(this);
*//* 283 *//*     this.j.intera(this.dislike)
*//* 284 *//*       .intera(this.h)
*//* 285 *//*       .dislike(this.i)
*//* 286 *//*       .intera(this.m);
*//*     *//*   }
*//*     *//*
*//*     *//*   public void onBackPressed()
*//*     *//*   {
*//* 291 *//*     if ((this.D) && (this.mO != null) && (this.mO.getNativeVideoController() != null)) {
*//* 292 *//*       ((com.bytedance.sdk.openadsdk.core.video.intera.intera)this.mO.getNativeVideoController()).eee(null, null);
*//* 293 *//*       this.D = false;
*//* 294 *//*       return;
*//*     *//*     }
*//* 296 *//*     super.onBackPressed();
*//*     *//*   }
*//*     *//*
*//* 299 *//*   private eee E = new eee()
*//*     *//*   {
*//*     *//*     public void intera(boolean paramAnonymousBoolean) {
*//* 302 *//*       TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this, paramAnonymousBoolean);
*//* 303 *//*       if (!TTVideoLandingPageActivity.this.isFinishing()) {
*//*     *//*         ViewGroup.MarginLayoutParams localMarginLayoutParams;
*//* 305 *//*         if (paramAnonymousBoolean) {
*//* 306 *//*           com.bytedance.sdk.openadsdk.g.s.intera(TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this), 8);
*//* 307 *//*           com.bytedance.sdk.openadsdk.g.s.intera(TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this), 8);
*//*     *//*
*//* 309 *//*           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.eee(TTVideoLandingPageActivity.this).getLayoutParams();
*//* 310 *//*           TTVideoLandingPageActivity.intera(TTVideoLandingPageActivity.this, localMarginLayoutParams.leftMargin);
*//* 311 *//*           TTVideoLandingPageActivity.dislike(TTVideoLandingPageActivity.this, localMarginLayoutParams.topMargin);
*//* 312 *//*           TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this, localMarginLayoutParams.width);
*//* 313 *//*           TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this, localMarginLayoutParams.height);
*//* 314 *//*           localMarginLayoutParams.width = -1;
*//* 315 *//*           localMarginLayoutParams.height = -1;
*//* 316 *//*           localMarginLayoutParams.topMargin = 0;
*//* 317 *//*           localMarginLayoutParams.leftMargin = 0;
*//* 318 *//*           TTVideoLandingPageActivity.eee(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
*//*     *//*         }
*//*     *//*         else {
*//* 321 *//*           com.bytedance.sdk.openadsdk.g.s.intera(TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this), 0);
*//* 322 *//*           com.bytedance.sdk.openadsdk.g.s.intera(TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this), 0);
*//* 323 *//*           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.eee(TTVideoLandingPageActivity.this).getLayoutParams();
*//* 324 *//*           localMarginLayoutParams.width = TTVideoLandingPageActivity.f(TTVideoLandingPageActivity.this);
*//* 325 *//*           localMarginLayoutParams.height = TTVideoLandingPageActivity.g(TTVideoLandingPageActivity.this);
*//* 326 *//*           localMarginLayoutParams.leftMargin = TTVideoLandingPageActivity.h(TTVideoLandingPageActivity.this);
*//* 327 *//*           localMarginLayoutParams.topMargin = TTVideoLandingPageActivity.i(TTVideoLandingPageActivity.this);
*//* 328 *//*           TTVideoLandingPageActivity.eee(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
*//*     *//*         }
*//*     *//*       }
*//*     *//*     }
*//*     *//*   };
*//*     *//*
*//*     *//*   protected void onSaveInstanceState(Bundle paramBundle)
*//*     *//*   {
*//* 336 *//*     super.onSaveInstanceState(paramBundle);
*//* 337 *//*     if (this.mO != null) {
*//* 338 *//*       paramBundle.putLong("video_play_position", this.mO.getNativeVideoController().d());
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   protected void onResume()
*//*     *//*   {
*//* 344 *//*     super.onResume();
*//* 345 *//*     if (this.j != null) {
*//* 346 *//*       this.j.dislike();
*//*     *//*     }
*//* 348 *//*     if (this.B != null) {
*//* 349 *//*       this.B.eee();
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
*//* 366 *//*     if (this.j != null) {
*//* 367 *//*       this.j.c();
*//*     *//*     }
*//* 369 *//*     if (this.mO != null) {
*//* 370 *//*       this.mO.getNativeVideoController().intera();
*//*     *//*     }
*//* 372 *//*     if (this.B != null) {
*//* 373 *//*       this.B.f();
*//*     *//*     }
*//* 375 *//*     if ((this.mO != null) && (this.mO.getNativeVideoController() != null) && (this.mR != null))
*//*     *//*     {
*//* 377 *//*       this.mP = Long.valueOf(this.mO.getNativeVideoController().d());
*//* 378 *//*       this.mR.dislike(this.mO.getNativeVideoController().eee());
*//* 379 *//*       this.mR.c(this.mO.getNativeVideoController().f());
*//* 380 *//*       this.mR.intera(this.mP.longValue());
*//*     *//*     }
*//*     *//*   }
*//*     *//*
*//*     *//*   protected void onDestroy()
*//*     *//*   {
*//* 386 *//*     super.onDestroy();
*//* 387 *//*     ab.intera(this.f, this.dislike);
*//* 388 *//*     ab.intera(this.dislike);
*//* 389 *//*     this.dislike = null;
*//*     *//*
*//* 391 *//*     if (this.j != null) {
*//* 392 *//*       this.j.d();
*//*     *//*     }
*//* 394 *//*     if ((this.mO != null) && (this.mO.getNativeVideoController() != null)) {
*//* 395 *//*       this.mO.getNativeVideoController().c();
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