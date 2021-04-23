package com.epam.rd.java.basic.practice7.dombuilder;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import com.epam.rd.java.basic.practice7.validator.XmlValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FlowerDomXmlBuilderTest {
    private List<Flower> flowers;
    @Before
    public void intiList() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        flowers = p.getFlowers();
    }
    @Test
    public void shouldNotReturnNull() {
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(flowers);

        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("output.xml");
        Assert.assertNotNull(p.getFlowers());
    }

    @Test
    public void sholdValidateOutputFileWithSchema() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("output.xml");
        XmlValidator.isValid("output.xml", "input.xsd");
    }
}
