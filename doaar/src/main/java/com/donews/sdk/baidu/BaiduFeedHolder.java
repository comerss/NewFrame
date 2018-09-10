package com.donews.sdk.baidu;

import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.manager.ConvertHelper;
import com.donews.sdk.manager.DoSlot;
import com.donews.sdk.manager.DonewsAgent;
import com.donews.sdk.manager.EventNameManager;

import java.util.List;

/**
 * Created by 79653 on 2018/6/21.
 * 描述：
 */
public class BaiduFeedHolder {
    public void init(final DoSlot slot, final InterfaceManager.OnFeedListener onFeedListener) {
        BaiduNative baiduNative = new BaiduNative(slot.getContext(), slot.getAdvertiseId(), new BaiduNative.BaiduNativeNetworkListener() {
            @Override
            public void onNativeLoad(List<NativeResponse> list) {
                if (list != null && list.size() > 0) {
                    if (onFeedListener != null) {
                        onFeedListener.onLoadFeed(ConvertHelper.convertTolists(slot, list));
                    }
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

            }

            @Override
            public void onNativeFail(NativeErrorCode nativeErrorCode) {
                if (onFeedListener != null) {
                    onFeedListener.onError(103, nativeErrorCode + "");
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(), slot.getAdvertiseId()) + "_Code" + nativeErrorCode.name(), slot.getAdvertiseId());
            }
        });
        RequestParameters parameters = new RequestParameters.Builder()
                .downloadAppConfirmPolicy(RequestParameters.DOWNLOAD_APP_CONFIRM_ONLY_MOBILE)
                .build();
        baiduNative.makeRequest(parameters);
    }
}
