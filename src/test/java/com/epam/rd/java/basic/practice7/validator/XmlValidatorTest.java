package com.epam.rd.java.basic.practice7.validator;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.builders.staxbuilder.FlowerStaxBuilder;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlValidatorTest {
    @Test
    public void shouldReturnTrueWhenValidatingInput() {
        boolean isValid = XmlValidator.isValid("input.xml", "input.xsd");
        Assert.assertTrue(isValid);
    }

    @Test
    public void shouldReturnTrueWhenValidatingOutputDom() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(p.getFlowers());
        b.buildXml();
        Assert.assertTrue(XmlValidator.isValid("output.dom.xml", "input-no-targetNamespace.xsd"));
    }

    @Test
    public void shouldReturnTrueWhenValidatingOutputSax() {
        FlowerSaxParser p = new FlowerSaxParser();
        p.parseFlowers("input.xml");
        FlowerSaxBuilder b = new FlowerSaxBuilder(p.getFlowers());
        b.buildXml();
        Assert.assertTrue(XmlValidator.isValid("output.sax.xml", "input-no-targetNamespace.xsd"));
    }

    @Test
    public void shouldReturnTrueWhenValidatingOutputStax() {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        FlowerStaxBuilder b = new FlowerStaxBuilder(p.getFlowers());
        b.buildXml();
        Assert.assertTrue(XmlValidator.isValid("output.stax.xml", "input-no-targetNamespace.xsd"));
    }

    @After
    public void deleteFIle() {
        try {
            Files.deleteIfExists(Paths.get("output.dom.xml"));
            Files.deleteIfExists(Paths.get("output.sax.xml"));
            Files.deleteIfExists(Paths.get("output.stax.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
