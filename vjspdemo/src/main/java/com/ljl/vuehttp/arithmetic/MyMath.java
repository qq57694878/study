package com.ljl.vuehttp.arithmetic;

public class MyMath {
    public static void main(String[] args) {
        int b= MyMath.pom(2,30);
        System.out.println(b);


    }

    public static int pom(int a,int b){
        int s=1;
        while(b>0){
            if(b%2==1){
                s = s*a;
            }
            a*=a;
            b=b>>1;
        }
        return s;
    }
}
