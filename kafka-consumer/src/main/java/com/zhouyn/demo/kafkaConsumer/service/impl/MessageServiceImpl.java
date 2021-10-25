package com.zhouyn.demo.kafkaConsumer.service.impl;

import com.zhouyn.demo.kafkaConsumer.kafka.KafkaConsumerRunner;
import com.zhouyn.demo.kafkaConsumer.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhouyn
 * @date 2021年10月25日 下午1:51
 */
public class MessageServiceImpl implements MessageService {

    @Autowired
    KafkaConsumerRunner kafkaConsumerRunner;

    @Override
    public void consumer() {
        kafkaConsumerRunner.run();
    }


    public static void main(String[] args) {
        new KafkaConsumerRunner().run();
    }
}
