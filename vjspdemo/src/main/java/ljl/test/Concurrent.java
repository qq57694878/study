package ljl.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
class AA {
    private String a;
    protected String b;
    public String c;

}

interface CC {
    String sayHello(String s);
}

class BB extends AA implements CC {
    private String bb;
    public String cc;


    @Override
    public String sayHello(String s) {
        System.out.println(s);
        return "aaa";
    }
}

class Worker implements Runnable {
    private CountDownLatch countDownLatch;
    private int i;

    public Worker(CountDownLatch countDownLatch, int i) {
        this.countDownLatch = countDownLatch;
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第" + i + "工人开始干活！");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("第" + i + "工人干完了！");
        countDownLatch.countDown();
    }
}
class P implements Callable{

    @Override
    public Object call() throws Exception {
        return "1";
    }
}
class Cus implements Runnable{
   private CyclicBarrier cyclicBarrier;

   private int i;

    public Cus(CyclicBarrier cyclicBarrier, int i) {
        this.cyclicBarrier = cyclicBarrier;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("第"+i+"开始干");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class SM implements Runnable{
    Semaphore semaphore;
    static AtomicInteger atomicInteger=new AtomicInteger(0);

    public SM(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            int i =atomicInteger.getAndIncrement();
            System.out.println("第"+i+" come in!");
            semaphore.acquire();
            System.out.println("第"+i+" 获得!");
            Thread.sleep(3000);
            semaphore.release();
            System.out.println("第"+i+" 释放!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Concurrent {
    public static void main(String[] args) throws Exception {
        test5();

    }
    public static void test5(){
        Semaphore semaphore = new Semaphore(2);
        ExecutorService executorService = Executors.newFixedThreadPool(11);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new SM(semaphore));
        }

    }
    public static void test4() throws InterruptedException {
        int n=10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);
        ExecutorService executorService = Executors.newFixedThreadPool(11);
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Cus(cyclicBarrier,i));
        }

    }
    public static void test3() throws InterruptedException {
        BlockingQueue b = new LinkedBlockingQueue(1);
        b.add(1);
        //b.add(2);
        b.take();
        b.put(2);
        b.take();

        System.out.println(b.size());

    }

    public static void test2() throws InterruptedException {
        int n = 10;
        java.util.concurrent.CountDownLatch countDownLatch = new CountDownLatch(n);
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < n; i++) {
           Future m = service.submit(new Worker(countDownLatch, i));
        }
      //  new Thread(new FutureTask<>(new P()));

        System.out.println("zhuxian gh");
            countDownLatch.await();
        System.out.println("all is over!");
    }

    public static void test1() {
        System.out.println("11");
        Field[] fields = BB.class.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        Field[] field1s = BB.class.getFields();
        System.out.println(Arrays.toString(field1s));
        Concurrent pp = new Concurrent();
        final BB bbb = new BB();
        CC dd = (CC) Proxy.newProxyInstance(BB.class.getClassLoader(), new Class[]{CC.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("pre");
                Object r = method.invoke(bbb, args);
                System.out.println("end");
                return r;
            }
        });
        String s = dd.sayHello("111");
        System.out.println(s);
    }

}
