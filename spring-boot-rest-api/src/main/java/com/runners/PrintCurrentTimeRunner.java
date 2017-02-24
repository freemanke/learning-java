package com.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 24/02/2017
 */

public class PrintCurrentTimeRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(PrintCurrentTimeRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        String time = System.currentTimeMillis() + "";
        logger.info(time);
        System.out.println(time);
    }
}
