package com.epam.rd.java.basic.practice7.container;

import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FlowersTest {
    private Flowers flowers;
    @Before
    public void init() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        flowers = p.getFlowers();
    }

    @Test
    public void shouldReturnFlower() {
        Assert.assertTrue(flowers.get(0) instanceof Flower);
    }

    @Test
    public void shouldReturnList() {
        Assert.assertTrue(flowers.getFlowers() instanceof List);
    }
}
