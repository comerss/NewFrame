package com.comers.sdk.gtong;

import android.widget.LinearLayout;

import com.comers.sdk.interfaces.AdvertiseSplash;
import com.comers.sdk.interfaces.InterfaceManager;
import com.comers.sdk.manager.AuthKeyManager;
import com.comers.sdk.manager.DoSlot;
import com.comers.sdk.manager.DonewsAgent;
import com.comers.sdk.manager.EventNameManager;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

/**
 * Created by 79653 on 2018/6/27.
 * 描述：
 */
public class TongSplashHolder {
    public  TongSplashHolder(DoSlot slot, LinearLayout linearLayout, InterfaceManager.OnSplashListener adListener){
        SplashAD splashAD = new SplashAD(slot.getContext(), linearLayout, AuthKeyManager.INSTANCE.getGuangDTKey(), slot.getAdvertiseId(), convert(slot,adListener), 5000);
    }
    private   AdvertiseSplash.AdvertiseInterationListener listener;
    public SplashADListener convert(final DoSlot slot, final InterfaceManager.OnSplashListener adListener) {
        final boolean[] click = {false};
        return new SplashADListener() {
            @Override
            public void onADDismissed() {
                if(click[0]){//广告的点击事件

                }else{//点击了跳过
                    if(listener!=null)
                        listener.onAdvertiseSkip();
                    click[0]=false;
                }
            }

            @Override
            public void onNoAD(AdError adError) {
                adListener.onError(adError.getErrorCode(),adError.getErrorMsg());
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(),slot.getAdvertiseId())+"_Code"+adError.getErrorCode(),slot.getAdvertiseId());
            }

            @Override
            public void onADPresent() {
                if(listener!=null){
                    listener.onAdvertiseShow(null,0);
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.error(slot.getAppID(),slot.getAdvertiseId()),slot.getAdvertiseId());
            }

            @Override
            public void onADClicked() {
                click[0] =true;
                if(listener!=null){
                    listener.onAdvertiseClicked(null,0);
                }
                DonewsAgent.onEvents(slot.getContext(), EventNameManager.INSTANCE.click(slot.getAppID(),slot.getAdvertiseId()),slot.getAdvertiseId());

            }

            @Override
            public void onADTick(long l) {
                if(l/1000==0L){
                    if(listener!=null){
                        listener.onAdvertiseTimeOver();
                    }
                }
            }
        };
    }

    public  void setListener(AdvertiseSplash.AdvertiseInterationListener listener) {
        this.listener = listener;
    }
}
