package com.epam.rd.java.basic.practice7.builders;

import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.ArrayList;
import java.util.List;

/**This is abstract class for classes who builds XML
 * @author Yan Zinchenko
 * @version 0.1
 */
public abstract class AbstractXmlBuilder {
    protected List<Flower> flowers;

    public AbstractXmlBuilder(List<Flower> flowers) {
        this.flowers = new ArrayList<>(flowers);
    }

    public AbstractXmlBuilder() {
        this.flowers = new ArrayList<>();
    }

    public abstract void buildXml();
}
