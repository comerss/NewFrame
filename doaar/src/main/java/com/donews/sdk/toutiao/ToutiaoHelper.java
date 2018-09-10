package com.donews.sdk.toutiao;

import android.content.Context;
import android.text.TextUtils;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.donews.sdk.base.LogUtils;
import com.donews.sdk.interfaces.AdvertiseTask;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.manager.ConvertHelper;
import com.donews.sdk.manager.DoSlot;
import com.donews.sdk.manager.DonewsAgent;
import com.donews.sdk.manager.EventNameManager;

import java.util.List;

/*
 * 头条广告管理类
 * */
public final class ToutiaoHelper implements AdvertiseTask {
    private ToutiaoHelper() {
    }

    private static ToutiaoHelper mSingleton;
    private TTAdManager mAdManager;
    private AdSlot mAdSlot;
    private String appKey = "";

    public static ToutiaoHelper getInstance() {
        if (mSingleton == null)
            synchronized (ToutiaoHelper.class) {
                if (mSingleton == null) {
                    mSingleton = new ToutiaoHelper();
                }
            }
        return mSingleton;
    }

    //建议使用全局的初始化context
    public void init(Context context, String appId, String appName) {
        if (TextUtils.isEmpty(appId) || TextUtils.isEmpty(appName)) {
            LogUtils.i("info", "appKey or appName can't be null ");
            return;
        }
        if (mAdManager == null) {//防止多次初始化
            mAdManager = TTAdManagerFactory.getInstance(context)
                    .setAppId(appId)//申请到的应用ID
                    .setName(appName)
                    .setTitleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
                    .setAllowShowNotifiFromSDK(true)
                    .setAllowLandingPageShowWhenScreenLock(true)
                    .setDirectDownloadNetworkType(TTAdConstant.NETWORK_STATE_WIFI, TTAdConstant.NETWORK_STATE_3G);
            mAdManager.requestPermissionIfNecessary(context);
        }
    }

    @Override
    public void loadSplash(final DoSlot slot, final InterfaceManager.OnSplashListener onSplashListener) {
//        ObjectHelper.requireNonNull(mAdManager,"SDK is not initialized or init failed, please init in your application first");
        if (mAdManager == null) {
            LogUtils.i("init", "SDK 初始化失败 无法获取广告素材");
            return;
        }
        mAdSlot = new AdSlot.Builder().
                setCodeId(slot.getAdvertiseId())
                .setSupportDeepLink(slot.isSupportDeepLink())
                .setImageAcceptedSize(slot.getWidth(), slot.getHeight())
                .setOrientation(slot.getOrientation())
                .build();
        mAdManager.createAdNative(slot.getContext()).loadSplashAd(mAdSlot, new TTAdNative.SplashAdListener() {
            @Override
            public void onError(int i, String s) {
                if (onSplashListener != null) {
                    onSplashListener.onError(i, s);
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(), slot.getAdvertiseId()) + "_Code" + i, slot.getAdvertiseId());
            }

            @Override
            public void onTimeout() {
                if (onSplashListener != null) {
                    onSplashListener.onTimeOut();
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.timeOut(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
            }

            @Override
            public void onSplashAdLoad(TTSplashAd ttSplashAd) {
                if (onSplashListener != null) {
                    onSplashListener.onLoadSplash(ConvertHelper.convert(slot, ttSplashAd));
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
            }
        });

    }

    @Override
    public void loadFeed(final DoSlot slot, final InterfaceManager.OnFeedListener onFeedListener) {
//        ObjectHelper.requireNonNull(mAdManager,"SDK is not initialized, please init in your application first");
        if (mAdManager == null) {
            LogUtils.i("init", "SDK 初始化失败 无法获取广告素材");
            return;
        }
        mAdSlot = new AdSlot.Builder().
                setCodeId(slot.getAdvertiseId())
                .setSupportDeepLink(slot.isSupportDeepLink())
                .setAdCount(slot.getAdCount())
                .setImageAcceptedSize(slot.getWidth(), slot.getHeight())
                .setOrientation(slot.getOrientation())
                .build();
        mAdManager.createAdNative(slot.getContext())
                .loadFeedAd(mAdSlot, new TTAdNative.FeedAdListener() {
                    @Override
                    public void onError(int i, String s) {
                        if (onFeedListener != null) {
                            onFeedListener.onError(i, s);
                        }
                        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID() + "_Code" + i, slot.getAdvertiseId()), slot.getAdvertiseId());
                    }

                    @Override
                    public void onFeedAdLoad(List<TTFeedAd> list) {
                        if (onFeedListener != null) {
                            if (list != null && list.size() > 0) {
                                onFeedListener.onLoadFeed(ConvertHelper.converts(slot, list));
                            }
                        }
                        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                    }
                })
        ;
    }
}