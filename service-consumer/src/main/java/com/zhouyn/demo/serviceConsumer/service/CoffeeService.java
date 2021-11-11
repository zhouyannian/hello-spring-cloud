package com.zhouyn.demo.serviceConsumer.service;

import com.zhouyn.demo.serviceProvider.entity.Coffee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Hello Sprin Cloud -- Product Service
 *
 * @author zhouyn(zhouyannian @ 163.com)
 * @data 2019年4月24日下午10点45分
 * @since 1.0.0
 */
@FeignClient(name = "service-provider")
public interface CoffeeService {

    @RequestMapping(value = "/coffee", method = RequestMethod.GET)
    List<Coffee> findAll();

    @RequestMapping(value = "/coffee/{id}", method = RequestMethod.GET)
    Coffee loadByItemCode(@PathVariable("id") String id);
}
