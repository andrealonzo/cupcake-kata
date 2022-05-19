package org.aalonzo;

public class Cookie implements Pastry {
    public static final int PRICE = 2;

    @Override
    public String name() {
        return "Cookie";
    }

    @Override
    public Pastry getInner() {
        return null;
    }

    public double price() {
        return PRICE;
    }
}
