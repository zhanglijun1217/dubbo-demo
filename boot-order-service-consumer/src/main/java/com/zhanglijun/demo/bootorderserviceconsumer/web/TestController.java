package com.zhanglijun.demo.bootorderserviceconsumer.web;

import javabean.UserAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.order.OrderService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 夸克
 * @date 2019/3/20 21:04
 */
@RestController
public class TestController {

    @Resource
    private OrderService orderService;

    @GetMapping(path = "/initOrder")
    public List<UserAddress> initOrder(@RequestParam("userId") String userId) {
        return orderService.initOrder(userId);
    }
}
