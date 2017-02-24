package com.thoughtworks;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

public class AspectTest {

    @Test
    public void assert_aspect() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Greeting greeting = context.getBean(Greeting.class);
        greeting.sayHello();
    }
}
