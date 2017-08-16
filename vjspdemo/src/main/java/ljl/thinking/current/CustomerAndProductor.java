package ljl.thinking.current;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public class CustomerAndProductor {
    private static AtomicInteger atomicInteger = new AtomicInteger();
    class Food{
        private String  name;

        public Food(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Food{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    class Customer implements Runnable{
        private MyBlockList<Food> container;
        private String name;

        public Customer(MyBlockList container,int i) {
            this.container = container;
            this.name = "customer"+i;
        }

        public Food custom(){
            System.out.println(this.name+"消费 start");
            Food d = this.container.get();
            System.out.println(this.container);
            try {
                System.out.println(this.name+"消费 实物:"+d+" ing");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name+"消费 实物:"+d+" end");
            return d;
        }

        @Override
        public void run() {
            while(!Thread.interrupted()){
                custom();
            }
        }
    }
     class Productor implements Runnable{
        private MyBlockList<Food> container;
        private String name;


        public Productor(MyBlockList container,int i) {
            this.container = container;
            this.name = "productor"+i;
        }

        public void product(){
            System.out.println(this.name+"生产 start");
            Food d = new Food("food"+atomicInteger.getAndIncrement());
            try {
                System.out.println(this.name+"生产 实物:"+d+" ing");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             this.container.put(d);
            System.out.println(this.container);
            System.out.println(this.name+"生产 实物:"+d+" end");
        }

        @Override
        public void run() {

                while(!Thread.interrupted()){
                    product();
                }

        }
    }
    class MyBlockList<T>{
        private T[] data;
        private  Lock lock = new ReentrantLock();
        private Condition empty= lock.newCondition();
        private Condition full= lock.newCondition();
        int index = -1;
        public MyBlockList (int size){
            data = (T[])new Object[size];

        }
         public void put(T o){
             lock.lock();
            try{
                while(index>=data.length-1){
                    full.await();
                }
                data[++index] = o;
                empty.signalAll();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

         }
        public T get (){
            lock.lock();
             T r = null;
            try{
                while(index<0){
                    empty.await();
                }
                r = data[index--];
                full.signalAll();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return r;
        }

        @Override
        public String toString() {
            return "MyBlockList{" +
                    "data=" + Arrays.toString(data) +
                    ", index=" + index +
                    '}';
        }
    }
    public static void main(String[] args) {
        CustomerAndProductor test = new CustomerAndProductor();
        ExecutorService service = Executors.newCachedThreadPool();
        MyBlockList<Food> blockList =  test.new MyBlockList<Food>(10);
        for(int i=0;i<3;i++){
            service.submit(test.new Customer(blockList,i));
            service.submit(test.new Productor(blockList,i));
        }


/*        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();*/


    }
}
