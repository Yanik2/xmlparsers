package com.epam.rd.java.basic.practice7.sort;

import com.epam.rd.java.basic.practice7.Main;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortingTest {
    private Flowers flowers;
    private Flower flower;

    @Before
    public void initFlowers() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        flowers = p.getFlowers();
        flower = flowers.get(0);
    }

    @Test
    public void shouldSortSort1() {
        Main.sort1(flowers, (f, f1) -> {
            return f.getName().compareTo(f1.getName());
        });

        Assert.assertNotEquals(flowers.get(0), flower);
    }

    @Test
    public void shouldSortSort2() {
        Main.sort1(flowers, (f, f1) -> {
            return f.getName().compareTo(f1.getName());
        });

        Assert.assertNotEquals(flowers.get(0), flower);
    }

    @Test
    public void shouldSortSort23() {
        Main.sort1(flowers, (f, f1) -> {
            return f.getName().compareTo(f1.getName());
        });

        Assert.assertNotEquals(flowers.get(0), flower);
    }
}
