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
        param.put("name","李");
        param.put("id","1");
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                .post(""+PRE_PATH+"/demo/list.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }
    @Test
    public void testListFilter() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
       // param.put("filter_CONTAINS_lastName","李");
        //param.put("filter_EQI_id","1");
        param.put("filter_EQI_department.id","1"); //部门3
        param.put("filter_GED_crateTime","2017-09-19 00:00:00");
        param.put("filter_LED_crateTime","2017-09-19 23:59:59");
        param.put("filter_INI_id","1,2");
        //param.put("filter_INLB_department.id","true"); //部门3
        param.put("filter_NNLB_department.id","true"); //部门3
        param.put("size","10");
        param.put("page","0");
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                .post(""+PRE_PATH+"/demo/listFilter.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }
}
