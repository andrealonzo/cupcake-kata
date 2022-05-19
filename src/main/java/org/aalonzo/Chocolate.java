package org.aalonzo;

public class Chocolate extends Topping {

    public static final double PRICE = .1;
    private final Pastry pastry;

    public Chocolate(Pastry pastry) {
        super(pastry);
        this.pastry = pastry;
    }


    @Override
    public String name() {
        return "chocolate";
    }

    @Override
    public Pastry getWhatImTopping() {
        return pastry;
    }

    @Override
    public double price() {
        return pastry.price() + PRICE;
    }
}
