package org.aalonzo.domain.topping;

import org.aalonzo.domain.Pastry;

import javax.persistence.*;

@Entity
public class Topping extends Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private static final double PRICE = .2;
    public static final String NUTS = "nuts";
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
            return whatImTopping.getName() + " and " + NUTS;
        }
        return whatImTopping.getName() + " with " + NUTS;
    }

    @Override
    public double getPrice() {

        if (whatImTopping == null) {
            return PRICE;
        }
        return whatImTopping.getPrice() + PRICE;
    }
}
