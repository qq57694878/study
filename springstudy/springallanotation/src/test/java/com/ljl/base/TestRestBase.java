package com.ljl.base;

import io.restassured.RestAssured;
import io.restassured.config.DecoderConfig;
import io.restassured.config.EncoderConfig;
import org.junit.Before;

/**
 * Created by jinliang on 2016/8/23.
 */
public class TestRestBase {
   // public final static String PRE_PATH="/cherry";
      public final static String PRE_PATH="";


   @Before
    public void init() throws  Exception{
        //指定 URL 和端口号
        RestAssured.baseURI ="http://localhost";
        RestAssured.port = 9999;
        RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8").defaultQueryParameterCharset("UTF-8"));
        RestAssured.config = RestAssured.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultCharsetForContentType("UTF-8","multipart/form-data"));
    }




  /*  @Before
    public void init() throws  Exception{
        //指定 URL 和端口号
        RestAssured.baseURI ="http://www.tongpinlife.com";
        RestAssured.port = 9999;
               RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8").defaultQueryParameterCharset("UTF-8"));
        RestAssured.config = RestAssured.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultCharsetForContentType("UTF-8","multipart/form-data"));

    }*/

 /*   @Before
    public void init() throws  Exception{
        //指定 URL 和端口号
        RestAssured.baseURI ="http://192.168.1.55";
        RestAssured.port = 9999;
        RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultContentCharset("UTF-8").defaultQueryParameterCharset("UTF-8"));
        RestAssured.config = RestAssured.config().decoderConfig(DecoderConfig.decoderConfig().defaultContentCharset("UTF-8"));
        RestAssured.config = RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().defaultCharsetForContentType("UTF-8","multipart/form-data"));
    }*/


}
