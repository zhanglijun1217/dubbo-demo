package com.zhanglijun.demo.bootuserserviceprovider.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
@Activate(group = Constants.PROVIDER, order = Integer.MIN_VALUE)
public class HelloFilter implements Filter {

    /**
     * 注意在META-INF 下注册SPI加载的文件的时候 要新建META-INF 再新建dubbo目录 再去建com.alibaba.dubbo.rpc.Filter文件
     * 直接去建立 META-INF.dubbo 会导致filter文件不加载
     * @param invoker
     * @param invocation
     * @return
     * @throws RpcException
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("filter调用了");
        return invoker.invoke(invocation);
    }
}
