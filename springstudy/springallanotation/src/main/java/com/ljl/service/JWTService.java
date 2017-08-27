package com.ljl.service;

import com.ljl.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by jinliang on 2016/8/23.
 */
@Service
public class JWTService {
    /**
     * jwt验证私钥
     */
    private String secret;
    /**
     * jwt过期时间单位：秒
     */
    private long expires;
    /**
     * jwt 目标
     */
    private String iss;
    /**
     * 密码加密盐值
     */
    private String salt;
    @Value("${password.salt}")
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken(String userid){
        long iat = System.currentTimeMillis() / 1000l;
        long exp = iat + expires;
        HashMap<String, Object> claims = new HashMap<String, Object>();
        claims.put("iss", this.iss);
        claims.put("exp", exp);
        claims.put("iat", iat);
        claims.put("userid",  userid);
        return  JwtUtil.createJwtToken(this.secret,claims);
    }


    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }
    @Value("${jwt.expires}")
    public void setExpires(long expires) {
        this.expires = expires;
    }
    @Value("${jwt.iss}")
    public void setIss(String iss) {
        this.iss = iss;
    }

}
