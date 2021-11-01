package com.zhouyn.demo.springkafkaconsumer.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhouyn
 * @date 2021年10月25日 下午3:58
 */
@Slf4j
@Component
public class AvgLatencyConsumerInterceptor implements ConsumerInterceptor<String, String> {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> consumerRecords) {
        long latency = 0L;
        for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
            latency += (System.currentTimeMillis() - consumerRecord.timestamp());
        }
        redisTemplate.opsForValue().increment("totalLatency", latency);
        long totalLatency = Long.parseLong(redisTemplate.opsForValue().get("totalLatency").toString());
        long totalSentMsgs = Long.parseLong(redisTemplate.opsForValue().get("totalSentMessage").toString());
        redisTemplate.opsForValue().set("avgLatency", String.valueOf(totalLatency / totalSentMsgs));
        return consumerRecords;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        log.info("消息消费延时:{}", redisTemplate.opsForValue().get("avgLatency"));
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
