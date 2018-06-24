package com.comers.baselibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.comers.baselibrary.R;


/*使用时需要注意吧context更换成全局的*/
public class SharedHelper {
    public static SharedPreferences preferences;


    public static void init(Context context) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(UIUtils.getContext().getString(R.string.app_name), Context.MODE_PRIVATE);
        }
    }

    public static void init() {
        if (preferences == null) {
            preferences = UIUtils.getContext().getSharedPreferences(UIUtils.getContext().getString(R.string.app_name), Context.MODE_PRIVATE);
        }
    }

    //添加属性
    public static <T> void put(Context context, String key, T values) {
        init(context);
        SharedPreferences.Editor edit = preferences.edit();
        if (values instanceof String) {
            edit.putString(key, values.toString());
        } else if (values instanceof Integer) {
            edit.putInt(key, (Integer) values);
        } else if (values instanceof Long) {
            edit.putLong(key, (Long) values);
        } else if (values instanceof Boolean) {
            edit.putBoolean(key, (Boolean) values);
        } else if (values instanceof Float) {
            edit.putFloat(key, (Float) values);
        }
        edit.commit();
    }

    //添加属性
    public static <T> void put(String key, T values) {
        init();
        SharedPreferences.Editor edit = preferences.edit();
        if (values instanceof String) {
            edit.putString(key, values.toString());
        } else if (values instanceof Integer) {
            edit.putInt(key, (Integer) values);
        } else if (values instanceof Long) {
            edit.putLong(key, (Long) values);
        } else if (values instanceof Boolean) {
            edit.putBoolean(key, (Boolean) values);
        } else if (values instanceof Float) {
            edit.putFloat(key, (Float) values);
        }
        edit.commit();
    }

    //查询属性
    public static <T> T get(Context context, String key, T values) {
        init(context);
        Object o = null;
        if (values instanceof String) {
            o = preferences.getString(key, values.toString());
        } else if (values instanceof Integer) {
            o = preferences.getInt(key, (Integer) values);
        } else if (values instanceof Long) {
            o = preferences.getLong(key, (Long) values);
        } else if (values instanceof Boolean) {
            o = preferences.getBoolean(key, (Boolean) values);
        } else if (values instanceof Float) {
            o = preferences.getFloat(key, (Float) values);
        }
        T t = (T) o;
        return t;
    }

    //查询属性
    public static <T> T get(String key, T values) {
        init();
        Object o = null;
        if (values instanceof String) {
            o = preferences.getString(key, values.toString());
        } else if (values instanceof Integer) {
            o = preferences.getInt(key, (Integer) values);
        } else if (values instanceof Long) {
            o = preferences.getLong(key, (Long) values);
        } else if (values instanceof Boolean) {
            o = preferences.getBoolean(key, (Boolean) values);
        } else if (values instanceof Float) {
            o = preferences.getFloat(key, (Float) values);
        }
        T t = (T) o;
        return t;
    }


}
