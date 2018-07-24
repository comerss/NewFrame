/*     */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.a;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.os.Message;
/*     */ import android.support.annotation.NonNull;
/*     */ import android.view.ViewGroup;
/*     */ import android.widget.FrameLayout;
/*     */ import android.widget.ImageView;
/*     */ import android.widget.RelativeLayout;
/*     */ import com.androidquery.AQuery;
/*     */ import com.androidquery.callback.AQuery2;
/*     */ import com.bytedance.sdk.openadsdk.R.id;
/*     */ import com.bytedance.sdk.openadsdk.core.d.h;
/*     */ import com.bytedance.sdk.openadsdk.core.d.k;
/*     */ import com.bytedance.sdk.openadsdk.core.video.c.d;
/*     */ import com.bytedance.sdk.openadsdk.g.s;
/*     */ import com.bytedance.sdk.openadsdk.g.t;
/*     */ import com.bytedance.sdk.openadsdk.g.t.a;
/*     */ 
/*     */ public class f extends FrameLayout implements t.a
/*     */ {
/*     */   private Context a;
/*     */   private final h b;
/*     */   private c c;
/*     */   private ViewGroup d;
/*     */   private FrameLayout e;
/*  27 */   private boolean f = true;
/*  28 */   private boolean g = false;
/*  29 */   private boolean h = false;
/*     */   
/*     */   private RelativeLayout i;
/*     */   
/*     */   private ImageView j;
/*     */   
/*     */   private AQuery2 k;
/*     */   
/*  37 */   private boolean l = true;
/*     */   
/*     */   private long m;
/*  40 */   private t n = new t(this);
/*     */   
/*     */   public f(@NonNull Context paramContext, @NonNull h paramh) {
/*  43 */     super(paramContext);
/*  44 */     this.a = paramContext;
/*  45 */     this.b = paramh;
/*  46 */     d();
/*     */   }
/*     */   
/*     */   private void d() {
/*  50 */     inflate(this.a, com.bytedance.sdk.openadsdk.R.layout.tt_native_video_ad_view, this);
/*  51 */     this.d = ((ViewGroup)findViewById(R.id.native_video_layout));
/*  52 */     this.e = ((FrameLayout)findViewById(R.id.native_video_frame));
/*  53 */     this.i = ((RelativeLayout)findViewById(R.id.native_video_img_cover));
/*  54 */     this.j = ((ImageView)findViewById(R.id.native_video_img_id));
/*  55 */     this.k = new AQuery2(this.a);
/*  56 */     ((AQuery)this.k.id(this.j)).image(this.b.a().c());
/*  57 */     this.c = new g(this.a, this.e, this.b);
/*     */   }
/*     */   
/*     */   public boolean a(long paramLong) {
/*  61 */     this.d.setVisibility(0);
/*  62 */     if (this.c == null) {
/*  63 */       this.c = new g(this.a, this.e, this.b);
/*     */     }
/*  65 */     this.m = paramLong;
/*     */     
/*  67 */     if (c()) {
/*  68 */       boolean bool = this.c.a(this.b.a().d(), this.b.l(), this.d
/*  69 */         .getWidth(), this.d.getHeight(), null, this.b.o(), paramLong, b());
/*  70 */       return bool;
/*     */     }
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setNativeVideoAdListener(c.a parama)
/*     */   {
/*  78 */     this.c.a(parama);
/*     */   }
/*     */   
/*     */   protected void onDetachedFromWindow()
/*     */   {
/*  83 */     super.onDetachedFromWindow();
/*  84 */     e();
/*     */   }
/*     */   
/*     */   private void e() {
/*  88 */     if (this.c != null) {
/*  89 */       this.c.c();
/*  90 */       this.c = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setVisibility(int paramInt)
/*     */   {
/*  96 */     super.setVisibility(paramInt);
/*  97 */     if ((paramInt == 4) || (paramInt == 8)) {
/*  98 */       e();
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(Message paramMessage)
/*     */   {
/* 104 */     switch (paramMessage.what) {
/*     */     case 1: 
/* 106 */       f();
/* 107 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   private void f()
/*     */   {
/* 114 */     boolean bool = s.a(getContext(), this, 50);
/* 115 */     a(bool);
/* 116 */     this.n.obtainMessage(1).sendToTarget();
/*     */   }
/*     */   
/*     */   private void a(boolean paramBoolean)
/*     */   {
/* 121 */     if ((this.b == null) || (this.c == null) || 
/* 122 */       (this.c.h() == null) || 
/* 123 */       (this.c.h().h())) {
/* 124 */       return;
/*     */     }
/* 126 */     if ((paramBoolean) && (!this.c.g())) {
/* 127 */       if (this.c.h().g()) {
/* 128 */         this.c.b();
/*     */       }
/*     */     }
/* 131 */     else if (this.c.h().f()) {
/* 132 */       this.c.a();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onWindowFocusChanged(boolean paramBoolean)
/*     */   {
/* 139 */     super.onWindowFocusChanged(paramBoolean);
/* 140 */     if ((c()) || (!a()) || (this.c == null) || (this.c.g())) {
/* 141 */       return;
/*     */     }
/*     */     
/* 144 */     if (this.n != null) {
/* 145 */       if ((paramBoolean) && (this.c != null) && (this.c.h() != null) && 
/* 146 */         (!this.c.h().h())) {
/* 147 */         this.n.obtainMessage(1).sendToTarget();
/*     */       } else {
/* 149 */         this.n.removeMessages(1);
/* 150 */         a(false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onWindowVisibilityChanged(int paramInt)
/*     */   {
/* 157 */     super.onWindowVisibilityChanged(paramInt);
/* 158 */     if ((c()) || (!a()) || (this.c == null) || (this.c.g())) {
/* 159 */       return;
/*     */     }
/* 161 */     if (this.l) {
/* 162 */       this.c.a(this.b.a().d(), this.b.l(), this.d
/* 163 */         .getWidth(), this.d.getHeight(), null, this.b.o(), this.m, b());
/* 164 */       this.l = false;
/* 165 */       s.a(this.i, 8);
/*     */     }
/* 167 */     if ((paramInt == 0) && 
/* 168 */       (this.n != null) && (this.c != null) && (this.c.h() != null) && 
/* 169 */       (!this.c.h().h())) {
/* 170 */       this.n.obtainMessage(1).sendToTarget();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setNativeVideoController(c paramc)
/*     */   {
/* 176 */     this.c = paramc;
/*     */   }
/*     */   
/*     */   public c getNativeVideoController() {
/* 180 */     return this.c;
/*     */   }
/*     */   
/*     */   public boolean a() {
/* 184 */     return this.f;
/*     */   }
/*     */   
/*     */   public void setIsAutoPlay(boolean paramBoolean) {
/* 188 */     this.f = paramBoolean;
/* 189 */     if (!paramBoolean) {
/* 190 */       s.a(this.i, 0);
/* 191 */       ((AQuery)this.k.id(this.j)).image(this.b.a().c());
/*     */     } else {
/* 193 */       s.a(this.i, 8);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean b() {
/* 198 */     return this.g;
/*     */   }
/*     */   
/*     */   public void setIsQuiet(boolean paramBoolean) {
/* 202 */     this.g = paramBoolean;
/* 203 */     if (this.c != null) {
/* 204 */       this.c.b(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 209 */     return this.h;
/*     */   }
/*     */   
/*     */   public void setIsInDetail(boolean paramBoolean) {
/* 213 */     this.h = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\a\f.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */