package com.ljl;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/15/015.
 */
public class B   {
    public static class A{
        private String a;
        public void p(){
            System.out.println(this.a);
        }
    }
    public A method1(Map<String,String> map){
        System.out.println("method1");
        return new A();
    }
    public void method2(){
        System.out.println("method2");

    }

    public static void main(String[] args) {
    }

}

