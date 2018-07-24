/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.renderview;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.util.AttributeSet;
/*    */ import android.view.SurfaceView;
/*    */ 
/*    */ public class c extends SurfaceView
/*    */ {
/*    */   public c(Context paramContext)
/*    */   {
/* 11 */     super(paramContext);
/*    */   }
/*    */   
/*    */   public c(Context paramContext, AttributeSet paramAttributeSet) {
/* 15 */     super(paramContext, paramAttributeSet);
/*    */   }
/*    */   
/*    */   public c(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
/* 19 */     super(paramContext, paramAttributeSet, paramInt);
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onWindowVisibilityChanged(int paramInt)
/*    */   {
/* 25 */     if (paramInt == 0) {
/* 26 */       super.onWindowVisibilityChanged(paramInt);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\renderview\c.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */