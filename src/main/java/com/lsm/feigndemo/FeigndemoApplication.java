package com.lsm.feigndemo;

import com.lsm.feigndemo.config.EnableFeignDemoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignDemoClient(basePackages = {"com.lsm.feigndemo.client"})
public class FeigndemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeigndemoApplication.class, args);
    }

}
