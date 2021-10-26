package com.zhouyn.demo.springkafkaproduce.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/message")
public class MessageApi {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final String TOPIC_NAME = "USER-DATA";

    @GetMapping(value = "/{partition}/{message}")
    public void sendMessage(@PathVariable("partition") String partition,
                            @PathVariable("message") String message) {
        kafkaTemplate.send(TOPIC_NAME, Integer.parseInt(partition), partition, message);
        log.info("向主题[{}]的分区[{}]发送消息：{}", TOPIC_NAME, partition, message);
    }
}
