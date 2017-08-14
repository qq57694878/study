package com.ljl.section1_6;

import com.ljl.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created by Administrator on 2017/8/10/010.
 */
public class TestOne extends TestBase {
    @Test
    public void testOne(){
        ApplicationContext applicationContext  = this.applicationContext;
        ServiceStaticFactory serviceStaticFactory = applicationContext.getBean("ServiceStaticFactory",ServiceStaticFactory.class);
        serviceStaticFactory.sayHello();
        ServiceA serviceA = applicationContext.getBean("ServiceA",ServiceA.class);
        serviceA.sayHello();
        ServiceA serviceb = applicationContext.getBean("ServiceA1",ServiceA.class);
        serviceb.sayHello1();
        ExampleBean exampleBean = applicationContext.getBean("exampleBean",ExampleBean.class);
        exampleBean.sayHello();
        ExampleBean exampleBean1 = applicationContext.getBean("exampleBean1",ExampleBean.class);
        exampleBean1.sayHello();

        Foo foo = applicationContext.getBean("foo",Foo.class);
        foo.sayHello();

        ComplexBean complexBean = applicationContext.getBean("complexBean",ComplexBean.class);
        System.out.println(complexBean);

        Foo fooc = applicationContext.getBean("fooc",Foo.class);
        fooc.sayHello();
    }
    @Autowired
    private CommandManager commandManager;
    @Test
    public void test2(){
     /*   ApplicationContext applicationContext  = this.applicationContext;
        CommandManager c = applicationContext.getBean("commandManager",CommandManager.class);
        */commandManager.process();
    }
}
