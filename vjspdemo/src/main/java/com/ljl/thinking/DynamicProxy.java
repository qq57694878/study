package com.ljl.thinking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by Administrator on 2017/7/12/012.
 */
public class DynamicProxy {

    public static void main(String[] args) {
        Inter interImpl = new InterImpl();
        DynamicProxy d = new DynamicProxy();
        Inter inter = (Inter)Proxy.newProxyInstance(Inter.class.getClassLoader(), new Class[]{Inter.class},d.new DynamicInvocationHandler(interImpl) );
        inter.p("1");
    }
     class DynamicInvocationHandler implements InvocationHandler{
        public DynamicInvocationHandler(Inter inter) {
            real = inter;
        }
        private Inter real;

        @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("p prefix");
                Object r = method.invoke(real,args);
                System.out.println("p suffix");
            System.out.println("1111111111111111111111111111111111".hashCode());
                return r;
            }
    }

}
