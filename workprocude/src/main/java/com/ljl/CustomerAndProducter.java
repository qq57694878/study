package com.ljl;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/6/23.
 */
public class CustomerAndProducter {

    private int poolSize;
    private int curIndex;
    private Good[] goods;
    private AtomicInteger integer = new AtomicInteger(0);
    private Lock lock = new ReentrantLock();


    public static void main(String[] args) {
        CustomerAndProducter customerAndProducter = new CustomerAndProducter(10);

    }

    public CustomerAndProducter(int poolSize){
        this.poolSize = poolSize;
        this.goods = new Good[this.poolSize];
        curIndex=-1;
    }
    class Producter implements Runnable{

        private void product(){
            int i = integer.get();
            Good good = new Good("name"+i,i);
            try{
                lock.lock();
                if(curIndex>=poolSize){
                    goods.wait();
                }else{
                    goods[++curIndex]=good;
                    System.out.println("生产者生产了"+good);
                    Thread.sleep(1000);
                    goods.notifyAll();
                }

            }catch(Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

            goods[++curIndex]= good;
        }

        @Override
        public void run() {
           while(true){
               this.product();
           }
        }
    }
    class Customer implements Runnable{

        private void cust(){
            int i = integer.get();

            try{
                lock.lock();
                if(curIndex>0){
                    Good good =  goods[curIndex--];
                    System.out.println("消费者消费了"+good);
                    Thread.sleep(1000);
                    goods.notifyAll();
                }else{
                    goods.wait();
                }

            }catch(Exception e){
                 e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }

        @Override
        public void run() {
            while(true){
                this.cust();
            }
        }
    }
}



class Good{

    public Good(String name, int id) {
        this.name = name;
        this.id = id;
    }

    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
