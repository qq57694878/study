package com.ljl.controller;

import com.ljl.auth.Userid;
import com.ljl.entity.Sysuser;
import com.ljl.vo.RestResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/8/25/025.
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Object hello(@Userid String userid, @RequestBody(required = false) Map<String,String> param){
      Map r = new HashMap();
      r.put("hello","wrold");
      return new RestResult("",r);
    }

}
