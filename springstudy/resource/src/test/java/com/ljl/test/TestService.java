package com.ljl.test;

import com.ljl.Base.TestBase;
import com.ljl.aop.CountingBeforeAdvice;
import com.ljl.dao.TaDao;
import com.ljl.service.C;
import com.ljl.time.ExecutionTime;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/20/020.
 */
public class TestService  extends TestBase{
  /*  public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/ctx-framework.xml");
        C c = ac.getBean(C.class);
        c.sayHello();

    }*/
    @Autowired
    private C c;
    @Autowired
    private TaDao taDao;
    @Autowired
    private CountingBeforeAdvice countingBeforeAdvice;
    @Test
    public void testc(){
        c.sayHello();
    }
    @Autowired
    private ExecutionTime executionTime;
    @Test
    public void testTime(){
        executionTime.time1();
    }
    @Test
    public void testParam(){
        Map<String,String> m = new HashMap<String,String>();
        m.put("key1","value1");
        m.put("key2","value2");
        executionTime.param(m);
        Exception e;
    }
    @Test
    public void testTransactional(){
        taDao.save();
    }
    @Test
    public void getFoo(){
        executionTime.getFoo("name",10);
    }
    @Test
    public void countingBeforeAdvice(){
        taDao.save();
        executionTime.getFoo("name",10);
        System.out.println(countingBeforeAdvice.getCount());;
    }

}
