/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */ 
/*     */

/*     */ import android.content.ContentUris;
/*     */ import android.content.ContentValues;
/*     */ import android.content.Context;
/*     */ import android.media.MediaScannerConnection;
/*     */
        /*     */ import android.net.Uri;
/*     */ import android.os.Bundle;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.os.SystemClock;
/*     */ import android.text.TextUtils;
/*     */ import android.util.Log;
/*     */ import com.bytedance.sdk.openadsdk.ggg.MineHandler;
/*     */
        /*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */   implements MediaScannerConnection.MediaScannerConnectionClient, MineHandler.OnResult
/*     */ {
/*     */   private final Context b;
/*     */   private final MediaScannerConnection c;
/*  31 */   protected final MineHandler a = new MineHandler(Looper.getMainLooper(), this);
/*     */   
/*     */   private static class a {
/*     */     public final long a;
/*     */     public final String b;
/*     */     public final String c;
/*     */     public final long d;
/*     */     
/*     */     public a(long paramLong, String paramString1, String paramString2) {
/*  40 */       this.a = paramLong;
/*  41 */       this.b = paramString1;
/*  42 */       this.c = paramString2;
/*  43 */       this.d = SystemClock.elapsedRealtime();
/*     */     }
/*     */     
/*     */     public void a(MediaScannerConnection paramMediaScannerConnection) {
/*  47 */       paramMediaScannerConnection.scanFile(this.b, this.c);
/*     */     }
/*     */   }
/*     */   
/*  51 */   private HashMap<String, a> d = new HashMap();
/*     */   
/*     */   public j(Context paramContext) {
/*  54 */     this.b = paramContext;
/*  55 */     this.c = new MediaScannerConnection(paramContext, this);
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
/*     */   public void a(d paramd)
/*     */   {
///*  86 */     if (bee.VideoManager) Log.TTAndroidObject("SsAndroidDownloadManager", "requestScan() for " + paramd.TTBannerAdImpl);
/*  87 */     synchronized (this.c) {
/*  88 */       a locala = new a(paramd.a, paramd.e, paramd.f);
/*  89 */       this.d.put(locala.b, locala);
/*     */       
/*  91 */       if (this.c.isConnected()) {
/*  92 */         locala.a(this.c);
/*     */       } else {
/*  94 */         this.c.connect();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void a() {
/* 100 */     this.c.disconnect();
/*     */   }
/*     */   
/*     */   public void onMediaScannerConnected()
/*     */   {
/* 105 */     synchronized (this.c) {
/* 106 */       for (a locala : this.d.values()) {
/* 107 */         locala.a(this.c);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onScanCompleted(String paramString, Uri paramUri)
/*     */   {
/* 114 */     Message localMessage = this.a.obtainMessage();
/* 115 */     Bundle localBundle = new Bundle();
/* 116 */     localBundle.putString("path", paramString);
/* 117 */     localBundle.putString("uri", paramUri.toString());
/* 118 */     localMessage.setData(localBundle);
/* 119 */     this.a.sendMessage(localMessage);
/*     */   }
/*     */   
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 124 */     if (paramMessage == null) {
/* 125 */       return;
/*     */     }
/* 127 */     Bundle localBundle = paramMessage.getData();
/* 128 */     if (localBundle == null) {
/* 129 */       return;
/*     */     }
/* 131 */     String str1 = localBundle.getString("path");
/* 132 */     String str2 = localBundle.getString("uri");
/* 133 */     if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
/* 134 */       return;
/*     */     }
/* 136 */     Uri localUri1 = Uri.parse(str2);
/*     */     a locala;
/* 138 */     synchronized (this.c) {
/* 139 */       locala = (a)this.d.remove(str1);
/*     */     }
/* 141 */     if (locala == null) {
/* 142 */       Log.w("SsAndroidDownloadManager", "Missing request for path " + str1);
/* 143 */       return;
/*     */     }
/*     */     
/*     */ 
/* 147 */    ContentValues contentValues = new ContentValues();
/* 148 */     ((ContentValues)contentValues).put("scanned", Integer.valueOf(1));
/* 149 */     if (localUri1 != null) {
/* 150 */       ((ContentValues)contentValues).put("mediaprovider_uri", localUri1.toString());
/*     */     }
/*     */     
/* 153 */     i locali = i.a(this.b);
/* 154 */     Uri localUri2 = ContentUris.withAppendedId(m.a.a, locala.a);
/*     */     
/* 156 */     int i = locali.a(localUri2, (ContentValues)contentValues, null, null);
/* 157 */     if (i == 0)
/*     */     {
/*     */ 
/* 160 */       if (this.b != null) {
/* 161 */         this.b.getContentResolver().delete(localUri1, null, null);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\mTTFeedAd.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */