package service.user;

import javabean.UserAddress;

import java.util.List;

/**
 * provider对应的用户接口 用户服务
 *  这里有一个返回用户信息的接口 服务提供者
 * @author 夸克
 * @date 2019/3/18 00:09
 */
public interface UserService {

    List<UserAddress> getUserAddressList(String userId);
}
