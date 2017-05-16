package com.dhc.tools.config;

import com.dhc.tools.CreateModelLjl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/5/3.
 */
public class ConfigParser {
    private final static  String  confFile = "/config.properties";
    public static Config parseConfig(){
        Config config = new Config();
       // String classPath=ConfigParser.class.getResource("/").getPath();
        //classPath=classPath.substring(1);
        InputStream inStream =ConfigParser.class.getResourceAsStream(confFile);
        Properties prop = new Properties() ;
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        config.setDriverClassName(prop.getProperty("driverClassName"));
        config.setDbURL( prop.getProperty("url"));
        config.setDbUser(prop.getProperty("username"));
        config.setDbPass(prop.getProperty("password"));
        config.setPack(prop.getProperty("package"));
        config.setSourcePackage(prop.getProperty("sourcePackage"));
        String tableStr = prop.getProperty("tables");
        List<String> list = new ArrayList<String>();
        for(String tableName:tableStr.split(",")){
            if(tableName!=null&&tableName.trim().length()>0){
                list.add(tableName.toUpperCase());
            }
        }
        config.settNames(list.toArray(new String[]{}));
        return config;
    }

}
