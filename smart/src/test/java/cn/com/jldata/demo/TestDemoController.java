package cn.com.jldata.demo;

import cn.com.jldata.assp.base.TestRestBussinessBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestDemoController extends TestRestBussinessBase {

    @Test
    public void testList() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name","test");
        param.put("id","1");
        Response r = RestAssured.given(this.spec).header("token",this.token).contentType(ContentType.URLENC).formParams(param)
                .post(""+PRE_PATH+"/demo/list.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }
}
