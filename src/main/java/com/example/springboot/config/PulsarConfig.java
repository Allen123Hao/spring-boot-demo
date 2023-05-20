package com.example.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <code>PulsarConfig</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/19
 * @version: 1.0
 */
@Slf4j
@Configuration
public class PulsarConfig {

    @Value("${pulsar.service-url}")
    private String serviceUrl;

    @Bean
    public PulsarClient pulsarClient(){
        log.debug("debug level,serviceUrl:{}",serviceUrl);
        log.info("info level,serviceUrl:{}",serviceUrl);
        try {
            return PulsarClient.builder()
                    .serviceUrl(serviceUrl)
                    .build();
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        }
    }
}
