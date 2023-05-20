package com.example.springboot.service.impl;

import com.example.dubbo.client.DubboProviderService;
import com.example.dubbo.client.UserService;
import com.example.springboot.service.DubboTestService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <code>DubboProviderServiceImpl</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/20
 * @version: 1.0
 */
@Slf4j
@DubboService
public class DubboTestServiceImpl implements DubboTestService {

    @DubboReference
    private DubboProviderService dubboProviderService;

    @DubboReference
    private UserService userService;

    @Override
    public String provider(){
        log.info("this is dubbo test service.");
        String result = dubboProviderService.provider();
        log.info("dubbo result:{}",result);
        String user = userService.getUser();
        log.info("user result:{}",user);
        return "dubbo done";
    }
}
