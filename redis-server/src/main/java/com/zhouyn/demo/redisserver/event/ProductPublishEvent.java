package com.zhouyn.demo.redisserver.event;

import lombok.Data;

/**
 * @author zhouyn
 * @date 2021年05月11日 下午2:30
 */
@Data
public class ProductPublishEvent {
    Long productId;
}
