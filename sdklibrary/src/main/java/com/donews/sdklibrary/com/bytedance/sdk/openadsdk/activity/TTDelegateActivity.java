/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.activity;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.AlertDialog.Builder;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnCancelListener;
/*     */ import android.content.DialogInterface.OnClickListener;
/*     */ import android.content.Intent;
/*     */ import android.database.Cursor;
/*     */ import android.net.Uri;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Bundle;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.text.TextUtils;
/*     */ import android.view.Window;
/*     */ import android.view.WindowManager.LayoutParams;
/*     */ import android.widget.Toast;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.R.style;
/*     */ import com.bytedance.sdk.openadsdk.c.b.d;
/*     */ import com.bytedance.sdk.openadsdk.c.b.e;
/*     */ import com.bytedance.sdk.openadsdk.c.f;
/*     */ import com.bytedance.sdk.openadsdk.c.g;
/*     */ import com.bytedance.sdk.openadsdk.c.x;
/*     */ import com.bytedance.sdk.openadsdk.core.h;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.e.a;
/*     */ import com.bytedance.sdk.openadsdk.e.c;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.q;
/*     */ import java.net.URL;
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
/*     */ public class TTDelegateActivity
/*     */   extends Activity
/*     */ {
/*     */   private Intent a;
/*     */   
/*     */   protected void onCreate(@Nullable Bundle paramBundle)
/*     */   {
/*  61 */     super.onCreate(paramBundle);
/*  62 */     a();
/*  63 */     this.a = getIntent();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a()
/*     */   {
/*  71 */     if (h.a().k()) {
/*  72 */       getWindow().addFlags(2621440);
/*     */     }
/*     */     
/*     */ 
/*  76 */     Window localWindow = getWindow();
/*  77 */     WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
/*  78 */     localLayoutParams.alpha = 0.0F;
/*  79 */     localWindow.setAttributes(localLayoutParams);
/*     */   }
/*     */   
/*     */   protected void onNewIntent(Intent paramIntent)
/*     */   {
/*  84 */     super.onNewIntent(paramIntent);
/*  85 */     setIntent(paramIntent);
/*     */   }
/*     */   
/*     */   protected void onResume()
/*     */   {
/*  90 */     super.onResume();
/*  91 */     Intent localIntent = getIntent();
/*  92 */     if (localIntent != null) {
/*  93 */       setIntent(null);
/*  94 */       b();
/*     */     }
/*     */   }
/*     */   
/*     */   private void b() {
/*  99 */     int i = this.a.getIntExtra("type", 0);
/* 100 */     String str1 = this.a.getStringExtra("app_download_url");
/* 101 */     String str2 = this.a.getStringExtra("app_name");
/* 102 */     if (i == 1) {
/* 103 */       a(str1, str2);
/* 104 */     } else if (i == 2)
/*     */     {
/* 106 */       c();
/*     */     }
/*     */     else
/*     */     {
/* 110 */       d();
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(final String paramString1, String paramString2)
/*     */   {
/* 116 */     int i = Build.VERSION.SDK_INT >= 21 ? R.style.Theme_Dialog_TTDownload : R.style.Theme_Dialog_TTDownloadOld;
/*     */     
/* 118 */     AlertDialog.Builder localBuilder = new AlertDialog.Builder(this, i);
/*     */     String str;
/* 120 */     if (!q.a(paramString2)) {
/* 121 */       str = String.format(getString(R.string.tt_confirm_download_have_app_name), new Object[] { paramString2 });
/*     */     } else {
/* 123 */       str = getString(R.string.tt_confirm_download);
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
/* 142 */     localBuilder.setTitle(getString(R.string.tt_tip)).setMessage(str).setPositiveButton(getString(R.string.tt_label_ok), new OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 130 */         x.a(paramString1, 1);
/* 131 */         TTDelegateActivity.this.finish();
/*     */       }
/*     */       
/* 134 */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       ).setNegativeButton(getString(R.string.tt_label_cancel), new OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
/* 137 */           x.a(paramString1, 2);
/* 138 */           TTDelegateActivity.this.finish(); } })
/*     */       
/*     */ 
/*     */ 
/* 142 */       .setOnCancelListener(new OnCancelListener()
/*     */       {
/*     */ 
/*     */ 
/*     */         public void onCancel(DialogInterface paramAnonymousDialogInterface)
/*     */         {
/*     */ 
/* 145 */           x.a(paramString1, 2);
/* 146 */           TTDelegateActivity.this.finish();
/*     */         }
/*     */         
/* 149 */       });
/* 150 */     localBuilder.show();
/*     */   }
/*     */   
/*     */   private void c() {
/* 154 */     if (Build.VERSION.SDK_INT >= 23) {
/*     */       try {
/* 156 */         d.a().a(this, new String[] { "android.permission.READ_PHONE_STATE", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" }, new e()
/*     */         {
/*     */ 
/*     */           public void a()
/*     */           {
/* 161 */             com.bytedance.sdk.openadsdk.core.i.j(n.a());
/* 162 */             TTDelegateActivity.this.finish();
/*     */           }
/*     */           
/*     */           public void a(String paramAnonymousString) {
/* 166 */             if ("android.permission.READ_PHONE_STATE".equals(paramAnonymousString)) {
/* 167 */               Toast.makeText(TTDelegateActivity.this, R.string.tt_permission_denied, 0).show();
/*     */             }
/* 169 */             com.bytedance.sdk.openadsdk.core.i.j(n.a());
/* 170 */             TTDelegateActivity.this.finish();
/*     */           }
/*     */         });
/*     */       } catch (Exception localException) {
/* 174 */         finish();
/*     */       }
/*     */     } else {
/* 177 */       m.b("TT_AD_SDK", "已经有Read phone state权限");
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
/*     */   private void d()
/*     */   {
/* 209 */     boolean bool = e();
/* 210 */     if (!bool) {
/* 211 */       finish();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean e() {
/* 216 */     if (this.a == null) {
/* 217 */       return false;
/*     */     }
/* 219 */     Uri localUri = this.a.getData();
/* 220 */     if (localUri == null) {
/* 221 */       return false;
/*     */     }
/* 223 */     Cursor localCursor = com.bytedance.sdk.openadsdk.c.i.a(getApplicationContext()).a(localUri, null, null, null, null);
/* 224 */     if (localCursor == null) {
/* 225 */       return false;
/*     */     }
/* 227 */     String str1 = null;
/*     */     final long l;
/*     */     String str2;
/*     */     final int i;
/*     */     try
/*     */     {
/* 233 */       if (localCursor.moveToFirst()) {
/* 234 */         str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("title"));
/* 235 */         l = localCursor.getLong(localCursor.getColumnIndexOrThrow("_id"));
/* 236 */         str2 = new URL(localCursor.getString(localCursor.getColumnIndexOrThrow("uri"))).toString();
/* 237 */         i = localCursor.getInt(localCursor.getColumnIndex("status"));
/*     */       } else {
/* 239 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       try
/*     */       {
/* 246 */         localCursor.close();
/*     */       } catch (Exception localException1) {
/* 248 */         localException1.printStackTrace();
/*     */       }
/*     */       
/* 251 */       if (!TextUtils.isEmpty(str1)) {
/*     */         break label239;
/*     */       }
/*     */     }
/*     */     catch (Exception localException2)
/*     */     {
/* 242 */       localException2.printStackTrace();
/* 243 */       return false;
/*     */     } finally {
/*     */       try {
/* 246 */         localCursor.close();
/*     */       } catch (Exception localException5) {
/* 248 */         localException5.printStackTrace();
/*     */       }
/*     */     }
/*     */     
/* 252 */     m.b("TT_AD_SDK", "Missing appName; skipping handle");
/* 253 */     return false;
/*     */     label239:
/* 255 */     String str3 = String.format(getString(R.string.tt_confirm_delete), new Object[] { str1 });
/*     */     
/* 257 */     int j = Build.VERSION.SDK_INT >= 21 ? R.style.Theme_Dialog_TTDownload : R.style.Theme_Dialog_TTDownloadOld;
/*     */     
/* 259 */     AlertDialog.Builder localBuilder = new AlertDialog.Builder(this, j);
/* 260 */     localBuilder.setTitle(getString(R.string.tt_tip)).setMessage(str3)
/* 261 */       .setPositiveButton(getString(R.string.tt_label_ok), new OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
/* 264 */           f.a(TTDelegateActivity.this).d(new long[] { l });
/* 265 */           if (a.a() != null) {
/* 266 */             a.a().a(this.b);
/*     */           }
/* 268 */           TTDelegateActivity.this.finish();
/*     */         }
/* 270 */       }).setNegativeButton(getString(R.string.tt_label_cancel), new OnClickListener()
/*     */       {
/*     */         public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
/* 273 */           TTDelegateActivity.a(TTDelegateActivity.this, i, l);
/* 274 */           TTDelegateActivity.this.finish(); } })
/*     */       
/* 276 */       .setOnCancelListener(new OnCancelListener()
/*     */       {
/*     */ 
/*     */         public void onCancel(DialogInterface paramAnonymousDialogInterface)
/*     */         {
/* 279 */           TTDelegateActivity.this.finish();
/*     */         }
/* 281 */       });
/* 282 */     localBuilder.show();
/* 283 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a(int paramInt, long paramLong)
/*     */   {
/* 290 */     if ((!h.a().j()) && (paramInt != 200)) {
/* 291 */       g.b(getApplicationContext(), paramLong);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
/*     */   {
/* 298 */     d.a().a(this, paramArrayOfString, paramArrayOfInt);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\activity\TTDelegateActivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */