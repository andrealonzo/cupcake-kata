package org.aalonzo.domain.topping;

import org.aalonzo.domain.pastry.Pastry;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Chocolate extends Topping {

    public static final double PRICE = .1;
    public static final String CHOCOLATE = "chocolate";
    @Transient
    private final Pastry whatImTopping;


    public Chocolate(Pastry whatImTopping) {
        this.whatImTopping = whatImTopping;
    }

    public Chocolate() {
        super();
        whatImTopping = null;
    }

    @Override
    public String getName() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.getName() + " and " + CHOCOLATE;
        }
        return whatImTopping.getName() + " with " + CHOCOLATE;
    }


    @Override
    public double getPrice() {
        return whatImTopping.getPrice() + PRICE;
    }
}
