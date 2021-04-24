package com.epam.rd.java.basic.practice7.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import org.junit.Assert;
import org.junit.Test;

public class FlowerSaxBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(new Flowers());
        Assert.assertNotNull(b);
    }
}
