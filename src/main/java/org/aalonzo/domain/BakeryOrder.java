package org.aalonzo.domain;

import org.aalonzo.domain.Pastry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BakeryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private final List<Pastry> pastries;

    public BakeryOrder(String name) {
        pastries = new ArrayList<>();
        this.name = name;
    }

    public BakeryOrder() {
        pastries = new ArrayList<>();
    }

    public double calculateTotalPrice() {
        return pastries.stream()
                .map(Pastry::getPrice)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public void add(Pastry pastry) {
        pastries.add(pastry);

    }
    public List<Pastry> getPastries(){
        return this.pastries;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
