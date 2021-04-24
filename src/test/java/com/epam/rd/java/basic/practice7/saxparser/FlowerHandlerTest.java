package com.epam.rd.java.basic.practice7.saxparser;

import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import org.junit.Assert;
import org.junit.Test;

public class FlowerHandlerTest {
    @Test
    public void shouldNotReturnNull() {
        FlowerSaxParser saxParser = new FlowerSaxParser();
        saxParser.parseFlowers("input.xml");
        Assert.assertNotNull(saxParser.getFlowers());
    }
}
