/*     */ package com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.ccccc.MyDownloadManager;
import com.bytedance.sdk.openadsdk.core.TTAndroidObject;
import com.bytedance.sdk.openadsdk.core.ab;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.WebViewHelper;

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
/*     */   protected TTAndroidObject a;
/*     */   private int m;
/*     */   
/*     */   protected void onCreate(@Nullable Bundle paramBundle)
/*     */   {
/*  69 */     super.onCreate(paramBundle);
/*     */     
/*  71 */
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
/*  89 */     this.c.setWebViewClient(new MineWebViewClient(this.g, this.a, this.k));
/*  90 */     this.c.getSettings().setUserAgentString(WebViewHelper.a(this.c, this.h));
/*     */
/*  92 */     if (Build.VERSION.SDK_INT >= 21) {
/*  93 */       this.c.getSettings().setMixedContentMode(0);
/*     */     }
/*  95 */     this.c.loadUrl(str1);
/*  96 */     this.c.setWebChromeClient(new MineWebChromeClient(this.a));
/*  97 */     this.c.setDownloadListener(new DownloadListener()
/*     */     {
/*     */       public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
/* 100 */         MyDownloadManager.a(g, paramAnonymousString1, str2, str3);
/*     */       }
/*     */     });
/* 103 */     if (this.f != null) {
/* 104 */       this.f.setText(StringUtils.isEmpty(str2) ? getBaseContext().getString(R.string.tt_web_title_default) : str2);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a() {
/* 109 */     this.c = ((SSWebView)findViewById(R.id.browser_webview));
/* 110 */     this.i = ((ViewStub)findViewById(R.id.browser_titlebar_view_stub));
/* 111 */     this.j = ((ViewStub)findViewById(R.id.browser_titlebar_dark_view_stub));
/* 112 */     switch (com.bytedance.sdk.openadsdk.core.h.a().i()) {
/*     */     case 0:
/* 114 */       this.i.setVisibility(View.VISIBLE);
/* 115 */       break;
/*     */     case 1:
/* 117 */       this.j.setVisibility(View.VISIBLE);
/* 118 */       break;
/*     */     }
/*     */
/*     */
/*     */
/* 123 */     this.d = ((ImageView)findViewById(R.id.titlebar_back));
/* 124 */     if (this.d != null) {
/* 125 */       this.d.setOnClickListener(new View.OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/* 128 */           if (c != null) {
/* 129 */             if (c.canGoBack()) {
/* 130 */               c.goBack();
/*     */             } else {
/* 132 */               TTLandingPageActivity.this.finish();
/*     */             }
/*     */           }
/*     */         }
/*     */       });
/*     */     }
/* 138 */     this.e = ((ImageView)findViewById(R.id.titlebar_close));
/* 139 */     if (this.e != null) {
/* 140 */       this.e.setOnClickListener(new View.OnClickListener()
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
/* 152 */     this.a = new TTAndroidObject(this);
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