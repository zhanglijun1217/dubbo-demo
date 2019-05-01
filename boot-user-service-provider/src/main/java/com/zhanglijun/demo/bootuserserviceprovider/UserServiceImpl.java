package com.zhanglijun.demo.bootuserserviceprovider;

import com.alibaba.dubbo.config.annotation.Service;
import javabean.UserAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import service.user.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夸克
 * @date 2019/3/18 00:15
 */
//@Service(version = "boot-1.0.0") /** 这里使用xml的配置 服务提供者 */

//@Component
//@Service// 这个是为了 配合第三种spring boot dubbo整合方式  利于dubboComponentScan扫描到这个dubbo服务
    @Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        System.out.println(Thread.currentThread().getName() + " 调用到了消费者");
        log.info("愤怒，windows为啥不显示表情");
        final UserAddress userAddress1 = new UserAddress()
                .setUserId(1L)
                .setAddressId(1L)
                .setAddressNo("123")
                .setAddressStr("庆丰大街")
                .setUserName("小张");

        final UserAddress userAddress2  = new UserAddress()
                .setUserId(1L)
                .setAddressId(2L)
                .setAddressNo("456")
                .setAddressStr("西湖")
                .setUserName("小王");

        return new ArrayList<UserAddress>(){{
            add(userAddress1);
            add(userAddress2);
        }};
    }
}
