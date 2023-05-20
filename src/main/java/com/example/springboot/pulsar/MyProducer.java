package com.example.springboot.pulsar;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.Schema;

/**
 * <code>Producer</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/20
 * @version: 1.0
 */
@Slf4j
public class MyProducer {

    public static void main(String[] args) {
        String serviceUrl = "pulsar://localhost:6650";
        PulsarClient pulsarClient = null;
        Producer<String> producer = null;
        try {
            pulsarClient = PulsarClient.builder()
                    .serviceUrl(serviceUrl)
                    .build();
            producer = pulsarClient.newProducer(Schema.STRING)
                    .producerName("produce-test")
                    .topic("my-topic")
                    .create();
            producer.send("hello world!");
            log.info("send success");
        } catch (PulsarClientException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                pulsarClient.close();
                producer.close();
            } catch (PulsarClientException e) {
                throw new RuntimeException(e);
            }
        }
    }}
