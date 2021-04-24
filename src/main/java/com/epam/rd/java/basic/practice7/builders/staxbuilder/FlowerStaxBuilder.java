package com.epam.rd.java.basic.practice7.builders.staxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.builders.saxbuilder.FlowerSaxBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FlowerStaxBuilder extends AbstractXmlBuilder {

    private XMLOutputFactory factory;
    public FlowerStaxBuilder(List<Flower> flowers) {
        super(flowers);
        factory = XMLOutputFactory.newInstance();
    }

    @Override
    public void buildXml() {
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("output.stax.xml"), "cp1251");
            writer.writeStartDocument("cp1251", "1.0");
            writer.writeStartElement("flowers");
            for(Flower f : flowers) {
                writer.writeStartElement("flower");

                writer.writeStartElement("name");
                writer.writeCharacters(f.getName());
                writer.writeEndElement();

                writer.writeStartElement("soil");
                writer.writeAttribute("typeOfSoil", f.getSoil());
                writer.writeEndElement();

                writer.writeStartElement("origin");
                writer.writeCharacters(f.getOrigin());
                writer.writeEndElement();

                writer.writeStartElement("visualParams");
                writer.writeStartElement("colorOfStem");
                writer.writeCharacters(f.getVisualParams().getColorOfStem());
                writer.writeEndElement();

                writer.writeStartElement("colorOfLeaves");
                writer.writeCharacters(f.getVisualParams().getColorOfLeaves());
                writer.writeEndElement();

                writer.writeStartElement("averageSize");
                writer.writeCharacters(Integer.toString(f.getVisualParams().getAverageSize()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("growingTips");
                writer.writeStartElement("temperature");
                writer.writeCharacters(Integer.toString(f.getGrowingTips().getTemperature()));
                writer.writeEndElement();

                writer.writeStartElement("light");
                writer.writeAttribute("condition", Boolean.toString(f.getGrowingTips().isLight()));
                writer.writeEndElement();

                writer.writeStartElement("watering");
                writer.writeCharacters(Integer.toString(f.getGrowingTips().getWatering()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("multiplying");
                writer.writeAttribute("method", f.getMultiplying());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
