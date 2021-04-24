package com.epam.rd.java.basic.practice7.validator;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
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
    public void shouldReturnTrueWhenValidatingOutput() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(p.getFlowers());
        b.buildXml();
        Assert.assertTrue(XmlValidator.isValid("output.dom.xml", "input-no-targetNamespace.xsd"));
    }

    @After
    public void deleteFIle() {
        try {
            Files.deleteIfExists(Paths.get("output.dom.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
