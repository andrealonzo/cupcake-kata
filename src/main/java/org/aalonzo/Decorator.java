package org.aalonzo;

public class Decorator implements Pastry{
    private Pastry pastry;

    @Override
    public Pastry getInner() {
        return null;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public String name() {
        return null;
    }
}
