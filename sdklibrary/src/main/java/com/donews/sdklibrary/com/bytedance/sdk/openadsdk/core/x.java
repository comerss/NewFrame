/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.app.Dialog;
/*     */ import android.content.Context;
/*     */ import android.content.DialogInterface;
/*     */ import android.content.DialogInterface.OnShowListener;
/*     */ import android.graphics.Bitmap;
/*     */ import android.os.Looper;
/*     */ import android.support.annotation.MainThread;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.widget.ImageView;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.androidquery.callback.AjaxStatus;
/*     */ import com.androidquery.callback.BitmapAjaxCallback;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.style;
/*     */ import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
/*     */ import com.bytedance.sdk.openadsdk.TTInteractionAd;
/*     */ import com.bytedance.sdk.openadsdk.TTInteractionAd.AdInteractionListener;
/*     */ import com.bytedance.sdk.openadsdk.core.a.a;
/*     */ import com.bytedance.sdk.openadsdk.core.a.b.a;
/*     */ import com.bytedance.sdk.openadsdk.core.d.g;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ class x
/*     */   implements TTInteractionAd
/*     */ {
/*     */   private Context a;
/*     */   private h b;
/*     */   private Dialog c;
/*     */   private TTInteractionAd.AdInteractionListener d;
/*     */   private com.bytedance.sdk.openadsdk.c.x e;
/*     */   private j f;
/*     */   private ImageView g;
/*     */   private ImageView h;
/*     */   private static boolean i;
/*     */   
/*     */   x(Context paramContext, h paramh)
/*     */   {
/*  51 */     this.a = paramContext;
/*  52 */     this.b = paramh;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   void a(@NonNull j paramj)
/*     */   {
/*  59 */     this.f = paramj;
/*  60 */     com.bytedance.sdk.openadsdk.d.c.a(this.b);
/*  61 */     if (getInteractionType() == 4) {
/*  62 */       this.e = new com.bytedance.sdk.openadsdk.c.x(this.a, this.b, "interaction");
/*     */     }
/*     */     
/*  65 */     a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void a()
/*     */   {
/*  72 */     this.c = new l(this.a, R.style.wg_insert_dialog);
/*     */     
/*  74 */     this.c.setOnShowListener(new OnShowListener()
/*     */     {
/*     */       public void onShow(DialogInterface paramAnonymousDialogInterface) {
/*  77 */         if (x.a(x.this).isShowing()) {
/*  78 */           com.bytedance.sdk.openadsdk.d.c.a(x.b(x.this), x.c(x.this), "interaction");
/*  79 */           if (x.d(x.this) != null) {
/*  80 */             x.d(x.this).onAdShow();
/*     */           }
/*  82 */           if (x.c(x.this).t()) {
/*  83 */             r.a(x.c(x.this), x.e(x.this));
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*  88 */     });
/*  89 */     this.c.setContentView(R.layout.tt_insert_ad_layout);
/*  90 */     this.h = ((ImageView)this.c.findViewById(R.id.insert_ad_img));
/*     */     
/*  92 */     int j = s.a(this.a);
/*  93 */     int k = j / 3;
/*  94 */     this.h.setMaxWidth(j);
/*  95 */     this.h.setMinimumWidth(k);
/*  96 */     this.h.setMinimumHeight(k);
/*     */     
/*  98 */     this.g = ((ImageView)this.c.findViewById(R.id.insert_dislike_icon_img));
/*     */     
/* 100 */     int m = (int)s.a(this.a, 15.0F);
/* 101 */     s.a(this.g, m, m, m, m);
/*     */     
/* 103 */     b();
/*     */     
/* 105 */     c();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void b()
/*     */   {
/* 113 */     a locala = new a(this.a, this.b, "interaction", 3);
/* 114 */     locala.a(this.h);
/* 115 */     locala.b(this.g);
/* 116 */     locala.a(this.e);
/* 117 */     locala.a(new b.a()
/*     */     {
/*     */       public void a(View paramAnonymousView, int paramAnonymousInt) {
/* 120 */         if (x.d(x.this) != null) {
/* 121 */           x.d(x.this).onAdClicked();
/*     */         }
/* 123 */         if ((paramAnonymousInt == 2) || (paramAnonymousInt == 3) || (paramAnonymousInt == 5))
/*     */         {
/*     */ 
/* 126 */           x.f(x.this);
/* 127 */           if (x.d(x.this) != null) {
/* 128 */             x.d(x.this).onAdDismiss();
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 133 */     });
/* 134 */     this.h.setOnClickListener(locala);
/* 135 */     this.h.setOnTouchListener(locala);
/*     */     
/*     */ 
/* 138 */     this.g.setOnClickListener(new OnClickListener()
/*     */     {
/*     */       public void onClick(View paramAnonymousView) {
/* 141 */         x.f(x.this);
/* 142 */         com.bytedance.sdk.openadsdk.d.c.c(x.c(x.this));
/* 143 */         if (x.d(x.this) != null) {
/* 144 */           x.d(x.this).onAdDismiss();
/*     */         }
/* 146 */         m.b("TTInteractionAdImpl", "dislike事件发出");
/*     */       }
/*     */     });
/*     */     
/* 150 */     if (this.e != null) {
/* 151 */       this.e.a(new com.bytedance.sdk.openadsdk.core.a.c(this.a, this.b, "interaction"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void c()
/*     */   {
/* 161 */     int j = ((g)this.b.f().get(0)).b();
/* 162 */     String str = ((g)this.b.f().get(0)).a();
/* 163 */     AQuery2 localAQuery2 = new AQuery2(this.a);
/* 164 */     ((AQuery)localAQuery2.id(this.h)).image(str, true, true, j, 0, new BitmapAjaxCallback()
/*     */     {
/*     */       protected void callback(String paramAnonymousString, ImageView paramAnonymousImageView, Bitmap paramAnonymousBitmap, AjaxStatus paramAnonymousAjaxStatus) {
/* 167 */         super.callback(paramAnonymousString, paramAnonymousImageView, paramAnonymousBitmap, paramAnonymousAjaxStatus);
/* 168 */         if (x.g(x.this) != null) {
/* 169 */           if ((paramAnonymousAjaxStatus == null) || (paramAnonymousBitmap == null)) {
/* 170 */             x.g(x.this).b();
/*     */           }
/* 172 */           else if (paramAnonymousAjaxStatus.getCode() == 200) {
/* 173 */             x.g(x.this).a();
/*     */           } else {
/* 175 */             x.g(x.this).b();
/*     */           }
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAdInteractionListener(TTInteractionAd.AdInteractionListener paramAdInteractionListener)
/*     */   {
/* 188 */     this.d = paramAdInteractionListener;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener)
/*     */   {
/* 196 */     if (this.e != null) {
/* 197 */       this.e.a(paramTTAppDownloadListener);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getInteractionType()
/*     */   {
/* 203 */     if (this.b == null) {
/* 204 */       return -1;
/*     */     }
/* 206 */     return this.b.c();
/*     */   }
/*     */   
/*     */   @MainThread
/*     */   public void showInteractionAd(Activity paramActivity)
/*     */   {
/* 212 */     if (paramActivity.isFinishing()) {
/* 213 */       return;
/*     */     }
/* 215 */     if (Looper.getMainLooper() != Looper.myLooper()) {
/* 216 */       throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
/*     */     }
/* 218 */     if (!i) {
/* 219 */       i = true;
/* 220 */       this.c.show();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void d()
/*     */   {
/* 228 */     i = false;
/* 229 */     this.c.dismiss();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\x.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */