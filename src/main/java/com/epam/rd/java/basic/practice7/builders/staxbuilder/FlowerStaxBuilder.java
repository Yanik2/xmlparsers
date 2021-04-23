package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.List;

public class FlowerStaxBuilder extends AbstractXmlBuilder {

    public FlowerStaxBuilder(List<Flower> flowers) {
        super(flowers);
    }

    @Override
    public void buildXml() {

    }
}
