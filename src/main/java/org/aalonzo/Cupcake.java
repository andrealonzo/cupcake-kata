package org.aalonzo;

public class Cupcake implements Pastry {

    public static final int PRICE = 1;

    @Override
    public String name() {
        return "Cupcake";
    }

    @Override
    public Pastry getWhatImTopping() {
        return null;
    }

    public double price() {
        return PRICE;
    }
}
