package cn.com.jldata.solrdemo.controller;

import cn.com.jldata.solrdemo.base.TestRestBussinessBase;
import cn.com.jldata.solrdemo.domain.Article;
import cn.com.jldata.solrdemo.vo.RestResult;
import com.github.pagehelper.Page;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TestArticleController extends TestRestBussinessBase {

    @Test
    public void testSaveALL() throws IOException{
        for(int i=0;i<100;i++){
            testSave();
        }
    }

    @Test
    public void testSave() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Random random = new Random();
       int i= random.nextInt(100000);
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
    @Test
    public void testDelete() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        List<Map<String,Object>>list = selectAll();
        if(list!=null&&list.size()>0){
            int id = Integer.parseInt(String.valueOf(list.get(0).get("id")));
            param.put("id",id);
            Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(id)
                    .post(""+PRE_PATH+"/article/delete.json");
            r.then().statusCode(200);
            r.prettyPrint();
        }
    }

    @Test
    public void testSelectAll() throws IOException{
        Object r= selectAll();
        System.out.println(r);
    }
    public List<Map<String,Object>> selectAll() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                .post(""+PRE_PATH+"/article/findAll.json");
        r.then().statusCode(200);
        r.prettyPrint();
        RestResult result = this.objectMapper.readValue(r.asString(), RestResult.class);
        return (List<Map<String,Object>>)(((Map<String,List>)result.getData()).get("list"));
    }


    @Test
    public void testSearch() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("pageNum",1);
        param.put("pageSize",10);
        param.put("word","标题");
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(param)
                .post(""+PRE_PATH+"/article/search.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }


    @Test
    public void testReIndexAll() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(param)
                .post(""+PRE_PATH+"/article/reIndexAll.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }



}
