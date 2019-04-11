package com.kulongtai.stest.search.controller;

import com.kulongtai.stest.search.base.TestRestBussinessBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Title: TestXuningController
 * <p>Description: </p>
 *
 * @author lijinliang
 * Date: 2019/4/11 11:05
 */
public class TestXuningController extends TestRestBussinessBase{
	@Test
    public void testCreate(){
		for (int i = 2; i < 100; i++) {
			java.util.Map<String,Object> body = new HashMap<String,Object>();
			body.put("id",""+i);
			body.put("title","标题"+i);
			body.put("content","内容"+i);
			body.put("filenames",new String[]{"1.jpg","2.jpg"});
			body.put("type","1");
			body.put("remark","备注"+i);
			body.put("create_date",new Date());
			Response r = RestAssured.given().contentType("application/json").body(body)
					.post("/xuning/create");
			r.then().statusCode(200);
			r.prettyPrint();
		}

	}

	@Test
	public void testSearch(){
		java.util.Map<String,Object> body = new HashMap<String,Object>();
		body.put("q","标题");
		body.put("q1","标题");
		body.put("q2","标题");
		body.put("pageNumber",9);
		body.put("pageSize",10);
		Response r = RestAssured.given().params(body)
				.get("/xuning/search");
		r.then().statusCode(200);
		r.prettyPrint();
	}
}
