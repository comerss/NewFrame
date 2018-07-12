/*     */ package com.bytedance.sdk.openadsdk.core.video.b;
/*     */ 
/*     */

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.video.a.b;
import com.bytedance.sdk.openadsdk.core.video.a.e;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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
/*     */ public class a
/*     */   implements com.bytedance.sdk.openadsdk.core.video.a.c, com.bytedance.sdk.openadsdk.core.video.a.d, MineHandler.OnResult
/*     */ {
/*  47 */   private static final String c = a.class.getSimpleName();
/*     */   private com.bytedance.sdk.openadsdk.core.video.a.h d;
/*     */   private ViewGroup e;
/*  50 */   private MineHandler f = new MineHandler(this);
/*  51 */   private long g = 0L;
/*  52 */   private long h = 0L;
/*     */   private com.bytedance.sdk.openadsdk.core.video.c.d i;
/*     */   private com.bytedance.sdk.openadsdk.core.video.a.c.a j;
/*  55 */   private long k = 0L;
/*  56 */   private long l = 0L;
/*     */   private long m;
/*     */   private ArrayList<Runnable> n;
/*     */   private boolean o;
/*     */   private WeakReference<Context> p;
/*  61 */   private boolean q = false;
/*  62 */   private boolean r = false;
/*  63 */   private boolean s = false;
/*     */   private final com.bytedance.sdk.openadsdk.core.nibuguan.h t;
/*  65 */   private boolean u = true;
/*  66 */   private boolean v = false;
/*     */   
/*     */ 
/*     */   private WeakReference<e> w;
/*     */   
/*  71 */   private long x = 0L;
/*     */   
/*  73 */   private boolean y = false;
/*  74 */   private boolean z = false;
/*  75 */   private boolean A = false;
/*     */   
/*     */   private void b(Context paramContext) {
/*  78 */     EnumSet localEnumSet = EnumSet.noneOf(com.bytedance.sdk.openadsdk.core.video.a.b.a.class);
/*  79 */     localEnumSet.add(com.bytedance.sdk.openadsdk.core.video.a.b.a.a);
/*  80 */     localEnumSet.add(com.bytedance.sdk.openadsdk.core.video.a.b.a.e);
/*     */     
/*  82 */     this.d = new com.bytedance.sdk.openadsdk.core.video.a.h(paramContext, LayoutInflater.from(paramContext.getApplicationContext()).inflate(R.layout.tt_video_play_layout_for_live, null, false), true, localEnumSet, this.t, this);
/*  83 */     this.d.a(this);
/*     */   }
/*     */   
/*     */   public a(Context paramContext, ViewGroup paramViewGroup, com.bytedance.sdk.openadsdk.core.nibuguan.h paramh) {
/*  87 */     this.e = paramViewGroup;
/*  88 */     this.p = new WeakReference(paramContext);
/*  89 */     this.t = paramh;
/*  90 */     b(paramContext);
/*     */     
/*  92 */     this.q = (Build.VERSION.SDK_INT >= 17);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean a(String paramString1, String paramString2, int paramInt1, int paramInt2, List<String> paramList, String paramString3, long paramLong, boolean paramBoolean)
/*     */   {
/*  99 */      LogUtils.b(c, "video local url " + paramString1);
/* 100 */     if (com.bytedance.sdk.openadsdk.ggg.q.a(paramString1)) {
/* 101 */       LogUtils.e(c, "No video info");
/* 102 */       return false;
/*     */     }
/* 104 */     this.v = paramBoolean;
/* 105 */     if (paramLong > 0L) {
/* 106 */       this.k = paramLong;
/* 107 */       this.l = (this.l > this.k ? this.l : this.k);
/*     */     }
/* 109 */     if (this.d != null) {
/* 110 */       this.d.f();
/*     */       
/* 112 */       this.d.e();
/* 113 */       this.d.c(paramInt1, paramInt2);
/* 114 */       this.d.a(this.e);
/* 115 */       this.d.a(paramInt1, paramInt2);
/*     */     }
/* 117 */     if (this.i == null) {
/* 118 */       this.i = new com.bytedance.sdk.openadsdk.core.video.c.d(this.f);
/*     */     }
/*     */     
/* 121 */     this.h = 0L;
/*     */     try {
/* 123 */       a(paramString1);
/*     */     } catch (Exception localException) {
/* 125 */       return false;
/*     */     }
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   public com.bytedance.sdk.openadsdk.core.video.c.d h()
/*     */   {
/* 132 */     return this.i;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long d()
/*     */   {
/* 142 */     return this.k;
/*     */   }
/*     */   
/*     */   public void a(long paramLong)
/*     */   {
/* 147 */     this.k = paramLong;
/* 148 */     this.l = (this.l > this.k ? this.l : this.k);
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean)
/*     */   {
/* 153 */     this.u = paramBoolean;
/* 154 */     this.d.a(paramBoolean);
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
/* 168 */     return this.y;
/*     */   }
/*     */   
/*     */   public void b(long paramLong) {
/* 172 */     this.x = paramLong;
/*     */   }
/*     */   
/*     */   public long f() {
/* 176 */     return this.m;
/*     */   }
/*     */   
/*     */   public void c(long paramLong) {
/* 180 */     this.m = paramLong;
/*     */   }
/*     */   
/*     */   public long e()
/*     */   {
/* 185 */     return this.i == null ? 0L : this.i.p() + this.x;
/*     */   }
/*     */   
/*     */   public boolean i() {
/* 189 */     return this.v;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/* 193 */     this.v = paramBoolean;
/* 194 */     if (this.i != null)
/* 195 */       this.i.a(paramBoolean);
/*     */   }
/*     */   
/*     */   public boolean j() {
/* 199 */     return this.A;
/*     */   }
/*     */   
/*     */   public int k()
/*     */   {
/* 204 */     return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.l, this.m);
/*     */   }
/*     */   
/*     */   private void a(String paramString) throws Exception {
/* 208 */     if (this.i != null) {
/* 209 */       this.i.a(paramString);
/*     */     }
/* 211 */     this.g = System.currentTimeMillis();
/* 212 */     if (!com.bytedance.sdk.openadsdk.ggg.q.a(paramString)) {
/* 213 */       this.d.a(8);
/* 214 */       this.d.a(0);
/*     */       
/* 216 */       a(new Runnable()
/*     */       {
/*     */         public void run() {
/* 219 */          g=System.currentTimeMillis();
/* 220 */           d.d(0);
/* 221 */           if ((i != null) && (k == 0L)) {
/* 222 */             i.a(true, 0L, !v);
/* 223 */           } else if (i != null) {
/* 224 */            i.a(true, k, !v);
/*     */           }
/* 226 */           if (f!= null) {
/* 227 */            f.postDelayed(B, 100L);
/*     */           }
/* 229 */          l();
/*     */         }
/*     */       });
/*     */     }
/* 233 */     q();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 238 */   private Runnable B = new Runnable()
/*     */   {
/*     */     public void run() {
/* 241 */       if (i != null) {
/* 242 */        i.d();
/*     */       }
/*     */     }
/*     */   };
/*     */   
/* 247 */   private Runnable C = new Runnable()
/*     */   {
/*     */     public void run() {
/* 250 */       if (j != null) {
/* 251 */         j.a();
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   public void l() {
/* 257 */     m();
/* 258 */     this.f.postDelayed(this.D, 800L);
/*     */   }
/*     */   
/*     */   public void m() {
/* 262 */     this.f.removeCallbacks(this.D);
/*     */   }
/*     */   
/* 265 */   private Runnable D = new Runnable()
/*     */   {
/*     */     public void run() {
/* 268 */       if (i!= null) {
/* 269 */         if (m<= 0L) {
/* 270 */          i.d();
/*     */         }
/* 272 */         i.e();
/*     */       }
/* 274 */       f.postDelayed(this, 200L);
/*     */     }
/*     */   };
/*     */   
/*     */   public void a(e parame)
/*     */   {
/* 280 */     this.w = new WeakReference(parame);
/*     */   }
/*     */   
/*     */   private void c(int paramInt)
/*     */   {
/* 285 */     if (!s()) {
/* 286 */       return;
/*     */     }
/* 288 */     if (this.d == null) {
/* 289 */       return;
/*     */     }
/* 291 */     this.d.g();
/* 292 */     this.h = (System.currentTimeMillis() - this.g);
/* 293 */     if (this.j != null) {
/* 294 */       this.j.a(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
/*     */     }
/*     */     
/* 297 */     if (!this.s) {
/* 298 */       com.bytedance.sdk.openadsdk.dddd.c.a((Context)this.p.get(), this.t, "embeded_ad", "feed_over", this.m, 100);
/*     */       
/* 300 */       this.s = true;
/* 301 */       a(this.m, this.m);
/* 302 */       this.l = (this.k = this.m);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 307 */     this.A = true;
/*     */   }
/*     */   
/*     */   private boolean s() {
/* 311 */     return (this.p != null) && (this.p.get() != null);
/*     */   }
/*     */   
/*     */   public void a(Runnable paramRunnable)
/*     */   {
/* 316 */     if (paramRunnable == null) {
/* 317 */       return;
/*     */     }
/* 319 */     if (d.n() && o) {
/* 320 */       paramRunnable.run();
/*     */     } else {
/* 322 */       b(paramRunnable);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(Runnable paramRunnable) {
/* 327 */     if (this.n == null) {
/* 328 */       this.n = new ArrayList();
/*     */     }
/* 330 */     this.n.add(paramRunnable);
/*     */   }
/*     */   
/*     */   private void t() {
/* 334 */     if ((this.n == null) || (this.n.isEmpty())) {
/* 335 */       return;
/*     */     }
/* 337 */     ArrayList<Runnable> localArrayList = new ArrayList(this.n);
/* 338 */     for (Runnable localRunnable : localArrayList) {
/* 339 */       localRunnable.run();
/*     */     }
/* 341 */     this.n.clear();
/*     */   }
/*     */   
/*     */   public void a(com.bytedance.sdk.openadsdk.core.video.a.c.a parama)
/*     */   {
/* 346 */     this.j = parama;
/*     */   }
/*     */   
/*     */   public void a()
/*     */   {
/* 351 */     if (this.i != null) {
/* 352 */       this.i.a();
/*     */     }
/* 354 */     if ((!this.s) && (this.r))
/*     */     {
/* 356 */       com.bytedance.sdk.openadsdk.dddd.c.a((Context)this.p.get(), this.t, "embeded_ad", "play_pause",
/* 357 */         e(), k());
/*     */     }
/* 359 */     r();
/*     */   }
/*     */   
/*     */   public void b()
/*     */   {
/* 364 */     if (this.d != null) {
/* 365 */       this.d.f();
/*     */     }
/* 367 */     if (this.i != null) {
/* 368 */       this.i.a(false, this.k, !this.v);
/* 369 */       l();
/* 370 */       q();
/*     */     }
/* 372 */     if ((!this.s) && (this.r)) {
/* 373 */       com.bytedance.sdk.openadsdk.dddd.c.a((Context)this.p.get(), this.t, "embeded_ad", "continue_play",
/* 374 */         e(), k());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void e(long paramLong)
/*     */   {
/* 381 */     this.k = paramLong;
/* 382 */     this.l = (this.l > this.k ? this.l : this.k);
/* 383 */     if (this.d != null) {
/* 384 */       this.d.f();
/*     */     }
/* 386 */     if (this.i != null) {
/* 387 */       this.i.a(true, this.k, !this.v);
/* 388 */       l();
/*     */       
/* 390 */       q();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void c()
/*     */   {
/* 397 */     if (this.i != null) {
/* 398 */       this.i.b();
/*     */     }
/*     */     
/* 401 */     if (this.d != null) {
/* 402 */       this.d.i();
/*     */     }
/* 404 */     if (this.f != null) {
/* 405 */       this.f.removeCallbacks(this.C);
/* 406 */       this.f.removeCallbacks(this.B);
/*     */     }
/* 408 */     m();
/*     */     
/* 410 */     r();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doResult(Message paramMessage)
/*     */   {
/* 421 */     if ((this.d == null) || (paramMessage == null) || (this.p == null) || 
/* 422 */       (this.p.get() == null)) {
/* 423 */       return;
/*     */     }
/* 425 */     switch (paramMessage.what) {
/*     */     case 302: 
/* 427 */       c(paramMessage.what);
/* 428 */       break;
/*     */     case 108: 
/* 430 */       if (((paramMessage.obj instanceof Long)) && 
/* 431 */         (((Long)paramMessage.obj).longValue() > 0L)) {
/* 432 */         this.m = ((Long)paramMessage.obj).longValue();
/*     */       }
/*     */       
/*     */       break;
/*     */     case 304: 
/* 437 */       int i1 = paramMessage.arg1;
/* 438 */       if (this.d != null) {
/* 439 */         this.d.g();
/*     */       }
/* 441 */       if ((this.q) && (i1 == 3) && (!this.r)) {
/* 442 */         com.bytedance.sdk.openadsdk.dddd.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_play");
/* 443 */         this.r = true;
/*     */       }
/*     */       break;
/*     */     case 305: 
/* 447 */       if (this.f != null) {
/* 448 */         this.f.removeCallbacks(this.C);
/*     */       }
/* 450 */       if ((!this.q) && (!this.r)) {
/* 451 */         com.bytedance.sdk.openadsdk.dddd.c.f((Context)this.p.get(), this.t, "embeded_ad", "feed_play");
/* 452 */         this.r = true;
/*     */       }
/* 454 */       if (this.d != null) {
/* 455 */         this.d.g();
/*     */       }
/*     */       break;
/*     */     case 109: 
/* 459 */       if ((paramMessage.obj instanceof Long)) {
/* 460 */         this.k = ((Long)paramMessage.obj).longValue();
/* 461 */         this.l = (this.l > this.k ? this.l : this.k);
/* 462 */         a(this.k, this.m);
/*     */       }
/*     */       break;
/*     */     case 303: 
/* 466 */       if (this.d != null) {
/* 467 */         this.d.g();
/*     */       }
/* 469 */       if (this.j != null) {
/* 470 */         this.j.b(this.h, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.k, this.m));
/*     */       }
/*     */       break;
/*     */     case 306: 
/* 474 */       if (this.d != null) {
/* 475 */         this.d.g();
/*     */       }
/*     */       break;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView)
/*     */   {
/* 483 */     if ((this.i == null) || (!s())) {
/* 484 */       return;
/*     */     }
/* 486 */     if (this.i.f()) {
/* 487 */       a();
/* 488 */       this.d.a(true, false);
/* 489 */       this.d.d();
/*     */     }
/* 491 */     else if (!this.i.g()) {
/* 492 */       if (this.d != null) {
/* 493 */         this.d.a(this.e);
/*     */       }
/* 495 */       e(this.k);
/* 496 */       if (this.d != null) {
/* 497 */         this.d.a(false, false);
/*     */       }
/*     */     } else {
/* 500 */       b();
/* 501 */       if (this.d != null) {
/* 502 */         this.d.a(false, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(b paramb, int paramInt)
/*     */   {
/* 510 */     if (this.i == null) {
/* 511 */       return;
/*     */     }
/* 513 */     l();
/* 514 */     a(this.b, d(paramInt));
/*     */   }
/*     */   
/*     */   public void b(b paramb, int paramInt)
/*     */   {
/* 519 */     if (this.i != null) {
/* 520 */       m();
/*     */     }
/* 522 */     if (this.d != null) {
/* 523 */       this.d.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(b paramb, int paramInt, boolean paramBoolean)
/*     */   {
/* 529 */     if (!s()) {
/* 530 */       return;
/*     */     }
/* 532 */     Context localContext = (Context)this.p.get();
/* 533 */     long l1 = (long) ((float)(paramInt * this.m) * 1.0F / localContext.getResources().getInteger(R.integer.video_progress_max));
/* 534 */     if (this.m > 0L) {
/* 535 */       this.b = ((int)l1);
/*     */     } else {
/* 537 */       this.b = 0L;
/*     */     }
/* 539 */     if (this.d != null) {
/* 540 */       this.d.a(this.b);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(long paramLong1, long paramLong2) {
/* 545 */     this.k = paramLong1;
/* 546 */     this.m = paramLong2;
/* 547 */     this.d.a(paramLong1, paramLong2);
/* 548 */     int i1 = com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1, paramLong2);
/* 549 */     this.d.b(i1);
/* 550 */     if (this.j != null) {
/* 551 */       this.j.a(paramLong1, paramLong2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(b paramb, View paramView)
/*     */   {
/* 557 */     a(paramb, paramView, false, false);
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 562 */     if (!s()) {
/* 563 */       return;
/*     */     }
/* 565 */     c(!this.a);
/* 566 */     if (!(this.p.get() instanceof Activity)) {
/* 567 */        LogUtils.b(c, "context is not activity, not support this function.");
/* 568 */       return;
/*     */     }
/* 570 */     if (this.a) {
/* 571 */       a(paramBoolean1 ? 8 : 0);
/*     */       
/* 573 */       if (this.d != null) {
/* 574 */         this.d.b(this.e);
/* 575 */         this.d.c(false);
/*     */       }
/*     */     } else {
/* 578 */       a(1);
/*     */       
/* 580 */       if (this.d != null) {
/* 581 */         this.d.c(this.e);
/* 582 */         this.d.c(false);
/*     */       }
/*     */     }
/*     */     
/* 586 */     Object localObject = this.w != null ? (e)this.w.get() : null;
/* 587 */     if (localObject != null) {
/* 588 */       ((e)localObject).a(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(int paramInt)
/*     */   {
/* 594 */     if (!s()) {
/* 595 */       return;
/*     */     }
/*     */     
/* 598 */     int i1 = (paramInt == 0) || (paramInt == 8) ? 1 : 0;
/* 599 */     Context localContext = (Context)this.p.get();
/* 600 */     if (!(localContext instanceof Activity)) {
/* 601 */       return;
/*     */     }
/* 603 */     Activity localActivity = (Activity)localContext;
/*     */     try
/*     */     {
/* 606 */       localActivity.setRequestedOrientation(paramInt);
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */     
/* 610 */     if (this.d != null) {
/* 611 */       this.d.o();
/*     */     }
/* 613 */     if (i1 == 0) {
/* 614 */       localActivity.getWindow().setFlags(1024, 1024);
/*     */     } else {
/* 616 */       localActivity.getWindow().clearFlags(1024);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void c(b paramb, View paramView)
/*     */   {
/* 623 */     if (this.d != null) {
/* 624 */       this.d.i();
/*     */     }
/* 626 */     c();
/*     */   }
/*     */   
/*     */ 
/*     */   public void b(b paramb, View paramView, boolean paramBoolean1, boolean paramBoolean2)
/*     */   {
/* 632 */     if (this.u) {
/* 633 */       a();
/*     */     }
/* 635 */     if ((paramBoolean1) && (!this.u) && (!n())) {
/* 636 */       this.d.a(!o(), false);
/* 637 */       this.d.a(paramBoolean2, true, false);
/*     */     }
/* 639 */     if ((this.i != null) && (this.i.f())) {
/* 640 */       this.d.d();
/* 641 */       this.d.c();
/*     */     } else {
/* 643 */       this.d.d();
/*     */     }
/*     */   }
/*     */   
/*     */   public void d(b paramb, View paramView)
/*     */   {
/* 649 */     if (this.a) {
/* 650 */       c(false);
/* 651 */       if (this.d != null) {
/* 652 */         this.d.c(this.e);
/*     */       }
/* 654 */       a(1);
/*     */     } else {
/* 656 */       c();
/*     */     }
/*     */   }
/*     */   
/*     */   public void e(b paramb, View paramView)
/*     */   {
/* 662 */     a(paramb, paramView, false);
/*     */   }
/*     */   
/*     */   public void a(b paramb, View paramView, boolean paramBoolean)
/*     */   {
/* 667 */     u();
/*     */   }
/*     */   
/*     */   private void u() {
/* 671 */     if (!s()) {
/* 672 */       return;
/*     */     }
/* 674 */     c(!this.a);
/* 675 */     if (!(this.p.get() instanceof Activity)) {
/* 676 */        LogUtils.b(c, "context is not activity, not support this function.");
/* 677 */       return;
/*     */     }
/* 679 */     if (this.d != null) {
/* 680 */       this.d.c(this.e);
/* 681 */       this.d.c(false);
/*     */     }
/* 683 */     a(1);
/* 684 */     Object localObject = this.w != null ? (e)this.w.get() : null;
/* 685 */     if (localObject != null) {
/* 686 */       ((e)localObject).a(this.a);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void c(boolean paramBoolean) {
/* 691 */     this.a = paramBoolean;
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
/* 702 */     this.o = true;
/* 703 */     if (this.i == null) {
/* 704 */       return;
/*     */     }
/* 706 */     this.i.a(paramSurfaceHolder);
/* 707 */     t();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void a(b paramb, SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
/*     */   
/*     */ 
/*     */   public void b(b paramb, SurfaceHolder paramSurfaceHolder)
/*     */   {
/* 717 */     this.o = false;
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
/* 730 */     return this.i.h();
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
/* 752 */     if (this.i != null) {
/* 753 */       return this.i.f();
/*     */     }
/* 755 */     return false;
/*     */   }
/*     */   
/* 758 */   protected boolean a = false;
/*     */   protected long b;
/*     */   
/*     */   public void d(long paramLong)
/*     */   {
/* 763 */     if (this.d == null) {
/* 764 */       return;
/*     */     }
/*     */     
/* 767 */     if (this.d.p()) {
/* 768 */       if ((paramLong == this.m) || (!this.a) || (this.m <= 0L)) {
/* 769 */         return;
/*     */       }
/* 771 */       this.b = paramLong;
/* 772 */       a(this.b, d((int)(this.k * 100L / this.m)));
/*     */     }
/*     */   }
/*     */   
/*     */   protected void a(long paramLong, boolean paramBoolean)
/*     */   {
/* 778 */     if (this.i == null) {
/* 779 */       return;
/*     */     }
/* 781 */     if (paramBoolean) {
/* 782 */       p();
/*     */     }
/* 784 */     this.i.a(paramLong);
/*     */   }
/*     */   
/*     */   private boolean d(int paramInt) {
/* 788 */     return this.d.c(paramInt);
/*     */   }
/*     */   
/*     */   public void p() {
/* 792 */     if (this.d != null) {
/* 793 */       this.d.d(0);
/* 794 */       this.d.b(false, false);
/* 795 */       this.d.c(false);
/* 796 */       this.d.c();
/* 797 */       this.d.e();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(com.bytedance.sdk.openadsdk.core.widget.a parama, float paramFloat, boolean paramBoolean)
/*     */   {
/* 803 */     if (!s()) {
/* 804 */       return;
/*     */     }
/* 806 */     if ((parama != null) && (this.i != null) && (
/* 807 */       (this.i.f()) || 
/* 808 */       (this.i.g()))) {
/* 809 */       parama.a((Context)this.p.get(), paramFloat, paramBoolean, this.k, this.m);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(com.bytedance.sdk.openadsdk.core.widget.b.enume parama, String paramString)
/*     */   {
/* 818 */     switch (parama.ordinal()) {
/*     */     case 1: 
/* 820 */       a();
/* 821 */       break;
/*     */     case 2: 
/* 823 */       c();
/* 824 */       break;
/*     */     case 3: 
/* 826 */       b();
/* 827 */       this.y = false;
/* 828 */       this.z = true;
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean b(int paramInt)
/*     */   {
/* 834 */     com.bytedance.sdk.openadsdk.ggg.n.a locala = com.bytedance.sdk.openadsdk.ggg.n.b(com.bytedance.sdk.openadsdk.core.n.a());
/* 835 */     if ((locala != com.bytedance.sdk.openadsdk.ggg.n.a.e) && (locala != com.bytedance.sdk.openadsdk.ggg.n.a.a)) {
/* 836 */       a();
/* 837 */       this.y = true;
/* 838 */       this.z = false;
/* 839 */       if ((this.d != null) && (this.t != null)) {
/* 840 */         return this.d.a(paramInt, this.t.a());
/*     */       }
/* 842 */     } else if (locala == com.bytedance.sdk.openadsdk.ggg.n.a.e) {
/* 843 */       this.y = false;
/* 844 */       if (this.d != null) {
/* 845 */         this.d.a();
/*     */       }
/*     */     }
/* 848 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 854 */   private final BroadcastReceiver E = new BroadcastReceiver()
/*     */   {
/*     */     public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {
/* 857 */       String str = paramAnonymousIntent.getAction();
/* 858 */       if ("android.intent.action.SCREEN_OFF".equals(str)) {
/* 859 */         a();
/* 860 */       } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
/* 861 */       a(paramAnonymousContext);
/*     */       }
/*     */     }
/*     */   };
/*     */   
/* 866 */   private com.bytedance.sdk.openadsdk.ggg.n.a F = com.bytedance.sdk.openadsdk.ggg.n.b(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext());
/*     */   
/*     */   protected void a(Context paramContext) {
/* 869 */     if (!s()) {
/* 870 */       return;
/*     */     }
/* 872 */     com.bytedance.sdk.openadsdk.ggg.n.a locala = com.bytedance.sdk.openadsdk.ggg.n.b(paramContext);
/*     */     
/* 874 */     if (this.F == locala) {
/* 875 */       return;
/*     */     }
/*     */     
/* 878 */     if (!this.z) {
/* 879 */       b(2);
/*     */     }
/*     */     
/* 882 */     this.F = locala;
/*     */   }
/*     */   
/* 885 */   private boolean G = false;
/*     */   
/*     */   protected void q() {
/* 888 */     if (this.G) {
/* 889 */       return;
/*     */     }
/* 891 */     Context localContext = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
/* 892 */     this.G = true;
/* 893 */     IntentFilter localIntentFilter = new IntentFilter();
/* 894 */     localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
/*     */     try {
/* 896 */       localContext.registerReceiver(this.E, localIntentFilter);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */   
/*     */   protected void r() {
/* 902 */     if (!this.G) {
/* 903 */       return;
/*     */     }
/* 905 */     Context localContext = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
/* 906 */     this.G = false;
/*     */     try {
/* 908 */       localContext.unregisterReceiver(this.E);
/*     */     }
/*     */     catch (Exception localException) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\result\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */