package com.epam.rd.java.basic.practice7.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import com.epam.rd.java.basic.practice7.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FlowerSaxBuilderTest {
    private List<Flower> flowers;
    @Before
    public void init() {
        FlowerDomParser domParser = new FlowerDomParser();
        domParser.parseFlowers("input.xml");
        flowers = domParser.getFlowers();
    }


    @Test
    public void shouldNotReturnNull() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(flowers);
        b.buildXml();

        FlowerDomParser domParser = new FlowerDomParser();
        domParser.parseFlowers("output.xml");
        Assert.assertNotNull(domParser.getFlowers());

    }

    @Test
    public void shouldValidateOutput() {
        FlowerDomParser domParser = new FlowerDomParser();
        domParser.parseFlowers("output.xml");
        Assert.assertTrue(XmlValidator.isValid("output.xml", "input.xsd"));
    }
}
