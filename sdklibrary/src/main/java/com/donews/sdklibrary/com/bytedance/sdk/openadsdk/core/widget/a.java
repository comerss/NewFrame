/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.widget;
/*     */ 
/*     */ import android.app.Dialog;
/*     */ import android.content.Context;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.View;
/*     */ import android.view.View.OnTouchListener;
/*     */ import android.view.Window;
/*     */ import android.view.WindowManager.LayoutParams;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.ProgressBar;
/*     */ import android.widget.TextView;
/*     */ import com.bytedance.sdk.openadsdk.R.drawable;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.style;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import com.bytedance.sdk.openadsdk.core.video.a.d;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
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
/*     */ public class a
/*     */ {
/*     */   private a a;
/*  36 */   private boolean b = false;
/*  37 */   private boolean c = false;
/*     */   
/*  39 */   private boolean d = false;
/*     */   
/*     */   private Dialog e;
/*     */   
/*     */   private ProgressBar f;
/*     */   
/*     */   private ImageView g;
/*     */   private TextView h;
/*     */   private TextView i;
/*  48 */   private int j = 1000;
/*  49 */   private int k = 10;
/*     */   
/*  51 */   private long l = 0L;
/*     */   private float m;
/*     */   
/*  54 */   public a(a parama) { this.a = parama;
/*  55 */     this.d = true;
/*     */   }
/*     */   
/*     */ 
/*     */   private float n;
/*     */   private int o;
/*     */   private int p;
/*  62 */   private boolean q = true;
/*  63 */   private boolean r = false;
/*     */   private View s;
/*     */   
/*     */   public void a(View paramView) {
/*  67 */     if (paramView != null) {
/*  68 */       this.s = paramView;
/*  69 */       paramView.setOnTouchListener(this.t);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/*  74 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/*  78 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*  82 */   private OnTouchListener t = new OnTouchListener()
/*     */   {
/*     */     public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
/*  85 */       if (a.a(a.this).p()) {
/*  86 */         return (a.b(a.this)) || (!a.c(a.this));
/*     */       }
/*  88 */       float f1 = paramAnonymousMotionEvent.getX();
/*  89 */       float f2 = paramAnonymousMotionEvent.getY();
/*  90 */       switch (paramAnonymousMotionEvent.getAction()) {
/*     */       case 0: 
/*  92 */         a.a(a.this, a.a(a.this, paramAnonymousMotionEvent));
/*  93 */         a.a(a.this, f1);
/*  94 */         a.b(a.this, f2);
/*  95 */         a.a(a.this, (int)f1);
/*  96 */         a.b(a.this, (int)f2);
/*  97 */         a.b(a.this, true);
/*  98 */         if ((a.a(a.this) != null) && (a.c(a.this)) && (!a.b(a.this))) {
/*  99 */           a.a(a.this).a(paramAnonymousView, true);
/*     */         }
/*     */         break;
/*     */       case 2: 
/* 103 */         if ((a.b(a.this)) && (!a.d(a.this)))
/*     */         {
/*     */ 
/* 106 */           float f3 = f1 - a.e(a.this);
/* 107 */           float f4 = f2 - a.f(a.this);
/* 108 */           float f5 = Math.abs(f3);
/* 109 */           float f6 = Math.abs(f4);
/*     */           
/* 111 */           if (!a.g(a.this)) {
/* 112 */             if ((f5 > 20.0F) || (f6 > 20.0F)) {
/* 113 */               a.c(a.this, true);
/*     */             } else {
/* 115 */               return true;
/*     */             }
/*     */           }
/* 118 */           if (a.a(a.this) != null) {
/* 119 */             a.a(a.this).n();
/*     */           }
/* 121 */           if (f5 > f6) {
/* 122 */             if (f3 > 0.0F) {
/* 123 */               a.c(a.this, f5);
/* 124 */             } else if (f3 < 0.0F) {
/* 125 */               a.d(a.this, f5);
/*     */             }
/*     */           }
/* 128 */           a.a(a.this, f1);
/* 129 */           a.b(a.this, f2); }
/* 130 */         break;
/*     */       case 1: 
/* 132 */         if ((Math.abs(f1 - a.h(a.this)) > 20.0F) || 
/* 133 */           (Math.abs(f2 - a.i(a.this)) > 20.0F)) {
/* 134 */           a.b(a.this, false);
/*     */         }
/* 136 */         if (!a.b(a.this)) {
/* 137 */           a.b(a.this, true);
/*     */         }
/* 139 */         a.c(a.this, false);
/* 140 */         a.a(a.this, 0.0F);
/* 141 */         a.b(a.this, 0.0F);
/* 142 */         a.a(a.this, 0);
/* 143 */         if (a.a(a.this) != null) {
/* 144 */           a.a(a.this).a(paramAnonymousView, a.j(a.this));
/*     */         }
/* 146 */         if (a.a(a.this) != null) {
/* 147 */           a.a(a.this).b(a.k(a.this));
/*     */         }
/* 149 */         a.a(a.this, false);
/* 150 */         break;
/*     */       case 3: 
/* 152 */         a.a(a.this, false);
/* 153 */         break;
/*     */       }
/*     */       
/*     */       
/* 157 */       return (a.b(a.this)) || (!a.c(a.this));
/*     */     }
/*     */   };
/*     */   
/*     */   private boolean u;
/*     */   
/*     */   private d v;
/*     */   
/*     */ 
/*     */   private boolean a(MotionEvent paramMotionEvent)
/*     */   {
/* 168 */     if (paramMotionEvent.getActionMasked() == 0) {
/* 169 */       int i1 = s.a(n.a().getApplicationContext());
/* 170 */       int i2 = s.b(n.a().getApplicationContext());
/*     */       
/* 172 */       float f1 = paramMotionEvent.getRawX();
/* 173 */       float f2 = paramMotionEvent.getRawY();
/*     */       
/* 175 */       if ((f1 <= i1 * 0.01F) || (f1 >= i1 * 0.99F) || (f2 <= i2 * 0.01F) || (f2 >= i2 * 0.99F))
/*     */       {
/* 177 */         return true;
/*     */       }
/*     */     }
/* 180 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(d paramd)
/*     */   {
/* 186 */     this.v = paramd;
/*     */   }
/*     */   
/*     */   private void a(float paramFloat)
/*     */   {
/* 191 */     if ((!this.b) || (!b())) {
/* 192 */       return;
/*     */     }
/* 194 */     this.v.a(this, paramFloat, false);
/*     */   }
/*     */   
/*     */   private void b(float paramFloat)
/*     */   {
/* 199 */     if ((!this.b) || (!b())) {
/* 200 */       return;
/*     */     }
/* 202 */     this.v.a(this, paramFloat, true);
/*     */   }
/*     */   
/*     */   private boolean b() {
/* 206 */     if (this.v == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   public boolean a(Context paramContext, boolean paramBoolean, long paramLong1, long paramLong2) {
/* 213 */     if ((paramContext == null) || (paramLong2 <= 0L)) {
/* 214 */       return false;
/*     */     }
/* 216 */     if ((this.e == null) || (this.d)) {
/* 217 */       this.d = false;
/* 218 */       View localView = LayoutInflater.from(paramContext).inflate(R.layout.tt_video_progress_dialog, null);
/* 219 */       this.f = ((ProgressBar)localView.findViewById(R.id.duration_progressbar));
/* 220 */       this.h = ((TextView)localView.findViewById(R.id.tv_current));
/* 221 */       this.i = ((TextView)localView.findViewById(R.id.tv_duration));
/* 222 */       this.g = ((ImageView)localView.findViewById(R.id.duration_image_tip));
/*     */       
/* 224 */       this.e = new Dialog(paramContext, R.style.volume_dialog);
/* 225 */       this.e.setContentView(localView);
/* 226 */       this.e.getWindow().addFlags(8);
/* 227 */       this.e.getWindow().addFlags(32);
/* 228 */       this.e.getWindow().addFlags(16);
/* 229 */       this.e.getWindow().setLayout(-2, -2);
/*     */       
/* 231 */       WindowManager.LayoutParams localLayoutParams = this.e.getWindow().getAttributes();
/* 232 */       localLayoutParams.gravity = 17;
/* 233 */       this.e.getWindow().setAttributes(localLayoutParams);
/*     */     }
/*     */     
/* 236 */     if (this.f != null) {
/* 237 */       this.f.setProgress((int)(paramLong1 * 100L / paramLong2));
/*     */     }
/*     */     
/* 240 */     if (this.h != null) {
/* 241 */       this.h.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1));
/*     */     }
/*     */     
/* 244 */     if (this.i != null) {
/* 245 */       this.i.setText(" / " + com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong2));
/*     */     }
/*     */     
/* 248 */     if (this.g != null) {
/* 249 */       if (paramBoolean) {
/* 250 */         this.g.setBackgroundResource(R.drawable.tt_forward_video);
/*     */       } else {
/* 252 */         this.g.setBackgroundResource(R.drawable.tt_back_video);
/*     */       }
/*     */     }
/*     */     try {
/* 256 */       if (!this.e.isShowing()) {
/* 257 */         this.e.show();
/* 258 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public boolean a() {
/*     */     try {
/* 267 */       if ((this.e != null) && (this.e.isShowing())) {
/* 268 */         this.e.dismiss();
/* 269 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/* 273 */     return false;
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
/*     */   public void a(Context paramContext, float paramFloat, boolean paramBoolean, long paramLong1, long paramLong2)
/*     */   {
/* 286 */     if ((paramContext == null) || (paramLong1 < 0L)) {
/* 287 */       return;
/*     */     }
/*     */     
/* 290 */     if (paramLong2 <= 0L) {
/* 291 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 298 */     int i1 = (int)(paramFloat / this.k * this.j);
/*     */     
/* 300 */     if (paramBoolean) {
/* 301 */       this.l += i1;
/*     */     } else {
/* 303 */       this.l -= i1;
/*     */     }
/* 305 */     if (this.l > paramLong2) {
/* 306 */       this.l = paramLong2;
/*     */     }
/* 308 */     if (this.l < 0L) {
/* 309 */       this.l = 0L;
/*     */     }
/* 311 */     if (a(paramContext, paramBoolean, this.l, paramLong2)) {
/* 312 */       this.l = paramLong1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract void a(View paramView, boolean paramBoolean);
/*     */     
/*     */     public abstract void n();
/*     */     
/*     */     public abstract void b(long paramLong);
/*     */     
/*     */     public abstract boolean p();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\widget\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */