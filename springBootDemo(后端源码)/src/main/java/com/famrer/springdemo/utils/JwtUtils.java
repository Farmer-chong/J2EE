package com.famrer.springdemo.utils;


import io.jsonwebtoken.*;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private final static int EXPIRATION_TIME = 60 * 60 * 24;
    private final static String SECRET_KEY = "dev key";
    public static final String AUTHORIZATION = "Token";

    /**
     * 生成一个payload为data的token
     * @param data  payload的数据
     * @param expr  过期时间，单位为 秒
     * @return  token, type String
     */
    public static String generateToken(Object data, int expr) {
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        Date expiration = null;
        if (expr > 0){
            calendar.setTime(now);
            calendar.add(Calendar.SECOND, expr);
            expiration = calendar.getTime();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", data);
        String res = Jwts.builder()
                .setClaims(map)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return res;
    }

    public static String generateToken(Object data){
        return generateToken(data, EXPIRATION_TIME);
    }

    public static Object parse(String token) throws Exception {
            Claims body = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return body.get("data");

    }


}
