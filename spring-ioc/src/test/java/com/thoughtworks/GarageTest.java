package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.mockito.Mockito.mock;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

public class GarageTest {
    private ApplicationContext context = ne/Users/zgke/Projects/learning-java/ioc/src/main/java/com/thoughtworks/BeanConfiguration.javaw AnnotationConfigApplicationContext(BeanConfiguration.class);

    @Test
    public void should_return_sonata_car() {
        Garage bean = context.getBean(Garage.class);
        Assert.assertEquals("sonata", bean.getSonata().getName());
    }

    @Test
    public void should_return_mock_car() {
        Car car = mock(Car.class);
        Assert.assertNotNull(car);
        System.out.println(car.getName());
    }
}
