package com.epam.rd.java.basic.practice7.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import java.util.logging.Logger;

public class FlowerSaxBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(new Flowers());
        Assert.assertNotNull(b);
    }

    @Test
    public void shouldBeInstanceOfLogger() {
        Assert.assertTrue(FlowerSaxBuilder.getLOGGER() instanceof Logger);
    }

    @Test
    public void shouldBeInstanceOfXMLOutputFactory() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(null);
        Assert.assertTrue(b.getFactory() instanceof XMLOutputFactory);
    }
}
