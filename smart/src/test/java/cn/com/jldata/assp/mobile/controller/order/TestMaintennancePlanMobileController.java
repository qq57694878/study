package cn.com.jldata.assp.mobile.controller.order;

import cn.com.jldata.assp.base.TestRestBussinessBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

public class TestMaintennancePlanMobileController extends TestRestBussinessBase {
    @Test
    public void testSelectPlanDetailMessage() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("orderId","43a998c6810743ca80a5fa8ac92eabb5");
        Response r = RestAssured.given(this.spec).header("token",this.token).contentType(ContentType.URLENC).formParams(param)
               .post(""+PRE_PATH+"/mobile/maintenanceMan/plan/selectPlanDetailMessage.json");
        r.then().statusCode(200);
        BufferedReader reader = new BufferedReader(new InputStreamReader(r.thenReturn().getBody().asInputStream()));
        StringBuilder body = new StringBuilder();
        String s="";
        while((s=reader.readLine())!=null){
            body.append(s).append("\r\n");
        }
        System.out.println(body.toString());
       Map m = objectMapper.readValue(body.toString(),Map.class);
        assert(Matchers.equalTo("00000").matches(m.get("code")));
    }
    @Test
    public void testScanDevice() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("mCode","HLqf001001");
        param.put("orderId","43a998c6810743ca80a5fa8ac92eabb5");
        Response r = RestAssured.given(this.spec).header("token",this.token).contentType(ContentType.URLENC).formParams(param)
                .post(""+PRE_PATH+"/mobile/maintenanceMan/plan/scanDevice.json");
        r.then().statusCode(200);
        String body = r.print();
        Map m = objectMapper.readValue(body,Map.class);
        assert(Matchers.equalTo("00000").matches(m.get("code")));
    }

    @Test
    public void testGetDeviceInfo() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("orderDetailId","115");
        Response r = RestAssured.given(this.spec).header("token",this.token).contentType(ContentType.URLENC).formParams(param)
                .post(""+PRE_PATH+"/mobile/maintenanceMan/plan/getDeviceInfo.json");
        r.then().statusCode(200);
        String body = r.print();
        Map m = objectMapper.readValue(body,Map.class);
        assert(Matchers.equalTo("00000").matches(m.get("code")));
    }
    @Test
    public void testFinishPlan() throws IOException {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("orderId","43a998c6810743ca80a5fa8ac92eabb5");
        List<Map<String,String>> finishPlanList = new ArrayList<Map<String,String>>();
        if(true){
            Map<String,String> m = new HashMap<String,String>();
            m.put("orderDetailId","198ac2cb47cc4b59ab0c3e2d1aedf203");
            m.put("mCode","HLtkj001001");
            m.put("orderDetailRemark","维修明细100");
            m.put("orderDetailUrl", "https://www.baidu.com/img/bd_logo1.png");//图片1存储路径
            m.put("orderDetailUrl1", "https://img.alicdn.com/tps/i2/TB1bNE7LFXXXXaOXFXXwFSA1XXX-292-116.png_145x145.jpg");//图片2存储路径
            m.put("orderDetailUrl2", "https://www.baidu.com/img/bd_logo1.png");//图片3存储路径
            m.put("orderDetailUrl3", "https://www.baidu.com/img/bd_logo1.png");//图片4存储路径
            m.put("orderDetailUrl4", "https://www.baidu.com/img/bd_logo1.png");//图片5存储路径
            finishPlanList.add(m);
        }
        if(true){
            Map<String,String> m = new HashMap<String,String>();
            m.put("orderDetailId","5fdb8407bbe742c28126fcf97ae778b6");
            m.put("mCode","HLqf001001");
            m.put("orderDetailRemark","维修明细101");
            m.put("orderDetailUrl", "https://img.alicdn.com/tps/i2/TB1bNE7LFXXXXaOXFXXwFSA1XXX-292-116.png_145x145.jpg");//图片1存储路径
            m.put("orderDetailUrl1", "https://img.alicdn.com/tps/i2/TB1bNE7LFXXXXaOXFXXwFSA1XXX-292-116.png_145x145.jpg");//图片2存储路径
            m.put("orderDetailUrl2", "https://img.alicdn.com/tps/i2/TB1bNE7LFXXXXaOXFXXwFSA1XXX-292-116.png_145x145.jpg");//图片3存储路径
            m.put("orderDetailUrl3", "https://www.baidu.com/img/bd_logo1.png");//图片4存储路径
            m.put("orderDetailUrl4", "https://www.baidu.com/img/bd_logo1.png");//图片5存储路径
            finishPlanList.add(m);
        }
        param.put("finishPlanList",this.objectMapper.writeValueAsString(finishPlanList));
        Response r = RestAssured.given(this.spec).header("token",this.token).contentType(ContentType.URLENC).formParams(param)
                .post(""+PRE_PATH+"/mobile/maintenanceMan/plan/finishPlan.json");
        r.then().statusCode(200);
        String body = r.print();
        Map m = objectMapper.readValue(body,Map.class);
        assert(Matchers.equalTo("00000").matches(m.get("code")));
    }

}
