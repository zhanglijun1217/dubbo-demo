import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestGenericApiConsumer {

    public static void main(String[] args) {
        // api方式来测试泛化调用
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo");

        // 注册中心
        RegistryConfig registryConfig  = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");
        applicationConfig.setRegistry(registryConfig);

        // 声明泛化调用的接口
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        // 弱类型接口名
        reference.setInterface("generic.IGenericDemoService");
        // 标识为泛化调用
        reference.setGeneric(true);

        reference.setApplication(applicationConfig);


        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();
        // 和 TestGenericConsumer 中的一样 调用$invoke方法即可
        List getPersonAddressList = (ArrayList)genericService.$invoke("getPersonAddressList", new String[]{String.class.getName()}, new Object[]{"张三"});

        HashMap hashMap = (HashMap) getPersonAddressList.get(0);
        System.out.println((hashMap).get("class"));
        System.out.println(hashMap.get("name"));
        System.out.println(hashMap.get("no"));
        System.out.println(hashMap.get("city"));
    }

}
