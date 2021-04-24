package com.epam.rd.java.basic.practice7.tags;

import org.junit.Assert;
import org.junit.Test;

public class FlowerTagNameTest {

    @Test
    public void shouldReturnName() {
        Assert.assertEquals("name", FlowerXmlTags.NAME.getValue());
    }
}
