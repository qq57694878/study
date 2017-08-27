package com.ljl.Base;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Administrator on 2017/8/10/010.
 */
@RunWith(SpringRunner.class)
// ApplicationContext will be loaded from
// "classpath:com/example/MyTest-context.xml"
@WebAppConfiguration("webapp")
@ContextConfiguration("classpath*:spring/ctx*.xml")
public class TestBaseWeb {

    // 模拟request,response
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    MockServletContext servletContext; // cached

    @Autowired
    MockHttpSession session;

    protected MockMvc mockMvc;



    // 执行测试方法之前初始化模拟request,response
    @Before
    public void init() throws Exception{
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test(){

    }
}
