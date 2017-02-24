package com.thoughtworks;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

@Component
public class Audia3 extends Car {
    public Audia3() {
        this.setName("audia3");
        Logger.getLogger(Audia3.class.toString()).info("create an audia2 object");
    }
}
