package com.epam.rd.java.basic.practice7.parsers.staxparser;

import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.AbstractFlowerParser;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

/**
 * This class extends AbstractFlowerParser, and parses xml file
 *
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerStaxParser extends AbstractFlowerParser {
    private static final Logger LOGGER = Logger.getLogger(FlowerStaxParser.class.getName());
    private final XMLInputFactory factory;
    private XMLEventReader reader;
    private Flower current;

    public FlowerStaxParser() {
        factory = XMLInputFactory.newInstance();
        factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        factory.setProperty("javax.xml.stream.isSupportingExternalEntities", false);
    }

    @Override
    public void parseFlowers(String filename) {
       current = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            reader = factory.createXMLEventReader(file);

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    event = makeStart(event, startElement);
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if ("flower".equals(endElement.getName().getLocalPart())) {
                        flowers.add(current);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
           LOGGER.severe(e.getMessage());
        }
    }

    private XMLEvent makeStart(XMLEvent event, StartElement startElement) throws XMLStreamException {
        if ("flower".equals(startElement.getName().getLocalPart())) {
            current = new Flower();
        } else if ("multiplying".equals(startElement.getName().getLocalPart())) {
            event = reader.nextEvent();
            current.setMultiplying(event.asCharacters().getData());
        } else if ("name".equals(startElement.getName().getLocalPart())) {
            event = reader.nextEvent();
            current.setName(event.asCharacters().getData());
        } else if ("origin".equals(startElement.getName().getLocalPart())) {
            event = reader.nextEvent();
            current.setOrigin(event.asCharacters().getData());
        } else if ("soil".equals(startElement.getName().getLocalPart())) {
            event = reader.nextEvent();
            current.setSoil(event.asCharacters().getData());
        } else if (startElement.isStartElement()) {
            StartElement startElement1 = event.asStartElement();
            buildGrowingTips(startElement1, current);
            buildVisualParams(startElement1, current);
        }
        return event;
    }

    private void buildVisualParams(StartElement el, Flower flower) throws XMLStreamException {
        XMLEvent event;
        if ("colorOfStem".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getVisualParams().setColorOfStem(event.asCharacters().getData());
        } else if ("colorOfLeaves".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getVisualParams().setColorOfLeaves(event.asCharacters().getData());
        } else if ("averageSize".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getVisualParams().setAverageSize(Integer.parseInt(event.asCharacters().getData()));
        }
    }

    private void buildGrowingTips(StartElement el, Flower flower) throws XMLStreamException {
        XMLEvent event;
        if ("temperature".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getGrowingTips().setTemperature(Integer.parseInt(event.asCharacters().getData()));
        } else if ("light".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getGrowingTips().setLight(Boolean.parseBoolean(event.asCharacters().getData()));
        } else if ("watering".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getGrowingTips().setWatering(Integer.parseInt(event.asCharacters().getData()));
        }
    }

}
