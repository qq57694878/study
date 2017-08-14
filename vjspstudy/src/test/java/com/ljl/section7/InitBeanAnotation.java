package com.ljl.section7;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Administrator on 2017/8/11/011.
 */
@Component
public class InitBeanAnotation{
    private String a;
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
         this.a="init";
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("InitBeanAnotation destory!");
    }
    public void sayHelle(){
        System.out.println(this.a);
    }
}
