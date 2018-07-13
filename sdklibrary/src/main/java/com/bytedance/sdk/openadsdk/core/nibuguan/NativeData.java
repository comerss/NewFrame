/*    */ package com.bytedance.sdk.openadsdk.core.nibuguan;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NativeData
/*    */ {
/*    */   private String a;
/*    */   private int b;
/*    */   private String c;
/* 15 */   private List<h> d = new ArrayList();
/*    */   
/*    */ 
/*    */   private String e;
/*    */   
/*    */   private long f;
/*    */   
/*    */ 
/*    */   public void a(String paramString)
/*    */   {
/* 25 */     this.a = paramString;
/*    */   }
/*    */   
/*    */   public int a() {
/* 29 */     return this.b;
/*    */   }
/*    */   
/*    */   public void a(int paramInt) {
/* 33 */     this.b = paramInt;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void b(String paramString)
/*    */   {
/* 41 */     this.c = paramString;
/*    */   }
/*    */   
/*    */   public List<h> b() {
/* 45 */     return this.d;
/*    */   }
/*    */   
/*    */   public void a(h paramh) {
/* 49 */     this.d.add(paramh);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public String c()
/*    */   {
/* 57 */     return this.e;
/*    */   }
/*    */   
/*    */   public void c(String paramString) {
/* 61 */     this.e = paramString;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void a(long paramLong)
/*    */   {
/* 69 */     this.f = paramLong;
/*    */   }

    @Override
    public String toString() {
        return "NativeData{" +
                "OnLoadImage='" + a + '\'' +
                ", fbbb=" + b +
                ", fccc='" + c + '\'' +
                ", TTSplashAdImpl=" + d +
                ", e='" + e + '\'' +
                ", ImageUtils=" + f +
                '}';
    }
    /*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\LocationUtils\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */