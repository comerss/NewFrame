/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.graphics.Bitmap;
/*    */
/*    */
/*    */ import android.graphics.BitmapFactory;
/*    */
/*    */ import android.os.Environment;
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class f
/*    */ {
/*    */   public static File a(Context paramContext, String paramString1, String paramString2)
/*    */   {
            String str;
/* 26 */     if ((("mounted".equals(Environment.getExternalStorageState())) || 
/* 27 */       (!Environment.isExternalStorageRemovable())) && (paramContext.getExternalCacheDir() != null))
/*    */     {
/* 29 */       str = paramContext.getExternalCacheDir().getPath();
/*    */     } else {
/* 31 */       str = paramContext.getCacheDir().getPath();
/*    */     }
/* 33 */      str = str + paramString1;
/* 34 */     File localFile = new File(str);
/* 35 */     if (!localFile.exists()) {
/* 36 */       localFile.mkdirs();
/*    */     }
/* 38 */     return new File(str, paramString2);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
/*    */   {
/* 50 */     ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
/* 51 */     paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
/* 52 */     if (localByteArrayOutputStream.toByteArray().length / 1024 > 1024) {
/* 53 */       localByteArrayOutputStream.reset();
/* 54 */       paramBitmap.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
/*    */     }
/* 56 */     ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
/* 57 */     BitmapFactory.Options localOptions = new BitmapFactory.Options();
/* 58 */     localOptions.inJustDecodeBounds = true;
/* 59 */     localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
/* 60 */     Bitmap localBitmap = BitmapFactory.decodeStream(localByteArrayInputStream, null, localOptions);
/* 61 */     localOptions.inJustDecodeBounds = false;
/* 62 */     int i = localOptions.outWidth;
/* 63 */     int j = localOptions.outHeight;
/* 64 */     float f1 = paramFloat2;
/* 65 */     float f2 = paramFloat1;
/*    */     
/* 67 */     int k = 1;
/* 68 */     if ((i >= j) && (i > f2)) {
/* 69 */       k = (int)(localOptions.outWidth / f2);
/* 70 */     } else if ((i < j) && (j > f1)) {
/* 71 */       k = (int)(localOptions.outHeight / f1);
/*    */     }
/* 73 */     if (k <= 0) k = 1;
/* 74 */     localOptions.inSampleSize = k;
/* 75 */     localByteArrayInputStream = new ByteArrayInputStream(localByteArrayOutputStream.toByteArray());
/* 76 */     localBitmap = BitmapFactory.decodeStream(localByteArrayInputStream, null, localOptions);
/* 77 */     return localBitmap;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\DownloadNotifier\doErrorHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */