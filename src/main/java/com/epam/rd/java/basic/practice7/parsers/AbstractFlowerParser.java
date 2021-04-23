package com.epam.rd.java.basic.practice7.parsers;

import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.ArrayList;
import java.util.List;

/**This class is abstract class for all parsers
 * @author Yan Zinchenko
 * @version 0.1
 */
public abstract class AbstractFlowerParser {

    protected List<Flower> flowers;

    protected AbstractFlowerParser() {
        flowers = new ArrayList<>();
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public abstract void parseFlowers(String filename);
}
