package com.ljl.glib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/8/15/015.
 */
public class BIntercepter implements MethodInterceptor{
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("prefix "+method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("subfix "+method.getName());
        return result;
    }
}
