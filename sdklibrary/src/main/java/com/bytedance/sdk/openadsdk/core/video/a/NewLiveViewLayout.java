/*      */ package com.bytedance.sdk.openadsdk.core.video.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AQuery2;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.m;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.LogUtils;
import com.bytedance.sdk.openadsdk.ggg.MineHandler;
import com.bytedance.sdk.openadsdk.ggg.StringUtils;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

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
public class NewLiveViewLayout implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, com.bytedance.sdk.openadsdk.core.widget.a.ao, com.bytedance.sdk.openadsdk.core.widget.b.bbb, MineHandler.OnResult {
    private View a;
    private com.bytedance.sdk.openadsdk.core.video.renderview.b b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private View k;
    private View l;
    private View mView1;
    private ImageView n;
    private TextView o;
    private View p;
    private ImageView q;
    private View r;
    private RoundImageView s;
    private TextView mView;
    private TextView u;
    private TextView v;
    private RelativeLayout w;
    private ImageView mImageView;
    private View y;
    private ImageView z;
    private MineHandler A = new MineHandler(this);
    private Context B;
    private int C;
    private int D;
    private int E;
    private int F;
    private boolean G = false;
    private boolean H = true;
    private boolean I = false;
    private int J = 0;
    private int K = 0;
    private int L = 0;
    private int M = 0;
    private int N = 0;
    private Rect O = new Rect();
    private SeekBar P;
    private ProgressBar Q;
    private TextView R;
    private TextView S;
    private ColorStateList T;
    private float U;
    private Rect V = new Rect();
    private int W = 0;
    private boolean X;
    private int Y = 0;
    private int Z = 0;
    private d aa;
    private boolean ab;
    private int ac;
    private EnumSet<com.bytedance.sdk.openadsdk.core.video.a.b.a> ad;
    private WindowManager ae;
    private com.bytedance.sdk.openadsdk.core.widget.a af = null;
    private com.bytedance.sdk.openadsdk.core.widget.b ag;
    private AQuery2 ah;
    private final com.bytedance.sdk.openadsdk.core.nibuguan.h ai;
    private boolean aj = true;
    private DownLoadListenerImpl ak;
    private c al;
    private com.bytedance.sdk.openadsdk.core.a.a am;
    private boolean an = false;
    private View.OnTouchListener ao = new View.OnTouchListener() {
        private float b;

        public boolean onTouch(View var1, MotionEvent var2) {
            float var3 = var2.getX();
            switch(var2.getActionMasked()) {
                case 0:
                    this.b = var3;
                    break;
                case 1:
                    if (Math.abs(this.b - var2.getX()) < 10.0F) {
                        NewLiveViewLayout.this.an = true;
                    } else {
                        NewLiveViewLayout.this.an = false;
                    }
                    break;
                case 2:
                    var1.getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 3:
                    var1.getParent().requestDisallowInterceptTouchEvent(false);
            }

            return false;
        }
    };
    private float ap;
    private ColorStateList aq;
    private float ar;
    private Rect as = new Rect();
    private float at;
    private ColorStateList au;
    private float av;
    private Rect aw = new Rect();
    private Rect ax = new Rect();
    private boolean ay;
    private boolean az;
    private int aA = this.x();

    public NewLiveViewLayout(Context var1, View var2, boolean var3, EnumSet<com.bytedance.sdk.openadsdk.core.video.a.b.a> var4, com.bytedance.sdk.openadsdk.core.nibuguan.h var5, c var6) {
        this.ae = var1 instanceof Activity ? ((Activity)var1).getWindowManager() : null;
        this.B = com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext();
        this.a = var2;
        this.H = var3;
        this.af = new com.bytedance.sdk.openadsdk.core.widget.a(this);
        this.af.b(this.H);
        DisplayMetrics var7 = this.B.getResources().getDisplayMetrics();
        this.Y = var7.widthPixels;
        this.Z = var7.heightPixels;
        this.ad = var4 == null ? EnumSet.noneOf(com.bytedance.sdk.openadsdk.core.video.a.b.a.class) : var4;
        this.ah = new AQuery2(this.B);
        this.al = var6;
        this.ai = var5;
        this.d(8);
        this.a(var1, this.a);
        this.b();
        this.r();
    }

    private void r() {
        if (this.ai.c() == 4) {
            this.ak = new DownLoadListenerImpl(this.B, this.ai, "embeded_ad");
            this.ak.a(new DownLoadListenerImpl.b() {
                public void a() {
                    String var1 = NewLiveViewLayout.this.aj ? "click_start" : "click_start_detail";
                    AdEvent.a(NewLiveViewLayout.this.B, NewLiveViewLayout.this.ai, "embeded_ad", var1);
                }

                public void b() {
                    AdEvent.b(NewLiveViewLayout.this.B, NewLiveViewLayout.this.ai, "embeded_ad", "click_pause");
                }

                public void c() {
                    AdEvent.c(NewLiveViewLayout.this.B, NewLiveViewLayout.this.ai, "embeded_ad", "click_continue");
                }

                public void d() {
                    String var1 = NewLiveViewLayout.this.aj ? "click_open" : "click_open_detail";
                    AdEvent.h(NewLiveViewLayout.this.B, NewLiveViewLayout.this.ai, "embeded_ad", var1);
                }
            });
        }

        this.am = new com.bytedance.sdk.openadsdk.core.a.a(this.B, this.ai, "embeded_ad", 1);
        if (this.aj) {
            this.am.a(true);
        } else {
            this.am.a(false);
        }

        this.am.a(this.al);
        this.am.b(true);
        if (this.ak != null && this.am != null) {
            this.am.a(this.ak);
        }

    }

    private void a(Context var1, View var2) {
        SSRenderSurfaceView var3 = new SSRenderSurfaceView(this.B);
        if (var2 instanceof RelativeLayout) {
            RelativeLayout.LayoutParams var4 = new RelativeLayout.LayoutParams(-2, -2);
            var4.addRule(13);
            ((RelativeLayout)var2).addView(var3, 0, var4);
        }

        var3.setVisibility(View.GONE);
        this.b = (com.bytedance.sdk.openadsdk.core.video.renderview.b)var3;
        this.c = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_back);
        this.d = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_close);
        this.f = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_top_layout);
        this.j = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_fullscreen_back);
        this.g = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_title);
        this.h = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_top_title);
        this.i = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_current_time);
        this.e = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_play);
        this.Q = (ProgressBar)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_progress);
        this.k = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_loading_retry_layout);
        this.l = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_loading_progress);
        this.mView1 = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_loading_retry);
        this.n = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_retry);
        this.o = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_retry_des);
        this.w = (RelativeLayout)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_loading_cover);
        this.mImageView = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_loading_cover_image);
        this.P = (SeekBar)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_seekbar);
        this.R = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_time_left_time);
        this.S = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_time_play);
        this.p = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_cover);
        this.q = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_finish_cover_image);
        this.r = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_cover_center_layout);
        this.s = (RoundImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_logo_image);
        this.mView = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_btn_ad_image_tv);
        this.u = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_name);
        this.v = (TextView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_button);
        this.y = var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_bottom_layout);
        this.z = (ImageView)var2.findViewById(com.bytedance.sdk.openadsdk.R.id.video_ad_full_screen);
    }

    private void s() {
        if (this.aa != null && this.ag == null) {
            this.ag = new com.bytedance.sdk.openadsdk.core.widget.b();
            this.ag.a(this.B, this.a);
            this.ag.a(this.aa, this);
        }

    }

    public boolean a(int var1, m var2) {
        return this.ag != null ? this.ag.a(var1, var2) : true;
    }

    public void a() {
        if (this.ag != null) {
            this.ag.a(false);
        }

    }

    public void a(com.bytedance.sdk.openadsdk.core.video.a.a var1) {
        if (var1 instanceof d) {
            this.aa = (d)var1;
            this.af.a(this.aa);
            this.s();
        }

    }

    private boolean t() {
        if (this.aa == null) {
            LogUtils.e("NewLiveViewLayout", "callback is null");
            return false;
        } else {
            return true;
        }
    }

    public void b() {
        this.b.a(this);
        this.af.a(this.a);
        this.d.setVisibility(!this.H && !this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.a) ? View.VISIBLE : View.GONE);
        this.d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.c(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.c.setVisibility(this.H && !this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.b) ?View.VISIBLE : View.GONE);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.d(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.e(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.a(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                NewLiveViewLayout.this.a(false, true);
                NewLiveViewLayout.this.i();
                NewLiveViewLayout.this.e();
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.f(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.z.setOnClickListener(new View.OnClickListener() {
            public void onClick(View var1) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.b(NewLiveViewLayout.this, var1);
                }

            }
        });
        this.P.setThumbOffset(0);
        this.P.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar var1) {
                if (!NewLiveViewLayout.this.G && NewLiveViewLayout.this.B != null) {
                    var1.setThumb(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext().getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_seek_thumb_normal));
                }

                if (NewLiveViewLayout.this.t()) {
                    var1.setThumbOffset(0);
                    NewLiveViewLayout.this.aa.a(NewLiveViewLayout.this, var1.getProgress());
                }

            }

            public void onStartTrackingTouch(SeekBar var1) {
                if (!NewLiveViewLayout.this.G && NewLiveViewLayout.this.B != null) {
                    var1.setThumb(com.bytedance.sdk.openadsdk.core.n.a().getApplicationContext().getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_seek_thumb_press));
                }

                if (NewLiveViewLayout.this.t()) {
                    var1.setThumbOffset(0);
                    NewLiveViewLayout.this.aa.b(NewLiveViewLayout.this, var1.getProgress());
                }

            }

            public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
                if (NewLiveViewLayout.this.t()) {
                    NewLiveViewLayout.this.aa.a(NewLiveViewLayout.this, var2, var3);
                }

            }
        });
        this.P.setOnTouchListener(this.ao);
    }

    public void a(int var1) {
        this.a.setVisibility(View.VISIBLE);
        if (this.b != null) {
            this.b.setVisibility(var1);
        }

    }

    public void a(boolean var1) {
        this.aj = var1;
        if (this.am != null) {
            if (this.aj) {
                this.am.a(true);
            } else {
                this.am.a(false);
            }

        }
    }

    public void c() {
        this.A.removeMessages(1);
        Message var1 = this.A.obtainMessage(1);
        this.A.sendMessageDelayed(var1, 2000L);
    }

    public void d() {
        this.A.removeMessages(1);
    }

    public void b(boolean var1) {
        int var2 = this.k() ? this.Z : this.C;
        int var3 = this.k() ? this.Y : this.D;
        if (this.F > 0 && this.E > 0) {
            if (var2 > 0) {
                boolean var4 = false;
                boolean var5 = false;
                boolean var6 = false;
                int var11;
                if (!this.l() && !this.k() && !this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.d)) {
                    var11 = this.B.getResources().getDimensionPixelSize(com.bytedance.sdk.openadsdk.R.dimen.video_container_maxheight);
                } else {
                    var11 = var3;
                }

                int var12 = var2;
                float var7 = (float)var2 * 1.0F / (float)this.E;
                int var8 = (int)((float)this.F * var7);
                int var13;
                if (var8 > var11) {
                    var13 = var11;
                    var7 = (float)var11 * 1.0F / (float)this.F;
                    var12 = (int)((float)this.E * var7);
                } else {
                    var13 = var8;
                }

                int var9;
                int var10;
                if (!var1 && !this.k()) {
                    var9 = this.C;
                    var10 = this.D;
                } else {
                    var9 = var12;
                    var10 = var13;
                }

                this.b.a(var9, var10);
            }
        }
    }

    public void a(int var1, int var2) {
        if (var1 == -1) {
            DisplayMetrics var3 = this.B.getResources().getDisplayMetrics();
            var1 = var3.widthPixels;
        }

        if (var1 > 0) {
            this.C = var1;
            if (!this.l() && !this.k() && !this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.d)) {
                this.D = this.e(var1);
            } else {
                this.D = var2;
            }

            this.b(this.C, this.D);
        }
    }

    public void a(boolean var1, boolean var2) {
        this.X = var1;
        if (this.e != null) {
            if (var1) {
                this.e.setImageResource(com.bytedance.sdk.openadsdk.R.drawable.tt_play_movebar_textpage);
            } else {
                this.e.setImageResource(com.bytedance.sdk.openadsdk.R.drawable.tt_stop_movebar_textpage);
            }
        }

    }

    public void a(String var1) {
        if (this.g != null) {
            this.g.setText(var1);
        }

        if (this.h != null) {
            this.h.setText(var1);
        }

    }

    public void b(int var1, int var2) {
        android.view.ViewGroup.LayoutParams var3 = this.a.getLayoutParams();
        if (var1 == -1 || var1 == -2 || var1 > 0) {
            var3.width = var1;
        }

        if (var2 == -1 || var2 == -2 || var2 > 0) {
            var3.height = var2;
        }

        this.a.setLayoutParams(var3);
    }

    private int e(int var1) {
        if (this.E > 0 && this.F > 0) {
            int var2 = this.B.getResources().getDimensionPixelSize(com.bytedance.sdk.openadsdk.R.dimen.video_container_maxheight);
            int var3 = this.B.getResources().getDimensionPixelSize(com.bytedance.sdk.openadsdk.R.dimen.video_container_minheight);
            boolean var4 = false;
            float var5 = (float)var1 * 1.0F / (float)this.E;
            int var6 = (int)((float)this.F * var5);
            int var7;
            if (var6 > var2) {
                var7 = var2;
            } else if (var6 < var3) {
                var7 = var3;
            } else {
                var7 = var6;
            }

            return var7;
        } else {
            return 0;
        }
    }

    public void c(int var1, int var2) {
        this.E = var1;
        this.F = var2;
    }

    public void b(int var1) {
        if (this.y != null && this.y.getVisibility() == View.VISIBLE) {
            ViewWather.a(this.Q, 8);
        } else {
            ViewWather.a(this.Q, 0);
            this.P.setProgress(var1);
            this.Q.setProgress(var1);
        }

    }

    public void a(long var1, long var3) {
        this.R.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(var3));
        this.S.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(var1));
        int var5 = com.bytedance.sdk.openadsdk.core.video.d.a.a(var1, var3);
        this.P.setProgress(var5);
    }

    public void a(ViewGroup var1) {
        if (this.a.getParent() != null) {
            ViewGroup var2 = (ViewGroup)this.a.getParent();
            var2.removeView(this.a);
        }

        this.ay = true;
        var1.addView(this.a);
        this.d(0);
    }

    public void e() {
        this.k.setVisibility(View.VISIBLE);
        this.l.setVisibility(View.VISIBLE);
        this.mView1.setVisibility(View.GONE);
        if (this.w != null && this.mImageView != null && this.ai != null) {
            ViewWather.a(this.w, 0);
            ((AQuery)this.ah.id(this.mImageView)).image(this.ai.a().c());
        }

        if (this.e.getVisibility() == View.VISIBLE) {
            this.e.setVisibility(View.GONE);
        }

    }

    public void f() {
        this.b(false, this.H);
        this.u();
    }

    public void a(long var1) {
        this.S.setText(com.bytedance.sdk.openadsdk.core.video.d.a.a(var1));
    }

    public void g() {
        ViewWather.a(this.a, 0);
        if (this.b != null) {
            View var1 = this.b.getView();
            if (var1 instanceof TextureView) {
                ViewParent var2 = var1.getParent();
                if (var2 instanceof ViewGroup) {
                    ViewGroup var3 = (ViewGroup)var2;
                    int var4 = var3.indexOfChild(var1);
                    var3.removeView(var1);
                    var3.addView(var1, var4);
                }
            }

            var1.setVisibility(View.GONE);
            var1.setVisibility(View.VISIBLE);
        }

    }

    private void u() {
        ViewWather.a(this.p, 8);
        ViewWather.a(this.q, 8);
        ViewWather.a(this.r, 8);
        ViewWather.a(this.s, 8);
        ViewWather.a(this.mView, 8);
        ViewWather.a(this.u, 8);
        ViewWather.a(this.v, 8);
    }

    public void a(com.bytedance.sdk.openadsdk.core.nibuguan.h var1, WeakReference<Context> var2, boolean var3) {
        if (var1 != null) {
            this.b(false, this.H);
            ViewWather.a(this.p, 0);
            ViewWather.a(this.q, 0);
            ViewWather.a(this.r, 0);
            String var4 = "";
            if (!StringUtils.isEmpty(var1.b())) {
                var4 = var1.b();
            } else if (!StringUtils.isEmpty(var1.j())) {
                var4 = var1.j();
            } else if (!StringUtils.isEmpty(var1.k())) {
                var4 = var1.k();
            }

            if (this.ai != null && this.ai.d() != null && this.ai.d().a() != null) {
                ViewWather.a(this.s, 0);
                ViewWather.a(this.mView, 4);
                ((AQuery)this.ah.id(this.s)).image(this.ai.d().a());
                this.s.setOnClickListener(this.am);
                this.s.setOnTouchListener(this.am);
            } else if (!StringUtils.isEmpty(var4)) {
                ViewWather.a(this.s, 4);
                ViewWather.a(this.mView, 0);
                this.mView.setText(var4.substring(0, 1));
                this.mView.setOnClickListener(this.am);
                this.mView.setOnTouchListener(this.am);
            }

            if (!StringUtils.isEmpty(var4)) {
                this.u.setText(var4);
            }

            ViewWather.a(this.u, 0);
            ViewWather.a(this.v, 0);
            switch(var1.c()) {
                case 2:
                case 3:
                    this.v.setText(this.B.getResources().getString(com.bytedance.sdk.openadsdk.R.string.video_mobile_go_detail));
                    break;
                case 4:
                    this.v.setText(this.B.getResources().getString(com.bytedance.sdk.openadsdk.R.string.video_download_apk));
                    break;
                case 5:
                    this.v.setText(this.B.getResources().getString(com.bytedance.sdk.openadsdk.R.string.video_dial_phone));
                    break;
                default:
                    this.v.setText(this.B.getResources().getString(com.bytedance.sdk.openadsdk.R.string.video_mobile_go_detail));
            }

            this.v.setOnClickListener(this.am);
            this.v.setOnTouchListener(this.am);
        }
    }

    public void h() {
        this.k.setVisibility(View.GONE);
        this.l.setVisibility(View.GONE);
        if (this.w != null) {
            ViewWather.a(this.w, 8);
        }

    }

    public void i() {
        this.k.setVisibility(View.GONE);
        this.mView1.setVisibility(View.GONE);
    }

    public void a(SurfaceHolder var1) {
        this.A.removeMessages(2);
        if (var1 == this.b.getHolder()) {
            this.ab = true;
            if (this.t()) {
                this.aa.a(this, var1);
            }

        }
    }

    public void a(SurfaceHolder var1, int var2, int var3, int var4) {
        if (this.A.hasMessages(2)) {
            this.A.removeMessages(2);
            if (this.aA != -1) {
                this.A.sendMessageDelayed(Message.obtain(this.A, 2, this.aA, 0), 500L);
                this.aA = -1;
            }
        }

        if (var1 == this.b.getHolder()) {
            if (this.t()) {
                this.aa.a(this, var1, var2, var3, var4);
            }

        }
    }

    public void b(SurfaceHolder var1) {
        this.A.removeMessages(2);
        if (var1 == this.b.getHolder()) {
            this.ab = false;
            if (this.t()) {
                this.aa.b(this, var1);
            }

        }
    }

    public void j() {
        this.P.setProgress(0);
        this.P.setSecondaryProgress(0);
        this.Q.setProgress(0);
        this.Q.setSecondaryProgress(0);
        this.R.setText("00:00");
        this.S.setText("00:00");
        this.d(8);
        if (this.y()) {
            this.b.setVisibility(View.GONE);
        }

        if (this.mImageView != null) {
            this.mImageView.setImageDrawable((Drawable)null);
        }

        this.d(8);
        this.y.setVisibility(View.GONE);
        this.p.setVisibility(View.GONE);
        this.q.setVisibility(View.GONE);
        this.r.setVisibility(View.GONE);
        this.s.setVisibility(View.GONE);
        this.mView.setVisibility(View.GONE);
        this.u.setVisibility(View.GONE);
        if (this.ag != null) {
            this.ag.a(true);
        }

    }

    public boolean k() {
        return this.G;
    }

    public boolean l() {
        return this.H;
    }

    public void b(ViewGroup var1) {
        if (var1 != null) {
            if (this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                this.G = true;
                this.af.a(true);
                ViewGroup.MarginLayoutParams var2 = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
                this.K = var2.leftMargin;
                this.J = var2.topMargin;
                this.L = var2.width;
                this.M = var2.height;
                var2.width = -1;
                var2.height = -1;
                var2.topMargin = 0;
                var2.leftMargin = 0;
                this.a.setLayoutParams(var2);
                android.view.ViewGroup.LayoutParams var3 = var1.getLayoutParams();
                if (var3 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams var4 = (RelativeLayout.LayoutParams)var3;
                    int[] var5 = var4.getRules();
                    this.N = var5.length > 0 ? var5[3] : 0;
                    var4.addRule(3, 0);
                    var1.setLayoutParams(var4);
                }

                if (var3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams var6 = (ViewGroup.MarginLayoutParams)var3;
                    this.O.set(var6.leftMargin, var6.topMargin, var6.rightMargin, var6.bottomMargin);
                    ViewWather.a(var1, 0, 0, 0, 0);
                }

                this.b(true);
                this.z.setImageDrawable(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_shrink_video));
                this.P.setThumb(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_seek_thumb_fullscreen_selector));
                this.P.setThumbOffset(0);
                com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, false);
                this.d(this.G);
                this.f.setVisibility(View.GONE);
                if (!this.H) {
                    this.d.setVisibility(View.GONE);
                    this.c.setVisibility(View.GONE);
                } else if (this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.a)) {
                    ViewWather.a(this.d, 8);
                }

            }
        }
    }

    public void c(ViewGroup var1) {
        if (var1 != null) {
            if (this.a != null && this.a.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                this.G = false;
                this.af.a(false);
                ViewGroup.MarginLayoutParams var2 = (ViewGroup.MarginLayoutParams)this.a.getLayoutParams();
                var2.width = this.L;
                var2.height = this.M;
                var2.leftMargin = this.K;
                var2.topMargin = this.J;
                this.a.setLayoutParams(var2);
                android.view.ViewGroup.LayoutParams var3 = var1.getLayoutParams();
                if (var3 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams var4 = (RelativeLayout.LayoutParams)var3;
                    var4.addRule(3, this.N);
                    var1.setLayoutParams(var4);
                }

                if (var3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewWather.a(var1, this.O.left, this.O.top, this.O.right, this.O.bottom);
                }

                this.b(true);
                this.z.setImageDrawable(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_enlarge_video));
                this.P.setThumb(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_seek_thumb_normal));
                this.P.setThumbOffset(0);
                com.bytedance.sdk.openadsdk.core.video.d.a.a(this.a, true);
                this.d(this.G);
                this.f.setVisibility(View.GONE);
                if (this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.b)) {
                    this.c.setVisibility(View.VISIBLE);
                }

            }
        }
    }

    private void d(boolean var1) {
        if (var1) {
            this.v();
        } else {
            this.w();
        }

    }

    private void v() {
        DisplayMetrics var1 = this.B.getResources().getDisplayMetrics();
        android.view.ViewGroup.LayoutParams var2;
        ViewGroup.MarginLayoutParams var3;
        if (this.S != null) {
            this.ap = this.S.getTextSize();
            this.S.setTextSize(2, 14.0F);
            this.aq = this.S.getTextColors();
            if (this.aq != null) {
                this.S.setTextColor(this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_ssxinzi15));
            }

            this.ar = this.S.getAlpha();
            this.S.setAlpha(0.85F);
            this.S.setShadowLayer(0.0F, ViewWather.a(this.B, 0.5F), ViewWather.a(this.B, 0.5F), this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_video_shaoow_color_fullscreen));
            var2 = this.S.getLayoutParams();
            if (var2 instanceof ViewGroup.MarginLayoutParams) {
                var3 = (ViewGroup.MarginLayoutParams)var2;
                this.as.set(var3.leftMargin, var3.topMargin, var3.rightMargin, var3.bottomMargin);
                ViewWather.a(this.S, (int) TypedValue.applyDimension(1, 16.0F, var1), this.as.top, (int)TypedValue.applyDimension(1, 14.0F, var1), this.as.bottom);
            }
        }

        if (this.R != null) {
            this.at = this.R.getTextSize();
            this.R.setTextSize(2, 14.0F);
            this.au = this.R.getTextColors();
            if (this.au != null) {
                this.R.setTextColor(this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_ssxinzi15));
            }

            this.av = this.R.getAlpha();
            this.R.setAlpha(0.85F);
            this.R.setShadowLayer(0.0F, ViewWather.a(this.B, 0.5F), ViewWather.a(this.B, 0.5F), this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_video_shaoow_color_fullscreen));
            var2 = this.R.getLayoutParams();
            if (var2 instanceof ViewGroup.MarginLayoutParams) {
                var3 = (ViewGroup.MarginLayoutParams)var2;
                this.aw.set(var3.leftMargin, var3.topMargin, var3.rightMargin, var3.bottomMargin);
                ViewWather.a(this.R, (int)TypedValue.applyDimension(1, 14.0F, var1), this.aw.top, this.aw.right, this.aw.bottom);
            }
        }

        if (this.z != null) {
            var2 = this.z.getLayoutParams();
            if (var2 instanceof ViewGroup.MarginLayoutParams) {
                var3 = (ViewGroup.MarginLayoutParams)var2;
                this.ax.set(var3.leftMargin, var3.topMargin, var3.rightMargin, var3.bottomMargin);
                ViewWather.a(this.z, this.ax.left, this.ax.top, (int)TypedValue.applyDimension(1, 16.0F, var1), this.ax.bottom);
            }
        }

        if (this.z != null) {
            this.z.setImageDrawable(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_shrink_fullscreen));
        }

        if (this.h != null) {
            this.T = this.h.getTextColors();
            if (this.T != null) {
                this.h.setTextColor(this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_ssxinzi15));
            }

            this.U = this.h.getAlpha();
            this.h.setAlpha(0.85F);
            var2 = this.h.getLayoutParams();
            if (var2 instanceof ViewGroup.MarginLayoutParams) {
                var3 = (ViewGroup.MarginLayoutParams)var2;
                this.V.set(var3.leftMargin, var3.topMargin, var3.rightMargin, var3.bottomMargin);
                ViewWather.a(this.h, (int)TypedValue.applyDimension(1, 1.0F, var1), this.aw.top, this.aw.right, this.aw.bottom);
            }
        }

        if (this.f != null) {
            var2 = this.f.getLayoutParams();
            this.W = var2.height;
            var2.height = (int)TypedValue.applyDimension(1, 49.0F, var1);
            this.f.setLayoutParams(var2);
            this.f.setBackgroundResource(com.bytedance.sdk.openadsdk.R.drawable.tt_shadow_fullscreen_top);
        }

        this.a(this.X, true);
    }

    private void w() {
        if (this.S != null) {
            this.S.setTextSize(0, this.ap);
            if (this.aq != null) {
                this.S.setTextColor(this.aq);
            }

            this.S.setAlpha(this.ar);
            this.S.setShadowLayer(ViewWather.a(this.B, 1.0F), 0.0F, 0.0F, this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_video_shadow_color));
            ViewWather.a(this.S, this.as.left, this.as.top, this.as.right, this.as.bottom);
        }

        if (this.R != null) {
            this.R.setTextSize(0, this.at);
            if (this.au != null) {
                this.R.setTextColor(this.au);
            }

            this.R.setAlpha(this.av);
            this.R.setShadowLayer(ViewWather.a(this.B, 1.0F), 0.0F, 0.0F, this.B.getResources().getColor(com.bytedance.sdk.openadsdk.R.color.tt_video_shadow_color));
            ViewWather.a(this.R, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
        }

        if (this.z != null) {
            ViewWather.a(this.z, this.ax.left, this.ax.top, this.ax.right, this.ax.bottom);
        }

        if (this.z != null) {
            this.z.setImageDrawable(this.B.getResources().getDrawable(com.bytedance.sdk.openadsdk.R.drawable.tt_enlarge_video));
        }

        if (this.h != null) {
            if (this.T != null) {
                this.h.setTextColor(this.T);
            }

            this.h.setAlpha(this.U);
            ViewWather.a(this.h, this.aw.left, this.aw.top, this.aw.right, this.aw.bottom);
        }

        if (this.f != null) {
            android.view.ViewGroup.LayoutParams var1 = this.f.getLayoutParams();
            var1.height = this.W;
            this.f.setLayoutParams(var1);
            this.f.setBackgroundResource(com.bytedance.sdk.openadsdk.R.drawable.tt_video_black_desc_gradient);
        }

        this.a(this.X, true);
    }

    public void doResult(Message var1) {
        switch(var1.what) {
            case 1:
                this.m();
                break;
            case 2:
                int var2 = var1.arg1;
                if (this.az && var2 != this.x() && var2 != -1) {
                    if (var2 == 1) {
                        if (this.k() && this.t()) {
                            this.aa.a(this, (View)null, true);
                        }
                    } else if (this.t()) {
                        if (this.k()) {
                            this.aa.a(var2);
                        } else {
                            this.aa.a(this, (View)null, var2 == 8, true);
                        }
                    }
                }
        }

    }

    public void a(boolean var1, boolean var2, boolean var3) {
        this.y.setVisibility(View.VISIBLE);
        this.Q.setVisibility(View.VISIBLE);
        if (this.G) {
            this.f.setVisibility(View.VISIBLE);
            this.h.setVisibility(View.VISIBLE);
        } else if (var3) {
            this.f.setVisibility(View.GONE);
        }

        this.e.setVisibility(var1 && this.k.getVisibility() != View.VISIBLE ? View.VISIBLE : View.GONE);
        if (!this.H && !this.G) {
            if (!this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.a) && !var3) {
                this.d.setVisibility(View.VISIBLE);
            }

            this.c.setVisibility(var3 ? View.GONE : View.VISIBLE);
        }

        this.R.setVisibility(View.VISIBLE);
        this.S.setVisibility(View.VISIBLE);
        this.P.setVisibility(View.VISIBLE);
    }

    public void b(boolean var1, boolean var2) {
        this.y.setVisibility(View.GONE);
        this.f.setVisibility(View.GONE);
        this.Q.setVisibility(var1 ? View.VISIBLE : View.GONE);
        this.e.setVisibility(View.GONE);
        if (!this.H && !this.G) {
            this.d.setVisibility(View.GONE);
            if (!this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.b)) {
                this.c.setVisibility(View.GONE);
            }
        } else if (this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.a)) {
            ViewWather.a(this.d, 8);
        }

        if (var2) {
            ViewWather.a(this.d, 8);
            ViewWather.a(this.c, 8);
        }

        this.c(false);
    }

    public void m() {
        this.b(true, false);
    }

    public boolean c(int var1) {
        return this.P != null && var1 > this.P.getSecondaryProgress();
    }

    public void c(boolean var1) {
        if (this.g != null) {
            if (this.H) {
                this.g.setVisibility(View.GONE);
            } else {
                this.g.setVisibility(var1 ? View.VISIBLE : View.GONE);
            }
        }

    }

    public boolean n() {
        return this.ab;
    }

    public void d(int var1) {
        this.ac = var1;
        ViewWather.a(this.a, var1);
        if (var1 != 0) {
            this.az = false;
        } else if (this.ay) {
            this.az = true;
        }

    }

    private int x() {
        if (this.ae != null) {
            int var1 = this.ae.getDefaultDisplay().getRotation();
            switch(var1) {
                case 0:
                    return 1;
                case 1:
                    return 0;
                case 2:
                    return 9;
                case 3:
                    return 8;
            }
        }

        return -1;
    }

    public void a(View var1, boolean var2) {
        if (this.k()) {
            SimpleDateFormat var3 = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String var4 = var3.format(new Date());
            LogUtils.b("NewLiveViewLayout", var4);
            if (this.ai != null && !TextUtils.isEmpty(this.ai.j())) {
                this.a(this.ai.j());
            }

            this.i.setText(var4);
        } else {
            this.a("");
            this.i.setText("");
        }

        boolean var5 = false;
        if (!this.aj) {
            var5 = true;
            this.c(this.H && !this.G);
            if (this.t()) {
                this.aa.b(this, var1, var5, this.k.getVisibility() != View.VISIBLE);
            }
        }

    }

    public void o() {
        this.m();
        this.c(false);
    }

    public void b(long var1) {
        if (this.t()) {
            this.aa.d(var1);
        }

    }

    public boolean p() {
        return this.af.a();
    }

    public boolean q() {
        return this.ag != null && this.ag.a();
    }

    private boolean y() {
        return !this.ad.contains(com.bytedance.sdk.openadsdk.core.video.a.b.a.c) || this.H;
    }
}