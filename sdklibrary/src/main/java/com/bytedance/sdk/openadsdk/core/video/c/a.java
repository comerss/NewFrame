/*    */ package com.bytedance.sdk.openadsdk.core.video.c;
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class a
/*    */   implements cc
/*    */ {
/*    */   private cc.e a;
/*    */   
/*    */ 
/*    */   private cc.b b;
/*    */   
/*    */ 
/*    */   private cc.a c;
/*    */   
/*    */ 
/*    */   private cc.f d;
/*    */   
/*    */ 
/*    */   private cc.g e;
/*    */   
/*    */ 
/*    */   private cc.c f;
/*    */   
/*    */ 
/*    */   private cc.d g;
/*    */   
/*    */ 
/*    */   public final void a(cc.e parame)
/*    */   {
/* 31 */     this.a = parame;
/*    */   }
/*    */   
/*    */   public final void a(cc.b paramb) {
/* 35 */     this.b = paramb;
/*    */   }
/*    */   
/*    */   public final void a(cc.a parama)
/*    */   {
/* 40 */     this.c = parama;
/*    */   }
/*    */   
/*    */   public final void a(cc.f paramf) {
/* 44 */     this.d = paramf;
/*    */   }
/*    */   
/*    */   public final void a(cc.c paramc) {
/* 48 */     this.f = paramc;
/*    */   }
/*    */   
/*    */   public final void a(cc.d paramd) {
/* 52 */     this.g = paramd;
/*    */   }
/*    */   
/*    */   public void a()
/*    */   {
/* 57 */     this.a = null;
/* 58 */     this.c = null;
/* 59 */     this.b = null;
/* 60 */     this.d = null;
/* 61 */     this.e = null;
/* 62 */     this.f = null;
/* 63 */     this.g = null;
/*    */   }
/*    */   
/*    */   protected final void b() {
/* 67 */     if (this.a != null)
/* 68 */       this.a.b(this);
/*    */   }
/*    */   
/*    */   protected final void c() {
/* 72 */     if (this.b != null)
/* 73 */       this.b.a(this);
/*    */   }
/*    */   
/*    */   protected final void a(int paramInt) {
/* 77 */     if (this.c != null)
/* 78 */       this.c.a(this, paramInt);
/*    */   }
/*    */   
/*    */   protected final void d() {
/* 82 */     if (this.d != null) {
/* 83 */       this.d.c(this);
/*    */     }
/*    */   }
/*    */   
/*    */   protected final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 88 */     if (this.e != null) {
/* 89 */       this.e.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
/*    */     }
/*    */   }
/*    */   
/*    */   protected final boolean a(int paramInt1, int paramInt2) {
/* 94 */     return (this.f != null) && (this.f.a(this, paramInt1, paramInt2));
/*    */   }
/*    */   
/*    */   protected final boolean b(int paramInt1, int paramInt2) {
/* 98 */     return (this.g != null) && (this.g.b(this, paramInt1, paramInt2));
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\cdsss\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */