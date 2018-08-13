/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.content.Context;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Locale;
/*    */ import org.json.JSONObject;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class i
/*    */   implements f.a
/*    */ {
/*    */   private static volatile i a;
/*    */   private Context b;
/*    */   private f c;
/*    */   private k d;
/*    */   private long e;
/*    */   
/*    */   static i b()
/*    */   {
/* 24 */     if (a == null)
/* 25 */       throw new IllegalArgumentException("CrashInfoManager not inited");
/* 26 */     return a;
/*    */   }
/*    */   
/* 29 */   static void a(Context paramContext, j.a parama) { if (a == null)
/* 30 */       synchronized (i.class) {
/* 31 */         a = new i(paramContext, parama);
/*    */       }
/*    */   }
/*    */   
/*    */   private i(Context paramContext, j.a parama) {
/* 36 */     this.b = paramContext.getApplicationContext();
/* 37 */     this.e = System.currentTimeMillis();
/* 38 */     this.c = new f(this.b, this);
/* 39 */     this.d = new k(this.b, parama);
/*    */   }
/*    */   
/*    */   public void a(JSONObject paramJSONObject) throws Throwable {
/* 43 */     if ((paramJSONObject == null) || (paramJSONObject.length() <= 0) || (this.d == null) || (this.c == null))
/* 44 */       return;
/* 45 */     paramJSONObject.put("last_create_activity", this.c.b());
/* 46 */     paramJSONObject.put("last_resume_activity", this.c.c());
/* 47 */     paramJSONObject.put("app_start_time", this.e);
/* 48 */     SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.US);
/* 49 */     String str = localSimpleDateFormat.format(new Date(this.e));
/* 50 */     paramJSONObject.put("app_start_time_readable", str);
/* 51 */     paramJSONObject.put("alive_activities", this.c.a());
/* 52 */     paramJSONObject.put("running_task_info", this.c.d());
/* 53 */     this.d.a(paramJSONObject);
/*    */   }
/*    */   
/*    */   public void a() {
/* 57 */     if (this.d != null) {
/* 58 */       this.d.a();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\mOnClick.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */