package com.zhouyn.demo.redisserver.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class AddImage2AliyunEvent extends ApplicationEvent {

    /**
     * 产品ID
     */
    private Long productId;

    public AddImage2AliyunEvent(Object source) {
        super(source);
    }
}