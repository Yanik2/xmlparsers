package com.epam.rd.java.basic.practice7.container;

import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flowers implements Iterable<Flower> {
    private List<Flower> flowers;

    public Flowers() {
        flowers = new ArrayList<>();
    }

    public Flowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void add(Flower f) {
        flowers.add(f);
    }

    public Flower get(int i) {
        return flowers.get(i);
    }

    public Iterator<Flower> iterator() {
        return flowers.iterator();
    }

    @Override
    public String toString() {
        return flowers.toString();
    }
}
