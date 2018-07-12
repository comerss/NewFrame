/*    */ package com.bytedance.sdk.openadsdk.core.video.d;
/*    */ 
/*    */

import android.os.Build;
import android.view.View;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/* 11 */   private static int a = Build.VERSION.SDK_INT;
/*    */   
/*    */   public static int a(long paramLong1, long paramLong2) {
/* 14 */     int i = 0;
/* 15 */     if (paramLong2 > 0L) {
/* 16 */       i = (int)(paramLong1 * 1.0D / paramLong2 * 100.0D);
/*    */     }
/* 18 */     i = Math.min(Math.max(0, i), 100);
/* 19 */     return i;
/*    */   }
/*    */   
/*    */   public static String a(long paramLong) {
/* 23 */     StringBuilder localStringBuilder = new StringBuilder();
/*    */     
/* 25 */     long l1 = paramLong / 60000L;
/* 26 */     long l2 = paramLong % 3600000L % 60000L / 1000L;
/*    */     
/* 28 */     if (l1 >= 10L) {
/* 29 */       localStringBuilder.append(l1);
/* 30 */     } else if (l1 > 0L) {
/* 31 */       localStringBuilder.append(0);
/* 32 */       localStringBuilder.append(l1);
/*    */     } else {
/* 34 */       localStringBuilder.append(0);
/* 35 */       localStringBuilder.append(0);
/*    */     }
/* 37 */     localStringBuilder.append(":");
/*    */     
/* 39 */     if (l2 >= 10L) {
/* 40 */       localStringBuilder.append(l2);
/* 41 */     } else if (l2 > 0L) {
/* 42 */       localStringBuilder.append(0);
/* 43 */       localStringBuilder.append(l2);
/*    */     } else {
/* 45 */       localStringBuilder.append(0);
/* 46 */       localStringBuilder.append(0);
/*    */     }
/*    */     
/* 49 */     return localStringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static void a(View paramView, boolean paramBoolean) {
/* 53 */     if (paramView == null) {
/* 54 */       return;
/*    */     }
/* 56 */     if (paramBoolean) {
/* 57 */       paramView.setSystemUiVisibility(0);
/*    */     }
/* 59 */     else if (a >= 19) {
/* 60 */       paramView.setSystemUiVisibility(3846);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/* 66 */     else if (a >= 16) {
/* 67 */       paramView.setSystemUiVisibility(5);
/*    */     }
/*    */     else {
/* 70 */       paramView.setSystemUiVisibility(1);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\LocationUtils\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */