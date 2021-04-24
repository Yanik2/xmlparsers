package com.epam.rd.java.basic.practice7.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.staxbuilder.FlowerStaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import org.junit.Assert;
import org.junit.Test;

public class FlowerStaxBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerStaxBuilder b = new FlowerStaxBuilder(new Flowers());
        Assert.assertNotNull(b);
    }
}
