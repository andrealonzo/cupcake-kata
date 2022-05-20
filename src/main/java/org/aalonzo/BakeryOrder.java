package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BakeryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Transient
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
                .map(Pastry::price)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    public void add(Pastry pastry) {
        pastries.add(pastry);

    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
