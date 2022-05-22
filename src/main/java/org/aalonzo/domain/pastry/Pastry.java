package org.aalonzo.domain.pastry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    public Pastry(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Pastry() {
        this.name = "";
        this.price = 0;
    }

    public double getPrice(){
        return this.price;
    }

    public  String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }
}
