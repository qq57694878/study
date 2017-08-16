package ljl.thinking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1/001.
 */
public class Fanxing {
    public static void main(String[] args)  {
        List<Fruit> list = new ArrayList<Fruit>();
        list.add(new Apple());
        Object o = new Object();
        HashMap m = new HashMap<>();
        m.put(new Fruit(),"1");
        String s="";

        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("start....");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println("finally");
                }
                System.out.println("end....");
            }
        };
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
    }


}
class Fruit{

}
class Apple extends Fruit{

}