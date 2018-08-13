/*     */ package com.bytedance.sdk.openadsdk.core.widget;
/*     */ 
/*     */

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.video.a.d;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;

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
/*     */ public class a
/*     */ {
/*     */   private ao a;
/*  36 */   private boolean b = false;
/*  37 */   private boolean c = false;
/*     */   
/*  39 */   private boolean d = false;
/*     */   
/*     */   private Dialog e;
/*     */   
/*     */   private ProgressBar f;
/*     */   
/*     */   private ImageView g;
/*     */   private TextView h;
/*     */   private TextView i;
/*  48 */   private int j = 1000;
/*  49 */   private int k = 10;
/*     */   
/*  51 */   private long l = 0L;
/*     */   private float m;
/*     */   
/*  54 */   public a(ao parama) { this.a = parama;
/*  55 */     this.d = true;
/*     */   }
/*     */   
/*     */ 
/*     */   private float n;
/*     */   private int o;
/*     */   private int p;
/*  62 */   private boolean q = true;
/*  63 */   private boolean r = false;
/*     */   private View s;
/*     */   
/*     */   public void a(View paramView) {
/*  67 */     if (paramView != null) {
/*  68 */       this.s = paramView;
/*  69 */       paramView.setOnTouchListener(this.t);
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(boolean paramBoolean) {
/*  74 */     this.b = paramBoolean;
/*     */   }
/*     */   
/*     */   public void b(boolean paramBoolean) {
/*  78 */     this.c = paramBoolean;
/*     */   }
/*     */   
/*     */ 
/*  82 */   private View.OnTouchListener t = new View.OnTouchListener()
/*     */   {
/*     */     public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent) {
/*  85 */       if (a.p()) {
/*  86 */         return b || c;
/*     */       }
/*  88 */       float f1 = paramAnonymousMotionEvent.getX();
/*  89 */       float f2 = paramAnonymousMotionEvent.getY();
/*  90 */       switch (paramAnonymousMotionEvent.getAction()) {
/*     */       case 0:
                    u=a(paramAnonymousMotionEvent);
/*  93 */         m= f1;
/*  94 */        n= f2;
/*  95 */        o= (int)f1;
/*  96 */        p= (int)f2;
/*  97 */        q= true;
/*  98 */         if ((a != null) && (c && b)) {
/*  99 */           a.a(paramAnonymousView, true);
/*     */         }
/*     */         break;
/*     */       case 1:
            if (Math.abs(f1 - (float)o) > 20.0F || Math.abs(f2 - (float)p) > 20.0F) {
               q = false;
            }

            if (!b) {
                q = true;
            }

            r = false;
            m = 0.0F;
            n = 0.0F;
            o = 0;
            if (a != null) {
                a.a(paramAnonymousView, q);
            }

            if (a != null) {
                a.b(l);
            }

            u = false;
            break;
        case 2:
            if (b && !u) {
                float var5 = f1 - m;
                float var6 = f2 - n;
                float var7 = Math.abs(var5);
                float var8 = Math.abs(var6);
                if (!r) {
                    if (var7 <= 20.0F && var8 <= 20.0F) {
                        return true;
                    }

                    r = true;
                }

                if (a != null) {
                    a.p();
                }

                if (var7 > var8) {
                    if (var5 > 0.0F) {
                        b(var7);
                    } else if (var5 < 0.0F) {
                       a(var7);
                    }
                }

                m = f1;
                n = f2;
            }
            break;
        case 3:
            u = false;
/* 153 */         break;
/*     */       }
/*     */       
/*     */       
/* 157 */       return b|| c;
/*     */     }
/*     */   };
/*     */   
/*     */   private boolean u;
/*     */   
/*     */   private d v;
/*     */   
/*     */ 
/*     */   private boolean a(MotionEvent paramMotionEvent)
/*     */   {
/* 168 */     if (paramMotionEvent.getActionMasked() == 0) {
/* 169 */       int i1 = ViewWather.visibleWidth(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext());
/* 170 */       int i2 = ViewWather.visibleWidth(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext());
/*     */       
/* 172 */       float f1 = paramMotionEvent.getRawX();
/* 173 */       float f2 = paramMotionEvent.getRawY();
/*     */       
/* 175 */       if ((f1 <= i1 * 0.01F) || (f1 >= i1 * 0.99F) || (f2 <= i2 * 0.01F) || (f2 >= i2 * 0.99F))
/*     */       {
/* 177 */         return true;
/*     */       }
/*     */     }
/* 180 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void a(d paramd)
/*     */   {
/* 186 */     this.v = paramd;
/*     */   }
/*     */   
/*     */   private void a(float paramFloat)
/*     */   {
/* 191 */     if ((!this.b) || (!b())) {
/* 192 */       return;
/*     */     }
/* 194 */     this.v.a(this, paramFloat, false);
/*     */   }
/*     */   
/*     */   private void b(float paramFloat)
/*     */   {
/* 199 */     if ((!this.b) || (!b())) {
/* 200 */       return;
/*     */     }
/* 202 */     this.v.a(this, paramFloat, true);
/*     */   }
/*     */   
/*     */   private boolean b() {
/* 206 */     if (this.v == null) {
/* 207 */       return false;
/*     */     }
/* 209 */     return true;
/*     */   }
/*     */   
/*     */   public boolean a(Context paramContext, boolean paramBoolean, long paramLong1, long paramLong2) {
/* 213 */     if ((paramContext == null) || (paramLong2 <= 0L)) {
/* 214 */       return false;
/*     */     }
/* 216 */     if ((this.e == null) || (this.d)) {
/* 217 */       this.d = false;
/* 218 */       View localView = LayoutInflater.from(paramContext).inflate(R.layout.tt_video_progress_dialog, null);
/* 219 */       this.f = ((ProgressBar)localView.findViewById(R.id.duration_progressbar));
/* 220 */       this.h = ((TextView)localView.findViewById(R.id.tv_current));
/* 221 */       this.i = ((TextView)localView.findViewById(R.id.tv_duration));
/* 222 */       this.g = ((ImageView)localView.findViewById(R.id.duration_image_tip));
/*     */       
/* 224 */       this.e = new Dialog(paramContext, R.style.volume_dialog);
/* 225 */       this.e.setContentView(localView);
/* 226 */       this.e.getWindow().addFlags(8);
/* 227 */       this.e.getWindow().addFlags(32);
/* 228 */       this.e.getWindow().addFlags(16);
/* 229 */       this.e.getWindow().setLayout(-2, -2);
/*     */       
/* 231 */       WindowManager.LayoutParams localLayoutParams = this.e.getWindow().getAttributes();
/* 232 */       localLayoutParams.gravity = 17;
/* 233 */       this.e.getWindow().setAttributes(localLayoutParams);
/*     */     }
/*     */     
/* 236 */     if (this.f != null) {
/* 237 */       this.f.setProgress((int)(paramLong1 * 100L / paramLong2));
/*     */     }
/*     */     
/* 240 */     if (this.h != null) {
/* 241 */       this.h.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong1));
/*     */     }
/*     */     
/* 244 */     if (this.i != null) {
/* 245 */       this.i.setText(" / " + com.bytedance.sdk.openadsdk.core.video.d.a.a(paramLong2));
/*     */     }
/*     */     
/* 248 */     if (this.g != null) {
/* 249 */       if (paramBoolean) {
/* 250 */         this.g.setBackgroundResource(R.drawable.tt_forward_video);
/*     */       } else {
/* 252 */         this.g.setBackgroundResource(R.drawable.tt_back_video);
/*     */       }
/*     */     }
/*     */     try {
/* 256 */       if (!this.e.isShowing()) {
/* 257 */         this.e.show();
/* 258 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public boolean a() {
/*     */     try {
/* 267 */       if ((this.e != null) && (this.e.isShowing())) {
/* 268 */         this.e.dismiss();
/* 269 */         return true;
/*     */       }
/*     */     }
/*     */     catch (Exception localException) {}
/* 273 */     return false;
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
/*     */   public void a(Context paramContext, float paramFloat, boolean paramBoolean, long paramLong1, long paramLong2)
/*     */   {
/* 286 */     if ((paramContext == null) || (paramLong1 < 0L)) {
/* 287 */       return;
/*     */     }
/*     */     
/* 290 */     if (paramLong2 <= 0L) {
/* 291 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 298 */     int i1 = (int)(paramFloat / this.k * this.j);
/*     */     
/* 300 */     if (paramBoolean) {
/* 301 */       this.l += i1;
/*     */     } else {
/* 303 */       this.l -= i1;
/*     */     }
/* 305 */     if (this.l > paramLong2) {
/* 306 */       this.l = paramLong2;
/*     */     }
/* 308 */     if (this.l < 0L) {
/* 309 */       this.l = 0L;
/*     */     }
/* 311 */     if (a(paramContext, paramBoolean, this.l, paramLong2)) {
/* 312 */       this.l = paramLong1;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface ao
/*     */   {
/*     */     public abstract void a(View paramView, boolean paramBoolean);
/*     */     
/*     */     public abstract boolean n();
/*     */     
/*     */     public abstract void b(long paramLong);
/*     */     
/*     */     public abstract boolean p();
/*     */   }
/*     */ }


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\widget\SslHepler.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */