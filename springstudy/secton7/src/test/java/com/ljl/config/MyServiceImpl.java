package com.ljl.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/14/014.
 */
@Service
@Primary
public class MyServiceImpl implements MyService {
    public void doStuff() {
        System.out.println("MyServiceImpl out");
    }
}
