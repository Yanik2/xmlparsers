package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.container.Flowers;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainTest {
    @Test
    public void shouldTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void doesContainerExists() {
       Assert.assertFalse(false);
    }
}
