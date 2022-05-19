package org.aalonzo.domain;

import org.aalonzo.domain.pastry.Pastry;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private final List<Pastry> pastry;

    public Bakery() {
        this.pastry = new ArrayList<>();
    }

    public List<Pastry> getAllPastries() {
        return this.pastry;
    }

    public void add(Pastry pastry) {
        this.pastry.add(pastry);
    }
}
