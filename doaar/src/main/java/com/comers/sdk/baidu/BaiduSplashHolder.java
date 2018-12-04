package com.comers.sdk.baidu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.comers.sdk.interfaces.AdvertiseSplash;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.manager.DoSlot;
import com.comers.sdk.manager.DonewsAgent;
import com.comers.sdk.manager.EventNameManager;


/**
 * Created by 79653 on 2018/6/20.
 * 描述：
 */
public class BaiduSplashHolder implements SplashAdListener {

    private LinearLayout mLinearLayout;
    private InterfaceManager.OnSplashListener mOnSplashListener;
    DoSlot slot;
    public SplashAd init(DoSlot doSlot, InterfaceManager.OnSplashListener onSplashListener) {
        this.slot =doSlot;
        mLinearLayout = new LinearLayout(doSlot.getContext());
        mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mOnSplashListener=onSplashListener;
        final SplashAd splashAd = new SplashAd(doSlot.getContext(), mLinearLayout, this, doSlot.getAdvertiseId(),true);
        return splashAd;
    }

    @Override
    public void onAdPresent() {
        if (mHolderInterface != null){
            mHolderInterface.onAdvertiseShow(mLinearLayout, 5);
        }
    }

    @Override
    public void onAdDismissed() {
        if(mHolderInterface!=null){
            mHolderInterface.onAdvertiseSkip();
        }
    }

    @Override
    public void onAdFailed(String s) {
        isSuccess=false;
        if (mOnSplashListener != null){
            mOnSplashListener.onError(103,s);
        }
        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());
    }

    @Override
    public void onAdClick() {
        if (mHolderInterface != null){
            mHolderInterface.onAdvertiseClicked(mLinearLayout, 1);
        }
        DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(), slot.getAdvertiseId()), slot.getAdvertiseId());

    }

    private AdvertiseSplash.AdvertiseInterationListener mHolderInterface;


    public void setHolderInterface(AdvertiseSplash.AdvertiseInterationListener holderInterface) {
        mHolderInterface = holderInterface;
    }
    public View getView(){
        return mLinearLayout;
    }
    private  boolean isSuccess=true;
    public  boolean isSuccess(){
        return isSuccess;
    }
}
