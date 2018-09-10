package com.donews.sdk.bean;


import com.donews.sdk.utils.JSONParser;

/**
 * Created by 79653 on 2018/8/16.
 * 描述：
 */
public class Native {
    /*{
	        "aid":"广告编号id",
	        "mid":"素材编号id",
	        "material_type_id":"素材类型", //1 图片 2 视频
	        "pic":["素材图片地址（node端将其组合成数组）"],
	        "video":{
	           "url":"视频素材地址",
	           "thumbnail":"缩略图地址",
	           "time":"时长"
	        },
	        "w":"素材宽",
	        "h":"素材高",
	        "title":"广告名称",
	        "url":"落地页地址",
	        "information":"信息流展示样式",
	        "m_play":"轮播规则",
	        "wn_url":"曝光统计url",
	        "clk_url":"点击统计url",
	        "adHtml":"广告html代码",
	        "ad_from":"广告来源"            //广告来源(数字）[ 0:直客（非联盟） 1:百度 2:google 3:今日头条 4:英威诺 5:广点通 ]
	    }*/
    public String ad_from;
    public String clk_url;
    public String wn_url;
    public String aid;
    public String mid;

    public Native(String json) {
        ad_from = JSONParser.getString(json, "ad_from");
        clk_url = JSONParser.getString(json, "clk_url");
        wn_url = JSONParser.getString(json, "wn_url");
        aid = JSONParser.getString(json, "aid");
        mid = JSONParser.getString(json, "mid");
    }
}
