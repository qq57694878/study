package ljl.section7;

/**
 * Created by Administrator on 2017/8/11/011.
 */
public class InitBeanXml {
    private String a;

    public void init() throws Exception {
        this.a="init";
    }

    public void destroy() throws Exception {
        System.out.println("InitBeanXml destory!");
    }
    public void sayHelle(){
        System.out.println(this.a);
    }
}
