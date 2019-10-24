package com.lsm.feigndemo.config;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 16:45
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeignDemoClient {
}
