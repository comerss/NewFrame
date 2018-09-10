package com.donews.sdk.bean;

import java.util.List;

/**
 * Created by yujuan on 2018/6/6.
 */

public class InvenoAd {
    public String ad_id;
    /**
     * 落地页打开类型
     * 0:ALL,内开外开由媒体决定
     * 1：INNER,内开，由媒体webview打开
     * 2：OUTER,外开，由浏览器打开
     */
    public int open_type;
    /**
     * 交互类型
     * 1：NO_INTERACTION,不交互
     * 2：BROWSE,浏览
     * 3：DOWNLOAD,下载
     * 4：DIALING,电话
     * 5：MESSAGE,短信
     * 6：MAIL,邮件
     * 7：VIDEO，视频播放
     * 8：AUDIO，音频播放
     * 9：GIF,GIF图播放
     */
    public String interaction_type;
    /**
     * 用于描述与用户交互动作，跟interaction_type相对应
     */
    public InteractionObject interaction_object;
    /**
     * 广告素材类型
     * 1、html素材
     * 2、原生素材
     */
    public String adm_type;
    /**
     * 广告素材对象
     */
    public Adm adm;
    /**
     * EventTrack对象列表，用于各种事件的追踪
     （返回的事件是一个列表，需要客户端逐一上报）
     */
    public List<EventTrack> event_track;
    /**
     * 客户端广告过期时长
     * 单位：秒
     * 从客户端请求到此广告后开始计时，客户端在这个时长之前展示广告
     */
    public int expiration_duration;
    /**
     * 广告清单过期UTC 时间戳，非即时展现类广告位使用
     */
    public int expiration_time;

    /**
     * 广告位槽位id，如果广告位请求多条创意，INVENO会对返回的多条创意进行编号，从0开始
     */
    public int adspace_slot_seq;
    //--------------------------------------一下是为了方便数据获取，拿到的数据--------------------------------
    public String title;
    public String description;
    public List<String> imgList ;
    public List<ImageInfo> imgs;
    public List<EventTrack> eventTracks;
    public InteractionObject interactionObject;
    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public int getOpen_type() {
        return open_type;
    }

    public void setOpen_type(int open_type) {
        this.open_type = open_type;
    }

    public String getInteraction_type() {
        return interaction_type;
    }

    public void setInteraction_type(String interaction_type) {
        this.interaction_type = interaction_type;
    }

    public InteractionObject getInteraction_object() {
        return interaction_object;
    }

    public void setInteraction_object(InteractionObject interaction_object) {
        this.interaction_object = interaction_object;
    }

    public String getAdm_type() {
        return adm_type;
    }

    public void setAdm_type(String adm_type) {
        this.adm_type = adm_type;
    }

    public Adm getAdm() {
        return adm;
    }

    public void setAdm(Adm adm) {
        this.adm = adm;
    }

    public List<EventTrack> getEvent_track() {
        return event_track;
    }

    public void setEvent_track(List<EventTrack> event_track) {
        this.event_track = event_track;
    }

    public int getExpiration_duration() {
        return expiration_duration;
    }

    public void setExpiration_duration(int expiration_duration) {
        this.expiration_duration = expiration_duration;
    }

    public int getExpiration_time() {
        return expiration_time;
    }

    public void setExpiration_time(int expiration_time) {
        this.expiration_time = expiration_time;
    }

    public int getAdspace_slot_seq() {
        return adspace_slot_seq;
    }

    public void setAdspace_slot_seq(int adspace_slot_seq) {
        this.adspace_slot_seq = adspace_slot_seq;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }

    public void setImgs(List<ImageInfo> imgs) {
        this.imgs = imgs;
    }

    public void setEventTracks(List<EventTrack> eventTracks) {
        this.eventTracks = eventTracks;
    }

    public void setInteractionObject(InteractionObject interactionObject) {
        this.interactionObject = interactionObject;
    }
}
