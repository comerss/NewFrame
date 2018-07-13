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
/*    */ public class ImageHelper
/*    */ {
/*    */   public static void loadImage(Context paramContext, String paramString, final OnLoadImage onLoadImage)
/*    */   {
/* 22 */     AQuery2 localAQuery2 = new AQuery2(paramContext);
/* 23 */    AjaxCallback var4 = new AjaxCallback<byte[]>() {
        public void callback(String var1, byte[] var2x, AjaxStatus var3) {
            if (onLoadImage != null) {
                if (var3 != null && var2x != null && var2x.length != 0) {
                    if (var3.getCode() == 200) {
                        LogUtils.b("ImageBytesHelper", "图片数据返回成功" + var2x.length);
                        onLoadImage.onsuccess(var2x);
                    } else {
                        onLoadImage.onFail();
                    }
                } else {
                    onLoadImage.onFail();
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
/*    */   public static Drawable loadImage(byte[] paramArrayOfByte, int paramInt)
/*    */   {
/* 52 */     DrawableAjaxCallback localDrawableAjaxCallback = new DrawableAjaxCallback();
/* 53 */     localDrawableAjaxCallback.targetWidth(paramInt);
/* 54 */     return localDrawableAjaxCallback.transform(null, paramArrayOfByte, new AjaxStatus());
/*    */   }
/*    */   
/*    */   public static abstract interface OnLoadImage
/*    */   {
/*    */     public abstract void onsuccess(@NonNull byte[] paramArrayOfByte);
/*    */     
/*    */     public abstract void onFail();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\DownloadNotifier\ImageHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */