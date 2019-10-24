package com.lsm.feigndemo.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lsm.feigndemo.config.FeignCall;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 18:09
 */

public class FeignDemoClientProxy implements InvocationHandler {
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        final FeignCall annotation = method.getAnnotation(FeignCall.class);
        if(annotation == null){
            System.out.println("没有调用配置");
            return null;
        }else {
            String info = String.format("%s %s", annotation.method()[0], annotation.url());
            System.out.println("-------info---" + info);
            return info;
        }

    }
}

