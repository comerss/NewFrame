/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import com.bytedance.sdk.openadsdk.TTAdManager;
/*     */ import com.bytedance.sdk.openadsdk.TTAdNative;
/*     */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
/*     */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
/*     */ import com.bytedance.sdk.openadsdk.c.z;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class t
/*     */   implements TTAdManager
/*     */ {
/*     */   public t a(String paramString)
/*     */   {
/*  25 */     h.a().a(paramString);
/*  26 */     return this;
/*     */   }
/*     */   
/*     */   public t b(String paramString)
/*     */   {
/*  31 */     h.a().b(paramString);
/*  32 */     return this;
/*     */   }
/*     */   
/*     */   public t a(boolean paramBoolean)
/*     */   {
/*  37 */     h.a().a(paramBoolean);
/*  38 */     return this;
/*     */   }
/*     */   
/*     */   public t a(int paramInt)
/*     */   {
/*  43 */     h.a().b(paramInt);
/*  44 */     return this;
/*     */   }
/*     */   
/*     */   public t b(int paramInt)
/*     */   {
/*  49 */     h.a().a(paramInt);
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public t c(String paramString)
/*     */   {
/*  55 */     h.a().c(paramString);
/*  56 */     return this;
/*     */   }
/*     */   
/*     */   public t d(String paramString)
/*     */   {
/*  61 */     h.a().d(paramString);
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdManager setTitleBarTheme(int paramInt)
/*     */   {
/*  67 */     h.a().c(paramInt);
/*  68 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdManager setAllowShowNotifiFromSDK(boolean paramBoolean)
/*     */   {
/*  73 */     h.a().b(paramBoolean);
/*  74 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdManager openDebugMode()
/*     */   {
/*  79 */     m.b();
/*  80 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean paramBoolean)
/*     */   {
/*  85 */     h.a().c(paramBoolean);
/*  86 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdManager setGlobalAppDownloadListener(TTGlobalAppDownloadListener paramTTGlobalAppDownloadListener)
/*     */   {
/*  91 */     h.a().a(paramTTGlobalAppDownloadListener);
/*  92 */     return this;
/*     */   }
/*     */   
/*     */   public TTGlobalAppDownloadController getGlobalAppDownloadController(Context paramContext)
/*     */   {
/*  97 */     return z.a(paramContext);
/*     */   }
/*     */   
/*     */   public TTAdManager setDirectDownloadNetworkType(int... paramVarArgs)
/*     */   {
/* 102 */     h.a().a(paramVarArgs);
/* 103 */     return this;
/*     */   }
/*     */   
/*     */   public TTAdNative createAdNative(Context paramContext)
/*     */   {
/* 108 */     h.a().m();
/*     */     
/* 110 */     return new u(paramContext);
/*     */   }
/*     */   
/*     */   public void requestPermissionIfNecessary(Context paramContext)
/*     */   {
/* 115 */     Intent localIntent = new Intent(paramContext, TTDelegateActivity.class);
/* 116 */     localIntent.addFlags(268435456);
/* 117 */     localIntent.putExtra("type", 2);
/* 118 */     if (paramContext != null) {
/* 119 */       paramContext.startActivity(localIntent);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\t.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */