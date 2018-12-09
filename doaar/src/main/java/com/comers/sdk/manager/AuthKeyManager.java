package com.comers.sdk.manager;

import android.app.Application;
import android.text.TextUtils;

import com.comers.sdk.baidu.BaiduHelper;
import com.comers.sdk.bean.AdPosition;
import com.comers.sdk.gtong.TongHelper;
import com.comers.sdk.toutiao.ToutiaoHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 79653 on 2018/8/15.
 * 描述：
 */
public enum AuthKeyManager {
    INSTANCE;
    private String BaiDuKey = "";
    private String TouTiaoKey = "";
    private String GuangDTKey = "";
    private String authKey = "";
    private String appName="";
    public Map<String, AdPosition> mPositionMap = new HashMap<>();

    public String getBaiDuKey() {
        return BaiDuKey;
    }

    public String getTouTiaoKey() {
        return TouTiaoKey;
    }

    public String getGuangDTKey() {
        return GuangDTKey;
    }

    public String getAuthKey() {
        return authKey;
    }

    public String getAuthSecret() {
        return authSecret;
    }

    private String authSecret = "";

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setBaiDuKey(Application application, String baiDuKey) {
        this.BaiDuKey = baiDuKey;
        if (!TextUtils.isEmpty(baiDuKey)) {
            BaiduHelper.getInstance().init(application, baiDuKey);
        }
    }

    public void setTouTiaoKey(Application application, String touTiaoKey, String appName) {
        this.TouTiaoKey = touTiaoKey;
        if (!TextUtils.isEmpty(touTiaoKey)) {
            ToutiaoHelper.getInstance().init(application, touTiaoKey, appName);
        }
    }

    public void setGuangDTKey(Application application, String guangDTKey) {
        this.GuangDTKey = guangDTKey;
        if (!TextUtils.isEmpty(guangDTKey)) {
            TongHelper.getInstance().init(application, guangDTKey);
        }
    }

    public void setAuth(String authKey, String authSecret) {
        this.authKey = authKey;
        this.authSecret = authSecret;
    }
}
