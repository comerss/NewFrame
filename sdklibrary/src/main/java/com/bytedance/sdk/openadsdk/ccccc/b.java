/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */ import android.os.Build;
/*     */
/*     */ import android.os.Environment;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
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
/*     */ public class b
/*     */ {
/*  87 */   public static final String a = "/" + Environment.DIRECTORY_DOWNLOADS;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static final String b;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static
/*     */   {
/* 100 */     StringBuilder localStringBuilder = new StringBuilder();
/*     */     
/* 102 */     int i = !TextUtils.isEmpty(Build.VERSION.RELEASE) ? 1 : 0;
/* 103 */     int j = !TextUtils.isEmpty(Build.ID) ? 1 : 0;
/*     */     
/* 105 */     int k = ("REL".equals(Build.VERSION.CODENAME)) && (!TextUtils.isEmpty(Build.MODEL)) ? 1 : 0;
/*     */     
/* 107 */     localStringBuilder.append("SsAndroidDownloadManager");
/* 108 */     if (i != 0) {
/* 109 */       localStringBuilder.append("/").append(Build.VERSION.RELEASE);
/*     */     }
/* 111 */     localStringBuilder.append(" (Linux; U; Android");
/* 112 */     if (i != 0) {
/* 113 */       localStringBuilder.append(" ").append(Build.VERSION.RELEASE);
/*     */     }
/* 115 */     if ((k != 0) || (j != 0)) {
/* 116 */       localStringBuilder.append(";");
/* 117 */       if (k != 0) {
/* 118 */         localStringBuilder.append(" ").append(Build.MODEL);
/*     */       }
/* 120 */       if (j != 0) {
/* 121 */         localStringBuilder.append(" Build/").append(Build.ID);
/*     */       }
/*     */     }
/* 124 */     localStringBuilder.append(")");
/*     */     
/* 126 */     b = localStringBuilder.toString();
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
/* 193 */   public static final boolean c = Log.isLoggable("SsDownloadManager", 2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 199 */   public static final boolean d = c;
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */