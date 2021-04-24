package com.epam.rd.java.basic.practice7.parsers.staxparser;

import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.parsers.AbstractFlowerParser;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This class extends AbstractFlowerParser, and parses xml file
 *
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerStaxParser extends AbstractFlowerParser {
    private XMLInputFactory factory;
    //    private XMLEvent event;
    private XMLEventReader reader;

    public FlowerStaxParser() {
        factory = XMLInputFactory.newInstance();
    }

    @Override
    public void parseFlowers(String filename) {
        Flower flower = null;

        try {
            FileInputStream file = new FileInputStream(filename);
            reader = factory.createXMLEventReader(file);

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    if ("flower".equals(startElement.getName().getLocalPart())) {
                        flower = new Flower();
                    } else if ("multiplying".equals(startElement.getName().getLocalPart())) {
//                        Attribute method = startElement.getAttributeByName(new QName("method"));
//                        flower.setMultiplying(method.getValue());
                        event = reader.nextEvent();
                        flower.setMultiplying(event.asCharacters().getData());
                    } else if ("name".equals(startElement.getName().getLocalPart())) {
                        event = reader.nextEvent();
                        flower.setName(event.asCharacters().getData());
                    } else if ("origin".equals(startElement.getName().getLocalPart())) {
                        event = reader.nextEvent();
                        flower.setOrigin(event.asCharacters().getData());
                    } else if ("soil".equals(startElement.getName().getLocalPart())) {
//                        Attribute attr = startElement.getAttributeByName(new QName("typeOfSoil"));
//                        flower.setSoil(attr.getValue());
                        event = reader.nextEvent();
                        flower.setSoil(event.asCharacters().getData());
                    } else if (startElement.isStartElement()) {
                        StartElement startElement1 = event.asStartElement();
                        buildGrowingTips(startElement1, flower, event);
                        buildVisualParams(startElement1, flower, event);
                    }
                }
                if (event.isEndElement()) {
                    EndElement endElement = event.asEndElement();
                    if ("flower".equals(endElement.getName().getLocalPart())) {
                        flowers.add(flower);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void buildVisualParams(StartElement el, Flower flower, XMLEvent event) throws XMLStreamException {
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

    private void buildGrowingTips(StartElement el, Flower flower, XMLEvent event) throws XMLStreamException {
        if ("temperature".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getGrowingTips().setTemperature(Integer.parseInt(event.asCharacters().getData()));
        } else if ("light".equals(el.getName().getLocalPart())) {
//            Attribute condition = el.getAttributeByName(new QName("condition"));
//            flower.getGrowingTips().setLight(Boolean.parseBoolean(condition.getValue()));
            event = reader.nextEvent();
            flower.getGrowingTips().setLight(Boolean.parseBoolean(event.asCharacters().getData()));
        } else if ("watering".equals(el.getName().getLocalPart())) {
            event = reader.nextEvent();
            flower.getGrowingTips().setWatering(Integer.parseInt(event.asCharacters().getData()));
        }
    }

}
