/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
/*     */ class e
/*     */ {
/*     */   private c b;
/*     */   protected Context a;
/*  27 */   private static final Object c = new Object();
/*     */   
/*     */   e(Context paramContext) {
/*  30 */     this.a = paramContext.getApplicationContext();
/*  31 */     if (this.b == null) {
/*  32 */       this.b = new c();
/*     */     }
/*     */   }
/*     */   
/*     */   public class c {
/*  37 */     private SQLiteDatabase b = null;
/*     */     
/*     */     public c() {}
/*     */     
/*  41 */     private void e() { try { synchronized (c.getClass()) {
/*  42 */           if ((this.b == null) || (!this.b.isOpen())) {
/*  43 */             e.aHelper locala = new e.aHelper(a);
/*  44 */             this.b = locala.getWritableDatabase();
/*  45 */             this.b.setLockingEnabled(false);
/*     */           }
/*     */         }
/*     */       } catch (Throwable localThrowable) {
/*  49 */         localThrowable.printStackTrace();
/*  50 */         if (d()) {
/*  51 */           throw localThrowable;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void a(String paramString) throws SQLException
/*     */     {
/*     */       try {
/*  59 */         e();
/*  60 */         this.b.execSQL(paramString);
/*     */       } catch (Throwable localThrowable) {
/*  62 */         if (d()) {
/*  63 */           throw localThrowable;
/*     */         }
/*     */       }
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
/*     */     public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
/*     */     {
/*     */       Object localObject;
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
/*     */       try
/*     */       {
/* 117 */         e();
/* 118 */         localObject = this.b.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
/*     */       } catch (Throwable localThrowable) {
/* 120 */         localThrowable.printStackTrace();
/* 121 */         localObject = new e.b();
/* 122 */         if (d()) {
/* 123 */           throw localThrowable;
/*     */         }
/*     */       }
/* 126 */       return (Cursor)localObject;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
/*     */     {
/*     */       int i;
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
/*     */       try
/*     */       {
/* 165 */         e();
/* 166 */         i = this.b.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
/*     */       } catch (Exception localException) {
/* 168 */         localException.printStackTrace();
/* 169 */         i = 0;
/* 170 */         if (d()) {
/* 171 */           throw localException;
/*     */         }
/*     */       }
/* 174 */       return i;
/*     */     }
/*     */     
/*     */     public long a(String paramString1, String paramString2, ContentValues paramContentValues) {
/*     */       long l;
/*     */       try {
/* 180 */         e();
/* 181 */         l = this.b.insert(paramString1, paramString2, paramContentValues);
/*     */       } catch (Exception localException) {
/* 183 */         localException.printStackTrace();
/* 184 */         l = -1L;
/* 185 */         if (d()) {
/* 186 */           throw localException;
/*     */         }
/*     */       }
/* 189 */       return l;
/*     */     }
/*     */     
/*     */     public int a(String paramString1, String paramString2, String[] paramArrayOfString) {
/*     */       int i;
/*     */       try {
/* 195 */         e();
/* 196 */         i = this.b.delete(paramString1, paramString2, paramArrayOfString);
/*     */       } catch (Exception localException) {
/* 198 */         localException.printStackTrace();
/* 199 */         i = 0;
/* 200 */         if (d()) {
/* 201 */           throw localException;
/*     */         }
/*     */       }
/* 204 */       return i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */     public void a()
/*     */     {
/* 221 */       e();
/* 222 */       this.b.beginTransaction();
/*     */     }
/*     */     
/*     */     public void b() {
/* 226 */       e();
/* 227 */       this.b.setTransactionSuccessful();
/*     */     }
/*     */     
/*     */     public void c() {
/* 231 */       e();
/* 232 */       this.b.endTransaction();
/*     */     }
/*     */     
/*     */     public boolean d() {
/* 236 */       SQLiteDatabase localSQLiteDatabase = this.b;
/* 237 */       return (localSQLiteDatabase != null) && (localSQLiteDatabase.inTransaction());
/*     */     }
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
/*     */   protected class aHelper
/*     */     extends SQLiteOpenHelper
/*     */   {
/* 255 */     Context a = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public aHelper(Context paramContext)
/*     */     {
/* 263 */       super(paramContext,"ttopensdk.db", null, 1);
/* 264 */       this.a = paramContext;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onCreate(SQLiteDatabase paramSQLiteDatabase)
/*     */     {
/* 272 */       a(paramSQLiteDatabase, this.a);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void a(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
/*     */     {
/* 279 */       paramSQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.dddd.e.d());
/* 280 */       paramSQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.ff.e.b());
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
/*     */     public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
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
/*     */   public c a()
/*     */   {
/* 343 */     return this.b;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public class b
/*     */     extends AbstractCursor
/*     */   {
/*     */     public b() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 364 */       return 0;
/*     */     }
/*     */     
/*     */     public String[] getColumnNames()
/*     */     {
/* 369 */       return new String[0];
/*     */     }
/*     */     
/*     */     public String getString(int paramInt)
/*     */     {
/* 374 */       return null;
/*     */     }
/*     */     
/*     */     public short getShort(int paramInt)
/*     */     {
/* 379 */       return 0;
/*     */     }
/*     */     
/*     */     public int getInt(int paramInt)
/*     */     {
/* 384 */       return 0;
/*     */     }
/*     */     
/*     */     public long getLong(int paramInt)
/*     */     {
/* 389 */       return 0L;
/*     */     }
/*     */     
/*     */     public float getFloat(int paramInt)
/*     */     {
/* 394 */       return 0.0F;
/*     */     }
/*     */     
/*     */     public double getDouble(int paramInt)
/*     */     {
/* 399 */       return 0.0D;
/*     */     }
/*     */     
/*     */     public boolean isNull(int paramInt)
/*     */     {
/* 404 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\eee.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */