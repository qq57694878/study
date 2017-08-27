package com.ljl.controller;

import com.ljl.base.TestRestBussinessBase;
import com.ljl.util.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Created by Administrator on 2017/8/26/026.
 */
public class TestHelloController  extends TestRestBussinessBase{
    @Test
    public void testHello()  throws Exception {
        Response r = RestAssured.given().contentType("application/json")
                .header(Constants.AUTHENTICATION_HEADER,this.token).header(Constants.VERSION,Constants.DEFAULT_VERSION)
                .post(""+PRE_PATH+"/hello.do");
        r.then().statusCode(200).body("error_code", Matchers.equalTo(200));
        r.prettyPrint();

    }
}
