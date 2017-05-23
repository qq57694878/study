package com.ljl.study.controller;

import com.ljl.study.properties.PropertiesContig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/23.
 */
@RestController
public class PropertiesController {
    @Autowired
    private PropertiesContig config;

    @RequestMapping("/properties/index")
    public String index(){
        return config.getA()+":"+config.getB();
    }
}
