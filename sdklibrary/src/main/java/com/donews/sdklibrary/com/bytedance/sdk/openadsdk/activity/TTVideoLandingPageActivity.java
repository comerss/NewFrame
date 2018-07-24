/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewGroup.MarginLayoutParams;
/*     */ import android.view.Window;
/*     */ import android.webkit.DownloadListener;
/*     */ import android.webkit.WebSettings;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.RelativeLayout;
/*     */ import android.widget.TextView;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.c.l;
/*     */ import com.bytedance.sdk.openadsdk.c.x;
/*     */ import com.bytedance.sdk.openadsdk.c.x.b;
/*     */ import com.bytedance.sdk.openadsdk.core.ab;
/*     */ import com.bytedance.sdk.openadsdk.core.d.g;
/*     */ import com.bytedance.sdk.openadsdk.core.v;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.e;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.f;
/*     */ import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
/*     */ import com.bytedance.sdk.openadsdk.g.j;
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
/*     */   private com.bytedance.sdk.openadsdk.core.d.h q;
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
/*     */   private x B;
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
/* 116 */     this.q = com.bytedance.sdk.openadsdk.core.s.a().c();
/* 117 */     this.r = com.bytedance.sdk.openadsdk.core.s.a().b();
/* 118 */     com.bytedance.sdk.openadsdk.core.s.a().f();
/* 119 */     this.C = new AQuery2(this.f);
/* 120 */     a();
/* 121 */     d();
/* 122 */     e();
/* 123 */     boolean bool = Build.VERSION.SDK_INT >= 16;
/* 124 */     com.bytedance.sdk.openadsdk.core.q.a(this.f).a(bool).a(this.b);
/* 125 */     this.b.setWebViewClient(new b(this.f, this.j, this.h));
/* 126 */     this.b.getSettings().setUserAgentString(j.a(this.b, this.g));
/*     */     
/* 128 */     if (Build.VERSION.SDK_INT >= 21) {
/* 129 */       this.b.getSettings().setMixedContentMode(0);
/*     */     }
/* 131 */     this.b.loadUrl(str1);
/* 132 */     this.b.setWebChromeClient(new a(this.j));
/* 133 */     this.b.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
/* 136 */         String str = null;
/* 137 */         if (TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this) != null) {
/* 138 */           str = TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this).d() == null ? null : TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this).d().a();
/*     */         }
/* 140 */         l.a(TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this), paramAnonymousString1, null, str);
/*     */       }
/*     */     });
/* 143 */     if (this.e != null) {
/* 144 */       this.e.setText(com.bytedance.sdk.openadsdk.g.q.a(str2) ? getBaseContext().getString(R.string.tt_web_title_default) : str2);
/*     */     }
/* 146 */     b();
/*     */   }
/*     */   
/*     */   private void a() {
/* 150 */     this.b = ((SSWebView)findViewById(R.id.browser_webview));
/* 151 */     this.c = ((ImageView)findViewById(R.id.titlebar_back));
/* 152 */     if (this.c != null) {
/* 153 */       this.c.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/* 156 */           if (TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this) != null) {
/* 157 */             if (TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this).canGoBack()) {
/* 158 */               TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this).goBack();
/*     */             } else {
/* 160 */               TTVideoLandingPageActivity.this.finish();
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 166 */     this.d = ((ImageView)findViewById(R.id.titlebar_close));
/* 167 */     if (this.d != null) {
/* 168 */       this.d.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/* 171 */           TTVideoLandingPageActivity.this.finish();
/*     */         }
/*     */       });
/*     */     }
/* 175 */     this.e = ((TextView)findViewById(R.id.titlebar_title));
/* 176 */     this.m = ((FrameLayout)findViewById(R.id.native_video_container));
/* 177 */     this.l = ((RelativeLayout)findViewById(R.id.native_video_titlebar));
/* 178 */     this.w = ((RelativeLayout)findViewById(R.id.tt_rl_download));
/* 179 */     this.x = ((TextView)findViewById(R.id.tt_video_btn_ad_image_tv));
/* 180 */     this.y = ((RoundImageView)findViewById(R.id.video_ad_logo_image));
/* 181 */     this.z = ((TextView)findViewById(R.id.tt_video_ad_name));
/* 182 */     this.A = ((TextView)findViewById(R.id.tt_video_ad_button));
/*     */     
/* 184 */     c();
/*     */   }
/*     */   
/*     */   private void b() {
/* 188 */     if (this.n == 5) {
/*     */       try {
/* 190 */         if ((this.r != null) && (this.r.j())) {
/* 191 */           this.p = Long.valueOf(0L);
/*     */         }
/* 193 */         this.o = new f(this.f, this.q);
/* 194 */         this.o.setIsInDetail(true);
/* 195 */         if (this.o.a(this.p.longValue())) {
/* 196 */           this.m.setVisibility(0);
/* 197 */           this.m.removeAllViews();
/* 198 */           this.m.addView(this.o);
/*     */         }
/* 200 */         if (this.o.getNativeVideoController() != null) {
/* 201 */           this.o.getNativeVideoController().a(false);
/* 202 */           this.o.getNativeVideoController().a(this.E);
/* 203 */           if (this.r != null) {
/* 204 */             this.o.getNativeVideoController().b(this.r.e());
/* 205 */             this.o.getNativeVideoController().b(this.r.i());
/*     */           }
/*     */         }
/*     */       } catch (Exception localException) {
/* 209 */         localException.printStackTrace();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void c()
/*     */   {
/* 216 */     if ((this.q == null) || (this.q.c() != 4)) {
/* 217 */       return;
/*     */     }
/* 219 */     com.bytedance.sdk.openadsdk.g.s.a(this.w, 0);
/* 220 */     String str = "";
/* 221 */     if (!com.bytedance.sdk.openadsdk.g.q.a(this.q.j())) {
/* 222 */       str = this.q.j();
/* 223 */     } else if (!com.bytedance.sdk.openadsdk.g.q.a(this.q.k())) {
/* 224 */       str = this.q.k();
/* 225 */     } else if (!com.bytedance.sdk.openadsdk.g.q.a(this.q.b())) {
/* 226 */       str = this.q.b();
/*     */     }
/* 228 */     if ((this.q.d() != null) && (this.q.d().a() != null)) {
/* 229 */       com.bytedance.sdk.openadsdk.g.s.a(this.y, 0);
/* 230 */       com.bytedance.sdk.openadsdk.g.s.a(this.x, 4);
/* 231 */       ((AQuery)this.C.id(this.y)).image(this.q.d().a());
/* 232 */     } else if (!com.bytedance.sdk.openadsdk.g.q.a(str)) {
/* 233 */       com.bytedance.sdk.openadsdk.g.s.a(this.y, 4);
/* 234 */       com.bytedance.sdk.openadsdk.g.s.a(this.x, 0);
/* 235 */       this.x.setText(str.substring(0, 1));
/*     */     }
/*     */     
/* 238 */     if (!com.bytedance.sdk.openadsdk.g.q.a(str)) {
/* 239 */       this.z.setText(str);
/*     */     }
/* 241 */     com.bytedance.sdk.openadsdk.g.s.a(this.z, 0);
/*     */     
/* 243 */     com.bytedance.sdk.openadsdk.g.s.a(this.A, 0);
/*     */   }
/*     */   
/*     */   private void d() {
/* 247 */     if ((this.q == null) || (this.q.c() != 4)) {
/* 248 */       return;
/*     */     }
/* 250 */     this.B = new x(this, this.q, "embeded_ad");
/* 251 */     com.bytedance.sdk.openadsdk.core.a.a locala = new com.bytedance.sdk.openadsdk.core.a.a(this, this.q, "embeded_ad", 1);
/*     */     
/* 253 */     locala.a(false);
/* 254 */     locala.a(this.r);
/* 255 */     this.A.setOnClickListener(locala);
/* 256 */     this.A.setOnTouchListener(locala);
/* 257 */     locala.a(this.B);
/* 258 */     this.B.a(new x.b()
/*     */     {
/*     */       public void a() {
/* 261 */         com.bytedance.sdk.openadsdk.d.c.a(TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this), "embeded_ad", "click_start_detail");
/*     */       }
/*     */       
/*     */       public void b()
/*     */       {
/* 266 */         com.bytedance.sdk.openadsdk.d.c.b(TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this), "embeded_ad", "click_pause");
/*     */       }
/*     */       
/*     */       public void c()
/*     */       {
/* 271 */         com.bytedance.sdk.openadsdk.d.c.c(TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this), "embeded_ad", "click_continue");
/*     */       }
/*     */       
/*     */       public void d()
/*     */       {
/* 276 */         com.bytedance.sdk.openadsdk.d.c.h(TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this), TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this), "embeded_ad", "click_open_detail");
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private void e() {
/* 282 */     this.j = new v(this);
/* 283 */     this.j.a(this.b)
/* 284 */       .a(this.h)
/* 285 */       .b(this.i)
/* 286 */       .a(this.k);
/*     */   }
/*     */   
/*     */   public void onBackPressed()
/*     */   {
/* 291 */     if ((this.D) && (this.o != null) && (this.o.getNativeVideoController() != null)) {
/* 292 */       ((com.bytedance.sdk.openadsdk.core.video.a.a)this.o.getNativeVideoController()).e(null, null);
/* 293 */       this.D = false;
/* 294 */       return;
/*     */     }
/* 296 */     super.onBackPressed();
/*     */   }
/*     */   
/* 299 */   private e E = new e()
/*     */   {
/*     */     public void a(boolean paramAnonymousBoolean) {
/* 302 */       TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this, paramAnonymousBoolean);
/* 303 */       if (!TTVideoLandingPageActivity.this.isFinishing()) {
/*     */         ViewGroup.MarginLayoutParams localMarginLayoutParams;
/* 305 */         if (paramAnonymousBoolean) {
/* 306 */           com.bytedance.sdk.openadsdk.g.s.a(TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this), 8);
/* 307 */           com.bytedance.sdk.openadsdk.g.s.a(TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this), 8);
/*     */           
/* 309 */           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.e(TTVideoLandingPageActivity.this).getLayoutParams();
/* 310 */           TTVideoLandingPageActivity.a(TTVideoLandingPageActivity.this, localMarginLayoutParams.leftMargin);
/* 311 */           TTVideoLandingPageActivity.b(TTVideoLandingPageActivity.this, localMarginLayoutParams.topMargin);
/* 312 */           TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this, localMarginLayoutParams.width);
/* 313 */           TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this, localMarginLayoutParams.height);
/* 314 */           localMarginLayoutParams.width = -1;
/* 315 */           localMarginLayoutParams.height = -1;
/* 316 */           localMarginLayoutParams.topMargin = 0;
/* 317 */           localMarginLayoutParams.leftMargin = 0;
/* 318 */           TTVideoLandingPageActivity.e(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
/*     */         }
/*     */         else {
/* 321 */           com.bytedance.sdk.openadsdk.g.s.a(TTVideoLandingPageActivity.c(TTVideoLandingPageActivity.this), 0);
/* 322 */           com.bytedance.sdk.openadsdk.g.s.a(TTVideoLandingPageActivity.d(TTVideoLandingPageActivity.this), 0);
/* 323 */           localMarginLayoutParams = (ViewGroup.MarginLayoutParams)TTVideoLandingPageActivity.e(TTVideoLandingPageActivity.this).getLayoutParams();
/* 324 */           localMarginLayoutParams.width = TTVideoLandingPageActivity.f(TTVideoLandingPageActivity.this);
/* 325 */           localMarginLayoutParams.height = TTVideoLandingPageActivity.g(TTVideoLandingPageActivity.this);
/* 326 */           localMarginLayoutParams.leftMargin = TTVideoLandingPageActivity.h(TTVideoLandingPageActivity.this);
/* 327 */           localMarginLayoutParams.topMargin = TTVideoLandingPageActivity.i(TTVideoLandingPageActivity.this);
/* 328 */           TTVideoLandingPageActivity.e(TTVideoLandingPageActivity.this).setLayoutParams(localMarginLayoutParams);
/*     */         }
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   protected void onSaveInstanceState(Bundle paramBundle)
/*     */   {
/* 336 */     super.onSaveInstanceState(paramBundle);
/* 337 */     if (this.o != null) {
/* 338 */       paramBundle.putLong("video_play_position", this.o.getNativeVideoController().d());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onResume()
/*     */   {
/* 344 */     super.onResume();
/* 345 */     if (this.j != null) {
/* 346 */       this.j.b();
/*     */     }
/* 348 */     if (this.B != null) {
/* 349 */       this.B.e();
/*     */     }
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
/*     */   protected void onPause()
/*     */   {
/* 365 */     super.onPause();
/* 366 */     if (this.j != null) {
/* 367 */       this.j.c();
/*     */     }
/* 369 */     if (this.o != null) {
/* 370 */       this.o.getNativeVideoController().a();
/*     */     }
/* 372 */     if (this.B != null) {
/* 373 */       this.B.f();
/*     */     }
/* 375 */     if ((this.o != null) && (this.o.getNativeVideoController() != null) && (this.r != null))
/*     */     {
/* 377 */       this.p = Long.valueOf(this.o.getNativeVideoController().d());
/* 378 */       this.r.b(this.o.getNativeVideoController().e());
/* 379 */       this.r.c(this.o.getNativeVideoController().f());
/* 380 */       this.r.a(this.p.longValue());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDestroy()
/*     */   {
/* 386 */     super.onDestroy();
/* 387 */     ab.a(this.f, this.b);
/* 388 */     ab.a(this.b);
/* 389 */     this.b = null;
/*     */     
/* 391 */     if (this.j != null) {
/* 392 */       this.j.d();
/*     */     }
/* 394 */     if ((this.o != null) && (this.o.getNativeVideoController() != null)) {
/* 395 */       this.o.getNativeVideoController().c();
/*     */     }
/* 397 */     this.r = null;
/* 398 */     this.o = null;
/* 399 */     this.q = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\TTVideoLandingPageActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */