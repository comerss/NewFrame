/*    */ package com.bytedance.sdk.openadsdk.ggg;
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
/*    */   public static void a(Context paramContext, String paramString, final a var2)
/*    */   {
/* 22 */     AQuery2 localAQuery2 = new AQuery2(paramContext);
/* 23 */    AjaxCallback var4 = new AjaxCallback<byte[]>() {
        public void a(String var1, byte[] var2x, AjaxStatus var3) {
            if (var2 != null) {
                if (var3 != null && var2x != null && var2x.length != 0) {
                    if (var3.getCode() == 200) {
                        LogUtils.b("ImageBytesHelper", "图片数据返回成功" + var2x.length);
                        var2.a(var2x);
                    } else {
                        var2.a();
                    }
                } else {
                    var2.a();
                }
            }

        }
    };
/* 42 */     localAQuery2.ajax(paramString, byte[].class, var4);
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