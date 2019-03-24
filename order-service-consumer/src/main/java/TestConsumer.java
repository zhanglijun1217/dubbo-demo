import lombok.SneakyThrows;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.order.OrderService;

/**
 * @author 夸克
 * @date 2019/3/18 15:22
 */
public class TestConsumer {

    @SneakyThrows
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");

        // 启动spring环境
        applicationContext.start();
//
        // 拿到orderService这个bean
        OrderService bean = applicationContext.getBean(OrderService.class);

        // 测试是否调用了远程接口
        bean.initOrder();

        System.in.read();
    }
}
