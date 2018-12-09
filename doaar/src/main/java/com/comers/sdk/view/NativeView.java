package com.comers.sdk.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

import com.comers.sdk.interfaces.MyCallBack;
import com.comers.sdk.utils.Contants;
import com.comers.sdk.utils.NetUtils;
import com.comers.sdk.utils.URLUtils;


/**
 * Created by YJ on 2016/4/8.
 */
public class NativeView {

    /**
     * 初始化接口变量
     */
    MyCallBack icallBack = null;

    /**
     * 自定义控件的自定义事件
     * @param iBack 接口类型
     */
//    public void setNativeCallBack(NativeCallBack iBack) {
//        icallBack = iBack;
//    }
    private Activity act;
    private String key,secret;
    public NativeView(Activity c,String authKey,String authSecret){
        act=c;
        key=authKey;
        secret=authSecret;
    }
    public NativeView (Activity activity){
        this.act=activity;
        this.key= Contants.getDonewsKey(activity);
        this.secret=Contants.getDonewsSecret(activity);
    }
    public NativeData loadAd(MyCallBack callBack){
        if(NetUtils.netstate(act)!=0){
            URLUtils.getNativeAD(act, key,secret,callBack);
        }
        return null;
    }

    public NativeData loadNiuerAd(String adType, String userid, String channelid, String position, int black_flag, MyCallBack callBack){
        if(NetUtils.netstate(act)!=0){
//            URLUtils.getNiuerNativeAd(act,userid,key,secret,adType,channelid,position,black_flag,callBack);
        }
        return null;
    }
    private Handler mHandler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Contants.GETNATIVEAD_SUCCESS:
                    NativeData aNative=(NativeData)msg.obj;
                    icallBack.setNative(aNative);
                    break;
            }
        }
    };
}
