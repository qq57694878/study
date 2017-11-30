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

public class TesAttachmentController extends TestRestBussinessBase {
    @Before
    public void mybefore(){
        atomicInteger = new AtomicInteger();
    }
    private java.util.concurrent.atomic.AtomicInteger atomicInteger;

    @Test
    public void testSaveALL() throws IOException{
        for(int i=0;i<100;i++){
            testSave();
        }
    }

    public static String getId(){
        return  UUID.randomUUID().toString().replaceAll("-", "");
    }
    @Test
    public void testSave() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Random random = new Random();
        int i= random.nextInt(100000);
        param.put("id",getId());
        param.put("title","标题"+i);
        param.put("desc","描述"+i);
        param.put("content","内容"+i);
        param.put("createtime","2017-01-01 01:01:01");
        int jj =  atomicInteger.getAndIncrement();{
            if(jj%2==0){
                param.put("type","doc");
                param.put("url","https://pan.baidu.com/s/1mhPU6KS");
            }else{
                param.put("type","mp4");
                param.put("url","https://pan.baidu.com/s/1ctvfWU");
            }
        }
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                .post(""+PRE_PATH+"/attachment/create.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }
    @Test
    public void testDelete() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        List<Map<String,Object>>list = selectAll();
        if(list!=null&&list.size()>0){
            String id = String.valueOf(list.get(0).get("id"));
            param.put("id",id);
            Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(id)
                    .post(""+PRE_PATH+"/attachment/delete.json");
            r.then().statusCode(200);
            r.prettyPrint();
        }
    }
    @Test
    public void testFindOne() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        List<Map<String,Object>>list = selectAll();
        if(list!=null&&list.size()>0){
            String id =String.valueOf(list.get(0).get("id"));
            param.put("id",id);
            Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(id)
                    .post(""+PRE_PATH+"/attachment/findOne.json");
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
                .post(""+PRE_PATH+"/attachment/findAll.json");
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
                .post(""+PRE_PATH+"/attachment/search.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }


    @Test
    public void testReIndexAll() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(param)
                .post(""+PRE_PATH+"/attachment/reIndexAll.json");
        r.then().statusCode(200);
        r.prettyPrint();
    }





    @Test
    public void testInitData() throws IOException{
        File file =new File("E:\\1");
        initData(file);
    }

    public void initData(File file) throws IOException {
        if(file.isDirectory()){
            File[] files =file.listFiles();
            if(files!=null){
                for(File f:files){
                    initData(f);
                }
            }
        }else{
            Random random = new Random();
            int i= 100039;
            BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
            String line=null;
            while((line  = reader.readLine())!=null){
                i++;
                String tt =String.valueOf(line+i);
                String title = tt.substring(0,tt.length()>500?500:tt.length());
                String desc = reader.readLine()+i;
                String content = reader.readLine()+i;
                Map<String,Object> param = new HashMap<String,Object>();
                param.put("id",getId());
                param.put("title",title);
                param.put("desc",desc);
                param.put("content",content);
                int jj =  atomicInteger.getAndIncrement();{
                    if(jj%2==0){
                        param.put("type","doc");
                        param.put("url","https://pan.baidu.com/s/1mhPU6KS");
                    }else{
                        param.put("type","mp4");
                        param.put("url","https://pan.baidu.com/s/1ctvfWU");
                    }
                }
                param.put("createtime",getCreateTime());
                Response r = RestAssured.given(this.spec).contentType(ContentType.JSON).body(objectMapper.writeValueAsString(param))
                        .post(""+PRE_PATH+"/attachment/create.json");
                r.then().statusCode(200);
                //r.prettyPrint();
            }
        }

    }


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public String getCreateTime(){
        Random random = new Random();
        int i = random.nextInt(365);
        Calendar c = Calendar.getInstance();
        c.set(2017,1,1,0,0,0);
        c.add(Calendar.DAY_OF_YEAR,i);
        return sdf.format(c.getTime());
    }






}
