package com.ljl.section1_6;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/9/009.
 */
@Service
public class ServerAnotation {
    public void sayHello(){
        System.out.println("hello");
    }
}
