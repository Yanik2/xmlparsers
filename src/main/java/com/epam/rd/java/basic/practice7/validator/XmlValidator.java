package com.epam.rd.java.basic.practice7.validator;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * This class is validator for xml files
 *
 * @author Yan Zinchenko
 * @version 0.1
 */
public class XmlValidator {
    private static final Logger LOGGER = Logger.getLogger(XmlValidator.class.getName());

    private XmlValidator() {
    }

    public static boolean isValid(String filename, String schemaName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            File schemaLocation = new File(schemaName);
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(filename);
            validator.setErrorHandler(new FlowerErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            LOGGER.severe(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * Error handler for validator
     */
    private static class FlowerErrorHandler implements ErrorHandler {
        @Override
        public void warning(SAXParseException e) throws SAXException {
            LOGGER.warning(getLineColumnNumber(e) + " - " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            LOGGER.severe(getLineColumnNumber(e) + " - " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            LOGGER.severe(getLineColumnNumber(e) + " - " + e.getMessage());
        }

        private String getLineColumnNumber(SAXParseException e) {
            return e.getLineNumber() + " : " + e.getColumnNumber();
        }
    }
}
