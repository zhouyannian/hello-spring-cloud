package com.zhouyn.demo.redisserver.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PicResponse {
    Class<? extends Result> value() default PicResult.class;
}
