package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@RestController("/api/v1/token")
public class TokenController {

    @RequestMapping(method = RequestMethod.POST)
    public String get() {
        String token = "";

        return  token;
    }
}
