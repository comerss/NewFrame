/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

/*     */
/*     */
/*     */

/*     */
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class r
/*     */   implements NotificationListener
/*     */ {
    /*  15 */   private NotificationCompat.Builder mBuilder = null;
/*     */   
/*     */   public r(Context paramContext) {
/*  18 */     this.mBuilder = new NotificationCompat.Builder(paramContext);
/*     */   }
/*     */   
/*     */   public NotificationListener a(PendingIntent paramPendingIntent)
/*     */   {
/*  23 */     if (this.mBuilder != null) {
/*  24 */       this.mBuilder.setContentIntent(paramPendingIntent);
/*     */     }
/*  26 */     return this;
/*     */   }
/*     */   
/*     */   public NotificationListener a(boolean paramBoolean)
/*     */   {
/*  31 */     if (this.mBuilder != null) {
/*  32 */       this.mBuilder.setOngoing(paramBoolean);
/*     */     }
/*  34 */     return this;
/*     */   }
/*     */   
/*     */   public NotificationListener b(boolean paramBoolean)
/*     */   {
/*  39 */     if (this.mBuilder != null) {
/*  40 */       this.mBuilder.setAutoCancel(paramBoolean);
/*     */     }
/*  42 */     return this;
/*     */   }
/*     */   
/*     */   public NotificationListener b(PendingIntent paramPendingIntent)
/*     */   {
/*  47 */     if (this.mBuilder != null) {
/*  48 */       this.mBuilder.setDeleteIntent(paramPendingIntent);
/*     */     }
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public NotificationListener a(long paramLong)
/*     */   {
/*  55 */     if (this.mBuilder != null) {
/*  56 */       this.mBuilder.setWhen(paramLong);
/*     */     }
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public NotificationListener a(int paramInt)
/*     */   {
/*  63 */     if (this.mBuilder != null) {
/*  64 */       this.mBuilder.setSmallIcon(paramInt);
/*     */     }
/*  66 */     return this;
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
/*     */   public Notification a()
/*     */   {
/* 111 */     if (this.mBuilder != null) {
/* 112 */       return this.mBuilder.build();
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\r.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */