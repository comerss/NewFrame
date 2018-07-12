/*     */ package com.bytedance.sdk.openadsdk.dddd;
/*     */ 
/*     */ import android.os.Handler;
/*     */
/*     */ import android.os.HandlerThread;
/*     */ import android.os.Message;
/*     */ import com.bytedance.sdk.openadsdk.core.AdNativeListener;
/*     */ import com.bytedance.sdk.openadsdk.ggg.k;
/*     */ import com.bytedance.sdk.openadsdk.ggg.LogUtils;
/*     */ import java.util.LinkedList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class doErrorHelper<T>
/*     */   extends HandlerThread
/*     */   implements Handler.Callback
/*     */ {
/*     */   private d<T> a;
/*     */   private AdNativeListener<T> b;
/*     */   private List<T> c;
/*     */   private long d;
/*     */   private boolean e;
/*     */   private int f;
/*     */   private Handler g;
/*     */   private a h;
/*     */   private b i;
/*     */   
/*     */   doErrorHelper(d<T> paramd, AdNativeListener<T> paramo, b paramb, a parama)
/*     */   {
/*  49 */     super("ttad_bk");
/*  50 */     this.i = paramb;
/*  51 */     this.h = parama;
/*  52 */     this.a = paramd;
/*  53 */     this.b = paramo;
/*  54 */     this.c = new LinkedList();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onLooperPrepared()
/*     */   {
/*  60 */     this.d = System.currentTimeMillis();
/*  61 */     this.g = new Handler(getLooper(), this);
/*     */   }
/*     */   
/*     */   public boolean handleMessage(Message paramMessage)
/*     */   {
/*  66 */     switch (paramMessage.what) {
/*     */     /*case 1:
*//*  68 *//*       OnAdLoad((g)paramMessage.obj);
*//*  69 *//*       break;
*//*     *//*     case 2:
*//*  71 *//*       d();
*//*  72 *//*       break;
*//*     *//*     case 3:
*//*  74 *//*       c();
*//*  75 *//*       break;
*//*     *//*     case 4:
*//*  77 *//*       b();
*//*  78 *//*       break;
*//*     *//*     case 5:
*//*  80 *//*       OnAdLoad();*/
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   private void a() {
/*  87 */     this.a.a(this.i.d, this.i.e);
/*     */     
/*  89 */     this.e = this.a.b();
/*  90 */     this.f = this.a.c();
/*  91 */     if (this.e) {
/*  92 */       a("onHandleInitEvent serverBusy, retryCount = " + this.f);
/*  93 */       h();
/*     */     } else {
/*  95 */       List localList = this.a.a();
/*  96 */       this.c.addAll(localList);
/*  97 */       a("onHandleInitEvent cacheData count = " + this.c.size());
/*  98 */       e();
/*     */     }
/*     */   }
/*     */   
/*     */   private void b()
/*     */   {
/* 104 */     if (!this.h.a())
/*     */     {
/* 106 */       a(4, this.i.c);
/* 107 */       a("onHandleServerBusyRetryEvent, no net");
/* 108 */       return;
/*     */     }
/* 110 */     List localList = this.a.a();
/* 111 */     if (k.a(localList)) {
/* 112 */       a("onHandleServerBusyRetryEvent, empty list start routine");
/*     */       
/*     */ 
/* 115 */       n();
/*     */       
/* 117 */       j();
/* 118 */       return;
/*     */     }
/* 120 */     g localg = this.b.a(localList);
/* 121 */     if (localg != null) {
/* 122 */       if (localg.a) {
/* 123 */         a("onHandleServerBusyRetryEvent, success");
/*     */         
/* 125 */         g();
/*     */         
/* 127 */         f();
/*     */       }
/* 129 */       else if (a(localg)) {
/* 130 */         this.f += 1;
/* 131 */         this.a.a(this.f);
/* 132 */         this.a.a(localList, this.i.d, this.i.e);
/*     */         
/*     */ 
/* 135 */         h();
/* 136 */         a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.f);
/*     */       }
/* 138 */       else if (b(localg))
/*     */       {
/* 140 */         g();
/*     */         
/* 142 */         f();
/*     */       }
/*     */       else {
/* 145 */         i();
/* 146 */         a("onHandleServerBusyRetryEvent, net fail");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void c()
/*     */   {
/* 157 */     if (this.e)
/*     */     {
/* 159 */       return;
/*     */     }
/* 161 */     a("onHandleRoutineRetryEvent");
/* 162 */     e();
/*     */   }
/*     */   
/*     */   private void d()
/*     */   {
/* 167 */     if (this.e)
/*     */     {
/* 169 */       return;
/*     */     }
/* 171 */     a("onHandleRoutineUploadEvent");
/* 172 */     e();
/*     */   }
/*     */   
/*     */   private void a(T paramT)
/*     */   {
/* 177 */     this.a.a(paramT);
/* 178 */     if (this.e)
/*     */     {
/* 180 */       return;
/*     */     }
/* 182 */     a("onHandleReceivedAdEvent");
/* 183 */     this.c.add(paramT);
/* 184 */     if (m()) {
/* 185 */       a("onHandleReceivedAdEvent upload");
/* 186 */       e();
/*     */     }
/*     */   }
/*     */   
/*     */   private void e()
/*     */   {
/* 192 */     this.g.removeMessages(3);
/* 193 */     this.g.removeMessages(2);
/*     */     
/* 195 */     if (k.a(this.c)) {
/* 196 */       this.d = System.currentTimeMillis();
/*     */       
/* 198 */       j();
/* 199 */       return;
/*     */     }
/* 201 */     if (!this.h.a()) {
/* 202 */       a("doRoutineUpload no net, wait retry");
/* 203 */       i();
/* 204 */       return;
/*     */     }
/* 206 */     g localg = this.b.a(this.c);
/* 207 */     if (localg != null) {
/* 208 */       if (localg.a) {
/* 209 */         a("doRoutineUpload success");
/*     */         
/* 211 */         g();
/*     */         
/* 213 */         f();
/*     */ 
/*     */       }
/* 216 */       else if (a(localg)) {
/* 217 */         a("doRoutineUpload serverbusy");
/* 218 */         k();
/*     */       }
/* 220 */       else if (b(localg))
/*     */       {
/* 222 */         g();
/*     */         
/* 224 */         f();
/* 225 */       } else if (!this.e)
/*     */       {
/* 227 */         i();
/* 228 */         a("doRoutineUpload net fail retry");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void f()
/*     */   {
/* 237 */     this.d = System.currentTimeMillis();
/*     */     
/* 239 */     n();
/*     */     
/* 241 */     j();
/*     */   }
/*     */   
/*     */   private void g() {
/* 245 */     this.a.a(this.c);
/* 246 */     this.c.clear();
/*     */   }
/*     */   
/*     */   private void h()
/*     */   {
/* 251 */     a(4, l());
/*     */   }
/*     */   
/*     */   private void i() {
/* 255 */     a(3, this.i.c);
/*     */   }
/*     */   
/*     */   private void j() {
/* 259 */     a(2, this.i.b);
/*     */   }
/*     */   
/*     */   private void a(int paramInt, long paramLong) {
/* 263 */     Message localMessage = this.g.obtainMessage();
/* 264 */     localMessage.what = paramInt;
/* 265 */     this.g.sendMessageDelayed(localMessage, paramLong);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void k()
/*     */   {
/* 272 */     this.e = true;
/* 273 */     this.a.a(true);
/* 274 */     this.c.clear();
/* 275 */     this.g.removeMessages(3);
/* 276 */     this.g.removeMessages(2);
/* 277 */     h();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long l()
/*     */   {
/* 286 */     return (this.f % 3 + 1) * this.i.f;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean a(g paramg)
/*     */   {
/* 296 */     return paramg.b == 509;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean b(g paramg)
/*     */   {
/* 306 */     return paramg.d;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean m()
/*     */   {
/* 315 */     return (!this.e) && ((this.c.size() >= this.i.a) || 
/* 316 */       (System.currentTimeMillis() - this.d >= this.i.b));
/*     */   }
/*     */   
/*     */   private void n() {
/* 320 */     this.e = false;
/* 321 */     this.a.a(false);
/* 322 */     this.f = 0;
/* 323 */     this.a.a(0);
/* 324 */     this.g.removeMessages(4);
/*     */   }
/*     */   
/*     */   private void a(String paramString) {
/* 328 */     LogUtils.c("AdEventThread", paramString);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class b
/*     */   {
/*     */     final int a;
/*     */     
/*     */ 
/*     */     final long b;
/*     */     
/*     */ 
/*     */     final long c;
/*     */     
/*     */ 
/*     */     final int d;
/*     */     
/*     */ 
/*     */     final long e;
/*     */     
/*     */ 
/*     */     final long f;
/*     */     
/*     */ 
/*     */     b(int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3, long paramLong4)
/*     */     {
/* 355 */       this.a = paramInt1;
/* 356 */       this.b = paramLong1;
/* 357 */       this.c = paramLong2;
/* 358 */       this.d = paramInt2;
/* 359 */       this.e = paramLong3;
/* 360 */       this.f = paramLong4;
/*     */     }
/*     */     
/*     */     public static b a() {
/* 364 */       return new b(5, 120000L, 15000L, 5, 86400000L, 600000L);
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface a
/*     */   {
/*     */     public abstract boolean a();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\LocationUtils\doErrorHelper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */