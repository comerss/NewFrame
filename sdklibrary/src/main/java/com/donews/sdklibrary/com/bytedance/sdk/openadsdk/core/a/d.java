/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.a;
/*    */ 
/*    */ import android.view.MotionEvent;
/*    */ import android.view.View;
/*    */ import android.view.View.OnClickListener;
/*    */ import android.view.View.OnTouchListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class d
/*    */   implements OnClickListener, OnTouchListener
/*    */ {
/*    */   protected int m;
/*    */   protected int n;
/*    */   protected int o;
/*    */   protected int p;
/*    */   protected long q;
/*    */   protected long r;
/*    */   
/*    */   public void onClick(View paramView)
/*    */   {
/* 26 */     b(paramView, this.m, this.n, this.o, this.p);
/*    */   }
/*    */   
/*    */   public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
/*    */   {
/* 31 */     switch (paramMotionEvent.getActionMasked()) {
/*    */     case 0: 
/* 33 */       this.m = ((int)paramMotionEvent.getRawX());
/* 34 */       this.n = ((int)paramMotionEvent.getRawY());
/* 35 */       this.q = System.currentTimeMillis();
/* 36 */       break;
/*    */     case 1: 
/* 38 */       this.o = ((int)paramMotionEvent.getRawX());
/* 39 */       this.p = ((int)paramMotionEvent.getRawY());
/* 40 */       this.r = System.currentTimeMillis();
/*    */     }
/*    */     
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\a\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */