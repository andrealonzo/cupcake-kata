package org.aalonzo;

import org.aalonzo.domain.PastryWithToppings;

import java.util.ArrayList;
import java.util.List;

public class Bundle extends PastryWithToppings implements Bundable {

    public static final String BUNDLE = "Bundle";
    List<Bundable> bundables;
    public static final double DISCOUNT = .10;

    public Bundle() {
        bundables = new ArrayList<>();
    }

    public void add(Bundable pastry) {
        bundables.add(pastry);
    }


//    public double getPrice() {
//        return bundables.stream().map(p -> p.calculatePrice() - p.calculatePrice() * DISCOUNT)
//                .reduce(0.0,
//                        Double::sum);
//    }

    @Override
    public double calculatePrice() {
        double price=  0;
        for (Bundable bundable: bundables){
            price += bundable.calculatePrice() - bundable.calculatePrice() * DISCOUNT;
        }
        return price;
    }
}
