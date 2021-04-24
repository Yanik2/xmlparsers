package com.epam.rd.java.basic.practice7.parsers.domparser;

import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.item.GrowingTips;
import com.epam.rd.java.basic.practice7.item.VisualParams;
import com.epam.rd.java.basic.practice7.parsers.AbstractFlowerParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import static com.epam.rd.java.basic.practice7.tags.FlowerXmlTags.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.logging.Logger;

/**This class is parsing xml file
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerDomParser extends AbstractFlowerParser {
    private static final Logger logger = Logger.getLogger(FlowerDomParser.class.getName());
    private DocumentBuilder documentBuilder;

    public FlowerDomParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    public void parseFlowers(String filename) {
        try {
            Document doc = documentBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList nodes = root.getElementsByTagName(FLOWER.getValue());
            for(int i = 0; i < nodes.getLength(); i++) {
                Element flowerElement = (Element)nodes.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (IOException | SAXException e) {
            logger.severe(e.getMessage());
        }
    }

    /**Method for build Flower object from xml file
     *
     * @param flowerElement - node in xml
     * @return Flower object
     */
    private Flower buildFlower(Element flowerElement) {
        Flower flower = new Flower();
        flower.setName(getElementTextContent(flowerElement, NAME.getValue()));
        flower.setOrigin(getElementTextContent(flowerElement, ORIGIN.getValue()));
        flower.setSoil(getElementTextContent(flowerElement, SOIL.getValue()));
        Element visualParams = (Element)flowerElement.getElementsByTagName(VISUALPARAMS.getValue()).item(0);
        flower.setVisualParams(buildVisualParams(visualParams));
        Element growingTips = (Element)flowerElement.getElementsByTagName(GROWINGTIPS.getValue()).item(0);
        flower.setGrowingTips(buildGrowingTips(growingTips));
        flower.setMultiplying(getElementTextContent(flowerElement, MULTIPLYING.getValue()));
        return flower;
    }

    private VisualParams buildVisualParams(Element el) {
        VisualParams visualParams = new VisualParams();
        visualParams.setColorOfStem(getElementTextContent(el, COLOROFSTEM.getValue()));
        visualParams.setColorOfLeaves(getElementTextContent(el, COLOROFLEAVES.getValue()));
        visualParams.setAverageSize(Integer.parseInt(getElementTextContent(el, AVERAGESIZE.getValue())));
        return visualParams;
    }

    private GrowingTips buildGrowingTips(Element el) {
        GrowingTips tips = new GrowingTips();
        tips.setLight(Boolean.parseBoolean(getElementTextContent(el, LIGHT.getValue())));
        tips.setTemperature(Integer.parseInt(getElementTextContent(el, TEMPERATURE.getValue())));
        tips.setWatering(Integer.parseInt(getElementTextContent(el, WATERING.getValue())));
        return tips;
    }

    private String getElementTextContent(Element el, String name) {
        Node node = el.getElementsByTagName(name).item(0);
        return node.getTextContent();
    }

    public static Logger getLogger() {
        return logger;
    }

    public DocumentBuilder getDocumentBuilder() {
        return documentBuilder;
    }
}
