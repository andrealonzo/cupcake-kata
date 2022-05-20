package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;

import java.util.ArrayList;
import java.util.List;

public class Bundle extends Pastry {

    public static final String BUNDLE = "Bundle";
    List<Pastry> pastries;
    public static final double DISCOUNT = .10;

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

    public String getName() {
        return BUNDLE;
    }


}
