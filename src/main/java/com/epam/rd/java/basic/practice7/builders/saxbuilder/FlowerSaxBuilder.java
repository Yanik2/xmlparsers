package com.epam.rd.java.basic.practice7.builders.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**This class builds xml file with Sax
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerSaxBuilder extends AbstractXmlBuilder {
    private XMLOutputFactory factory;

    public FlowerSaxBuilder(Flowers flowers) {
        super(flowers);
        factory = XMLOutputFactory.newInstance();
    }

    @Override
    public void buildXml() {
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("output.sax.xml"));
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("flowers");
            for(Flower f : flowers) {
                writer.writeStartElement("flower");

                writer.writeStartElement("name");
                writer.writeCharacters(f.getName());
                writer.writeEndElement();

                writer.writeStartElement("soil");
                writer.writeCharacters(f.getSoil());
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
                writer.writeCharacters(Boolean.toString(f.getGrowingTips().isLight()));
                writer.writeEndElement();

                writer.writeStartElement("watering");
                writer.writeCharacters(Integer.toString(f.getGrowingTips().getWatering()));
                writer.writeEndElement();
                writer.writeEndElement();

                writer.writeStartElement("multiplying");
                writer.writeCharacters(f.getMultiplying());
                writer.writeEndElement();

                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
