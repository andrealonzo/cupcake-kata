package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cupcake extends Pastry {
    public static final int PRICE = 1;
    public static final String CUPCAKE = "Cupcake";

    @Override
    public String getName() {
        return CUPCAKE;
    }


    public double price() {
        return PRICE;
    }

}
