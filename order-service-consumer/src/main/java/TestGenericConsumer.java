import com.alibaba.dubbo.common.utils.PojoUtils;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class TestGenericConsumer {

    @SneakyThrows
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        applicationContext.start();
        // 调用 泛化调用

        GenericService iGenericDemoService = (GenericService) applicationContext.getBean("iGenericDemoService");
        List getPersonAddressList = (ArrayList)iGenericDemoService.$invoke("getPersonAddressList", new String[]{String.class.getName()}, new Object[]{"张三"});

        HashMap hashMap = (HashMap) getPersonAddressList.get(0);
        System.out.println((hashMap).get("class"));
        System.out.println(hashMap.get("name"));
        System.out.println(hashMap.get("no"));
        System.out.println(hashMap.get("city"));

        new CountDownLatch(1).await();

    }
}
