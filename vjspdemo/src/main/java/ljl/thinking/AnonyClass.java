package ljl.thinking;

/**
 * Created by Administrator on 2017/7/12/012.
 */
public class AnonyClass {
    public static IOuter getOuter(int i){
        return new IOuter(i){
            @Override
            public void p(String s) {
                System.out.println(s+i);
            }
        };
    }

    public static void main(String[] args) {
       AnonyClass.getOuter(22).p("111");
    }
}
