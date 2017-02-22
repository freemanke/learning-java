package com.thoughtworks;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 22/02/2017
 */

@Configuration
@ComponentScan
public class BeanConfiguration {

    private Logger logger = Logger.getLogger(BeanConfiguration.class.toString());

    public BeanConfiguration() {
        logger.info("invoke constructor");
    }
}
