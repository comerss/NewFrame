/*    */ package com.donews.sdklibrary.com.androidquery.callback;
/*    */ 
/*    */ import android.app.Activity;
/*    */ import android.content.Context;
/*    */ import android.graphics.Bitmap;
/*    */ import android.graphics.drawable.BitmapDrawable;
/*    */ import android.view.View;
/*    */ import android.widget.ImageView;
/*    */ import com.androidquery.AQuery;
/*    */ import org.apache.http.HttpHost;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AQuery2
/*    */   extends AQuery
/*    */ {
/* 21 */   private int a = 0;
/*    */   private Activity b;
/*    */   private HttpHost c;
/*    */   
/*    */   public AQuery2(Activity paramActivity) {
/* 26 */     super(paramActivity);
/* 27 */     this.b = paramActivity;
/*    */   }
/*    */   
/*    */   public AQuery2(View paramView) {
/* 31 */     super(paramView);
/*    */   }
/*    */   
/*    */   public AQuery2(Context paramContext) {
/* 35 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public AQuery2(Activity paramActivity, View paramView) {
/* 39 */     super(paramActivity, paramView);
/* 40 */     this.b = paramActivity;
/*    */   }
/*    */   
/*    */   public AQuery policy(int paramInt)
/*    */   {
/* 45 */     this.a = paramInt;
/* 46 */     return (AQuery)super.policy(paramInt);
/*    */   }
/*    */   
/*    */   protected void reset()
/*    */   {
/* 51 */     super.reset();
/* 52 */     this.a = 0;
/*    */   }
/*    */   
/*    */   public AQuery proxy(String paramString, int paramInt)
/*    */   {
/* 57 */     this.c = new HttpHost(paramString, paramInt);
/* 58 */     return (AQuery)super.proxy(paramString, paramInt);
/*    */   }
/*    */   
/*    */   protected AQuery a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat, int paramInt4, String paramString2)
/*    */   {
/* 63 */     if ((this.view instanceof ImageView)) {
/* 64 */       DrawableAjaxCallback.async(this.b, getContext(), (ImageView)this.view, paramString1, paramBoolean1, paramBoolean2, paramInt1, paramInt2, new BitmapDrawable(paramBitmap), paramInt3, paramFloat, Float.MAX_VALUE, this.progress, this.ah, this.a, paramInt4, this.c, paramString2);
/* 65 */       reset();
/*    */     }
/*    */     
/* 68 */     return (AQuery)self();
/*    */   }
/*    */   
/*    */   protected AQuery a(String paramString1, ImageOptions paramImageOptions, String paramString2)
/*    */   {
/* 73 */     if ((this.view instanceof ImageView)) {
/* 74 */       DrawableAjaxCallback.async(this.b, getContext(), (ImageView)this.view, paramString1, this.progress, this.ah, paramImageOptions, this.c, paramString2);
/* 75 */       reset();
/*    */     }
/*    */     
/* 78 */     return (AQuery)self();
/*    */   }
/*    */   
/*    */   public AQuery image(String paramString1, ImageOptions paramImageOptions, String paramString2, DrawableAjaxCallback paramDrawableAjaxCallback) {
/* 82 */     if ((this.view instanceof ImageView)) {
/* 83 */       DrawableAjaxCallback.async(this.b, getContext(), (ImageView)this.view, paramString1, this.progress, this.ah, paramImageOptions, this.c, paramString2, paramDrawableAjaxCallback);
/* 84 */       reset();
/*    */     }
/*    */     
/* 87 */     return (AQuery)self();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\androidquery\callback\AQuery2.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */