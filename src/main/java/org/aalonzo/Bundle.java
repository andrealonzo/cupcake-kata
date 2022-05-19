package org.aalonzo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bundle {

    List<Decorator> pastries;
    public static final double DISCOUNT = .10;
    private Decorator pastry;

    public Bundle() {
        pastries = new ArrayList<>();
    }

    public void add(Decorator pastry) {
        pastries.add(pastry);
    }

    public double getPrice() {
        return pastries.stream().map(p -> p.price() - p.price() * DISCOUNT)
                .reduce(0.0,
                        (Double a, Double b) -> a + b);
    }
}
