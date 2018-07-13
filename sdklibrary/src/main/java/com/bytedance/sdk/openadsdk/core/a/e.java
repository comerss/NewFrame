/*    */ package com.bytedance.sdk.openadsdk.core.a;
/*    */ 
/*    */ import android.content.Context;
/*    */ import android.support.annotation.NonNull;
/*    */ import android.view.View;
/*    */ import com.bytedance.sdk.openadsdk.core.nibuguan.h;
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
/*    */ public abstract class e
/*    */   extends a
/*    */ {
/*    */   public e(@NonNull Context paramContext, @NonNull h paramh, @NonNull String paramString, int paramInt)
/*    */   {
/* 25 */     super(paramContext, paramh, paramString, paramInt);
/*    */   }
/*    */   
/*    */   public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
/*    */   {
/* 30 */     a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
/* 31 */     super.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
/*    */   }
/*    */   
/*    */   public abstract void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\TTBannerAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */