package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Pastry> pastries;

    public Order() {
        pastries = new ArrayList<>();
    }

    public double getTotalPrice() {
        return pastries.stream()
                .map(Pastry::price)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public void add(Pastry pastry) {
        pastries.add(pastry);

    }
}
