package com.zhouyn.demo.serviceConsumer.controller;

import com.zhouyn.demo.serviceConsumer.entity.User;
import com.zhouyn.demo.serviceConsumer.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Hello Spring Cloud -- Product Controller
 *
 * @author zhouyn(zhouyannian @ 163.com)
 * @data 2019年4月24日下午10点45分
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在/users下
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "获取用户列表")
    @GetMapping
    public List<User> getUserList() {
        return userService.findAll();
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @PostMapping
    public User postUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @PutMapping
    public User putUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable Long id) {
         userService.deleteUser(id);
         return "success";
    }

    @GetMapping(value = "/redis")
    public String getKeys(){
        return redisTemplate.keys("*").toString();
    }

    @GetMapping(value = "/redis/{key}")
    public String getValue(@PathVariable String key){
        return redisTemplate.opsForValue().get(key).toString();
    }
}
