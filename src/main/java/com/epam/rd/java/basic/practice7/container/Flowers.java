package com.epam.rd.java.basic.practice7.container;

import com.epam.rd.java.basic.practice7.item.Flower;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flowers implements Iterable<Flower> {
    private final List<Flower> storage;

    public Flowers() {
        storage = new ArrayList<>();
    }

    public Flowers(List<Flower> flowers) {
        this.storage = flowers;
    }

    public List<Flower> getFlowers() {
        return storage;
    }

    public void add(Flower f) {
        storage.add(f);
    }

    public Flower get(int i) {
        return storage.get(i);
    }

    public Iterator<Flower> iterator() {
        return storage.iterator();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
