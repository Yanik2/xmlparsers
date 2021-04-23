package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import com.epam.rd.java.basic.practice7.validator.XmlValidator;

public final class Main {

    public static void main(final String[] args) {
//        FlowerDomParser domParser = new FlowerDomParser();
//        domParser.parseFlowers("input.xml");
//        System.out.println(domParser.getFlowers());
//        FlowerSaxParser saxParser = new FlowerSaxParser();
//        saxParser.parseFlowers("input.xml");
//        System.out.println(saxParser.getFlowers());
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");
//        System.out.println(p.getFlowers());
//        FlowerDomXmlBuilder builder = new FlowerDomXmlBuilder(p.getFlowers());
//        builder.buildXml();
//        XmlValidator.isValid("output.xml", "input.xsd");
        FlowerSaxBuilder b = new FlowerSaxBuilder(p.getFlowers());
        b.buildXml();
        XmlValidator.isValid("output.xml", "input.xsd");
    }
}
