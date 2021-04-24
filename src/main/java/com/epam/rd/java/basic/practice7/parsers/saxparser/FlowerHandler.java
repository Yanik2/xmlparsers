package com.epam.rd.java.basic.practice7.parsers.saxparser;

import com.epam.rd.java.basic.practice7.container.Flowers;
import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.tags.FlowerXmlTags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;

public class FlowerHandler extends DefaultHandler {
    private final Flowers flowers;
    private Flower current;
    private FlowerXmlTags currentTag;
    private final EnumSet<FlowerXmlTags> withText;
    private static final String FLOWER_ELEMENT = "flower";

    public FlowerHandler() {
        flowers = new Flowers();
        withText = EnumSet.range(FlowerXmlTags.NAME, FlowerXmlTags.MULTIPLYING);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(FLOWER_ELEMENT)) {
            current = new Flower();
            return;
        }

        FlowerXmlTags tmp = FlowerXmlTags.valueOf(qName.toUpperCase());
        if (withText.contains(tmp)) {
            currentTag = tmp;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if(currentTag != null) {
            switch (currentTag) {
                case NAME:
                    current.setName(data);
                    break;
                case ORIGIN:
                    current.setOrigin(data);
                    break;
                case SOIL:
                    current.setSoil(data);
                    break;
                case COLOROFSTEM:
                    current.getVisualParams().setColorOfStem(data);
                    break;
                case COLOROFLEAVES:
                    current.getVisualParams().setColorOfLeaves(data);
                    break;
                case AVERAGESIZE:
                    current.getVisualParams().setAverageSize(Integer.parseInt(data));
                    break;
                case TEMPERATURE:
                    current.getGrowingTips().setTemperature(Integer.parseInt(data));
                    break;
                case WATERING:
                    current.getGrowingTips().setWatering(Integer.parseInt(data));
                    break;

                case LIGHT:
                    current.getGrowingTips().setLight(Boolean.parseBoolean(data));
                    break;
                case MULTIPLYING:
                    current.setMultiplying(data);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
            }
        }
        currentTag = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals(FLOWER_ELEMENT)) {
            flowers.add(current);
        }
    }

    public Flowers getFlowers() {
        return flowers;
    }
}
