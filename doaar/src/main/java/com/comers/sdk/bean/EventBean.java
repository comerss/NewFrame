package com.comers.sdk.bean;

/**
 * Created by YJ on 2016/6/29.
 */
public class EventBean {
    private String appkey;
    private String appversion;
    private String osversion;
    private String lang;
    private String channel;
    private String timestamp;
    private String display;
    private String suuid;
    private String network;
    private String deviceType;
    private String osType;
    private String ip;
    private String mac;
    private String event;
    private int register_days;
    private String nettype;

    private String payment_method;
    private int money;

    private String consumption_point;

    private int pagenum;
    private String lastpage;
    private String pagename;

    private String eventname;

    private String error_type;

    private long use_duration;//使用时长
    private long use_interval;//使用间隔

    private String account_level;

    public String getAccount_level() {
        return account_level;
    }

    public void setAccount_level(String account_level) {
        this.account_level = account_level;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSuuid() {
        return suuid;
    }

    public void setSuuid(String suuid) {
        this.suuid = suuid;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getRegister_days() {
        return register_days;
    }

    public void setRegister_days(int register_days) {
        this.register_days = register_days;
    }

    public String getNettype() {
        return nettype;
    }

    public void setNettype(String nettype) {
        this.nettype = nettype;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getConsumption_point() {
        return consumption_point;
    }

    public void setConsumption_point(String consumption_point) {
        this.consumption_point = consumption_point;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public String getLastpage() {
        return lastpage;
    }

    public void setLastpage(String lastpage) {
        this.lastpage = lastpage;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public long getUse_duration() {
        return use_duration;
    }

    public void setUse_duration(long use_duration) {
        this.use_duration = use_duration;
    }

    public long getUse_interval() {
        return use_interval;
    }

    public void setUse_interval(long use_interval) {
        this.use_interval = use_interval;
    }

    private String account;
    private String device_id;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "EventBean{" +
                "appkey='" + appkey + '\'' +
                ", appversion='" + appversion + '\'' +
                ", osversion='" + osversion + '\'' +
                ", lang='" + lang + '\'' +
                ", channel='" + channel + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", display='" + display + '\'' +
                ", suuid='" + suuid + '\'' +
                ", network='" + network + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", osType='" + osType + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", event='" + event + '\'' +
                ", register_days=" + register_days +
                ", nettype='" + nettype + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", money=" + money +
                ", consumption_point='" + consumption_point + '\'' +
                ", pagenum=" + pagenum +
                ", lastpage='" + lastpage + '\'' +
                ", pagename='" + pagename + '\'' +
                ", eventname='" + eventname + '\'' +
                ", error_type='" + error_type + '\'' +
                ", use_duration=" + use_duration +
                ", use_interval=" + use_interval +
                ", account_level='" + account_level + '\'' +
                ", account='" + account + '\'' +
                ", device_id='" + device_id + '\'' +
                '}';
    }
}