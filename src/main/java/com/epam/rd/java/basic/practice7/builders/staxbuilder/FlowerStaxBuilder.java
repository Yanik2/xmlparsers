package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import static com.epam.rd.java.basic.practice7.tags.FlowerXmlTags.*;
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

            StartElement startElement = eventFactory.createStartElement("", "", FLOWERS.getValue());
            writer.add(startElement);
            for (Flower f : flowers) {
                makeFlower(f, eventFactory, writer);
            }
            EndElement endElement = eventFactory.createEndElement("", "", FLOWERS.getValue());
            writer.add(endElement);

            EndDocument endDoc = eventFactory.createEndDocument();
            writer.add(endDoc);
        } catch (XMLStreamException | FileNotFoundException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    private void makeFlower(Flower f, XMLEventFactory factory, XMLEventWriter w) throws XMLStreamException {
        StartElement flower = factory.createStartElement("", "", FLOWER.getValue());
        EndElement flowerEnd = factory.createEndElement("", "", FLOWER.getValue());
        w.add(flower);
        makeNode(factory, w, f.getName(), NAME.getValue());
        makeNode(factory, w, f.getSoil(), SOIL.getValue());
        makeNode(factory, w, f.getOrigin(), ORIGIN.getValue());
        StartElement vp = factory.createStartElement("", "", VISUALPARAMS.getValue());
        w.add(vp);
        makeNode(factory, w, f.getVisualParams().getColorOfStem(), COLOROFSTEM.getValue());
        makeNode(factory, w, f.getVisualParams().getColorOfLeaves(), COLOROFLEAVES.getValue());
        makeNode(factory, w, Integer.toString(f.getVisualParams().getAverageSize()), AVERAGESIZE.getValue());
        EndElement vpEnd = factory.createEndElement("", "", VISUALPARAMS.getValue());
        w.add(vpEnd);
        StartElement gt = factory.createStartElement("", "", GROWINGTIPS.getValue());
        w.add(gt);
        makeNode(factory, w, Integer.toString(f.getGrowingTips().getTemperature()), TEMPERATURE.getValue());
        makeNode(factory, w, Boolean.toString(f.getGrowingTips().isLight()), LIGHT.getValue());
        makeNode(factory, w, Integer.toString(f.getGrowingTips().getWatering()), WATERING.getValue());
        EndElement gtEnd = factory.createEndElement("", "", GROWINGTIPS.getValue());
        w.add(gtEnd);
        makeNode(factory, w, f.getMultiplying(), MULTIPLYING.getValue());
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
