package com.comers.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by 79653 on 2018/11/5.
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MainThread {
    boolean isMainThread() default false;
    String getThreadName() default "thread";
}
