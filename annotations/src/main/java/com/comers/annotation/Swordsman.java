package com.comers.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * 注解根据  RetentionPolicy 生命周期策略也出现了不同的处理方案
 *
 * 例如 RetentionPolicy.CLASS 使用AbstractProcessor
 *     RetentionPolicy.RUNTIME 使用反射进行处理
 * */
@Retention(RetentionPolicy.RUNTIME)
public @interface Swordsman {
    String name() default "你的名字";

    int age() default 30;
}
