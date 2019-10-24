package com.lsm.feigndemo.controller;

import com.lsm.feigndemo.client.DemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author lvshaoming 2019/10/23 18:16
 */
@RequestMapping(value = "/v1/print-name")
@RestController
public class TestController {

    @Autowired
    private DemoClient demoClient;

    @GetMapping
    public String printName(@RequestParam("name") String name){
        try {
            return demoClient.printHello(name);
        }catch (UndeclaredThrowableException e){
            e.getCause().printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return "";
    }
}
