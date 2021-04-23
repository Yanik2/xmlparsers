package com.epam.rd.java.basic.practice7.staxparser;

import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.Assert;
import org.junit.Test;

public class FlowerStaxParserTest {
    @Test
    public void shouldNotReturnNull() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        Assert.assertNotNull(p.getFlowers());
    }
}
