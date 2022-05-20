package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cookie extends Pastry {
    public static final int PRICE = 2;
    public static final String COOKIE = "Cookie";

    @Override
    public String getName() {
        return COOKIE;
    }


    public double price() {
        return PRICE;
    }

}
