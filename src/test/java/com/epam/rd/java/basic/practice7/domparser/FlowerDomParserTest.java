package com.epam.rd.java.basic.practice7.domparser;

import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.parsers.DocumentBuilder;
import java.util.logging.Logger;

public class FlowerDomParserTest {
    @Test
    public void shouldNotReturnNull() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        Assert.assertNotNull(p.getFlowers());
    }

    @Test
    public void shouldBeInstanceOfLogger() {
        Assert.assertTrue(FlowerDomParser.getLogger() instanceof Logger);
    }

    @Test
    public void shouldBeInstanceOfDocumentBuilder() {
        FlowerDomParser p = new FlowerDomParser();
        Assert.assertTrue(p.getDocumentBuilder() instanceof DocumentBuilder);
    }
}
