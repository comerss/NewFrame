/*    */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.d;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.bytedance.sdk.openadsdk.g.n;
/*    */ import com.bytedance.sdk.openadsdk.g.n.a;
/*    */ import java.util.Iterator;
/*    */ import java.util.UUID;
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
/*    */ public class a
/*    */ {
/*    */   public final String a;
/*    */   public final JSONObject b;
/*    */   
/*    */   a(String paramString, JSONObject paramJSONObject)
/*    */   {
/* 27 */     this.a = paramString;
/* 28 */     this.b = paramJSONObject;
/*    */   }
/*    */   
/*    */   static a a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
/* 32 */     JSONObject localJSONObject = new JSONObject();
/*    */     try {
/* 34 */       localJSONObject.putOpt("log_extra", paramString4);
/*    */     }
/*    */     catch (JSONException localJSONException) {}
/*    */     
/* 38 */     return new a(UUID.randomUUID().toString(), b(paramContext, paramString1, paramString2, paramString3, localJSONObject));
/*    */   }
/*    */   
/*    */   static a a(Context paramContext, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
/* 42 */     return new a(UUID.randomUUID().toString(), b(paramContext, paramString1, paramString2, paramString3, paramJSONObject));
/*    */   }
/*    */   
/*    */   static a a(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
/* 46 */     return new a(UUID.randomUUID().toString(), b(paramString1, paramString2, paramString3, paramLong1, paramLong2, paramJSONObject));
/*    */   }
/*    */   
/*    */   private static JSONObject b(Context paramContext, String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject) {
/* 50 */     JSONObject localJSONObject = new JSONObject();
/*    */     try {
/* 52 */       localJSONObject.putOpt("tag", paramString1);
/* 53 */       localJSONObject.putOpt("label", paramString2);
/* 54 */       localJSONObject.putOpt("category", "app_union");
/*    */       try {
/* 56 */         localJSONObject.putOpt("value", Long.valueOf(Long.parseLong(paramString3)));
/*    */       } catch (NumberFormatException localNumberFormatException) {
/* 58 */         localJSONObject.putOpt("value", Long.valueOf(0L));
/*    */       }
/* 60 */       localJSONObject.putOpt("is_ad_event", "1");
/* 61 */       localJSONObject.putOpt("nt", Integer.valueOf(n.b(paramContext).a()));
/* 62 */       if (paramJSONObject != null) {
/* 63 */         Iterator localIterator = paramJSONObject.keys();
/* 64 */         while (localIterator.hasNext()) {
/* 65 */           String str = (String)localIterator.next();
/* 66 */           Object localObject = paramJSONObject.opt(str);
/* 67 */           localJSONObject.putOpt(str, localObject);
/*    */         }
/*    */       }
/*    */     } catch (Exception localException) {}
/* 71 */     return localJSONObject;
/*    */   }
/*    */   
/*    */   private static JSONObject b(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, JSONObject paramJSONObject) {
/* 75 */     JSONObject localJSONObject = new JSONObject();
/*    */     try {
/* 77 */       localJSONObject.putOpt("tag", paramString2);
/* 78 */       localJSONObject.putOpt("label", paramString3);
/* 79 */       localJSONObject.putOpt("category", paramString1);
/* 80 */       localJSONObject.putOpt("value", Long.valueOf(paramLong1));
/* 81 */       localJSONObject.putOpt("ext_value", Long.valueOf(paramLong2));
/* 82 */       if (paramJSONObject != null) {
/* 83 */         Iterator localIterator = paramJSONObject.keys();
/* 84 */         while (localIterator.hasNext()) {
/* 85 */           String str = (String)localIterator.next();
/* 86 */           Object localObject = paramJSONObject.opt(str);
/* 87 */           localJSONObject.putOpt(str, localObject);
/*    */         }
/*    */       }
/*    */     }
/*    */     catch (Exception localException) {}
/* 92 */     return localJSONObject;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\d\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */