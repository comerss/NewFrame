package com.donews.sdk.gtong;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.donews.sdk.interfaces.AdvertiseSplash;
import com.donews.sdk.interfaces.AdvertiseTask;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.manager.AuthKeyManager;
import com.donews.sdk.manager.DoSlot;
import com.donews.sdk.manager.DonewsAgent;
import com.donews.sdk.manager.EventNameManager;

/**
 * Created by 79653 on 2018/6/27.
 * 描述：广点通的广告帮助类
 */
public final class TongHelper implements AdvertiseTask {
    private static TongHelper mSingleton;
    private String appKey="";
    private TongHelper(){}
    public static TongHelper getInstance() {
        if (mSingleton == null)
            synchronized (TongHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new TongHelper();
                }
            }
        return mSingleton;
    }

    @Override
    public void loadSplash(final DoSlot slot, InterfaceManager.OnSplashListener adListener) {
        if(TextUtils.isEmpty(AuthKeyManager.INSTANCE.getGuangDTKey())){
            return;
        }
        final LinearLayout linearLayout = new LinearLayout(slot.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        final TongSplashHolder holder = new TongSplashHolder(slot, linearLayout, adListener);
        adListener.onLoadSplash(new AdvertiseSplash() {
            @Override
            public View getSplashView() {
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(),slot.getAdvertiseId()),slot.getAdvertiseId());
                return linearLayout;
            }

            @Override
            public int getInteractionType() {
                return 0;
            }

            @Override
            public void setInteractionListener(AdvertiseInterationListener advertiseInterationListener) {
                holder.setListener(advertiseInterationListener);
            }
        });
    }

    @Override
    public void loadFeed(DoSlot slot, InterfaceManager.OnFeedListener listener) {
        TongFeedHelper helper = new TongFeedHelper(slot, listener);

    }
    public void init(Application application,String key){
        this.appKey=key;
    }
}
