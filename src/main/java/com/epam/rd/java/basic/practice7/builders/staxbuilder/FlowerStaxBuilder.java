package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Logger;

public class FlowerStaxBuilder extends AbstractXmlBuilder {
    private static final Logger LOGGER = Logger.getLogger(FlowerStaxBuilder.class.getName());
    private XMLOutputFactory factory;

    public FlowerStaxBuilder(Flowers flowers) {
        super(flowers);
        factory = XMLOutputFactory.newInstance();
    }

    @Override
    public void buildXml() {
        try {
            XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream("output.stax.xml"));

            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            StartDocument doc = eventFactory.createStartDocument("UTF-8", "1.0");
            writer.add(doc);

            StartElement startElement = eventFactory.createStartElement("", "", "flowers");
            writer.add(startElement);
            for (Flower f : flowers) {
                makeFlower(f, eventFactory, writer);
            }
            EndElement endElement = eventFactory.createEndElement("", "", "flowers");
            writer.add(endElement);

            EndDocument endDoc = eventFactory.createEndDocument();
            writer.add(endDoc);
        } catch (XMLStreamException | FileNotFoundException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    private void makeFlower(Flower f, XMLEventFactory factory, XMLEventWriter w) throws XMLStreamException {
        StartElement flower = factory.createStartElement("", "", "flower");
        EndElement flowerEnd = factory.createEndElement("", "", "flower");
        w.add(flower);

        String value = f.getName();
        makeNode(factory, w, value, "name");
        value = f.getSoil();
        makeNode(factory, w, value, "soil");

        value = f.getOrigin();
        makeNode(factory, w, value, "origin");

        StartElement vp = factory.createStartElement("", "", "visualParams");
        w.add(vp);

        value = f.getVisualParams().getColorOfStem();
        makeNode(factory, w, value, "colorOfStem");

        value = f.getVisualParams().getColorOfLeaves();
        makeNode(factory, w, value, "colorOfLeaves");

        value = Integer.toString(f.getVisualParams().getAverageSize());
        makeNode(factory, w, value, "averageSize");

        EndElement vpEnd = factory.createEndElement("", "", "visualParams");
        w.add(vpEnd);

        StartElement gt = factory.createStartElement("", "", "growingTips");
        w.add(gt);

        value = Integer.toString(f.getGrowingTips().getTemperature());
        makeNode(factory, w, value, "temperature");

        value = Boolean.toString(f.getGrowingTips().isLight());
        makeNode(factory, w, value, "light");

        value = Integer.toString(f.getGrowingTips().getWatering());
        makeNode(factory, w, value, "watering");

        EndElement gtEnd = factory.createEndElement("", "", "growingTips");
        w.add(gtEnd);

        value = f.getMultiplying();
        makeNode(factory, w, value, "multiplying");
        w.add(flowerEnd);
    }

    private void makeNode(XMLEventFactory factory, XMLEventWriter w, String value, String tag) throws XMLStreamException {
        StartElement name = factory.createStartElement("", "", tag);
        Characters ch = factory.createCharacters(value);
        EndElement end = factory.createEndElement("", "", tag);
        w.add(name);
        w.add(ch);
        w.add(end);
    }
}
