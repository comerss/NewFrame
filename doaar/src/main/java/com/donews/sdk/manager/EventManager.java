package com.donews.sdk.manager;

import android.text.TextUtils;

import com.donews.sdk.bean.Native;
import com.donews.sdk.utils.HttpUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 79653 on 2018/8/17.
 * 描述：
 */
public class EventManager {
    public static Set<String> click = new HashSet<>();
    public static Set<String> show = new HashSet<>();

    public static void onEvent(String url) {
        HttpUtils.startHttpGet(url, new HttpUtils.HttpResultCallback() {
            @Override
            public void result(String url, boolean isResult, String jsonStr) {

            }
        });
    }

    public static void click(Native data) {
        if (data != null && !TextUtils.isEmpty(data.clk_url)) {
            if (click.contains(data.aid)) {
                return;
            }else{
                click.add(data.aid);
            }
            HttpUtils.startHttpGet(data.clk_url, new HttpUtils.HttpResultCallback() {
                @Override
                public void result(String url, boolean isResult, String jsonStr) {

                }
            });
        }
    }

    public static void show(Native data) {
        if (data != null && !TextUtils.isEmpty(data.wn_url)) {
            if(show.contains(data.aid)){
                return;
            }else{
                show.add(data.aid);
            }
            HttpUtils.startHttpGet(data.wn_url, new HttpUtils.HttpResultCallback() {
                @Override
                public void result(String url, boolean isResult, String jsonStr) {

                }
            });
        }
    }
}
