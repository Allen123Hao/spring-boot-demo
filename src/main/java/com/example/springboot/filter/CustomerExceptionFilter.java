package com.example.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * <code>CustomerExceptionFilter</code>
 *
 * @description:
 * @author: Hao Xueqiang
 * @creation: 2023/5/20
 * @version: 1.0
 */
@Slf4j
@Activate(group = CommonConstants.PROVIDER,value = "CustomerExceptionFilter",order = 300)
public class CustomerExceptionFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        log.info("调用过滤器CustomerExceptionFilter");
        Result result = invoker.invoke(invocation);
        return result;
    }
}
