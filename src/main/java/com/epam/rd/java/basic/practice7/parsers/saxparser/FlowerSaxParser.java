package com.epam.rd.java.basic.practice7.parsers.saxparser;

import com.epam.rd.java.basic.practice7.parsers.AbstractFlowerParser;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.logging.Logger;

/**This is SaxParser
 * @author Yan Zinchenko
 * @version 0.1
 */
public class FlowerSaxParser extends AbstractFlowerParser {
    private static final Logger logger = Logger.getLogger(FlowerSaxParser.class.getName());

    private final FlowerHandler handler;
    private XMLReader reader;

    public FlowerSaxParser() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        handler = new FlowerHandler();
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
        } catch(SAXException | ParserConfigurationException e) {
            logger.severe(e.getMessage());
        }
        reader.setContentHandler(handler);
    }

    @Override
    public void parseFlowers(String filename) {
        try {
            reader.parse(filename);
        } catch(SAXException | IOException e) {
            logger.severe(e.getMessage());
        }
        flowers = handler.getFlowers();
    }
}
