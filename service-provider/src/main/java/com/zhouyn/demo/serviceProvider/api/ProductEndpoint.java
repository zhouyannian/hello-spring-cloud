package com.zhouyn.demo.serviceProvider.api;

import com.zhouyn.demo.serviceProvider.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello Sprin Cloud -- Product Service
 *
 * @author zhouyn(zhouyannian @ 163.com)
 * @data 2019年4月24日下午10点45分
 * @since 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductEndpoint {
    protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list() {
        return this.buildProducts();
    }

    @RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable String itemCode) {
        List<Product> products = this.buildProducts();
        for (Product product : products) {
            if (product.getItemCode().equalsIgnoreCase(itemCode)) {
                return product;
            }
        }
        return null;
    }

    protected List<Product> buildProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("item-1", "测试商品-1", "Hello,SpringCloud", 100));
        products.add(new Product("item-2", "测试商品-2", "Hello,SpringCloud", 200));
        products.add(new Product("item-3", "测试商品-3", "Hello,SpringCloud", 300));
        products.add(new Product("item-4", "测试商品-4", "Hello,SpringCloud", 400));
        products.add(new Product("item-5", "测试商品-5", "Hello,SpringCloud", 500));
        products.add(new Product("item-6", "测试商品-6", "Hello,SpringCloud", 600));
        return products;
    }
}
