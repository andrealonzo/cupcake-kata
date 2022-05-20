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
    public String getName() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.getName() + " and " + NUTS;
        }
        return whatImTopping.getName() + " with " + NUTS;
    }

    @Override
    public double getPrice() {
        return whatImTopping.getPrice() + PRICE;
    }
}
