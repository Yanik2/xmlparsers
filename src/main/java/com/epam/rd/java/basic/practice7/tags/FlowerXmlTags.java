package com.epam.rd.java.basic.practice7.tags;

public enum FlowerXmlTags {
    FLOWERS("flowers"),
    FLOWER("flower"),
    NAME("name"),
    ORIGIN("origin"),
    COLOROFSTEM("colorOfStem"),
    COLOROFLEAVES("colorOfLeaves"),
    AVERAGESIZE("averageSize"),
    TEMPERATURE("temperature"),
    WATERING("watering"),
    VISUALPARAMS("visualParams"),
    GROWINGTIPS("growingTips"),
    SOIL("soil"),
    LIGHT("light"),
    MULTIPLYING("multiplying");

    private String value;

    FlowerXmlTags(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
