/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 22/02/2017
 */

package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarTest {

    @Test
    public void should_return_name_sonata() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Car car = context.getBean(Sonata.class);
        Assert.assertEquals("sonata", car.getName());
    }

    @Test(expected = Exception.class)
    public void should_throw_exception() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        Car car = context.getBean(Sonata.class);
        String name = car.getName();

        Assert.assertEquals("sonata", name);
    }
}

