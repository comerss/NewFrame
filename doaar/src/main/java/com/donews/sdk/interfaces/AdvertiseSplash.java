package com.donews.sdk.interfaces;

import android.view.View;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public interface AdvertiseSplash {
    View getSplashView();

    int getInteractionType();

    void setInteractionListener(AdvertiseInterationListener advertiseInterationListener);

    interface AdvertiseInterationListener {
        void onAdvertiseClicked(View view, int time);

        void onAdvertiseShow(View view, int time);

        void onAdvertiseSkip();

        void onAdvertiseTimeOver();
    }
}