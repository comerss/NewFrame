/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.net.Uri;
/*     */ import android.support.annotation.Nullable;
/*     */ import com.bytedance.sdk.openadsdk.TTFeedAd;
/*     */ import com.bytedance.sdk.openadsdk.activity.TTLandingPageActivity;
/*     */ import com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity;
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.d;
/*     */
/*     */ import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.ADViewLayout;
/*     */ import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.PhoneUtils;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
/*     */ import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class aa
/*     */ {
/*  26 */   private static boolean a = false;
/*     */   
/*  28 */   public static void a(boolean paramBoolean) { a = paramBoolean; }
/*     */   
/*     */   public static boolean a(Context paramContext, NativeAdData paramh, int paramInt, @Nullable com.bytedance.sdk.openadsdk.core.video.a.c paramc, @Nullable TTFeedAd paramTTFeedAd, String paramString)
/*     */   {
/*  32 */     if ((paramContext == null) || (paramh == null) || (paramInt == -1)) {
/*  33 */       return false;
/*     */     }
/*     */     
/*  36 */     d locald = paramh.n();
/*  37 */     String str; Object localObject; Uri localUri; if (locald != null) {
/*  38 */       str = locald.a();
/*  39 */       if (!StringUtils.isEmpty(str)) {
/*  40 */         localObject = locald.a();
/*  41 */         localUri = Uri.parse((String)localObject);
/*  42 */         Intent localIntent = new Intent("android.intent.action.VIEW");
/*  43 */         localIntent.setData(localUri);
/*  44 */         if (ToolUtils.a(paramContext, localIntent)) {
/*  45 */           if (!(paramContext instanceof Activity)) {
/*  46 */             localIntent.addFlags(268435456);
/*     */           }
/*  48 */           paramContext.startActivity(localIntent);
/*  49 */           AdEvent.h(paramContext, paramh, paramString, "open_url_app");
/*  50 */           return true;
/*     */         }
/*  52 */         str = locald.b();
/*     */       }
/*     */       else {
/*  55 */         str = locald.b();
/*     */       }
/*  57 */       AdEvent.h(paramContext, paramh, paramString, "open_fallback_url");
/*     */     }
/*     */     else {
/*  60 */       str = paramh.e();
/*     */     }
/*  62 */     if (!StringUtils.isEmpty(str)) {
/*  63 */       if (paramh.c() == 2) {
/*  64 */         if (!PhoneUtils.isAccess(str)) {
/*  65 */           return false;
/*     */         }
/*  67 */         localObject = new Intent("android.intent.action.VIEW");
/*     */         try {
/*  69 */           localUri = Uri.parse(str);
/*  70 */           ((Intent)localObject).setData(localUri);
/*     */         } catch (Exception localException) {
/*  72 */           return false;
/*     */         }
/*  74 */         if (!(paramContext instanceof Activity)) {
/*  75 */           ((Intent)localObject).addFlags(268435456);
/*     */         }
/*  77 */         paramContext.startActivity((Intent)localObject);
/*     */       } else {
/*  79 */         localObject = a(paramContext, str, paramh, paramInt, paramc, paramTTFeedAd);
/*  80 */         paramContext.startActivity((Intent)localObject);
/*  81 */         a = false;
/*     */       }
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   private static Intent a(Context paramContext, String paramString, NativeAdData paramh, int paramInt, @Nullable com.bytedance.sdk.openadsdk.core.video.a.c paramc, @Nullable TTFeedAd paramTTFeedAd)
/*     */   {
/*  90 */     Intent localIntent = null;
/*  91 */     if ((paramh.p() == 5) && (!a)) {
/*  92 */       localIntent = new Intent(paramContext, TTVideoLandingPageActivity.class);
/*     */     } else {
/*  94 */       localIntent = new Intent(paramContext, TTLandingPageActivity.class);
/*     */     }
/*  96 */     localIntent.putExtra("url", paramString);
/*  97 */     localIntent.putExtra("web_title", paramh.j());
/*  98 */     localIntent.putExtra("sdk_version", 1);
/*  99 */     localIntent.putExtra("adid", paramh.l());
/* 100 */     localIntent.putExtra("log_extra", paramh.o());
/* 101 */     String str = paramh.d() == null ? null : paramh.d().a();
/* 102 */     localIntent.putExtra("icon_url", str);
/* 103 */     localIntent.putExtra("source", paramInt);
/* 104 */     if (!(paramContext instanceof Activity)) {
/* 105 */       localIntent.addFlags(268435456);
/*     */     }
/* 107 */     if (paramh.p() == 5) {
/* 108 */       localIntent.putExtra("imageMode", 5);
/* 109 */       if (paramc != null) {
/* 110 */         localIntent.putExtra("video_play_position", paramc.d());
/* 111 */         s.a().f();
/* 112 */         s.a().a(paramh);
/* 113 */         s.a().a(paramc);
/* 114 */       } else if ((paramTTFeedAd != null) && (paramTTFeedAd.getAdView() != null)) {
/* 115 */         com.bytedance.sdk.openadsdk.core.video.a.c localc = ((ADViewLayout)paramTTFeedAd.getAdView()).getNativeVideoController();
/* 116 */         if (localc != null) {
/* 117 */           localIntent.putExtra("video_play_position", localc.d());
/*     */         }
/*     */         
/* 120 */         s.a().f();
/* 121 */         s.a().a(paramh);
/* 122 */         s.a().a(localc);
/*     */       }
/*     */     }
/* 125 */     return localIntent;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\aa.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */