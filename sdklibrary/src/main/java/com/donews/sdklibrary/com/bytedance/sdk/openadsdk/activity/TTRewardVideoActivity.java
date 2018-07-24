/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.res.Configuration;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.PorterDuff.Mode;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import android.graphics.drawable.LayerDrawable;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.Window;
/*     */ import android.webkit.DownloadListener;
/*     */ import android.webkit.WebSettings;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.FrameLayout.LayoutParams;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.RatingBar;
/*     */ import android.widget.RelativeLayout;
/*     */ import android.widget.RelativeLayout.LayoutParams;
/*     */ import android.widget.TextView;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.bytedance.sdk.openadsdk.R.color;
/*     */ import com.bytedance.sdk.openadsdk.R.drawable;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener;
/*     */ import com.bytedance.sdk.openadsdk.c.l;
/*     */ import com.bytedance.sdk.openadsdk.c.x;
/*     */ import com.bytedance.sdk.openadsdk.c.x.b;
/*     */ import com.bytedance.sdk.openadsdk.core.a.e;
/*     */ import com.bytedance.sdk.openadsdk.core.ab;
/*     */ import com.bytedance.sdk.openadsdk.core.d.g;
/*     */ import com.bytedance.sdk.openadsdk.core.d.k;
/*     */ import com.bytedance.sdk.openadsdk.core.o;
/*     */ import com.bytedance.sdk.openadsdk.core.o.b;
/*     */ import com.bytedance.sdk.openadsdk.core.p.c;
/*     */ import com.bytedance.sdk.openadsdk.core.q;
/*     */ import com.bytedance.sdk.openadsdk.core.r;
/*     */ import com.bytedance.sdk.openadsdk.core.v;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.c.a;
/*     */ import com.bytedance.sdk.openadsdk.core.video.c.d;
/*     */ import com.bytedance.sdk.openadsdk.g.n.a;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
/*     */ import java.util.UUID;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TTRewardVideoActivity
/*     */   extends Activity
/*     */   implements t.a
/*     */ {
/*     */   private Context a;
/*     */   private SSWebView b;
/*     */   private ImageView c;
/*     */   private ImageView d;
/*     */   private ImageView e;
/*     */   private TextView f;
/*     */   private TextView g;
/*     */   private TextView h;
/*     */   private TextView i;
/*     */   private FrameLayout j;
/*     */   private RelativeLayout k;
/*     */   private RatingBar l;
/*     */   private TextView m;
/*     */   private TextView n;
/*     */   private com.bytedance.sdk.openadsdk.core.d.h o;
/*     */   private TTRewardVideoAd.RewardAdInteractionListener p;
/*     */   private x q;
/*     */   private String r;
/*     */   private String s;
/*     */   private v t;
/*     */   private int u;
/*     */   private int v;
/*     */   private String w;
/*     */   private com.bytedance.sdk.openadsdk.core.video.a.c x;
/*  88 */   private boolean y = false;
/*     */   
/*     */ 
/*  91 */   private t z = new t(Looper.getMainLooper(), this);
/*     */   private int A;
/*     */   private AQuery2 B;
/*     */   private o C;
/*     */   private e D;
/*  96 */   private boolean E = true;
/*     */   
/*     */   private long F;
/*     */   private String G;
/*     */   private int H;
/* 101 */   private int I = 4;
/* 102 */   private int J = 6870;
/* 103 */   private int K = 5;
/*     */   private boolean L;
/*     */   
/*     */   protected void onCreate(@Nullable Bundle paramBundle) {
/* 107 */     super.onCreate(paramBundle);
/* 108 */     if (com.bytedance.sdk.openadsdk.core.h.a().k()) {
/* 109 */       getWindow().addFlags(2621440);
/*     */     }
/*     */     
/* 112 */     requestWindowFeature(1);
/* 113 */     getWindow().addFlags(1024);
/* 114 */     setContentView(R.layout.tt_activity_rewardvideo);
/* 115 */     this.a = this;
/* 116 */     if ((paramBundle != null) && (paramBundle.getLong("video_current") > 0L)) {
/* 117 */       this.F = paramBundle.getLong("video_current", 0L);
/*     */     }
/* 119 */     e();
/* 120 */     b();
/* 121 */     d();
/* 122 */     c();
/* 123 */     f();
/*     */   }
/*     */   
/*     */   private void b() {
/* 127 */     this.j = ((FrameLayout)findViewById(R.id.video_reward_container));
/* 128 */     this.b = ((SSWebView)findViewById(R.id.reward_browser_webview));
/* 129 */     this.c = ((ImageView)findViewById(R.id.video_ad_close));
/* 130 */     this.d = ((ImageView)findViewById(R.id.video_ad_mute));
/* 131 */     this.h = ((TextView)findViewById(R.id.reward_ad_countdown));
/* 132 */     this.i = ((TextView)findViewById(R.id.reward_ad_download));
/* 133 */     this.k = ((RelativeLayout)findViewById(R.id.video_reward_bar));
/* 134 */     this.e = ((ImageView)findViewById(R.id.reward_ad_icon));
/* 135 */     this.f = ((TextView)findViewById(R.id.reward_ad_appname));
/* 136 */     this.g = ((TextView)findViewById(R.id.tt_comment_vertical));
/* 137 */     this.l = ((RatingBar)findViewById(R.id.rb_score));
/* 138 */     this.m = ((TextView)findViewById(R.id.tv_comment_num));
/* 139 */     this.n = ((TextView)findViewById(R.id.tv_comment_text));
/* 140 */     if (!this.E) {
/* 141 */       this.k.setVisibility(4);
/* 142 */       int i1 = (int)com.bytedance.sdk.openadsdk.g.s.a(this.a, 24.0F);
/* 143 */       FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.d.getLayoutParams();
/* 144 */       localLayoutParams.gravity = 85;
/* 145 */       localLayoutParams.bottomMargin = i1;
/* 146 */       this.d.setLayoutParams(localLayoutParams);
/*     */     }
/*     */   }
/*     */   
/*     */   private void c() {
/* 151 */     if (this.K == 15)
/*     */     {
/* 153 */       this.n.setVisibility(8);
/* 154 */       this.g.setVisibility(0);
/* 155 */       this.m.setVisibility(8);
/* 156 */       this.f.setMaxWidth((int)com.bytedance.sdk.openadsdk.g.s.a(this, 120.0F));
/* 157 */       RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.l.getLayoutParams();
/* 158 */       localLayoutParams.leftMargin = ((int)com.bytedance.sdk.openadsdk.g.s.a(this, 89.0F));
/* 159 */       localLayoutParams.topMargin = ((int)com.bytedance.sdk.openadsdk.g.s.a(this, 2.0F));
/* 160 */       this.l.setLayoutParams(localLayoutParams);
/*     */     }
/*     */   }
/*     */   
/*     */   private void d() {
/* 165 */     this.B = new AQuery2(this.a);
/* 166 */     this.C = com.bytedance.sdk.openadsdk.core.n.c();
/* 167 */     this.o = com.bytedance.sdk.openadsdk.core.s.a().c();
/* 168 */     this.p = com.bytedance.sdk.openadsdk.core.s.a().d();
/* 169 */     this.q = com.bytedance.sdk.openadsdk.core.s.a().e();
/* 170 */     com.bytedance.sdk.openadsdk.core.s.a().f();
/* 171 */     if (this.o == null) {
/* 172 */       return;
/*     */     }
/* 174 */     this.K = this.o.p();
/* 175 */     if (this.o.m() != null) {
/* 176 */       this.I = this.o.m().d();
/* 177 */       this.J = this.o.m().e();
/*     */     }
/* 179 */     this.r = this.o.l();
/* 180 */     this.s = this.o.o();
/* 181 */     this.A = ((int)this.o.a().b());
/* 182 */     this.u = 1;
/* 183 */     g();
/* 184 */     this.w = (this.o.a() != null ? this.o.a().e() : null);
/* 185 */     if (this.K == 15) {
/* 186 */       this.w += "&orientation=portrait";
/*     */     }
/* 188 */     if ((this.o.d() != null) && (!TextUtils.isEmpty(this.o.d().a()))) {
/* 189 */       ((AQuery)this.B.id(this.e)).image(this.o.d().a());
/*     */     } else {
/* 191 */       this.e.setImageResource(R.drawable.tt_ad_logo_small);
/*     */     }
/* 193 */     if ((this.K == 15) && 
/* 194 */       (this.o.m() != null) && 
/* 195 */       (!TextUtils.isEmpty(this.o.m().b()))) {
/* 196 */       this.f.setText(this.o.m().b());
/*     */     } else {
/* 198 */       this.f.setText(this.o.j());
/*     */     }
/* 200 */     if (this.o.c() != 4) {
/* 201 */       this.i.setVisibility(4);
/*     */     }
/* 203 */     LayerDrawable localLayerDrawable = (LayerDrawable)this.l.getProgressDrawable();
/* 204 */     if (localLayerDrawable.getDrawable(2) != null) {
/* 205 */       localLayerDrawable.getDrawable(2).setColorFilter(getResources().getColor(R.color.tt_rating_star), PorterDuff.Mode.SRC_ATOP);
/*     */     }
/* 207 */     this.l.setRating(this.I);
/* 208 */     String str1 = getResources().getString(R.string.tt_comment_num);
/* 209 */     String str2 = this.J + "";
/* 210 */     String str3 = String.format(str1, new Object[] { str2 });
/* 211 */     this.m.setText(str3);
/* 212 */     this.g.setText(str3);
/* 213 */     this.v = 1;
/* 214 */     boolean bool = Build.VERSION.SDK_INT >= 16;
/* 215 */     q.a(this.a).a(bool).a(this.b);
/* 216 */     this.b.setWebViewClient(new b(this.a, this.t, this.r));
/* 217 */     this.b.getSettings().setUserAgentString(com.bytedance.sdk.openadsdk.g.j.a(this.b, this.v));
/*     */     
/* 219 */     if (Build.VERSION.SDK_INT >= 21) {
/* 220 */       this.b.getSettings().setMixedContentMode(0);
/*     */     }
/* 222 */     this.b.loadUrl(this.w);
/* 223 */     this.b.setWebChromeClient(new a(this.t));
/* 224 */     this.b.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
/* 227 */         String str = null;
/* 228 */         if (TTRewardVideoActivity.a(TTRewardVideoActivity.this) != null) {
/* 229 */           str = TTRewardVideoActivity.a(TTRewardVideoActivity.this).d() == null ? null : TTRewardVideoActivity.a(TTRewardVideoActivity.this).d().a();
/*     */         }
/* 231 */         l.a(TTRewardVideoActivity.b(TTRewardVideoActivity.this), paramAnonymousString1, null, str);
/* 232 */         TTRewardVideoActivity.this.a();
/*     */       }
/* 234 */     });
/* 235 */     this.c.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/* 238 */         if (TTRewardVideoActivity.c(TTRewardVideoActivity.this) != null) {
/* 239 */           TTRewardVideoActivity.c(TTRewardVideoActivity.this).onAdClose();
/*     */         }
/* 241 */         com.bytedance.sdk.openadsdk.d.c.g(TTRewardVideoActivity.b(TTRewardVideoActivity.this), TTRewardVideoActivity.a(TTRewardVideoActivity.this), "embeded_ad", "click_close");
/* 242 */         TTRewardVideoActivity.this.finish();
/*     */       }
/* 244 */     });
/* 245 */     this.d.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/* 248 */         int i = TTRewardVideoActivity.d(TTRewardVideoActivity.this) ? R.drawable.unmute : R.drawable.mute;
/* 249 */         TTRewardVideoActivity.e(TTRewardVideoActivity.this).setImageResource(i);
/* 250 */         TTRewardVideoActivity.a(TTRewardVideoActivity.this, !TTRewardVideoActivity.d(TTRewardVideoActivity.this));
/* 251 */         TTRewardVideoActivity.f(TTRewardVideoActivity.this).b(TTRewardVideoActivity.d(TTRewardVideoActivity.this));
/*     */       }
/* 253 */     });
/* 254 */     a(this.F);
/*     */   }
/*     */   
/*     */   private void e() {
/* 258 */     Intent localIntent = getIntent();
/* 259 */     if (localIntent == null) {
/* 260 */       return;
/*     */     }
/* 262 */     this.M = localIntent.getStringExtra("reward_name");
/* 263 */     this.N = localIntent.getIntExtra("reward_amount", 0);
/* 264 */     this.O = localIntent.getStringExtra("media_extra");
/* 265 */     this.P = localIntent.getStringExtra("user_id");
/* 266 */     this.E = localIntent.getBooleanExtra("show_download_bar", true);
/* 267 */     this.G = localIntent.getStringExtra("video_cache_url");
/* 268 */     this.H = localIntent.getIntExtra("orientation", 2);
/*     */   }
/*     */   
/*     */ 
/*     */   private void f()
/*     */   {
/* 274 */     if ((this.o == null) || (this.o.c() != 4)) {
/* 275 */       return;
/*     */     }
/*     */     
/* 278 */     this.D = new e(this, this.o, "embeded_ad", 1)
/*     */     {
/*     */       public void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
/*     */       {
/* 282 */         if (TTRewardVideoActivity.c(TTRewardVideoActivity.this) != null) {
/* 283 */           TTRewardVideoActivity.c(TTRewardVideoActivity.this).onAdVideoBarClick();
/*     */         }
/* 285 */         if (paramAnonymousView.getId() == R.id.video_reward_bar) {
/* 286 */           TTRewardVideoActivity.b(TTRewardVideoActivity.this, true);
/*     */         }
/*     */       }
/* 289 */     };
/* 290 */     this.D.a(this.q);
/* 291 */     this.q.a(new x.b()
/*     */     {
/*     */       public void a() {
/* 294 */         String str = TTRewardVideoActivity.g(TTRewardVideoActivity.this) ? "click_start_play_bar" : "click_start_play";
/* 295 */         com.bytedance.sdk.openadsdk.d.c.a(TTRewardVideoActivity.b(TTRewardVideoActivity.this), TTRewardVideoActivity.a(TTRewardVideoActivity.this), "embeded_ad", str);
/*     */       }
/*     */       
/*     */       public void b()
/*     */       {
/* 300 */         com.bytedance.sdk.openadsdk.d.c.b(TTRewardVideoActivity.b(TTRewardVideoActivity.this), TTRewardVideoActivity.a(TTRewardVideoActivity.this), "embeded_ad", "click_play_pause");
/*     */       }
/*     */       
/*     */       public void c()
/*     */       {
/* 305 */         com.bytedance.sdk.openadsdk.d.c.c(TTRewardVideoActivity.b(TTRewardVideoActivity.this), TTRewardVideoActivity.a(TTRewardVideoActivity.this), "embeded_ad", "click_play_continue");
/*     */       }
/*     */       
/*     */       public void d()
/*     */       {
/* 310 */         com.bytedance.sdk.openadsdk.d.c.h(TTRewardVideoActivity.b(TTRewardVideoActivity.this), TTRewardVideoActivity.a(TTRewardVideoActivity.this), "embeded_ad", "click_play_open");
/*     */       }
/* 312 */     });
/* 313 */     this.i.setOnClickListener(this.D);
/* 314 */     this.i.setOnTouchListener(this.D);
/* 315 */     this.k.setOnClickListener(this.D);
/* 316 */     this.k.setOnTouchListener(this.D);
/*     */   }
/*     */   
/*     */   private void g()
/*     */   {
/* 321 */     this.t = new v(this.a);
/* 322 */     this.t.a(this.b)
/* 323 */       .a(this.r)
/* 324 */       .b(this.s)
/* 325 */       .a(this.u);
/* 326 */     this.t.a(false);
/*     */   }
/*     */   
/*     */   private boolean a(long paramLong) {
/* 330 */     if (this.x == null) {
/* 331 */       this.x = new com.bytedance.sdk.openadsdk.core.video.b.a(this.a, this.j, this.o);
/*     */     }
/* 333 */     this.x.a(new c.a()
/*     */     {
/*     */       public void a(long paramAnonymousLong, int paramAnonymousInt) {
/* 336 */         if (TTRewardVideoActivity.c(TTRewardVideoActivity.this) != null) {
/* 337 */           TTRewardVideoActivity.c(TTRewardVideoActivity.this).onVideoComplete();
/*     */         }
/* 339 */         TTRewardVideoActivity.h(TTRewardVideoActivity.this).setVisibility(0);
/* 340 */         TTRewardVideoActivity.i(TTRewardVideoActivity.this).setVisibility(0);
/* 341 */         TTRewardVideoActivity.a(TTRewardVideoActivity.this, (int)(System.currentTimeMillis() / 1000L));
/* 342 */         TTRewardVideoActivity.j(TTRewardVideoActivity.this);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void b(long paramAnonymousLong, int paramAnonymousInt) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public void a() {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */       public void a(long paramAnonymousLong1, long paramAnonymousLong2)
/*     */       {
/* 362 */         TTRewardVideoActivity.b(TTRewardVideoActivity.this, (int)(TTRewardVideoActivity.a(TTRewardVideoActivity.this).a().b() - paramAnonymousLong1 / 1000L));
/* 363 */         if (TTRewardVideoActivity.k(TTRewardVideoActivity.this) >= 0) {
/* 364 */           com.bytedance.sdk.openadsdk.g.s.a(TTRewardVideoActivity.l(TTRewardVideoActivity.this), 0);
/* 365 */           TTRewardVideoActivity.l(TTRewardVideoActivity.this).setText(String.valueOf(TTRewardVideoActivity.k(TTRewardVideoActivity.this)));
/*     */         }
/*     */       }
/* 368 */     });
/* 369 */     String str = TextUtils.isEmpty(this.G) ? this.o.a().d() : this.G;
/* 370 */     boolean bool = this.x.a(str, this.o.l(), this.j
/* 371 */       .getWidth(), this.j.getHeight(), null, this.o.o(), paramLong, this.y);
/* 372 */     if (bool)
/*     */     {
/* 374 */       com.bytedance.sdk.openadsdk.d.c.a(this.a, this.o, "embeded_ad");
/* 375 */       if (this.p != null) {
/* 376 */         this.p.onAdShow();
/*     */       }
/* 378 */       this.Q = ((int)(System.currentTimeMillis() / 1000L));
/*     */     }
/* 380 */     return bool;
/*     */   }
/*     */   
/*     */   private void h() {
/* 384 */     JSONObject localJSONObject = i();
/* 385 */     this.C.a(localJSONObject, new o.b()
/*     */     {
/*     */       public void a(int paramAnonymousInt, String paramAnonymousString) {
/* 388 */         if (TTRewardVideoActivity.c(TTRewardVideoActivity.this) != null) {
/* 389 */           TTRewardVideoActivity.c(TTRewardVideoActivity.this).onRewardVerify(false, 0, "");
/*     */         }
/*     */       }
/*     */       
/*     */       public void a(p.c paramAnonymousc)
/*     */       {
/* 395 */         int i = paramAnonymousc.c.a();
/* 396 */         String str = paramAnonymousc.c.b();
/* 397 */         if (TTRewardVideoActivity.c(TTRewardVideoActivity.this) != null) {
/* 398 */           TTRewardVideoActivity.c(TTRewardVideoActivity.this).onRewardVerify(paramAnonymousc.b, i, str);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   private String M;
/*     */   
/*     */   private int N;
/*     */   
/*     */   private String O;
/*     */   private String P;
/*     */   private int Q;
/*     */   private int R;
/*     */   private JSONObject i()
/*     */   {
/* 415 */     JSONObject localJSONObject = new JSONObject();
/* 416 */     float f1 = com.bytedance.sdk.openadsdk.g.b.a(this.a) == null ? 0.0F : com.bytedance.sdk.openadsdk.g.b.a(this.a).a;
/* 417 */     float f2 = com.bytedance.sdk.openadsdk.g.b.a(this.a) == null ? 0.0F : com.bytedance.sdk.openadsdk.g.b.a(this.a).b;
/* 418 */     int i1 = (int)this.x.f();
/*     */     try {
/* 420 */       localJSONObject.put("reward_name", this.M);
/* 421 */       localJSONObject.put("reward_amount", this.N);
/* 422 */       localJSONObject.put("network", com.bytedance.sdk.openadsdk.g.n.b(this.a).a());
/* 423 */       localJSONObject.put("latitude", f1);
/* 424 */       localJSONObject.put("longitude", f2);
/* 425 */       localJSONObject.put("sdk_version", "1.9.0");
/* 426 */       localJSONObject.put("user_agent", r.a);
/* 427 */       localJSONObject.put("extra", new JSONObject(this.s));
/* 428 */       localJSONObject.put("media_extra", this.O);
/* 429 */       localJSONObject.put("video_duration", this.o.a().b());
/* 430 */       localJSONObject.put("play_start_ts", this.Q);
/* 431 */       localJSONObject.put("play_end_ts", this.R);
/* 432 */       localJSONObject.put("duration", i1);
/* 433 */       localJSONObject.put("user_id", this.P);
/* 434 */       localJSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
/*     */     }
/*     */     catch (Throwable localThrowable) {
/* 437 */       return null;
/*     */     }
/* 439 */     return localJSONObject;
/*     */   }
/*     */   
/*     */   private boolean j() {
/* 443 */     if ((this.x != null) && (this.x.h() != null) && 
/* 444 */       (this.x.h().f())) {
/* 445 */       return true;
/*     */     }
/*     */     
/* 448 */     return false;
/*     */   }
/*     */   
/*     */   private boolean k() {
/* 452 */     if ((this.x != null) && (this.x.h() != null) && 
/* 453 */       (this.x.h().g())) {
/* 454 */       return true;
/*     */     }
/*     */     
/* 457 */     return false;
/*     */   }
/*     */   
/*     */   protected void onSaveInstanceState(Bundle paramBundle)
/*     */   {
/* 462 */     super.onSaveInstanceState(paramBundle);
/* 463 */     paramBundle.putLong("video_current", this.x.d());
/*     */   }
/*     */   
/*     */   public void onConfigurationChanged(Configuration paramConfiguration)
/*     */   {
/* 468 */     super.onConfigurationChanged(paramConfiguration);
/*     */   }
/*     */   
/*     */   protected void onResume()
/*     */   {
/* 473 */     if (this.K == 15) {
/* 474 */       setRequestedOrientation(1);
/*     */     }
/* 476 */     super.onResume();
/* 477 */     if (k()) {
/* 478 */       this.x.b();
/*     */     }
/* 480 */     if (this.t != null) {
/* 481 */       this.t.b();
/*     */     }
/* 483 */     if (this.q != null) {
/* 484 */       this.q.e();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onBackPressed() {}
/*     */   
/*     */ 
/*     */   protected void onPause()
/*     */   {
/* 495 */     super.onPause();
/* 496 */     if (j()) {
/* 497 */       this.x.a();
/*     */     }
/* 499 */     if (this.t != null) {
/* 500 */       this.t.c();
/*     */     }
/* 502 */     if (this.q != null) {
/* 503 */       this.q.f();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDestroy()
/*     */   {
/* 509 */     super.onDestroy();
/* 510 */     ab.a(this.a, this.b);
/* 511 */     ab.a(this.b);
/* 512 */     this.b = null;
/* 513 */     if (this.t != null) {
/* 514 */       this.t.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(Message paramMessage)
/*     */   {
/* 520 */     if (paramMessage.what == 1) {
/* 521 */       if (!j()) {
/* 522 */         this.z.sendEmptyMessageDelayed(1, 1000L);
/* 523 */         return;
/*     */       }
/* 525 */       this.A -= 1;
/* 526 */       if (this.A == 0) {
/* 527 */         this.z.removeCallbacksAndMessages(null);
/* 528 */       } else if (this.A > 0) {
/* 529 */         this.h.setText(String.valueOf(this.A));
/* 530 */         this.z.sendEmptyMessageDelayed(1, 1000L);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void a() {
/* 536 */     if (this.p != null) {
/* 537 */       this.p.onAdVideoBarClick();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\TTRewardVideoActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */