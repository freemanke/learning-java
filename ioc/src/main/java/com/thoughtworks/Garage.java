package com.thoughtworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

@Component
public class Garage {
    public Garage() {
        Logger.getLogger(Garage.class.toString()).info("create garage object");
    }

    @Resource
    private Sonata sonata;

    @Autowired
    private Audia3 audia3;

    public Car getSonata() {
        sonata.setName("sonata");
        return sonata;
    }

    public Car getAudia3() {
        return audia3;
    }

    public void setAudia3(Audia3 audia3) {
        this.audia3 = audia3;
    }
}
