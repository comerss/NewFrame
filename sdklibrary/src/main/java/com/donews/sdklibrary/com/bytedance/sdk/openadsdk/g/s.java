/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*     */ 
/*     */ import android.app.KeyguardManager;
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.Rect;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.PowerManager;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import android.util.DisplayMetrics;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import android.view.ViewGroup.MarginLayoutParams;
/*     */ import android.widget.TextView;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class s
/*     */ {
/*     */   public static float a(Context paramContext, float paramFloat)
/*     */   {
/*  30 */     float f = paramContext.getResources().getDisplayMetrics().density;
/*  31 */     return paramFloat * f + 0.5F;
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
/*     */   public static final int a(Context paramContext)
/*     */   {
/*  45 */     if (paramContext == null) {
/*  46 */       return 0;
/*     */     }
/*  48 */     DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
/*  49 */     return localDisplayMetrics == null ? 0 : localDisplayMetrics.widthPixels;
/*     */   }
/*     */   
/*     */   public static final int b(Context paramContext) {
/*  53 */     if (paramContext == null) {
/*  54 */       return 0;
/*     */     }
/*  56 */     DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
/*  57 */     return localDisplayMetrics == null ? 0 : localDisplayMetrics.heightPixels;
/*     */   }
/*     */   
/*     */   public static final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  61 */     Rect localRect = new Rect();
/*  62 */     paramView.getHitRect(localRect);
/*     */     
/*  64 */     localRect.top -= paramInt1;
/*  65 */     localRect.bottom += paramInt2;
/*  66 */     localRect.left -= paramInt3;
/*  67 */     localRect.right += paramInt4;
/*     */     
/*  69 */     g localg = new g(localRect, paramView);
/*  70 */     ((View)paramView.getParent()).setTouchDelegate(localg);
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static int[] a(View paramView) {
/*  75 */     int[] arrayOfInt = null;
/*  76 */     if ((paramView != null) && (paramView.getVisibility() == 0)) {
/*  77 */       arrayOfInt = new int[2];
/*  78 */       paramView.getLocationOnScreen(arrayOfInt);
/*     */     }
/*  80 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   @Nullable
/*     */   public static int[] b(View paramView) {
/*  85 */     int[] arrayOfInt = null;
/*  86 */     if (paramView != null) {
/*  87 */       arrayOfInt = new int[2];
/*  88 */       arrayOfInt[0] = paramView.getWidth();
/*  89 */       arrayOfInt[1] = paramView.getHeight();
/*     */     }
/*  91 */     return arrayOfInt;
/*     */   }
/*     */   
/*  94 */   private static boolean a(int paramInt) { return (paramInt == 0) || (paramInt == 8) || (paramInt == 4); }
/*     */   
/*     */   public static final void a(View paramView, int paramInt)
/*     */   {
/*  98 */     if ((paramView == null) || (paramView.getVisibility() == paramInt) || (!a(paramInt))) {
/*  99 */       return;
/*     */     }
/* 101 */     paramView.setVisibility(paramInt);
/*     */   }
/*     */   
/*     */   public static final boolean c(View paramView) {
/* 105 */     if (paramView == null) {
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     return paramView.getVisibility() == 0;
/*     */   }
/*     */   
/*     */   public static void a(TextView paramTextView, CharSequence paramCharSequence) {
/* 113 */     if ((paramTextView == null) && (TextUtils.isEmpty(paramCharSequence))) {
/* 114 */       return;
/*     */     }
/*     */     
/* 117 */     paramTextView.setText(paramCharSequence);
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
/*     */   public static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*     */   {
/* 134 */     if (paramView == null)
/* 135 */       return;
/* 136 */     ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
/* 137 */     if (localLayoutParams == null)
/* 138 */       return;
/* 139 */     if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
/* 140 */       a(paramView, (ViewGroup.MarginLayoutParams)localLayoutParams, paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void a(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 145 */     if ((paramView == null) || (paramMarginLayoutParams == null) || ((paramMarginLayoutParams.leftMargin == paramInt1) && (paramMarginLayoutParams.topMargin == paramInt2) && (paramMarginLayoutParams.rightMargin == paramInt3) && (paramMarginLayoutParams.bottomMargin == paramInt4)))
/*     */     {
/*     */ 
/* 148 */       return; }
/* 149 */     if (paramInt1 != -3)
/* 150 */       paramMarginLayoutParams.leftMargin = paramInt1;
/* 151 */     if (paramInt2 != -3)
/* 152 */       paramMarginLayoutParams.topMargin = paramInt2;
/* 153 */     if (paramInt3 != -3)
/* 154 */       paramMarginLayoutParams.rightMargin = paramInt3;
/* 155 */     if (paramInt4 != -3)
/* 156 */       paramMarginLayoutParams.bottomMargin = paramInt4;
/* 157 */     paramView.setLayoutParams(paramMarginLayoutParams);
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean a(Context paramContext, View paramView, int paramInt)
/*     */   {
/* 163 */     if (paramView == null) {
/* 164 */       m.a("adView is null.");
/* 165 */       return false;
/*     */     }
/*     */     
/* 168 */     if (paramView.getParent() == null) {
/* 169 */       m.a("adView has no parent.");
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     if (paramView.getWindowVisibility() != 0) {
/* 174 */       m.a("adView window is not set to VISIBLE.");
/* 175 */       return false;
/*     */     }
/*     */     
/* 178 */     if (paramView.getVisibility() != 0) {
/* 179 */       m.a("adView is not set to VISIBLE.");
/* 180 */       return false;
/*     */     }
/*     */     boolean bool;
/* 183 */     if ((paramView.getMeasuredWidth() > 0) && (paramView.getMeasuredHeight() > 0)) {
/* 184 */       if ((Build.VERSION.SDK_INT >= 11) && (paramView.getAlpha() < 0.9F)) {
/* 185 */         m.a("adView is transparent.");
/* 186 */         return false;
/*     */       }
/*     */       
/* 189 */       int i = paramView.getWidth();
/* 190 */       int j = paramView.getHeight();
/* 191 */       int[] arrayOfInt = new int[2];
/*     */       try {
/* 193 */         paramView.getLocationOnScreen(arrayOfInt);
/*     */       }
/*     */       catch (Exception localException) {
/* 196 */         m.a("Cannot get location on screen.");
/* 197 */         return false;
/*     */       }
/*     */       
/* 200 */       DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
/* 201 */       if ((arrayOfInt[0] >= 0) && (localDisplayMetrics.widthPixels - arrayOfInt[0] >= i)) {
/* 202 */         i = (int)(j * (100.0D - paramInt) / 100.0D);
/* 203 */         if ((arrayOfInt[1] < 0) && (Math.abs(arrayOfInt[1]) > i)) {
/* 204 */           m.a("adView is not visible from the top.");
/* 205 */           return false;
/*     */         }
/*     */         
/* 208 */         if (j + arrayOfInt[1] - localDisplayMetrics.heightPixels > i) {
/* 209 */           m.a("adView is not visible from the bottom.");
/* 210 */           return false;
/*     */         }
/*     */         
/* 213 */         m.a("adView is visible.");
/* 214 */         return c(paramContext);
/*     */       }
/*     */       
/* 217 */       m.a("adView is not fully on screen horizontally.");
/* 218 */       bool = false;
/*     */     }
/*     */     else {
/* 221 */       m.a(
/* 222 */         "adView has invisible dimensions (w=" + paramView.getMeasuredWidth() + ", h=" + paramView.getMeasuredHeight());
/* 223 */       bool = false;
/*     */     }
/*     */     
/* 226 */     return bool;
/*     */   }
/*     */   
/*     */   public static boolean c(Context paramContext)
/*     */   {
/*     */     try {
/* 232 */       PowerManager localPowerManager = (PowerManager)paramContext.getSystemService("power");
/*     */       
/* 234 */       if (!localPowerManager.isScreenOn()) {
/* 235 */         return false;
/*     */       }
/* 237 */       KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
/*     */       
/*     */ 
/* 240 */       if (localKeyguardManager.inKeyguardRestrictedInputMode()) {
/* 241 */         return false;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {
/* 245 */       m.a("adView exception:" + localException.getMessage());
/* 246 */       localException.printStackTrace();
/* 247 */       return false;
/*     */     }
/* 249 */     return true;
/*     */   }
/*     */   
/*     */   public static Bitmap d(View paramView)
/*     */   {
/* 254 */     Bitmap localBitmap = null;
/* 255 */     if (paramView == null) {
/* 256 */       return localBitmap;
/*     */     }
/* 258 */     paramView.destroyDrawingCache();
/* 259 */     paramView.setDrawingCacheEnabled(true);
/* 260 */     paramView.buildDrawingCache();
/* 261 */     localBitmap = paramView.getDrawingCache();
/* 262 */     return localBitmap;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\s.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */