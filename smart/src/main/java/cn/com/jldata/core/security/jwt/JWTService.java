package cn.com.jldata.core.security.jwt;

public interface JWTService {
    String getUsernameFromToken(String auth_token);
}
