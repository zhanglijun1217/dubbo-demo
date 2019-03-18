package javabean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 夸克
 * @date 2019/3/18 00:11
 */
@Data
@Accessors(chain = true)
public class UserAddress implements Serializable {

    private Long addressId;
    private String addressNo;
    private String addressStr;
    private String userName;
    private Long userId;
}
