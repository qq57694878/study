package cn.com.jldata.search.spmsearch.controller;


import cn.com.jldata.search.spmsearch.base.TestRestBussinessBase;
import cn.com.jldata.search.spmsearch.vo.RestResult;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TesCreateIndexController extends TestRestBussinessBase {

    @Test
    public void testReIndexAll() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(param)
                .post(""+PRE_PATH+"/reIndexAll.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }










}
