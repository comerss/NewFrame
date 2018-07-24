/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.util.Base64;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/*    */   public static String a(String paramString1, String paramString2)
/*    */   {
/*    */     try
/*    */     {
/* 16 */       SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
/* 17 */       Cipher localCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
/* 18 */       localCipher.init(1, localSecretKeySpec);
/* 19 */       byte[] arrayOfByte = localCipher.doFinal(paramString1.getBytes("utf-8"));
/* 20 */       return Base64.encodeToString(arrayOfByte, 0);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/* 31 */       localException.printStackTrace();
/*    */     }
/* 33 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */