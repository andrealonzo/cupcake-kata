package org.aalonzo;

public class Cookie implements Decorator{
    public static final int PRICE = 2;

    @Override
    public String toString() {
        return "Cookie";
    }

    @Override
    public Decorator getInner() {
        return null;
    }

    public double price() {
        return PRICE;
    }
}
