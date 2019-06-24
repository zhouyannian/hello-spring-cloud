package com.zhouyn.demo.kafkaConsumer.model;

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
