package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue
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
