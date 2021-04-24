package com.epam.rd.java.basic.practice7.dombuilder;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FlowerDomBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(new Flowers());
        Assert.assertNotNull(b);
    }

    @Test
    public void shouldReturnLogger() {
        Assert.assertNotNull(FlowerDomXmlBuilder.getLOGGER());
    }

    @Test
    public void shouldCreateFile() {
        FlowerDomParser p = new FlowerDomParser();
        p.parseFlowers("input.xml");
        FlowerDomXmlBuilder b = new FlowerDomXmlBuilder(p.getFlowers());
        b.buildXml();
        File file = new File("output.dom.xml");
        Assert.assertTrue(file.delete());
    }

    @After
    public void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get("output.dom.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
