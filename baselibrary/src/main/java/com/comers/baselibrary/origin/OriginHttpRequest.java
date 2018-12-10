package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpHeader;
import com.comers.baselibrary.origin.http.HttpMethod;
import com.comers.baselibrary.origin.http.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Map;

/**
 * @author nate
 */

public class OriginHttpRequest extends BufferHttpRequest {

    private HttpURLConnection mConnection;

    private String mUrl;

    private HttpMethod mMethod;

    public OriginHttpRequest(HttpURLConnection connection, HttpMethod method, String url) {
        this.mConnection = connection;
        this.mUrl = url;
        this.mMethod = method;
    }

    @Override
    protected HttpResponse executeInternal(HttpHeader header, byte[] data) throws IOException {

        for (Map.Entry<String, String> entry : header.entrySet()) {
            mConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        mConnection.setDoInput(true);
        mConnection.setInstanceFollowRedirects(true);//自动重定向
        mConnection.setRequestProperty("Charset", "UTF-8");
        mConnection.setUseCaches(false);
        mConnection.setConnectTimeout(10000);
        mConnection.setReadTimeout(10000);

        if(mMethod== HttpMethod.FORM){
            mConnection.setRequestMethod("POST");
        }else{
            mConnection.setRequestMethod(mMethod.name());
        }
        if(mMethod==HttpMethod.POST){
            mConnection.setDoOutput(true);
            mConnection.setRequestProperty("Content-Type", "application/json");
        }else if(mMethod==HttpMethod.FORM){
            mConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        }
        mConnection.setRequestProperty("Content-Length",data.length + "");
        mConnection.connect();
        if (data != null && data.length > 0) {
            OutputStream out = mConnection.getOutputStream();
            out.write(data);
            out.close();
        }
        OriginHttpResponse response = new OriginHttpResponse(mConnection);
        return response;
    }


    @Override
    public HttpMethod getMethod() {
        return mMethod;
    }

    @Override
    public URI getUri() {
        return URI.create(mUrl);
    }
}
