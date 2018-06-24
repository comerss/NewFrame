package com.comers.baselibrary.http;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Comers on 2017/10/28.
 */

public class ParameterizedTypeImpl implements ParameterizedType {
    private final Class raw;
    private final java.lang.reflect.Type[] args;

    public ParameterizedTypeImpl(Class raw, java.lang.reflect.Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new java.lang.reflect.Type[0];
    }

    @Override
    public java.lang.reflect.Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public java.lang.reflect.Type getRawType() {
        return raw;
    }

    @Override
    public java.lang.reflect.Type getOwnerType() {
        return null;
    }
}
