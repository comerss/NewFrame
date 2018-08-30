package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpHeader;
import com.comers.baselibrary.origin.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author nate
 */

public class OriginHttpResponse extends AbstractHttpResponse {

    private HttpURLConnection mConnection;

    public OriginHttpResponse(HttpURLConnection connection) {
        this.mConnection = connection;
    }

    @Override
    public HttpStatus getStatus() {
        try {
            return HttpStatus.getValue(mConnection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getStatusMsg() {
        try {
            return mConnection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getContentLength() {
        return mConnection.getContentLength();
    }


    @Override
    protected InputStream getBodyInternal() throws IOException {
        if(mConnection.getResponseCode()>=400){
            return mConnection.getErrorStream();
        }else{
            return mConnection.getInputStream();
        }
    }

    @Override
    protected void closeInternal() {
        mConnection.disconnect();

    }

    @Override
    public HttpHeader getHeaders() {

        HttpHeader header = new HttpHeader();
        for (Map.Entry<String, List<String>> entry : mConnection.getHeaderFields().entrySet()) {
            header.set(entry.getKey(), entry.getValue().get(0));
        }
        return header;
    }
}
