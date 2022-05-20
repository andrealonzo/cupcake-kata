package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Cupcake implements Pastry {
    @Id
    @GeneratedValue
    private Long id;
    public static final int PRICE = 1;
    public static final String CUPCAKE = "Cupcake";

    @Override
    public String name() {
        return CUPCAKE;
    }

    public double price() {
        return PRICE;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
