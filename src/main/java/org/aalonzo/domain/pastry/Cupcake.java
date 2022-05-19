package org.aalonzo.domain.pastry;

public class Cupcake implements Pastry {

    public static final int PRICE = 1;
    public static final String CUPCAKE = "Cupcake";

    @Override
    public String name() {
        return CUPCAKE;
    }

    public double price() {
        return PRICE;
    }
}
