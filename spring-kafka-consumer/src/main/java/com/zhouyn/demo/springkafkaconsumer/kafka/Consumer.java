package com.zhouyn.demo.springkafkaconsumer.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author zhouyn
 * @date 2021年10月25日 下午2:34
 */
@Slf4j
@Component
public class Consumer {

//    @Autowired
//    org.apache.kafka.clients.consumer.KafkaConsumer

    @KafkaListener(topics = {"USER-DATA"}, groupId = "user-service")
    public void consumer(String msg, KafkaConsumer consumer) {
        log.info("消费者1接收到消息:{}", msg);
        try {
            Thread.sleep(8000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        consumer.commitAsync((map, e) -> {
            if (Objects.isNull(e)) {
                log.info("消费者1提交位移:{}", map);
            } else {
                log.error("提交位移失败:" + e);
            }
        });
    }

    @KafkaListener(topics = {"USER-DATA"}, groupId = "user-service")
    public void consumer_2(String msg, KafkaConsumer consumer) {
        log.info("消费者2接收到消息:{}", msg);
        consumer.commitSync();
    }
}
