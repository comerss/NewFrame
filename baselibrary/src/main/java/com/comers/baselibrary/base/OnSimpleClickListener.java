package com.comers.baselibrary.base;

import android.view.View;

import java.util.Calendar;

/**
 * Created by Comers on 2017/9/20.
 * 去除重复的点击事件  默认300ms
 */

public abstract class OnSimpleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 300;
    private long lastClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onSimpleClick(v);
        }
    }
    protected abstract void onSimpleClick(View v);
}
