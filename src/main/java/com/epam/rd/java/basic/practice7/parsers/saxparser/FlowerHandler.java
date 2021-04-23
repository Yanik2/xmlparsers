package com.epam.rd.java.basic.practice7.parsers.saxparser;

import com.epam.rd.java.basic.practice7.item.Flower;
import com.epam.rd.java.basic.practice7.tags.FlowerXmlTags;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FlowerHandler extends DefaultHandler {
    private final List<Flower> flowers;
    private Flower current;
    private FlowerXmlTags currentTag;
    private final EnumSet<FlowerXmlTags> withText;
    private final EnumSet<FlowerXmlTags> withAttr;
    private static final String FLOWER_ELEMENT = "flower";

    public FlowerHandler() {
        flowers = new ArrayList<>();
        withText = EnumSet.range(FlowerXmlTags.NAME, FlowerXmlTags.WATERING);
        withAttr = EnumSet.range(FlowerXmlTags.SOIL, FlowerXmlTags.MULTIPLYING);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(FLOWER_ELEMENT)) {
            current = new Flower();
            return;
        }

        FlowerXmlTags tmp = FlowerXmlTags.valueOf(qName.toUpperCase());
        if (withAttr.contains(tmp) || withText.contains(tmp)) {
            currentTag = tmp;
            if(withAttr.contains(tmp))
                setValueFromAttributes(attributes);
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
                default:
                    throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
            }
        }
        currentTag = null;
    }

    /**This method is setting values from attributes
     *
     * @param attr - soil, light or multiplying attributes
     */
    private void setValueFromAttributes(Attributes attr) {
        switch (currentTag) {
            case SOIL:
                current.setSoil(attr.getValue(0));
                break;
            case LIGHT:
                current.getGrowingTips().setLight(Boolean.parseBoolean(attr.getValue(0)));
                break;
            case MULTIPLYING:
                current.setMultiplying(attr.getValue(0));
                break;
            default:
                throw new EnumConstantNotPresentException(currentTag.getDeclaringClass(), currentTag.name());
        }
        currentTag = null;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equals(FLOWER_ELEMENT)) {
            flowers.add(current);
        }
    }

    public List<Flower> getFlowers() {
        return flowers;
    }
}
