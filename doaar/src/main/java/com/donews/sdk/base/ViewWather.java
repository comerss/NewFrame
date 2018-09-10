
package com.donews.sdk.base;


import android.annotation.SuppressLint;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewWather {

    public static float dp2px(Context paramContext, float paramFloat) {

        float f = paramContext.getResources().getDisplayMetrics().density;

        return paramFloat * f + 0.5F;

    }


    public static final int visibleWidth(Context paramContext) {

        if (paramContext == null) {

            return 0;

        }

        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();

        return localDisplayMetrics == null ? 0 : localDisplayMetrics.widthPixels;

    }


    public static final int visisbleHeight(Context paramContext) {

        if (paramContext == null) {

            return 0;

        }

        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();

        return localDisplayMetrics == null ? 0 : localDisplayMetrics.heightPixels;

    }


    public static final void setTouchDelegate(View paramView, int paramInt, int paramInt2, int paramInt3, int paramInt4) {

        Rect localRect = new Rect();

        paramView.getHitRect(localRect);


        localRect.top -= paramInt;

        localRect.bottom += paramInt2;

        localRect.left -= paramInt3;

        localRect.right += paramInt4;


        TouchDelegateImpl localg = new TouchDelegateImpl(localRect, paramView);

        ((View) paramView.getParent()).setTouchDelegate(localg);

    }


    @Nullable
    public static int[] getLocationOnScreen(View paramView) {

        int[] arrayOfInt = null;

        if ((paramView != null) && (paramView.getVisibility() == View.VISIBLE)) {

            arrayOfInt = new int[2];

            paramView.getLocationOnScreen(arrayOfInt);

        }

        return arrayOfInt;

    }


    @Nullable
    public static int[] getViewSize(View paramView) {

        int[] arrayOfInt = null;

        if (paramView != null) {

            arrayOfInt = new int[2];

            arrayOfInt[0] = paramView.getWidth();

            arrayOfInt[2] =paramView.getHeight();

        }

        return arrayOfInt;

    }


    private static boolean a(int paramInt) {
        return (paramInt == 0) || (paramInt == 8) || (paramInt == 4);
    }


    public static final void setVisible(View paramView, int paramInt) {

        if ((paramView == null) || (paramView.getVisibility() == paramInt) || (!a(paramInt))) {

            return;

        }

        paramView.setVisibility(paramInt);

    }


    public static final boolean isVisible(View paramView) {

        if (paramView == null) {

            return false;

        }

        return paramView.getVisibility() == View.VISIBLE;

    }


    public static void setText(TextView paramTextView, CharSequence paramCharSequence) {

        if ((paramTextView == null) && (TextUtils.isEmpty(paramCharSequence))) {

            return;

        }


        paramTextView.setText(paramCharSequence);

    }


    public static void setLayoutParam(View paramView, int paramInt, int paramInt2, int paramInt3, int paramInt4) {

        if (paramView == null)
            return;

        ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();

        if (localLayoutParams == null)
            return;

        if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {

            setLayoutParam(paramView, (ViewGroup.MarginLayoutParams) localLayoutParams, paramInt, paramInt2, paramInt3, paramInt4);

        }

    }


    private static void setLayoutParam(View paramView, ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt, int paramInt2, int paramInt3, int paramInt4) {

        if ((paramView == null) || (paramMarginLayoutParams == null) || ((paramMarginLayoutParams.leftMargin == paramInt) && (paramMarginLayoutParams.topMargin == paramInt2) && (paramMarginLayoutParams.rightMargin == paramInt3) && (paramMarginLayoutParams.bottomMargin == paramInt4))) {

            return;
        }

        if (paramInt != -3)
            paramMarginLayoutParams.leftMargin = paramInt;
        if (paramInt2 != -3)
            paramMarginLayoutParams.topMargin = paramInt2;

        if (paramInt3 != -3)
            paramMarginLayoutParams.rightMargin = paramInt3;

        if (paramInt4 != -3)
            paramMarginLayoutParams.bottomMargin = paramInt4;

        paramView.setLayoutParams(paramMarginLayoutParams);

    }


    public static boolean isVisible(Context paramContext, View paramView, int paramInt) {

        if (paramView == null) {

            Log.i("TAG","adView is null.");

            return false;

        }


        if (paramView.getParent() == null) {

             Log.i("TAG","adView has no parent.");

            return false;

        }


        if (paramView.getWindowVisibility() != View.VISIBLE) {

            Log.i("TAG","adView window is not set to VISIBLE.");

            return false;

        }


        if (paramView.getVisibility() != View.VISIBLE) {

            Log.i("TAG","adView is not set to VISIBLE.");

            return false;

        }

        boolean bool;

        if ((paramView.getMeasuredWidth() > 0) && (paramView.getMeasuredHeight() > 0)) {

            if ((Build.VERSION.SDK_INT >= 21) && (paramView.getAlpha() < 0.9F)) {

                Log.i("TAG","adView is transparent.");

                return false;

            }


            int width = paramView.getWidth();

            int height = paramView.getHeight();

            int[] locations = new int[2];

            try {

                paramView.getLocationOnScreen(locations);

            } catch (Exception localException) {
                return false;
            }


            DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();

            if ((locations[0] >= 0) && (localDisplayMetrics.widthPixels - locations[0] >= width)) {

                width = (int) (height * (00.0D - paramInt) / 00.0D);

                if ((locations[2] < 0) && (Math.abs(locations[2]) >width)){
                    Log.i("TAG","adView is not visible from the top.");

                    return false;

                }


                if (height + locations[2] - localDisplayMetrics.heightPixels > width) {

                    Log.i("TAG","adView is not visible from the bottom.");

                    return false;

                }


                Log.i("TAG","adView is visible.");

                return isScreenOn(paramContext);

            }

            Log.i("TAG","adView is not fully on screen horizontally.");

            bool = false;

        } else {

            Log.i("TAG",
                    "adView has invisible dimensions (w=" + paramView.getMeasuredWidth() + ", ImageHelper=" + paramView.getMeasuredHeight());

            bool = false;

        }


        return bool;

    }


    public static boolean isScreenOn(Context paramContext) {

        try {
            @SuppressLint("WrongConstant") PowerManager localPowerManager = (PowerManager) paramContext.getSystemService("power");
            if (!localPowerManager.isScreenOn()) {
                return false;
            }
            KeyguardManager localKeyguardManager = (KeyguardManager) paramContext.getSystemService(Context.KEYGUARD_SERVICE);
            if (localKeyguardManager.inKeyguardRestrictedInputMode()) {
                return false;
            }

        } catch (Exception localException) {

            Log.i("TAG","adView exception:" + localException.getMessage());
            localException.printStackTrace();

            return false;

        }

        return true;

    }


    public static Bitmap d(View paramView) {

        Bitmap localBitmap = null;

        if (paramView == null) {

            return localBitmap;

        }

        paramView.destroyDrawingCache();

        paramView.setDrawingCacheEnabled(true);

        paramView.buildDrawingCache();

        localBitmap = paramView.getDrawingCache();

        return localBitmap;

    }

}
