package com.epam.rd.java.basic.practice7.parsers;

import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.ArrayList;
import java.util.List;

/**This class is abstract class for all parsers
 * @author Yan Zinchenko
 * @version 0.1
 */
public abstract class AbstractFlowerParser {

    protected Flowers flowers;

    protected AbstractFlowerParser() {
        flowers = new Flowers();
    }

    public Flowers getFlowers() {
        return flowers;
    }

    public abstract void parseFlowers(String filename);
}
