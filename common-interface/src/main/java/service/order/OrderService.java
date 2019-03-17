package service.order;

/**
 * 订单的接口  consumer对应的接口
 *  有一个初始化订单的方法 这个作为dubbo中的consumer 调用用户服务
 * @author 夸克
 * @date 2019/3/18 00:07
 */
public interface OrderService {

    boolean initOrder();
}
