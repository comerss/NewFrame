package com.comers.sdk.view;

import android.app.Activity;

import com.comers.sdk.interfaces.MyCallBack;
import com.comers.sdk.utils.Contants;
import com.comers.sdk.utils.NetUtils;
import com.comers.sdk.utils.PhoneInfoUtils;


/**
 * Created by yujuan on 2017/9/7.
 */
public class GravitySplashView {
    private Activity act;
    private String key,secret,user;
    public GravitySplashView (Activity activity,String userid){
        this.act=activity;
        this.key= Contants.getDonewsKey(activity);
        this.secret=Contants.getDonewsSecret(activity);
        this.user=userid;
    }
    public NativeData loadGravitySplashAd(MyCallBack callBack){
        if(act==null){
            return null;
        }
        if(!PhoneInfoUtils.isLiving(act)){
            return null;
        }
        if(NetUtils.netstate(act)!=0){
//            URLUtils.getGravitySplashAd(act,user ,key, secret,callBack);
        }
        return null;
    }
}
