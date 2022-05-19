package org.aalonzo;

public class Chocolate implements Decorator  {

    public static final double PRICE = .1;
    private final Decorator decorator;

    public Chocolate(Decorator decorator) {
        super();
        this.decorator = decorator;
    }


    @Override
    public String toString() {
        return "chocolate";
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
