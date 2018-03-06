package com.ljl.vuehttp.arithmetic;

public class MyRSA {
    public static void main(String[] args) {
        long g=  gcd(10,15);
        long l=  lcm(10,15);
        System.out.println(g);
        System.out.println(l);
    }

    /**
     * 求最小公倍数（ least common multiple ）
     */
    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    /**
     * 辗转相除法求最大公约数(greatest common divisor)
     * 1.C=A%B 2.A=B,B=C, 3.重复1和2 知道C=0;A为最大公约数
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a,long b){
        if(a<b){
            long r=a;
            a=b;
            b=r;
        }
        while(b!=0){
            long c =a%b;
            a=b;
            b=c;
        }
        return a;
    }

}
