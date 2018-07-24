/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.c;
/*     */ 
/*     */ import android.os.Handler;
/*     */ import android.os.Looper;
/*     */ import com.bytedance.sdk.openadsdk.core.e.c;
/*     */ import com.bytedance.sdk.openadsdk.core.n;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Queue;
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
/*     */ public class a
/*     */ {
/*     */   private static volatile a a;
/*     */   private static volatile boolean b;
/*     */   private static volatile long c;
/*     */   private Queue<a> d;
/*     */   private Handler e;
/*     */   private c f;
/*     */   
/*     */   private a()
/*     */   {
/*  34 */     this.d = new LinkedList();
/*  35 */     this.f = n.e();
/*     */   }
/*     */   
/*     */   public static a a() {
/*  39 */     if (a == null) {
/*  40 */       synchronized (a.class) {
/*  41 */         if (a == null) {
/*  42 */           a = new a();
/*     */         }
/*     */       }
/*     */     }
/*  46 */     return a;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized boolean b(String paramString)
/*     */   {
/*  55 */     long l1 = System.currentTimeMillis();
/*  56 */     int i = this.f.d();
/*  57 */     long l2 = this.f.c();
/*  58 */     if (this.d.size() >= i) {
/*  59 */       long l3 = a.a((a)this.d.peek());
/*  60 */       long l4 = Math.abs(l1 - l3);
/*     */       
/*  62 */       if (l4 <= l2) {
/*  63 */         b(l2 - l4);
/*  64 */         return true;
/*     */       }
/*  66 */       this.d.poll();
/*  67 */       this.d.offer(new a(l1, paramString, null));
/*     */     }
/*     */     else {
/*  70 */       this.d.offer(new a(l1, paramString, null));
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized boolean a(String paramString)
/*     */   {
/*  79 */     if (b(paramString)) {
/*  80 */       a(true);
/*  81 */       a(c);
/*     */     } else {
/*  83 */       a(false);
/*     */     }
/*  85 */     return b;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private synchronized void a(long paramLong)
/*     */   {
/*  92 */     if (this.e == null) {
/*  93 */       this.e = new Handler(Looper.getMainLooper());
/*     */     }
/*  95 */     this.e.postDelayed(new Runnable()
/*     */     {
/*     */ 
/*  98 */       public void run() { a.a(a.this, false); } }, paramLong);
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized void a(boolean paramBoolean)
/*     */   {
/* 104 */     b = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean b() {
/* 108 */     return b;
/*     */   }
/*     */   
/*     */   private synchronized void b(long paramLong) {
/* 112 */     c = paramLong;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public synchronized String c()
/*     */   {
/* 119 */     HashMap localHashMap = new HashMap();
/* 120 */     for (Object localObject1 = this.d.iterator(); ((Iterator)localObject1).hasNext();) { localObject2 = (a)((Iterator)localObject1).next();
/* 121 */       if (localHashMap.containsKey(a.b((a)localObject2))) {
/* 122 */         localHashMap.put(a.b((a)localObject2), Integer.valueOf(((Integer)localHashMap.get(a.b((a)localObject2))).intValue() + 1));
/*     */       } else {
/* 124 */         localHashMap.put(a.b((a)localObject2), Integer.valueOf(1));
/*     */       }
/*     */     }
/* 127 */     localObject1 = localHashMap.keySet();
/* 128 */     Object localObject2 = ((Set)localObject1).iterator();
/* 129 */     int i = Integer.MIN_VALUE;
/* 130 */     Object localObject3 = "";
/*     */     
/*     */ 
/* 133 */     while (((Iterator)localObject2).hasNext()) {
/* 134 */       String str = (String)((Iterator)localObject2).next();
/* 135 */       int j = ((Integer)localHashMap.get(str)).intValue();
/* 136 */       if (i < j) {
/* 137 */         i = j;
/* 138 */         localObject3 = str;
/*     */       }
/*     */     }
/* 141 */     return (String)localObject3;
/*     */   }
/*     */   
/*     */ 
/*     */   private static class a
/*     */   {
/*     */     private long a;
/*     */     private String b;
/*     */     
/*     */     private a(long paramLong, String paramString)
/*     */     {
/* 152 */       this.a = paramLong;
/* 153 */       this.b = paramString;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\c\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */