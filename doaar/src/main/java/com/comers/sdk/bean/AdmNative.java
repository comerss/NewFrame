package com.comers.sdk.bean;

import java.util.List;

/**
 * Created by 79653 on 2018/6/26.
 * 描述：
 */
public class AdmNative {
    /**
     * 素材图片的详细信息
     */
    public List<ImageInfo> imgs;
    /**
     * 素材标题
     */
    public String ad_title;
    public String logo;
    /**
     * 素材描述
     */
    public String description;
    /**
     * 广告来源厂商标识
     */
    public String ad_source_logo;
    /**
     * 广告来源厂商名称
     */
    public String ad_source_text;
    /**
     *
     */
    public String adtag;
    /**
     * 视频素材URL,客户端通过此地址获取视频内容
     */
    public String video_url;
    /**
     * 视频播放时长,秒
     */
    public String video_duration;
    /**
     * 视频大小,byte
     */
    public String video_size;
    /**
     * 视频素材格式,avi,mp4,wmv,rmvb[]
     */
    public String video_format;

}
