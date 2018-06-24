package com.comers.baselibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.InputType;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.comers.baselibrary.base.GlobalApplication;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by human on 2017/5/27.
 */
public class UIUtils {
    public static Context getContext() {
        return GlobalApplication.getContext();
    }

    /**
     * 从EditText获取文本
     */
    public static String getText(EditText editText) {
        String content = editText.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            return "";
        } else {
            return content;
        }
    }

    /**
     * 从TexztView获取输入文本
     */
    public static String getText(TextView view) {
        String content = view.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            return "";
        } else {
            return content;
        }
    }

    public static String getFixUrl(String url, Map<String, Object> map) {
        String json = "";
        for (String key : map.keySet()) {
            if (map.get(key) != null) {
                if (json.equals("")) {
                    if (null == map.get(key)) {
                        json = key + "=";
                    } else {
                        json = key + "=" + map.get(key);
                    }
                } else {
                    if (null == map.get(key)) {
                        json = json + "&" + key + "=";
                    } else {
                        json = json + "&" + key + "=" + map.get(key);
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(json)) {
            url = url + "?" + json;
        }
        return url;
    }

    /**
     * 关闭软键盘
     */
    public static void closeKeybord(EditText mEditText, Context mContext) {
        if (mEditText == null || mContext == null)
            return;
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
    public static void closeKeybord(Activity activity){
        if (activity == null)
            return;
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null)
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            Class<EditText> cls = EditText.class;
            try {
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(false);
                setShowSoftInputOnFocus.invoke(activity.getCurrentFocus(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打卡软键盘
     */
    public static void openKeybord(EditText mEditText, Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(mEditText, InputMethodManager.RESULT_SHOWN);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static Handler getMainHandler() {
        return GlobalApplication.getMainHandler();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    public static float dip2px(Context context,float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return dpValue * scale + 0.5f;
    }
    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getColor(int color) {
        return getContext().getResources().getColor(color);
    }

    public static void hideKeyboard(Activity activity) {
        if (activity == null)
            return;
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (activity.getWindow().getAttributes().softInputMode != WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN) {
            if (activity.getCurrentFocus() != null)
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
            Class<EditText> cls = EditText.class;
            try {
                Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(false);
                setShowSoftInputOnFocus.invoke(activity.getCurrentFocus(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean canLoadMore(List list) {
        if (list == null || list.size() < 10) {
            return false;
        } else {
            return true;
        }
    }

    public static String getVersionCode() {
        try {
            String pkName = getContext().getPackageName();
            String versionName = getContext()
                    .getPackageManager().getPackageInfo(pkName, 0).versionName;
            return versionName;
        } catch (Exception e) {
        }
        return null;
    }
    public static String getVersionCode(Context context) {
        try {
            String pkName = context.getPackageName();
            String versionName = context
                    .getPackageManager().getPackageInfo(pkName, 0).versionName;
            return versionName;
        } catch (Exception e) {
        }
        return null;
    }

    public static boolean isMobile(String mobiles) {

        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[7,0-9])|(18[0-3,5-9]))\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();

    }

    public static void setText(EditText editText, String text) {
        if (!TextUtils.isEmpty(text)) {
            editText.setText(text);
        }
    }

    public static void setText(EditText editText, String textShow, String defaultText) {
        if (!TextUtils.isEmpty(textShow)) {
            editText.setText(textShow);
        } else {
            editText.setText(defaultText);
        }
    }

    public static void setText(TextView editText, String textShow, String defaultText) {
        if (!TextUtils.isEmpty(textShow)) {
            editText.setText(textShow);
        } else {
            editText.setText(defaultText);
        }
    }

    public static void setText(TextView editText, String text) {
        if (!TextUtils.isEmpty(text)) {
            editText.setText(text);
        }
    }

    public static void setSex(TextView txPatientSex, String patientSex) {
        if (TextUtils.isEmpty(patientSex)) {
            return;
        }
        if (TextUtils.equals(patientSex, "M")) {
            txPatientSex.setText("男");
        } else if (TextUtils.equals(patientSex, "F")) {
            txPatientSex.setText("女");
        }
    }

    public static void hideKeyboard(EditText editText) {
        Class<EditText> cls = EditText.class;
        int inType = editText.getInputType();
        try {
            Method setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
            setShowSoftInputOnFocus.setAccessible(false);
            setShowSoftInputOnFocus.invoke(editText, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        editText.setInputType(InputType.TYPE_NULL);
        editText.setInputType(inType);
    }
    public static int getScreenWith() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
