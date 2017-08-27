package com.ljl.main;

import com.ljl.util.MD5Encoder;

/**
 * Created by Administrator on 2017/8/25/025.
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        String p = MD5Encoder.encode("1","ljl");
        System.out.println(p);
    }
}
