package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;

import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.b.TTAdDislikeImpl;

import com.bytedance.sdk.openadsdk.ccccc.DownLoadListenerImpl;
import com.bytedance.sdk.openadsdk.core.nibuguan.g;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.core.video.a.ADViewLayout;
import com.bytedance.sdk.openadsdk.ggg.o;

import java.util.ArrayList;
import java.util.List;


class TTFeedAdImpl implements TTFeedAd {
    private final FeedAdManager b;
    private final NativeAdData mAdData;
    protected Context mContext;
    private TTAdDislike mAdDislike;
    private DownloadStatusController mStatusController;
    private ADViewLayout mViewLayout;

    TTFeedAdImpl(@NonNull Context paramContext, @NonNull NativeAdData paramh) {
        /*  40 */
        o.a(paramh, "materialMeta不能为null");
        /*  41 */
        this.mAdData = paramh;
        /*  42 */
        this.mContext = paramContext;
        /*  43 */
        this.b = new FeedAdManager(this.mContext, this, paramh);
        /*  44 */
        if (getImageMode() == 5) {
            /*  46 */
            this.mViewLayout = new ADViewLayout(paramContext, paramh);
        }
    }

    public void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, TTFeedAd.AdInteractionListener paramAdInteractionListener) {
        /*  52 */
        o.a(paramViewGroup, "container不能为null");
        /*  53 */
        o.a(paramView, "clickView不能为null");

        /*  55 */
        ArrayList localArrayList = new ArrayList(1);
        /*  56 */
        localArrayList.add(paramView);
        /*  57 */
        registerViewForInteraction(paramViewGroup, localArrayList, null, paramAdInteractionListener);
    }

    public void registerViewForInteraction(@NonNull ViewGroup paramViewGroup, @NonNull List<View> paramList1, @Nullable List<View> paramList2, TTFeedAd.AdInteractionListener paramAdInteractionListener) {
        /*  62 */
        o.a(paramViewGroup, "container不能为null");
        /*  63 */
        o.a(paramList1, "clickView不能为null");
        /*  64 */
        o.a(paramList1.size() > 0, "clickViews数量必须大于等于1");

        /*  66 */
        this.b.registerViewForInteraction(paramViewGroup, paramList1, paramList2, paramAdInteractionListener);
    }

    public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
        /*  71 */
        o.a(paramTTAppDownloadListener, "downloadListener不能为null");
        /*  72 */
        this.b.a(paramTTAppDownloadListener);
    }


    public String getTitle() {
        /*  78 */
        return this.mAdData.j();
    }

    public String getDescription() {
        /*  83 */
        return this.mAdData.k();
    }

    public String getSource() {
        /*  88 */
        return this.mAdData.b();
    }

    public TTImage getIcon() {
        /*  93 */
        return this.mAdData.d() == null ? null : g.a(this.mAdData.d());
    }

    public List<TTImage> getImageList() {
        /*  98 */
        ArrayList localArrayList = new ArrayList();
        /*  99 */
        if ((this.mAdData.f() != null) && (!this.mAdData.f().isEmpty())) {
            /* 100 */
            for (g localg : this.mAdData.f()) {
                /* 101 */
                localArrayList.add(g.a(localg));
            }
        }
        /* 104 */
        return localArrayList;
    }

    public int getInteractionType() {
        /* 109 */
        if (this.mAdData == null) {
            /* 110 */
            return -1;
        }
        /* 112 */
        return this.mAdData.c();
    }

    public int getImageMode() {
        /* 117 */
        if (this.mAdData == null) {
            /* 118 */
            return -1;
        }
        /* 120 */
        return this.mAdData.p();
    }

    public TTAdDislike getDislikeDialog() {
        /* 124 */
        if (this.mAdDislike == null) {
            /* 125 */
            a();
        }
        /* 127 */
        return this.mAdDislike;
    }

    public View getAdView(boolean paramBoolean1, boolean paramBoolean2) {
        /* 132 */
        if (this.mViewLayout != null) {
            /* 133 */
            this.mViewLayout.setIsAutoPlay(paramBoolean1);
            /* 134 */
            this.mViewLayout.setIsQuiet(paramBoolean2);
        }
        /* 136 */
        if ((getImageMode() != 5) || (this.mViewLayout == null) || (!this.mViewLayout.a(0L))) {
            /* 137 */
            return null;
        }
        /* 139 */
        return this.mViewLayout;
    }

    public View getAdView() {
        /* 144 */
        if ((getImageMode() != 5) || (this.mViewLayout == null) || (!this.mViewLayout.a(0L))) {
            /* 145 */
            return null;
        }
        /* 147 */
        return this.mViewLayout;
    }

    public DownloadStatusController getDownloadStatusController() {
        /* 152 */
        if ((this.mStatusController == null) && (this.b != null)) {
            /* 153 */
            final DownLoadListenerImpl localx = this.b.a();
            /* 154 */
            if (localx != null) {
                /* 155 */
                this.mStatusController = new DownloadStatusController() {
                    public void changeDownloadStatus() {
                        /* 158 */
                        if (localx != null) {
                            /* 159 */
                            localx.b();
                        }
                    }

                    public void cancelDownload() {
                        /* 165 */
                        if (localx != null) {
                            /* 166 */
                            localx.g();
                        }
                    }
                };
            }
        }
        /* 172 */
        return this.mStatusController;
    }

    public void setActivityForDownloadApp(@NonNull Activity paramActivity) {
        /* 177 */
        if ((paramActivity != null) && ((paramActivity instanceof Activity))) {
            /* 178 */
            this.b.a(paramActivity);
        }
    }


    private void a() {
        /* 186 */
        if ((this.mContext instanceof Activity)) {
            /* 187 */
            this.mAdDislike = new TTAdDislikeImpl(this.mContext, this.mAdData);
        }
    }
}


/* Location:              C:\Users\79653\Desktop\back\open_ad_sdk\classes.jar!\com\bytedance\sdk\openadsdk\core\TTFeedAdImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */