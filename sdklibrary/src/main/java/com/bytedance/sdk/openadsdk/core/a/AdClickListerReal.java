/*     */ package com.bytedance.sdk.openadsdk.core.a;
/*     */ 
/*     */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.nibuguan.NativeAdData;
import com.bytedance.sdk.openadsdk.dddd.AdEvent;

/*     */
/*     */
/*     */
/*     */
/*     */
public class AdClickListerReal extends AdClickListenerImpl {
    private boolean a = true;

    public AdClickListerReal(@NonNull Context var1, @NonNull NativeAdData var2, @NonNull String var3, int var4) {
        super(var1, var2, var3, var4);
    }

    public void a(boolean var1) {
        this.a = var1;
    }

    public void b(View var1, int var2, int var3, int var4, int var5) {
        if (this.mContext != null) {
//            this.ImageHelper = this.OnClick(var2, var3, var4, var5, this.mR, this.ViewWather, this.HandleInitEvent == null ? null : (View)this.HandleInitEvent.get(), this.ApiException == null ? null : (View)this.ApiException.get());
            int var6 = this.mAdData.c();
            switch(var6) {
                case 2:
                case 3:
                    if (this.mAdData.p() == 5) {
                        AdEvent.a(this.mContext, "click_button", this.mAdData, this.h, this.d, true);
                    }

                    aa.a(true);
//                    boolean var9 = aa.OnClick(this.bee, this.VideoManager, this.TTBannerAdImpl, this.LogUtils, this.mTTFeedAd, mR.OnClick(this.TTBannerAdImpl), this.mM);
                    if (this.a) {
                        AdEvent.a(this.mContext, "click", this.mAdData, this.h, this.d, true);
                    }
                    break;
                case 4:
                    if (this.mDownLoadListener != null) {
                        this.mDownLoadListener.c();
                        if (this.a && this.mDownLoadListener.a()) {
                            AdEvent.a(this.mContext, "click", this.mAdData, this.h, this.d, true);
                        }
                    }
                    break;
                case 5:
                    String var7 = this.a(this.d);
//                    if (!mQ.OnClick(var7)) {
                        AdEvent.a(this.mContext, "click_call", this.mAdData, this.h, var7, true);
//                    }

//                    boolean var8 = mR.TTBannerAdImpl(var1.getContext(), this.VideoManager.ApiException());
//                    com.bytedance.sdk.openadsdk.dddd.VideoManager.OnClick(this.bee, "click", this.VideoManager, this.ImageHelper, this.LocationUtils, var8);
                    break;
                default:
                    var6 = -1;
            }

            if (this.mOnClick != null) {
                this.mOnClick.onClick(var1, var6);
            }

        }
    }

    private String a(String var1) {
        byte var3 = -1;
        switch(var1.hashCode()) {
            case -1695837674:
                if (var1.equals("banner_ad")) {
                    var3 = 1;
                }
                break;
            case -712491894:
                if (var1.equals("embeded_ad")) {
                    var3 = 0;
                }
                break;
            case 174971131:
                if (var1.equals("splash_ad")) {
                    var3 = 4;
                }
                break;
            case 1844104722:
                if (var1.equals("interaction")) {
                    var3 = 3;
                }
                break;
            case 2091589896:
                if (var1.equals("slide_banner_ad")) {
                    var3 = 2;
                }
        }

        switch(var3) {
            case 0:
                return "feed_call";
            case 1:
                return "banner_call";
            case 2:
                return "banner_call";
            case 3:
                return "interaction_call";
            case 4:
                return "splash_ad";
            default:
                return "";
        }
    }
}