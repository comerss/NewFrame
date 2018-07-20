package com.comers.baselibrary.http;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 79653 on 2018/7/18.
 * 描述：
 */
public enum UrlManager {
    INSTANCE;
    private HashSet<String> mHashSet = new HashSet<>();
    private HashMap<String, Integer> mIntegerHashMap = new HashMap<>();

    public boolean contains(String url) {
        boolean contains = false;
        for (String str : mHashSet) {
            if (TextUtils.equals(url, str)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public void add(String url) {
        if (contains(url))
            return;
        mHashSet.add(url);
        mIntegerHashMap.put(url, mIntegerHashMap.size() + 1);
    }

    public void remove(String url) {
        if (!contains(url))
            return;
        mHashSet.remove(url);
    }

    public int get(String url) {
        if (!contains(url))
            return 1;
        return mIntegerHashMap.get(url);
    }

}
