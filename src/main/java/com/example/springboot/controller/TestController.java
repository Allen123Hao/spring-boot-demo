package com.example.springboot.controller;

import com.example.springboot.service.DubboTestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>TestController</code>
 *
 * @description:
 * @author: Hao Xueqiang(haoxueqiang@58.com)
 * @creation: 2023/5/19
 * @version: 1.0
 */
@RestController
public class TestController {

    @Autowired
    private DubboTestService dubboTestService;

    @GetMapping("hello")
    public String test(){
        return "hello world";
    }

    @GetMapping("dubbo")
    public String testDubbo(){
        return dubboTestService.provider();
    }

}
