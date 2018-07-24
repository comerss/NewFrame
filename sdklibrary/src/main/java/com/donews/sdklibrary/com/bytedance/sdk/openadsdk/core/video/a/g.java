/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.a;
/*     */ 
/*     */ import android.app.Activity;
/*     */ import android.content.BroadcastReceiver;
/*     */ import android.content.Context;
/*     */ import android.content.Intent;
/*     */ import android.content.IntentFilter;
/*     */ import android.content.res.Resources;
/*     */ import android.os.Build.VERSION;
/*     */ import android.os.Message;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.SurfaceHolder;
/*     */ import android.view.View;
/*     */ import android.view.ViewGroup;
/*     */ import android.view.Window;
/*     */ import com.bytedance.sdk.openadsdk.R.integer;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.g.m;
/*     */ import com.bytedance.sdk.openadsdk.g.n.a;
/*     */ import com.bytedance.sdk.openadsdk.g.q;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumSet;
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
/*     */ public class g
/*     */   implements c, d, t.a
/*     */ {
/*  42 */   private static final String c = g.class.getSimpleName();
/*     */   private h d;
/*     */   private ViewGroup e;
/*  45 */   private t f = new t(this);
/*  46 */   private long g = 0L;
/*  47 */   private long h = 0L;
/*     */   private com.bytedance.sdk.openadsdk.core.video.c.d i;
/*     */   private c.a j;
/*  50 */   private long k = 0L;
/*  51 */   private long l = 0L;
/*     */   private long m;
/*     */   private ArrayList<Runnable> n;
/*     */   private boolean o;
/*     */   private WeakReference<Context> p;
/*  56 */   private boolean q = false;
/*  57 */   private boolean r = false;
/*  58 */   private boolean s = false;
/*     */   private final com.bytedance.sdk.openadsdk.core.d.h t;
/*  60 */   private boolean u = true;
/*  61 */   private boolean v = false;
/*     */   
/*     */ 
/*     */   private WeakReference<e> w;
/*     */   
/*  66 */   private long x = 0L;
/*     */   
/*  68 */   private boolean y = false;
/*  69 */   private boolean z = false;
/*  70 */   private boolean A = false;
/*     */   
/*     */   private void b(Context paramContext) {
/*  73 */     EnumSet localEnumSet = EnumSet.noneOf(b.a.class);
/*  74 */     localEnumSet.add(b.a.a);
/*  75 */     localEnumSet.add(b.a.e);
/*     */     
/*  77 */     this.d = new h(paramContext, LayoutInflater.from(paramContext.getApplicationContext()).inflate(R.layout.tt_video_play_layout_for_live, null, false), true, localEnumSet, this.t, this);
/*  78 */     this.d.a(this);
/*     */   }
/*     */   
/*     */   public g(Context paramContext, ViewGroup paramViewGroup, com.bytedance.sdk.openadsdk.core.d.h paramh) {
/*  82 */     this.e = paramViewGroup;
/*  83 */     this.p = new WeakReference(paramContext);
/*  84 */     this.t = paramh;
/*  85 */     b(paramContext);
/*     */     
/*  87 */     this.q = (Build.VERSION.SDK_INT >= 17);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<String> paramList, String paramString3, long paramLong, boolean paramBoolean)
/*     */   {
/*  94 */     m.b(c, "video local url " + paramString1);
/*  95 */     if (q.a(paramString1)) {
/*  96 */       m.e(c, "No video info");
/*  97 */       return false;
/*     */     }
/*  99 */     this.v = paramBoolean;
/* 100 */     if (paramLong > 0L) {
/* 101 */       this.k = paramLong;
/* 102 */       this.l = (this.l > this.k ? this.l : this.k);
/*     */     }
/* 104 */     if (this.d != null) {
/* 105 */       this.d.f();
/*     */       
/* 107 */       this.d.e();
/* 108 */       this.d.c(paramInt1, paramInt2);
/* 109 */       this.d.a(this.e);
/* 110 */       this.d.a(paramInt1, paramInt2);
/*     */     }
/* 112 */     if (this.i == null) {
/* 113 */       this.i = new com.bytedance.sdk.openadsdk.core.video.c.d(this.f);
/*     */     }
/*     */     
/* 116 */     this.h = 0L;
/*     */     try {
/* 118 */       a(paramString1);
/*     */     } catch (Exception localException) {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */   
/*     */   public com.bytedance.sdk.openadsdk.core.video.c.d h()
/*     */   {
/* 127 */     return this.i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long d()
/*     */   {
/* 137 */     return this.k;
/*     */   }
/*     */   
/*     */   public void a(long paramLong)
/*     */   {
/* 142 */     this.k = paramLong;
/* 143 */     this.l = (this.l > this.k ? this.l : this.k);
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean)
/*     */   {
/* 148 */     this.u = paramBoolean;
/* 149 */     this.d.a(paramBoolean);
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
/*     */   public boolean g()
/*     */   {
/* 163 */     return this.y;
/*     */   }
/*     */   
/*     */   public void b(long paramLong) {
/* 167 */     this.x = paramLong;
/*     */   }
/*     */   
/*     */   public long f() {
/* 171 */     return this.m;
/*     */   }
/*     */   
/*     */   public void c(long paramLong) {
/* 175 */     this.m = paramLong;
/*     */   }
/*     */   
/*     */   public long e()
/*     */   {
/* 180 */     return this.i == null ? 0L : this.i.m() + this.x;
/*     */   }
/*     */   
/*     */   public boolean i() {
/* 184 */     return this.v;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/* 188 */     this.v = paramBoolean;
/* 189 */     if (this.i != null)
/* 190 */       this.i.a(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean j() {
/* 194 */     return this.A;
/*     */   }
/*     */   
/*     */   public int k()
/*     */   {
/* 199 */     return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.l, this.m);
/*     */   }
/*     */   
/*     */   private void a(String paramString) throws Exception {
/* 203 */     if (this.i != null) {
/* 204 */       this.i.a(paramString);
/*     */     }
/* 206 */     this.g = System.currentTimeMillis();
/* 207 */     if (!q.a(paramString)) {
/* 208 */       this.d.a(8);
/* 209 */       this.d.a(0);
/*     */       
/* 211 */       a(new Runnable()
/*     */       {
/*     */         public void run() {
/* 214 */           g.a(g.this, System.currentTimeMillis());
/* 215 */           g.a(g.this).d(0);
/* 216 */           if ((g.b(g.this) != null) && (g.c(g.this) == 0L)) {
/* 217 */             g.b(g.this).a(true, 0L, !g.d(g.this));
/* 218 */           } else if (g.b(g.this) != null) {
/* 219 */             g.b(g.this).a(true, g.c(g.this), !g.d(g.this));
/*     */           }
/* 221 */           if (g.e(g.this) != null) {
/* 222 */             g.e(g.this).postDelayed(g.f(g.this), 100L);
/*     */           }
/* 224 */           g.this.l();
/*     */         }
/*     */       });
/*     */     }
/* 228 */     q();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 233 */   private Runnable B = new Runnable()
/*     */   {
/*     */     public void run() {
/* 236 */       if (g.b(g.this) != null) {
/* 237 */         g.b(g.this).d();
/*     */       }
/*     */     }
/*     */   };
/*     */   
/* 242 */   private Runnable C = new Runnable()
/*     */   {
/*     */     public void run() {
/* 245 */       if (g.g(g.this) != null) {
/* 246 */         g.g(g.this).a();
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   public void l() {
/* 252 */     m();
/* 253 */     this.f.postDelayed(this.D, 800L);
/*     */   }
/*     */   
/*     */   public void m() {
/* 257 */     this.f.removeCallbacks(this.D);
/*     */   }
/*     */   
/* 260 */   private Runnable D = new Runnable()
/*     */   {
/*     */     public void run() {
/* 263 */       if (g.b(g.this) != null) {
/* 264 */         if (g.h(g.this) <= 0L) {
/* 265 */           g.b(g.this).d();
/*     */         }
/* 267 */         g.b(g.this).e();
/*     */       }
/* 269 */       g.e(g.this).postDelayed(this, 200L);
/*     */     }
/*     */   };
/*     */   
/*     */   public void a(e parame)
/*     */   {
/* 275 */     this.w = new WeakReference(parame);
/*     */   }
/*     */   
/*     */   private void c(int paramInt)
/*     */   {
/* 280 */     if (!s()) {
/* 281 */       return;
/*     */     }
/* 283 */     if (this.d == null) {
/* 284 */       return;
/*     */     }
/* 286 */     this.d.g();
/* 287 */     if (this.j != null) {
/* 288 */       this.j.a(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
/*     */     }
/* 290 */     this.h = (System.currentTimeMillis() - this.g);
/* 291 */     this.d.a(this.t, this.p, true);
/* 292 */     if (!this.s) {
/* 293 */       com.bytedance.sdk.openadsdk.d.c.a((Context)this.p.get(), this.t, "embeded_ad", "feed_over", 
/* 294 */         e(), 100);
/* 295 */       this.s = true;
/* 296 */       a(this.m, this.m);
/* 297 */       this.l = (this.k = this.m);
/*     */     }
/* 299 */     if ((!this.u) && (this.a)) {
/* 300 */       e(this.d, null);
/*     */     }
/* 302 */     this.A = true;
/*     */   }
/*     */   
/*     */   private boolean s() {
/* 306 */     return (this.p != null) && (this.p.get() != null);
/*     */   }
/*     */   
/*     */   public void a(Runnable paramRunnable)
/*     */   {
/* 311 */     if (paramRunnable == null) {
/* 312 */       return;
/*     */     }
/* 314 */     if ((this.d.m()) && (this.o)) {
/* 315 */       paramRunnable.run();
/*     */     } else {
/* 317 */       b(paramRunnable);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(Runnable paramRunnable) {
/* 322 */     if (this.n == null) {
/* 323 */       this.n = new ArrayList();
/*     */     }
/* 325 */     this.n.add(paramRunnable);
/*     */   }
/*     */   
/*     */   private void t() {
/* 329 */     if ((this.n == null) || (this.n.isEmpty())) {
/* 330 */       return;
/*     */     }
/* 332 */     ArrayList localArrayList = new ArrayList(this.n);
/* 333 */     for (Runnable localRunnable : localArrayList) {
/* 334 */       localRunnable.run();
/*     */     }
/* 336 */     this.n.clear();
/*     */   }
/*     */   
/*     */   public void a(c.a parama)
/*     */   {
/* 341 */     this.j = parama;
/*     */   }
/*     */   
/*     */   public void a()
/*     */   {
/* 346 */     if (this.i != null) {
/* 347 */       this.i.a();
/*     */     }
/* 349 */     r();
/*     */   }
/*     */   
/*     */   public void b()
/*     */   {
/* 354 */     if (this.d != null) {
/* 355 */       this.d.f();
/*     */     }
/* 357 */     if (this.i != null) {
/* 358 */       this.i.a(false, this.k, !this.v);
/* 359 */       l();
/*     */       
/* 361 */       q();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void e(long paramLong)
/*     */   {
/* 368 */     this.k = paramLong;
/* 369 */     this.l = (this.l > this.k ? this.l : this.k);
/* 370 */     if (this.d != null) {
/* 371 */       this.d.f();
/*     */     }
/* 373 */     if (this.i != null) {
/* 374 */       this.i.a(true, this.k, !this.v);
/* 375 */       l();
/*     */       
/* 377 */       q();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void c()
/*     */   {
/* 384 */     if (this.i != null) {
/* 385 */       this.i.b();
/*     */     }
/*     */     
/* 388 */     if (this.d != null) {
/* 389 */       this.d.i();
/*     */     }
/* 391 */     if (this.f != null) {
/* 392 */       this.f.removeCallbacks(this.C);
/* 393 */       this.f.removeCallbacks(this.B);
/*     */     }
/* 395 */     m();
/*     */     
/* 397 */     r();
/* 398 */     if ((!this.s) && (this.r))
/*     */     {
/* 400 */       com.bytedance.sdk.openadsdk.d.c.a((Context)this.p.get(), this.t, "embeded_ad", "feed_break", 
/* 401 */         e(), k());
/* 402 */       this.s = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(Message paramMessage)
/*     */   {
/* 408 */     if ((this.d == null) || (paramMessage == null) || (this.p == null) || 
/* 409 */       (this.p.get() == null)) {
/* 410 */       return;
/*     */     }
/* 412 */     switch (paramMessage.what) {
/*     */     case 302: 
/* 414 */       c(paramMessage.what);
/* 415 */       break;
/*     */     case 108: 
/* 417 */       if (((paramMessage.obj instanceof Long)) && 
/* 418 */         (((Long)paramMessage.obj).longValue() > 0L)) {
/* 419 */         this.m = ((Long)paramMessage.obj).longValue();
/*     */       }
/*     */       
/*     */       break;
/*     */     case 304: 
/* 424 */       int i1 = paramMessage.arg1;
/* 425 */       if (this.d != null) {
/* 426 */         this.d.g();
/*     */       }
/* 428 */       if ((this.q) && (i1 == 3) && (!this.r)) {
/* 429 */         if (this.u) {
/* 430 */           com.bytedance.sdk.openadsdk.d.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_auto_play");
/*     */         } else {
/* 432 */           com.bytedance.sdk.openadsdk.d.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_play");
/*     */         }
/* 434 */         this.r = true;
/*     */       }
/*     */       break;
/*     */     case 305: 
/* 438 */       if (this.f != null) {
/* 439 */         this.f.removeCallbacks(this.C);
/*     */       }
/* 441 */       if ((!this.q) && (!this.r)) {
/* 442 */         if (this.u) {
/* 443 */           com.bytedance.sdk.openadsdk.d.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_auto_play");
/*     */         } else {
/* 445 */           com.bytedance.sdk.openadsdk.d.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_play");
/*     */         }
/* 447 */         this.r = true;
/*     */       }
/* 449 */       if (this.d != null) {
/* 450 */         this.d.g();
/*     */       }
/*     */       break;
/*     */     case 109: 
/* 454 */       if ((paramMessage.obj instanceof Long)) {
/* 455 */         this.k = ((Long)paramMessage.obj).longValue();
/* 456 */         this.l = (this.l > this.k ? this.l : this.k);
/* 457 */         a(this.k, this.m);
/*     */       }
/*     */       break;
/*     */     case 303: 
/* 461 */       if (this.d != null) {
/* 462 */         this.d.g();
/*     */       }
/* 464 */       if (this.j != null) {
/* 465 */         this.j.b(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
/*     */       }
/*     */       break;
/*     */     case 306: 
/* 469 */       if (this.d != null) {
/* 470 */         this.d.g();
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView)
/*     */   {
/* 478 */     if ((this.i == null) || (!s())) {
/* 479 */       return;
/*     */     }
/* 481 */     if (this.i.f()) {
/* 482 */       a();
/* 483 */       this.d.a(true, false);
/* 484 */       this.d.d();
/*     */     }
/* 486 */     else if (!this.i.g()) {
/* 487 */       if (this.d != null) {
/* 488 */         this.d.a(this.e);
/*     */       }
/* 490 */       e(this.k);
/* 491 */       if (this.d != null) {
/* 492 */         this.d.a(false, false);
/*     */       }
/*     */     } else {
/* 495 */       b();
/* 496 */       if (this.d != null) {
/* 497 */         this.d.a(false, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(b paramb, int paramInt)
/*     */   {
/* 505 */     if (this.i == null) {
/* 506 */       return;
/*     */     }
/* 508 */     l();
/* 509 */     a(this.b, d(paramInt));
/*     */   }
/*     */   
/*     */   public void b(b paramb, int paramInt)
/*     */   {
/* 514 */     if (this.i != null) {
/* 515 */       m();
/*     */     }
/* 517 */     if (this.d != null) {
/* 518 */       this.d.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(b paramb, int paramInt, boolean paramBoolean)
/*     */   {
/* 524 */     if (!s()) {
/* 525 */       return;
/*     */     }
/* 527 */     Context localContext = (Context)this.p.get();
/* 528 */     long l1 = ((float)(paramInt * this.m) * 1.0F / localContext.getResources().getInteger(R.integer.video_progress_max));
/* 529 */     if (this.m > 0L) {
/* 530 */       this.b = ((int)l1);
/*     */     } else {
/* 532 */       this.b = 0L;
/*     */     }
/* 534 */     if (this.d != null) {
/* 535 */       this.d.a(this.b);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(long paramLong1, long paramLong2) {
/* 540 */     this.k = paramLong1;
/* 541 */     this.m = paramLong2;
/* 542 */     this.d.a(paramLong1, paramLong2);
/* 543 */     int i1 = com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1, paramLong2);
/* 544 */     this.d.b(i1);
/*     */   }
/*     */   
/*     */   public void b(b paramb, View paramView)
/*     */   {
/* 549 */     a(paramb, paramView, false, false);
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 554 */     if (!s()) {
/* 555 */       return;
/*     */     }
/* 557 */     c(!this.a);
/* 558 */     if (!(this.p.get() instanceof Activity)) {
/* 559 */       m.b(c, "context is not activity, not support this function.");
/* 560 */       return;
/*     */     }
/* 562 */     if (this.a) {
/* 563 */       a(paramBoolean1 ? 8 : 0);
/*     */       
/* 565 */       if (this.d != null) {
/* 566 */         this.d.b(this.e);
/* 567 */         this.d.c(false);
/*     */       }
/*     */     } else {
/* 570 */       a(1);
/*     */       
/* 572 */       if (this.d != null) {
/* 573 */         this.d.c(this.e);
/* 574 */         this.d.c(false);
/*     */       }
/*     */     }
/*     */     
/* 578 */     Object localObject = this.w != null ? (e)this.w.get() : null;
/* 579 */     if (localObject != null) {
/* 580 */       ((e)localObject).a(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(int paramInt)
/*     */   {
/* 586 */     if (!s()) {
/* 587 */       return;
/*     */     }
/*     */     
/* 590 */     int i1 = (paramInt == 0) || (paramInt == 8) ? 1 : 0;
/* 591 */     Context localContext = (Context)this.p.get();
/* 592 */     if (!(localContext instanceof Activity)) {
/* 593 */       return;
/*     */     }
/* 595 */     Activity localActivity = (Activity)localContext;
/*     */     try
/*     */     {
/* 598 */       localActivity.setRequestedOrientation(paramInt);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 602 */     if (this.d != null) {
/* 603 */       this.d.o();
/*     */     }
/* 605 */     if (i1 == 0) {
/* 606 */       localActivity.getWindow().setFlags(1024, 1024);
/*     */     } else {
/* 608 */       localActivity.getWindow().clearFlags(1024);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void c(b paramb, View paramView)
/*     */   {
/* 615 */     if (this.d != null) {
/* 616 */       this.d.i();
/*     */     }
/* 618 */     c();
/*     */   }
/*     */   
/*     */ 
/*     */   public void b(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 624 */     if (this.u) {
/* 625 */       a();
/*     */     }
/* 627 */     if ((paramBoolean1) && (!this.u) && (!n())) {
/* 628 */       this.d.a(!o(), false);
/* 629 */       this.d.a(paramBoolean2, true, false);
/*     */     }
/* 631 */     if ((this.i != null) && (this.i.f())) {
/* 632 */       this.d.d();
/* 633 */       this.d.c();
/*     */     } else {
/* 635 */       this.d.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void d(b paramb, View paramView)
/*     */   {
/* 641 */     if (this.a) {
/* 642 */       c(false);
/* 643 */       if (this.d != null) {
/* 644 */         this.d.c(this.e);
/*     */       }
/* 646 */       a(1);
/*     */     } else {
/* 648 */       c();
/*     */     }
/*     */   }
/*     */   
/*     */   public void e(b paramb, View paramView)
/*     */   {
/* 654 */     a(paramb, paramView, false);
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView, boolean paramBoolean)
/*     */   {
/* 659 */     u();
/*     */   }
/*     */   
/*     */   private void u() {
/* 663 */     if (!s()) {
/* 664 */       return;
/*     */     }
/* 666 */     c(!this.a);
/* 667 */     if (!(this.p.get() instanceof Activity)) {
/* 668 */       m.b(c, "context is not activity, not support this function.");
/* 669 */       return;
/*     */     }
/* 671 */     if (this.d != null) {
/* 672 */       this.d.c(this.e);
/* 673 */       this.d.c(false);
/*     */     }
/* 675 */     a(1);
/* 676 */     Object localObject = this.w != null ? (e)this.w.get() : null;
/* 677 */     if (localObject != null) {
/* 678 */       ((e)localObject).a(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void c(boolean paramBoolean) {
/* 683 */     this.a = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void f(b paramb, View paramView) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(b paramb, SurfaceHolder paramSurfaceHolder)
/*     */   {
/* 694 */     this.o = true;
/* 695 */     if (this.i == null) {
/* 696 */       return;
/*     */     }
/* 698 */     this.i.a(paramSurfaceHolder);
/* 699 */     t();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(b paramb, SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
/*     */   
/*     */ 
/*     */   public void b(b paramb, SurfaceHolder paramSurfaceHolder)
/*     */   {
/* 709 */     this.o = false;
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
/*     */   public boolean n()
/*     */   {
/* 722 */     return this.i.h();
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
/*     */   public boolean o()
/*     */   {
/* 744 */     if (this.i != null) {
/* 745 */       return this.i.f();
/*     */     }
/* 747 */     return false;
/*     */   }
/*     */   
/* 750 */   protected boolean a = false;
/*     */   protected long b;
/*     */   
/*     */   public void d(long paramLong)
/*     */   {
/* 755 */     if (this.d == null) {
/* 756 */       return;
/*     */     }
/*     */     
/* 759 */     if (this.d.o()) {
/* 760 */       if ((paramLong == this.m) || (!this.a) || (this.m <= 0L)) {
/* 761 */         return;
/*     */       }
/* 763 */       this.b = paramLong;
/* 764 */       a(this.b, d((int)(this.k * 100L / this.m)));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void a(long paramLong, boolean paramBoolean)
/*     */   {
/* 770 */     if (this.i == null) {
/* 771 */       return;
/*     */     }
/* 773 */     if (paramBoolean) {
/* 774 */       p();
/*     */     }
/* 776 */     this.i.a(paramLong);
/*     */   }
/*     */   
/*     */   private boolean d(int paramInt) {
/* 780 */     return this.d.c(paramInt);
/*     */   }
/*     */   
/*     */   public void p() {
/* 784 */     if (this.d != null) {
/* 785 */       this.d.d(0);
/* 786 */       this.d.b(false, false);
/* 787 */       this.d.c(false);
/* 788 */       this.d.c();
/* 789 */       this.d.e();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(com.bytedance.sdk.openadsdk.core.widget.a parama, float paramFloat, boolean paramBoolean)
/*     */   {
/* 795 */     if (!s()) {
/* 796 */       return;
/*     */     }
/* 798 */     if ((parama != null) && (this.i != null) && (
/* 799 */       (this.i.f()) || 
/* 800 */       (this.i.g()))) {
/* 801 */       parama.a((Context)this.p.get(), paramFloat, paramBoolean, this.k, this.m);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(com.bytedance.sdk.openadsdk.core.widget.b.a parama, String paramString)
/*     */   {
/* 810 */     switch (6.a[parama.ordinal()]) {
/*     */     case 1: 
/* 812 */       a();
/* 813 */       break;
/*     */     case 2: 
/* 815 */       c();
/* 816 */       break;
/*     */     case 3: 
/* 818 */       b();
/* 819 */       this.y = false;
/* 820 */       this.z = true;
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean b(int paramInt)
/*     */   {
/* 826 */     n.a locala = com.bytedance.sdk.openadsdk.g.n.b(com.bytedance.sdk.openadsdk.core.n.a());
/* 827 */     if ((locala != n.a.e) && (locala != n.a.a)) {
/* 828 */       a();
/* 829 */       this.y = true;
/* 830 */       this.z = false;
/* 831 */       if ((this.d != null) && (this.t != null)) {
/* 832 */         return this.d.a(paramInt, this.t.a());
/*     */       }
/* 834 */     } else if (locala == n.a.e) {
/* 835 */       this.y = false;
/* 836 */       if (this.d != null) {
/* 837 */         this.d.a();
/*     */       }
/*     */     }
/* 840 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 846 */   private final BroadcastReceiver E = new BroadcastReceiver()
/*     */   {
/*     */     public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
/* 849 */       String str = paramAnonymousIntent.getAction();
/* 850 */       if ("android.intent.action.SCREEN_OFF".equals(str)) {
/* 851 */         g.this.a();
/* 852 */       } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
/* 853 */         g.this.a(paramAnonymousContext);
/*     */       }
/*     */     }
/*     */   };
/*     */   
/* 858 */   private n.a F = com.bytedance.sdk.openadsdk.g.n.b(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext());
/*     */   
/*     */   protected void a(Context paramContext) {
/* 861 */     if (!s()) {
/* 862 */       return;
/*     */     }
/* 864 */     n.a locala = com.bytedance.sdk.openadsdk.g.n.b(paramContext);
/*     */     
/* 866 */     if (this.F == locala) {
/* 867 */       return;
/*     */     }
/*     */     
/* 870 */     if (!this.z) {
/* 871 */       b(2);
/*     */     }
/*     */     
/* 874 */     this.F = locala;
/*     */   }
/*     */   
/* 877 */   private boolean G = false;
/*     */   
/*     */   protected void q() {
/* 880 */     if (this.G) {
/* 881 */       return;
/*     */     }
/* 883 */     Context localContext = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
/* 884 */     this.G = true;
/* 885 */     IntentFilter localIntentFilter = new IntentFilter();
/* 886 */     localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
/*     */     try {
/* 888 */       localContext.registerReceiver(this.E, localIntentFilter);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   protected void r() {
/* 894 */     if (!this.G) {
/* 895 */       return;
/*     */     }
/* 897 */     Context localContext = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
/* 898 */     this.G = false;
/*     */     try {
/* 900 */       localContext.unregisterReceiver(this.E);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\a\g.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */