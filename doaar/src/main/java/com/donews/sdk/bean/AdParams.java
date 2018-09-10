package com.donews.sdk.bean;

import android.app.Activity;

/**
 * Created by 79653 on 2018/8/9.
 * 描述：
 */
public class AdParams {
    private Activity context;
    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    private int height;
    private int width;
    private boolean isSupportDeepLink;
    private String mediaExtra;
    private int adCount;
    private int orientation;
    private String adPosition;
    public void setImgAcceptSize(int width, int height) {
        this.width = width;
        this.height = height;
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
    public void setAdPosition(String adPosition){
        this.adPosition=adPosition;
    }
    public String getAdPosition(){
        return adPosition;
    }
    private AdParams() {
    }

    public static class Builder {
        private int height;
        private int width;
        private Activity context;
        private boolean isSupportDeepLink;
        private String mediaExtra;
        private int adCount;
        private int horizontal;
        private String adPosition;
        public Builder() {
        }
        public Builder setContext(Activity context) {
            this.context = context;
            return this;
        }

        public Builder setAdPosition(String codeId){
            this.adPosition=codeId;
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

        public AdParams build() {
            AdParams slot = new AdParams();
            slot.setAdCount(adCount);
            slot.setOrientation(horizontal);
            slot.setImgAcceptSize(width, height);
            slot.setSupportDeepLink(isSupportDeepLink);
            slot.setMediaExtra(mediaExtra);
            slot.setContext(context);
            slot.setAdPosition(adPosition);
            return slot;
        }
    }
}
