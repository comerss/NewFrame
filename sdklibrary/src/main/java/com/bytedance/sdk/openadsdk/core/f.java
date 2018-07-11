/*     */ package com.bytedance.sdk.openadsdk.core;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.Nullable;
/*     */ import android.view.View;
/*     */
/*     */ import com.bytedance.sdk.openadsdk.core.ssl.d;
/*     */ import com.bytedance.sdk.openadsdk.ggg.k;
/*     */ import com.bytedance.sdk.openadsdk.ggg.r;
/*     */ import java.util.List;
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
/*     */ public class f
/*     */   extends View
/*     */ {
/*     */   private boolean b;
/*     */   private boolean c;
/*     */   private a d;
/*     */   private View e;
/*     */   private List<View> f;
/*     */   @Nullable
/*     */   private List<View> g;
/*     */   private boolean h;
/*     */   private int i;
/*  44 */   protected final Handler a = new Handler(Looper.getMainLooper())
/*     */   {
/*     */     public void handleMessage(Message paramAnonymousMessage) {
/*  47 */       switch (paramAnonymousMessage.what) {
/*     */       case 1: 
/*  49 */         if (f.a(f.this)) {
/*  50 */           if (z.a(f.b(f.this), 20, f.c(f.this))) {
/*  51 */             f.this.c();
/*  52 */             f.this.a.sendEmptyMessageDelayed(2, 1000L);
/*  53 */             if (f.d(f.this) != null) {
/*  54 */               f.d(f.this).a(f.b(f.this));
/*     */             }
/*     */           }
/*     */           else {
/*  58 */             f.this.a.sendEmptyMessageDelayed(1, 1000L);
/*     */           }
/*     */         }
/*     */         
/*     */         break;
/*     */       case 2: 
/*  64 */         boolean bool = r.d(n.a(), n.a().getPackageName());
/*  65 */         if ((z.a(f.b(f.this), 20, f.c(f.this))) || (!bool)) {
/*  66 */           f.this.a.sendEmptyMessageDelayed(2, 1000L);
/*  67 */         } else if (!f.e(f.this)) {
/*  68 */           f.this.setNeedCheckingShow(true);
/*     */         }
/*     */         
/*     */         break;
/*     */       }
/*     */       
/*     */     }
/*     */   };
/*     */   
/*     */   public f(Context paramContext, View paramView)
/*     */   {
/*  79 */     super(n.a());
/*  80 */     this.e = paramView;
/*  81 */     setLayoutParams(new ViewGroup.LayoutParams(0, 0));
/*     */   }
/*     */   
/*     */   public void onWindowFocusChanged(boolean paramBoolean)
/*     */   {
/*  86 */     super.onWindowFocusChanged(paramBoolean);
/*  87 */     if (this.d != null) {
/*  88 */       this.d.a(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onAttachedToWindow()
/*     */   {
/*  94 */     super.onAttachedToWindow();
/*  95 */     b();
/*  96 */     this.h = false;
/*  97 */     if (this.d != null) {
/*  98 */       this.d.a();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onDetachedFromWindow() {
/* 103 */     super.onDetachedFromWindow();
/* 104 */     c();
/* 105 */     this.h = true;
/* 106 */     if (this.d != null) {
/* 107 */       this.d.b();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void setRefClickViews(List<View> paramList)
/*     */   {
/* 114 */     this.f = paramList;
/*     */   }
/*     */   
/*     */   public void setRefCreativeViews(@Nullable List<View> paramList) {
/* 118 */     this.g = paramList;
/*     */   }
/*     */   
/*     */   public void a() {
/* 122 */     a(this.f, null);
/* 123 */     a(this.g, null);
/*     */   }
/*     */   
/*     */   public void a(List<View> paramList, d paramd) {
/* 127 */     if (k.b(paramList)) {
/* 128 */       for (View localView : paramList) {
/* 129 */         localView.setOnClickListener(paramd);
/* 130 */         localView.setOnTouchListener(paramd);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void b()
/*     */   {
/* 140 */     if ((!this.c) || (this.b)) {
/* 141 */       return;
/*     */     }
/* 143 */     this.b = true;
/* 144 */     this.a.sendEmptyMessage(1);
/*     */   }
/*     */   
/*     */   void c() {
/* 148 */     if (!this.b) {
/* 149 */       return;
/*     */     }
/* 151 */     this.a.removeCallbacksAndMessages(null);
/* 152 */     this.b = false;
/*     */   }
/*     */   
/*     */   public void setNeedCheckingShow(boolean paramBoolean) {
/* 156 */     this.c = paramBoolean;
/* 157 */     if ((!paramBoolean) && (this.b))
/*     */     {
/* 159 */       c();
/* 160 */     } else if ((paramBoolean) && (!this.b)) {
/* 161 */       b();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setCallback(a parama) {
/* 166 */     this.d = parama;
/*     */   }
/*     */   
/*     */   public void setAdType(int paramInt) {
/* 170 */     this.i = paramInt;
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(boolean paramBoolean);
/*     */     
/*     */     public abstract void a();
/*     */     
/*     */     public abstract void b();
/*     */     
/*     */     public abstract void a(View paramView);
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\f.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */