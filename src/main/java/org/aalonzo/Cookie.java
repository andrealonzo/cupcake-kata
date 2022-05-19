package org.aalonzo;

public class Cookie implements Pastry {
    public static final int PRICE = 2;
    public static final String COOKIE = "Cookie";

    @Override
    public String name() {
        return COOKIE;
    }


    public double price() {
        return PRICE;
    }
}
