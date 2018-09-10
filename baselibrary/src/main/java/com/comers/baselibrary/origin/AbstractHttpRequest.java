package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpHeader;
import com.comers.baselibrary.origin.http.HttpRequest;
import com.comers.baselibrary.origin.http.HttpResponse;

import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author nate
 */

public abstract class AbstractHttpRequest implements HttpRequest {

    private static final String GZIP = "gzip";

    private HttpHeader mHeader = new HttpHeader();

    private ZipOutputStream mZip;

    private boolean executed;

    @Override
    public HttpHeader getHeaders() {
        return mHeader;
    }

    @Override
    public OutputStream getBody() {
        OutputStream body = getBodyOutputStream();
        if (isGzip()) {
            return getGzipOutStream(body);
        }
        return body;
    }

    private OutputStream getGzipOutStream(OutputStream body) {
        if (this.mZip == null) {
            this.mZip = new ZipOutputStream(body);
        }
        return mZip;
    }

    private boolean isGzip() {

        String contentEncoding = getHeaders().getContentEncoding();
        if (GZIP.equals(contentEncoding)) {
            return true;
        }
        return false;
    }

    @Override
    public HttpResponse execute() throws Exception {
        if (mZip != null) {
            mZip.close();
        }
        HttpResponse response = executeInternal(mHeader);
        executed = true;
        return response;
    }

    protected abstract HttpResponse executeInternal(HttpHeader mHeader) throws Exception;

    protected abstract OutputStream getBodyOutputStream();
}
