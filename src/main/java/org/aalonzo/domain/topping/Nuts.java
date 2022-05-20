package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

public class Nuts extends Topping {

    private static final double PRICE = .2;
    public static final String NUTS = "nuts";
    private final Pastry whatImTopping;
    public Nuts(Pastry whatImTopping) {
        this.whatImTopping = whatImTopping;
    }

    @Override
    public String name() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.name() + " and " + NUTS;
        }
        return whatImTopping.name() + " with " + NUTS;
    }

    public String getName() {
        return NUTS;
    }

    @Override
    public double price() {
        return whatImTopping.price() + PRICE;
    }
}
