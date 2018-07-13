/*    */ package com.bytedance.sdk.openadsdk.core.a;
/*    */ 
/*    */ import android.view.MotionEvent;
import android.view.View;

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
/*    */ public abstract class AdClickListener
/*    */   implements View.OnClickListener, View.OnTouchListener
/*    */ {
/*    */   protected int mM;
/*    */   protected int mN;
/*    */   protected int mO;
/*    */   protected int mP;
/*    */   protected long mQ;
/*    */   protected long mR;
/*    */   
/*    */   public void onClick(View paramView)
/*    */   {
/* 26 */     b(paramView, this.mM, this.mN, this.mO, this.mP);
/*    */   }
/*    */   
/*    */   public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
/*    */   {
/* 31 */     switch (paramMotionEvent.getActionMasked()) {
/*    */     case 0: 
/* 33 */       this.mM = ((int)paramMotionEvent.getRawX());
/* 34 */       this.mN = ((int)paramMotionEvent.getRawY());
/* 35 */       this.mQ = System.currentTimeMillis();
/* 36 */       break;
/*    */     case 1: 
/* 38 */       this.mO = ((int)paramMotionEvent.getRawX());
/* 39 */       this.mP = ((int)paramMotionEvent.getRawY());
/* 40 */       this.mR = System.currentTimeMillis();
/*    */     }
/*    */     
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public abstract void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\LocationUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */