package org.aalonzo.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    @ManyToMany
    private List<Topping> toppings;

    public Pastry(String name, double price) {
        this.name = name;
        this.price = price;
        toppings= new ArrayList<>();
    }

    public Pastry() {
        this.name = "";
        this.price = 0;
    }
    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public double getPrice(){
        return this.price;
    }

    private  String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }



    public String generateName() {
        String fullName = name;
        String connector;
        for (int i = 0; i < toppings.size(); i++) {
            if(i ==0){
                connector = "with";
            }else{
                connector = "and";
            }
            fullName += " " + connector + " " +toppings.get(i).getName();
        }
        return fullName;
    }
}
