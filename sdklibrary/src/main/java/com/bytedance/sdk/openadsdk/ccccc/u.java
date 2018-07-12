/*    */ package com.bytedance.sdk.openadsdk.ccccc;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class u
/*    */   extends Exception
/*    */ {
/*    */   private final int a;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public u(int paramInt, String paramString)
/*    */   {
/* 17 */     super(paramString);
/* 18 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public u(int paramInt, Throwable paramThrowable) {
/* 22 */     super(paramThrowable);
/* 23 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public u(int paramInt, String paramString, Throwable paramThrowable) {
/* 27 */     super(paramString, paramThrowable);
/* 28 */     this.a = paramInt;
/*    */   }
/*    */   
/*    */   public int a() {
/* 32 */     return this.a;
/*    */   }
/*    */   
/*    */   public static u a(int paramInt, String paramString) throws u
/*    */   {
/* 37 */     String str = "Unhandled HTTP response: " + paramInt + " " + paramString;
/* 38 */     if ((paramInt >= 400) && (paramInt < 600))
/* 39 */       throw new u(paramInt, str);
/* 40 */     if ((paramInt >= 300) && (paramInt < 400)) {
/* 41 */       throw new u(493, str);
/*    */     }
/* 43 */     throw new u(494, str);
/*    */   }
/*    */ }

