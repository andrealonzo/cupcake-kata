package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Order {
    private Long id;

    private final List<Pastry> pastries;

    public Order() {
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

    @Id
    public Long getId() {
        return id;
    }
}
