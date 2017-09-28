package cn.com.jldata.solrdemo.controller;

import cn.com.jldata.solrdemo.base.TestRestBussinessBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestArticleController extends TestRestBussinessBase {

    @Test
    public void testSave() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Random random = new Random();
       int i= random.nextInt(1000);
        param.put("id",i);
        param.put("title","标题"+i);
        param.put("content","内容"+i);
        param.put("type","11");
        param.put("createtime","2017-01-01 01:01:01");
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                .post(""+PRE_PATH+"/article/create.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }

}
