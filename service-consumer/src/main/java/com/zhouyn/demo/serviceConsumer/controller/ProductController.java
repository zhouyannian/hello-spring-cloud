package com.zhouyn.demo.serviceConsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhouyn.demo.serviceConsumer.service.ProductService;
import com.zhouyn.demo.serviceProvider.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hello Sprin Cloud -- Product Controller
 *
 * @author zhouyn(zhouyannian@163.com)
 * @data 2019年4月24日下午10点45分
 * @since 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {

        return this.productService.findAll();
    }

    @HystrixCommand(fallbackMethod = "detailForback")
    @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
    public Product detail(@PathVariable String itemCode) {
        return this.productService.loadByItemCode(itemCode);
    }

    public Product detailForback(String itemCode) {
        Product product = new Product("0001","service-consumer", "Hystrix断路器",9999);
        return product;
    }
}
