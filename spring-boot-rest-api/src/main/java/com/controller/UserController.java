package com.controller;

import com.dto.UserInfo;
import com.entity.User;
import com.mapper.UserMapper;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/{name}")
    public UserInfo view(@PathVariable("name") String name) {
        UserInfo userInfo = userService.findByName(name);

        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setName("Freeman Ke");
        }

        return userInfo;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserInfo Update(@RequestBody UserInfo userInfo) throws Exception {
        return userService.updateUser(userInfo);
    }
}
