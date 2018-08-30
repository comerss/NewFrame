package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpMethod;
import com.comers.baselibrary.origin.http.HttpRequest;

import java.io.IOException;
import java.net.URI;

/**
 * @author nate
 */

public interface HttpRequestFactory {

    HttpRequest createHttpRequest(URI uri, HttpMethod method) throws IOException;
}
