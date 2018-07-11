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
/*     */   implements o
/*     */ {
/*  15 */   private NotificationCompat.Builder a = null;
/*     */   
/*     */   public r(Context paramContext) {
/*  18 */     this.a = new NotificationCompat.Builder(paramContext);
/*     */   }
/*     */   
/*     */   public o a(PendingIntent paramPendingIntent)
/*     */   {
/*  23 */     if (this.a != null) {
/*  24 */       this.a.setContentIntent(paramPendingIntent);
/*     */     }
/*  26 */     return this;
/*     */   }
/*     */   
/*     */   public o a(boolean paramBoolean)
/*     */   {
/*  31 */     if (this.a != null) {
/*  32 */       this.a.setOngoing(paramBoolean);
/*     */     }
/*  34 */     return this;
/*     */   }
/*     */   
/*     */   public o b(boolean paramBoolean)
/*     */   {
/*  39 */     if (this.a != null) {
/*  40 */       this.a.setAutoCancel(paramBoolean);
/*     */     }
/*  42 */     return this;
/*     */   }
/*     */   
/*     */   public o b(PendingIntent paramPendingIntent)
/*     */   {
/*  47 */     if (this.a != null) {
/*  48 */       this.a.setDeleteIntent(paramPendingIntent);
/*     */     }
/*  50 */     return this;
/*     */   }
/*     */   
/*     */   public o a(long paramLong)
/*     */   {
/*  55 */     if (this.a != null) {
/*  56 */       this.a.setWhen(paramLong);
/*     */     }
/*  58 */     return this;
/*     */   }
/*     */   
/*     */   public o a(int paramInt)
/*     */   {
/*  63 */     if (this.a != null) {
/*  64 */       this.a.setSmallIcon(paramInt);
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
/* 111 */     if (this.a != null) {
/* 112 */       return this.a.build();
/*     */     }
/* 114 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\r.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */