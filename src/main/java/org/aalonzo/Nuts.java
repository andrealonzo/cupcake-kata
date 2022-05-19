package org.aalonzo;

public class Nuts implements Decorator {

    private final Decorator decorator;
    public Nuts(Decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public String toString() {
        return decorator.toString() + " and nuts";
    }
}
