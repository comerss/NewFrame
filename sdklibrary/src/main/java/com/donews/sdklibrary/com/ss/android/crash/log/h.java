/*    */ package com.donews.sdklibrary.com.ss.android.crash.log;
/*    */ 
/*    */ import android.content.Context;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class h
/*    */   implements Thread.UncaughtExceptionHandler
/*    */ {
/* 12 */   private Thread.UncaughtExceptionHandler a = null;
/*    */   
/*    */   private Context b;
/*    */   private static a c;
/*    */   
/*    */   public static void a(a parama)
/*    */   {
/* 19 */     if (c == null)
/* 20 */       c = parama;
/*    */   }
/*    */   
/* 23 */   h(Context paramContext) { this.b = paramContext.getApplicationContext();
/* 24 */     this.a = Thread.getDefaultUncaughtExceptionHandler();
/* 25 */     Thread.setDefaultUncaughtExceptionHandler(this);
/*    */   }
/*    */   
/*    */   public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
/*    */     try { JSONObject localJSONObject;
/* 30 */       if (c != null) {
/* 31 */         if (c.a(paramThrowable)) {
/* 32 */           localJSONObject = l.a(this.b, paramThread, paramThrowable);
/* 33 */           i.b().a(localJSONObject);
/*    */         }
/*    */       } else {
/* 36 */         localJSONObject = l.a(this.b, paramThread, paramThrowable);
/* 37 */         i.b().a(localJSONObject);
/*    */       }
/*    */     }
/*    */     catch (Throwable localThrowable) {}finally {
/* 41 */       if ((this.a != null) && (this.a != this)) {
/* 42 */         this.a.uncaughtException(paramThread, paramThrowable);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract interface a
/*    */   {
/*    */     public abstract boolean a(Throwable paramThrowable);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\h.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */