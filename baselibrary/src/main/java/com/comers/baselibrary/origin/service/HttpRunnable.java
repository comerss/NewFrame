package com.comers.baselibrary.origin.service;


import com.comers.baselibrary.origin.http.HttpRequest;
import com.comers.baselibrary.origin.http.HttpResponse;

import java.io.ByteArrayOutputStream;

/**
 * @author nate
 */

public class HttpRunnable implements Runnable {

    private HttpRequest mHttpRequest;

    private DoRequest mRequest;

    private WorkStation mWorkStation;

    public HttpRunnable(HttpRequest httpRequest, DoRequest request, WorkStation workStation) {
        this.mHttpRequest = httpRequest;
        this.mRequest = request;
        this.mWorkStation = workStation;

    }

    @Override
    public void run() {
        if (mHttpRequest == null) {
            return;
        }
        try {
            if (mRequest.getData() != null) {
                mHttpRequest.getBody().write(mRequest.getData());
            }
            HttpResponse response = mHttpRequest.execute();
            String contentType = response.getHeaders().getContentType();
            mRequest.setContentType(contentType);
            if (response.getStatus() != null) {
                if (response.getStatus().isSuccess()) {
                    String result = getData(response);
                    if (mRequest.getResponse() != null) {
                        mRequest.getResponse().success(mRequest, result);
                    }
                } else {
                    if (mRequest.getResponse() != null) {
                        mRequest.getResponse().fail(response.getStatus().getCode(), response.getStatusMsg());
                    }
                }
            }
        } catch (Exception e) {
            if (mRequest.getResponse() != null) {
                mRequest.getResponse().fail(911, e.getMessage());
            }
            e.printStackTrace();
        } finally {
            mWorkStation.finish(mRequest);
        }


    }

    public String getData(HttpResponse response) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len;
        byte[] data = new byte[512];
        try {
            while ((len = response.getBody().read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toString();
    }
}
