package org.aalonzo.domain;

import javax.persistence.*;

@Entity
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private double price;

    public Topping(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    public Topping() {
        this.name = "";
        this.price = 0;
    }


    public String getName() {
        return this.name;
    }


    public double getPrice() {
        return price;
    }
}
