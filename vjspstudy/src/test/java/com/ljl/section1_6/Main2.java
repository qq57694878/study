package com.ljl.section1_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/8/9/009.
 */
public class Main2 {
    public static void main(String[] args) {
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext(new String[]{"spring/ctx-servers.xml"});
        Server server = (Server) applicationContext.getBean("server");
        server.sayHello();
        A a =  applicationContext.getBean("com.ljl.section1_6.A",A.class);
        a.sayHello();
        B b = (B) applicationContext.getBean("com.ljl.section1_6.B");
        b.sayHello();
        C c = (C) applicationContext.getBean("com.ljl.section1_6.C");
        c.sayHello();

 /*        applicationContext  = new AnnotationConfigApplicationContext();
        com.ljl.section1_6.ServerAnotation server1 = (com.ljl.section1_6.ServerAnotation) applicationContext.getBean("com.ljl.section1_6.ServerAnotation");
        server1.sayHello();*/
    }
}
