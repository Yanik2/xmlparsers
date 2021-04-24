package com.epam.rd.java.basic.practice7.validator;

import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    @Test
    public void shouldReturnTrueWhenValidatingInput() {
        boolean isValid = XmlValidator.isValid("input.xml", "input.xsd");
        Assert.assertTrue(isValid);
    }
}
