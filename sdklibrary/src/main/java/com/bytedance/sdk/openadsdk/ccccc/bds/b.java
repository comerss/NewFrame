/*    */ package com.bytedance.sdk.openadsdk.ccccc.bds;
/*    */ 
/*    */

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.support.annotation.NonNull;

/*    */
/*    */
/*    */
/*    */
/*    */ 
/*    */ public class b
/*    */ {
/*    */   public static void a(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, int paramInt)
/*    */   {
/* 13 */     if (Build.VERSION.SDK_INT >= 23) {
/* 14 */       paramActivity.requestPermissions(paramArrayOfString, paramInt);
/*    */     }
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
/*    */   public static int a(@NonNull Context paramContext, @NonNull String paramString)
/*    */   {
/* 29 */     if (paramString == null) {
/* 30 */       throw new IllegalArgumentException("permission is null");
/*    */     }
/*    */     try {
/* 33 */       return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
/*    */     } catch (Throwable localThrowable) {
/* 35 */       localThrowable.printStackTrace();
/*    */       
/* 37 */       if (Build.VERSION.SDK_INT >= 23)
/* 38 */         return -1;
/*    */     }
/* 40 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\c\Result\Result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */