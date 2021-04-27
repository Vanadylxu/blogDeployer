package com.vanadyl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 用于需要记录访客访问日志的方法
 * @Author: Vanadyl
 * @Date: 2021-4-20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface VisitLogger {
    /**
     * 访问行为
     */
    String behavior() default "";

    /**
     * 访问内容
     */
    String content() default "";
}
