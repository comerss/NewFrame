package com.comers.sdk.manager;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mobad.feeds.NativeResponse;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.comers.sdk.bean.ImageInfo;
import com.comers.sdk.interfaces.AdvertiseFeed;
import com.comers.sdk.interfaces.AdvertiseSplash;
import com.comers.sdk.interfaces.DownLoadListener;
import com.comers.sdk.interfaces.InterfaceManager;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public final class ConvertHelper {
    public static AdvertiseSplash convert(final DoSlot slot, final TTSplashAd splashAd) {
        AdvertiseSplash advertiseSplash = null;
        if (splashAd != null) {
            advertiseSplash = new AdvertiseSplash() {
                @Override
                public View getSplashView() {
                    return splashAd.getSplashView();
                }

                @Override
                public int getInteractionType() {
                    return splashAd.getInteractionType();
                }

                @Override
                public void setInteractionListener(final AdvertiseInterationListener listener) {
                    splashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() {
                        @Override
                        public void onAdClicked(View view, int i) {
                            if (listener != null) {
                                listener.onAdvertiseClicked(view, i);
                            }
                            EventManager.click(slot.getNative());
                            DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                        }

                        @Override
                        public void onAdShow(View view, int i) {
                            if (listener != null) {
                                listener.onAdvertiseShow(view, i);
                            }
                            DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                            EventManager.show(slot.getNative());
                        }

                        @Override
                        public void onAdSkip() {
                            if (listener != null) {
                                listener.onAdvertiseSkip();
                            }
                        }

                        @Override
                        public void onAdTimeOver() {
                            if (listener != null) {
                                listener.onAdvertiseTimeOver();
                            }
                        }
                    });
                }
            };
        }
        return advertiseSplash;
    }


    public static AdvertiseFeed convertTTFeedAd(final DoSlot slot, final TTFeedAd ttFeedAd) {
        AdvertiseFeed advertiseFeed = null;
        if (ttFeedAd != null) {
            advertiseFeed = new AdvertiseFeed() {
                @Override
                public String getTitle() {
                    if (slot.getContext() != null && !slot.getContext().isFinishing()) {
                        ttFeedAd.setActivityForDownloadApp(slot.getContext());
                    }
                    return ttFeedAd.getTitle();
                }

                @Override
                public String getDescription() {
                    return ttFeedAd.getDescription();
                }

                @Override
                public String getSource() {
                    return ttFeedAd.getSource();
                }

                @Override
                public ImageInfo getIcon() {
                    return new ImageInfo(ttFeedAd.getIcon().getHeight(), ttFeedAd.getIcon().getWidth(), ttFeedAd.getIcon().getImageUrl());
                }

                @Override
                public List<ImageInfo> getImageList() {
                    return convertToInfo(ttFeedAd.getImageList());
                }

                @Override
                public int getInteractionType() {
                    return ttFeedAd.getInteractionType();
                }

                @Override
                public int getImageMode() {
                    return ttFeedAd.getImageMode();
                }

                @Override
                public void registerViewForInteraction(ViewGroup var1, View var2, AdvertiseInteractionListener var3) {
                    ttFeedAd.registerViewForInteraction(var1, var2, convert(slot, var3));
                }

                @Override
                public void registerViewForInteraction(ViewGroup var1, List<View> var2, AdvertiseInteractionListener var4) {
                    if (ttFeedAd != null) {
                        ttFeedAd.registerViewForInteraction(var1, var2, new ArrayList<View>(), convert(slot, var4));
                    }
                }

                @Override
                public void onShowAdvertise(View viewGroup) {

                }
            };
        }
        return advertiseFeed;
    }

    private static TTAppDownloadListener convert(final DownLoadListener downLoadListener) {
        if (downLoadListener != null)
            return new TTAppDownloadListener() {
                @Override
                public void onIdle() {
                    downLoadListener.onIdle();
                }

                @Override
                public void onDownloadActive(long l, long l1, String s, String s1) {
                    downLoadListener.onDownloadActive(l, l1, s, s1);
                }

                @Override
                public void onDownloadPaused(long l, long l1, String s, String s1) {
                    downLoadListener.onDownloadPaused(l, l1, s, s1);
                }

                @Override
                public void onDownloadFailed(long l, long l1, String s, String s1) {
                    downLoadListener.onDownloadFailed(l, l1, s, s1);
                }

                @Override
                public void onDownloadFinished(long l, String s, String s1) {
                    downLoadListener.onDownloadFinished(l, s, s1);
                }

                @Override
                public void onInstalled(String s, String s1) {
                    downLoadListener.onInstalled(s, s1);
                }
            };
        return null;
    }

    private static List<ImageInfo> convertToInfo(List<TTImage> imageList) {
        List<ImageInfo> list = new ArrayList<>();
        if (imageList != null && imageList.size() > 0) {
            for (int i = 0; i < imageList.size(); i++) {
                list.add(new ImageInfo(imageList.get(i).getHeight(), imageList.get(i).getWidth(), imageList.get(i).getImageUrl()));
            }
        }
        return list;
    }

    public static TTFeedAd.AdInteractionListener convert(final DoSlot slot, final AdvertiseFeed.AdvertiseInteractionListener listener) {
        if (listener != null)
            return new TTFeedAd.AdInteractionListener() {
                @Override
                public void onAdClicked(View view, TTFeedAd ttFeedAd) {
                    if(listener!=null){
                        listener.onViewClicked(view);
                    }
                    DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                    EventManager.click(slot.getNative());
                }

                @Override
                public void onAdCreativeClick(View view, TTFeedAd ttFeedAd) {
//                    listener.onAdvertiseCreativeClick(view,convert(ttFeedAd));
                }

                @Override
                public void onAdShow(TTFeedAd ttFeedAd) {
                    if(listener!=null){
                        listener.onShow(null);
                    }
                    DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                    EventManager.show(slot.getNative());
                }
            };
        return null;
    }


    public static AdvertiseFeed convertNativeResponse(final DoSlot slot, final NativeResponse nativeResponse) {
        if (nativeResponse == null)
            return null;
        return new AdvertiseFeed() {
            @Override
            public String getTitle() {
                return nativeResponse.getTitle();
            }

            @Override
            public String getDescription() {
                return nativeResponse.getDesc();
            }

            @Override
            public String getSource() {
                return nativeResponse.getBrandName();
            }

            @Override
            public ImageInfo getIcon() {
                return convert(nativeResponse.getIconUrl());
            }

            @Override
            public List<ImageInfo> getImageList() {
                if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                    List<String> list = new ArrayList<>();
                    list.add(nativeResponse.getImageUrl());
                    return convert(list);
                }
                return convert(nativeResponse.getMultiPicUrls());
            }

            @Override
            public int getInteractionType() {
                return 0;
            }

            @Override
            public int getImageMode() {// //3 大图 2小图 4组图 5视频 其它：未知类型
                if (!TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                    return 3;
                } else if (nativeResponse.getMultiPicUrls() != null && nativeResponse.getMultiPicUrls().size() >= 2) {
                    return 4;
                } else {
                    return 2;
                }
            }

            @Override
            public void registerViewForInteraction(ViewGroup var1, View var2, final AdvertiseInteractionListener var3) {
                if (nativeResponse != null) {
                    if (var2 != null) {
                        var3.onShow(var2);
                        EventManager.show(slot.getNative());
                        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

                        var2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                nativeResponse.handleClick(v);
                                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                                EventManager.click(slot.getNative());
                                if (var3 != null) {
                                    var3.onViewClicked(v);
                                }
                            }
                        });
                    }
                }
            }

            @Override
            public void registerViewForInteraction(final ViewGroup var1, List<View> var2, final AdvertiseInteractionListener var4) {
                if (nativeResponse != null) {
                    if (var2 != null) {
                        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                        for (int i = 0; i < var2.size(); i++) {
                           if(var4!=null){
                               var4.onShow(var2.get(i));
                           }
                        }
                        for (int i = 0; i < var2.size(); i++) {
                            var2.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    nativeResponse.handleClick(v);
                                    DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                                    if (var4 != null) {
                                        var4.onViewClicked(v);
                                    }
                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onShowAdvertise(View viewGroup) {
                nativeResponse.recordImpression(viewGroup);
            }
        };
    }

    public static List<ImageInfo> convert(List<String> multiPicUrls) {
        List<ImageInfo> infos = new ArrayList<>();
        if (multiPicUrls != null && multiPicUrls.size() > 0) {
            for (int i = 0; i < multiPicUrls.size(); i++) {
                infos.add(convert(multiPicUrls.get(i)));
            }
        }
        return infos;
    }

    private static ImageInfo convert(String iconUrl) {
        return new ImageInfo(0, 0, iconUrl);
    }

    public static SplashADListener convert(final InterfaceManager.OnSplashListener adListener) {
        final boolean[] click = {false};
        final AdvertiseSplash.AdvertiseInterationListener listener = new AdvertiseSplash.AdvertiseInterationListener() {

            @Override
            public void onAdvertiseClicked(View view, int clickTime) {

            }

            @Override
            public void onAdvertiseShow(View view, int clickTime) {

            }

            @Override
            public void onAdvertiseSkip() {

            }

            @Override
            public void onAdvertiseTimeOver() {

            }
        };
        adListener.onLoadSplash(new AdvertiseSplash() {
            @Override
            public View getSplashView() {
                return null;
            }

            @Override
            public int getInteractionType() {
                return 0;
            }

            @Override
            public void setInteractionListener(AdvertiseInterationListener advertiseInterationListener) {

            }
        });
        return new SplashADListener() {
            @Override
            public void onADDismissed() {
                if (click[0]) {//广告的点击事件

                } else {//点击了跳过
                    listener.onAdvertiseSkip();
                }
            }

            @Override
            public void onNoAD(AdError adError) {
                adListener.onError(adError.getErrorCode(), adError.getErrorMsg());
            }

            @Override
            public void onADPresent() {
                listener.onAdvertiseShow(null, 0);
            }

            @Override
            public void onADClicked() {
                click[0] = true;
                listener.onAdvertiseClicked(null, 0);
            }

            @Override
            public void onADTick(long l) {
                if (l == 0L) {
                    listener.onAdvertiseTimeOver();
                }
            }
        };
    }

    public static List<AdvertiseFeed> convertTolists(DoSlot slot, List<NativeResponse> list) {
        List<AdvertiseFeed> list1 = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                list1.add(convertNativeResponse(slot, list.get(i)));
            }
        }
        return list1;
    }

    public static List<AdvertiseFeed> converts(DoSlot slot, List<TTFeedAd> list) {
        List<AdvertiseFeed> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            result.add(convertTTFeedAd(slot, list.get(i)));
        }
        return result;
    }
}