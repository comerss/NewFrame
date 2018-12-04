package com.comers.sdk.view;

import android.app.Activity;

import com.comers.sdk.utils.NetUtils;
import com.comers.sdk.utils.URLUtils;


/**
 * Created by YJ on 2016/8/9.
 */
public class AppCenterView {
    private Activity act;
    private String key,secret;
    public AppCenterView(Activity c,String authKey,String authSecret){
        act=c;
        key=authKey;
        secret=authSecret;
    }
    public void loadAd(AppCenterCallBack callBack){
        if(NetUtils.netstate(act)!=0){
            URLUtils.getAppCenterAD(act, key, secret,callBack);
        }
    }
    public interface AppCenterCallBack{
        public void getAppCenter(NativeData appCenter);
    }

    /**
     * 初始化接口变量
     */
    AppCenterCallBack icallBack = null;
}
