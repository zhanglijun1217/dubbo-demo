package com.zhanglijun.demo.bootuserserviceprovider.config;

import com.alibaba.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import service.user.UserService;

import java.util.ArrayList;

/**
 * @author 夸克
 * @date 2019/3/27 23:44
 */
@Configuration
public class DubboProviderConfig {

    /**
     *   对应的配置：  <dubbo:application name="dubbo-demo"  />
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo");

        return applicationConfig;
    }

    /**
     *  对应的配置   <dubbo:registry address="zookeeper://127.0.0.1:2181" />
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        return registryConfig;
    }

    /**
     * 对应的配置 <dubbo:protocol name="dubbo" port="20882" />
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);

        return protocolConfig;
    }

    /**
     * 对应的配置：
     * <dubbo:service interface="service.user.UserService" ref="userService" timeout="2000" retries="3"
     *                    version="boot-1.0.0" stub="service.user.UserServiceSub">
     *         <!--引用方法级别 timeout会优先生效-->
     *         <!--<dubbo:method name="getUserAddressList" timeout="500"/>-->
     *     </dubbo:service>
     *
     *
     * @Param UserService 会自动注入对应的userService实现
     * @return
     */
    @Bean
    @Primary
    public ServiceConfig<UserService> serviceServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceServiceConfig = new ServiceConfig<>();
        serviceServiceConfig.setInterface(UserService.class);
        serviceServiceConfig.setRef(userService);

        // fixme 这种设置 版本、本地存根、重试次数 是无效的？
        serviceServiceConfig.setVersion("boot-1.0.0");
        serviceServiceConfig.setStub("service.user.UserServiceSub");
        serviceServiceConfig.setRetries(3);

        // 为serviceConfig加入MethodConfig
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(500);

        serviceServiceConfig.setMethods(new ArrayList<MethodConfig>(){{
            add(methodConfig);
        }});

        return serviceServiceConfig;
    }

}
