package com.lsm.feigndemo.config;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 16:45
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeignCall {
    String url();
    String[] method() default {};

    String METHOD_GET = "GET";
    String METHOD_POST = "POST";
    String METHOD_DELETE = "DELETE";
    String METHOD_UPDATE = "UPDATE";
}
