package org.aalonzo;

public class Chocolate implements Pastry {

    public static final double PRICE = .1;
    private final Pastry pastry;

    public Chocolate(Pastry pastry) {
        super();
        this.pastry = pastry;
    }


    @Override
    public String name() {
        return "chocolate";
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
