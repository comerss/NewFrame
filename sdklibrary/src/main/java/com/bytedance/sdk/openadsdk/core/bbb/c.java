/*    */ package com.bytedance.sdk.openadsdk.core.bbb;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.Bitmap;
/*    */ import android.support.annotation.NonNull;
/*    */ import android.widget.FrameLayout;
/*    */
/*    */ import android.widget.ImageView;
/*    */
/*    */ import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class c
/*    */   extends FrameLayout
/*    */ {
/*    */   private ImageView a;
/*    */   private Context b;
/*    */   private NativeAdData c;
/*    */   
/*    */   public c(@NonNull Context paramContext)
/*    */   {
/* 24 */     super(paramContext);
/* 25 */     this.b = paramContext;
/* 26 */     c();
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
/*    */ 
/*    */ 
/*    */   private void c()
/*    */   {
/* 42 */     this.a = new ImageView(this.b);
/* 43 */     this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
/*    */     
/* 45 */     this.a.setScaleType(ImageView.ScaleType.FIT_XY);
/* 46 */     addView(this.a);
/*    */   }
/*    */   
/*    */   NativeAdData a() {
/* 50 */     return this.c;
/*    */   }
/*    */   
/*    */   void a(NativeAdData paramh) {
/* 54 */     this.c = paramh;
/*    */   }
/*    */   
/*    */   void a(Bitmap paramBitmap) {
/* 58 */     this.a.setImageBitmap(paramBitmap);
/*    */   }
/*    */   
/*    */   void b() {
/* 62 */     this.a.setImageBitmap(null);
/* 63 */     setOnClickListener(null);
/* 64 */     this.c = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\result\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */