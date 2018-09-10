package com.donews.sdk.manager;

import android.app.Activity;
import android.app.Application;

import com.donews.sdk.bean.Native;


/**
 * Created by 79653 on 2018/6/19.
 * 描述：需要用于请求的基本参数
 */
public class DoSlot {

    private Activity context;
    private Application mApplication;

    public Application getApplication() {
        return mApplication;
    }

    public void setApplication(Application application) {
        mApplication = application;
    }

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    private String appID;//应用ID

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Native getNative() {
        return mNative;
    }

    private String appName;//应用ID
    private String advertiseId;//广告位ID
    private int height;
    private int width;
    private boolean isSupportDeepLink;
    private String mediaExtra;
    private int adCount;
    private int orientation;
    private Native mNative;
    private int pageNum;
    private int channel;

    public int getPageNum() {
        return pageNum;
    }

    public int getChannelId() {
        return channel;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(String advertiseId) {
        this.advertiseId = advertiseId;
    }

    public void setImgAcceptSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void setNative(Native aNative){
        this.mNative=aNative;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isSupportDeepLink() {
        return isSupportDeepLink;
    }

    public void setSupportDeepLink(boolean supportDeepLink) {
        isSupportDeepLink = supportDeepLink;
    }

    public String getMediaExtra() {
        return mediaExtra;
    }

    public void setMediaExtra(String mediaExtra) {
        this.mediaExtra = mediaExtra;
    }

    public int getAdCount() {
        return adCount;
    }

    public void setAdCount(int adCount) {
        this.adCount = adCount;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    private DoSlot() {
    }

    public static class Builder {
        private String appID;//应用ID
        private String appName;
        private String advertiseId;//广告位ID
        private int height;
        private int width;
        private Application mApplication;
        private Activity context;
        private boolean isSupportDeepLink;
        private String mediaExtra;
        private int adCount;
        private int horizontal;
        private Native mNative;
        private int pageNum = 1;
        private int channel;

        public Builder() {
        }

        public Builder setPageNum(int pageNum) {
            this.pageNum = pageNum;
            return this;
        }

        public Builder setChannelId(int channelId) {
            this.channel = channelId;
            return this;
        }

        public Builder setAppID(String appID) {
            this.appID = appID;
            return this;
        }

        public Builder setApplication(Application application) {
            mApplication = application;
            return this;
        }

        public Builder setAdvertiseId(String advertiseId) {
            this.advertiseId = advertiseId;
            return this;
        }

        public Builder setContext(Activity context) {
            this.context = context;
            return this;
        }

        public Builder setImageAcceptedSize(int width, int height) {
            this.height = height;
            this.width = width;
            return this;
        }

        public Builder setSupportDeepLink(boolean supportDeepLink) {
            isSupportDeepLink = supportDeepLink;
            return this;
        }

        public Builder setAppName(String appName) {
            this.appName = appName;
            return this;
        }

        public Builder setMediaExtra(String mediaExtra) {
            this.mediaExtra = mediaExtra;
            return this;
        }

        public Builder setAdCount(int adCount) {
            this.adCount = adCount;
            return this;
        }

        public Builder setHorizontal(int horizontal) {
            this.horizontal = horizontal;
            return this;
        }
        public Builder setNative(Native aNative){
            this.mNative=aNative;
            return this;
        }
        public DoSlot build() {
            DoSlot slot = new DoSlot();
            slot.setAppID(this.appID);
            slot.setAdCount(adCount);
            slot.setAdvertiseId(advertiseId);
            slot.setOrientation(horizontal);
            slot.setImgAcceptSize(width, height);
            slot.setSupportDeepLink(isSupportDeepLink);
            slot.setMediaExtra(mediaExtra);
            slot.setContext(context);
            slot.setApplication(mApplication);
            slot.setNative(mNative);
            return slot;
        }
    }

}
