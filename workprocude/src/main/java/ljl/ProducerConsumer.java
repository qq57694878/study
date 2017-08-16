package ljl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java多线程模拟生产者消费者问题
 * 
 * ProducerConsumer是主类，Producer生产者，Consumer消费者，Product产品，Storage仓库
 * 
 * @author 林计钦
 * @version 1.0 2013-7-24 下午04:49:02
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Storage s = pc.new Storage();

       // ExecutorService service = Executors.newCachedThreadPool();
        Producer p = pc.new Producer("张三", s);
        Producer p2 = pc.new Producer("李四", s);
        Consumer c = pc.new Consumer("王五", s);
        Consumer c2 = pc.new Consumer("老刘", s);
        Consumer c3 = pc.new Consumer("老林", s);
        Thread tp1 = new Thread(p);
        tp1.start();
        Thread tp2 = new Thread(p2);
        tp2.start();
        Thread tc1 = new Thread(c);
        tc1.start();
        Thread tc2 = new Thread(c2);
        tc2.start();
        Thread tc3 = new Thread(c3);
        tc3.start();
 /*       service.submit(p);
        service.submit(p2);
        service.submit(c);
        service.submit(c2);
        service.submit(c3);*/
        
    }

    /**
     * 消费者
     * 
     * @author 林计钦
     * @version 1.0 2013-7-24 下午04:53:30
     */
    class Consumer implements Runnable {
        private String name;
        private Storage s = null;

        public Consumer(String name, Storage s) {
            this.name = name;
            this.s = s;
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(name + "准备消费产品.");
                    Thread.sleep(1000);
                    Product product = s.pop();
                    System.out.println(name + "已消费(" + product.toString() + ").");
                    System.out.println("===============");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * 生产者
     * 
     * @author 林计钦
     * @version 1.0 2013-7-24 下午04:53:44
     */
    class Producer implements Runnable {
        private String name;
        private Storage s = null;

        public Producer(String name, Storage s) {
            this.name = name;
            this.s = s;
        }

        public void run() {
            try {
                while (true) {
                    Product product = new Product((int) (Math.random() * 10000)); // 产生0~9999随机整数
                    System.out.println(name + "准备生产(" + product.toString() + ").");
                    Thread.sleep(1000);
                    s.push(product);
                    System.out.println(name + "已生产(" + product.toString() + ").");
                    System.out.println("===============");
                }
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

        }
    }

    /**
     * 仓库，用来存放产品
     * 
     * @author 林计钦
     * @version 1.0 2013-7-24 下午04:54:16
     */
  /*  public class Storage {
        BlockingQueue<Product> queues = new LinkedBlockingQueue<Product>(10);


        public void push(Product p) throws InterruptedException {
            queues.put(p);
        }


        public Product pop() throws InterruptedException {
            return queues.take();
        }
    }*/
    public class Storage {
        private final int BOOLSIZE = 10;
        private Storage(){
            queues = new  Product[BOOLSIZE];
            curIndex = -1;
        }
        private Product[] queues;
        private int curIndex;
        private Lock lock = new ReentrantLock();

        private final Condition empty = lock.newCondition();

        private final Condition full = lock.newCondition();

        public void push(Product p) throws InterruptedException {
            try{
                lock.lock();
                while(curIndex>=BOOLSIZE) {
                    full.await();
                }
                queues[++curIndex]=p;
                empty.signal();
            }catch (Exception e){
               e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }


        public Product pop() throws InterruptedException {
            Product p=null;
            try{
                lock.lock();
                while(curIndex<=0){
                    empty.await();
                }

                p=queues[curIndex--];
                full.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            return p;
        }
    }
    /*public class Storage {
        private final int BOOLSIZE = 10;
        private Storage(){
            queues = new  Product[BOOLSIZE];
            curIndex = -1;
        }
        private Product[] queues;
        private int curIndex;

        public void push(Product p) throws InterruptedException {
            synchronized (this){
                while(curIndex>=BOOLSIZE) {
                    this.wait();
                }
                queues[++curIndex]=p;
                this.notify();
            }
        }


        public Product pop() throws InterruptedException {

           synchronized (this){
               Product p=null;
               while(curIndex<0){
                   this.wait();
               }
               p=queues[curIndex--];
               this.notify();
               return p;
           }

        }
    }*/
    /**
     * 产品
     * 
     * @author 林计钦
     * @version 1.0 2013-7-24 下午04:54:04
     */
    public class Product {
        private int id;

        public Product(int id) {
            this.id = id;
        }

        public String toString() {// 重写toString方法
            return "产品：" + this.id;
        }
    }

}