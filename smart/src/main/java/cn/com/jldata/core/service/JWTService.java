package cn.com.jldata.core.service;

public interface JWTService {
    String getUsernameFromToken(String auth_token);
}
