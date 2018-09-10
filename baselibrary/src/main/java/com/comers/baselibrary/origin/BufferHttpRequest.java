package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpHeader;
import com.comers.baselibrary.origin.http.HttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * @author nate
 */

public abstract class BufferHttpRequest extends AbstractHttpRequest {

    private ByteArrayOutputStream mByteArray = new ByteArrayOutputStream();

    protected OutputStream getBodyOutputStream() {
        return mByteArray;
    }

    protected HttpResponse executeInternal(HttpHeader header) throws Exception {
        byte[] data = mByteArray.toByteArray();
        return executeInternal(header, data);
    }

    protected abstract HttpResponse executeInternal(HttpHeader header, byte[] data) throws Exception;
}
