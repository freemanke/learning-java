package com.entity;

import org.springframework.stereotype.Component;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Component
public class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
