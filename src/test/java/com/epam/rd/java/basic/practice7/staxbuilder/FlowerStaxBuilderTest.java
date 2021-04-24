package com.epam.rd.java.basic.practice7.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.staxbuilder.FlowerStaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FlowerStaxBuilderTest {
    @Test
    public void shouldNotNull() {
        FlowerStaxBuilder b = new FlowerStaxBuilder(new Flowers());
        Assert.assertNotNull(b);
    }

    @Test
    public void shouldCreateFile() throws IOException {
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
        FlowerStaxBuilder b = new FlowerStaxBuilder(p.getFlowers());
        Assert.assertTrue(Files.deleteIfExists(Paths.get("output.stax.xml")));
    }

    @After
    public void deleteFile() {
        try {
            Files.deleteIfExists(Paths.get("output.stax.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
