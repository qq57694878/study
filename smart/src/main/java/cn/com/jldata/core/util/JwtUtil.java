package cn.com.jldata.core.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Map;

/**
 * Created by jinliang on 2016/7/28.
 */
public class JwtUtil {
    /**
     * 生成token方法
     * @param secret
     * @param claims
     * @return
     */
    public static String createJwtToken(String secret,Map<String,Object> claims){
        JWTSigner signer = new JWTSigner(secret);
        return  signer.sign(claims);
    }

    public static Map<String,Object> verify(String token,String secret) throws SignatureException, NoSuchAlgorithmException, JWTVerifyException, InvalidKeyException, IOException {
        JWTVerifier verifier = new JWTVerifier(secret);
        Map<String,Object> claims= verifier.verify(token);
        return claims;
    }

    /**
     * 验证token 方法
     * @param token
     * @param secret
     * @return
     */
    public static boolean isValid(String token, String secret) {
        Map<String, Object> claims = null;
        try {
            claims = JwtUtil.verify(token, secret);
        } catch (Exception e) {
            // e.printStackTrace();
            return false;
        }
        long current = System.currentTimeMillis() / 1000;
        long ext = Long.parseLong(String.valueOf(claims.get("exp")));
        if (current > ext) {
            return false;
        }
        return true;
    }

    /**
     * 获得userid
     * @param token
     * @param secret
     * @return
     */
    public static String getUsername(String token,String secret){
        String username = null;
        Map<String, Object> claims = null;
        try {
            claims = JwtUtil.verify(token, secret);
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
        long current = System.currentTimeMillis() / 1000;
        long ext = Long.parseLong(String.valueOf(claims.get("exp")));
        if (current <= ext) {
            String.valueOf(claims.get("userid"));
        }
        return null;
    }

}
