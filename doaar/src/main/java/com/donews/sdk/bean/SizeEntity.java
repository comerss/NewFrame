package com.donews.sdk.bean;

/**
 * Created by yujuan on 2017/11/15.
 */
public class SizeEntity {
    private int w;
    private int h;
    private int timestamp;

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public SizeEntity(int w, int h, int timestamp) {
        this.w = w;
        this.h = h;
        this.timestamp = timestamp;
    }
    public SizeEntity() {
    }
    public SizeEntity(int w, int h) {
        this.w = w;
        this.h = h;
    }
}
