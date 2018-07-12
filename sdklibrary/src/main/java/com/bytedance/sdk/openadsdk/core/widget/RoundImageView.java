/*     */ package com.bytedance.sdk.openadsdk.core.widget;
/*     */ 
/*     */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

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
/*     */ public class RoundImageView
/*     */   extends ImageView
/*     */ {
/*  23 */   private int a = 0;
/*  24 */   private int b = 0;
/*     */   
/*     */   public RoundImageView(Context paramContext) {
/*  27 */     super(paramContext);
/*     */   }
/*     */   
/*     */   public RoundImageView(Context paramContext, AttributeSet paramAttributeSet) {
/*  31 */     super(paramContext, paramAttributeSet);
/*     */   }
/*     */   
/*     */   public RoundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
/*  35 */     super(paramContext, paramAttributeSet, paramInt);
/*     */   }
/*     */   
/*     */   protected void onDraw(Canvas paramCanvas)
/*     */   {
/*  40 */     Drawable localDrawable = getDrawable();
/*  41 */     if (localDrawable == null) {
/*  42 */       return;
/*     */     }
/*  44 */     if ((getWidth() == 0) || (getHeight() == 0)) {
/*  45 */       return;
/*     */     }
/*  47 */     measure(0, 0);
/*  48 */     if (localDrawable.getClass() == NinePatchDrawable.class)
/*  49 */       return;
/*  50 */     Bitmap localBitmap1 = ((BitmapDrawable)localDrawable).getBitmap();
/*  51 */     if (localBitmap1 == null) {
/*  52 */       return;
/*     */     }
/*  54 */     Bitmap localBitmap2 = localBitmap1.copy(Bitmap.Config.ARGB_8888, true);
/*  55 */     if (this.a == 0) {
/*  56 */       this.a = getWidth();
/*     */     }
/*     */     
/*  59 */     if (this.b == 0) {
/*  60 */       this.b = getHeight();
/*     */     }
/*  62 */     int i = (this.a < this.b ? this.a : this.b) / 2;
/*     */     
/*  64 */     Bitmap localBitmap3 = a(localBitmap2, i);
/*  65 */     paramCanvas.drawBitmap(localBitmap3, this.a / 2 - i, this.b / 2 - i, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Bitmap a(Bitmap paramBitmap, int paramInt)
/*     */   {
/*  76 */     int i = paramInt * 2;
/*     */     
/*     */ 
/*  79 */     int j = paramBitmap.getWidth();
/*  80 */     int k = paramBitmap.getHeight();
/*     */     int n;
/*     */     int m;
/*     */     int i1;
    Bitmap localBitmap2;
    Bitmap localBitmap1;
/*  84 */     int i2; if (k > j) {
/*  85 */       m = n = j;
/*  86 */       i1 = 0;
/*  87 */       i2 = (k - j) / 2;
/*     */       
/*  89 */       localBitmap2 = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
/*     */     }
/*  91 */     else if (k < j) {
/*  92 */       m = n = k;
/*  93 */       i1 = (j - k) / 2;
/*  94 */       i2 = 0;
/*  95 */       localBitmap2 = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
/*     */     }
/*     */     else {
/*  98 */       localBitmap2 = paramBitmap;
/*     */     }
/*     */     
/* 101 */     if ((localBitmap2.getWidth() != i) || 
/* 102 */       (localBitmap2.getHeight() != i)) {
/* 103 */       localBitmap1 = Bitmap.createScaledBitmap(localBitmap2, i, i, true);
/*     */     }
/*     */     else
/*     */     {
/* 107 */       localBitmap1 = localBitmap2;
/*     */     }
/* 109 */     Bitmap localBitmap3 = Bitmap.createBitmap(localBitmap1.getWidth(), localBitmap1
/* 110 */       .getHeight(), Bitmap.Config.ARGB_8888);
/* 111 */     Canvas localCanvas = new Canvas(localBitmap3);
/*     */     
/* 113 */     Paint localPaint = new Paint();
/*     */     
/* 115 */     Rect localRect = new Rect(0, 0, localBitmap1.getWidth(), localBitmap1.getHeight());
/*     */     
/* 117 */     localPaint.setAntiAlias(true);
/* 118 */     localPaint.setFilterBitmap(true);
/* 119 */     localPaint.setDither(true);
/* 120 */     localCanvas.drawARGB(0, 0, 0, 0);
/* 121 */     localCanvas.drawCircle(localBitmap1.getWidth() / 2, localBitmap1
/* 122 */       .getHeight() / 2, localBitmap1.getWidth() / 2, localPaint);
/*     */     
/* 124 */     localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
/* 125 */     localCanvas.drawBitmap(localBitmap1, localRect, localRect, localPaint);
/* 126 */
/* 129 */     return localBitmap3;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\widget\RoundImageView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */