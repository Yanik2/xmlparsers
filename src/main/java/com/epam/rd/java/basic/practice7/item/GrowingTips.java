package com.epam.rd.java.basic.practice7.item;

/** This class is represent field in Flower
 * @see Flower
 * @author Yan Zinchenko
 * @version 0.1
 */
public class GrowingTips {
    private Integer temperature;
    private Boolean light;
    private Integer watering;

    public GrowingTips() {
    }

    public GrowingTips(int temperature, boolean light, int watering) {
        this.temperature = temperature;
        this.light = light;
        this.watering = watering;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Boolean isLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

    public Integer getWatering() {
        return watering;
    }

    public void setWatering(Integer watering) {
        this.watering = watering;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n   Temperature: ").append(temperature);
        sb.append("\n   Light: ").append(light);
        sb.append("\n   Watering: ").append(watering);
        return sb.toString();
    }
}
