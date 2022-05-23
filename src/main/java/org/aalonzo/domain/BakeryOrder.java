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

    public void setId(Long id) {
        this.id = id;
    }

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
                .map(Pastry::calculatePrice)
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

    public double getTotalPrice() {
        return calculateTotalPrice();
    }
}
