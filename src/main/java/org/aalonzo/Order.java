package org.aalonzo;

import jdk.jfr.DataAmount;
import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="order")
public class Order {
    @Id
    private Long id;
    private String name;


    //  private final List<Pastry> pastries;

    public Order(String name) {
   //     pastries = new ArrayList<>();
        this.name = name;
    }

    public Order() {

    }

    public double calculateTotalPrice() {
        return 0;
//        return pastries.stream()
//                .map(Pastry::price)
//                .reduce(Double::sum)
//                .orElse(0.0);
    }

    public void add(Pastry pastry) {
//        pastries.add(pastry);

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
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
