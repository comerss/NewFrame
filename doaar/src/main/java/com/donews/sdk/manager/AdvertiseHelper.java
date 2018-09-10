package com.donews.sdk.manager;

import android.support.annotation.NonNull;

import com.donews.sdk.baidu.BaiduHelper;
import com.donews.sdk.gtong.TongHelper;
import com.donews.sdk.interfaces.AdvertiseTask;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.inveno.InvenoHelper;
import com.donews.sdk.toutiao.ToutiaoHelper;
import com.donews.sdk.zhike.ZhiKeHelper;


/**
 * Created by 79653 on 2018/6/27.
 * 描述：
 */
public enum AdvertiseHelper {
    INSTANCE;
    private AdvertiseTask mAdvertiseTask;

    private AdvertiseHelper create(AdvertiseType advertiseType, DoSlot doSlot) {
        if (advertiseType == AdvertiseType.DEFAULT) {

        } else if (advertiseType == AdvertiseType.BAI_DU) {
            BaiduHelper.getInstance().init(doSlot.getApplication(), doSlot.getAppID());
            mAdvertiseTask = BaiduHelper.getInstance();
        } else if (advertiseType == AdvertiseType.GOOGLE) {

        } else if (advertiseType == AdvertiseType.TOU_TIAO) {
            ToutiaoHelper.getInstance().init(doSlot.getApplication(), doSlot.getAppID(), doSlot.getAppName());
            mAdvertiseTask = ToutiaoHelper.getInstance();
        } else if (advertiseType == AdvertiseType.INVENO) {
            mAdvertiseTask = InvenoHelper.getInstance();
        } else if (advertiseType == AdvertiseType.GUANG_DIAN_TONG) {
            mAdvertiseTask = TongHelper.getInstance();
        } else if (advertiseType == AdvertiseType.ZHI_KE) {
            mAdvertiseTask = ZhiKeHelper.getInstance();

        } else {
            mAdvertiseTask = ToutiaoHelper.getInstance();
        }
        return this;
    }

    public void loadSplash(AdvertiseType type, @NonNull DoSlot slot, InterfaceManager.OnSplashListener listener) {
        create(type, slot);
        if (mAdvertiseTask != null) {
            mAdvertiseTask.loadSplash(slot, listener);
        }
    }

    public void loadFeed(AdvertiseType type, @NonNull DoSlot slot, InterfaceManager.OnFeedListener listener) {
        create(type, slot);
        if (mAdvertiseTask != null) {
            mAdvertiseTask.loadFeed(slot, listener);
        }
    }
}
