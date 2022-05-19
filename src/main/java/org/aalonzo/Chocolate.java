package org.aalonzo;

public class Chocolate implements Decorator  {

    private final Decorator decorator;

    public Chocolate(Decorator decorator) {
        super();
        this.decorator = decorator;
    }


    @Override
    public String toString() {
        return decorator.toString() + " with chocolate";
    }
}
