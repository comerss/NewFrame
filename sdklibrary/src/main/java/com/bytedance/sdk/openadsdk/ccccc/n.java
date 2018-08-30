/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.net.Uri;
/*     */ import android.os.Environment;
/*     */ import android.os.SystemClock;
/*     */ import android.util.Log;
/*     */ import android.webkit.MimeTypeMap;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.Random;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class n
/*     */ {
/*  28 */   public static Random a = new Random(SystemClock.uptimeMillis());
/*     */   
/*     */ 
/*     */ 
/*  32 */   private static final Pattern b = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");
/*     */   
/*  34 */   private static final Object c = new Object();
/*     */   private static com.bytedance.sdk.openadsdk.ccccc.asasa.b d;
/*     */   
/*     */   public static void a(com.bytedance.sdk.openadsdk.ccccc.asasa.b paramb)
/*     */   {
/*  39 */     d = paramb;
/*     */   }
/*     */   
/*     */   public static com.bytedance.sdk.openadsdk.ccccc.asasa.b a() {
/*  43 */     return d;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static String a(String paramString)
/*     */   {
/*     */     try
/*     */     {
/*  57 */       Matcher localMatcher = b.matcher(paramString);
/*  58 */       if (localMatcher.find()) {
/*  59 */         return localMatcher.group(1);
/*     */       }
/*     */     }
/*     */     catch (IllegalStateException localIllegalStateException) {}
/*     */     
/*  64 */     return null;
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
/*     */   static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, long paramLong, v paramv)
/*     */     throws u
/*     */   {
/*  80 */     if (paramLong < 0L) {
/*  81 */       paramLong = 0L;
/*     */     }
/*     */     
/*  84 */     File localFile = null;
String str;
/*  85 */     if (paramInt == 1) {
/*  86 */       str = Uri.parse(paramString2).getPath();
/*     */     } else {
/*  88 */       localFile = paramv.a(paramString5, paramInt, paramLong);
/*     */       
/*  90 */       str = a(paramString1, paramString2, paramString3, paramString4, paramInt);
/*     */     }
/*     */     
/*  93 */     paramv.b(paramInt, str, paramLong);
/*  94 */   a(str, paramString5, paramInt, localFile);
/*  95 */     return str;
/*     */   }
/*     */   
/*     */   static String a(String paramString1, String paramString2, int paramInt, File paramFile) throws u
/*     */   {
/* 100 */     String str1 = null;
/* 101 */     int i = paramString1.lastIndexOf('.');
/* 102 */     int j = (i < 0) || (i < paramString1.lastIndexOf('/')) ? 1 : 0;
/* 103 */     if (paramInt == 1)
/*     */     {
/* 105 */       if (j != 0) {
/* 106 */         str1 = "";
/*     */       } else {
/* 108 */         str1 = paramString1.substring(i);
/* 109 */         paramString1 = paramString1.substring(0, i);
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 114 */     else if (j != 0) {
/* 115 */       str1 = a(paramString2, true);
/*     */     } else {
/* 117 */       str1 = a(paramString2, paramInt, paramString1, i);
/* 118 */       paramString1 = paramString1.substring(0, i);
/*     */     }
/*     */     
/*     */ 
/* 122 */     boolean bool = "recovery".equalsIgnoreCase(paramString1 + str1);
/*     */     
/* 124 */     if (paramFile != null) {
/* 125 */       paramString1 = paramFile.getPath() + File.separator + paramString1;
/*     */     }
/*     */
/*     */     
/* 132 */     synchronized (c) {
/* 133 */       String str2 = a(paramInt, paramString1, str1, bool);
/*     */       
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 139 */         File localFile1 = new File(str2);
/* 140 */         File localFile2 = localFile1.getParentFile();
/*     */         
/*     */ 
/* 143 */         if ((localFile2 != null) && (!localFile2.exists())) {
/* 144 */           localFile2.mkdirs();
/*     */         }
/*     */         
/* 147 */         localFile1.createNewFile();
/*     */       } catch (IOException localIOException) {
/* 149 */         throw new u(492, "Failed to create target file " + str2, localIOException);
/*     */       }
/*     */       
/* 152 */       return str2;
/*     */     }
/*     */   }
/*     */   
/*     */   private static String a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
/*     */   {
/* 158 */     Object localObject = null;
/*     */     
/*     */     int i;
/* 161 */     if ((localObject == null) && (paramString2 != null) && (!paramString2.endsWith("/"))) {
/* 162 */
/* 165 */       i = paramString2.lastIndexOf('/') + 1;
/* 166 */       if (i > 0) {
/* 167 */         localObject = paramString2.substring(i);
/*     */       } else {
/* 169 */         localObject = paramString2;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 174 */     if ((localObject == null) && (paramString3 != null)) {
/* 175 */       localObject = a(paramString3);
/* 176 */       if (localObject != null) {
/* 178 */           Log.v("SsAndroidDownloadManager", "getting filename from content-disposition");
/* 180 */         i = ((String)localObject).lastIndexOf('/') + 1;
/* 181 */         if (i > 0) {
/* 182 */           localObject = ((String)localObject).substring(i);
/*     */         }
/*     */       }
/*     */     }
/*     */     String str;
/*     */     int j;
/* 188 */     if ((localObject == null) && (paramString4 != null)) {
/* 189 */       str = Uri.decode(paramString4);
/* 190 */       if ((str != null) && 
/* 191 */         (!str.endsWith("/")) && 
/* 192 */         (str.indexOf('?') < 0)) {
/* 194 */           Log.v("SsAndroidDownloadManager", "getting filename from content-location");
/* 196 */         j = str.lastIndexOf('/') + 1;
/* 197 */         if (j > 0) {
/* 198 */           localObject = str.substring(j);
/*     */         } else {
/* 200 */           localObject = str;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 206 */     if (localObject == null) {
/* 207 */       str = Uri.decode(paramString1);
/* 208 */       if ((str != null) && 
/* 209 */         (!str.endsWith("/")) && (str.indexOf('?') < 0)) {
/* 210 */         j = str.lastIndexOf('/') + 1;
/* 211 */         if (j > 0) {
/* 213 */             Log.v("SsAndroidDownloadManager", "getting filename from uri");
/* 215 */           localObject = str.substring(j);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 221 */     if (localObject == null) {
/* 223 */         Log.v("SsAndroidDownloadManager", "using default filename");
/* 225 */       localObject = "downloadfile";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 230 */     localObject = b((String)localObject);
/*     */     
/* 232 */     return (String)localObject;
/*     */   }
/*     */   
/*     */   private static String a(String paramString, boolean paramBoolean) {
/* 236 */     String str = null;
/* 237 */     if (paramString != null) {
/* 238 */       str = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
/* 239 */       if (str != null) {
/* 241 */           Log.v("SsAndroidDownloadManager", "adding extension from type");
/* 243 */         str = "." + str;
/*     */       }
/* 246 */         Log.v("SsAndroidDownloadManager", "couldn'MineHandler find extension for " + paramString);
/*     */     }
/*     */     
/* 250 */     if (str == null) {
/* 251 */       if ((paramString != null) && (paramString.toLowerCase().startsWith("text/"))) {
/* 252 */         if (paramString.equalsIgnoreCase("text/html")) {
/* 254 */             Log.v("SsAndroidDownloadManager", "adding default html extension");
/* 256 */           str = ".html";
/* 257 */         } else if (paramBoolean) {
/* 259 */             Log.v("SsAndroidDownloadManager", "adding default text extension");
/* 261 */           str = ".txt";
/*     */         }
/* 263 */       } else if (paramBoolean) {
/* 265 */           Log.v("SsAndroidDownloadManager", "adding default binary extension");
/* 267 */         str = ".bin";
/*     */       }
/*     */     }
/* 270 */     return str;
/*     */   }
/*     */   
/*     */   private static String a(String paramString1, int paramInt1, String paramString2, int paramInt2)
/*     */   {
/* 275 */     String str1 = null;
/* 276 */     if (paramString1 != null)
/*     */     {
/*     */ 
/* 279 */       String str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString2
/* 280 */         .substring(paramInt2 + 1));
/* 281 */       if ((str2 == null) || (!str2.equalsIgnoreCase(paramString1))) {
/* 282 */         str1 = a(paramString1, false);
/* 283 */         if (str1 != null) {
/* 285 */             Log.v("SsAndroidDownloadManager", "substituting extension from type");
/*     */         }
/* 289 */           Log.v("SsAndroidDownloadManager", "couldn'MineHandler find extension for " + paramString1);
/*     */       }
/*     */     }
/*     */     
/* 294 */     if (str1 == null) {
/* 296 */         Log.v("SsAndroidDownloadManager", "keeping extension");
/* 298 */       str1 = paramString2.substring(paramInt2);
/*     */     }
/* 300 */     return str1;
/*     */   }
/*     */   
/*     */   private static String a(int paramInt, String paramString1, String paramString2, boolean paramBoolean) throws u
/*     */   {
/* 305 */     String str = paramString1 + paramString2;
/* 306 */     if ((!new File(str).exists()) && (!paramBoolean))
/*     */     {
/* 308 */       return str;
/*     */     }
/* 310 */     paramString1 = paramString1 + "-";
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
/* 325 */     int i = 1;
/* 326 */     for (int j = 1; j < 1000000000; j *= 10) {
/* 327 */       for (int k = 0; k < 9; k++) {
/* 328 */         str = paramString1 + i + paramString2;
/* 329 */         if (!new File(str).exists()) {
/* 330 */           return str;
/*     */         }
/* 333 */           Log.v("SsAndroidDownloadManager", "file with sequence number " + i + " exists");
/* 335 */         i += a.nextInt(j) + 1;
/*     */       }
/*     */     }
/* 338 */     throw new u(492, "failed to generate an unused filename on internal download storage");
/*     */   }
/*     */   
/*     */ 
/*     */   static boolean a(String paramString, File paramFile)
/*     */   {
/*     */     String[] arrayOfString1;
/*     */     
/*     */     try
/*     */     {
/* 348 */       paramString = new File(paramString).getCanonicalPath();
/*     */       
/*     */ 
/*     */ 
/* 352 */       arrayOfString1 = new String[] {paramFile.getCanonicalPath(), Environment.getDownloadCacheDirectory().getCanonicalPath(), Environment.getExternalStorageDirectory().getCanonicalPath() };
/*     */     }
/*     */     catch (IOException localIOException) {
/* 355 */       Log.w("SsAndroidDownloadManager", "Failed to resolve canonical path: " + localIOException);
/* 356 */       return false;
/*     */     }
/*     */     
/* 359 */     for (String str : arrayOfString1) {
/* 360 */       if (paramString.startsWith(str)) {
/* 361 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 365 */     return false;
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
/*     */   private static String b(String paramString)
/*     */   {
/* 636 */     int i = 0;
/* 637 */     int j = 31;
/* 638 */     int k = 34;
/* 639 */     int m = 42;
/* 640 */     int n = 47;
/* 641 */     int i1 = 58;
/* 642 */     int i2 = 60;
/* 643 */     int i3 = 62;
/* 644 */     int i4 = 63;
/* 645 */     int i5 = 92;
/* 646 */     int i6 = 124;
/* 647 */     int i7 = 127;
/* 648 */     int i8 = 95;
/*     */     
/* 650 */     StringBuffer localStringBuffer = new StringBuffer();
/*     */     
/* 652 */     int i9 = 0;
/* 653 */     for (int i10 = 0; i10 < paramString.length(); i10++) {
/* 654 */       char c1 = paramString.charAt(i10);
/* 655 */       if ((('\000' <= c1) && (c1 <= '\037')) || (c1 == '"') || (c1 == '*') || (c1 == '/') || (c1 == ':') || (c1 == '<') || (c1 == '>') || (c1 == '?') || (c1 == '\\') || (c1 == '|') || (c1 == ''))
/*     */       {
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
/* 667 */         if (i9 == 0) {
/* 668 */           localStringBuffer.append('_');
/* 669 */           i9 = 1;
/*     */         }
/*     */       } else {
/* 672 */         localStringBuffer.append(c1);
/* 673 */         i9 = 0;
/*     */       }
/*     */     }
/* 676 */     return localStringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\mN.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */