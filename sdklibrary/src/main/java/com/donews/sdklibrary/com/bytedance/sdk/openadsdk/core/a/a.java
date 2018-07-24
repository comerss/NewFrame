/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.a;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.view.View;
/*     */ import com.bytedance.sdk.openadsdk.c.x;
/*     */ import com.bytedance.sdk.openadsdk.core.aa;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.d.c;
/*     */ import com.bytedance.sdk.openadsdk.g.q;
/*     */ import com.bytedance.sdk.openadsdk.g.r;
/*     */ import java.lang.ref.WeakReference;
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
/*     */   extends b
/*     */ {
/*     */   private x a;
/*  26 */   private boolean s = true;
/*     */   
/*     */   public a(@NonNull Context paramContext, @NonNull h paramh, @NonNull String paramString, int paramInt) {
/*  29 */     super(paramContext, paramh, paramString, paramInt);
/*     */   }
/*     */   
/*     */   public void a(x paramx) {
/*  33 */     this.a = paramx;
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/*  37 */     this.s = paramBoolean;
/*     */   }
/*     */   
/*     */   public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  41 */     if (this.b == null) {
/*  42 */       return;
/*     */     }
/*  44 */     this.h = a(paramInt1, paramInt2, paramInt3, paramInt4, this.q, this.r, this.f == null ? null : 
/*  45 */       (View)this.f.get(), this.g == null ? null : (View)this.g.get());
/*  46 */     int i = this.c.c();
/*  47 */     switch (i) {
/*     */     case 4: 
/*  49 */       if (this.a != null) {
/*  50 */         this.a.c();
/*  51 */         if ((this.s) && (this.a.a())) {
/*  52 */           c.a(this.b, "click", this.c, this.h, this.d, true);
/*     */         }
/*     */       }
/*     */       break;
/*     */     case 5: 
/*  57 */       String str = a(this.d);
/*  58 */       if (!q.a(str)) {
/*  59 */         c.a(this.b, "click_call", this.c, this.h, str, true);
/*     */       }
/*  61 */       boolean bool1 = r.e(paramView.getContext(), this.c.g());
/*  62 */       c.a(this.b, "click", this.c, this.h, this.d, bool1);
/*  63 */       break;
/*     */     case 2: 
/*     */     case 3: 
/*  66 */       if (this.c.p() == 5)
/*     */       {
/*  68 */         c.a(this.b, "click_button", this.c, this.h, this.d, true);
/*     */       }
/*  70 */       aa.a(true);
/*  71 */       boolean bool2 = aa.a(this.b, this.c, this.e, this.k, this.j, r.a(this.e));
/*  72 */       if (this.s) {
/*  73 */         c.a(this.b, "click", this.c, this.h, this.d, bool2);
/*     */       }
/*     */       break;
/*     */     default: 
/*  77 */       i = -1;
/*     */     }
/*  79 */     if (this.i != null) {
/*  80 */       this.i.a(paramView, i);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private String a(String paramString)
/*     */   {
/*  88 */     switch (paramString) {
/*     */     case "embeded_ad": 
/*  90 */       return "feed_call";
/*     */     case "banner_ad": 
/*  92 */       return "banner_call";
/*     */     case "slide_banner_ad": 
/*  94 */       return "banner_call";
/*     */     case "interaction": 
/*  96 */       return "interaction_call";
/*     */     case "splash_ad": 
/*  98 */       return "splash_ad";
/*     */     }
/* 100 */     return "";
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\a\a.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */