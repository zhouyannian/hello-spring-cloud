package com.zhouyn.demo.kafkaProducer.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private Long id;

    private String message;
}
