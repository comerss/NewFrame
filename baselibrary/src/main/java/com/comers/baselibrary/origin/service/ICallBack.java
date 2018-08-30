package com.comers.baselibrary.origin.service;

/**
 * @author nate
 */

public abstract class ICallBack<T> {

    public abstract void success(DoRequest request, T data);

    public abstract void fail(int code, String msg);

}
