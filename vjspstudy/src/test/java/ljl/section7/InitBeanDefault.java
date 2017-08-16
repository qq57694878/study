package ljl.section7;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/11/011.
 */
@Component
public class InitBeanDefault {
    private String a;
    public void init(){
        this.a="init";
    }
    public void destroy(){
        System.out.println("InitBeanDefault destroy");
    }
    public void sayHello(){
        System.out.println(this.a);
    }
}
