package org.aalonzo;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements Pastry {

    List<Pastry> pastries;
    public static final double DISCOUNT = .10;
    private Pastry pastry;

    public Bundle() {
        pastries = new ArrayList<>();
    }

    public void add(Pastry pastry) {
        pastries.add(pastry);
    }


    public double price() {
        return pastries.stream().map(p -> p.price() - p.price() * DISCOUNT)
                .reduce(0.0,
                        Double::sum);
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Pastry getWhatImTopping() {
        return pastry;
    }
}
