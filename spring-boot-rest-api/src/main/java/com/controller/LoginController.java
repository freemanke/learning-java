package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Controller
public class LoginController {
    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
