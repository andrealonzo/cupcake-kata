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

    public Pastry(PastryType pastryType) {
        this.name = pastryType.getName();
        this.price = pastryType.getPrice();
        toppings= new ArrayList<>();
    }

    public Pastry() {
        this.name = "";
        this.price = 0;
    }

    public Pastry(Long id) {
        this.id = id;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
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

    public List<Topping> getToppings() {
        return toppings;
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
