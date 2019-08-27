import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author 夸克
 * @date 2019/3/18 14:16
 */
public class TestProvider {

    public static void main(String[] args) throws Exception {
        // 加载spring配置
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("provider.xml");
        // 启动spring环境
        applicationContext.start();

        // 使程序hang住  不退出
        new CountDownLatch(1).await();
    }
}
