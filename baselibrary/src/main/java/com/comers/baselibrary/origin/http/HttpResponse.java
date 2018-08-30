package com.comers.baselibrary.origin.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author nate
 */
public interface HttpResponse extends Header, Closeable {

    HttpStatus getStatus();

    String getStatusMsg();

    InputStream getBody() throws IOException;

    void close();

    long getContentLength();

}
