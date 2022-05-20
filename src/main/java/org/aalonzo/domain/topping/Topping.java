package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

public abstract class Topping extends Pastry {
    private final Pastry pastry;

    public Topping(Pastry pastry) {
        this.pastry = pastry;
    }


    @Override
    public double price() {
        return 0;
    }

    @Override
    public String name() {
        return pastry.name();
    }
}
