package com.epam.rd.java.basic.practice7.builders.saxbuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import static com.epam.rd.java.basic.practice7.tags.FlowerXmlTags.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**This class builds xml file with Sax
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerSaxBuilder extends AbstractXmlBuilder {
    private static final Logger LOGGER = Logger.getLogger(FlowerSaxBuilder.class.getName());
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
            writer.writeStartElement(FLOWERS.getValue());
            for(Flower f : flowers) {
                writer.writeStartElement(FLOWER.getValue());
                makeNode(writer, f.getName(), NAME.getValue());
                makeNode(writer, f.getSoil(), SOIL.getValue());
                makeNode(writer, f.getOrigin(), ORIGIN.getValue());
                writer.writeStartElement(VISUALPARAMS.getValue());
                makeNode(writer, f.getVisualParams().getColorOfStem(), COLOROFSTEM.getValue());
                makeNode(writer, f.getVisualParams().getColorOfLeaves(), COLOROFLEAVES.getValue());
                makeNode(writer, Integer.toString(f.getVisualParams().getAverageSize()), AVERAGESIZE.getValue());
                writer.writeEndElement();
                writer.writeStartElement(GROWINGTIPS.getValue());
                makeNode(writer, Integer.toString(f.getGrowingTips().getTemperature()), TEMPERATURE.getValue());
                makeNode(writer, Boolean.toString(f.getGrowingTips().isLight()), LIGHT.getValue());
                makeNode(writer, Integer.toString(f.getGrowingTips().getWatering()), WATERING.getValue());
                writer.writeEndElement();
                makeNode(writer, f.getMultiplying(), MULTIPLYING.getValue());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
           LOGGER.severe(e.getMessage());
        }
    }

    private void makeNode(XMLStreamWriter w, String value, String tag) throws XMLStreamException {
        w.writeStartElement(tag);
        w.writeCharacters(value);
        w.writeEndElement();
    }
    public static Logger getLOGGER() {
        return LOGGER;
    }

    public XMLOutputFactory getFactory() {
        return factory;
    }
}
