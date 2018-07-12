/*    */ package com.bytedance.sdk.openadsdk.core;
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
/*    */ public class ApiException
/*    */ {
/*    */   public static String a(int paramInt)
/*    */   {
/* 43 */     switch (paramInt) {
/*    */     case -2: 
/* 45 */       return "网络请求失败";
/*    */     case -1: 
/* 47 */       return "解析失败";
/*    */     case 20001: 
/* 49 */       return "没有广告";
/*    */     case -3: 
/* 51 */       return "没有解析到广告";
/*    */     case 40000: 
/* 53 */       return "http conent_type错误";
/*    */     case 40001: 
/* 55 */       return "http request pb错误";
/*    */     case 40002: 
/* 57 */       return "请求app不能为空 ";
/*    */     case 40003: 
/* 59 */       return "请求wap不能为空";
/*    */     case 40004: 
/* 61 */       return "广告位不能为空";
/*    */     case 40005: 
/* 63 */       return "广告位尺寸不能为空";
/*    */     case 40006: 
/* 65 */       return "广告位ID不合法";
/*    */     case 50001: 
/* 67 */       return "服务器错误";
/*    */     case -4: 
/* 69 */       return "返回数据缺少必要字段";
/*    */     case -5: 
/* 71 */       return "Banner广告加载图片失败";
/*    */     case 40007: 
/* 73 */       return "广告数量错误";
/*    */     case -6: 
/* 75 */       return "插屏广告图片加载失败";
/*    */     case -7: 
/* 77 */       return "开屏广告图片加载失败";
/*    */     case -8: 
/* 79 */       return "广告请求频率过高";
/*    */     case -9: 
/* 81 */       return "请求实体为空";
/*    */     case -10: 
/* 83 */       return "缓存解析失败";
/*    */     case -11: 
/* 85 */       return "缓存过期";
/*    */     case -12: 
/* 87 */       return "缓存中没有开屏广告";
/*    */     case 60007: 
/* 89 */       return "激励视频验证服务器异常或处理失败";
/*    */     }
/* 91 */     return "未知错误码";
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\ApiException.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */