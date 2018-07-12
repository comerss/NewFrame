/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.os.Environment;
/*     */ import com.bytedance.sdk.openadsdk.core.h;
/*     */ import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.e;
/*     */
/*     */ import com.bytedance.sdk.openadsdk.ggg.q;
/*     */ import java.io.File;
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
/*     */ public class l
/*     */ {
/*     */   public static long a(Context paramContext, String paramString1, String paramString2, String paramString3)
/*     */   {
/*  58 */     if (paramContext == null) {
/*  59 */       return -1L;
/*     */     }
/*     */     try
/*     */     {
/*  63 */       f localf = f.aaaaaa(paramContext);
/*  64 */       if (localf == null)
/*  65 */         return -1L;
/*  66 */       Uri localUri = Uri.parse(paramString1);
/*  67 */       String str = e.a(localUri.getLastPathSegment());
/*  68 */       if (q.a(str)) {
/*  69 */         if (!q.a(paramString2)) {
/*  70 */           str = paramString2;
/*     */         } else {
/*  72 */           str = "default.apk";
/*     */         }
/*     */       }
/*  75 */       if (q.a(paramString2)) {
/*  76 */         paramString2 = str;
/*     */       }
/*  78 */       f.c localc = new f.c(localUri);
/*  79 */       if (!str.endsWith(".apk")) {
/*  80 */         str = str + ".apk";
/*     */       }
/*  82 */       localc.a("application/vnd.android.package-archive");
/*  83 */       localc.a(paramString2);
/*  84 */       if (paramString3 != null) {
/*  85 */         localc.b(paramString3);
/*     */       }
/*  87 */       File localFile = paramContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
/*  88 */       if ((localFile != null) && (!localFile.exists()) && 
/*  89 */         (!localFile.mkdirs())) {
/*  90 */         return -1L;
/*     */       }
/*     */       
/*  93 */       localc.a(paramContext, Environment.DIRECTORY_DOWNLOADS, str);
/*  94 */       if (h.a().j()) {
/*  95 */         localc.a(1);
/*     */       } else {
/*  97 */         localc.a(2);
/*     */       }
/*  99 */       localc.a(false);
/* 100 */       return localf.aaaaaa(localc);
/*     */     } catch (Throwable localThrowable) {
/* 102 */       LogUtils.b("MyDownloadManager", "add download task error:" + localThrowable); }
/* 103 */     return -1L;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ccccc\l.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */