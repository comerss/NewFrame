/*    */ package com.bytedance.sdk.openadsdk.core.eeee;
/*    */ 
/*    */ import android.content.Context;
/*    */ import com.androidquery.AQuery;
/*    */ import com.androidquery.callback.AjaxCallback;
/*    */ import com.androidquery.callback.AjaxStatus;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class bee
/*    */ {
/*    */   private com.bytedance.sdk.openadsdk.core.eeee.a a;
/*    */   private Context b;
/*    */   
/*    */   public bee(a parama)
/*    */   {
/* 23 */     this.a = parama;
/* 24 */     this.b = com.bytedance.sdk.openadsdk.core.n.a();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void a()
/*    */   {
/* 31 */     boolean bool = com.bytedance.sdk.openadsdk.ggg.n.a(this.b);
/* 32 */     if (!bool) {
/* 33 */       this.a.a();
/*    */     } else {
/* 35 */       AQuery localAQuery = new AQuery(this.b);
/* 36 */       localAQuery.ajax("http://i.snssdk.com/api/ad/union/sdk/config/", JSONObject.class, new AjaxCallback()
/*    */       {
/*    */         public void callback(String paramAnonymousString, JSONObject paramAnonymousJSONObject, AjaxStatus paramAnonymousAjaxStatus) {
/* 39 */           super.callback(paramAnonymousString, paramAnonymousJSONObject, paramAnonymousAjaxStatus);
/* 40 */           if ((paramAnonymousAjaxStatus.getCode() == 200) && (paramAnonymousJSONObject != null)) {
/* 41 */            a.a(paramAnonymousJSONObject);
/*    */           } else {
/* 43 */             a.a();
/*    */           }
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\eee\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */