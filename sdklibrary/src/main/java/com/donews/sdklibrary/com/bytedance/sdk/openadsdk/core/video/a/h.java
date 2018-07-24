/*      */ package com.donews.sdklibrary.com.bytedance.sdk.openadsdk.core.video.a;
/*      */ 
/*      */ import android.app.Activity;
/*      */ import android.content.Context;
/*      */ import android.content.res.ColorStateList;
/*      */ import android.content.res.Resources;
/*      */ import android.graphics.Rect;
/*      */ import android.os.Message;
/*      */ import android.text.TextUtils;
/*      */ import android.util.DisplayMetrics;
/*      */ import android.util.TypedValue;
/*      */ import android.view.Display;
/*      */ import android.view.MotionEvent;
/*      */ import android.view.SurfaceHolder;
/*      */ import android.view.View;
/*      */ import android.view.View.OnClickListener;
/*      */ import android.view.View.OnTouchListener;
/*      */ import android.view.ViewGroup;
/*      */ import android.view.ViewGroup.LayoutParams;
/*      */ import android.view.ViewGroup.MarginLayoutParams;
/*      */ import android.view.ViewParent;
/*      */ import android.view.WindowManager;
/*      */ import android.widget.ImageView;
/*      */ import android.widget.ProgressBar;
/*      */ import android.widget.RelativeLayout;
/*      */ import android.widget.RelativeLayout.LayoutParams;
/*      */ import android.widget.SeekBar;
/*      */ import android.widget.SeekBar.OnSeekBarChangeListener;
/*      */ import android.widget.TextView;
/*      */ import com.androidquery.AQuery;
/*      */ import com.androidquery.callback.AQuery2;
/*      */ import com.bytedance.sdk.openadsdk.R.color;
/*      */ import com.bytedance.sdk.openadsdk.R.dimen;
/*      */ import com.bytedance.sdk.openadsdk.R.drawable;
/*      */ import com.bytedance.sdk.openadsdk.R.id;
/*      */ import com.bytedance.sdk.openadsdk.R.string;
/*      */ import com.bytedance.sdk.openadsdk.c.x;
/*      */ import com.bytedance.sdk.openadsdk.c.x.b;
/*      */ import com.bytedance.sdk.openadsdk.core.d.g;
/*      */ import com.bytedance.sdk.openadsdk.core.d.k;
/*      */ import com.bytedance.sdk.openadsdk.core.n;
/*      */ import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
/*      */ import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
/*      */ import com.bytedance.sdk.openadsdk.core.widget.a.a;
/*      */ import com.bytedance.sdk.openadsdk.core.widget.b.b;
/*      */ import com.bytedance.sdk.openadsdk.g.m;
/*      */ import com.bytedance.sdk.openadsdk.g.q;
/*      */ import com.bytedance.sdk.openadsdk.g.s;
/*      */ import com.bytedance.sdk.openadsdk.g.t;
/*      */ import com.bytedance.sdk.openadsdk.g.t.a;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.Date;
/*      */ import java.util.EnumSet;
/*      */ import java.util.Locale;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class h
/*      */   implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, a.a, b.b, t.a
/*      */ {
/*      */   private View a;
/*      */   private com.bytedance.sdk.openadsdk.core.video.renderview.b b;
/*      */   private TextView c;
/*      */   private ImageView d;
/*      */   private ImageView e;
/*      */   private View f;
/*      */   private TextView g;
/*      */   private TextView h;
/*      */   private TextView i;
/*      */   private ImageView j;
/*      */   private View k;
/*      */   private View l;
/*      */   private View m;
/*      */   private ImageView n;
/*      */   private TextView o;
/*      */   private View p;
/*      */   private ImageView q;
/*      */   private View r;
/*      */   private RoundImageView s;
/*      */   private TextView t;
/*      */   private TextView u;
/*      */   private TextView v;
/*      */   private RelativeLayout w;
/*      */   private ImageView x;
/*      */   private View y;
/*      */   private ImageView z;
/*   98 */   private t A = new t(this);
/*      */   private Context B;
/*      */   private int C;
/*      */   private int D;
/*      */   private int E;
/*      */   private int F;
/*  104 */   private boolean G = false;
/*  105 */   private boolean H = true;
/*  106 */   private boolean I = false;
/*      */   
/*  108 */   private int J = 0;
/*  109 */   private int K = 0;
/*  110 */   private int L = 0;
/*  111 */   private int M = 0;
/*      */   
/*  113 */   private int N = 0;
/*  114 */   private Rect O = new Rect();
/*      */   
/*      */   private SeekBar P;
/*      */   
/*      */   private ProgressBar Q;
/*      */   
/*      */   private TextView R;
/*      */   
/*      */   private TextView S;
/*      */   private ColorStateList T;
/*      */   private float U;
/*  125 */   private Rect V = new Rect();
/*      */   
/*  127 */   private int W = 0;
/*      */   
/*      */   private boolean X;
/*      */   
/*  131 */   private int Y = 0;
/*  132 */   private int Z = 0;
/*      */   
/*      */   private d aa;
/*      */   
/*      */   private boolean ab;
/*      */   
/*      */   private int ac;
/*      */   
/*      */   private EnumSet<b.a> ad;
/*      */   
/*      */   private WindowManager ae;
/*  143 */   private com.bytedance.sdk.openadsdk.core.widget.a af = null;
/*      */   
/*      */   private com.bytedance.sdk.openadsdk.core.widget.b ag;
/*      */   
/*      */   private AQuery2 ah;
/*      */   private final com.bytedance.sdk.openadsdk.core.d.h ai;
/*  149 */   private boolean aj = true;
/*      */   private x ak;
/*      */   private c al;
/*      */   private com.bytedance.sdk.openadsdk.core.a.a am;
/*      */   
/*      */   public h(Context paramContext, View paramView, boolean paramBoolean, EnumSet<b.a> paramEnumSet, com.bytedance.sdk.openadsdk.core.d.h paramh, c paramc)
/*      */   {
/*  156 */     this.ae = ((paramContext instanceof Activity) ? ((Activity)paramContext).getWindowManager() : null);
/*  157 */     this.B = n.a().getApplicationContext();
/*  158 */     this.a = paramView;
/*  159 */     this.H = paramBoolean;
/*  160 */     this.af = new com.bytedance.sdk.openadsdk.core.widget.a(this);
/*  161 */     this.af.b(this.H);
/*  162 */     DisplayMetrics localDisplayMetrics = this.B.getResources().getDisplayMetrics();
/*  163 */     this.Y = localDisplayMetrics.widthPixels;
/*  164 */     this.Z = localDisplayMetrics.heightPixels;
/*  165 */     this.ad = (paramEnumSet == null ? EnumSet.noneOf(b.a.class) : paramEnumSet);
/*  166 */     this.ah = new AQuery2(this.B);
/*  167 */     this.al = paramc;
/*  168 */     this.ai = paramh;
/*  169 */     d(8);
/*  170 */     a(paramContext, this.a);
/*  171 */     b();
/*  172 */     q();
/*      */   }
/*      */   
/*      */   private void q() {
/*  176 */     if (this.ai.c() == 4) {
/*  177 */       this.ak = new x(this.B, this.ai, "embeded_ad");
/*  178 */       this.ak.a(new x.b()
/*      */       {
/*      */         public void a() {
/*  181 */           String str = h.a(h.this) ? "click_start" : "click_start_detail";
/*  182 */           com.bytedance.sdk.openadsdk.d.c.a(h.b(h.this), h.c(h.this), "embeded_ad", str);
/*      */         }
/*      */         
/*      */         public void b()
/*      */         {
/*  187 */           com.bytedance.sdk.openadsdk.d.c.b(h.b(h.this), h.c(h.this), "embeded_ad", "click_pause");
/*      */         }
/*      */         
/*      */         public void c()
/*      */         {
/*  192 */           com.bytedance.sdk.openadsdk.d.c.c(h.b(h.this), h.c(h.this), "embeded_ad", "click_continue");
/*      */         }
/*      */         
/*      */         public void d()
/*      */         {
/*  197 */           String str = h.a(h.this) ? "click_open" : "click_open_detail";
/*  198 */           com.bytedance.sdk.openadsdk.d.c.h(h.b(h.this), h.c(h.this), "embeded_ad", str);
/*      */         }
/*      */       });
/*      */     }
/*      */     
/*  203 */     this.am = new com.bytedance.sdk.openadsdk.core.a.a(this.B, this.ai, "embeded_ad", 1);
/*      */     
/*  205 */     if (this.aj) {
/*  206 */       this.am.a(true);
/*      */     } else {
/*  208 */       this.am.a(false);
/*      */     }
/*  210 */     this.am.a(this.al);
/*  211 */     this.am.b(true);
/*  212 */     if ((this.ak != null) && (this.am != null)) {
/*  213 */       this.am.a(this.ak);
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(Context paramContext, View paramView) {
/*  218 */     SSRenderSurfaceView localSSRenderSurfaceView = new SSRenderSurfaceView(this.B);
/*  219 */     if ((paramView instanceof RelativeLayout)) {
/*  220 */       localObject = new RelativeLayout.LayoutParams(-2, -2);
/*  221 */       ((RelativeLayout.LayoutParams)localObject).addRule(13);
/*  222 */       ((RelativeLayout)paramView).addView(localSSRenderSurfaceView, 0, (ViewGroup.LayoutParams)localObject);
/*      */     }
/*  224 */     localSSRenderSurfaceView.setVisibility(8);
/*  225 */     this.b = ((com.bytedance.sdk.openadsdk.core.video.renderview.b)localSSRenderSurfaceView);
/*      */     
/*  227 */     Object localObject = paramView;
/*  228 */     this.c = ((TextView)((View)localObject).findViewById(R.id.video_back));
/*  229 */     this.d = ((ImageView)((View)localObject).findViewById(R.id.video_close));
/*  230 */     this.f = ((View)localObject).findViewById(R.id.video_top_layout);
/*  231 */     this.j = ((ImageView)((View)localObject).findViewById(R.id.video_fullscreen_back));
/*  232 */     this.g = ((TextView)((View)localObject).findViewById(R.id.video_title));
/*  233 */     this.h = ((TextView)((View)localObject).findViewById(R.id.video_top_title));
/*      */     
/*  235 */     this.i = ((TextView)((View)localObject).findViewById(R.id.video_current_time));
/*      */     
/*  237 */     this.e = ((ImageView)((View)localObject).findViewById(R.id.video_play));
/*  238 */     this.Q = ((ProgressBar)((View)localObject).findViewById(R.id.video_progress));
/*  239 */     this.k = ((View)localObject).findViewById(R.id.video_loading_retry_layout);
/*  240 */     this.l = ((View)localObject).findViewById(R.id.video_loading_progress);
/*  241 */     this.m = ((View)localObject).findViewById(R.id.video_loading_retry);
/*  242 */     this.n = ((ImageView)((View)localObject).findViewById(R.id.video_retry));
/*  243 */     this.o = ((TextView)((View)localObject).findViewById(R.id.video_retry_des));
/*  244 */     this.w = ((RelativeLayout)((View)localObject).findViewById(R.id.video_loading_cover));
/*  245 */     this.x = ((ImageView)((View)localObject).findViewById(R.id.video_loading_cover_image));
/*  246 */     this.P = ((SeekBar)((View)localObject).findViewById(R.id.video_seekbar));
/*  247 */     this.R = ((TextView)((View)localObject).findViewById(R.id.video_time_left_time));
/*  248 */     this.S = ((TextView)((View)localObject).findViewById(R.id.video_time_play));
/*      */     
/*  250 */     this.p = paramView.findViewById(R.id.video_ad_cover);
/*  251 */     this.q = ((ImageView)paramView.findViewById(R.id.video_ad_finish_cover_image));
/*  252 */     this.r = paramView.findViewById(R.id.video_ad_cover_center_layout);
/*  253 */     this.s = ((RoundImageView)paramView.findViewById(R.id.video_ad_logo_image));
/*  254 */     this.t = ((TextView)paramView.findViewById(R.id.video_btn_ad_image_tv));
/*  255 */     this.u = ((TextView)paramView.findViewById(R.id.video_ad_name));
/*  256 */     this.v = ((TextView)paramView.findViewById(R.id.video_ad_button));
/*      */     
/*  258 */     this.y = ((View)localObject).findViewById(R.id.video_ad_bottom_layout);
/*  259 */     this.z = ((ImageView)((View)localObject).findViewById(R.id.video_ad_full_screen));
/*      */   }
/*      */   
/*      */ 
/*      */   private void r()
/*      */   {
/*  265 */     if ((this.aa != null) && 
/*  266 */       (this.ag == null)) {
/*  267 */       this.ag = new com.bytedance.sdk.openadsdk.core.widget.b();
/*  268 */       this.ag.a(this.B, this.a);
/*  269 */       this.ag.a(this.aa, this);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean a(int paramInt, k paramk)
/*      */   {
/*  276 */     if (this.ag != null) {
/*  277 */       return this.ag.a(paramInt, paramk);
/*      */     }
/*  279 */     return true;
/*      */   }
/*      */   
/*      */   public void a() {
/*  283 */     if (this.ag != null) {
/*  284 */       this.ag.a(false);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void a(a parama)
/*      */   {
/*  306 */     if ((parama instanceof d)) {
/*  307 */       this.aa = ((d)parama);
/*  308 */       this.af.a(this.aa);
/*  309 */       r();
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean s() {
/*  314 */     if (this.aa == null) {
/*  315 */       m.e("NewLiveViewLayout", "callback is null");
/*  316 */       return false;
/*      */     }
/*  318 */     return true;
/*      */   }
/*      */   
/*      */   public void b() {
/*  322 */     this.b.a(this);
/*  323 */     this.af.a(this.a);
/*      */     
/*  325 */     this.d.setVisibility((this.H) || (this.ad.contains(b.a.a)) ? 8 : 0);
/*  326 */     this.d.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  330 */         if (h.d(h.this)) {
/*  331 */           h.e(h.this).c(h.this, paramAnonymousView);
/*      */         }
/*      */         
/*      */       }
/*  335 */     });
/*  336 */     this.c.setVisibility((this.H) && (!this.ad.contains(b.a.b)) ? 8 : 0);
/*  337 */     this.c.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  341 */         if (h.d(h.this)) {
/*  342 */           h.e(h.this).d(h.this, paramAnonymousView);
/*      */         }
/*      */       }
/*  345 */     });
/*  346 */     this.j.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  350 */         if (h.d(h.this)) {
/*  351 */           h.e(h.this).e(h.this, paramAnonymousView);
/*      */         }
/*      */       }
/*  354 */     });
/*  355 */     this.e.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  359 */         if (h.d(h.this)) {
/*  360 */           h.e(h.this).a(h.this, paramAnonymousView);
/*      */         }
/*      */         
/*      */       }
/*  364 */     });
/*  365 */     this.n.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  369 */         h.this.a(false, true);
/*  370 */         h.this.h();
/*  371 */         h.this.e();
/*  372 */         if (h.d(h.this)) {
/*  373 */           h.e(h.this).f(h.this, paramAnonymousView);
/*      */         }
/*      */         
/*      */       }
/*  377 */     });
/*  378 */     this.z.setOnClickListener(new OnClickListener()
/*      */     {
/*      */       public void onClick(View paramAnonymousView)
/*      */       {
/*  382 */         if (h.d(h.this)) {
/*  383 */           h.e(h.this).b(h.this, paramAnonymousView);
/*      */         }
/*      */         
/*      */       }
/*  387 */     });
/*  388 */     this.P.setThumbOffset(0);
/*  389 */     this.P.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
/*      */     {
/*      */       public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
/*      */       {
/*  393 */         if ((!h.f(h.this)) && (h.b(h.this) != null)) {
/*  394 */           paramAnonymousSeekBar.setThumb(n.a().getApplicationContext().getResources().getDrawable(R.drawable.tt_seek_thumb_normal));
/*      */         }
/*  396 */         if (h.d(h.this)) {
/*  397 */           paramAnonymousSeekBar.setThumbOffset(0);
/*  398 */           h.e(h.this).a(h.this, paramAnonymousSeekBar.getProgress());
/*      */         }
/*      */       }
/*      */       
/*      */       public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
/*      */       {
/*  404 */         if ((!h.f(h.this)) && (h.b(h.this) != null)) {
/*  405 */           paramAnonymousSeekBar.setThumb(n.a().getApplicationContext().getResources().getDrawable(R.drawable.tt_seek_thumb_press));
/*      */         }
/*  407 */         if (h.d(h.this)) {
/*  408 */           paramAnonymousSeekBar.setThumbOffset(0);
/*  409 */           h.e(h.this).b(h.this, paramAnonymousSeekBar.getProgress());
/*      */         }
/*      */       }
/*      */       
/*      */       public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
/*      */       {
/*  415 */         if (h.d(h.this)) {
/*  416 */           h.e(h.this).a(h.this, paramAnonymousInt, paramAnonymousBoolean);
/*      */         }
/*      */       }
/*  419 */     });
/*  420 */     this.P.setOnTouchListener(this.ao);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*  425 */   private boolean an = false;
/*      */   
/*  427 */   private OnTouchListener ao = new OnTouchListener()
/*      */   {
/*      */     private float b;
/*      */     
/*      */     public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
/*  432 */       float f = paramAnonymousMotionEvent.getX();
/*  433 */       switch (paramAnonymousMotionEvent.getActionMasked()) {
/*      */       case 0: 
/*  435 */         this.b = f;
/*  436 */         break;
/*      */       case 2: 
/*  438 */         paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
/*  439 */         break;
/*      */       case 1: 
/*  441 */         if (Math.abs(this.b - paramAnonymousMotionEvent.getX()) < 10.0F) {
/*  442 */           h.a(h.this, true);
/*      */         } else {
/*  444 */           h.a(h.this, false);
/*      */         }
/*  446 */         break;
/*      */       case 3: 
/*  448 */         paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
/*      */       }
/*      */       
/*  451 */       return false;
/*      */     } };
/*      */   private float ap;
/*      */   private ColorStateList aq;
/*      */   private float ar;
/*      */   
/*  457 */   public void a(int paramInt) { this.a.setVisibility(0);
/*  458 */     if (this.b != null)
/*  459 */       this.b.setVisibility(paramInt);
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean) {
/*  463 */     this.aj = paramBoolean;
/*  464 */     if (this.am == null) {
/*  465 */       return;
/*      */     }
/*  467 */     if (this.aj) {
/*  468 */       this.am.a(true);
/*      */     } else {
/*  470 */       this.am.a(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void c()
/*      */   {
/*  476 */     this.A.removeMessages(1);
/*  477 */     Message localMessage = this.A.obtainMessage(1);
/*  478 */     this.A.sendMessageDelayed(localMessage, 2000L);
/*      */   }
/*      */   
/*      */   public void d()
/*      */   {
/*  483 */     this.A.removeMessages(1);
/*      */   }
/*      */   
/*      */   public void b(boolean paramBoolean)
/*      */   {
/*  488 */     int i1 = j() ? this.Z : this.C;
/*  489 */     int i2 = j() ? this.Y : this.D;
/*  490 */     if ((this.F <= 0) || (this.E <= 0)) {
/*  491 */       return;
/*      */     }
/*      */     
/*  494 */     if (i1 <= 0) {
/*  495 */       return;
/*      */     }
/*  497 */     int i3 = 0;
/*  498 */     int i4 = 0;
/*  499 */     int i5 = 0;
/*  500 */     if ((k()) || (j()) || (this.ad.contains(b.a.d))) {
/*  501 */       i3 = i2;
/*      */     } else {
/*  503 */       i3 = this.B.getResources().getDimensionPixelSize(R.dimen.video_container_maxheight);
/*      */     }
/*  505 */     i4 = i1;
/*  506 */     float f1 = i1 * 1.0F / this.E;
/*  507 */     int i6 = (int)(this.F * f1);
/*  508 */     if (i6 > i3) {
/*  509 */       i5 = i3;
/*  510 */       f1 = i3 * 1.0F / this.F;
/*  511 */       i4 = (int)(this.E * f1);
/*      */     } else {
/*  513 */       i5 = i6;
/*      */     }
/*      */     
/*      */     int i7;
/*      */     int i8;
/*  518 */     if ((!paramBoolean) && (!j())) {
/*  519 */       i7 = this.C;
/*  520 */       i8 = this.D;
/*      */     } else {
/*  522 */       i7 = i4;
/*  523 */       i8 = i5;
/*      */     }
/*  525 */     this.b.a(i7, i8);
/*      */   }
/*      */   
/*      */ 
/*      */   public void a(int paramInt1, int paramInt2)
/*      */   {
/*  531 */     if (paramInt1 == -1) {
/*  532 */       DisplayMetrics localDisplayMetrics = this.B.getResources().getDisplayMetrics();
/*  533 */       paramInt1 = localDisplayMetrics.widthPixels;
/*      */     }
/*      */     
/*  536 */     if (paramInt1 <= 0) {
/*  537 */       return;
/*      */     }
/*  539 */     this.C = paramInt1;
/*  540 */     if ((k()) || (j()) || (this.ad.contains(b.a.d))) {
/*  541 */       this.D = paramInt2;
/*      */     } else {
/*  543 */       this.D = e(paramInt1);
/*      */     }
/*  545 */     b(this.C, this.D);
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean1, boolean paramBoolean2)
/*      */   {
/*  550 */     this.X = paramBoolean1;
/*  551 */     if (this.e != null) {
/*  552 */       if (paramBoolean1) {
/*  553 */         this.e.setImageResource(R.drawable.tt_play_movebar_textpage);
/*      */       } else {
/*  555 */         this.e.setImageResource(R.drawable.tt_stop_movebar_textpage);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(String paramString)
/*      */   {
/*  562 */     if (this.g != null) {
/*  563 */       this.g.setText(paramString);
/*      */     }
/*  565 */     if (this.h != null) {
/*  566 */       this.h.setText(paramString);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void b(int paramInt1, int paramInt2)
/*      */   {
/*  578 */     ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
/*  579 */     if ((paramInt1 == -1) || (paramInt1 == -2) || (paramInt1 > 0)) {
/*  580 */       localLayoutParams.width = paramInt1;
/*      */     }
/*  582 */     if ((paramInt2 == -1) || (paramInt2 == -2) || (paramInt2 > 0)) {
/*  583 */       localLayoutParams.height = paramInt2;
/*      */     }
/*  585 */     this.a.setLayoutParams(localLayoutParams);
/*      */   }
/*      */   
/*      */   private int e(int paramInt) {
/*  589 */     if ((this.E <= 0) || (this.F <= 0)) {
/*  590 */       return 0;
/*      */     }
/*  592 */     int i1 = this.B.getResources().getDimensionPixelSize(R.dimen.video_container_maxheight);
/*  593 */     int i2 = this.B.getResources().getDimensionPixelSize(R.dimen.video_container_minheight);
/*  594 */     int i3 = 0;
/*  595 */     float f1 = paramInt * 1.0F / this.E;
/*  596 */     int i4 = (int)(this.F * f1);
/*  597 */     if (i4 > i1) {
/*  598 */       i3 = i1;
/*  599 */     } else if (i4 < i2) {
/*  600 */       i3 = i2;
/*      */     } else {
/*  602 */       i3 = i4;
/*      */     }
/*  604 */     return i3;
/*      */   }
/*      */   
/*      */   public void c(int paramInt1, int paramInt2)
/*      */   {
/*  609 */     this.E = paramInt1;
/*  610 */     this.F = paramInt2;
/*      */   }
/*      */   
/*      */   public void b(int paramInt)
/*      */   {
/*  615 */     if ((this.y != null) && (this.y.getVisibility() == 0)) {
/*  616 */       s.a(this.Q, 8);
/*      */     } else {
/*  618 */       s.a(this.Q, 0);
/*  619 */       this.P.setProgress(paramInt);
/*  620 */       this.Q.setProgress(paramInt);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void a(long paramLong1, long paramLong2)
/*      */   {
/*  637 */     this.R.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong2));
/*  638 */     this.S.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1));
/*  639 */     int i1 = com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1, paramLong2);
/*  640 */     this.P.setProgress(i1);
/*      */   }
/*      */   
/*      */   public void a(ViewGroup paramViewGroup)
/*      */   {
/*  645 */     if (this.a.getParent() != null) {
/*  646 */       ViewGroup localViewGroup = (ViewGroup)this.a.getParent();
/*  647 */       localViewGroup.removeView(this.a);
/*      */     }
/*  649 */     this.ay = true;
/*      */     
/*  651 */     paramViewGroup.addView(this.a);
/*  652 */     d(0);
/*      */   }
/*      */   
/*      */   public void e()
/*      */   {
/*  657 */     this.k.setVisibility(0);
/*  658 */     this.l.setVisibility(0);
/*  659 */     this.m.setVisibility(8);
/*      */     
/*  661 */     if ((this.w != null) && (this.x != null) && (this.ai != null))
/*      */     {
/*  663 */       s.a(this.w, 0);
/*  664 */       ((AQuery)this.ah.id(this.x)).image(this.ai.a().c());
/*      */     }
/*      */     
/*  667 */     if (this.e.getVisibility() == 0) {
/*  668 */       this.e.setVisibility(8);
/*      */     }
/*      */   }
/*      */   
/*      */   public void f()
/*      */   {
/*  674 */     b(false, this.H);
/*  675 */     t();
/*      */   }
/*      */   
/*      */   public void a(long paramLong)
/*      */   {
/*  680 */     this.S.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void t()
/*      */   {
/*  708 */     s.a(this.p, 8);
/*  709 */     s.a(this.q, 8);
/*  710 */     s.a(this.r, 8);
/*  711 */     s.a(this.s, 8);
/*  712 */     s.a(this.t, 8);
/*  713 */     s.a(this.u, 8);
/*  714 */     s.a(this.v, 8);
/*      */   }
/*      */   
/*      */   public void a(com.bytedance.sdk.openadsdk.core.d.h paramh, WeakReference<Context> paramWeakReference, boolean paramBoolean)
/*      */   {
/*  719 */     if (paramh == null) {
/*  720 */       return;
/*      */     }
/*  722 */     b(false, this.H);
/*  723 */     s.a(this.p, 0);
/*  724 */     s.a(this.q, 0);
/*  725 */     s.a(this.r, 0);
/*  726 */     String str = "";
/*  727 */     if (!q.a(paramh.b())) {
/*  728 */       str = paramh.b();
/*  729 */     } else if (!q.a(paramh.j())) {
/*  730 */       str = paramh.j();
/*  731 */     } else if (!q.a(paramh.k())) {
/*  732 */       str = paramh.k();
/*      */     }
/*      */     
/*  735 */     if ((this.ai != null) && (this.ai.d() != null) && (this.ai.d().a() != null)) {
/*  736 */       s.a(this.s, 0);
/*  737 */       s.a(this.t, 4);
/*  738 */       ((AQuery)this.ah.id(this.s)).image(this.ai.d().a());
/*  739 */       this.s.setOnClickListener(this.am);
/*  740 */       this.s.setOnTouchListener(this.am);
/*  741 */     } else if (!q.a(str)) {
/*  742 */       s.a(this.s, 4);
/*  743 */       s.a(this.t, 0);
/*  744 */       this.t.setText(str.substring(0, 1));
/*      */       
/*      */ 
/*  747 */       this.t.setOnClickListener(this.am);
/*  748 */       this.t.setOnTouchListener(this.am);
/*      */     }
/*      */     
/*  751 */     if (!q.a(str)) {
/*  752 */       this.u.setText(str);
/*      */     }
/*  754 */     s.a(this.u, 0);
/*      */     
/*  756 */     s.a(this.v, 0);
/*  757 */     switch (paramh.c()) {
/*      */     case 4: 
/*  759 */       this.v.setText(this.B.getResources().getString(R.string.video_download_apk));
/*  760 */       break;
/*      */     case 5: 
/*  762 */       this.v.setText(this.B.getResources().getString(R.string.video_dial_phone));
/*  763 */       break;
/*      */     case 2: 
/*      */     case 3: 
/*  766 */       this.v.setText(this.B.getResources().getString(R.string.video_mobile_go_detail));
/*  767 */       break;
/*      */     default: 
/*  769 */       this.v.setText(this.B.getResources().getString(R.string.video_mobile_go_detail));
/*      */     }
/*      */     
/*      */     
/*  773 */     this.v.setOnClickListener(this.am);
/*  774 */     this.v.setOnTouchListener(this.am);
/*      */   }
/*      */   
/*      */   public void g()
/*      */   {
/*  779 */     this.k.setVisibility(8);
/*  780 */     this.l.setVisibility(8);
/*  781 */     if (this.w != null)
/*      */     {
/*  783 */       s.a(this.w, 8);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void h()
/*      */   {
/*  796 */     this.k.setVisibility(8);
/*  797 */     this.m.setVisibility(8);
/*      */   }
/*      */   
/*      */   public void a(SurfaceHolder paramSurfaceHolder)
/*      */   {
/*  802 */     this.A.removeMessages(2);
/*  803 */     if (paramSurfaceHolder != this.b.getHolder()) {
/*  804 */       return;
/*      */     }
/*  806 */     this.ab = true;
/*  807 */     if (s()) {
/*  808 */       this.aa.a(this, paramSurfaceHolder);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
/*      */   {
/*  814 */     if (this.A.hasMessages(2)) {
/*  815 */       this.A.removeMessages(2);
/*  816 */       if (this.aA != -1) {
/*  817 */         this.A.sendMessageDelayed(Message.obtain(this.A, 2, this.aA, 0), 500L);
/*  818 */         this.aA = -1;
/*      */       }
/*      */     }
/*  821 */     if (paramSurfaceHolder != this.b.getHolder()) {
/*  822 */       return;
/*      */     }
/*  824 */     if (s()) {
/*  825 */       this.aa.a(this, paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
/*      */     }
/*      */   }
/*      */   
/*      */   public void b(SurfaceHolder paramSurfaceHolder)
/*      */   {
/*  831 */     this.A.removeMessages(2);
/*  832 */     if (paramSurfaceHolder != this.b.getHolder()) {
/*  833 */       return;
/*      */     }
/*  835 */     this.ab = false;
/*  836 */     if (s()) {
/*  837 */       this.aa.b(this, paramSurfaceHolder);
/*      */     }
/*      */   }
/*      */   
/*      */   public void i()
/*      */   {
/*  843 */     this.P.setProgress(0);
/*  844 */     this.P.setSecondaryProgress(0);
/*  845 */     this.Q.setProgress(0);
/*  846 */     this.Q.setSecondaryProgress(0);
/*      */     
/*  848 */     this.R.setText("00:00");
/*  849 */     this.S.setText("00:00");
/*      */     
/*  851 */     d(8);
/*  852 */     if (x()) {
/*  853 */       this.b.setVisibility(8);
/*      */     }
/*  855 */     if (this.x != null) {
/*  856 */       this.x.setImageDrawable(null);
/*      */     }
/*  858 */     d(8);
/*  859 */     this.y.setVisibility(8);
/*      */     
/*  861 */     this.p.setVisibility(8);
/*  862 */     this.q.setVisibility(8);
/*  863 */     this.r.setVisibility(8);
/*  864 */     this.s.setVisibility(8);
/*  865 */     this.t.setVisibility(8);
/*  866 */     this.u.setVisibility(8);
/*  867 */     if (this.ag != null) {
/*  868 */       this.ag.a(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean j()
/*      */   {
/*  874 */     return this.G;
/*      */   }
/*      */   
/*      */   public boolean k()
/*      */   {
/*  879 */     return this.H;
/*      */   }
/*      */   
/*      */   public void b(ViewGroup paramViewGroup)
/*      */   {
/*  884 */     if (paramViewGroup == null) {
/*  885 */       return;
/*      */     }
/*  887 */     if (!(this.a.getLayoutParams() instanceof MarginLayoutParams)) {
/*  888 */       return;
/*      */     }
/*  890 */     this.G = true;
/*  891 */     this.af.a(true);
/*  892 */     MarginLayoutParams localMarginLayoutParams = (MarginLayoutParams)this.a.getLayoutParams();
/*  893 */     this.K = localMarginLayoutParams.leftMargin;
/*  894 */     this.J = localMarginLayoutParams.topMargin;
/*  895 */     this.L = localMarginLayoutParams.width;
/*  896 */     this.M = localMarginLayoutParams.height;
/*  897 */     localMarginLayoutParams.width = -1;
/*  898 */     localMarginLayoutParams.height = -1;
/*  899 */     localMarginLayoutParams.topMargin = 0;
/*  900 */     localMarginLayoutParams.leftMargin = 0;
/*  901 */     this.a.setLayoutParams(localMarginLayoutParams);
/*      */     
/*  903 */     ViewGroup.LayoutParams localLayoutParams = paramViewGroup.getLayoutParams();
/*  904 */     Object localObject; if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
/*  905 */       localObject = (RelativeLayout.LayoutParams)localLayoutParams;
/*  906 */       int[] arrayOfInt = ((RelativeLayout.LayoutParams)localObject).getRules();
/*  907 */       this.N = (arrayOfInt.length > 0 ? arrayOfInt[3] : 0);
/*  908 */       ((RelativeLayout.LayoutParams)localObject).addRule(3, 0);
/*  909 */       paramViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject);
/*      */     }
/*  911 */     if ((localLayoutParams instanceof MarginLayoutParams)) {
/*  912 */       localObject = (MarginLayoutParams)localLayoutParams;
/*  913 */       this.O.set(((MarginLayoutParams)localObject).leftMargin, ((MarginLayoutParams)localObject).topMargin, ((MarginLayoutParams)localObject).rightMargin, ((MarginLayoutParams)localObject).bottomMargin);
/*  914 */       s.b(paramViewGroup, 0, 0, 0, 0);
/*      */     }
/*      */     
/*  917 */     b(true);
/*      */     
/*  919 */     this.z.setImageDrawable(this.B.getResources().getDrawable(R.drawable.tt_shrink_video));
/*      */     
/*  921 */     this.P.setThumb(this.B.getResources().getDrawable(R.drawable.tt_seek_thumb_fullscreen_selector));
/*  922 */     this.P.setThumbOffset(0);
/*      */     
/*      */ 
/*  925 */     com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, false);
/*  926 */     d(this.G);
/*      */     
/*  928 */     this.f.setVisibility(8);
/*  929 */     if (!this.H) {
/*  930 */       this.d.setVisibility(8);
/*  931 */       this.c.setVisibility(8);
/*  932 */     } else if (this.ad.contains(b.a.a)) {
/*  933 */       s.a(this.d, 8);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void c(ViewGroup paramViewGroup)
/*      */   {
/*  941 */     if (paramViewGroup == null) {
/*  942 */       return;
/*      */     }
/*  944 */     if ((this.a == null) || (!(this.a.getLayoutParams() instanceof MarginLayoutParams))) {
/*  945 */       return;
/*      */     }
/*  947 */     this.G = false;
/*  948 */     this.af.a(false);
/*  949 */     MarginLayoutParams localMarginLayoutParams = (MarginLayoutParams)this.a.getLayoutParams();
/*  950 */     localMarginLayoutParams.width = this.L;
/*  951 */     localMarginLayoutParams.height = this.M;
/*  952 */     localMarginLayoutParams.leftMargin = this.K;
/*  953 */     localMarginLayoutParams.topMargin = this.J;
/*      */     
/*  955 */     this.a.setLayoutParams(localMarginLayoutParams);
/*      */     
/*  957 */     ViewGroup.LayoutParams localLayoutParams = paramViewGroup.getLayoutParams();
/*  958 */     if ((localLayoutParams instanceof RelativeLayout.LayoutParams)) {
/*  959 */       RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localLayoutParams;
/*  960 */       localLayoutParams1.addRule(3, this.N);
/*  961 */       paramViewGroup.setLayoutParams(localLayoutParams1);
/*      */     }
/*  963 */     if ((localLayoutParams instanceof MarginLayoutParams)) {
/*  964 */       s.b(paramViewGroup, this.O.left, this.O.top, this.O.right, this.O.bottom);
/*      */     }
/*  966 */     b(true);
/*      */     
/*  968 */     this.z.setImageDrawable(this.B.getResources().getDrawable(R.drawable.tt_enlarge_video));
/*      */     
/*      */ 
/*  971 */     this.P.setThumb(this.B.getResources().getDrawable(R.drawable.tt_seek_thumb_normal));
/*  972 */     this.P.setThumbOffset(0);
/*      */     
/*      */ 
/*  975 */     com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, true);
/*      */     
/*  977 */     d(this.G);
/*      */     
/*  979 */     this.f.setVisibility(8);
/*  980 */     if (this.ad.contains(b.a.b)) {
/*  981 */       this.c.setVisibility(0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void d(boolean paramBoolean)
/*      */   {
/*  988 */     if (paramBoolean) {
/*  989 */       u();
/*      */     } else {
/*  991 */       v();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  998 */   private Rect as = new Rect();
/*      */   
/*      */   private float at;
/*      */   private ColorStateList au;
/*      */   private float av;
/* 1003 */   private Rect aw = new Rect();
/* 1004 */   private Rect ax = new Rect();
/*      */   private boolean ay;
/*      */   
/* 1007 */   private void u() { DisplayMetrics localDisplayMetrics = this.B.getResources().getDisplayMetrics();
/*      */     ViewGroup.LayoutParams localLayoutParams;
/*      */     MarginLayoutParams localMarginLayoutParams;
/* 1010 */     if (this.S != null) {
/* 1011 */       this.ap = this.S.getTextSize();
/* 1012 */       this.S.setTextSize(2, 14.0F);
/* 1013 */       this.aq = this.S.getTextColors();
/*      */       
/* 1015 */       if (this.aq != null) {
/* 1016 */         this.S.setTextColor(this.B.getResources().getColor(R.color.tt_ssxinzi15));
/*      */       }
/* 1018 */       this.ar = this.S.getAlpha();
/* 1019 */       this.S.setAlpha(0.85F);
/* 1020 */       this.S.setShadowLayer(0.0F, s.a(this.B, 0.5F), s.a(this.B, 0.5F), this.B.getResources().getColor(R.color.tt_video_shaoow_color_fullscreen));
/* 1021 */       localLayoutParams = this.S.getLayoutParams();
/* 1022 */       if ((localLayoutParams instanceof MarginLayoutParams)) {
/* 1023 */         localMarginLayoutParams = (MarginLayoutParams)localLayoutParams;
/* 1024 */         this.as.set(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
/* 1025 */         s.b(this.S, (int)TypedValue.applyDimension(1, 16.0F, localDisplayMetrics), this.as.top, 
/* 1026 */           (int)TypedValue.applyDimension(1, 14.0F, localDisplayMetrics), this.as.bottom);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1031 */     if (this.R != null) {
/* 1032 */       this.at = this.R.getTextSize();
/* 1033 */       this.R.setTextSize(2, 14.0F);
/* 1034 */       this.au = this.R.getTextColors();
/*      */       
/* 1036 */       if (this.au != null) {
/* 1037 */         this.R.setTextColor(this.B.getResources().getColor(R.color.tt_ssxinzi15));
/*      */       }
/* 1039 */       this.av = this.R.getAlpha();
/* 1040 */       this.R.setAlpha(0.85F);
/* 1041 */       this.R.setShadowLayer(0.0F, s.a(this.B, 0.5F), s.a(this.B, 0.5F), this.B.getResources().getColor(R.color.tt_video_shaoow_color_fullscreen));
/* 1042 */       localLayoutParams = this.R.getLayoutParams();
/* 1043 */       if ((localLayoutParams instanceof MarginLayoutParams)) {
/* 1044 */         localMarginLayoutParams = (MarginLayoutParams)localLayoutParams;
/* 1045 */         this.aw.set(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
/* 1046 */         s.b(this.R, (int)TypedValue.applyDimension(1, 14.0F, localDisplayMetrics), this.aw.top, this.aw.right, this.aw.bottom);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1052 */     if (this.z != null) {
/* 1053 */       localLayoutParams = this.z.getLayoutParams();
/* 1054 */       if ((localLayoutParams instanceof MarginLayoutParams)) {
/* 1055 */         localMarginLayoutParams = (MarginLayoutParams)localLayoutParams;
/* 1056 */         this.ax.set(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
/* 1057 */         s.b(this.z, this.ax.left, this.ax.top, 
/* 1058 */           (int)TypedValue.applyDimension(1, 16.0F, localDisplayMetrics), this.ax.bottom);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1064 */     if (this.z != null) {
/* 1065 */       this.z.setImageDrawable(this.B.getResources().getDrawable(R.drawable.tt_shrink_fullscreen));
/*      */     }
/*      */     
/* 1068 */     if (this.h != null) {
/* 1069 */       this.T = this.h.getTextColors();
/* 1070 */       if (this.T != null) {
/* 1071 */         this.h.setTextColor(this.B.getResources().getColor(R.color.tt_ssxinzi15));
/*      */       }
/* 1073 */       this.U = this.h.getAlpha();
/* 1074 */       this.h.setAlpha(0.85F);
/* 1075 */       localLayoutParams = this.h.getLayoutParams();
/* 1076 */       if ((localLayoutParams instanceof MarginLayoutParams)) {
/* 1077 */         localMarginLayoutParams = (MarginLayoutParams)localLayoutParams;
/* 1078 */         this.V.set(localMarginLayoutParams.leftMargin, localMarginLayoutParams.topMargin, localMarginLayoutParams.rightMargin, localMarginLayoutParams.bottomMargin);
/* 1079 */         s.b(this.h, (int)TypedValue.applyDimension(1, 1.0F, localDisplayMetrics), this.aw.top, this.aw.right, this.aw.bottom);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1084 */     if (this.f != null) {
/* 1085 */       localLayoutParams = this.f.getLayoutParams();
/* 1086 */       this.W = localLayoutParams.height;
/* 1087 */       localLayoutParams.height = ((int)TypedValue.applyDimension(1, 49.0F, localDisplayMetrics));
/* 1088 */       this.f.setLayoutParams(localLayoutParams);
/* 1089 */       this.f.setBackgroundResource(R.drawable.tt_shadow_fullscreen_top);
/*      */     }
/*      */     
/* 1092 */     a(this.X, true);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void v()
/*      */   {
/* 1100 */     if (this.S != null) {
/* 1101 */       this.S.setTextSize(0, this.ap);
/*      */       
/* 1103 */       if (this.aq != null) {
/* 1104 */         this.S.setTextColor(this.aq);
/*      */       }
/* 1106 */       this.S.setAlpha(this.ar);
/* 1107 */       this.S.setShadowLayer(s.a(this.B, 1.0F), 0.0F, 0.0F, this.B.getResources().getColor(R.color.tt_video_shadow_color));
/* 1108 */       s.b(this.S, this.as.left, this.as.top, this.as.right, this.as.bottom);
/*      */     }
/*      */     
/*      */ 
/* 1112 */     if (this.R != null) {
/* 1113 */       this.R.setTextSize(0, this.at);
/* 1114 */       if (this.au != null) {
/* 1115 */         this.R.setTextColor(this.au);
/*      */       }
/* 1117 */       this.R.setAlpha(this.av);
/* 1118 */       this.R.setShadowLayer(s.a(this.B, 1.0F), 0.0F, 0.0F, this.B.getResources().getColor(R.color.tt_video_shadow_color));
/* 1119 */       s.b(this.R, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
/*      */     }
/*      */     
/* 1122 */     if (this.z != null) {
/* 1123 */       s.b(this.z, this.ax.left, this.ax.top, this.ax.right, this.ax.bottom);
/*      */     }
/*      */     
/*      */ 
/* 1127 */     if (this.z != null) {
/* 1128 */       this.z.setImageDrawable(this.B.getResources().getDrawable(R.drawable.tt_enlarge_video));
/*      */     }
/*      */     
/* 1131 */     if (this.h != null) {
/* 1132 */       if (this.T != null) {
/* 1133 */         this.h.setTextColor(this.T);
/*      */       }
/* 1135 */       this.h.setAlpha(this.U);
/* 1136 */       s.b(this.h, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
/*      */     }
/*      */     
/*      */ 
/* 1140 */     if (this.f != null) {
/* 1141 */       ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
/* 1142 */       localLayoutParams.height = this.W;
/* 1143 */       this.f.setLayoutParams(localLayoutParams);
/*      */       
/*      */ 
/*      */ 
/* 1147 */       this.f.setBackgroundResource(R.drawable.tt_video_black_desc_gradient);
/*      */     }
/*      */     
/* 1150 */     a(this.X, true);
/*      */   }
/*      */   
/*      */   public void a(Message paramMessage)
/*      */   {
/* 1155 */     switch (paramMessage.what) {
/*      */     case 1: 
/* 1157 */       l();
/* 1158 */       break;
/*      */     case 2: 
/* 1160 */       int i1 = paramMessage.arg1;
/* 1161 */       if ((this.az) && (i1 != w()) && (i1 != -1))
/*      */       {
/*      */ 
/* 1164 */         if (i1 == 1) {
/* 1165 */           if ((j()) && (s())) {
/* 1166 */             this.aa.a(this, null, true);
/*      */           }
/*      */         }
/* 1169 */         else if (s()) {
/* 1170 */           if (j())
/*      */           {
/* 1172 */             this.aa.a(i1);
/*      */           } else {
/* 1174 */             this.aa.a(this, null, i1 == 8, true);
/*      */           }
/*      */         }
/*      */       }
/*      */       break;
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
/*      */   {
/* 1184 */     this.y.setVisibility(0);
/* 1185 */     this.Q.setVisibility(0);
/* 1186 */     if (this.G) {
/* 1187 */       this.f.setVisibility(0);
/* 1188 */       this.h.setVisibility(0);
/* 1189 */     } else if (paramBoolean3) {
/* 1190 */       this.f.setVisibility(8);
/*      */     }
/* 1192 */     this.e.setVisibility((paramBoolean1) && (this.k.getVisibility() != 0) ? 0 : 8);
/* 1193 */     if ((!this.H) && (!this.G)) {
/* 1194 */       if ((!this.ad.contains(b.a.a)) && (!paramBoolean3)) {
/* 1195 */         this.d.setVisibility(0);
/*      */       }
/* 1197 */       this.c.setVisibility(paramBoolean3 ? 8 : 0);
/*      */     }
/*      */     
/* 1200 */     this.R.setVisibility(0);
/* 1201 */     this.S.setVisibility(0);
/* 1202 */     this.P.setVisibility(0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean az;
/*      */   
/*      */ 
/*      */ 
/*      */   public void b(boolean paramBoolean1, boolean paramBoolean2)
/*      */   {
/* 1214 */     this.y.setVisibility(8);
/* 1215 */     this.f.setVisibility(8);
/* 1216 */     this.Q.setVisibility(paramBoolean1 ? 0 : 8);
/* 1217 */     this.e.setVisibility(8);
/* 1218 */     if ((!this.H) && (!this.G)) {
/* 1219 */       this.d.setVisibility(8);
/* 1220 */       if (!this.ad.contains(b.a.b)) {
/* 1221 */         this.c.setVisibility(8);
/*      */       }
/* 1223 */     } else if (this.ad.contains(b.a.a)) {
/* 1224 */       s.a(this.d, 8);
/*      */     }
/* 1226 */     if (paramBoolean2) {
/* 1227 */       s.a(this.d, 8);
/* 1228 */       s.a(this.c, 8);
/*      */     }
/* 1230 */     c(false);
/*      */   }
/*      */   
/*      */   public void l()
/*      */   {
/* 1235 */     b(true, false);
/*      */   }
/*      */   
/*      */   public boolean c(int paramInt)
/*      */   {
/* 1240 */     return (this.P != null) && (paramInt > this.P.getSecondaryProgress());
/*      */   }
/*      */   
/*      */   public void c(boolean paramBoolean)
/*      */   {
/* 1245 */     if (this.g != null) {
/* 1246 */       if (this.H) {
/* 1247 */         this.g.setVisibility(8);
/*      */       } else {
/* 1249 */         this.g.setVisibility(paramBoolean ? 0 : 8);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean m()
/*      */   {
/* 1256 */     return this.ab;
/*      */   }
/*      */   
/*      */   public void d(int paramInt)
/*      */   {
/* 1261 */     this.ac = paramInt;
/* 1262 */     s.a(this.a, paramInt);
/*      */     
/* 1264 */     if (paramInt != 0) {
/* 1265 */       this.az = false;
/* 1266 */     } else if (this.ay) {
/* 1267 */       this.az = true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1278 */   private int aA = w();
/*      */   
/*      */   private int w() {
/* 1281 */     if (this.ae != null) {
/* 1282 */       int i1 = this.ae.getDefaultDisplay().getRotation();
/* 1283 */       switch (i1) {
/*      */       case 0: 
/* 1285 */         return 1;
/*      */       case 1: 
/* 1287 */         return 0;
/*      */       case 2: 
/* 1289 */         return 9;
/*      */       case 3: 
/* 1291 */         return 8;
/*      */       }
/*      */     }
/* 1294 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void a(View paramView, boolean paramBoolean)
/*      */   {
/* 1302 */     if (j()) {
/* 1303 */       SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
/* 1304 */       String str = localSimpleDateFormat.format(new Date());
/* 1305 */       m.b("NewLiveViewLayout", str);
/* 1306 */       if ((this.ai != null) && (!TextUtils.isEmpty(this.ai.j()))) {
/* 1307 */         a(this.ai.j());
/*      */       }
/* 1309 */       this.i.setText(str);
/*      */     } else {
/* 1311 */       a("");
/* 1312 */       this.i.setText("");
/*      */     }
/* 1314 */     boolean bool = false;
/* 1315 */     if (!this.aj) {
/* 1316 */       bool = true;
/* 1317 */       c((this.H) && (!this.G));
/* 1318 */       if (s()) {
/* 1319 */         this.aa.b(this, paramView, bool, this.k.getVisibility() != 0);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void n()
/*      */   {
/* 1326 */     l();
/* 1327 */     c(false);
/*      */   }
/*      */   
/*      */   public void b(long paramLong)
/*      */   {
/* 1332 */     if (s()) {
/* 1333 */       this.aa.d(paramLong);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean o()
/*      */   {
/* 1339 */     return this.af.a();
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean p()
/*      */   {
/* 1345 */     if ((this.ag != null) && (this.ag.a())) {
/* 1346 */       return true;
/*      */     }
/* 1348 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean x()
/*      */   {
/* 1357 */     return (!this.ad.contains(b.a.c)) || (this.H);
/*      */   }
/*      */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\video\a\h.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */