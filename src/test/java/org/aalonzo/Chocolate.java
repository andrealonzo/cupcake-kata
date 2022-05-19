package org.aalonzo;

public class Chocolate extends Cupcake {

    private final Cupcake cupcake;

    public Chocolate(Cupcake cupcake) {
        super();
        this.cupcake = cupcake;
    }

    @Override
    public String toString() {
        return super.toString() + " with chocolate";
    }
}
