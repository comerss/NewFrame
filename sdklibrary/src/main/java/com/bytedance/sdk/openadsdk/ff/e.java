/*    */ package com.bytedance.sdk.openadsdk.ff;
/*    */ 
/*    */ import android.content.ContentValues;
/*    */ import android.content.Context;
/*    */ import android.database.Cursor;
/*    */ import android.support.annotation.VisibleForTesting;
/*    */ import com.bytedance.sdk.openadsdk.core.eeee.c;
/*    */ import java.util.LinkedList;
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
/*    */ public class e
/*    */   implements d
/*    */ {
/*    */   @VisibleForTesting
/*    */   com.bytedance.sdk.openadsdk.core.d a;
/*    */   
/*    */   public e(Context paramContext)
/*    */   {
/* 30 */     this.a = com.bytedance.sdk.openadsdk.core.d.a(paramContext.getApplicationContext());
/*    */   }
/*    */   
/*    */   public List<c> a()
/*    */   {
/* 35 */     LinkedList localLinkedList = new LinkedList();
/* 36 */     Cursor localCursor = this.a.a().a("trackurl", null, null, null, null, null, null);
/*    */     try {
/* 38 */       while (localCursor.moveToNext()) {
/* 39 */         String str1 = localCursor.getString(localCursor.getColumnIndex("id"));
/* 40 */         String str2 = localCursor.getString(localCursor.getColumnIndex("url"));
/* 41 */         boolean bool = localCursor.getInt(localCursor.getColumnIndex("replaceholder")) > 0;
/* 42 */         int i = localCursor.getInt(localCursor.getColumnIndex("retry"));
/* 43 */         localLinkedList.add(new c(str1, str2, bool, i));
/*    */       }
/*    */     } finally {
/* 46 */       localCursor.close();
/*    */     }
/* 48 */     return localLinkedList;
/*    */   }
/*    */   
/*    */   public void a(c paramc)
/*    */   {
/* 53 */     ContentValues localContentValues = new ContentValues();
/* 54 */     localContentValues.put("id", paramc.a());
/* 55 */     localContentValues.put("url", paramc.b());
/* 56 */     localContentValues.put("replaceholder", Integer.valueOf(paramc.c() ? 1 : 0));
/* 57 */     localContentValues.put("retry", Integer.valueOf(paramc.d()));
/* 58 */     this.a.a().a("trackurl", null, localContentValues);
/*    */   }
/*    */   
/*    */   public void b(c paramc)
/*    */   {
/* 63 */     ContentValues localContentValues = new ContentValues();
/* 64 */     localContentValues.put("id", paramc.a());
/* 65 */     localContentValues.put("url", paramc.b());
/* 66 */     localContentValues.put("replaceholder", Integer.valueOf(paramc.c() ? 1 : 0));
/* 67 */     localContentValues.put("retry", Integer.valueOf(paramc.d()));
/* 68 */     this.a.a().a("trackurl", localContentValues, "id=?", new String[] { paramc.a() });
/*    */   }
/*    */   
/*    */   public void c(c paramc)
/*    */   {
/* 73 */     this.a.a().a("trackurl", "id=?", new String[] { paramc.a() });
/*    */   }
/*    */   
/*    */   public static String b() {
/* 77 */     return 
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 84 */       "CREATE TABLE IF NOT EXISTS " + "trackurl" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," + "id" + " TEXT UNIQUE," + "url" + " TEXT ," + "replaceholder" + " INTEGER default 0, " + "retry" + " INTEGER default 0" + ")";
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\f\eee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */