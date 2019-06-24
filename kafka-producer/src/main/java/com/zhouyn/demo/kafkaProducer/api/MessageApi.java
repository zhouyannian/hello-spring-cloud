package com.zhouyn.demo.kafkaProducer.api;

import com.zhouyn.demo.kafkaProducer.model.Message;
import com.zhouyn.demo.kafkaProducer.service.OutputMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Slf4j
@RestController
@RequestMapping(value = "/message")
public class MessageApi {

    @Autowired
    private OutputMessageService outputMessageService;

    @GetMapping(value = "/{message}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@PathVariable String message) {
        Message msg = Message.builder()
                .id(new Random().nextLong())
                .message(message)
                .build();
        outputMessageService.getOutput()
                .send(MessageBuilder.withPayload(msg)
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build());
        log.info("发送消息：{}", message);
    }
}
