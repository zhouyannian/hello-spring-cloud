package com.zhouyn.demo.serviceConsumer.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

@Slf4j
public class UserMsgSender {

    private Source source;

    public UserMsgSender(Source source) {
        this.source = source;
    }

    public void sendMsg(UserMsg userMsg) {
        log.debug("发送用户消息：{}", userMsg);

        this.source.output().send(MessageBuilder.withPayload(userMsg).build());
    }
}
