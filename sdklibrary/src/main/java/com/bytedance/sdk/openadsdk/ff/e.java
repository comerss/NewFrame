/*    */ package com.bytedance.sdk.openadsdk.ff;
/*    */ 
/*    */ import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.VisibleForTesting;

import java.util.LinkedList;
import java.util.List;

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
/*    */   public List<com.bytedance.sdk.openadsdk.ff.c> a()
/*    */   {
/* 35 */    LinkedList var1 = new LinkedList();
    Cursor var2 = this.a.a().a("trackurl", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);

    try {
        while(var2.moveToNext()) {
            String var3 = var2.getString(var2.getColumnIndex("id"));
            String var4 = var2.getString(var2.getColumnIndex("url"));
            boolean var5 = var2.getInt(var2.getColumnIndex("replaceholder")) > 0;
            int var6 = var2.getInt(var2.getColumnIndex("retry"));
            var1.add(new com.bytedance.sdk.openadsdk.ff.c(var3, var4, var5, var6));
        }
    } finally {
        var2.close();
    }

    return var1;
/*    */   }
/*    */   
/*    */   public void a(com.bytedance.sdk.openadsdk.ff.c paramc)
/*    */   {
/* 53 */     ContentValues localContentValues = new ContentValues();
/* 54 */     localContentValues.put("id", paramc.a());
/* 55 */     localContentValues.put("url", paramc.b());
/* 56 */     localContentValues.put("replaceholder", Integer.valueOf(paramc.c() ? 1 : 0));
/* 57 */     localContentValues.put("retry", Integer.valueOf(paramc.d()));
/* 58 */     this.a.a().a("trackurl", null, localContentValues);
/*    */   }
/*    */   
/*    */   public void b(com.bytedance.sdk.openadsdk.ff.c paramc)
/*    */   {
/* 63 */     ContentValues localContentValues = new ContentValues();
/* 64 */     localContentValues.put("id", paramc.a());
/* 65 */     localContentValues.put("url", paramc.b());
/* 66 */     localContentValues.put("replaceholder", Integer.valueOf(paramc.c() ? 1 : 0));
/* 67 */     localContentValues.put("retry", Integer.valueOf(paramc.d()));
/* 68 */     this.a.a().a("trackurl", localContentValues, "id=?", new String[] { paramc.a() });
/*    */   }

    /*    */
/*    */   public void c(com.bytedance.sdk.openadsdk.ff.c paramc)
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


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\doErrorHelper\eee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */