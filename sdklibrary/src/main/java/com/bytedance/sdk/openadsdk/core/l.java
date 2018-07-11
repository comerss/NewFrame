/*    */ package com.bytedance.sdk.openadsdk.core;
/*    */ 
/*    */ import android.app.Dialog;
/*    */ import android.content.Context;
/*    */ import android.os.Bundle;
/*    */ import android.support.annotation.NonNull;
/*    */ import android.support.annotation.StyleRes;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class l
/*    */   extends Dialog
/*    */ {
/*    */   public l(@NonNull Context paramContext, @StyleRes int paramInt)
/*    */   {
/* 21 */     super(paramContext, paramInt);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void onCreate(Bundle paramBundle)
/*    */   {
/* 30 */     super.onCreate(paramBundle);
/*    */     
/* 32 */     setCancelable(false);
/*    */   }
/*    */   
/*    */   public void onBackPressed() {}
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\l.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */