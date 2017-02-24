package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Freeman Ke (zgke@thoughtworks.com) $on 23/02/2017
 */

public class BeanConfigurationTest {

    @Test
    public void normal() {
        BeanConfiguration config = new BeanConfiguration();
        Assert.assertNotNull(config);
    }
}
