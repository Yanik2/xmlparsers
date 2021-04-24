package com.epam.rd.java.basic.practice7;

import com.epam.rd.java.basic.practice7.builders.dombuilder.FlowerDomXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.builders.staxbuilder.FlowerStaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.domparser.FlowerDomParser;
import com.epam.rd.java.basic.practice7.parsers.saxparser.FlowerSaxParser;
import com.epam.rd.java.basic.practice7.parsers.staxparser.FlowerStaxParser;
import com.epam.rd.java.basic.practice7.validator.XmlValidator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Main {

    public static void main(final String[] args) {
//        FlowerDomParser domParser = new FlowerDomParser();
//        domParser.parseFlowers(args[0]);
//
//
//
//        FlowerSaxParser saxParser = new FlowerSaxParser();
//        saxParser.parseFlowers(args[0]);

//
        FlowerStaxParser p = new FlowerStaxParser();
        p.parseFlowers("input.xml");

//

        Flowers sorted = sort3(p.getFlowers(), (f1, f2) -> f1.getName().compareTo(f2.getName()));
        System.out.println(sorted);
        FlowerDomXmlBuilder builder = new FlowerDomXmlBuilder(p.getFlowers());
        builder.buildXml();
//
        FlowerSaxBuilder b = new FlowerSaxBuilder(p.getFlowers());
        b.buildXml();
////
        FlowerStaxBuilder staxBuilder = new FlowerStaxBuilder(p.getFlowers());
        staxBuilder.buildXml();
    }

    public static Flowers sort1(Flowers flowers, Comparator<Flower> comparator) {
        List<Flower> f = flowers.getFlowers();
        boolean flag = true;
        while(flag) {
            flag = false;
            for(int i = 0; i < f.size() - 1; i++) {

                if(comparator.compare(f.get(i), f.get(i + 1)) > 0) {
                    flag = true;
                    Collections.swap(f, i, i + 1);
                }
            }
        }
        return new Flowers(f);
    }

    public static Flowers sort2(Flowers flowers, Comparator<Flower> comparator) {
        List<Flower> f = flowers.getFlowers();
        boolean flag = true;
        while(flag) {
            flag = false;
            for(int i = 0; i < f.size() - 1; i++) {

                if(comparator.compare(f.get(i), f.get(i + 1)) < 0) {
                    flag = true;
                    Collections.swap(f, i, i + 1);
                }
            }
        }
        return new Flowers(f);
    }
    public static Flowers sort3(Flowers flowers, Comparator<Flower> comparator) {
        List<Flower> f = flowers.getFlowers();
        for(int i = 0; i < f.size(); i++) {
            Flower min = f.get(i);
            for(int j = 0; j < f.size() - 1; j++) {
                if(comparator.compare(min, f.get(j)) < 0) {
                    Collections.swap(f, i, j);
                    min = f.get(j);
                }
            }
        }
        return new Flowers(f);
    }
}
