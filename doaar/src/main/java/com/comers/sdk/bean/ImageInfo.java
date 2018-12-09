package com.comers.sdk.bean;

import java.io.Serializable;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public class ImageInfo implements Serializable{
//(var height:Int?,var width:Int?,var url:String?)
    public int height;
    public int width;

    public ImageInfo(int height, int width, String imgUrl) {
        this.height = height;
        this.width = width;
        this.url = imgUrl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String url;
}
