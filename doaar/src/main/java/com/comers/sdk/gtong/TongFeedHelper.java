package com.comers.sdk.gtong;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

import com.comers.sdk.bean.ImageInfo;
import com.comers.sdk.interfaces.AdvertiseFeed;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.manager.ConvertHelper;
import com.comers.sdk.manager.DoSlot;
import com.comers.sdk.manager.DonewsAgent;
import com.comers.sdk.manager.EventManager;
import com.comers.sdk.manager.EventNameManager;
import com.qq.e.ads.cfg.BrowserType;
import com.qq.e.ads.nativ.NativeAD;
import com.qq.e.ads.nativ.NativeADDataRef;
import com.qq.e.comm.util.AdError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79653 on 2018/6/28.
 * 描述：广点通信息流广告
 */
public class TongFeedHelper {
    DoSlot slot;
    public TongFeedHelper(final DoSlot slot, final InterfaceManager.OnFeedListener listener) {
        this.slot =slot;
        NativeAD nativeAD = new NativeAD(slot.getContext(), slot.getAppID(), slot.getAdvertiseId(), new NativeAD.NativeAdListener() {
            @Override
            public void onADLoaded(List<NativeADDataRef> list) {
                List<AdvertiseFeed> result=new ArrayList<>();
                if (list != null && list.size() > 0) {
                    for(int i=0;i<list.size();i++){
                        result.add(convert(list.get(i)));
                    }
                    listener.onLoadFeed(result);
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.success(slot.getAppID(),slot.getAdvertiseId()),slot.getAdvertiseId());

            }

            @Override
            public void onNoAD(AdError adError) {
                listener.onError(adError.getErrorCode(), adError.getErrorMsg());
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(),slot.getAdvertiseId())+"_Code"+adError.getErrorCode(),slot.getAdvertiseId());
            }

            @Override
            public void onADStatusChanged(NativeADDataRef nativeADDataRef) {

            }

            @Override
            public void onADError(NativeADDataRef nativeADDataRef, AdError adError) {
                listener.onError(adError.getErrorCode(), adError.getErrorMsg());
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(),slot.getAdvertiseId())+"_Code"+adError.getErrorCode(),slot.getAdvertiseId());
            }
        });
        nativeAD.setBrowserType(BrowserType.Default);
        nativeAD.loadAD(slot.getAdCount());
    }

    private AdvertiseFeed convert(final NativeADDataRef contentData) {

        return new AdvertiseFeed() {
            @Override
            public String getTitle() {
                return contentData.getTitle();
            }

            @Override
            public String getDescription() {
                return contentData.getDesc();
            }

            @Override
            public String getSource() {
                return "";
            }

            @Override
            public ImageInfo getIcon() {
                return new ImageInfo(0,0,contentData.getIconUrl());
            }

            @Override
            public List<ImageInfo> getImageList() {
                if(!TextUtils.isEmpty(contentData.getImgUrl())){
                    List<String> list=new ArrayList<>();
                    list.add(contentData.getImgUrl() );
                    return ConvertHelper.convert(list);
                }
                return ConvertHelper.convert(contentData.getImgList());
            }

            @Override
            public int getInteractionType() {
                return 0;
            }

            @Override  //3 大图 2小图 4组图 5视频 其它：未知类型
            public int getImageMode() {
                if(!TextUtils.isEmpty(contentData.getImgUrl())){
                    return 3;
                }else if(contentData.getImgList()!=null&&contentData.getImgList().size()>=2){
                    return 4;
                }else{
                    return 2;
                }
            }

            @Override
            public void registerViewForInteraction(ViewGroup convertView, final View clickView, final AdvertiseInteractionListener listener) {
                if(listener!=null){
                    listener.onShow(clickView);
                }
                EventManager.show(slot.getNative());
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
                clickView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contentData.onClicked(clickView);
                        EventManager.click(slot.getNative());
                        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

                        if(listener!=null){
                            listener.onViewClicked(v);
                        }
                    }
                });
            }

            @Override
            public void registerViewForInteraction(ViewGroup convertView, final List<View> clickView, final AdvertiseInteractionListener listener) {
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.show(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

                if(clickView!=null&&clickView.size()>0){
                    for (int i = 0; i < clickView.size(); i++) {
                        final int finalI = i;
                        if(listener!=null){
                            listener.onShow(clickView.get(i));
                        }
                        clickView.get(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                contentData.onClicked(clickView.get(finalI));
                                if(listener!=null){
                                    listener.onViewClicked(v);
                                }
                            }
                        });
                    }
                }
            }


            @Override
            public void onShowAdvertise(View view) {
                contentData.onExposured(view);
            }
        };
    }


}
