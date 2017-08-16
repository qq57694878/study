package ljl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/27.
 */
public class ThreadLocalTest
{
    public static void main(String[] args) {
        ThreadLocal local = new ThreadLocal();
        Map m = new HashMap();
        m.put("1","1");
        local.set(m);
        Run1 run1 = new Run1(local);
        run1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(local.get());

    }
}
class Run1 extends Thread{
    public Run1(ThreadLocal t) {
        this.t = t;
    }

    private ThreadLocal t;

    @Override
    public void run() {
        System.out.println(this.getName()+":"+t.get());
        Map m = new HashMap();
        m.put("2","2");
        t.set(m);
    }
}
