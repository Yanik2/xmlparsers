package com.epam.rd.java.basic.practice7.item;

/** This class is represents field in Flower
 * @see Flower
 * @author  Yan Zinchenko
 * @version 0.1
 */
public class VisualParams {
    private String colorOfStem;
    private String colorOfLeaves;
    private Integer averageSize;

    public VisualParams() {
    }

    public VisualParams(String colorOfStem, String colorOfLeaves, int averageSize) {
        this.colorOfStem = colorOfStem;
        this.colorOfLeaves = colorOfLeaves;
        this.averageSize = averageSize;
    }

    public String getColorOfStem() {
        return colorOfStem;
    }

    public void setColorOfStem(String colorOfStem) {
        this.colorOfStem = colorOfStem;
    }

    public String getColorOfLeaves() {
        return colorOfLeaves;
    }

    public void setColorOfLeaves(String colorOfLeaves) {
        this.colorOfLeaves = colorOfLeaves;
    }

    public Integer getAverageSize() {
        return averageSize;
    }

    public void setAverageSize(Integer averageSize) {
        this.averageSize = averageSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n   Color of stem: ").append(colorOfStem);
        sb.append("\n   Color of leaves: ").append(colorOfLeaves);
        sb.append("\n   Average Size(cm): ").append(averageSize);
        return sb.toString();
    }
}
