package com.ljl.config;

import com.ljl.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/14/014.
 */
public class TestMyService extends TestBase {
    @Autowired
    private  MyService myService;
@Test
    public void test1(){
        myService.doStuff();
    try {
        Thread.sleep(10000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

}
