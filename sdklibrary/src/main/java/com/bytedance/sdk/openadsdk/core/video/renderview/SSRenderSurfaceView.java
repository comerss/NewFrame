/*     */ package com.bytedance.sdk.openadsdk.core.video.renderview;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.util.AttributeSet;
/*     */ import android.view.SurfaceHolder;
/*     */ import android.view.SurfaceHolder.Callback;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup.LayoutParams;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ public class SSRenderSurfaceView
/*     */   extends c
/*     */   implements SurfaceHolder.Callback, b
/*     */ {
/*     */   private a a;
/*     */   private d b;
/*  18 */   private static ArrayList<d> c = new ArrayList();
/*     */   private b.a d;
/*     */   
/*  21 */   public SSRenderSurfaceView(Context paramContext) { super(paramContext);
/*  22 */     a();
/*     */   }
/*     */   
/*     */   public SSRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet) {
/*  26 */     super(paramContext, paramAttributeSet);
/*  27 */     a();
/*     */   }
/*     */   
/*     */   public SSRenderSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
/*  31 */     super(paramContext, paramAttributeSet, paramInt);
/*  32 */     a();
/*     */   }
/*     */   
/*     */   private void a() {
/*  36 */     this.b = new d(this);
/*  37 */     c.add(this.b);
/*     */   }
/*     */   
/*     */   public void a(a parama)
/*     */   {
/*  42 */     this.a = parama;
/*     */     
/*  44 */     SurfaceHolder localSurfaceHolder = getHolder();
/*  45 */     localSurfaceHolder.setFormat(-3);
/*     */     
/*  47 */     Iterator localIterator = c.iterator();
/*  48 */     while (localIterator.hasNext()) {
/*  49 */       d locald = (d)localIterator.next();
/*  50 */       SurfaceHolder.Callback localCallback = locald.a();
/*  51 */       if (localCallback == null) {
/*  52 */         localSurfaceHolder.removeCallback(locald);
/*  53 */         localIterator.remove();
/*     */       }
/*     */     }
/*  56 */     localSurfaceHolder.addCallback(this.b);
/*     */   }
/*     */   
/*     */   public void a(int paramInt1, int paramInt2)
/*     */   {
/*  61 */     ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
/*  62 */     localLayoutParams.height = paramInt2;
/*  63 */     localLayoutParams.width = paramInt1;
/*  64 */     setLayoutParams(localLayoutParams);
/*     */   }
/*     */   
/*     */   public View getView()
/*     */   {
/*  69 */     return this;
/*     */   }
/*     */   
/*     */   public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
/*     */   {
/*  74 */     if (this.a != null) {
/*  75 */       this.a.a(paramSurfaceHolder);
/*     */     }
/*     */   }
/*     */   
/*     */   public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  81 */     if (this.a != null) {
/*  82 */       this.a.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
/*     */     }
/*     */   }
/*     */   
/*     */   public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
/*     */   {
/*  88 */     if (this.a != null) {
/*  89 */       this.a.b(paramSurfaceHolder);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onWindowVisibilityChanged(int paramInt)
/*     */   {
/*  97 */     super.onWindowVisibilityChanged(paramInt);
/*  98 */     if (this.d != null) {
/*  99 */       this.d.a(paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setWindowVisibilityChangedListener(b.a parama)
/*     */   {
/* 105 */     this.d = parama;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\SSRenderSurfaceView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */