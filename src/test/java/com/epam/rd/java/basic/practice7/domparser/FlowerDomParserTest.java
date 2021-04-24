package com.epam.rd.java.basic.practice7.domparser;

import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import org.junit.Assert;
import org.junit.Test;

public class FlowerDomParserTest {
    @Test
    public void shouldNotReturnNull() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        Assert.assertNotNull(p.getFlowers());
    }

}
