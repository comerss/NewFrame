package com.comers.baselibrary.origin.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * @author nate
 */

public interface HttpRequest extends Header {

    HttpMethod getMethod();

    URI getUri();

    OutputStream getBody();

    HttpResponse execute() throws IOException;

}
