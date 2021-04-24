package com.epam.rd.java.basic.practice7.item;

import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlowerTest {
    private Flowers flowers;
    @Before
    public void initFlowers() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        flowers = p.getFlowers();
    }

    @Test
    public void shoulReturnString() {
        Flower f = flowers.get(0);

        Assert.assertTrue(f.getName() instanceof String);
    }
}
