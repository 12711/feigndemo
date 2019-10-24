package com.lsm.feigndemo.config;

import com.lsm.feigndemo.factory.FeignDemoRegisterBean;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 16:45
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({FeignDemoRegisterBean.class})
public @interface EnableFeignDemoClient {
    // 扫描的包
   String[] basePackages() default {} ;
}
