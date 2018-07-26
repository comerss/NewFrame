package com.comers.baselibrary.download;

import android.text.TextUtils;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Call;

/**
 * Created by 79653 on 2018/7/18.
 * 描述：
 */
public enum UrlManager {
    INSTANCE;
    private HashSet<String> mHashSet = new HashSet<>();
    private ConcurrentHashMap<String, Integer> mIntegerHashMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> mStrHashMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Call> mCallHashMap = new ConcurrentHashMap<>();

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
        if(!mIntegerHashMap.containsKey(url)){
            int notifyId=mIntegerHashMap.size() + 1;
            mIntegerHashMap.put(url, notifyId);
            mStrHashMap.put(notifyId,url );
        }
    }

    public void addCall(String url, Call call) {
        if (!mCallHashMap.containsKey(url))
            mCallHashMap.put(url, call);
    }

    public void removeCall(String url) {
        if (mCallHashMap.containsKey(url))
            mCallHashMap.remove(url);
    }

    public void cancelCall(String url) {
        if (mCallHashMap.containsKey(url)){
            mCallHashMap.get(url).cancel();
//            ToastUtil.showToast(DonewsApp.mContext,"取消下载");
        }
        if(contains(url)){
            mHashSet.remove(url);
        }
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
