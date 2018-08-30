package com.comers.baselibrary.origin.service.convert;


import com.comers.baselibrary.origin.http.HttpResponse;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author nate
 */

public interface Convert {

    Object parse(HttpResponse response, Type type) throws IOException;

    boolean isCanParse(String contentType);

    Object parse(String content, Type type) throws IOException;
}
