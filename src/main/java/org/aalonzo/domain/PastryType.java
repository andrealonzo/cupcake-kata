package org.aalonzo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PastryType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    public PastryType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public PastryType() {
        this.name = "";
        this.price = 0;
    }

    public PastryType(Long id) {
        this.id = id;
    }

    public  double getPrice(){
        return this.price;
    }


    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
