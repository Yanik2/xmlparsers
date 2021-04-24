package com.epam.rd.java.basic.practice7.dombuilder;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import org.junit.Assert;
import org.junit.Test;

public class FlowerDomBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(new Flowers());
        Assert.assertNotNull(b);
    }
}
