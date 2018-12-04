package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.a.AdClickListenerImpl;
import com.bytedance.sdk.openadsdk.core.a.AdClickListerReal;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;
import com.bytedance.sdk.openadsdk.ggg.ToolUtils;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class FeedAdManager {
    private NativeAdData mAdData;
    private DownLoadListenerImpl mDownLoadListener;
    private TTAppDownloadListenerImpl mDownloadListener;
    protected Context mContext;
    private TTFeedAd mTTFeedAd;

    FeedAdManager(Context paramContext, TTFeedAd paramTTFeedAd, NativeAdData paramh) {
        /*  42 */
        this.mTTFeedAd = paramTTFeedAd;
        /*  43 */
        this.mAdData = paramh;
        /*  44 */
        this.mContext = paramContext;

        /*  46 */
        if (this.mAdData.c() == 4) {
            /*  47 */
            this.mDownloadListener = new TTAppDownloadListenerImpl();
            /*  48 */
            this.mDownLoadListener = new DownLoadListenerImpl(this.mContext, this.mAdData, "embeded_ad");

            /*  50 */
            this.mDownLoadListener.a(new com.bytedance.sdk.openadsdk.core.a.c(this.mContext, this.mAdData, "embeded_ad"));
        }
    }

    void a(@NonNull Activity paramActivity) {
        /*  55 */
        if (this.mDownLoadListener != null) {
            /*  56 */
            this.mDownLoadListener.a(paramActivity);
        }
    }

    DownLoadListenerImpl getDownloadListener() {
        /*  61 */
        return this.mDownLoadListener;
    }

    void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, List<View> paramList1, @Nullable List<View> paramList2, final TTFeedAd.AdInteractionListener paramAdInteractionListener) {
        /*  66 */
        if (this.mDownLoadListener != null) {
            /*  67 */
            this.mDownLoadListener.e();
        }
        /*  69 */
        AdEvent.addEventData(this.mAdData);
        /*  70 */
        SplashManager splashManager = getSplashManager(paramViewGroup);
        /*  71 */
        if (splashManager == null) {
            /*  72 */
            splashManager = new SplashManager(this.mContext, paramViewGroup);
            /*  73 */
            paramViewGroup.addView(splashManager);
        }
        /*  75 */
        splashManager.noClick();
        /*  76 */
        splashManager.setRefClickViews(paramList1);
        /*  77 */
        splashManager.setRefCreativeViews(paramList2);


        /*  80 */
        AdClickListenerImpl adClickListener = new AdClickListenerImpl(this.mContext, this.mAdData, "embeded_ad", 1);
        /*  81 */
        adClickListener.setView(paramViewGroup);
        /*  82 */
        adClickListener.setTTFeedAd(this.mTTFeedAd);
        /*  83 */
        adClickListener.setOnClickLister(new AdClickListenerImpl.OnClick() {
            public void onClick(View paramAnonymousView, int paramAnonymousInt) {
                /*  86 */
                if (paramAdInteractionListener != null) {
                    /*  87 */
                    paramAdInteractionListener.onAdClicked(paramAnonymousView, mTTFeedAd);
                }

            }

            /*  92 */
        });
        /*  93 */
        AdClickListerReal locala = new AdClickListerReal(this.mContext, this.mAdData, "embeded_ad", 1);
        /*  94 */
        locala.setView(paramViewGroup);
        /*  95 */
        locala.setDownLoadListener(this.mDownLoadListener);
        /*  96 */
        locala.setOnClickLister(new AdClickListenerImpl.OnClick() {
            public void onClick(View paramAnonymousView, int paramAnonymousInt) {
                /*  99 */
                if (paramAdInteractionListener != null) {
                    /* 100 */
                    paramAdInteractionListener.onAdCreativeClick(paramAnonymousView, mTTFeedAd);
                }

            }
            /* 104 */
        });
        /* 105 */
        splashManager.onClick(paramList1, adClickListener);
        /* 106 */
        splashManager.onClick(paramList2, locala);

        /* 108 */
        splashManager.setCallback(new SplashManager.SplashListener() {
            public void onWindowFocusChanged(boolean paramAnonymousBoolean) {
                /* 111 */
                if (mDownLoadListener != null) {
                    /* 112 */
                    if (paramAnonymousBoolean) {
                        /* 113 */
                        mDownLoadListener.e();
                    } else {
                        /* 115 */
                        mDownLoadListener.f();
                    }
                }
            }


            public void onAttachedToWindow() {
            }


            public void onDetachedFromWindow() {
            }


            public void onShow(View paramAnonymousView) {

                AdEvent.show(mContext, mAdData, "embeded_ad");
                if (paramAdInteractionListener != null) {
                    paramAdInteractionListener.onAdShow(mTTFeedAd);
                }
                if (mAdData.t()) {
                    ToolUtils.a(mAdData, paramAnonymousView);
                }
            }
        });
        splashManager.setNeedCheckingShow(true);
    }

    private SplashManager getSplashManager(ViewGroup paramViewGroup) {
        for (int i = 0; i < paramViewGroup.getChildCount(); i++) {
            View localView = paramViewGroup.getChildAt(i);
            if ((localView instanceof SplashManager)) {
                return (SplashManager) localView;
            }
        }
        return null;
    }

    void a(TTAppDownloadListener paramTTAppDownloadListener) {
        if (this.mDownLoadListener != null) {
            if (this.mDownloadListener == null) {
                this.mDownloadListener = new TTAppDownloadListenerImpl();
            }
            this.mDownloadListener.a(paramTTAppDownloadListener);
            this.mDownLoadListener.a(paramTTAppDownloadListener);
        }
    }

    private class TTAppDownloadListenerImpl implements TTAppDownloadListener {
        private TTAppDownloadListenerImpl() {
        }

        private List<WeakReference<TTAppDownloadListener>> b = new LinkedList();

        void a(TTAppDownloadListener paramTTAppDownloadListener) {
            this.b.add(new WeakReference(paramTTAppDownloadListener));
        }

        public void onIdle() {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener) localWeakReference.get();
                if (localTTAppDownloadListener == null) {
                    localIterator.remove();
                } else {
                    localTTAppDownloadListener.onIdle();
                }
            }
        }

        public void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2) {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener) localWeakReference.get();
                if (localTTAppDownloadListener == null) {
                    localIterator.remove();
                } else {
                    localTTAppDownloadListener.onDownloadActive(paramLong1, paramLong2, paramString1, paramString2);
                }
            }
        }

        public void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2) {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener) localWeakReference.get();
                if (localTTAppDownloadListener == null) {
                    localIterator.remove();
                } else {
                    localTTAppDownloadListener.onDownloadPaused(paramLong1, paramLong2, paramString1, paramString2);
                }
            }
        }

        public void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2) {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener) localWeakReference.get();
                if (localTTAppDownloadListener == null) {
                    localIterator.remove();
                } else {
                    localTTAppDownloadListener.onDownloadFailed(paramLong1, paramLong2, paramString1, paramString2);
                }
            }
        }

        public void onInstalled(String paramString1, String paramString2) {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                if (localWeakReference.get() == null) {
                    localIterator.remove();
                } else {
                    ((TTAppDownloadListener) localWeakReference.get()).onInstalled(paramString1, paramString2);
                }
            }
        }

        public void onDownloadFinished(long paramLong, String paramString1, String paramString2) {
            Iterator localIterator = this.b.iterator();
            while (localIterator.hasNext()) {
                WeakReference localWeakReference = (WeakReference) localIterator.next();
                TTAppDownloadListener localTTAppDownloadListener = (TTAppDownloadListener) localWeakReference.get();
                if (localTTAppDownloadListener == null) {
                    localIterator.remove();
                } else {
                    localTTAppDownloadListener.onDownloadFinished(paramLong, paramString1, paramString2);
                }
            }
        }
    }
}
