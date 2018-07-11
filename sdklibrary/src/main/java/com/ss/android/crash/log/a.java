/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.os.FileObserver;
/*    */ import android.text.TextUtils;
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends FileObserver
/*    */ {
/*    */   private final c a;
/*    */   
/*    */   public a(c paramc, String paramString, int paramInt)
/*    */   {
/* 14 */     super(paramString, paramInt);
/*    */     
/* 16 */     if ((paramc == null) || (TextUtils.isEmpty(paramString)))
/* 17 */       throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
/* 18 */     this.a = paramc;
/*    */   }
/*    */   
/*    */   public void onEvent(int paramInt, String paramString)
/*    */   {
/* 23 */     if ((paramInt == 8) && 
/* 24 */       (!TextUtils.isEmpty(paramString)) && (paramString.contains("trace")) && 
/* 25 */       (this.a != null)) {
/* 26 */       this.a.b(200, "/data/anr/" + paramString);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\ssl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */