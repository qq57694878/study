package com.ljl.thinking.current;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/7/17/017.
 */
public class CyclicBarrierTest {
    static class Worker implements Runnable{
        private String work;
        private String name;
        private CyclicBarrier barrier;
        private int sleep;

        public Worker(String work, String name,CyclicBarrier barrier,int sleep) {
            this.work = work;
            this.name = name;
            this.barrier= barrier;
            this.sleep = sleep;
        }

        @Override
        public void run() {
            while(!Thread.interrupted()){
                processWork();
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        }
        public String processWork(){
            System.out.println(name+":"+this.work+".start");
            try {
                Thread.sleep(sleep*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":"+this.work+".end");
            return this.work.toUpperCase();
        }
    }

    public static void main(String[] args) {
        final ExecutorService service =  Executors.newCachedThreadPool();
        int n=3;
        String[] data = new String[]{"work1","work2","work3"};
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n, new Runnable() {
            int index=1;
            @Override
            public void run() {
                 if(index++>=3){
                     service.shutdownNow();
                     System.out.println("all done");
                 }

            }
        });
        for(int i=0;i<n;i++){
            Worker worler =   new Worker(data[i],"name:"+i ,cyclicBarrier,i);
            service.submit(worler);
        }
        System.out.println("waiting...");
    }
}
