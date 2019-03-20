package com.zhanglijun.demo.bootorderserviceconsumer.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import javabean.UserAddress;
import org.springframework.stereotype.Service;
import service.order.OrderService;
import service.user.UserService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author 夸克
 * @date 2019/3/18 00:14
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Reference(version = "boot-1.0.0", timeout = 50000)
    private UserService userService;

    /**
     * 生成订单过程：
     *  调用远程接口 查询用户信息
     *  将用户信息去生成订单
     * @return
     */
    @Override
    public List<UserAddress> initOrder() {
        List<UserAddress> userAddressList = userService.getUserAddressList("1");
        if (null != userAddressList && userAddressList.size() > 0) {
            System.out.println("调用远程接口完成");

            Optional.of(userAddressList).ifPresent(System.out::println);
        }

        return userAddressList;
    }
}
