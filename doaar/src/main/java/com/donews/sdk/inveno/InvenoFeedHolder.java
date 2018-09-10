package com.donews.sdk.inveno;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.donews.sdk.bean.ImageInfo;
import com.donews.sdk.interfaces.AdvertiseFeed;
import com.donews.sdk.interfaces.InterfaceManager;
import com.donews.sdk.view.NativeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：处理信息流广告接口数据以及回调
 */
public class InvenoFeedHolder implements AdvertiseFeed {
    private InterfaceManager.OnFeedListener mOnFeedListener;
    private NativeData mNative;
    private Context mContext;
    InvenoEvent mInvenoEvent;
    public InvenoFeedHolder(Context context,  InterfaceManager.OnFeedListener splashListener, NativeData nativ) {
        mOnFeedListener = splashListener;
        mNative = nativ;
        mContext = context;
        mInvenoEvent=new InvenoEvent(context);
        List<AdvertiseFeed> feeds=new ArrayList<>();
        feeds.add(this);
        mOnFeedListener.onLoadFeed(feeds);
    }
    @Override
    public String getTitle() {
        return mNative.getTitle();
    }


    @Override
    public String getDescription() {
        return mNative.getDescription();
    }


    @Override
    public String getSource() {
        return mNative.getAd_from();
    }

    @Override
    public ImageInfo getIcon() {
        return new ImageInfo(mNative.getH(), mNative.getW(), mNative.getIcon());
    }

    @Override
    public List<ImageInfo> getImageList() {
        return mNative.getImgs();
    }

    @Override
    public int getInteractionType() {
        try {
            return Integer.valueOf(mNative.getInteraction_type()).intValue();
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int getImageMode() {
        return 0;
    }

    @Override
    public void registerViewForInteraction( ViewGroup var1,  View var2,  AdvertiseInteractionListener var3) {
        mInvenoEvent.onViewClick(var2,mNative,var3,this);
    }

    @Override
    public void registerViewForInteraction( ViewGroup var1,  List<View> var2,  AdvertiseInteractionListener var4) {
        //信息流回调的View设计点击事件
        if(var2!=null&&var2.size()>0){
            for (int i = 0; i < var2.size(); i++) {
                mInvenoEvent.onViewClick(var2.get(i),mNative,var4,this);
            }
        }
    }



    @Override
    public void onShowAdvertise(View viewGroup) {
        mInvenoEvent.onShow(viewGroup,mNative);
    }

}
