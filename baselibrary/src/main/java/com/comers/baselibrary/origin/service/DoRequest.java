package com.comers.baselibrary.origin.service;


import com.comers.baselibrary.origin.http.HttpMethod;

/**
 * @author nate
 */

public class DoRequest {

    private String mUrl;

    public HttpMethod mMethod;
    //下载 文件保存地址
    public String path;

    private byte[] mData;

    private ICallBack mResponse;

    private String mContentType;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public HttpMethod getMethod() {
        return mMethod;
    }


    public byte[] getData() {
        return mData;
    }

    public void setData(byte[] data) {
        mData = data;
    }

    public ICallBack getResponse() {
        return mResponse;
    }

    public void setResponse(ICallBack response) {
        mResponse = response;
    }

    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String contentType) {
        mContentType = contentType;
    }
}
