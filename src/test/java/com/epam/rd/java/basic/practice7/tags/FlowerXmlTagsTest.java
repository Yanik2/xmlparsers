package com.epam.rd.java.basic.practice7.tags;

import org.junit.Assert;
import org.junit.Test;

public class FlowerXmlTagsTest {
    @Test
    public void shouldNotReturnNull() {
        Assert.assertNotNull(FlowerXmlTags.FLOWER.getValue());
    }

    @Test
    public void shouldReturnFlower() {
        Assert.assertEquals("flower",FlowerXmlTags.FLOWER.getValue());
    }
}
