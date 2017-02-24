package com.thoughtworks;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

@Component
public class Sonata extends Car {
    public Sonata() {
        this.setName("sonata");
        Logger.getLogger(Sonata.class.toString()).info("create sonata object");
    }
}
