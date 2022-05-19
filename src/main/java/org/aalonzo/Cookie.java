package org.aalonzo;

public class Cookie implements Pastry {
    public static final int PRICE = 2;

    @Override
    public String name() {
        return "Cookie";
    }


    public double price() {
        return PRICE;
    }
}
