package org.aalonzo;

public class Nuts implements Pastry {

    private static final double PRICE = .2;
    private final Pastry pastry;
    public Nuts(Pastry pastry) {
        this.pastry = pastry;
    }

    @Override
    public String name() {
        return "nuts";
    }

    @Override
    public Pastry getInner() {
        return pastry;
    }

    @Override
    public double price() {
        return pastry.price() + PRICE;
    }
}
