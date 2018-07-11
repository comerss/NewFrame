/*     */ package com.bytedance.sdk.openadsdk.ggg;
/*     */ 
/*     */ import android.graphics.Rect;
/*     */ import android.view.MotionEvent;
/*     */ import android.view.TouchDelegate;
/*     */ import android.view.View;
/*     */ import android.view.ViewConfiguration;
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
/*     */ 
/*     */ public class g
/*     */   extends TouchDelegate
/*     */ {
/*     */   private View a;
/*     */   private Rect b;
/*     */   private Rect c;
/*     */   private boolean d;
/*     */   private int e;
/*     */   
/*     */   public g(Rect paramRect, View paramView)
/*     */   {
/*  79 */     super(paramRect, paramView);
/*  80 */     this.b = paramRect;
/*     */     
/*  82 */     this.e = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
/*  83 */     this.c = new Rect(paramRect);
/*  84 */     this.c.inset(-this.e, -this.e);
/*  85 */     this.a = paramView;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onTouchEvent(MotionEvent paramMotionEvent)
/*     */   {
/*  96 */     int i = (int)paramMotionEvent.getX();
/*  97 */     int j = (int)paramMotionEvent.getY();
/*  98 */     boolean bool1 = false;
/*  99 */     int k = 1;
/* 100 */     boolean bool2 = false;
/*     */     Object localObject;
/* 102 */     switch (paramMotionEvent.getAction()) {
/*     */     case 0: 
/* 104 */       localObject = this.b;
/*     */       
/* 106 */       if (((Rect)localObject).contains(i, j)) {
/* 107 */         this.d = true;
/* 108 */         bool1 = true;
/*     */       }
/*     */       else
/*     */       {
/* 112 */         this.d = false;
/* 113 */         bool1 = false;
/*     */       }
/* 115 */       break;
/*     */     case 1: 
/*     */     case 2: 
/* 118 */       bool1 = this.d;
/* 119 */       if (bool1) {
/* 120 */         Rect localRect = this.c;
/* 121 */         if (!localRect.contains(i, j))
/* 122 */           k = 0;
/*     */       }
/* 124 */       break;
/*     */     
/*     */     case 3: 
/* 127 */       bool1 = this.d;
/* 128 */       this.d = false;
/*     */     }
/*     */     
/* 131 */     if (bool1) {
/* 132 */       localObject = this.a;
/*     */       
/* 134 */       if (k != 0)
/*     */       {
/* 136 */         paramMotionEvent.setLocation(((View)localObject).getWidth() / 2, ((View)localObject).getHeight() / 2);
/*     */       }
/*     */       else
/*     */       {
/* 140 */         int m = this.e;
/* 141 */         paramMotionEvent.setLocation(-(m * 2), -(m * 2));
/*     */       }
/* 143 */       if (((View)localObject).getVisibility() == 0) {
/* 144 */         bool2 = ((View)localObject).dispatchTouchEvent(paramMotionEvent);
/*     */       }
/*     */     }
/* 147 */     return bool2;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\g\g.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */