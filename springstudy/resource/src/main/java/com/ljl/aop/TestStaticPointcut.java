package com.ljl.aop;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

class TestStaticPointcut extends StaticMethodMatcherPointcut {

    public boolean matches(Method m, Class targetClass) {
        return true;
    }
}