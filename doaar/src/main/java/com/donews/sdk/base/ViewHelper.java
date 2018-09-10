package com.donews.sdk.base;


import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.view.View;

import java.lang.reflect.Method;


class ViewHelper {
    public static boolean isShown(View paramView, int paramInt) {
        if ((paramView == null) || (paramView.getVisibility() != View.VISIBLE) || (paramView.getParent() == null)) {
            return false;
        }
        Rect localRect = new Rect();
        if (!paramView.getGlobalVisibleRect(localRect)) {
            return false;
        }
        long l1 = localRect.height() * localRect.width();
        long l2 = paramView.getHeight() * paramView.getWidth();

        if (l2 <= 0L) {
            return false;
        }

        return 100L * l1 >= paramInt * l2;
    }


    public static boolean isScreenOn(Context paramContext) {

        PowerManager localPowerManager = (PowerManager) paramContext.getSystemService(Context.POWER_SERVICE);
        boolean bool = true;
        Method localMethod = null;
        try {
            localMethod = localPowerManager.getClass().getMethod("isScreenOn", new Class[0]);
            bool = ((Boolean) localMethod.invoke(localPowerManager, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return bool;
    }


    public static boolean isShown(View paramView) {

        if ((paramView != null) && (paramView.isShown())) {

            return true;
        }
        return false;
    }

    public static boolean isValid(View paramView, int paramInt) {

        int i = validRange(paramView, paramInt);

        int j = getVisibleHeight(paramView, paramInt);


        return (paramView.getWidth() > i) && (paramView.getHeight() > j);
    }


    public static int validRange(View paramView, int paramInt) {

        if (paramInt == 3) {

            return (int) (ViewWather.visibleWidth(paramView.getContext().getApplicationContext()) * 0.7D);
        }

        return 100;
    }


    public static int getVisibleHeight(View paramView, int paramInt) {

        if (paramInt == 3) {

            return ViewWather.visisbleHeight(paramView.getContext().getApplicationContext()) / 2;
        }

        return 100;
    }

    public static int checkCanShow(View paramView, int paramInt1, int paramInt2) {
        int i = 0;
        if (!isScreenOn(paramView.getContext())) {
            i = 4;
        } else if (!isShown(paramView)) {
            i = 1;
        } else if (!isValid(paramView, paramInt2)) {
            i = 6;
        } else if (!isShown(paramView, paramInt1)) {
            i = 3;
        }
        return i;
    }

    // paramInt1 -->  20  paramInt2  3 --> 70%
    public static boolean canShow(View paramView, int paramInt1, int paramInt2) {
        try {
            return 0 == checkCanShow(paramView, paramInt1, paramInt2);
        } catch (Exception localException) {
        }
        return false;
    }

}

