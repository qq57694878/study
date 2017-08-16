package com.ljl;

import org.springframework.cglib.proxy.Enhancer;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/8/15/015.
 */
public class DynimicTest {

    public static void main(String[] args) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(B.class);
        enhancer.setCallback(new BIntercepter());
        B b=(B) enhancer.create();
        b.method1(new HashMap<>());
        b.method2();
    }
}
