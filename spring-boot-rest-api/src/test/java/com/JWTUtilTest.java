package com;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

public class JWTUtilTest {
    private final String key = "4##_4094849499_###";

    @Test
    public void should_create_valid_token() throws Exception {

        Map<String, String> claims = new HashMap<>();
        claims.put("name", "freeman");
        claims.put("role", "ADMIN,USER,READ_BOOK,WRITE_BOOK");

        JWTUtil jwt = new JWTUtil();
        String token = jwt.createJWT("freeman", 1000 * 60 * 60 * 24 * 30 * 12 * 100,
                claims, key);
        System.out.println(token);

        Assert.assertNotNull(token);
    }

    @Test
    public void should_parse_correct_jwt() {
        JWTUtil util = new JWTUtil();
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0ODc5MzE3MjIsInN1YiI6ImZyZWVtYW4iLCJleHAiOjE0O" +
                "Dg3NzUzOTksInJvbGUiOiJBRE1JTixVU0VSLFJFQURfQk9PSyxXUklURV9CT09LIiwibmFtZSI6ImZyZWVtYW4ifQ.vGwNzhh-8m" +
                "BrHJ-HzvPCJsw9a9Ec9bWKXStf7kjJJBY";
        util.isValidToken(jwt, key);
        Map<String, String> claims = util.parseJWT(jwt, key);
        claims.forEach((a, b) -> System.out.println(a + ", " + b));

        Assert.assertTrue(claims != null);
    }
}
