/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.widget;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.res.Resources;
/*     */ import android.view.LayoutInflater;
/*     */ import android.view.View;
/*     */ import android.view.View.OnClickListener;
/*     */ import android.view.ViewGroup;
/*     */ import android.widget.TextView;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.R.layout;
/*     */ import com.bytedance.sdk.openadsdk.R.string;
/*     */ import com.bytedance.sdk.openadsdk.core.d.k;
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
/*     */ public class b
/*     */ {
/*     */   private View a;
/*     */   private TextView b;
/*     */   private View c;
/*     */   private Context d;
/*     */   private d e;
/*     */   private b f;
/*  47 */   private boolean g = false;
/*     */   private k h;
/*     */   
/*     */   public void a(Context paramContext, View paramView) {
/*  51 */     if ((paramContext != null) && ((paramView instanceof ViewGroup))) {
/*  52 */       this.d = n.a().getApplicationContext();
/*  53 */       View localView = LayoutInflater.from(paramContext).inflate(R.layout.tt_video_traffic_tip, (ViewGroup)paramView, true);
/*  54 */       this.a = localView.findViewById(R.id.video_traffic_tip_layout);
/*  55 */       this.b = ((TextView)localView.findViewById(R.id.video_traffic_tip_tv));
/*  56 */       this.c = localView.findViewById(R.id.video_traffic_continue_play_btn);
/*  57 */       this.c.setOnClickListener(new OnClickListener()
/*     */       {
/*     */         public void onClick(View paramAnonymousView) {
/*  60 */           b.a(b.this, true);
/*  61 */           b.a(b.this);
/*  62 */           b.b(b.this).a(b.a.c, null);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(d paramd, b paramb) {
/*  69 */     this.f = paramb;
/*  70 */     this.e = paramd;
/*     */   }
/*     */   
/*     */   private void b() {
/*  74 */     this.h = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean a(int paramInt, k paramk)
/*     */   {
/*  85 */     if ((this.d == null) || (paramk == null)) {
/*  86 */       return true;
/*     */     }
/*     */     
/*  89 */     this.h = paramk;
/*     */     
/*  91 */     switch (paramInt) {
/*     */     case 1: 
/*     */     case 2: 
/*  94 */       return a(paramInt);
/*     */     }
/*  96 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean a(int paramInt)
/*     */   {
/* 106 */     if (a()) {
/* 107 */       return true;
/*     */     }
/* 109 */     if (!this.g) {
/* 110 */       if ((this.e != null) && (this.f != null)) {
/* 111 */         if (this.f.j()) {
/* 112 */           this.e.e(null, null);
/*     */         }
/* 114 */         this.e.a(a.a, null);
/*     */       }
/* 116 */       a(this.h, true);
/* 117 */       return false;
/*     */     }
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   private void c() {
/* 123 */     if (this.d == null) {
/* 124 */       return;
/*     */     }
/* 126 */     d();
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean)
/*     */   {
/* 131 */     if (paramBoolean) {
/* 132 */       b();
/*     */     }
/* 134 */     d();
/*     */   }
/*     */   
/*     */   public boolean a() {
/* 138 */     if ((this.a != null) && (this.a.getVisibility() == 0)) {
/* 139 */       return true;
/*     */     }
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   private void d() {
/* 145 */     this.a.setVisibility(8);
/*     */   }
/*     */   
/*     */   public void a(k paramk, boolean paramBoolean) {
/* 149 */     if ((paramk == null) || (this.a == null) || (this.d == null)) {
/* 150 */       return;
/*     */     }
/* 152 */     if (this.a.getVisibility() == 0) {
/* 153 */       return;
/*     */     }
/* 155 */     if (this.f != null) {
/* 156 */       this.f.l();
/*     */     }
/* 158 */     double d1 = paramk.a() * 1.0D / 1048576.0D;
/* 159 */     int i = (int)Math.ceil(d1);
/* 160 */     String str = null;
/* 161 */     if (paramBoolean)
/*     */     {
/*     */ 
/* 164 */       str = this.d.getResources().getString(R.string.video_without_wifi_tips) + i + this.d.getResources().getString(R.string.video_bytesize_MB) + this.d.getResources().getString(R.string.video_bytesize);
/*     */     }
/*     */     else {
/* 167 */       str = this.d.getResources().getString(R.string.video_without_wifi_tips) + this.d.getResources().getString(R.string.video_bytesize);
/*     */     }
/*     */     
/* 170 */     s.a(this.a, 0);
/* 171 */     s.a(this.b, str);
/*     */     
/* 173 */     if (s.c(this.a)) {
/* 174 */       this.a.bringToFront();
/*     */     }
/*     */   }
/*     */   
/*     */   public static enum a
/*     */   {
/*     */     private a() {}
/*     */   }
/*     */   
/*     */   public static abstract interface b
/*     */   {
/*     */     public abstract void l();
/*     */     
/*     */     public abstract boolean j();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\widget\b.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */