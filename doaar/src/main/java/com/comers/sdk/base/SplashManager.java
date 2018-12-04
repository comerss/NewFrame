package com.comers.sdk.base;


import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;


public class SplashManager extends View {
    private boolean isAttached;
    private boolean needCheckShow;
    private SplashListener mSplashListener;
    private View splshView;
    @Nullable
    private boolean isAttach;
    private int i=3;
    protected final Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message paramAnonymousMessage) {
            switch (paramAnonymousMessage.what) {
                case 1:
                    if (isAttached) {
                        if (ViewHelper.canShow(splshView, 20, i)) {
                            removeTask();
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
                    boolean bool = DogUtils.d(mContext, mContext.getPackageName());
                    if (!ViewHelper.canShow(splshView, 20, i) && bool) {
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
    Context mContext;
    public SplashManager(Context paramContext, View paramView) {
        super(paramContext);
        this.splshView = paramView;
        mContext=paramContext;
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
        attach();
        this.isAttach = false;
        if (this.mSplashListener != null) {
            this.mSplashListener.onAttachedToWindow();
        }
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeTask();
        this.isAttach = true;
        if (this.mSplashListener != null) {
            this.mSplashListener.onDetachedFromWindow();
        }
    }


    void attach() {
        if ((!this.needCheckShow) || (this.isAttached)) {
            return;
        }
        this.isAttached = true;
        this.mHandler.sendEmptyMessage(1);
    }

    void removeTask() {
        if (!this.isAttached) {
            return;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.isAttached = false;
    }

    public void setNeedCheckingShow(boolean paramBoolean) {
        this.needCheckShow = paramBoolean;
        if ((!paramBoolean) && (this.isAttached)) {
            removeTask();
        } else if ((paramBoolean) && (!this.isAttached)) {
            attach();
        }
    }

    public void setCallback(SplashListener parama) {
        this.mSplashListener = parama;
    }

    public void setAdType(int paramInt) {
        this.i = paramInt;
    }

    public  interface SplashListener {
         void onWindowFocusChanged(boolean paramBoolean);

         void onAttachedToWindow();

         void onDetachedFromWindow();

         void onShow(View paramView);
    }
}

