/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.c;
/*    */ 
/*    */ import android.content.ContentUris;
/*    */ import android.content.Context;
/*    */ import android.content.Intent;
/*    */ import android.net.Uri;
/*    */ import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadController;
/*    */ import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class z
/*    */   implements TTGlobalAppDownloadController
/*    */ {
/*    */   private static volatile TTGlobalAppDownloadController a;
/*    */   private Context b;
/*    */   
/*    */   private z(Context paramContext)
/*    */   {
/* 23 */     this.b = paramContext.getApplicationContext();
/*    */   }
/*    */   
/*    */   public static TTGlobalAppDownloadController a(Context paramContext) {
/* 27 */     if (a == null) {
/* 28 */       synchronized (TTGlobalAppDownloadController.class) {
/* 29 */         if (a == null) {
/* 30 */           a = new z(paramContext);
/*    */         }
/*    */       }
/*    */     }
/* 34 */     return a;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void changeDownloadStatus(int paramInt, long paramLong)
/*    */   {
/* 48 */     if (paramLong < 0L) {
/* 49 */       return;
/*    */     }
/* 51 */     int i = f.a(paramInt);
/* 52 */     f.a(this.b, i, paramLong);
/*    */   }
/*    */   
/*    */   public void removeDownloadTask(long paramLong)
/*    */   {
/* 57 */     if (paramLong < 0L) {
/* 58 */       return;
/*    */     }
/*    */     try {
/* 61 */       g.c(this.b, paramLong);
/* 62 */       Uri localUri = ContentUris.withAppendedId(m.a.a, paramLong);
/* 63 */       Intent localIntent = new Intent(this.b, TTDelegateActivity.class);
/* 64 */       localIntent.setData(localUri);
/* 65 */       localIntent.addFlags(268435456);
/* 66 */       this.b.startActivity(localIntent);
/*    */     }
/*    */     catch (Exception localException) {}
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\z.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */