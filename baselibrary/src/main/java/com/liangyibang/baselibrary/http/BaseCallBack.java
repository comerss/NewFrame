package com.liangyibang.baselibrary.http;

import java.lang.reflect.Type;

/**
 * Created by Comers on 2017/10/25.
 */

public abstract class BaseCallBack<T> {
    public abstract void onSuccess(HttpResult<T> sResult, String json);
    public abstract void onError(String msg);
    public Type getType() {//获取需要解析的泛型T类型
        return  new ParameterizedTypeImpl(HttpResult.class, new Type[]{FindTypeHelper.findNeedClass(getClass())});
    }

    public Type getRawType() {//获取需要解析的泛型T raw类型
        return FindTypeHelper.findRawType(getClass());
    }
}
