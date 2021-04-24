package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;

import javax.xml.stream.XMLOutputFactory;
import java.util.List;

public class FlowerStaxBuilder extends AbstractXmlBuilder {

    private XMLOutputFactory factory;
    public FlowerStaxBuilder(List<Flower> flowers) {
        super(flowers);
        factory = XMLOutputFactory.newInstance();
    }

    @Override
    public void buildXml() {

    }
}
