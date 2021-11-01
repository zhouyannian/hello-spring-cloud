package com.zhouyn.demo.springkafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaConsumerApplication.class, args);
    }

}
