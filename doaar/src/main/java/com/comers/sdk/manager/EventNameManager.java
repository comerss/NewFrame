package com.comers.sdk.manager;

/**
 * Created by 79653 on 2018/8/11.
 * 描述：
 */
public enum EventNameManager {
    INSTANCE;
    public String error(String appid, String advertiseId){
        return AuthKeyManager.INSTANCE.getAuthKey()+"_"+appid+"_"+advertiseId+"_Error";
    }
    public String timeOut(String appid, String advertiseId){
        return AuthKeyManager.INSTANCE.getAuthKey()+"_"+appid+"_"+advertiseId+"_TimeOut";
    }
    public String success(String appid, String advertiseId){
        return AuthKeyManager.INSTANCE.getAuthKey()+"_"+appid+"_"+advertiseId+"_Success";
    }
    public String click(String appid,String advertiseId){
        return AuthKeyManager.INSTANCE.getAuthKey()+"_"+appid+"_"+advertiseId+"_OnClick";
    }
    public String show(String appid,String advertiseId){
        return AuthKeyManager.INSTANCE.getAuthKey()+"_"+appid+"_"+advertiseId+"_Show";
    }

}
