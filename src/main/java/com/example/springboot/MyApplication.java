package com.example.springboot;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.example.springboot")
public class MyApplication {

    public static void main(String[] args) {
        System.setProperty("dubbo.meta.cache.filePath", "/Users/haoxueqiang/data/dubbo1");
        System.setProperty("dubbo.mapping.cache.filePath", "/Users/haoxueqiang/data/dubbo1");
        SpringApplication.run(MyApplication.class, args);
    }

}
