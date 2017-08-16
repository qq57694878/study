package ljl.section7;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/8/11/011.
 */
@Component
@Scope("prototype")
@Lazy
public class InitBean implements InitializingBean,DisposableBean{
    private String a;
    @Override
    public void afterPropertiesSet() throws Exception {
         this.a="init";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InitBean destory!");
    }
    public void sayHelle(){
        System.out.println(this.a);
    }
}
