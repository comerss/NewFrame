/*    */ package com.bytedance.sdk.openadsdk.ccccc.bds;
/*    */ 
/*    */

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.bytedance.sdk.openadsdk.ggg.LogUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PermisionHelper
/*    */ {
/* 22 */   private static final String a = PermisionHelper.class.getSimpleName();
/*    */   
/*    */   public static boolean a(Context paramContext, String paramString) {
/* 25 */     if (Build.VERSION.SDK_INT >= 19) {
/* 26 */       return b(paramContext, paramString);
/*    */     }
/* 28 */     return c(paramContext, paramString);
/*    */   }
/*    */   
/*    */   @TargetApi(19)
/*    */   private static boolean b(Context paramContext, String paramString)
/*    */   {
/* 34 */     boolean bool = true;
/*    */     try {
/* 36 */       if ("android.permission.ACCESS_COARSE_LOCATION".equals(paramString)) {
/* 37 */         paramString = "COARSE_LOCATION";
/* 38 */       } else if ("android.permission.ACCESS_FINE_LOCATION".equals(paramString)) {
/* 39 */         paramString = "FINE_LOCATION";
/*    */       } else {
/* 41 */         paramString = paramString.replaceFirst("android.permission.", "");
/*    */       }
/* 43 */       AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
/* 44 */       PackageManager localPackageManager = paramContext.getPackageManager();
/*    */       
/* 46 */       PackageInfo localPackageInfo = localPackageManager.getPackageInfo(paramContext.getPackageName(), 1);
/* 47 */       Class localClass = AppOpsManager.class;
/* 48 */       Field localField = localClass.getField("OP_" + paramString);
/* 49 */       Method localMethod = localClass.getDeclaredMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
/* 50 */       localMethod.setAccessible(true);
/* 51 */       int i = ((Integer)localMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(localField.getInt(localAppOpsManager)), Integer.valueOf(localPackageInfo.applicationInfo.uid), localPackageInfo.packageName })).intValue();
/*    */       
/* 53 */       bool = (i != 2) && (i != 1) && (i != 4);
/*    */     } catch (Exception localException) {
/* 55 */       LogUtils.e(a, "权限检查出错时默认返回有权限，异常代码：" + localException);
/*    */     }
/* 57 */     return bool;
/*    */   }
/*    */   
/*    */   private static boolean c(Context paramContext, String paramString) {
/* 61 */     PackageManager localPackageManager = paramContext.getPackageManager();
/* 62 */     return PackageManager.PERMISSION_GRANTED == localPackageManager
/* 63 */       .checkPermission(paramString, paramContext.getPackageName());
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\VideoManager\TTAdDislikeImpl\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */