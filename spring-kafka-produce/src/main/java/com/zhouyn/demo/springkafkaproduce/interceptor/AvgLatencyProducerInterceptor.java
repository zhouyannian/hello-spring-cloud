package com.zhouyn.demo.springkafkaproduce.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhouyn
 * @date 2021年10月25日 下午3:49
 */
@Component
public class AvgLatencyProducerInterceptor implements ProducerInterceptor<String, String> {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        redisTemplate.opsForValue().increment("totalSentMessage");
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
