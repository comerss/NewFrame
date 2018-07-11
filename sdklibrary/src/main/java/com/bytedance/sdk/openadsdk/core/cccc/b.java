/*    */ package com.bytedance.sdk.openadsdk.core.cccc;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.androidquery.AQuery;
/*    */ import com.androidquery.callback.AjaxCallback;
/*    */ import org.json.JSONException;
/*    */ import org.json.JSONObject;
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
/*    */ public class b
/*    */ {
/*    */   public static void a(Context paramContext, String paramString, long paramLong)
/*    */   {
/* 26 */     JSONObject localJSONObject = a(paramString, paramLong);
/* 27 */     AjaxCallback localAjaxCallback = new AjaxCallback();
/* 28 */     localAjaxCallback.timeout(10000);
/* 29 */     AQuery localAQuery = new AQuery(paramContext);
/*    */     
/* 31 */     localAQuery.post("https://i.snssdk.com/api/ad/union/sdk/stats/", localJSONObject, String.class, localAjaxCallback);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static JSONObject a(String paramString, long paramLong)
/*    */   {
/* 41 */     JSONObject localJSONObject = new JSONObject();
/*    */     try {
/* 43 */       localJSONObject.put("type", "over_freq");
/* 44 */       localJSONObject.put("rit", paramString);
/* 45 */       localJSONObject.put("ad_sdk_version", "1.9.0");
/* 46 */       localJSONObject.put("timestamp", paramLong);
/*    */     }
/*    */     catch (JSONException localJSONException) {}
/*    */     
/* 50 */     return localJSONObject;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\c\dislike.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */