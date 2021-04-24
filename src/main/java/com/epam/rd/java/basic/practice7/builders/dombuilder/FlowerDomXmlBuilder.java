package com.epam.rd.java.basic.practice7.builders.dombuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static com.epam.rd.java.basic.practice7.tags.FlowerXmlTags.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**This class is builds xml file using DOM parser
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerDomXmlBuilder extends AbstractXmlBuilder {
    private static final Logger LOGGER = Logger.getLogger(FlowerDomXmlBuilder.class.getName());

    public static Logger getLOGGER() {
        return LOGGER;
    }

    public FlowerDomXmlBuilder(Flowers flowers) {
        super(flowers);
    }
    @Override
    public void buildXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement(FLOWERS.getValue());
            doc.appendChild(root);
            for(Flower flower : flowers) {
                Element item = doc.createElement(FLOWER.getValue());
                Element name = doc.createElement(NAME.getValue());
                name.appendChild(doc.createTextNode(flower.getName()));
                Element soil = doc.createElement(SOIL.getValue());
                soil.appendChild(doc.createTextNode(flower.getSoil()));
                Element origin = doc.createElement(ORIGIN.getValue());
                origin.setTextContent(flower.getOrigin());
                Element visualParams = doc.createElement(VISUALPARAMS.getValue());
                Element colorOfStem = doc.createElement(COLOROFSTEM.getValue());
                colorOfStem.setTextContent(flower.getVisualParams().getColorOfStem());
                Element colorOfLeaves = doc.createElement(COLOROFLEAVES.getValue());
                colorOfLeaves.setTextContent(flower.getVisualParams().getColorOfLeaves());
                Element averageSize = doc.createElement(AVERAGESIZE.getValue());
                averageSize.setTextContent(Integer.toString(flower.getVisualParams().getAverageSize()));
                Element growingTips = doc.createElement(GROWINGTIPS.getValue());
                Element temperature = doc.createElement(TEMPERATURE.getValue());
                temperature.setTextContent(Integer.toString(flower.getGrowingTips().getTemperature()));
                Element light = doc.createElement(LIGHT.getValue());
                light.appendChild(doc.createTextNode(Boolean.toString(flower.getGrowingTips().isLight())));
                Element watering = doc.createElement(WATERING.getValue());
                watering.setTextContent(Integer.toString(flower.getGrowingTips().getWatering()));
                Element multiplying = doc.createElement(MULTIPLYING.getValue());
                multiplying.appendChild(doc.createTextNode(flower.getMultiplying()));

                growingTips.appendChild(temperature);
                growingTips.appendChild(light);
                growingTips.appendChild(watering);

                visualParams.appendChild(colorOfStem);
                visualParams.appendChild(colorOfLeaves);
                visualParams.appendChild(averageSize);

                item.appendChild(name);
                item.appendChild(soil);
                item.appendChild(origin);
                item.appendChild(visualParams);
                item.appendChild(growingTips);
                item.appendChild(multiplying);

                root.appendChild(item);

                write(doc);
            }
        } catch (ParserConfigurationException | TransformerException  | IOException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    private void write(Document doc) throws TransformerException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer tr = factory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream("output.dom.xml"));
        tr.transform(source, result);
    }
}
