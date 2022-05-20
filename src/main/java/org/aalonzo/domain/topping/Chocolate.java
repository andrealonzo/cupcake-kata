package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

public class Chocolate extends Topping {

    public static final double PRICE = .1;
    private final Pastry whatImTopping;

    public Chocolate(Pastry whatImTopping) {
        this.whatImTopping = whatImTopping;
    }

    @Override
    public String name() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.name() + " and chocolate";
        }
        return whatImTopping.name() + " with chocolate";
    }


    @Override
    public double price() {
        return whatImTopping.price() + PRICE;
    }
}
