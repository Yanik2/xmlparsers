package com.epam.rd.java.basic.practice7.flowerdom;

import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import org.junit.Assert;
import org.junit.Test;

public class FlowerDomParserTest {
    @Test
    public void shouldNotReturnNullAfterParse() {
        FlowerDomParser f = new FlowerDomParser();
        f.parseFlowers("input.xml");
        Assert.assertNotNull(f.getFlowers());
    }
}
