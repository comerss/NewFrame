package com.bytedance.sdk.openadsdk.core.a;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.c;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.ViewWather;

import java.lang.ref.WeakReference;


public class AdClickListenerImpl extends AdClickListener {
    protected Context mContext;
    protected NativeAdData mAdData;
    protected String d;
    protected int e;
    protected WeakReference<View> mWeakReference;
    protected WeakReference<View> mReference;
    protected com.bytedance.sdk.openadsdk.core.nibuguan.c h;
    protected OnClick mOnClick;
    protected TTFeedAd mTTFeedAd;
    protected com.bytedance.sdk.openadsdk.core.video.a.c k;
    protected boolean l = false;
    protected DownLoadListenerImpl mDownLoadListener;

    public void setDownLoadListener(DownLoadListenerImpl var1) {
        this.mDownLoadListener = var1;
    }

    public void setTTFeedAd(TTFeedAd paramTTFeedAd) {
        /*  45 */
        this.mTTFeedAd = paramTTFeedAd;
    }

    public void b(boolean paramBoolean) {
        /*  49 */
        this.l = paramBoolean;
    }

    /*  52 */
    public void a(com.bytedance.sdk.openadsdk.core.video.a.c paramc) {
        this.k = paramc;
    }

    public AdClickListenerImpl(@NonNull Context paramContext, @NonNull NativeAdData paramh, @NonNull String paramString, int paramInt) {
        /*  56 */
        this.mContext = paramContext.getApplicationContext();
        /*  57 */
        this.mAdData = paramh;
        /*  58 */
        this.d = paramString;
        /*  59 */
        this.e = paramInt;
    }

    public void setOnClickLister(OnClick parama) {
        /*  63 */
        this.mOnClick = parama;
    }

    public void a(View paramView) {
        /*  67 */
        this.mWeakReference = new WeakReference(paramView);
    }

    public void b(View paramView) {
        /*  71 */
        this.mWeakReference = new WeakReference(paramView);
    }

    public void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        /*  76 */
        if (this.mContext == null) {
            /*  77 */
            return;
        }

        /*  80 */
        this.h = a(paramInt1, paramInt2, paramInt3, paramInt4, this.mQ, this.mR, this.mWeakReference == null ? null :
                /*  81 */       (View) this.mWeakReference.get(), this.mReference == null ? null : (View) this.mReference.get());

        /*  83 */
        if (this.mOnClick != null) {
            /*  84 */
            this.mOnClick.onClick(paramView, -1);
        }
///*  86 */     boolean bool = aa.OnClick(this.bee, this.cc, this.TTBannerAdImpl, this.LogUtils, this.mTTFeedAd, mR.OnClick(this.TTBannerAdImpl));
        /*  87 */
        AdEvent.a(this.mContext, "click", this.mAdData, this.h, this.d, true);
    }


    protected com.bytedance.sdk.openadsdk.core.nibuguan.c a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, long paramLong2, View paramView1, View paramView2) {
///*  95 */           return (new com.bytedance.sdk.openadsdk.core.nibuguan.cc.asss()).LocationUtils(var1).cc(var2).bee(var3).asss(var4).bee(var5).asss(var7).bee(ViewWather.asss(var9)).asss(ViewWather.asss(var10)).cc(ViewWather.bee(var9)).LocationUtils(ViewWather.bee(var10)).asss();
        //
        return (new c.Builder()).d(paramInt1).c(paramInt2).b(paramInt3).a(paramInt4).b(paramLong1).a(paramLong2).b(ViewWather.getLocationOnScreen(paramView1)).a(ViewWather.getLocationOnScreen(paramView2)).c(ViewWather.getViewSize(paramView1)).d(ViewWather.getViewSize(paramView2)).a();
    }

    public interface OnClick {
        void onClick(View paramView, int paramInt);
    }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\SslHepler\result.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */