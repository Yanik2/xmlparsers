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
            NodeList nodes = root.getElementsByTagName("flower");
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
        flower.setName(getElementTextContent(flowerElement, "name"));
        flower.setOrigin(getElementTextContent(flowerElement, "origin"));
        Element soil = (Element)flowerElement.getElementsByTagName("soil").item(0);
        flower.setSoil(soil.getAttribute("typeOfSoil"));
        Element visualParams = (Element)flowerElement.getElementsByTagName("visualParams").item(0);
        flower.setVisualParams(buildVisualParams(visualParams));
        Element growingTips = (Element)flowerElement.getElementsByTagName("growingTips").item(0);
        flower.setGrowingTips(buildGrowingTips(growingTips));
        Element multiplying = (Element) flowerElement.getElementsByTagName("multiplying").item(0);
        flower.setMultiplying(multiplying.getAttribute("method"));
        return flower;
    }

    private VisualParams buildVisualParams(Element el) {
        VisualParams visualParams = new VisualParams();
        visualParams.setColorOfStem(getElementTextContent(el, "colorOfStem"));
        visualParams.setColorOfLeaves(getElementTextContent(el, "colorOfLeaves"));
        visualParams.setAverageSize(Integer.parseInt(getElementTextContent(el, "averageSize")));
        return visualParams;
    }

    private GrowingTips buildGrowingTips(Element el) {
        GrowingTips tips = new GrowingTips();
        Element light = (Element) el.getElementsByTagName("light").item(0);
        tips.setLight(Boolean.parseBoolean(light.getAttribute("condition")));
        tips.setTemperature(Integer.parseInt(getElementTextContent(el, "temperature")));
        tips.setWatering(Integer.parseInt(getElementTextContent(el, "watering")));
        return tips;
    }

    private String getElementTextContent(Element el, String name) {
        Node node = el.getElementsByTagName(name).item(0);
        return node.getTextContent();
    }
}
