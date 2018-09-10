package com.donews.sdk.view;


import com.donews.sdk.bean.EventTrack;
import com.donews.sdk.bean.ImageInfo;
import com.donews.sdk.bean.InteractionObject;
import com.donews.sdk.bean.VideoInfo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YJ on 2016/4/7.
 */
public class NativeData implements Serializable{
    private List<String> impurls;
    private String click_url;
    private String icon;
    private String title;
    private String text;

    public List<ImageInfo> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImageInfo> imgs) {
        this.imgs = imgs;
    }

    private String pic;
    private List<ImageInfo> imgs;
    private int w;
    private int h;
    private VideoInfo video;
    private int is_default_ad;//1正常广告、2默认广告

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_default_ad() {
        return is_default_ad;
    }

    public void setIs_default_ad(int is_default_ad) {
        this.is_default_ad = is_default_ad;
    }

    public VideoInfo getVideo() {
        return video;
    }

    public void setVideo(VideoInfo video) {
        this.video = video;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public NativeData() {
    }

    public List<String> getImpurls() {
        return impurls;
    }

    public void setImpurls(List<String> impurls) {
        this.impurls = impurls;
    }

    public String getClick_url() {
        return click_url;
    }

    public void setClick_url(String click_url) {
        this.click_url = click_url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public NativeData(List<String> impurls, String click_url, String icon, String title, String text, String pic, int w, int h) {
        this.impurls = impurls;
        this.click_url = click_url;
        this.icon = icon;
        this.title = title;
        this.text = text;
        this.pic=pic;
        this.w=w;
        this.h=h;
    }
    public NativeData(List<String> impurls, String click_url, String icon, String title, String text, String pic) {
        this.impurls = impurls;
        this.click_url = click_url;
        this.icon = icon;
        this.title = title;
        this.text = text;
        this.pic=pic;
    }


    private String mid;
    private String aid;
    private String url;
    private int information;//信息流展示样式
    private int m_play;//轮播规则
    private String wn_url;//广告曝光
    private String monitor_wn_url;//第三方曝光
    private String monitor_cl_url;

    public String getMonitor_wn_url() {
        return monitor_wn_url;
    }

    public void setMonitor_wn_url(String monitor_wn_url) {
        this.monitor_wn_url = monitor_wn_url;
    }

    public String getMonitor_cl_url() {
        return monitor_cl_url;
    }

    public void setMonitor_cl_url(String monitor_cl_url) {
        this.monitor_cl_url = monitor_cl_url;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getInformation() {
        return information;
    }

    public void setInformation(int information) {
        this.information = information;
    }

    public int getM_play() {
        return m_play;
    }

    public void setM_play(int m_play) {
        this.m_play = m_play;
    }

    public String getWn_url() {
        return wn_url;
    }

    public void setWn_url(String wn_url) {
        this.wn_url = wn_url;
    }

    @Override
    public String toString() {
        return "NativeData{" +
                "impurls=" + impurls +
                ", click_url='" + click_url + '\'' +
                ", icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", pic='" + pic + '\'' +
                ", w=" + w +
                ", h=" + h +
                ", mid=" + mid +
                ", aid=" + aid +
                ", url='" + url + '\'' +
                ", information=" + information +
                ", m_play=" + m_play +
                ", wn_url='" + wn_url + '\'' +
                ", monitor_wn_url='" + monitor_wn_url + '\'' +
                ", monitor_cl_url='" + monitor_cl_url + '\'' +
                '}';
    }
    private String ad_from;

    public String getAd_from() {
        return ad_from;
    }

    public void setAd_from(String ad_from) {
        this.ad_from = ad_from;
    }

    private String interaction_type;//交互类型，1：不交互 2：浏览 3：下载 4：打电话  5：短信 6：邮件  7：视频播放 8：音频播放 9：GIF
    private List<EventTrack> eventTracks;
    private InteractionObject interactionObject;


    public String getInteraction_type() {
        return interaction_type;
    }

    public void setInteraction_type(String interaction_type) {
        this.interaction_type = interaction_type;
    }

    public List<EventTrack> getEventTracks() {
        return eventTracks;
    }

    public void setEventTracks(List<EventTrack> eventTracks) {
        this.eventTracks = eventTracks;
    }

    public InteractionObject getInteractionObject() {
        return interactionObject;
    }

    public void setInteractionObject(InteractionObject interactionObject) {
        this.interactionObject = interactionObject;
    }
}
