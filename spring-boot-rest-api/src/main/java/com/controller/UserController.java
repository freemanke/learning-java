package com.controller;

import com.dto.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{name}")
    public UserInfo get(@PathVariable("name") String name) {
        UserInfo userInfo = userService.findByName(name);

        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setName("Freeman Ke");
        }

        return userInfo;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserInfo add(@RequestBody UserInfo userInfo) throws Exception {
        return userService.updateUser(userInfo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserInfo update(@RequestBody UserInfo userInfo) throws Exception {
        return userService.updateUser(userInfo);
    }
}
