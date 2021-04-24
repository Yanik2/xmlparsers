package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.builders.staxbuilder.FlowerStaxBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import com.epam.rd.java.basic.practice7.validator.XmlValidator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Main {

    public static void main(final String[] args) {
        FlowerDomParser domParser = new FlowerDomParser();
        domParser.parseFlowers(args[0]);



        FlowerSaxParser saxParser = new FlowerSaxParser();
        saxParser.parseFlowers(args[0]);

//
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers(args[0]);

//
//        List<Flower> flowers = p.getFlowers();
//        sort1(flowers, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        FlowerDomXmlBuilder builder = new FlowerDomXmlBuilder(p.getFlowers());
        builder.buildXml();
//
        FlowerSaxBuilder b = new FlowerSaxBuilder(p.getFlowers());
        b.buildXml();
////
        FlowerStaxBuilder staxBuilder = new FlowerStaxBuilder(p.getFlowers());
        staxBuilder.buildXml();
    }

    private static void sort1(List<Flower> flowers, Comparator<Flower> comparator) {
        Collections.sort(flowers, comparator);
    }

    private static void sort2(List<Flower> flowers, Comparator<Flower> comparator) {
        Collections.sort(flowers, comparator);
    }
    private static void sort3(List<Flower> flowers, Comparator<Flower> comparator) {
        Collections.sort(flowers, comparator);
    }
}
