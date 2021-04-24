package com.epam.rd.java.basic.practice7.builders.dombuilder;

import com.epam.rd.java.basic.practice7.builders.AbstractXmlBuilder;
import com.epam.rd.java.basic.practice7.item.Flower;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

/**This class is builds xml file using DOM parser
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerDomXmlBuilder extends AbstractXmlBuilder {
    private static Logger logger = Logger.getLogger(FlowerDomXmlBuilder.class.getName());

    public FlowerDomXmlBuilder(List<Flower> flowers) {
        super(flowers);
    }
    @Override
    public void buildXml() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("flowers");
            doc.appendChild(root);
            for(Flower flower : flowers) {
                Element item = doc.createElement("flower");
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(flower.getName()));
                Element soil = doc.createElement("soil");
                soil.setAttribute("typeOfSoil", flower.getSoil());
                Element origin = doc.createElement("origin");
                origin.setTextContent(flower.getOrigin());
                Element visualParams = doc.createElement("visualParams");
                Element colorOfStem = doc.createElement("colorOfStem");
                colorOfStem.setTextContent(flower.getVisualParams().getColorOfStem());
                Element colorOfLeaves = doc.createElement("colorOfLeaves");
                colorOfLeaves.setTextContent(flower.getVisualParams().getColorOfLeaves());
                Element averageSize = doc.createElement("averageSize");
                averageSize.setTextContent(Integer.toString(flower.getVisualParams().getAverageSize()));
                Element growingTips = doc.createElement("growingTips");
                Element temperature = doc.createElement("temperature");
                temperature.setTextContent(Integer.toString(flower.getGrowingTips().getTemperature()));
                Element light = doc.createElement("light");
                light.setAttribute("condition", Boolean.toString(flower.getGrowingTips().isLight()));
                Element watering = doc.createElement("watering");
                watering.setTextContent(Integer.toString(flower.getGrowingTips().getWatering()));
                Element multiplying = doc.createElement("multiplying");
                multiplying.setAttribute("method", flower.getMultiplying());

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
        } catch (ParserConfigurationException | TransformerException e) {
            logger.severe(e.getMessage());
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }

    }

    private void write(Document doc) throws TransformerException, IOException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer tr = factory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileWriter("output.xml"));
        tr.transform(source, result);
    }
}
