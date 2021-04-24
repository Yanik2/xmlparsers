package com.epam.rd.java.basic.practice7.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.stream.XMLOutputFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FlowerSaxBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(new Flowers());
        Assert.assertNotNull(b);
    }

    @Test
    public void shouldBeInstanceOfLogger() {
        Assert.assertTrue(FlowerSaxBuilder.getLOGGER() instanceof Logger);
    }

    @Test
    public void shouldBeInstanceOfXMLOutputFactory() {
        FlowerSaxBuilder b = new FlowerSaxBuilder(null);
        Assert.assertTrue(b.getFactory() instanceof XMLOutputFactory);
    }

    @Test
    public void shouldCreateFile() throws IOException {
        FlowerSaxParser p = new FlowerSaxParser();
        p.parseFlowers("input.xml");
        FlowerSaxBuilder b = new FlowerSaxBuilder(p.getFlowers());
        Assert.assertTrue(Files.deleteIfExists(Paths.get("output.sax.xml")));
    }

    @After
    public void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get("output.sax.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
