package service.user;

import javabean.UserAddress;
import lombok.SneakyThrows;

import java.util.List;

/**
 *  provider中userService的本地存根
 *
 *
 * @author 夸克
 * @date 2019/3/26 00:20
 */
public class UserServiceStub implements UserService {

    /**
     * userService的一个定义 必须有一个有参数构造函数，承接proxy对象
     */
    private final   UserService userService;

    public UserServiceStub(UserService userService) {
        super();
        this.userService = userService;
    }

    @SneakyThrows
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        // TODO 可以做容错处理、可以做ThreadLocal做线程缓存
        // 可以在这里做参数校验
        System.out.println("调用了服务的本地存根。。。");

        if (userId.length() < 3) {
            return null;
        }
        // 符合校验再进行远程接口的调用
        return userService.getUserAddressList(userId);
    }
}




