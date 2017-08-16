package ljl.section1_6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/9/009.
 */
public class Beanttt {
    public static void main(String[] args) {
        ApplicationContext applicationContext  = new ClassPathXmlApplicationContext(new String[]{"classpath:/spring/ctx-servers.xml"});
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
        List<Integer> list= new ArrayList<Integer>();
        for (int i = 0; i <3 ; i++) {
            list.add(i);
        }
        for(int i:list){
            list.set(i,1);
        }
        ComplexBean complexBean = applicationContext.getBean("complexBean",ComplexBean.class);
        System.out.println(complexBean);

        Foo fooc = applicationContext.getBean("fooc",Foo.class);
        fooc.sayHello();
    }
}
