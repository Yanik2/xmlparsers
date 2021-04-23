package com.epam.rd.java.basic.practice7.item;

import java.util.Objects;

/**
 * This class is represent item in xml file
 * @author Yan Zinchenko
 * @version 0.1
 */
public class Flower implements Comparable<Flower> {
    private String name;
    private String soil;
    private String origin;
    private String multiplying;
    /**@see VisualParams */
    private VisualParams visualParams = new VisualParams();
    /**see GrowingTips */
    private GrowingTips growingTips = new GrowingTips();

    public Flower() {
    }

    public Flower(String name, String soil, String origin, String multiplying, VisualParams visualParams, GrowingTips growingTips) {
        this.name = name;
        this.soil = soil;
        this.origin = origin;
        this.multiplying = multiplying;
        this.visualParams = visualParams;
        this.growingTips = growingTips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(String multiplying) {
        this.multiplying = multiplying;
    }

    public VisualParams getVisualParams() {
        return visualParams;
    }

    public void setVisualParams(VisualParams visualParams) {
        this.visualParams = visualParams;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(!(obj instanceof Flower)) return false;
        Flower flower = (Flower) obj;
        return name.equals(flower.getName()) && soil.equals(flower.getSoil()) &&
                origin.equals(flower.getOrigin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, soil, origin, multiplying);
    }

    @Override
    public int compareTo(Flower o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nName: ").append(name);
        sb.append("\nOrigin: ").append(origin);
        sb.append("\nSoil: ").append(soil);
        sb.append("\nMultiplying: ").append(multiplying);
        sb.append("\nVisual Parameters: ").append(visualParams);
        sb.append("\nGrowing Tips: ").append(growingTips);
        return sb.toString();
    }
}
