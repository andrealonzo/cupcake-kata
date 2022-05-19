package org.aalonzo;

import java.util.ArrayList;
import java.util.List;

public class Bundle implements Decorator {

    List<Decorator> pastries;
    public static final double DISCOUNT = .10;
    private Decorator pastry;

    public Bundle() {
        pastries = new ArrayList<>();
    }

    public void add(Decorator pastry) {
        pastries.add(pastry);
    }


    public double price() {
        return pastries.stream().map(p -> p.price() - p.price() * DISCOUNT)
                .reduce(0.0,
                        Double::sum);
    }

    @Override
    public Decorator getInner() {
        return pastry;
    }
}
