package cn.com.jldata.core.security.jwt.impl;

import cn.com.jldata.core.security.jwt.JWTService;
import cn.com.jldata.core.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTServiceImpl implements JWTService {
    private  String secret;
    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        this.secret = secret;
    }
    @Override
    public String getUsernameFromToken(String auth_token) {
        return JwtUtil.getUsername(auth_token,this.secret);
    }
}
