package com.comers.sdk.bean;

import java.io.Serializable;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public  class EventTrack implements Serializable {
    /**
     * 事件类型
     {
     SHOW = 1,  //曝光监测
     CLICK = 2;  //点击监测
     OPEN = 3;  //如果用户已经安装了广告主APP，则直接打开APP并回传“打开”的监测
     DOWNLOAD=4;  //如果用户没有安装广告主APP，在下载完成后回传“下载完成”的监测
     I
     OPEN_LINK_CONSUME=7:
     打开一个链接/下载链接需要多久
     例如打开一个普通链接，或者打开一个下载链接到有数据流开始返回，耗费了多久，当返回此事件类型时，客户端在用户第一次打开此广告需要上报，
     在上报地址后面追加consume=耗费时间(毫秒)

     VIDEO_PLAY_EVENT=8:
     视频播放事件，详细请参考文档末事件上报特殊说明部分
     */
    public String event_type;
    /**
     * 事件url，HTTP GET请求
     */
    public String notify_url;

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }
}

