package com.epam.rd.java.basic.practice7.item;

import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisualParamsTest {
    private Flowers flowers;

    @Before
    public void initFlowers() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        flowers = p.getFlowers();
    }

    @Test
    public void shouldReturnString() {
        Assert.assertTrue(flowers.get(0).getName() instanceof String);
    }
}
