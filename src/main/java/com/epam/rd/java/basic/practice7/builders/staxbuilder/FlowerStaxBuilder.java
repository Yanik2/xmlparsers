package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;

import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class FlowerStaxBuilder extends AbstractXmlBuilder {

    private XMLOutputFactory factory;
    public FlowerStaxBuilder(Flowers flowers) {
        super(flowers);
        factory = XMLOutputFactory.newInstance();
    }

    @Override
    public void buildXml() {
        try {
            XMLEventWriter writer = factory.createXMLEventWriter(new FileOutputStream("output.stax.xml"));

            XMLEventFactory factory = XMLEventFactory.newInstance();
            StartDocument doc = factory.createStartDocument("UTF-8", "1.0");
            writer.add(doc);



            StartElement startElement = factory.createStartElement("", "", "flowers");
            writer.add(startElement);
            for(Flower f : flowers) {
                makeFlower(f, factory, writer);
            }
            EndElement endElement = factory.createEndElement("", "", "flowers");
            writer.add(endElement);

            EndDocument endDoc = factory.createEndDocument();
            writer.add(endDoc);


//            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("output.stax.xml"));
//            writer.writeStartDocument("UTF-8", "1.0");
//            writer.writeStartElement("flowers");
//            for(Flower f : flowers) {
//                writer.writeStartElement("flower");
//
//                writer.writeStartElement("name");
//                writer.writeCharacters(f.getName());
//                writer.writeEndElement();
//
//                writer.writeStartElement("soil");
////                writer.writeAttribute("typeOfSoil", f.getSoil());
//                writer.writeCharacters(f.getSoil());
//                writer.writeEndElement();
//
//                writer.writeStartElement("origin");
//                writer.writeCharacters(f.getOrigin());
//                writer.writeEndElement();
//
//                writer.writeStartElement("visualParams");
//                writer.writeStartElement("colorOfStem");
//                writer.writeCharacters(f.getVisualParams().getColorOfStem());
//                writer.writeEndElement();
//
//                writer.writeStartElement("colorOfLeaves");
//                writer.writeCharacters(f.getVisualParams().getColorOfLeaves());
//                writer.writeEndElement();
//
//                writer.writeStartElement("averageSize");
//                writer.writeCharacters(Integer.toString(f.getVisualParams().getAverageSize()));
//                writer.writeEndElement();
//                writer.writeEndElement();
//
//                writer.writeStartElement("growingTips");
//                writer.writeStartElement("temperature");
//                writer.writeCharacters(Integer.toString(f.getGrowingTips().getTemperature()));
//                writer.writeEndElement();
//
//                writer.writeStartElement("light");
////                writer.writeAttribute("condition", Boolean.toString(f.getGrowingTips().isLight()));
//                writer.writeCharacters(Boolean.toString(f.getGrowingTips().isLight()));
//                writer.writeEndElement();
//
//                writer.writeStartElement("watering");
//                writer.writeCharacters(Integer.toString(f.getGrowingTips().getWatering()));
//                writer.writeEndElement();
//                writer.writeEndElement();
//
//                writer.writeStartElement("multiplying");
////                writer.writeAttribute("method", f.getMultiplying());
//                writer.writeCharacters(f.getMultiplying());
//                writer.writeEndElement();
//
//                writer.writeEndElement();
            } catch (XMLStreamException xmlStreamException) {
            xmlStreamException.printStackTrace();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
//            writer.writeEndElement();
//            writer.writeEndDocument();
//            writer.flush();
//        } catch (XMLStreamException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
