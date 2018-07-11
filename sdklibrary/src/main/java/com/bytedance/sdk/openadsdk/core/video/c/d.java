/*     */ package com.bytedance.sdk.openadsdk.core.video.c;
/*     */ 
/*     */

/*     */ import android.graphics.SurfaceTexture;
/*     */ import android.media.AudioManager;
/*     */
        /*     */ import android.os.Handler;
/*     */ import android.os.HandlerThread;
/*     */ import android.os.Message;
/*     */ import android.view.SurfaceHolder;
/*     */
        /*     */
        /*     */ import com.bytedance.sdk.openadsdk.ggg.t;
/*     */
        /*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   implements c.a, c.b, c.c, c.d, c.e, c.f, t.a
/*     */ {
/*  82 */   private c a = null;
/*  83 */   private boolean b = false;
/*  84 */   private boolean c = false;
/*     */   
/*     */   private boolean d;
/*     */   
/*  88 */   private int e = 201;
/*  89 */   private long f = -1L;
/*     */   
/*     */ 
/*     */ 
/*     */   private Handler g;
/*     */   
/*     */ 
/*     */ 
/*     */   private Handler h;
/*     */   
/*     */ 
/*     */   private ArrayList<Runnable> i;
/*     */   
/*     */ 
/* 103 */   private int j = 0;
/*     */   private int k;
/* 105 */   private static boolean l = false;
/*     */   
/* 107 */   private String m = "0";
/*     */   
/* 109 */   private static Map<Integer, Integer> n = new HashMap();
/*     */   private boolean o;
/*     */   
/* 112 */   public d(Handler paramHandler) { this(paramHandler, -1); }
/*     */   
/*     */   public d(Handler paramHandler, int paramInt)
/*     */   {
/* 116 */     this.j = 0;
/*     */     
/* 118 */     this.h = paramHandler;
/* 119 */     HandlerThread localHandlerThread = new HandlerThread("VideoManager");
/* 120 */     localHandlerThread.start();
/* 121 */     this.g = new t(localHandlerThread.getLooper(), this);
/* 122 */     this.v = (Build.VERSION.SDK_INT >= 17);
/* 123 */     n();
/*     */   }
/*     */   
/*     */   private void n() {
/* 127 */     if (this.a == null) {
/* 128 */       m.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
/* 129 */       this.a = new b();
/* 130 */       this.m = "0";
/* 131 */       this.a.a(this);
/* 132 */       this.a.a(this);
/* 133 */       this.a.a(this);
/* 134 */       this.a.a(this);
/* 135 */       this.a.a(this);
/* 136 */       this.a.a(this);
/* 137 */       this.a.b(this.b);
/* 138 */       this.c = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean1, long paramLong, boolean paramBoolean2)
/*     */   {
/* 144 */     this.o = false;
/* 145 */     if (!paramBoolean2)
/*     */     {
/* 147 */       if (this.a != null) {
/* 148 */         a(true);
/*     */       }
/*     */     }
/* 151 */     else if (this.a != null) {
/* 152 */       a(false);
/*     */     }
/*     */     
/* 155 */     if (paramBoolean1)
/*     */     {
/* 157 */       c();
/* 158 */       this.f = paramLong;
/*     */     } else {
/* 160 */       p();
/* 161 */       if (this.a != null) {
/* 162 */         this.f = (paramLong > this.a.i() ? paramLong : this.a.i());
/*     */       }
/* 164 */       a(new Runnable()
/*     */       {
/*     */         public void run() {
/* 167 */           d.a(d.this).sendEmptyMessageDelayed(100, 50L);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a()
/*     */   {
/* 178 */     this.g.removeMessages(100);
/* 179 */     this.o = true;
/* 180 */     this.g.sendEmptyMessage(101);
/* 181 */     q();
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
/*     */   public void b()
/*     */   {
/* 197 */     this.e = 203;
/* 198 */     q();
/* 199 */     if (this.a == null) {
/* 200 */       return;
/*     */     }
/* 202 */     o();
/* 203 */     if (this.g != null) {
/*     */       try {
/* 205 */         b("release");
/* 206 */         this.g.removeCallbacksAndMessages(null);
/* 207 */         this.d = true;
/* 208 */         this.g.sendEmptyMessage(103);
/*     */       }
/*     */       catch (Throwable localThrowable) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void c()
/*     */   {
/* 221 */     a(new Runnable()
/*     */     {
/*     */       public void run() {
/* 224 */         if (d.a(d.this) != null) {
/* 225 */           d.a(d.this).sendEmptyMessage(104);
/*     */         }
/*     */       }
/*     */     });
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
/*     */   public void a(final long paramLong)
/*     */   {
/* 244 */     q();
/* 245 */     if ((this.e == 207) || (this.e == 206) || (this.e == 209))
/*     */     {
/* 247 */       a(new Runnable()
/*     */       {
/*     */         public void run() {
/* 250 */           if (d.a(d.this) != null) {
/* 251 */             d.a(d.this).obtainMessage(106, Long.valueOf(paramLong)).sendToTarget();
/*     */           }
/*     */         }
/*     */       });
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
/* 270 */   private final Set<SurfaceTexture> p = new HashSet();
/*     */   
/*     */   /* Error */
/*     */   private boolean a(@android.support.annotation.NonNull SurfaceTexture paramSurfaceTexture)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield 74	com/bytedance/sdk/openadsdk/core/video/cdsss/d:mP	Ljava/util/Set;
/*     */     //   4: dup
/*     */     //   5: astore_2
/*     */     //   6: monitorenter
/*     */     //   7: aload_0
/*     */     //   8: getfield 74	com/bytedance/sdk/openadsdk/core/video/cdsss/d:mP	Ljava/util/Set;
/*     */     //   11: aload_1
/*     */     //   12: invokeinterface 170 2 0
/*     */     //   17: aload_2
/*     */     //   18: monitorexit
/*     */     //   19: ireturn
/*     */     //   20: astore_3
/*     */     //   21: aload_2
/*     */     //   22: monitorexit
/*     */     //   23: aload_3
/*     */     //   24: athrow
/*     */     // Line number table:
/*     */     //   Java source line #273	-> byte code offset #0
/*     */     //   Java source line #274	-> byte code offset #7
/*     */     //   Java source line #275	-> byte code offset #20
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	25	0	this	d
/*     */     //   0	25	1	paramSurfaceTexture	SurfaceTexture
/*     */     //   5	17	2	Ljava/lang/Object;	Object
/*     */     //   20	4	3	localObject1	Object
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   7	19	20	finally
/*     */     //   20	23	20	finally
/*     */   }
/*     */   
/*     */   public void a(final SurfaceHolder paramSurfaceHolder)
/*     */   {
/* 279 */     a(new Runnable()
/*     */     {
/*     */       public void run() {
/* 282 */         d.b(d.this);
/* 283 */         if (d.a(d.this) != null) {
/* 284 */           d.a(d.this).obtainMessage(110, paramSurfaceHolder).sendToTarget();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   public void d() {
/* 291 */     if (this.g != null) {
/* 292 */       this.g.obtainMessage(108).sendToTarget();
/*     */     }
/*     */   }
/*     */   
/*     */   public void e() {
/* 297 */     if (this.g != null) {
/* 298 */       this.g.obtainMessage(109).sendToTarget();
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
/*     */   public void a(final String paramString)
/*     */   {
/* 311 */     a(new Runnable()
/*     */     {
/*     */       public void run() {
/* 314 */         d.b(d.this);
/* 315 */         if (d.a(d.this) != null) {
/* 316 */           d.a(d.this).obtainMessage(107, paramString).sendToTarget();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean f()
/*     */   {
/* 327 */     return ((this.e == 206) || (this.g.hasMessages(100))) && (!this.o);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean g()
/*     */   {
/* 335 */     return ((this.e == 207) || (this.o)) && (!this.g.hasMessages(100));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean h()
/*     */   {
/* 343 */     return this.e == 209;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void a(Message paramMessage)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: aload_1
/*     */     //   3: getfield 58	android/os/Message:what	I
/*     */     //   6: istore_3
/*     */     //   7: aconst_null
/*     */     //   8: astore 4
/*     */     //   10: aload_0
/*     */     //   11: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   14: ifnull +1064 -> 1078
/*     */     //   17: aload_1
/*     */     //   18: getfield 58	android/os/Message:what	I
/*     */     //   21: lookupswitch	default:+1057->1078, 100:+115->136, 101:+221->242, 102:+436->457, 103:+359->380, 104:+293->314, 105:+833->854, 106:+468->489, 107:+538->559, 108:+920->941, 109:+981->1002, 110:+755->776, 111:+647->668, 201:+1054->1075
/*     */     //   136: aload_0
/*     */     //   137: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   140: sipush 205
/*     */     //   143: if_icmpeq +33 -> 176
/*     */     //   146: aload_0
/*     */     //   147: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   150: sipush 206
/*     */     //   153: if_icmpeq +23 -> 176
/*     */     //   156: aload_0
/*     */     //   157: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   160: sipush 207
/*     */     //   163: if_icmpeq +13 -> 176
/*     */     //   166: aload_0
/*     */     //   167: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   170: sipush 209
/*     */     //   173: if_icmpne +64 -> 237
/*     */     //   176: aload_0
/*     */     //   177: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   180: invokeinterface 159 1 0
/*     */     //   185: aload_0
/*     */     //   186: sipush 206
/*     */     //   189: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   192: aload_0
/*     */     //   193: getfield 64	com/bytedance/sdk/openadsdk/core/video/cdsss/d:f	J
/*     */     //   196: lconst_0
/*     */     //   197: lcmp
/*     */     //   198: ifle +23 -> 221
/*     */     //   201: aload_0
/*     */     //   202: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   205: aload_0
/*     */     //   206: getfield 64	com/bytedance/sdk/openadsdk/core/video/cdsss/d:f	J
/*     */     //   209: invokeinterface 146 3 0
/*     */     //   214: aload_0
/*     */     //   215: ldc2_w 54
/*     */     //   218: putfield 64	com/bytedance/sdk/openadsdk/core/video/cdsss/d:f	J
/*     */     //   221: goto +857 -> 1078
/*     */     //   224: astore 5
/*     */     //   226: sipush 1004
/*     */     //   229: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   232: astore 4
/*     */     //   234: goto +844 -> 1078
/*     */     //   237: iconst_1
/*     */     //   238: istore_2
/*     */     //   239: goto +839 -> 1078
/*     */     //   242: aload_0
/*     */     //   243: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   246: sipush 206
/*     */     //   249: if_icmpeq +23 -> 272
/*     */     //   252: aload_0
/*     */     //   253: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   256: sipush 207
/*     */     //   259: if_icmpeq +13 -> 272
/*     */     //   262: aload_0
/*     */     //   263: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   266: sipush 209
/*     */     //   269: if_icmpne +40 -> 309
/*     */     //   272: aload_0
/*     */     //   273: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   276: invokeinterface 161 1 0
/*     */     //   281: aload_0
/*     */     //   282: sipush 207
/*     */     //   285: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   288: aload_0
/*     */     //   289: iconst_0
/*     */     //   290: putfield 73	com/bytedance/sdk/openadsdk/core/video/cdsss/d:mO	Z
/*     */     //   293: goto +785 -> 1078
/*     */     //   296: astore 5
/*     */     //   298: sipush 1005
/*     */     //   301: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   304: astore 4
/*     */     //   306: goto +772 -> 1078
/*     */     //   309: iconst_1
/*     */     //   310: istore_2
/*     */     //   311: goto +767 -> 1078
/*     */     //   314: aload_0
/*     */     //   315: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   318: sipush 202
/*     */     //   321: if_icmpeq +13 -> 334
/*     */     //   324: aload_0
/*     */     //   325: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   328: sipush 208
/*     */     //   331: if_icmpne +44 -> 375
/*     */     //   334: aload_0
/*     */     //   335: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   338: checkcast 23	com/bytedance/sdk/openadsdk/core/video/cdsss/result
/*     */     //   341: invokevirtual 102	com/bytedance/sdk/openadsdk/core/video/cdsss/result:eee	()Landroid/media/MediaPlayer;
/*     */     //   344: invokevirtual 84	android/media/MediaPlayer:prepare	()V
/*     */     //   347: aload_0
/*     */     //   348: sipush 205
/*     */     //   351: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   354: goto +724 -> 1078
/*     */     //   357: astore 5
/*     */     //   359: aload 5
/*     */     //   361: invokevirtual 131	java/lang/Exception:printStackTrace	()V
/*     */     //   364: sipush 1003
/*     */     //   367: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   370: astore 4
/*     */     //   372: goto +706 -> 1078
/*     */     //   375: iconst_1
/*     */     //   376: istore_2
/*     */     //   377: goto +701 -> 1078
/*     */     //   380: aload_0
/*     */     //   381: getfield 74	com/bytedance/sdk/openadsdk/core/video/cdsss/d:mP	Ljava/util/Set;
/*     */     //   384: dup
/*     */     //   385: astore 5
/*     */     //   387: monitorenter
/*     */     //   388: aload 5
/*     */     //   390: monitorexit
/*     */     //   391: goto +11 -> 402
/*     */     //   394: astore 6
/*     */     //   396: aload 5
/*     */     //   398: monitorexit
/*     */     //   399: aload 6
/*     */     //   401: athrow
/*     */     //   402: aload_0
/*     */     //   403: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   406: invokeinterface 164 1 0
/*     */     //   411: goto +18 -> 429
/*     */     //   414: astore 5
/*     */     //   416: aload 5
/*     */     //   418: invokevirtual 131	java/lang/Exception:printStackTrace	()V
/*     */     //   421: sipush 1009
/*     */     //   424: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   427: astore 4
/*     */     //   429: aload_0
/*     */     //   430: iconst_0
/*     */     //   431: putfield 62	com/bytedance/sdk/openadsdk/core/video/cdsss/d:d	Z
/*     */     //   434: aload_0
/*     */     //   435: sipush 309
/*     */     //   438: aconst_null
/*     */     //   439: invokespecial 105	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(ILjava/lang/Object;)V
/*     */     //   442: aload_0
/*     */     //   443: sipush 203
/*     */     //   446: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   449: aload_0
/*     */     //   450: aconst_null
/*     */     //   451: putfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   454: goto +624 -> 1078
/*     */     //   457: aload_0
/*     */     //   458: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   461: invokeinterface 165 1 0
/*     */     //   466: aload_0
/*     */     //   467: sipush 201
/*     */     //   470: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   473: goto +605 -> 1078
/*     */     //   476: astore 5
/*     */     //   478: sipush 1006
/*     */     //   481: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   484: astore 4
/*     */     //   486: goto +592 -> 1078
/*     */     //   489: aload_0
/*     */     //   490: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   493: sipush 206
/*     */     //   496: if_icmpeq +23 -> 519
/*     */     //   499: aload_0
/*     */     //   500: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   503: sipush 207
/*     */     //   506: if_icmpeq +13 -> 519
/*     */     //   509: aload_0
/*     */     //   510: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   513: sipush 209
/*     */     //   516: if_icmpne +38 -> 554
/*     */     //   519: aload_0
/*     */     //   520: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   523: aload_1
/*     */     //   524: getfield 57	android/os/Message:obj	Ljava/lang/Object;
/*     */     //   527: checkcast 43	java/lang/Long
/*     */     //   530: invokevirtual 134	java/lang/Long:longValue	()J
/*     */     //   533: invokeinterface 146 3 0
/*     */     //   538: goto +540 -> 1078
/*     */     //   541: astore 5
/*     */     //   543: sipush 1007
/*     */     //   546: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   549: astore 4
/*     */     //   551: goto +527 -> 1078
/*     */     //   554: iconst_1
/*     */     //   555: istore_2
/*     */     //   556: goto +522 -> 1078
/*     */     //   559: aload_0
/*     */     //   560: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   563: sipush 201
/*     */     //   566: if_icmpeq +13 -> 579
/*     */     //   569: aload_0
/*     */     //   570: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   573: sipush 203
/*     */     //   576: if_icmpne +87 -> 663
/*     */     //   579: aload_1
/*     */     //   580: getfield 57	android/os/Message:obj	Ljava/lang/Object;
/*     */     //   583: checkcast 46	java/lang/String
/*     */     //   586: astore 5
/*     */     //   588: aload 5
/*     */     //   590: ifnull +27 -> 617
/*     */     //   593: aload 5
/*     */     //   595: ldc 1
/*     */     //   597: invokevirtual 137	java/lang/String:startsWith	(Ljava/lang/String;)Z
/*     */     //   600: ifeq +17 -> 617
/*     */     //   603: aload_0
/*     */     //   604: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   607: aload 5
/*     */     //   609: invokeinterface 156 2 0
/*     */     //   614: goto +21 -> 635
/*     */     //   617: aload 5
/*     */     //   619: invokestatic 85	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
/*     */     //   622: astore 6
/*     */     //   624: aload_0
/*     */     //   625: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   628: aload 5
/*     */     //   630: invokeinterface 156 2 0
/*     */     //   635: aload_0
/*     */     //   636: sipush 202
/*     */     //   639: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   642: goto +436 -> 1078
/*     */     //   645: astore 5
/*     */     //   647: aload 5
/*     */     //   649: invokevirtual 131	java/lang/Exception:printStackTrace	()V
/*     */     //   652: sipush 1001
/*     */     //   655: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   658: astore 4
/*     */     //   660: goto +418 -> 1078
/*     */     //   663: iconst_1
/*     */     //   664: istore_2
/*     */     //   665: goto +413 -> 1078
/*     */     //   668: aload_1
/*     */     //   669: getfield 57	android/os/Message:obj	Ljava/lang/Object;
/*     */     //   672: checkcast 10	android/graphics/SurfaceTexture
/*     */     //   675: astore 5
/*     */     //   677: aload_0
/*     */     //   678: getfield 74	com/bytedance/sdk/openadsdk/core/video/cdsss/d:mP	Ljava/util/Set;
/*     */     //   681: dup
/*     */     //   682: astore 6
/*     */     //   684: monitorenter
/*     */     //   685: aload_0
/*     */     //   686: aload 5
/*     */     //   688: invokespecial 107	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(Landroid/graphics/SurfaceTexture;)Z
/*     */     //   691: ifne +21 -> 712
/*     */     //   694: aload_0
/*     */     //   695: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   698: new 20	android/view/Surface
/*     */     //   701: dup
/*     */     //   702: aload 5
/*     */     //   704: invokespecial 99	android/view/Surface:<init>	(Landroid/graphics/SurfaceTexture;)V
/*     */     //   707: invokeinterface 148 2 0
/*     */     //   712: aload 6
/*     */     //   714: monitorexit
/*     */     //   715: goto +11 -> 726
/*     */     //   718: astore 7
/*     */     //   720: aload 6
/*     */     //   722: monitorexit
/*     */     //   723: aload 7
/*     */     //   725: athrow
/*     */     //   726: aload_0
/*     */     //   727: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   730: iconst_1
/*     */     //   731: invokeinterface 157 2 0
/*     */     //   736: aload_0
/*     */     //   737: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   740: invokestatic 100	com/bytedance/sdk/openadsdk/core/mN:ssl	()Landroid/content/Context;
/*     */     //   743: bipush 10
/*     */     //   745: invokeinterface 147 3 0
/*     */     //   750: goto +328 -> 1078
/*     */     //   753: astore 5
/*     */     //   755: sipush 1002
/*     */     //   758: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   761: astore 4
/*     */     //   763: ldc 3
/*     */     //   765: aload 5
/*     */     //   767: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   770: invokestatic 128	com/bytedance/sdk/openadsdk/g/m:eee	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   773: goto +305 -> 1078
/*     */     //   776: aload_1
/*     */     //   777: getfield 57	android/os/Message:obj	Ljava/lang/Object;
/*     */     //   780: checkcast 21	android/view/SurfaceHolder
/*     */     //   783: astore 5
/*     */     //   785: aload_0
/*     */     //   786: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   789: aload 5
/*     */     //   791: invokeinterface 149 2 0
/*     */     //   796: aload_0
/*     */     //   797: getfield 68	com/bytedance/sdk/openadsdk/core/video/cdsss/d:j	I
/*     */     //   800: iconst_2
/*     */     //   801: if_icmpne +17 -> 818
/*     */     //   804: aload_0
/*     */     //   805: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   808: invokestatic 100	com/bytedance/sdk/openadsdk/core/mN:ssl	()Landroid/content/Context;
/*     */     //   811: bipush 10
/*     */     //   813: invokeinterface 147 3 0
/*     */     //   818: aload_0
/*     */     //   819: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   822: iconst_1
/*     */     //   823: invokeinterface 157 2 0
/*     */     //   828: goto +250 -> 1078
/*     */     //   831: astore 5
/*     */     //   833: sipush 1002
/*     */     //   836: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   839: astore 4
/*     */     //   841: ldc 3
/*     */     //   843: aload 5
/*     */     //   845: invokevirtual 130	java/lang/Exception:getMessage	()Ljava/lang/String;
/*     */     //   848: invokestatic 128	com/bytedance/sdk/openadsdk/g/m:eee	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   851: goto +227 -> 1078
/*     */     //   854: aload_0
/*     */     //   855: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   858: sipush 205
/*     */     //   861: if_icmpeq +43 -> 904
/*     */     //   864: aload_0
/*     */     //   865: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   868: sipush 206
/*     */     //   871: if_icmpeq +33 -> 904
/*     */     //   874: aload_0
/*     */     //   875: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   878: sipush 208
/*     */     //   881: if_icmpeq +23 -> 904
/*     */     //   884: aload_0
/*     */     //   885: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   888: sipush 207
/*     */     //   891: if_icmpeq +13 -> 904
/*     */     //   894: aload_0
/*     */     //   895: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   898: sipush 209
/*     */     //   901: if_icmpne +35 -> 936
/*     */     //   904: aload_0
/*     */     //   905: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   908: invokeinterface 160 1 0
/*     */     //   913: aload_0
/*     */     //   914: sipush 208
/*     */     //   917: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   920: goto +158 -> 1078
/*     */     //   923: astore 5
/*     */     //   925: sipush 1008
/*     */     //   928: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   931: astore 4
/*     */     //   933: goto +145 -> 1078
/*     */     //   936: iconst_1
/*     */     //   937: istore_2
/*     */     //   938: goto +140 -> 1078
/*     */     //   941: lconst_0
/*     */     //   942: lstore 5
/*     */     //   944: aload_0
/*     */     //   945: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   948: sipush 206
/*     */     //   951: if_icmpeq +13 -> 964
/*     */     //   954: aload_0
/*     */     //   955: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   958: sipush 207
/*     */     //   961: if_icmpne +27 -> 988
/*     */     //   964: aload_0
/*     */     //   965: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   968: invokeinterface 163 1 0
/*     */     //   973: lstore 5
/*     */     //   975: goto +13 -> 988
/*     */     //   978: astore 7
/*     */     //   980: sipush 1010
/*     */     //   983: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   986: astore 4
/*     */     //   988: aload_0
/*     */     //   989: bipush 108
/*     */     //   991: lload 5
/*     */     //   993: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*     */     //   996: invokespecial 105	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(ILjava/lang/Object;)V
/*     */     //   999: goto +79 -> 1078
/*     */     //   1002: lconst_0
/*     */     //   1003: lstore 7
/*     */     //   1005: aload_0
/*     */     //   1006: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   1009: sipush 206
/*     */     //   1012: if_icmpeq +13 -> 1025
/*     */     //   1015: aload_0
/*     */     //   1016: getfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   1019: sipush 207
/*     */     //   1022: if_icmpne +32 -> 1054
/*     */     //   1025: aload_0
/*     */     //   1026: getfield 59	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	Lcom/bytedance/sdk/openadsdk/core/video/cdsss/cdsss;
/*     */     //   1029: invokeinterface 162 1 0
/*     */     //   1034: lstore 7
/*     */     //   1036: goto +18 -> 1054
/*     */     //   1039: astore 9
/*     */     //   1041: aload 9
/*     */     //   1043: invokevirtual 131	java/lang/Exception:printStackTrace	()V
/*     */     //   1046: sipush 1011
/*     */     //   1049: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   1052: astore 4
/*     */     //   1054: lload 7
/*     */     //   1056: lconst_0
/*     */     //   1057: lcmp
/*     */     //   1058: ifle +20 -> 1078
/*     */     //   1061: aload_0
/*     */     //   1062: bipush 109
/*     */     //   1064: lload 7
/*     */     //   1066: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*     */     //   1069: invokespecial 105	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(ILjava/lang/Object;)V
/*     */     //   1072: goto +6 -> 1078
/*     */     //   1075: goto +3 -> 1078
/*     */     //   1078: aload 4
/*     */     //   1080: ifnull +12 -> 1092
/*     */     //   1083: aload_0
/*     */     //   1084: sipush 310
/*     */     //   1087: aload 4
/*     */     //   1089: invokespecial 105	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(ILjava/lang/Object;)V
/*     */     //   1092: iload_2
/*     */     //   1093: ifeq +33 -> 1126
/*     */     //   1096: aload_0
/*     */     //   1097: sipush 200
/*     */     //   1100: putfield 63	com/bytedance/sdk/openadsdk/core/video/cdsss/d:eee	I
/*     */     //   1103: aload_0
/*     */     //   1104: getfield 61	com/bytedance/sdk/openadsdk/core/video/cdsss/d:cdsss	Z
/*     */     //   1107: ifne +19 -> 1126
/*     */     //   1110: aload_0
/*     */     //   1111: sipush 308
/*     */     //   1114: iload_3
/*     */     //   1115: invokestatic 133	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   1118: invokespecial 105	com/bytedance/sdk/openadsdk/core/video/cdsss/d:ssl	(ILjava/lang/Object;)V
/*     */     //   1121: aload_0
/*     */     //   1122: iconst_1
/*     */     //   1123: putfield 61	com/bytedance/sdk/openadsdk/core/video/cdsss/d:cdsss	Z
/*     */     //   1126: return
/*     */     // Line number table:
/*     */     //   Java source line #352	-> byte code offset #0
/*     */     //   Java source line #353	-> byte code offset #2
/*     */     //   Java source line #354	-> byte code offset #7
/*     */     //   Java source line #355	-> byte code offset #10
/*     */     //   Java source line #356	-> byte code offset #17
/*     */     //   Java source line #358	-> byte code offset #136
/*     */     //   Java source line #361	-> byte code offset #176
/*     */     //   Java source line #367	-> byte code offset #185
/*     */     //   Java source line #369	-> byte code offset #192
/*     */     //   Java source line #370	-> byte code offset #201
/*     */     //   Java source line #371	-> byte code offset #214
/*     */     //   Java source line #376	-> byte code offset #221
/*     */     //   Java source line #374	-> byte code offset #224
/*     */     //   Java source line #375	-> byte code offset #226
/*     */     //   Java source line #376	-> byte code offset #234
/*     */     //   Java source line #378	-> byte code offset #237
/*     */     //   Java source line #380	-> byte code offset #239
/*     */     //   Java source line #384	-> byte code offset #242
/*     */     //   Java source line #387	-> byte code offset #272
/*     */     //   Java source line #388	-> byte code offset #281
/*     */     //   Java source line #389	-> byte code offset #288
/*     */     //   Java source line #392	-> byte code offset #293
/*     */     //   Java source line #390	-> byte code offset #296
/*     */     //   Java source line #391	-> byte code offset #298
/*     */     //   Java source line #392	-> byte code offset #306
/*     */     //   Java source line #394	-> byte code offset #309
/*     */     //   Java source line #396	-> byte code offset #311
/*     */     //   Java source line #398	-> byte code offset #314
/*     */     //   Java source line #400	-> byte code offset #334
/*     */     //   Java source line #401	-> byte code offset #347
/*     */     //   Java source line #405	-> byte code offset #354
/*     */     //   Java source line #402	-> byte code offset #357
/*     */     //   Java source line #403	-> byte code offset #359
/*     */     //   Java source line #404	-> byte code offset #364
/*     */     //   Java source line #405	-> byte code offset #372
/*     */     //   Java source line #407	-> byte code offset #375
/*     */     //   Java source line #409	-> byte code offset #377
/*     */     //   Java source line #412	-> byte code offset #380
/*     */     //   Java source line #414	-> byte code offset #388
/*     */     //   Java source line #415	-> byte code offset #402
/*     */     //   Java source line #419	-> byte code offset #411
/*     */     //   Java source line #416	-> byte code offset #414
/*     */     //   Java source line #417	-> byte code offset #416
/*     */     //   Java source line #418	-> byte code offset #421
/*     */     //   Java source line #420	-> byte code offset #429
/*     */     //   Java source line #421	-> byte code offset #434
/*     */     //   Java source line #422	-> byte code offset #442
/*     */     //   Java source line #423	-> byte code offset #449
/*     */     //   Java source line #424	-> byte code offset #454
/*     */     //   Java source line #427	-> byte code offset #457
/*     */     //   Java source line #428	-> byte code offset #466
/*     */     //   Java source line #431	-> byte code offset #473
/*     */     //   Java source line #429	-> byte code offset #476
/*     */     //   Java source line #430	-> byte code offset #478
/*     */     //   Java source line #432	-> byte code offset #486
/*     */     //   Java source line #434	-> byte code offset #489
/*     */     //   Java source line #437	-> byte code offset #519
/*     */     //   Java source line #440	-> byte code offset #538
/*     */     //   Java source line #438	-> byte code offset #541
/*     */     //   Java source line #439	-> byte code offset #543
/*     */     //   Java source line #440	-> byte code offset #551
/*     */     //   Java source line #442	-> byte code offset #554
/*     */     //   Java source line #444	-> byte code offset #556
/*     */     //   Java source line #446	-> byte code offset #559
/*     */     //   Java source line #448	-> byte code offset #579
/*     */     //   Java source line #449	-> byte code offset #588
/*     */     //   Java source line #451	-> byte code offset #603
/*     */     //   Java source line #453	-> byte code offset #617
/*     */     //   Java source line #455	-> byte code offset #624
/*     */     //   Java source line #457	-> byte code offset #635
/*     */     //   Java source line #461	-> byte code offset #642
/*     */     //   Java source line #458	-> byte code offset #645
/*     */     //   Java source line #459	-> byte code offset #647
/*     */     //   Java source line #460	-> byte code offset #652
/*     */     //   Java source line #461	-> byte code offset #660
/*     */     //   Java source line #463	-> byte code offset #663
/*     */     //   Java source line #465	-> byte code offset #665
/*     */     //   Java source line #468	-> byte code offset #668
/*     */     //   Java source line #469	-> byte code offset #677
/*     */     //   Java source line #470	-> byte code offset #685
/*     */     //   Java source line #471	-> byte code offset #694
/*     */     //   Java source line #474	-> byte code offset #712
/*     */     //   Java source line #475	-> byte code offset #726
/*     */     //   Java source line #476	-> byte code offset #736
/*     */     //   Java source line #480	-> byte code offset #750
/*     */     //   Java source line #477	-> byte code offset #753
/*     */     //   Java source line #478	-> byte code offset #755
/*     */     //   Java source line #479	-> byte code offset #763
/*     */     //   Java source line #481	-> byte code offset #773
/*     */     //   Java source line #484	-> byte code offset #776
/*     */     //   Java source line #485	-> byte code offset #785
/*     */     //   Java source line #486	-> byte code offset #796
/*     */     //   Java source line #487	-> byte code offset #804
/*     */     //   Java source line #489	-> byte code offset #818
/*     */     //   Java source line #494	-> byte code offset #828
/*     */     //   Java source line #490	-> byte code offset #831
/*     */     //   Java source line #492	-> byte code offset #833
/*     */     //   Java source line #493	-> byte code offset #841
/*     */     //   Java source line #495	-> byte code offset #851
/*     */     //   Java source line #497	-> byte code offset #854
/*     */     //   Java source line #500	-> byte code offset #904
/*     */     //   Java source line #501	-> byte code offset #913
/*     */     //   Java source line #504	-> byte code offset #920
/*     */     //   Java source line #502	-> byte code offset #923
/*     */     //   Java source line #503	-> byte code offset #925
/*     */     //   Java source line #504	-> byte code offset #933
/*     */     //   Java source line #506	-> byte code offset #936
/*     */     //   Java source line #508	-> byte code offset #938
/*     */     //   Java source line #510	-> byte code offset #941
/*     */     //   Java source line #511	-> byte code offset #944
/*     */     //   Java source line #513	-> byte code offset #964
/*     */     //   Java source line #516	-> byte code offset #975
/*     */     //   Java source line #514	-> byte code offset #978
/*     */     //   Java source line #515	-> byte code offset #980
/*     */     //   Java source line #518	-> byte code offset #988
/*     */     //   Java source line #519	-> byte code offset #999
/*     */     //   Java source line #521	-> byte code offset #1002
/*     */     //   Java source line #522	-> byte code offset #1005
/*     */     //   Java source line #524	-> byte code offset #1025
/*     */     //   Java source line #528	-> byte code offset #1036
/*     */     //   Java source line #525	-> byte code offset #1039
/*     */     //   Java source line #526	-> byte code offset #1041
/*     */     //   Java source line #527	-> byte code offset #1046
/*     */     //   Java source line #530	-> byte code offset #1054
/*     */     //   Java source line #531	-> byte code offset #1061
/*     */     //   Java source line #535	-> byte code offset #1075
/*     */     //   Java source line #540	-> byte code offset #1078
/*     */     //   Java source line #542	-> byte code offset #1083
/*     */     //   Java source line #545	-> byte code offset #1092
/*     */     //   Java source line #547	-> byte code offset #1096
/*     */     //   Java source line #548	-> byte code offset #1103
/*     */     //   Java source line #549	-> byte code offset #1110
/*     */     //   Java source line #550	-> byte code offset #1121
/*     */     //   Java source line #553	-> byte code offset #1126
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	1127	0	this	d
/*     */     //   0	1127	1	paramMessage	Message
/*     */     //   1	1092	2	i1	int
/*     */     //   6	1109	3	i2	int
/*     */     //   8	1080	4	localInteger	Integer
/*     */     //   224	1	5	localException1	Exception
/*     */     //   296	1	5	localException2	Exception
/*     */     //   357	3	5	localException3	Exception
/*     */     //   385	12	5	Ljava/lang/Object;	Object
/*     */     //   414	3	5	localException4	Exception
/*     */     //   476	1	5	localException5	Exception
/*     */     //   541	1	5	localException6	Exception
/*     */     //   586	43	5	str	String
/*     */     //   645	3	5	localException7	Exception
/*     */     //   675	28	5	localSurfaceTexture	SurfaceTexture
/*     */     //   753	13	5	localException8	Exception
/*     */     //   783	7	5	localSurfaceHolder	SurfaceHolder
/*     */     //   831	13	5	localException9	Exception
/*     */     //   923	1	5	localException10	Exception
/*     */     //   942	50	5	l1	long
/*     */     //   394	6	6	localObject1	Object
/*     */     //   622	1	6	localUri	android.net.Uri
/*     */     //   718	6	7	localObject2	Object
/*     */     //   978	1	7	localException11	Exception
/*     */     //   1003	62	7	l2	long
/*     */     //   1039	3	9	localException12	Exception
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   176	221	224	java/lang/Exception
/*     */     //   272	293	296	java/lang/Exception
/*     */     //   334	354	357	java/lang/Exception
/*     */     //   388	391	394	finally
/*     */     //   394	399	394	finally
/*     */     //   380	411	414	java/lang/Exception
/*     */     //   457	473	476	java/lang/Exception
/*     */     //   519	538	541	java/lang/Exception
/*     */     //   579	642	645	java/lang/Exception
/*     */     //   685	715	718	finally
/*     */     //   718	723	718	finally
/*     */     //   668	750	753	java/lang/Exception
/*     */     //   776	828	831	java/lang/Exception
/*     */     //   904	920	923	java/lang/Exception
/*     */     //   964	975	978	java/lang/Exception
/*     */     //   1025	1036	1039	java/lang/Exception
/*     */   }
/*     */   
/*     */   private void a(int paramInt, Object paramObject)
/*     */   {
/* 565 */     if (paramInt == 309) {
/* 566 */       l();
/*     */     }
/* 568 */     if (this.h != null) {
/* 569 */       this.h.obtainMessage(paramInt, paramObject).sendToTarget();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(c paramc, int paramInt)
/*     */   {
/* 575 */     if (this.a != paramc) {
/* 576 */       return;
/*     */     }
/* 578 */     if (this.h != null) {
/* 579 */       this.h.obtainMessage(301, Integer.valueOf(paramInt)).sendToTarget();
/*     */     }
/*     */   }
/*     */   
/*     */   public void i() {
/* 584 */     Integer localInteger = (Integer)n.get(Integer.valueOf(this.j));
/* 585 */     if (localInteger == null) {
/* 586 */       n.put(Integer.valueOf(this.j), Integer.valueOf(1));
/*     */     } else {
/* 588 */       n.put(Integer.valueOf(this.j), localInteger = Integer.valueOf(localInteger.intValue() + 1));
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(c paramc)
/*     */   {
/* 594 */     this.e = (!this.b ? 209 : 206);
/* 595 */     n.remove(Integer.valueOf(this.j));
/* 596 */     if (this.h != null) {
/* 597 */       this.h.obtainMessage(302).sendToTarget();
/*     */     }
/*     */     
/* 600 */     b("completion");
/* 601 */     q();
/*     */   }
/*     */   
/*     */   public boolean a(c paramc, int paramInt1, int paramInt2)
/*     */   {
/* 606 */     this.e = 200;
/* 607 */     i();
/*     */     
/*     */ 
/*     */ 
/* 611 */     if (this.h != null) {
/* 612 */       this.h.obtainMessage(303, paramInt1, paramInt2).sendToTarget();
/*     */     }
/*     */     
/* 615 */     return true;
/*     */   }
/*     */   
/*     */   public boolean b(c paramc, int paramInt1, int paramInt2)
/*     */   {
/* 620 */     if (this.a != paramc) {
/* 621 */       return false;
/*     */     }
/* 623 */     if (this.h != null) {
/* 624 */       this.h.obtainMessage(304, paramInt1, paramInt2).sendToTarget();
/*     */     }
/* 626 */     a(paramInt1, paramInt2);
/* 627 */     return false;
/*     */   }
/*     */   
/*     */   protected void a(int paramInt1, int paramInt2) {
/* 631 */     if (paramInt1 == 701) {
/* 632 */       q();
/* 633 */     } else if (paramInt1 == 702) {
/* 634 */       if (this.u <= 0L) {
/* 635 */         this.u = System.currentTimeMillis();
/*     */       }
/* 637 */     } else if ((this.v) && (paramInt1 == 3))
/*     */     {
/* 639 */       if (this.u <= 0L) {
/* 640 */         this.u = System.currentTimeMillis();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void b(c paramc)
/*     */   {
/* 647 */     this.e = 205;
/*     */     
/* 649 */     if (this.o) {
/* 650 */       this.g.post(new Runnable()
/*     */       {
/*     */         public void run() {
/*     */           try {
/* 654 */             d.c(d.this).h();
/* 655 */             d.a(d.this, 207);
/* 656 */             d.a(d.this, false);
/*     */           }
/*     */           catch (Exception localException) {}
/*     */         }
/*     */       });
/*     */     } else {
/* 662 */       this.g.sendMessage(this.g.obtainMessage(100, -1, -1));
/*     */     }
/* 664 */     n.remove(Integer.valueOf(this.j));
/* 665 */     if (this.h != null) {
/* 666 */       this.h.sendEmptyMessage(305);
/*     */     }
/* 668 */     j();
/*     */   }
/*     */   
/*     */   protected void j() {
/* 672 */     if ((!this.v) && 
/* 673 */       (this.u <= 0L)) {
/* 674 */       this.u = System.currentTimeMillis();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void c(c paramc)
/*     */   {
/* 682 */     if (this.h != null) {
/* 683 */       this.h.sendEmptyMessage(306);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(Runnable paramRunnable) {
/* 688 */     if (this.i == null) {
/* 689 */       this.i = new ArrayList();
/*     */     }
/* 691 */     this.i.add(paramRunnable);
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
/*     */   private void o()
/*     */   {
/* 712 */     if ((this.i == null) || (this.i.isEmpty())) {
/* 713 */       return;
/*     */     }
/* 715 */     this.i.clear();
/*     */   }
/*     */   
/*     */   public void a(Runnable paramRunnable) {
/* 719 */     if (paramRunnable == null) {
/* 720 */       return;
/*     */     }
/* 722 */     if (!this.d) {
/* 723 */       paramRunnable.run();
/*     */     } else {
/* 725 */       b(paramRunnable);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(int paramInt, boolean paramBoolean) {
/* 730 */     if (paramBoolean) {
/* 731 */       int i1 = k();
/* 732 */       if (i1 != paramInt) {
/* 733 */         l = true;
/* 734 */         this.k = i1;
/*     */       }
/*     */     }
/* 737 */     AudioManager localAudioManager = (AudioManager)n.a().getSystemService("audio");
/* 738 */     localAudioManager.setStreamVolume(3, paramInt, 0);
/*     */   }
/*     */   
/*     */   public int k() {
/* 742 */     AudioManager localAudioManager = (AudioManager)n.a().getSystemService("audio");
/* 743 */     return localAudioManager.getStreamVolume(3);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void l()
/*     */   {
/* 752 */     if (l) {
/* 753 */       a(this.k, false);
/* 754 */       l = false;
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/*     */     try {
/* 760 */       if (paramBoolean) {
/* 761 */         this.a.a(0.0F, 0.0F);
/*     */       } else {
/* 763 */         this.a.a(1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */     catch (Throwable localThrowable) {}
/*     */   }
/*     */   
/* 769 */   private final Object q = new Object();
/* 770 */   private StringBuilder r = null;
/*     */   
/*     */   private void b(String paramString) {
/* 773 */     if (this.g != null) {
/* 774 */       this.g.removeMessages(201);
/*     */     }
/* 776 */     synchronized (this.q) {
/* 777 */       if (this.r != null) {
/* 778 */         this.r = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 787 */   private boolean s = false;
/* 788 */   private long t = 0L;
/* 789 */   private long u = 0L;
/*     */   
/*     */ 
/* 792 */   private boolean v = false;
/*     */   
/*     */   private void p() {
/* 795 */     if (this.u <= 0L) {
/* 796 */       this.u = System.currentTimeMillis();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void q()
/*     */   {
/* 806 */     if (this.u > 0L) {
/* 807 */       this.t += System.currentTimeMillis() - this.u;
/* 808 */       this.u = 0L;
/*     */     }
/*     */   }
/*     */   
/*     */   public long m() {
/* 813 */     q();
/* 814 */     return this.t;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\cdsss\d.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */