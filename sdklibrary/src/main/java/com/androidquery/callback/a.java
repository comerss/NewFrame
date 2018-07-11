/*     */ package com.androidquery.callback;
/*     */ 
/*     */ import android.graphics.Bitmap;
/*     */ import android.graphics.drawable.BitmapDrawable;
/*     */ import android.graphics.drawable.Drawable;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import pl.droidsonroids.gif.GifDrawable;
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
/*     */ class a
/*     */   extends LinkedHashMap<String, Drawable>
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   
/*     */   a(int paramInt1, int paramInt2, int paramInt3)
/*     */   {
/*  44 */     super(8, 0.75F, true);
/*     */     
/*  46 */     this.a = paramInt1;
/*  47 */     this.b = paramInt2;
/*  48 */     this.c = paramInt3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Drawable a(String paramString, Drawable paramDrawable)
/*     */   {
/*  55 */     Drawable localDrawable = null;
/*     */     
/*  57 */     int i = a(paramDrawable);
/*  58 */     if (i <= this.b) {
/*  59 */       this.d += i;
/*  60 */       localDrawable = (Drawable)super.put(paramString, paramDrawable);
/*  61 */       if (localDrawable != null) {
/*  62 */         this.d -= a(localDrawable);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */     return localDrawable;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Drawable a(Object paramObject)
/*     */   {
/*  79 */     Drawable localDrawable = (Drawable)super.remove(paramObject);
/*  80 */     if (localDrawable != null) {
/*  81 */       this.d -= a(localDrawable);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  86 */     return localDrawable;
/*     */   }
/*     */   
/*     */   public void clear()
/*     */   {
/*  91 */     super.clear();
/*  92 */     this.d = 0;
/*     */   }
/*     */   
/*     */   private int a(Drawable paramDrawable) {
/*  96 */     if (paramDrawable == null)
/*  97 */       return 0;
/*  98 */     if ((paramDrawable instanceof BitmapDrawable)) {
/*  99 */       Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
/* 100 */       return localBitmap.getWidth() * localBitmap.getHeight(); }
/* 101 */     if ((paramDrawable instanceof GifDrawable)) {
/* 102 */       return (int)((GifDrawable)paramDrawable).getAllocationByteCount();
/*     */     }
/*     */     
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   private void a()
/*     */   {
/* 111 */     if (this.d > this.c)
/*     */     {
/* 113 */       Iterator localIterator = keySet().iterator();
/*     */       
/* 115 */       while (localIterator.hasNext())
/*     */       {
/* 117 */         localIterator.next();
/* 118 */         localIterator.remove();
/*     */         
/* 120 */         if (this.d <= this.c) {
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEldestEntry(Map.Entry<String, Drawable> paramEntry)
/*     */   {
/* 134 */     if ((this.d > this.c) || (size() > this.a))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 143 */       a(paramEntry.getKey());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 148 */     a();
/*     */     
/* 150 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\androidquery\callback\ssl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */