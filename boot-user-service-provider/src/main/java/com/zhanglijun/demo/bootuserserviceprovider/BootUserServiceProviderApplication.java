package com.zhanglijun.demo.bootuserserviceprovider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * spring boot 整合 dubbo三种方式：
 * （1）导入dubbo-starter，在application.properties文件中配置dubbo的配置 使用@Service注解暴露服务（这个没办法实现方法级别的配置）
 * （2）导入dubbo-starter，保留dubbo-provider的配置文件，使用@ImportResource引入dubbo的配置文件 以此来加载xml中的method级别配置
 * （3）导入dubbo-starter，使用api编程的方式配置bean（这里的配置是按照xml中的配置写的对应的api）
 *        然后要用alibab.@Service暴露dubbo的服务   之后利用@DubboComponentScan扫描dubbo的服务类
 */


/**
 * 第一种整合方式
 */
@SpringBootApplication
@EnableDubbo

/**
 * 第二种整合方式
 */
@ImportResource(value = {"classpath:provider.xml"}) // 引入dubbo的配置文件 这里是第二种配置方式

/**
 * 第三种整合方式 扫描对应的config配置类 这里要将importResource注解注释掉
 */
//@EnableDubbo(scanBasePackages = {"com.zhanglijun.demo.bootuserserviceprovider"})

public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
