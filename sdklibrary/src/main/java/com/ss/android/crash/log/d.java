/*    */ package com.ss.android.crash.log;
/*    */ 
/*    */ import android.os.Handler;
/*    */ import android.os.Looper;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */   extends Thread
/*    */ {
/* 15 */   private Handler a = new Handler(Looper.getMainLooper());
/* 16 */   private long b = 5000L;
/*    */   private long c;
/* 18 */   private volatile int d = 0;
/*    */   private final c e;
/*    */   private volatile long f;
/*    */   
/* 22 */   public d(c paramc, long paramLong) { this.e = paramc;
/* 23 */     this.b = paramLong;
/* 24 */     this.c = a();
/*    */   }
/*    */   
/* 27 */   private Runnable g = new Runnable()
/*    */   {
/*    */     public void run() {
/* 30 */     d.this.d = (d.this.d + 1) % 2147483647;
/*    */     }
/*    */   };
/*    */   
/*    */   public void run() {
/* 35 */     super.run();
/* 36 */     setName("ANR_FILE_MODIFY");
/*    */     
/* 38 */     while (!isInterrupted()) {
/* 39 */       int i = this.d;
/* 40 */       this.a.post(this.g);
/* 41 */       com.ss.android.crash.log.e.a(this.b);
/* 42 */       if (i == this.d) {
/* 43 */         if (b()) {
/* 44 */           int j = 0;
/* 45 */           int k = 0;
/*    */           do {
/* 47 */             if (i != this.d)
/*    */               break;
/* 49 */             if (c()) {
/* 50 */               k++;
/* 51 */               this.c = a();
/* 52 */               this.e.a(200, "/data/anr/traces.txt");
/* 53 */               if (k >= 3)
/*    */                 break;
/*    */             } else {
/* 56 */               com.ss.android.crash.log.e.a(500L);
/*    */             }
/* 58 */           } while (j++ <= 40);
/*    */         } else {
/* 60 */           long l = System.currentTimeMillis();
/* 61 */           if (l - this.f > 20000L) {
/* 62 */             this.e.a(100, null);
/*    */           }
/* 64 */           this.f = l;
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private long a() {
/*    */     File localFile;
/* 72 */     if ((localFile = new File("/data/anr/traces.txt")).exists()) {
/* 73 */       return localFile.lastModified();
/*    */     }
/* 75 */     return 0L;
/*    */   }
/*    */   
/*    */   private boolean b() {
/*    */     File localFile;
/* 80 */     return ((localFile = new File("/data/anr/traces.txt")).exists()) && (localFile.canRead());
/*    */   }
/*    */   
/*    */   private boolean c() {
/* 84 */     long l = a();
/* 85 */     return (l != 0L) && (this.c != 0L) && (this.c != l);
/*    */   }
/*    */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\ss\android\crash\log\LocationUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */