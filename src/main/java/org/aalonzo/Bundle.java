package org.aalonzo;

import org.aalonzo.domain.Pastry;

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


    public double getPrice() {
        return pastries.stream().map(p -> p.getPrice() - p.getPrice() * DISCOUNT)
                .reduce(0.0,
                        Double::sum);
    }

    @Override
    public String getName() {
        return null;
    }


}
