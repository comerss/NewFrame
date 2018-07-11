/*     */ package com.bytedance.sdk.openadsdk.dddd;
/*     */ 
/*     */ import android.content.ContentValues;
/*     */ import android.content.Context;
/*     */ import android.database.Cursor;
/*     */ import android.support.annotation.VisibleForTesting;
/*     */ import android.text.TextUtils;
/*     */
/*     */
/*     */ import com.bytedance.sdk.openadsdk.ggg.k;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.json.JSONException;
/*     */ import org.json.JSONObject;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   implements d<a>
/*     */ {
/*     */   private Context b;
/*     */   @VisibleForTesting
/*     */   com.bytedance.sdk.openadsdk.core.d a;
/*     */   private c c;
/*     */   
/*     */   public e(Context paramContext)
/*     */   {
/*  39 */     this.b = paramContext.getApplicationContext();
/*  40 */     this.a = com.bytedance.sdk.openadsdk.core.d.a(this.b);
/*  41 */     this.c = c.a(paramContext);
/*     */   }
/*     */   
/*     */   public List<a> a()
/*     */   {
/*  46 */     LinkedList localLinkedList = new LinkedList();
/*  47 */     Cursor localCursor = this.a.a().a("adevent", new String[] { "id", "value" }, null, null, null, null, null);
/*     */     try {
/*  49 */       while (localCursor.moveToNext()) {
/*  50 */         String str1 = localCursor.getString(localCursor.getColumnIndex("id"));
/*  51 */         String str2 = localCursor.getString(localCursor.getColumnIndex("value"));
/*     */         try {
/*  53 */           JSONObject localJSONObject = new JSONObject(str2);
/*  54 */           localLinkedList.add(new a(str1, localJSONObject));
/*     */         }
/*     */         catch (JSONException localJSONException) {}
/*     */       }
/*     */     } finally {
/*  59 */       localCursor.close();
/*     */     }
/*  61 */     return localLinkedList;
/*     */   }
/*     */   
/*     */   public void a(a parama)
/*     */   {
/*  66 */     ContentValues localContentValues = new ContentValues();
/*  67 */     localContentValues.put("id", parama.a);
/*  68 */     localContentValues.put("value", parama.b.toString());
/*  69 */     localContentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
/*  70 */     localContentValues.put("retry", Integer.valueOf(0));
/*  71 */     this.a.a().a("adevent", null, localContentValues);
/*     */   }
/*     */   
/*     */   public void a(List<a> paramList)
/*     */   {
/*  76 */     if (k.a(paramList)) {
/*  77 */       return;
/*     */     }
/*  79 */     LinkedList localLinkedList = new LinkedList();
/*  80 */     for (Object localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { a locala = (a)((Iterator)localObject).next();
/*  81 */       localLinkedList.add(locala.a);
/*     */     }
/*  83 */     localObject = "DELETE FROM adevent WHERE " + a("id", localLinkedList, 1000, true);
/*  84 */     this.a.a().a((String)localObject);
/*     */   }
/*     */   
/*     */   public void a(int paramInt, long paramLong)
/*     */   {
/*  89 */     b(paramInt, paramLong);
/*     */   }
/*     */   
/*     */   private void b(int paramInt, long paramLong) {
/*  93 */     long l = System.currentTimeMillis() - paramLong;
/*  94 */     this.a.a().a("adevent", "gen_time <? AND retry >?", new String[] { l + "", paramInt + "" });
/*     */   }
/*     */   
/*     */   public void a(List<a> paramList, int paramInt, long paramLong)
/*     */   {
/*  99 */     if (k.a(paramList)) {
/* 100 */       return;
/*     */     }
/* 102 */     this.a.a().a();
/*     */     try {
/* 104 */       b(paramList);
/* 105 */       b(paramInt, paramLong);
/* 106 */       this.a.a().b();
/*     */     }
/*     */     catch (Exception localException) {}finally
/*     */     {
/* 110 */       this.a.a().c();
/*     */     }
/*     */   }
/*     */   
/*     */   @VisibleForTesting
/*     */   void b(List<a> paramList)
/*     */   {
/* 117 */     LinkedList localLinkedList = new LinkedList();
/* 118 */     for (Object localObject = paramList.iterator(); ((Iterator)localObject).hasNext();) { a locala = (a)((Iterator)localObject).next();
/* 119 */       localLinkedList.add(locala.a);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */     localObject = "UPDATE " + "adevent" + " SET " + "retry" + " = " + "retry" + "+1" + " WHERE " + a("id", localLinkedList, 1000, true);
/* 132 */     this.a.a().a((String)localObject);
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean)
/*     */   {
/* 137 */     this.c.a("serverbusy_flag", paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean b()
/*     */   {
/* 142 */     return this.c.b("serverbusy_flag", false);
/*     */   }
/*     */   
/*     */   public int c()
/*     */   {
/* 147 */     return this.c.b("serverbusy_retrycount", 0);
/*     */   }
/*     */   
/*     */   public void a(int paramInt)
/*     */   {
/* 152 */     this.c.a("serverbusy_retrycount", paramInt);
/*     */   }
/*     */   
/*     */   public static String d() {
/* 156 */     return 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */       "CREATE TABLE IF NOT EXISTS " + "adevent" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "value" + " TEXT ," + "gen_time" + " TEXT , " + "retry" + " INTEGER default 0" + ")";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(String paramString, List<?> paramList, int paramInt, boolean paramBoolean)
/*     */   {
/* 206 */     String str1 = paramBoolean ? " IN " : " NOT IN ";
/* 207 */     String str2 = paramBoolean ? " OR " : " AND ";
/*     */     
/* 209 */     paramInt = Math.min(paramInt, 1000);
/* 210 */     int i = paramList.size();
/* 211 */     int j = i % paramInt;
/* 212 */     if (j == 0) {
/* 213 */       j = i / paramInt;
/*     */     } else {
/* 215 */       j = i / paramInt + 1;
/*     */     }
/* 217 */     StringBuilder localStringBuilder = new StringBuilder();
/* 218 */     for (int k = 0; k < j; k++) {
/* 219 */       int m = k * paramInt;
/* 220 */       int n = Math.min(m + paramInt, i);
/* 221 */       String str4 = a(TextUtils.join("','", paramList.subList(m, n)), "");
/* 222 */       if (k != 0) {
/* 223 */         localStringBuilder.append(str2);
/*     */       }
/* 225 */       localStringBuilder.append(paramString).append(str1 + "('").append(str4).append("')");
/*     */     }
/* 227 */     String str3 = a(localStringBuilder.toString(), paramString + str1 + "('')");
/* 228 */     return str3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String a(String paramString1, String paramString2)
/*     */   {
/* 239 */     return !TextUtils.isEmpty(paramString1) ? paramString1 : paramString2;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\d\eee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */