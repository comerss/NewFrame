/*     */ package com.bytedance.sdk.openadsdk.ccccc;
/*     */
/*     */

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.widget.Toast;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.nibuguan.DownLoadInfo;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;
import com.bytedance.sdk.openadsdk.ggg.NetUtils;
import com.bytedance.sdk.openadsdk.service.TTDownloadHandlerService;

import java.util.HashMap;

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
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */ public class DownLoadListenerImpl
/*     */   implements DownLoadListener, MineHandler.OnResult
/*     */ {
/*     */   private Context mContext;
/*     */   private final com.bytedance.sdk.openadsdk.core.nibuguan.b b;
/*     */   private final NativeAdData mNativeAdData;
/*     */   private boolean d;
/*     */   private DownLoadData e;
/*     */   private long f;
/*     */   private c g;
/*     */   private b h;
/*     */   private TTAppDownloadListener mDownloadListener;
/*     */   private com.bytedance.sdk.openadsdk.eeeee.d j;
/*  65 */   private final MineHandler mHandler = new MineHandler(Looper.getMainLooper(), this);
/*     */
/*     */   private static HashMap<String, a> sHashMap;
/*     */
/*     */   private DownLoadInfo mLoadInfo;
/*     */
/*  71 */   private boolean n = false;
/*     */   private String o;
/*     */
/*     */   public DownLoadListenerImpl(@NonNull Context paramContext, @NonNull NativeAdData paramh, @NonNull String paramString)
/*     */   {
/*  76 */     this.mContext = paramContext;
/*  77 */     this.mNativeAdData = paramh;
/*  78 */     this.b = paramh.m();
/*  79 */     this.o = paramString;
/*  80 */     if (this.b == null) {
/*  81 */       throw new RuntimeException("not SslHepler App type Ad !");
/*     */     }
/*  83 */     this.mLoadInfo = new DownLoadInfo(paramh, paramString);
/*  84 */     e();
/*     */   }
/*     */
/*     */   public boolean a() {
/*  88 */     return this.n;
/*     */   }
/*     */
/*     */
/*     */
/*     */   public void a(@NonNull Activity paramActivity)
/*     */   {
/*  95 */     this.mContext = paramActivity;
/*     */   }
/*     */
/*     */
/*     */
/*     */   public void b()
/*     */   {
/* 102 */     if ((this.mContext == null) || (this.b == null)) {
/* 103 */       return;
/*     */     }
/* 105 */     if ((this.e != null) && (this.e.a > 0L)) {
/* 106 */       AppAdViewHolder.aaaaaa(this.mContext, this.e.b, this.e.a, this.b.c());
/* 107 */       if ((this.e != null) && (this.e.a >= 0L)) {
            DownloadNotifier.getDefault(this.mContext).a(Long.valueOf(this.e.a), this, this.mLoadInfo);
/*     */       }
/*     */     }
/*     */   }
/*     */
/*     */   public void c() {
/* 114 */     if ((this.mContext == null) || (this.b == null)) {
/* 115 */       return;
/*     */     }
/*     */
/* 118 */     if (k()) {
/* 119 */       this.n = true;
/* 120 */       return;
/*     */     }
/* 122 */     if (j())
/*     */     {
/* 124 */       if (this.h != null) {
/* 125 */         this.h.d();
/* 126 */         this.n = true;
/*     */       }
/* 128 */       return;
/*     */     }
/* 130 */     if ((this.e == null) || (this.e.a < 0L)) {
/* 131 */       NetUtils.a locala = NetUtils.b(this.mContext);
/* 132 */       if (locala == NetUtils.a.a) {
/* 133 */         Toast.makeText(this.mContext, R.string.tt_no_network, Toast.LENGTH_SHORT).show();
/* 134 */       } else if (com.bytedance.sdk.openadsdk.core.h.a().d(locala.a())) {
/* 135 */         l();
/*     */       } else {
/* 137 */         h();
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 142 */       /*int i1 = OnClick(this.OnClick, this.TTBannerAdImpl.bee, this.TTBannerAdImpl.OnClick, this.bee.VideoManager());
*//* 143 *//*       if ((this.TTBannerAdImpl != null) && (this.TTBannerAdImpl.OnClick >= 0L)) {
*//* 144 *//*         ApiException.OnClick(this.OnClick).OnClick(Long.valueOf(this.TTBannerAdImpl.OnClick), this, this.mM);
*//*     *//*       }*/
        int i1=0;
/* 146 */       if (i1 == 4)
/*     */       {
/* 148 */         if (this.h != null) {
/* 149 */           this.h.b();
/* 150 */           this.n = false;
/*     */         }
/* 152 */       } else if (i1 == 2)
/*     */       {
/* 154 */         if (this.h != null) {
/* 155 */           this.h.c();
/* 156 */           this.n = false;
/*     */         }
/* 158 */       } else if (i1 == 8) {
/* 159 */         this.n = true;
/*     */       }
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public static void download(String url, int paramInt)
/*     */   {
/* 171 */     if ((sHashMap != null) && (sHashMap.containsKey(url))) {
/* 172 */       a locala = (a) sHashMap.get(url);
/* 173 */       if (locala != null) {
/* 174 */         if (paramInt == 1) {
/* 175 */           locala.a();
/* 176 */         } else if (paramInt == 2) {
/* 177 */           locala.b();
/*     */         }
/*     */       }
/* 180 */       sHashMap.remove(url);
/*     */     }
/*     */   }
/*     */
/*     */   private void h() {
/* 185 */     if (!(this.mContext instanceof Activity)) {
/* 186 */       i();
/* 187 */       return;
/*     */     }
/* 189 */     AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext, R.style.Theme_Dialog_TTDownload);
/*     */     String str;
/* 191 */     if ((this.b != null) && (!StringUtils.isEmpty(this.b.b()))) {
/* 192 */       str = String.format(this.mContext.getString(R.string.tt_confirm_download_have_app_name), new Object[] { this.b.b() });
/*     */     } else {
/* 194 */       str = this.mContext.getString(R.string.tt_confirm_download);
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
/* 211 */     localBuilder.setTitle(this.mContext.getString(R.string.tt_tip)).setMessage(str).setPositiveButton(this.mContext.getString(R.string.tt_label_ok), new DialogInterface.OnClickListener()
/*     */     {
/*     */       public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
/*     */       {
/* 201 */         a();
/*     */       }
/*     */
/*     */
/* 205 */     }
/*     */
/*     */
/*     */
/*     */
/*     */
/* 211 */       ).setNegativeButton(this.mContext.getString(R.string.tt_label_cancel), new DialogInterface.OnClickListener() { public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {} })
/*     */
/*     */
/*     */
/*     */
/*     */
/* 211 */       .setOnCancelListener(new DialogInterface.OnCancelListener()
/*     */       {
/*     */
/*     */
/*     */
/*     */
/*     */         public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
/*     */
/*     */
/*     */
/*     */
/* 216 */       });
/* 217 */     localBuilder.show();
/*     */   }
/*     */
/*     */
/*     */
/*     */   @SuppressLint("WrongConstant")
private void i()
/*     */   {
/* 224 */     if ((this.b == null) || (StringUtils.isEmpty(this.b.a()))) {
/* 225 */       return;
/*     */     }
/* 227 */     if (sHashMap == null) {
/* 228 */       sHashMap = new HashMap();
/*     */     }
/* 230 */     a local4 = new a()
/*     */     {
/*     */       public void a() {
/* 233 */         m();
/* 234 */         LogUtils.b("TT_AD_SDK", "dialog onConfirm");
/*     */       }
/*     */
/*     */       public void b()
/*     */       {
/* 239 */        LogUtils.b("TT_AD_SDK", "dialog onCancel");
/*     */       }
/*     */
/* 242 */     };
/* 243 */     sHashMap.put(this.b.a(), local4);
/*     */     try {
/* 245 */       Intent localIntent = new Intent(this.mContext, TTDelegateActivity.class);
/* 246 */       localIntent.addFlags(268435456);
/* 247 */       localIntent.putExtra("app_download_url", this.b.a());
/* 248 */       localIntent.putExtra("type", 1);
/* 249 */       localIntent.putExtra("app_name", this.b.b());
/* 250 */       if (this.mContext != null) {
/* 251 */         this.mContext.startActivity(localIntent);
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {
/* 255 */       sHashMap.remove(this.b.a());
/*     */     }
/*     */   }
/*     */
/*     */   private boolean j() {
/* 260 */     if (this.b == null) {
/* 261 */       return false;
/*     */     }
/* 263 */     String str = this.b.c();
/* 264 */     if ((!StringUtils.isEmpty(str)) && (ToolUtils.b(this.mContext, str))) {
/* 265 */       Intent localIntent = ToolUtils.a(this.mContext, str);
/* 266 */       if (localIntent == null) {
/* 267 */         return false;
/*     */       }
/* 269 */       localIntent.putExtra("START_ONLY_FOR_ANDROID", true);
/* 270 */       this.mContext.startActivity(localIntent);
/* 271 */       return true;
/*     */     }
/* 273 */     return false;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   @SuppressLint("WrongConstant")
private boolean k()
/*     */   {
/* 283 */     if (this.mNativeAdData.n() != null) {
/* 284 */       String str = this.mNativeAdData.n().a();
/* 285 */       if (!StringUtils.isEmpty(str)) {
/* 286 */         Uri localUri = Uri.parse(str);
/* 287 */         Intent localIntent = new Intent("android.intent.action.VIEW");
/* 288 */         localIntent.setData(localUri);
/*     */
/* 290 */         if (ToolUtils.a(this.mContext, localIntent)) {
/* 291 */           if (!(this.mContext instanceof Activity)) {
/* 292 */             localIntent.addFlags(268435456);
/*     */           }
/* 294 */           this.mContext.startActivity(localIntent);
/* 295 */           AdEvent.h(this.mContext, this.mNativeAdData, this.o, "open_url_app");
/* 296 */           return true;
/*     */         }
/*     */       }
/* 299 */       AdEvent.h(this.mContext, this.mNativeAdData, this.o, "open_fallback_url");
/*     */     }
/* 301 */     return false;
/*     */   }
/*     */
/*     */   public void a(TTAppDownloadListener paramTTAppDownloadListener) {
/* 305 */     this.mDownloadListener = paramTTAppDownloadListener;
/*     */   }
/*     */
/*     */   public void a(com.bytedance.sdk.openadsdk.eeeee.d paramd) {
/* 309 */     this.j = paramd;
/*     */   }
/*     */
/*     */   public void d() {
/* 313 */     if (this.j != null) {
/* 314 */       this.j.a();
/*     */     }
/*     */   }
/*     */
/*     */
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a();
/*     */
/*     */
/*     */     public abstract void b();
/*     */   }
/*     */
/*     */
/*     */   public static abstract interface b
/*     */   {
/*     */     public abstract void a();
/*     */
/*     */
/*     */     public abstract void b();
/*     */
/*     */     public abstract void c();
/*     */
/*     */     public abstract void d();
/*     */   }
/*     */
/*     */   private void l()
/*     */   {
/* 342 */     m();
/* 343 */     this.n = true;
/*     */   }
/*     */
/*     */   private void m() {
/* 347 */     String str = this.mNativeAdData.d() == null ? null : this.mNativeAdData.d().a();
/* 348 */     long l1 = MyDownloadManager.a(this.mContext, this.b.a(), this.b.b(), str);
/* 349 */     if (l1 >= 0L) {
/* 350 */       if (this.h != null) {
/* 351 */         this.h.a();
/*     */       }
/* 353 */        DownloadNotifier.getDefault(this.mContext).a(Long.valueOf(l1), this, this.mLoadInfo);
/* 354 */       DownLoadData localy = new DownLoadData();
/* 355 */       localy.b = -1;
/* 356 */       sendMsg(localy, 0, -1, 2);
/* 357 */     } else if (l1 < 0L) {
/* 358 */       n();
/*     */     }
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */   public void a(b paramb)
/*     */   {
/* 367 */     this.h = paramb;
/*     */   }
/*     */
/*     */
/*     */   public void load(long paramLong)
/*     */   {
/* 373 */     this.f = paramLong;
/*     */   }
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */   public void progress(DownLoadData paramy, int paramInt, long paramLong1, long paramLong2, long paramLong3)
/*     */   {
/* 385 */     if ((paramy == null) || (paramy.a != this.f))
/*     */     {
/* 387 */       return;
/*     */     }
/* 389 */     this.e = paramy;
/* 390 */     double d1 = 0.0D;
/*     */     try {
/* 392 */       d1 = paramy.b() / paramy.a();
/*     */     } catch (Exception localException) {
/* 394 */       localException.printStackTrace();
/*     */     }
/* 396 */     int i1 = (int)(d1 * 100.0D);
/* 397 */     if (i1 < 0) {
/* 398 */       i1 = 0;
/*     */     }
/* 400 */     sendMsg(paramy, i1, paramInt, 1);
/*     */   }
/*     */
/*     */   private void n()
/*     */   {
/* 405 */     DownLoadData localy = new DownLoadData();
/* 406 */     localy.b = 16;
/* 407 */     sendMsg(localy, 0, 3, 2);
/*     */   }
/*     */
/*     */   private void sendMsg(DownLoadData paramy, int paramInt1, int paramInt2, int paramInt3) {
/* 411 */     Message localMessage = Message.obtain();
/* 412 */     localMessage.what = paramInt3;
/* 413 */     localMessage.arg1 = paramInt2;
/* 414 */     localMessage.arg2 = paramInt1;
/* 415 */     localMessage.obj = paramy;
/* 416 */     this.mHandler.sendMessage(localMessage);
/*     */   }
/*     */
/*     */
/*     */
/*     */   public void e()
/*     */   {
/* 423 */     this.d = true;
/* 424 */     if ((this.g != null) && (this.g.getStatus() != AsyncTask.Status.FINISHED)) {
/* 425 */       this.g.cancel(true);
/*     */     }
/* 427 */     this.g = new c();
/* 428 */     this.g.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { this.b.a() });
/*     */   }
/*     */
/*     */
/*     */
/*     */   public void f()
/*     */   {
/* 435 */     this.d = false;
/* 436 */     if (this.e != null) {
/* 437 */        DownloadNotifier.getDefault(this.mContext).addListener(Long.valueOf(this.e.a), this);
/*     */     }
/* 439 */     if ((this.g != null) && (this.g.getStatus() != AsyncTask.Status.FINISHED)) {
/* 440 */       this.g.cancel(true);
/*     */     }
/* 442 */     this.mHandler.removeCallbacksAndMessages(null);
/*     */   }
/*     */
/*     */
/*     */
/*     */   public void g()
/*     */   {
/* 449 */     if ((this.mContext == null) || (this.e == null) || (this.e.a < 0L) || (this.e.b == 8))
/*     */     {
/* 451 */       return;
/*     */     }
/* 453 */     Uri localUri = ContentUris.withAppendedId(com.bytedance.sdk.openadsdk.ccccc.m.a.a, this.e.a);
/* 454 */     Intent localIntent = new Intent("android.ss.intent.action.DOWNLOAD_DELETE", localUri, this.mContext, TTDownloadHandlerService.class);
/* 455 */     this.mContext.startService(localIntent);
/*     */   }
/*     */
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 460 */     if ((paramMessage == null) || (!this.d) || (this.mDownloadListener == null)) {
/* 461 */       return;
/*     */     }
/* 463 */     int i1 = paramMessage.arg1;
/* 464 */     int i2 = paramMessage.arg2;
/* 465 */     DownLoadData localy = (DownLoadData)paramMessage.obj;
/*     */
/* 467 */     String str = this.b.b();
/* 468 */     switch (paramMessage.what) {
/*     */     case 1:
/* 470 */       switch (i1) {
/*     */       case 1:
/* 472 */         this.mDownloadListener.onDownloadActive(localy.c, localy.d, localy.e, str);
/* 473 */         break;
/*     */       case 2:
/* 475 */         this.mDownloadListener.onDownloadPaused(localy.c, localy.d, localy.e, str);
/* 476 */         break;
/*     */       case 3:
/* 478 */         if (localy.b == 16) {
/* 479 */           this.mDownloadListener.onDownloadFailed(localy.c, localy.d, localy.e, str);
/* 480 */         } else if (localy.b == 32) {
/* 481 */           this.mDownloadListener.onInstalled(localy.e, str);
/* 482 */         } else if (localy.b == 8) {
/* 483 */           if (ToolUtils.b(this.mContext, this.b.c())) {
/* 484 */             this.mDownloadListener.onInstalled(localy.e, str);
/*     */           } else {
/* 486 */             this.mDownloadListener.onDownloadFinished(localy.c, localy.e, str);
/*     */           }
/*     */         }
/*     */         break;
/*     */       }
/* 491 */       break;
/*     */
/*     */
/*     */     case 2:
/* 495 */       switch (i1)
/*     */       {
/*     */       case -1:
/*     */         break;
/*     */       case 2:
/* 500 */         this.mDownloadListener.onDownloadActive(localy.c, localy.d, localy.e, str);
/* 501 */         break;
/*     */       case 1:
/* 503 */         this.mDownloadListener.onDownloadPaused(localy.c, localy.d, localy.e, str);
/* 504 */         break;
/*     */       case 3:
/* 506 */         if (localy.b == 16) {
/* 507 */           this.mDownloadListener.onDownloadFailed(localy.c, localy.d, localy.e, str);
/*     */         }
/*     */         break;
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */
/*     */private class c extends AsyncTask<String, Void, DownLoadData> {
            private c() {
            }

    @Override
    protected DownLoadData doInBackground(String... var1) {
        if (var1 != null && (var1.length < 1 || !TextUtils.isEmpty(var1[0])) && DownLoadListenerImpl.this.mContext != null) {
            String var2 = var1[0];
            AppAdViewHolder var3 = AppAdViewHolder.getInstance(mContext);
            return var3.aaaaaa(var2);
        } else {
            return null;
        }
    }

    protected void a(DownLoadData var1) {
        super.onPostExecute(var1);
        if (!this.isCancelled()) {
            try {
                if (var1 == null || var1.a <= -1L || AppAdViewHolder.getInstance(mContext).aaaaaa(var1) && !ToolUtils.b(DownLoadListenerImpl.this.mContext, DownLoadListenerImpl.this.b.c())) {
                    if (ToolUtils.b(DownLoadListenerImpl.this.mContext, DownLoadListenerImpl.this.b.c())) {
                        if (DownLoadListenerImpl.this.e != null) {
                            DownLoadListenerImpl.this.a(DownLoadListenerImpl.this.e);
                        } else {
                            DownLoadListenerImpl.this.e = new DownLoadData();
                            DownLoadListenerImpl.this.e.b = 8;
                            DownLoadListenerImpl.this.a(DownLoadListenerImpl.this.e);
                        }
                    } else {
                        if (DownLoadListenerImpl.this.mDownloadListener != null) {
                            DownLoadListenerImpl.this.mDownloadListener.onIdle();
                        }

                        DownLoadListenerImpl.this.e = null;
                    }
                } else {
                    if (DownLoadListenerImpl.this.e != null && DownLoadListenerImpl.this.e.b == 16) {
                        DownLoadListenerImpl.this.e = null;
                    } else {
                        DownLoadListenerImpl.this.e = var1;
                        DownloadNotifier.getDefault(DownLoadListenerImpl.this.mContext).a(DownLoadListenerImpl.this.e.a, DownLoadListenerImpl.this, DownLoadListenerImpl.this.mLoadInfo);
                    }

                    DownLoadListenerImpl.this.a(var1);
                }
            } catch (Exception var3) {
                ;
            }

        }
    }
}
/*     */
/*     */   private void a(DownLoadData paramy) {
/* 570 */     if (this.mDownloadListener == null) {
/* 571 */       return;
/*     */     }
/* 573 */     if (paramy == null) {
/* 574 */       this.mDownloadListener.onIdle();
/* 575 */       return;
/*     */     }
/* 577 */     if ((paramy.a() <= 0L) && (paramy.b != 8))
/*     */     {
/* 579 */       return;
/*     */     }
/* 581 */     double d1 = 0.0D;
/*     */     try {
/* 583 */       d1 = paramy.b() / paramy.a();
/*     */     } catch (Exception localException) {
/* 585 */       localException.printStackTrace();
/*     */     }
/* 587 */     int i1 = (int)(d1 * 100.0D);
/* 588 */     if (i1 < 0) {
/* 589 */       i1 = 0;
/*     */     }
/*     */
/* 592 */     String str = this.b.b();
/* 593 */     switch (paramy.b) {
/*     */     case 16:
/* 595 */       this.mDownloadListener.onDownloadFailed(paramy.c, paramy.d, paramy.e, str);
/* 596 */       break;
/*     */     case 4:
/* 598 */       this.mDownloadListener.onDownloadPaused(paramy.c, paramy.d, paramy.e, str);
/* 599 */       break;
/*     */     case 1:
/*     */     case 2:
/* 602 */       this.mDownloadListener.onDownloadActive(paramy.c, paramy.d, paramy.e, str);
/* 603 */       break;
/*     */     case 8:
/* 605 */       if (ToolUtils.b(this.mContext, this.b.c())) {
/* 606 */         this.mDownloadListener.onInstalled(paramy.e, str);
/*     */       } else {
/* 608 */         this.mDownloadListener.onDownloadFinished(paramy.c, paramy.e, str);
/*     */       }
/* 610 */       break;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\cdsss\DownLoadListenerImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */