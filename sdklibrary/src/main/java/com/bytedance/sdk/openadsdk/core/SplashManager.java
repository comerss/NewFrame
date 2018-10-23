package com.bytedance.sdk.openadsdk.core;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.core.a.AdClickListener;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;
import com.bytedance.sdk.openadsdk.ggg.ListUtils;

import java.util.List;


public class SplashManager extends View {
    private boolean b;
    private boolean needCheckShow;
    private SplashListener mSplashListener;
    private View splshView;
    private List<View> clickViews;
    @Nullable
    private List<View> crativeViews;
    private boolean isAttach;
    private int i;
    protected final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                case 1:
                    if (b) {
                        if (ViewHelper.a(splshView, 20, i)) {
                            c();
                            mHandler.sendEmptyMessageDelayed(2, 1000L);
                            if (mSplashListener != null) {
                                mSplashListener.onShow(splshView);
                            }
                        } else {
                            mHandler.sendEmptyMessageDelayed(1, 1000L);
                        }
                    }

                    break;
                case 2:
                    boolean bool = ToolUtils.d(n.a(), n.a().getPackageName());
                    if (!ViewHelper.a(splshView, 20, i) && bool) {
                        if (!isAttach) {
                            setNeedCheckingShow(true);
                        }
                    } else {
                        mHandler.sendEmptyMessageDelayed(2, 1000L);
                    }

                    break;
            }

        }
    };

    public SplashManager(Context paramContext, View paramView) {
        super(n.a());
        this.splshView = paramView;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }
    @Override
    public void onWindowFocusChanged(boolean paramBoolean) {
        super.onWindowFocusChanged(paramBoolean);
        if (this.mSplashListener != null) {
            this.mSplashListener.onWindowFocusChanged(paramBoolean);
        }
    }
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
        this.isAttach = false;
        if (this.mSplashListener != null) {
            this.mSplashListener.onAttachedToWindow();
        }
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
        this.isAttach = true;
        if (this.mSplashListener != null) {
            this.mSplashListener.onDetachedFromWindow();
        }
    }


    public void setRefClickViews(List<View> paramList) {
        this.clickViews = paramList;
    }

    public void setRefCreativeViews(@Nullable List<View> paramList) {
        this.crativeViews = paramList;
    }

    public void noClick() {
        onClick(this.clickViews, null);
        onClick(this.crativeViews, null);
    }

    public void onClick(List<View> paramList, AdClickListener paramd) {
        if (ListUtils.checkEmpty(paramList)) {
            for (View localView : paramList) {
                localView.setOnClickListener(paramd);
                localView.setOnTouchListener(paramd);
            }
        }
    }


    void b() {
        if ((!this.needCheckShow) || (this.b)) {
            return;
        }
        this.b = true;
        this.mHandler.sendEmptyMessage(1);
    }

    void c() {
        if (!this.b) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.b = false;
    }

    public void setNeedCheckingShow(boolean paramBoolean) {
        this.needCheckShow = paramBoolean;
        if ((!paramBoolean) && (this.b)) {
            c();
        } else if ((paramBoolean) && (!this.b)) {
            b();
        }
    }

    public void setCallback(SplashListener parama) {
        this.mSplashListener = parama;
    }

    public void setAdType(int paramInt) {
        this.i = paramInt;
    }

    public  interface SplashListener {
        public abstract void onWindowFocusChanged(boolean paramBoolean);

        public abstract void onAttachedToWindow();

        public abstract void onDetachedFromWindow();

        public abstract void onShow(View paramView);
    }
}

