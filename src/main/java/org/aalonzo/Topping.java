package org.aalonzo;

public abstract class Topping implements Pastry{
    private final Pastry pastry;

    public Topping(Pastry pastry) {
        this.pastry = pastry;
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
