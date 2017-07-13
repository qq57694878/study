package com.ljl.thinking;

/**
 * Created by Administrator on 2017/7/12/012.
 */
public class OuterInnerClass {
    private class InnerClass{
        public void p(String s){
            System.out.println(s);
        }
        public OuterInnerClass outter(){
            return OuterInnerClass.this;
        }
    };
    public void p(String s){
        System.out.println("outer:"+s);
    }

    public static void main(String[] args) {
        OuterInnerClass outer = new OuterInnerClass();
        OuterInnerClass.InnerClass inner = outer.new InnerClass();
        inner.p("111");
        inner.outter().p("222");
    }
}
