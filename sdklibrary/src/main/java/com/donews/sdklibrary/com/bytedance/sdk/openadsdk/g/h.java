/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.g;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.drawable.Drawable;
/*    */ import android.support.annotation.NonNull;
/*    */ import com.androidquery.callback.AQuery2;
/*    */ import com.androidquery.callback.AjaxCallback;
/*    */ import com.androidquery.callback.AjaxStatus;
/*    */ import com.androidquery.callback.DrawableAjaxCallback;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class h
/*    */ {
/*    */   public static void a(Context paramContext, String paramString, a parama)
/*    */   {
/* 22 */     AQuery2 localAQuery2 = new AQuery2(paramContext);
/* 23 */     AjaxCallback local1 = new AjaxCallback()
/*    */     {
/*    */       public void a(String paramAnonymousString, byte[] paramAnonymousArrayOfByte, AjaxStatus paramAnonymousAjaxStatus) {
/* 26 */         if (this.a != null) {
/* 27 */           if ((paramAnonymousAjaxStatus == null) || (paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0)) {
/* 28 */             this.a.a();
/*    */           }
/* 30 */           else if (paramAnonymousAjaxStatus.getCode() == 200) {
/* 31 */             m.b("ImageBytesHelper", "图片数据返回成功" + paramAnonymousArrayOfByte.length);
/* 32 */             this.a.a(paramAnonymousArrayOfByte);
/*    */           } else {
/* 34 */             this.a.a();
/*    */           }
/*    */           
/*    */         }
/*    */         
/*    */       }
/*    */       
/* 41 */     };
/* 42 */     localAQuery2.ajax(paramString, byte[].class, local1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Drawable a(byte[] paramArrayOfByte, int paramInt)
/*    */   {
/* 52 */     DrawableAjaxCallback localDrawableAjaxCallback = new DrawableAjaxCallback();
/* 53 */     localDrawableAjaxCallback.targetWidth(paramInt);
/* 54 */     return localDrawableAjaxCallback.transform(null, paramArrayOfByte, new AjaxStatus());
/*    */   }
/*    */   
/*    */   public static abstract interface a
/*    */   {
/*    */     public abstract void a(@NonNull byte[] paramArrayOfByte);
/*    */     
/*    */     public abstract void a();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\h.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */