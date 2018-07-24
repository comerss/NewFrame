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
/*     */ import android.view.ViewStub;
/*     */ import android.view.Window;
/*     */ import android.webkit.DownloadListener;
/*     */ import android.webkit.WebSettings;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.TextView;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.c.l;
/*     */ import com.bytedance.sdk.openadsdk.core.ab;
/*     */ import com.bytedance.sdk.openadsdk.core.h;
/*     */ import com.bytedance.sdk.openadsdk.core.v;
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
/*     */ public class TTLandingPageActivity
/*     */   extends Activity
/*     */ {
/*  50 */   private static final String b = TTLandingPageActivity.class.getSimpleName();
/*     */   
/*     */   private SSWebView c;
/*     */   
/*     */   private ImageView d;
/*     */   
/*     */   private ImageView e;
/*     */   private TextView f;
/*     */   private Context g;
/*     */   private int h;
/*     */   private ViewStub i;
/*     */   private ViewStub j;
/*     */   private String k;
/*     */   private String l;
/*     */   protected v a;
/*     */   private int m;
/*     */   
/*     */   protected void onCreate(@Nullable Bundle paramBundle)
/*     */   {
/*  69 */     super.onCreate(paramBundle);
/*     */     
/*  71 */     if (h.a().k()) {
/*  72 */       getWindow().addFlags(2621440);
/*     */     }
/*     */     
/*  75 */     setContentView(R.layout.tt_activity_ttlandingpage);
/*  76 */     a();
/*  77 */     this.g = this;
/*  78 */     boolean bool = Build.VERSION.SDK_INT >= 16;
/*  79 */     com.bytedance.sdk.openadsdk.core.q.a(this.g).a(bool).a(this.c);
/*  80 */     Intent localIntent = getIntent();
/*  81 */     this.h = localIntent.getIntExtra("sdk_version", 1);
/*  82 */     this.k = localIntent.getStringExtra("adid");
/*  83 */     this.l = localIntent.getStringExtra("log_extra");
/*  84 */     this.m = localIntent.getIntExtra("source", -1);
/*  85 */     String str1 = localIntent.getStringExtra("url");
/*  86 */     final String str2 = localIntent.getStringExtra("web_title");
/*  87 */     final String str3 = localIntent.getStringExtra("icon_url");
/*  88 */     b();
/*  89 */     this.c.setWebViewClient(new b(this.g, this.a, this.k));
/*  90 */     this.c.getSettings().setUserAgentString(j.a(this.c, this.h));
/*     */     
/*  92 */     if (Build.VERSION.SDK_INT >= 21) {
/*  93 */       this.c.getSettings().setMixedContentMode(0);
/*     */     }
/*  95 */     this.c.loadUrl(str1);
/*  96 */     this.c.setWebChromeClient(new a(this.a));
/*  97 */     this.c.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
/* 100 */         l.a(TTLandingPageActivity.a(TTLandingPageActivity.this), paramAnonymousString1, str2, str3);
/*     */       }
/*     */     });
/* 103 */     if (this.f != null) {
/* 104 */       this.f.setText(com.bytedance.sdk.openadsdk.g.q.a(str2) ? getBaseContext().getString(R.string.tt_web_title_default) : str2);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a() {
/* 109 */     this.c = ((SSWebView)findViewById(R.id.browser_webview));
/* 110 */     this.i = ((ViewStub)findViewById(R.id.browser_titlebar_view_stub));
/* 111 */     this.j = ((ViewStub)findViewById(R.id.browser_titlebar_dark_view_stub));
/* 112 */     switch (h.a().i()) {
/*     */     case 0: 
/* 114 */       this.i.setVisibility(0);
/* 115 */       break;
/*     */     case 1: 
/* 117 */       this.j.setVisibility(0);
/* 118 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 123 */     this.d = ((ImageView)findViewById(R.id.titlebar_back));
/* 124 */     if (this.d != null) {
/* 125 */       this.d.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/* 128 */           if (TTLandingPageActivity.b(TTLandingPageActivity.this) != null) {
/* 129 */             if (TTLandingPageActivity.b(TTLandingPageActivity.this).canGoBack()) {
/* 130 */               TTLandingPageActivity.b(TTLandingPageActivity.this).goBack();
/*     */             } else {
/* 132 */               TTLandingPageActivity.this.finish();
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 138 */     this.e = ((ImageView)findViewById(R.id.titlebar_close));
/* 139 */     if (this.e != null) {
/* 140 */       this.e.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/* 143 */           TTLandingPageActivity.this.finish();
/*     */         }
/*     */       });
/*     */     }
/* 147 */     this.f = ((TextView)findViewById(R.id.titlebar_title));
/*     */   }
/*     */   
/*     */   private void b()
/*     */   {
/* 152 */     this.a = new v(this);
/* 153 */     this.a.a(this.c)
/* 154 */       .a(this.k)
/* 155 */       .b(this.l)
/* 156 */       .a(this.m);
/*     */   }
/*     */   
/*     */   protected void onResume()
/*     */   {
/* 161 */     super.onResume();
/* 162 */     if (this.a != null) {
/* 163 */       this.a.b();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onPause()
/*     */   {
/* 169 */     super.onPause();
/* 170 */     if (this.a != null) {
/* 171 */       this.a.c();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDestroy()
/*     */   {
/* 177 */     super.onDestroy();
/* 178 */     ab.a(this.g, this.c);
/* 179 */     ab.a(this.c);
/* 180 */     this.c = null;
/*     */     
/* 182 */     if (this.a != null) {
/* 183 */       this.a.d();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\TTLandingPageActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */