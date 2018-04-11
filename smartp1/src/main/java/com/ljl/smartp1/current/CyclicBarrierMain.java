package com.ljl.smartp1.current;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {
    public final static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
        System.out.println("大家都完成了，我要执行了。");
    });
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" is start...");
                Sleep.sleepRandom();
                System.out.println(Thread.currentThread().getName()+" is end");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("all is finish");
    }
}
