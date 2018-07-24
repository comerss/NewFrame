/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.graphics.Bitmap;
/*     */ import android.os.Build;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Handler;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import android.view.ViewParent;
/*     */ import android.webkit.WebView;
/*     */ import android.widget.ImageView;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import java.util.HashSet;
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
/*     */ public class ab
/*     */ {
/*  37 */   private static final boolean d = (VERSION.SDK_INT >= 16) &&
/*  38 */     (r.c());
/*  39 */   private static final boolean e = a();
/*     */   
/*  41 */   private static int f = -1;
/*  42 */   private static int g = -1;
/*     */   
/*     */ 
/*  45 */   private static int h = -1;
/*     */   
/*     */ 
/*     */ 
/*  49 */   static Handler a = null;
/*     */   static final HashSet<String> b;
/*     */   
/*  52 */   static { HashSet localHashSet = new HashSet();
/*  53 */     localHashSet.add("HUAWEI C8812");
/*  54 */     localHashSet.add("HUAWEI C8812E");
/*  55 */     localHashSet.add("HUAWEI C8825D");
/*  56 */     localHashSet.add("HUAWEI U8825D");
/*  57 */     localHashSet.add("HUAWEI C8950D");
/*  58 */     localHashSet.add("HUAWEI U8950D");
/*  59 */     b = localHashSet;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  64 */     localHashSet = new HashSet();
/*  65 */     localHashSet.add("ZTE V955");
/*  66 */     localHashSet.add("ZTE N881E");
/*  67 */     localHashSet.add("ZTE N881F");
/*  68 */     localHashSet.add("ZTE N880G");
/*  69 */     localHashSet.add("ZTE N880F");
/*  70 */     localHashSet.add("ZTE V889F");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  76 */     c = localHashSet;
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
/*     */   static final HashSet<String> c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void a(Context paramContext, WebView paramWebView)
/*     */   {
/* 185 */     if ((paramContext == null) || (paramWebView == null)) {
/* 186 */       return;
/*     */     }
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
/* 199 */     if ((paramContext instanceof Activity)) {
/* 200 */       Activity localActivity = (Activity)paramContext;
/* 201 */       if (localActivity.isFinishing()) {
/*     */         try {
/* 203 */           paramWebView.loadUrl("about:blank");
/* 204 */           if (h > 0) {
/* 205 */             View localView1 = paramWebView.getRootView();
/* 206 */             if ((localView1 instanceof ViewGroup)) {
/* 207 */               View localView2 = ((ViewGroup)localView1).getChildAt(0);
/* 208 */               localView2.setDrawingCacheEnabled(true);
/* 209 */               Bitmap localBitmap = Bitmap.createBitmap(localView2.getDrawingCache());
/* 210 */               localView2.setDrawingCacheEnabled(false);
/* 211 */               ImageView localImageView = new ImageView(localActivity);
/* 212 */               localImageView.setImageBitmap(localBitmap);
/* 213 */               localImageView.setVisibility(0);
/* 214 */               ((ViewGroup)localView1).addView(localImageView, new LayoutParams(-1, -1));
/*     */             }
/*     */           }
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean a()
/*     */   {
/* 225 */     if (d)
/* 226 */       return true;
/* 227 */     if ((VERSION.SDK_INT == 16) && ("ZTE N5".equals(Build.MODEL))) {
/* 228 */       return true;
/*     */     }
/* 230 */     return false;
/*     */   }
/*     */   
/*     */   public static void a(WebView paramWebView) {
/* 234 */     if (paramWebView == null) {
/* 235 */       return;
/*     */     }
/* 237 */     paramWebView.setWebChromeClient(null);
/* 238 */     paramWebView.setWebViewClient(null);
/* 239 */     ViewParent localViewParent = paramWebView.getParent();
/* 240 */     if ((localViewParent instanceof ViewGroup)) {
/* 241 */       ((ViewGroup)localViewParent).removeView(paramWebView);
/*     */       try {
/* 243 */         paramWebView.destroy();
/*     */       }
/*     */       catch (Throwable localThrowable) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\ab.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */