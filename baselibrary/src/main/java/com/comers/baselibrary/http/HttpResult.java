package com.comers.baselibrary.http;

import java.io.Serializable;

/**
 * Created by Comers on 2017/10/25.
 */

public class HttpResult<T> implements Serializable {
    public String msg;
    public boolean success=false;
    public int code=-1;
    public T data;

    @Override
    public String toString() {
        return "HttpResult{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
