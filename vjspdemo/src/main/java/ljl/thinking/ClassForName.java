package ljl.thinking;


/**
 * Created by Administrator on 2017/7/12/012.
 */
public class ClassForName {
    public static void main(String[] args) throws Exception {
        Class ca=Class.forName("ljl.thinking.A");
        A a=(A)ca.newInstance();
        a.p("1");
        Class<? extends String> i = String.class;
        System.out.println(i.newInstance());
    }
}
