package com.example.springboot.controller;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <code>PulsarTestController</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/19
 * @version: 1.0
 */
@Slf4j
@RequestMapping("message")
@RestController
public class PulsarTestController {

    @Autowired
    private PulsarClient pulsarClient;

    @GetMapping("send")
    public String sendMessage(){
        Producer<String> producer = null;
        try {
            producer = pulsarClient.newProducer(Schema.STRING)
                    .topic("my-topic")
                    .create();
            producer.send("This is my first message.");
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                producer.close();
            } catch (PulsarClientException e) {
                throw new RuntimeException(e);
            }
        }
        return "success";
    }

    @GetMapping("receive")
    public String receiveMessage(){
        Consumer<String> consumer = null;
        Message<String> message = null;
        try {
            consumer = pulsarClient.newConsumer(Schema.STRING)
                    .topic("my-topic")
                    .subscriptionName("my-subscription")
                    .subscribe();
            message = consumer.receive();
            consumer.acknowledge(message);
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                consumer.close();
            } catch (PulsarClientException e) {
                throw new RuntimeException(e);
            }
        }
        log.info("receive message:{}", JSONUtil.toJsonStr(message));
        return message.getValue();
    }
}
