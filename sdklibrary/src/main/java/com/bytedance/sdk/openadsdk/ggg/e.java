/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */ {
/*  15 */   static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(byte[] paramArrayOfByte)
/*     */   {
/*  24 */     if (paramArrayOfByte == null)
/*  25 */       throw new NullPointerException("bytes is null");
/*  26 */     return a(paramArrayOfByte, 0, paramArrayOfByte.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
/*     */   {
/*  33 */     if (paramArrayOfByte == null)
/*  34 */       throw new NullPointerException("bytes is null");
/*  35 */     if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
/*  36 */       throw new IndexOutOfBoundsException();
/*  37 */     char[] arrayOfChar = new char[paramInt2 * 2];
/*     */     
/*  39 */     int j = 0;
/*  40 */     for (int k = 0; k < paramInt2; k++) {
/*  41 */       int i = paramArrayOfByte[(k + paramInt1)] & 0xFF;
/*  42 */       arrayOfChar[(j++)] = a[(i >> 4)];
/*  43 */       arrayOfChar[(j++)] = a[(i & 0xF)];
/*     */     }
/*  45 */     return new String(arrayOfChar, 0, paramInt2 * 2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(String paramString)
/*     */   {
/*     */     try
/*     */     {
/*  86 */       if ((paramString == null) || (paramString.length() == 0))
/*  87 */         return null;
/*  88 */       MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
/*  89 */       byte[] arrayOfByte = paramString.getBytes("UTF-8");
/*  90 */       localMessageDigest.update(arrayOfByte);
/*  91 */       return a(localMessageDigest.digest());
/*     */     } catch (Exception localException) {}
/*  93 */     return null;
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
/*     */ 
/*     */   public static String b(String paramString)
/*     */   {
/* 130 */     String str = "";
/*     */     try {
/* 132 */       MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
/* 133 */       localMessageDigest.update(paramString.getBytes("UTF-8"));
/* 134 */       str = a(localMessageDigest.digest());
/*     */     } catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {
/* 136 */       localNoSuchAlgorithmException.printStackTrace();
/*     */     } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
/* 138 */       localUnsupportedEncodingException.printStackTrace();
/*     */     }
/* 140 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\ApiException\TTBannerAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */