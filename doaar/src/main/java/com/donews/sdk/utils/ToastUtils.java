package com.donews.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by lq on 2017/5/24.
 * 作者：栗启
 * 作用：
 */

public class ToastUtils {
    public static void toast(Context context, String str) {
        Toast toast = Toast.makeText(context, str, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    private static Toast mToast;

    public static void showToast(Context context,String content) {
        if (mToast == null) {
            mToast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(content);
        }
        if (!TextUtils.isEmpty(content)) {
            mToast.show();
        }else{
            mToast.cancel();
        }
    }
   /* public static void showToastLong(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_LONG);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        if (!TextUtils.isEmpty(text)) {
            mToast.show();
        }
    }


    public static void showToastCenter(String text) {
        if (mToast == null) {
            mToast = Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(text);
        }
        if (!TextUtils.isEmpty(text)) {
            mToast.show();
        }
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static void showTimeToast( final long cnt,String text) {
        mToast = Toast.makeText(UIUtils.getContext(), text, Toast.LENGTH_LONG);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
*/
    /**
     * 如何按返回键想让Toast立即不显示，执行该方法
     */
    public static void onBackPressed() {
//        cancelToast();
    }
}
