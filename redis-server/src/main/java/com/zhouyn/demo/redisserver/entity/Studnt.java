package com.zhouyn.demo.redisserver.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouyn
 * @date 2021年09月08日 下午4:42
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Studnt {

    private Long id;

    private String name;

    private User user;
}
