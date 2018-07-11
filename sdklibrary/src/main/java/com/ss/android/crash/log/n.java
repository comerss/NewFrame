/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.text.TextUtils;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ 
/*    */ public class n
/*    */ {
/*    */   /* Error */
/*    */   static void a(File paramFile, String paramString)
/*    */     throws IOException
/*    */   {
/*    */     // Byte code:
/*    */     //   0: aload_0
/*    */     //   1: ifnull +10 -> 11
/*    */     //   4: aload_1
/*    */     //   5: invokestatic 15	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
/*    */     //   8: ifeq +4 -> 12
/*    */     //   11: return
/*    */     //   12: aconst_null
/*    */     //   13: astore_2
/*    */     //   14: new 8	java/io/FileOutputStream
/*    */     //   17: dup
/*    */     //   18: aload_0
/*    */     //   19: iconst_1
/*    */     //   20: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
/*    */     //   23: astore_2
/*    */     //   24: aload_2
/*    */     //   25: new 14	java/lang/StringBuilder
/*    */     //   28: dup
/*    */     //   29: invokespecial 27	java/lang/StringBuilder:<init>	()V
/*    */     //   32: aload_1
/*    */     //   33: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   36: ldc 1
/*    */     //   38: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   41: invokevirtual 29	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*    */     //   44: invokevirtual 26	java/lang/String:getBytes	()[B
/*    */     //   47: invokevirtual 25	java/io/OutputStream:write	([B)V
/*    */     //   50: aload_2
/*    */     //   51: ifnull +21 -> 72
/*    */     //   54: aload_2
/*    */     //   55: invokevirtual 24	java/io/OutputStream:close	()V
/*    */     //   58: goto +14 -> 72
/*    */     //   61: astore_3
/*    */     //   62: aload_2
/*    */     //   63: ifnull +7 -> 70
/*    */     //   66: aload_2
/*    */     //   67: invokevirtual 24	java/io/OutputStream:close	()V
/*    */     //   70: aload_3
/*    */     //   71: athrow
/*    */     //   72: return
/*    */     // Line number table:
/*    */     //   Java source line #19	-> byte code offset #0
/*    */     //   Java source line #20	-> byte code offset #11
/*    */     //   Java source line #21	-> byte code offset #12
/*    */     //   Java source line #23	-> byte code offset #14
/*    */     //   Java source line #24	-> byte code offset #24
/*    */     //   Java source line #26	-> byte code offset #50
/*    */     //   Java source line #27	-> byte code offset #54
/*    */     //   Java source line #26	-> byte code offset #61
/*    */     //   Java source line #27	-> byte code offset #66
/*    */     //   Java source line #29	-> byte code offset #72
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	signature
/*    */     //   0	73	0	paramFile	File
/*    */     //   0	73	1	paramString	String
/*    */     //   13	54	2	localFileOutputStream	java.io.FileOutputStream
/*    */     //   61	10	3	localObject	Object
/*    */     // Exception table:
/*    */     //   from	to	target	type
/*    */     //   14	50	61	finally
/*    */   }
/*    */   
/*    */   static void a(String paramString)
/*    */   {
/* 32 */     if (TextUtils.isEmpty(paramString))
/* 33 */       return;
/* 34 */     File localFile = new File(paramString);
/* 35 */     if (localFile.exists())
/* 36 */       localFile.delete();
/*    */   }
/*    */   
/*    */   static String b(String paramString) throws FileNotFoundException, IOException {
/* 40 */     if (TextUtils.isEmpty(paramString))
/* 41 */       return null;
/* 42 */     File localFile = new File(paramString);
/* 43 */     BufferedReader localBufferedReader = new BufferedReader(new FileReader(localFile));
/*    */     
/* 45 */     StringBuilder localStringBuilder = new StringBuilder();
/* 46 */     String str; while ((str = localBufferedReader.readLine()) != null) {
/* 47 */       localStringBuilder.append(str);
/*    */     }
/* 49 */     l.a(localBufferedReader);
/* 50 */     return localStringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\mN.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */