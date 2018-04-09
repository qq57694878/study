package com.ljl.controller;

import com.ljl.auth.Userid;
import com.ljl.entity.Sysuser;
import com.ljl.service.JWTService;
import com.ljl.service.LoginService;
import com.ljl.util.Constants;
import com.ljl.util.MD5Encoder;
import com.ljl.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/8/25/025.
 */
@RestController
public class LoginController {
    @Autowired
    private JWTService jwtService;
    @Autowired
    private LoginService loginService;


    /**
     * 密码加密盐值
     */
    private String salt;
    @Value("${password.salt}")
    public void setSalt(String salt) {
        this.salt = salt;
    }

    @RequestMapping("login")
    public RestResult login(@RequestBody Map<String,String> param){
        String usercode= param.get("username");
        String password = param.get("password");
        Sysuser user = loginService.getUserByUsercode(usercode);
        if(user!=null){
            //校验密码
            if(!MD5Encoder.encode(password,this.salt).equals( user.getPassword())){
                return new RestResult(Constants.ERROR_CODE_401);//"密码不正确!"
            }


        }else{
            return new RestResult(Constants.ERROR_CODE_401);//"用户名不存在!"
        }
        String token =  jwtService.getToken(user.getUserid());
        return  new RestResult(token,new Object());
    }



    /**
     * 注销
     */
    @RequestMapping("logout")
    public RestResult logout() {
        return new RestResult(null,new Object());
    }

    @RequestMapping("verify")
    public RestResult verify(@Userid String userid) {
        String token =  jwtService.getToken(userid);
        return  new RestResult(token,new Object());
    }

}
