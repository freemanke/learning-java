package com;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Component
public class JWTUtil {

    public String createJWT(String subject, long ttlMillis, Map<String, String> claims, String key) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder()
                .setId("jwt")
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        if (claims != null) {
            claims.forEach((a, b) -> builder.claim(a, b));
        }

        return builder.compact();
    }

    public boolean isValidToken(String jws, String key) {
        if (jws != null) {
            try {
                Jwts.parser().setSigningKey(key).parseClaimsJws(jws);
            } catch (SignatureException e) {
                return false;
            }
        }

        return false;
    }

    public Map<String, String> parseJWT(String jwt, String key) {
        Map<String, String> claims = new HashMap<>();
        if (jwt != null) {
            try {
                Jwts.parser()
                        .setSigningKey(key)
                        .parseClaimsJws(jwt)
                        .getBody()
                        .forEach((a, b) -> claims.put(a, b.toString()));
            } catch (SignatureException e) {

            }
        }

        return claims;
    }
}
