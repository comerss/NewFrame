/*    */ package com.bytedance.sdk.openadsdk.core.eeee;
/*    */ 
/*    */

/*    */ import android.content.SharedPreferences;
/*    */
        /*    */ import android.support.annotation.NonNull;
/*    */ import com.bytedance.sdk.openadsdk.core.n;
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
/*    */ 
/*    */ public class c
/*    */   implements a
/*    */ {
/*    */   private String a;
/* 28 */   private long b = 10000L;
/* 29 */   private int c = 50;
/*    */   
/*    */   public void a()
/*    */   {
/* 33 */     SharedPreferences localSharedPreferences = f();
/* 34 */     this.a = localSharedPreferences.getString("xpath", "");
/* 35 */     this.b = localSharedPreferences.getLong("duration", 10000L);
/* 36 */     this.c = localSharedPreferences.getInt("max", 50);
/*    */   }
/*    */   
/*    */   public void a(@NonNull JSONObject paramJSONObject)
/*    */   {
/* 41 */     this.a = paramJSONObject.optString("xpath");
/* 42 */     JSONObject localJSONObject = paramJSONObject.optJSONObject("feq_policy");
/* 43 */     this.b = (localJSONObject.optLong("duration") * 1000L);
/* 44 */     this.c = localJSONObject.optInt("max");
/*    */     
/* 46 */     e();
/*    */   }
/*    */   
/*    */   private void e() {
/* 50 */     SharedPreferences.Editor localEditor = f().edit();
/* 51 */     localEditor.putString("xpath", this.a);
/* 52 */     localEditor.putLong("duration", this.b);
/* 53 */     localEditor.putInt("max", this.c);
/* 54 */     localEditor.apply();
/*    */   }
/*    */   
/*    */   private SharedPreferences f() {
/* 58 */     return n.a().getSharedPreferences("tt_sdk_settings", 0);
/*    */   }
/*    */   
/*    */   public String b() {
/* 62 */     return this.a;
/*    */   }
/*    */   
/*    */   public long c() {
/* 66 */     return this.b;
/*    */   }
/*    */   
/*    */   public int d() {
/* 70 */     return this.c;
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\eee\cdsss.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */