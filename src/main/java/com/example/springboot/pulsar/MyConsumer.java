package com.example.springboot.pulsar;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.*;

/**
 * <code>Consumer</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/20
 * @version: 1.0
 */
@Slf4j
public class MyConsumer {

    public static void main(String[] args) {
        String serviceUrl = "pulsar://localhost:6650";
        PulsarClient pulsarClient = null;
        Consumer<String> consumer = null;
        try {
            pulsarClient = PulsarClient.builder()
                    .serviceUrl(serviceUrl)
                    .build();
            consumer = pulsarClient.newConsumer(Schema.STRING)
                    .consumerName("consumer-test")
                    .topic("my-topic")
                    .subscriptionName("my-sub")
                    .subscribe();
            Message<String> message = consumer.receive();
            String content = message.getValue();
            consumer.acknowledge(message);
            log.info("content:{}",content);
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pulsarClient.close();
                consumer.close();
            } catch (PulsarClientException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
