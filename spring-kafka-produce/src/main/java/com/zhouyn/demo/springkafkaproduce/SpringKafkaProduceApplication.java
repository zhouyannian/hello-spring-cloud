package com.zhouyn.demo.springkafkaproduce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringKafkaProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaProduceApplication.class, args);
    }

}
