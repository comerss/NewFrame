/*    */ package com.bytedance.sdk.openadsdk.ggg;
/*    */ 
/*    */ import java.util.List;
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
/*    */ public class ListUtils
/*    */ {
/*    */   public static boolean isEmpty(List<?> paramList)
/*    */   {
/* 20 */     return (paramList == null) || (paramList.size() == 0);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean checkEmpty(List<?> paramList)
/*    */   {
/* 30 */     return !isEmpty(paramList);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\TouchDelegateImpl\LogUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */