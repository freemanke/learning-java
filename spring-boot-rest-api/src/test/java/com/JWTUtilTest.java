package com;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

public class JWTUtilTest {
    private final String key = "4##_4094849499_###";

    @Test
    public void should_create_valid_token() throws Exception {

        ArrayList<String> claims = new ArrayList<>();
        claims.add("user");
        claims.add("admin");
        claims.add("can_read_book");
        claims.add("can_add_book");
        claims.add("can_update_book");
        claims.add("can_remove_book");

        JWTUtil jwt = new JWTUtil();
        String token = jwt.createJWT("freeman", 1000 * 60 * 60 * 24 * 30 * 12 * 100,
                claims, key);
        System.out.println(token);

        Assert.assertNotNull(token);
    }

    @Test
    public void should_return_true_given_valid_jwt_token() {
        JWTUtil util = new JWTUtil();
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE0ODc5MzA3MzUsInN1YiI6Im" +
                "ZyZWVtYW4iLCJleHAiOjE0ODg3NzQ0MTMsInVzZXIiOnRydWUsImFkbWluIjp0cnVlLCJjYW5fcmVh" +
                "ZF9ib29rIjp0cnVlLCJjYW5fYWRkX2Jvb2siOnRydWUsImNhbl91cGRhdGVfYm9vayI6dHJ1ZSwiY2" +
                "FuX3JlbW92ZV9ib29rIjp0cnVlfQ.p6zZCKUSFFlZdl-Ifgr5-6_hYWtfmW1NsScgp5FSUVs";
        util.isValidToken(jwt, key);
        List<String> claims = util.parseJWT(jwt, key);
        claims.forEach(a -> System.out.println(a));

        Assert.assertTrue(claims != null);
    }
}
