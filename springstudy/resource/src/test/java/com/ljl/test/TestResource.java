package com.ljl.test;

import com.ljl.dao.TaDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/8/15/015.
 */
public class TestResource {

    @Test
    public void testUrlResource(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath*:spring/ctx-framework.xml");
        TaDao a= ctx.getBean(TaDao.class);
      a.sayHell();
       /* B b= ctx.getBean(B.class);*/
  /*      Resource template = ctx.getResource("classpath*:spring/ctx-framework.xml");
        Resource template1 = ctx.getResource("file:///spring/ctx-framework.xml");
        Resource template2 = ctx.getResource("http://localhost/E%3A/Everything.ini");*/
        System.out.println("12222222222");
    }
}
