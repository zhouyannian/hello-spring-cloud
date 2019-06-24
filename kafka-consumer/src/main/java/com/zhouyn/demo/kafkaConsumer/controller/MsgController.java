package com.zhouyn.demo.kafkaConsumer.controller;

import com.zhouyn.demo.kafkaConsumer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MsgController {

    @StreamListener("message-in")
    public void handleMessage(Message msg) {
        log.info("收到消息: [{}]", msg);
    }
}
