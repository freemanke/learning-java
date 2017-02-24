package com.service;

import com.BaseTest;
import com.dto.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */


public class UserServiceTest extends BaseTest {
    @Autowired
    UserService userService;

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_null_user() {
        userService.addUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_given_null_user_name() {
        UserInfo userInfo = new UserInfo();
        userService.addUser(userInfo);
    }

    @Test
    public void should_add_one_user() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("freeman");

        userService.addUser(userInfo);
        UserInfo find = userService.findByName(userInfo.getName());

        Assert.assertEquals("freeman", find.getName());
    }

    @Test
    public void should_return_null_user() {
        String name = "should_return_null_user";

        UserInfo userInfo = userService.findByName(name);

        Assert.assertNull(userInfo);
    }

    @Test
    public void should_update_user_name() throws Exception {
        UserInfo userInfo = new UserInfo() {{
            setName("should_update_user_name");
        }};
        userService.addUser(userInfo);
        userInfo = userService.findByName("should_update_user_name");
        userInfo.setName("new");
        userInfo = userService.updateUser(userInfo);

        Assert.assertEquals("new", userInfo.getName());
    }
}
