package com.thoughtworks;

import org.springframework.stereotype.Component;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 22/02/2017
 */

@Component
public class Car {

    private String name = "unknown";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
