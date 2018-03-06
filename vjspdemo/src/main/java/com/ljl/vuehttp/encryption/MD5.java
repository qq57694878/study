package com.ljl.vuehttp.encryption;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5 {
    public static void main(String[] args) {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String result = md5PasswordEncoder.encodePassword("123","1");
        System.out.println(result);
    }
}
