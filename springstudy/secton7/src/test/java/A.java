
import com.ljl.config.AppConfig;
import com.ljl.config.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/8/14/014.
 */
public class A {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.scan("ljl");
       // ctx.refresh();
        MyService myService = ctx.getBean(MyService.class);
        myService.doStuff();
    }
}
