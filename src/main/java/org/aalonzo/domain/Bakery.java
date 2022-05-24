package org.aalonzo.domain;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private final List<PastryWithToppings> pastry;

    public Bakery() {
        this.pastry = new ArrayList<>();
    }

    public List<PastryWithToppings> getAllPastries() {
        return this.pastry;
    }

    public void add(PastryWithToppings pastry) {
        this.pastry.add(pastry);
    }
}
