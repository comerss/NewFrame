package com.comers.baselibrary.origin;


import com.comers.baselibrary.origin.http.HttpMethod;
import com.comers.baselibrary.origin.http.HttpRequest;

import java.io.IOException;
import java.net.URI;

/**
 * @author nate
 */

public class HttpRequestProvider {

    private HttpRequestFactory mHttpRequestFactory;

    public HttpRequestProvider() {
        mHttpRequestFactory = new OriginHttpRequestFactory();
    }

    public HttpRequest getHttpRequest(URI uri, HttpMethod httpMethod) throws IOException {
        return mHttpRequestFactory.createHttpRequest(uri, httpMethod);
    }

    public HttpRequestFactory getHttpRequestFactory() {
        return mHttpRequestFactory;
    }

    public void setHttpRequestFactory(HttpRequestFactory httpRequestFactory) {
        mHttpRequestFactory = httpRequestFactory;
    }
}
