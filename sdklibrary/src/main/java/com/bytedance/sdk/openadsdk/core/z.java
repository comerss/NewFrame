/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.graphics.Rect;
/*     */ import android.os.PowerManager;
/*     */ import android.view.View;
/*     */ import com.bytedance.sdk.openadsdk.ggg.s;
/*     */ import java.lang.reflect.Method;
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
/*     */ class z
/*     */ {
/*     */   private static boolean a(View paramView, int paramInt)
/*     */   {
/*  32 */     if ((paramView == null) || (paramView.getVisibility() != 0) || 
/*  33 */       (paramView.getParent() == null)) {
/*  34 */       return false;
/*     */     }
/*  36 */     Rect localRect = new Rect();
/*     */     
/*  38 */     if (!paramView.getGlobalVisibleRect(localRect))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     long l1 = localRect.height() * localRect.width();
/*  45 */     long l2 = paramView.getHeight() * paramView.getWidth();
/*     */     
/*  47 */     if (l2 <= 0L) {
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     return 100L * l1 >= paramInt * l2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean a(Context paramContext)
/*     */     throws Exception
/*     */   {
/*  63 */     PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
/*  64 */     Method localMethod = localPowerManager.getClass().getMethod("isScreenOn", new Class[0]);
/*  65 */     boolean bool = ((Boolean)localMethod.invoke(localPowerManager, new Object[0])).booleanValue();
/*  66 */     return bool;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean a(View paramView)
/*     */   {
/*  76 */     if ((paramView != null) && (paramView.isShown())) {
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean b(View paramView, int paramInt)
/*     */   {
/*  84 */     int i = c(paramView, paramInt);
/*  85 */     int j = d(paramView, paramInt);
/*     */     
/*  87 */     return (paramView.getWidth() > i) && (paramView.getHeight() > j);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int c(View paramView, int paramInt)
/*     */   {
/*  97 */     if (paramInt == 3) {
/*  98 */       return (int)(s.a(paramView.getContext().getApplicationContext()) * 0.7D);
/*     */     }
/* 100 */     return 100;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int d(View paramView, int paramInt)
/*     */   {
/* 110 */     if (paramInt == 3) {
/* 111 */       return s.b(paramView.getContext().getApplicationContext()) / 2;
/*     */     }
/* 113 */     return 100;
/*     */   }
/*     */   
/*     */   private static int b(View paramView, int paramInt1, int paramInt2) throws Exception
/*     */   {
/* 118 */     int i = 0;
/* 119 */     if (!a(paramView.getContext())) {
/* 120 */       i = 4;
/* 121 */     } else if (!a(paramView)) {
/* 122 */       i = 1;
/* 123 */     } else if (!b(paramView, paramInt2)) {
/* 124 */       i = 6;
/* 125 */     } else if (!a(paramView, paramInt1)) {
/* 126 */       i = 3;
/*     */     }
/* 128 */     return i;
/*     */   }
/*     */   
/*     */   public static boolean a(View paramView, int paramInt1, int paramInt2) {
/*     */     try {
/* 133 */       return 0 == b(paramView, paramInt1, paramInt2);
/*     */     } catch (Exception localException) {}
/* 135 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\z.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */