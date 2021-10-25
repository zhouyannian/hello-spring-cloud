package com.zhouyn.demo.kafkaConsumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author zhouyn
 * @date 2021年10月25日 上午11:49
 */

@Component
public class KafkaConsumerRunner implements Runnable {
    private final AtomicBoolean closed = new AtomicBoolean(false);

    @Autowired
    private KafkaConsumer consumer;

    @Override
    public void run() {
        try {
            consumer.subscribe(Arrays.asList("USER-DATA"));
            while (!closed.get()) {
                ConsumerRecords records = consumer.poll(10000L);
                records.forEach(System.out::println);

            }
        } catch (WakeupException e) { // Ignore exception if closing
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }
}
