package com.ljl.Base;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/8/10/010.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath*:spring/ctx*.xml")
public class TestBase {


    @Autowired
    protected ApplicationContext applicationContext;

    // 执行测试方法之前初始化模拟request,response
    @Before
    public void init() throws Exception{

    }

}
