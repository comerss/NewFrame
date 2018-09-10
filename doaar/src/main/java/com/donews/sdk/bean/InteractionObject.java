package com.donews.sdk.bean;

import java.io.Serializable;

/**
 * Created by 79653 on 2018/6/19.
 * 描述：
 */
public  class InteractionObject implements Serializable {
    /**
     * 如果是浏览类则是落地页地址；
     * 如果是下载类则是下载地址；
     * 如果是视频类则是视频地址；
     */
    public String url;
    /**
     * app deep link地址，（deep_link  优先  url）
     * 如果客户端不支持deeplink地址或者唤醒不成功，则应该使用URL打开
     */
    public String deep_link;
    public String phone;//电话或者短信类广告的目的手机号码
    public String mail;//邮件类广告的目的邮箱地址
    public String msg;//短信或者邮件类广告的内容
    public String package_name;//下载类广告的APP包名

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDeep_link() {
        return deep_link;
    }

    public void setDeep_link(String deep_link) {
        this.deep_link = deep_link;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }
}
