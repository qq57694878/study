package com.kulongtai.stest.search.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Rule;
import org.springframework.restdocs.JUnitRestDocumentation;

/**
 * 业务测试基类
 */
public class TestRestBussinessBase extends TestRestBase {
    protected ObjectMapper objectMapper = new ObjectMapper();

    protected RequestSpecification spec;


    // 执行测试方法之前初始化模拟request,response
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
    @Before
    public void init() throws Exception {
        super.init();
    }




    public void getToken()throws Exception{

    }

    public void setUp() {
    }


}
