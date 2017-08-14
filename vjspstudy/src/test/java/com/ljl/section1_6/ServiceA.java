package com.ljl.section1_6;

/**
 * Created by Administrator on 2017/8/9/009.
 */
public class ServiceA {
    public void sayHello(){
        System.out.println("heello a");
    }
    public void sayHello1(){
        System.out.println(this.a);
    }
    private  ServiceB a;

    public ServiceB getA() {
        return a;
    }

    public void setA(ServiceB a) {
        this.a = a;
    }

    public static class ServiceB{
        @Override
        public String toString() {
            return "ServiceB{}";
        }
    }
}
