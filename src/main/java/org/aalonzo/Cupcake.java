package org.aalonzo;

public class Cupcake implements Decorator{

    public static final int PRICE = 1;

    @Override
    public String toString() {
        return "Cupcake";
    }

    @Override
    public Decorator getInner() {
        return null;
    }

    public double price() {
        return PRICE;
    }
}
