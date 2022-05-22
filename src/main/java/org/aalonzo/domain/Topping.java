package org.aalonzo.domain;

import javax.persistence.*;

@Entity
public class Topping extends Pastry {

    private String name;
    private double price;
    @OneToOne
    private final Pastry whatImTopping;

    public Topping(String name, double price, Pastry whatImTopping) {
        this.name = name;
        this.price = price;
        this.whatImTopping = whatImTopping;
    }

    public Topping(String name, double price) {
        super();
        this.name = name;
        this.price = price;
        whatImTopping = null;
    }

    public Topping() {
        super();
        this.name = "";
        this.price = 0;
        whatImTopping = null;
    }

    @Override
    public String getName() {
        if (whatImTopping == null) {
            return "";
        }
        if (whatImTopping instanceof Topping) {
            return whatImTopping.getName() + " and " + name;
        }
        return whatImTopping.getName() + " with " + name;
    }

    @Override
    public double getPrice() {

        if (whatImTopping == null) {
            return price;
        }
        return whatImTopping.getPrice() + price;
    }
}
