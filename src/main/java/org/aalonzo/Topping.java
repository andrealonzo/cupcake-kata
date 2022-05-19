package org.aalonzo;

public class Topping implements Pastry{
    private final Pastry pastry;

    public Topping(Pastry pastry) {
        this.pastry = pastry;
    }

    @Override
    public Pastry getWhatImTopping() {
        return this.pastry;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public String name() {
        return pastry.name();
    }
}
