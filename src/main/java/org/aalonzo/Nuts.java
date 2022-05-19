package org.aalonzo;

public class Nuts implements Decorator {

    private static final double PRICE = .2;
    private final Decorator decorator;
    public Nuts(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public String toString() {
        return "nuts";
    }

    @Override
    public Decorator getInner() {
        return decorator;
    }

    @Override
    public double price() {
        return decorator.price() + PRICE;
    }
}
