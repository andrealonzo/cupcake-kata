package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

public class Chocolate extends Topping {

    public static final double PRICE = .1;
    public static final String CHOCOLATE = "chocolate";
    private final Pastry whatImTopping;

    public Chocolate(Pastry whatImTopping) {
        this.whatImTopping = whatImTopping;
    }

    @Override
    public String name() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.name() + " and " + CHOCOLATE;
        }
        return whatImTopping.name() + " with " + CHOCOLATE;
    }


    public String getName() {
        return CHOCOLATE;
    }


    @Override
    public double price() {
        return whatImTopping.price() + PRICE;
    }
}
