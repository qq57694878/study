package com.ljl.time;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/20/020.
 */
@Service
public class ExecutionTime {
    public void time1(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String returnObj(){
        return "hello";
    }
    public String param(Map<String,String> p){
        return p.toString();
    }

    public Foo getFoo(String name, int age) {
        return new Foo(name, age);
    }
}
