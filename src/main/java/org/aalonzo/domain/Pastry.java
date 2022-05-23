package org.aalonzo.domain;

import org.aalonzo.Bundable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pastry implements Bundable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
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

    public  double getPrice(){
        return this.price;
    }


    private  String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public double calculatePrice(){
        return this.price + toppings.stream()
                .map(Topping::getPrice)
                .reduce(0.0,Double::sum);
    }

    public String generateName() {
        StringBuilder fullName = new StringBuilder(name);
        String connector;
        for (int i = 0; i < toppings.size(); i++) {
            if(i ==0){
                connector = "with";
            }else{
                connector = "and";
            }
            fullName.append(" ").append(connector).append(" ").append(toppings.get(i).getName());
        }
        return fullName.toString();
    }
}
