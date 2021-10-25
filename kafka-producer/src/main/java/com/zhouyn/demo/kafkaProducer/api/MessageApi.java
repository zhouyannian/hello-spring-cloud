package com.zhouyn.demo.kafkaProducer.api;

import com.zhouyn.demo.kafkaProducer.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import org.springframework.http.HttpStatus;

@Slf4j
@RestController
@RequestMapping(value = "/message")
public class MessageApi {

//    @Autowired
//    private OutputMessageService outputMessageService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "/{message}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public void sendMessage(@PathVariable String message) {
//        Message msg = Message.builder()
//                .id(new Random().nextLong())
//                .message(message)
//                .build();
//        outputMessageService.getOutput()
//                .send(MessageBuilder.withPayload(msg)
//                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                        .build());
        log.info("发送消息：{}", message);
    }

    @PostMapping(value = "/send")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        log.info("发送消息：{}", message);
    }
}
