/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.service;
/*     */ 
/*     */ import android.app.Service;
/*     */ import android.content.ContentUris;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.IBinder;
/*     */ import android.text.TextUtils;
/*     */ import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
/*     */ import com.bytedance.sdk.openadsdk.c.a.b;
/*     */ import com.bytedance.sdk.openadsdk.c.f;
/*     */ import com.bytedance.sdk.openadsdk.c.g;
/*     */ import com.bytedance.sdk.openadsdk.c.i;
/*     */ import com.bytedance.sdk.openadsdk.c.m.a;
/*     */ import com.bytedance.sdk.openadsdk.c.n;
/*     */ import com.bytedance.sdk.openadsdk.c.s;
/*     */ import com.bytedance.sdk.openadsdk.c.t;
/*     */ import com.bytedance.sdk.openadsdk.c.w;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TTDownloadHandlerService
/*     */   extends Service
/*     */ {
/*  32 */   w a = null;
/*     */   
/*     */   public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
/*     */   {
/*  36 */     super.onStartCommand(paramIntent, paramInt1, paramInt2);
/*  37 */     if (m.a()) {
/*  38 */       m.b("TTDownloadHandlerService", "onStartCommand");
/*     */     }
/*  40 */     a(this, paramIntent);
/*  41 */     stopSelf();
/*  42 */     return 2;
/*     */   }
/*     */   
/*     */   public void a(Context paramContext, Intent paramIntent) {
/*  46 */     if (this.a == null) {
/*  47 */       this.a = t.a(paramContext);
/*     */     }
/*     */     
/*  50 */     String str1 = paramIntent.getAction();
/*  51 */     if (TextUtils.isEmpty(str1)) {
/*  52 */       return;
/*     */     }
/*  54 */     if (str1.equals("android.ss.intent.action.DOWNLOAD_WAKEUP")) {
/*  55 */       TTDownloadService.a(paramContext);
/*  56 */     } else if ((str1.equals("android.ss.intent.action.DOWNLOAD_OPEN")) || 
/*  57 */       (str1.equals("android.ss.intent.action.DOWNLOAD_DELETE")) || 
/*  58 */       (str1.equals("android.ss.intent.action.DOWNLOAD_HIDE"))) {
/*  59 */       b(paramContext, paramIntent); } else { long l;
/*  60 */       Object localObject1; Object localObject2; int j; if (str1.equals("android.ss.intent.action.DOWNLOAD_CLICK")) {
/*  61 */         l = ContentUris.parseId(paramIntent.getData());
/*  62 */         String str2 = paramIntent.getStringExtra("extra_notification_tag");
/*     */         
/*     */ 
/*  65 */         localObject1 = ContentUris.withAppendedId(m.a.a, l);
/*  66 */         localObject2 = i.a(paramContext).a((Uri)localObject1, null, null, null, null);
/*     */         try {
/*  68 */           if (((Cursor)localObject2).moveToFirst()) {
/*  69 */             j = g.a((Cursor)localObject2, "status");
/*     */           } else {
/*  71 */             m.d("TTDownloadHandlerService", "Missing details for download " + l);
/*  72 */             return;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */           try
/*     */           {
/*  79 */             if (localObject2 != null) {
/*  80 */               ((Cursor)localObject2).close();
/*     */             }
/*     */           }
/*     */           catch (Exception localException2) {}
/*     */           
/*     */ 
/*  86 */           f.a(paramContext, 
/*  87 */             f.a(j), l);
/*     */         }
/*     */         catch (Exception localException3)
/*     */         {
/*  76 */           return;
/*     */         } finally {
/*     */           try {
/*  79 */             if (localObject2 != null) {
/*  80 */               ((Cursor)localObject2).close();
/*     */             }
/*     */           }
/*     */           catch (Exception localException5) {}
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*  88 */         if (m.a.c(j)) {
/*  89 */           g.a(paramContext).a(paramContext, l);
/*  90 */           g.a(paramContext).a(str2);
/*     */         }
/*  92 */       } else if (str1.equals("android.ss.intent.action.DOWNLOAD_COMPLETE")) {
/*  93 */         l = paramIntent.getLongExtra("extra_download_id", -1L);
/*  94 */         int i = paramIntent.getIntExtra("status", -1);
/*  95 */         j = paramIntent.getIntExtra("extra_download_visibility", 1);
/*     */         
/*  97 */         if (l > -1L) {
/*  98 */           s.a(paramContext, l, 268435456);
/*  99 */           localObject1 = n.a();
/* 100 */           if ((localObject1 != null) && (m.a.a(i))) {
/* 101 */             localObject2 = paramIntent.getStringExtra("extra_app_package");
/* 102 */             ((b)localObject1).a(l, 1, (String)localObject2);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void b(Context paramContext, Intent paramIntent)
/*     */   {
/* 112 */     String str = paramIntent.getAction();
/*     */     try {
/* 114 */       if ("android.ss.intent.action.DOWNLOAD_DELETE".equals(str)) {
/* 115 */         Uri localUri = paramIntent.getData();
/* 116 */         Intent localIntent = new Intent(paramContext, TTDelegateActivity.class);
/* 117 */         localIntent.setData(localUri);
/* 118 */         localIntent.addFlags(268435456);
/* 119 */         paramContext.startActivity(localIntent);
/* 120 */         long l2 = ContentUris.parseId(paramIntent.getData());
/* 121 */         g.a(paramContext).a(paramContext, l2); } else { long l1;
/* 122 */         if ("android.ss.intent.action.DOWNLOAD_OPEN".equals(str)) {
/* 123 */           l1 = ContentUris.parseId(paramIntent.getData());
/* 124 */           s.a(paramContext, l1, 268435456);
/* 125 */           g.a(paramContext).a(paramContext, l1);
/* 126 */         } else if ("android.ss.intent.action.DOWNLOAD_HIDE".equals(str)) {
/* 127 */           l1 = ContentUris.parseId(paramIntent.getData());
/* 128 */           g.a(paramContext).a(paramContext, l1);
/*     */         }
/*     */       }
/* 131 */     } catch (Exception localException) { localException.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public IBinder onBind(Intent paramIntent)
/*     */   {
/* 137 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\service\TTDownloadHandlerService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */