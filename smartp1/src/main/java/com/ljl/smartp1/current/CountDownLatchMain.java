package com.ljl.smartp1.current;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 */
public class CountDownLatchMain {
    private final static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String args[]) throws Exception{
        for (int i=0;i<2;i++){
          new Thread(()->{
              System.out.println(Thread.currentThread().getName()+" is start...");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName()+" is end");
              countDownLatch.countDown();
          }).start();
        }
        System.out.println(Thread.currentThread().getName()+" is start...");
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+" is end");
    }
}
