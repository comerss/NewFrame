/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.app.Application;
/*    */ import android.content.Context;
/*    */ import android.text.TextUtils;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class j
/*    */ {
/*    */   private static volatile j a;
/*    */   private Context b;
/*    */   private volatile boolean c;
/*    */   private volatile h d;
/*    */   
/*    */   public static j a(Application paramApplication)
/*    */   {
/* 24 */     if (a == null) {
/* 25 */       synchronized (j.class) {
/* 26 */         if (a == null) {
/* 27 */           a = new j(paramApplication);
/*    */         }
/*    */       }
/*    */     }
/* 31 */     return a;
/*    */   }
/*    */   
/* 34 */   private j(Context paramContext) { if (paramContext == null)
/* 35 */       throw new IllegalArgumentException("context must not be null");
/* 36 */     this.b = paramContext.getApplicationContext();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void a(a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
/*    */   {
/* 65 */     if (this.c)
/* 66 */       return;
/* 67 */     if (parama == null)
/* 68 */       throw new IllegalArgumentException("CommonParams must not be null");
/* 69 */     if (paramBoolean1)
/* 70 */       this.d = new h(this.b);
/* 71 */     i.a(this.b, parama);
/* 72 */     if (paramBoolean3)
/* 73 */       g.a(this.b).a();
/* 74 */     String str = l.b(this.b);
/* 75 */     if ((paramBoolean2) && (!TextUtils.isEmpty(str))) {
///* 76 */       NativeCrashInit.registerForNativeCrash(this.netState, "ss_native_crash_logs", "ss_native_crash-", str);
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract interface a
/*    */   {
/*    */     public abstract Map<String, Object> a();
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\j.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */