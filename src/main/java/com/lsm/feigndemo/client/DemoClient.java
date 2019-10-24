package com.lsm.feigndemo.client;

import com.lsm.feigndemo.config.FeignCall;
import com.lsm.feigndemo.config.FeignDemoClient;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 18:03
 */

@FeignDemoClient
public interface DemoClient {
    /**
     * 打印名称
     * @param name 名称
     * @return
     */
    @FeignCall(url = "http://www.baidu.com",method = FeignCall.METHOD_GET)
    String printHello(String name);
}
