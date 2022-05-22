package org.aalonzo.domain.topping;

import org.aalonzo.domain.Pastry;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Nuts extends Topping {

    private static final double PRICE = .2;
    public static final String NUTS = "nuts";
    @OneToOne
    private final Pastry whatImTopping;
    public Nuts(Pastry whatImTopping) {
        this.whatImTopping = whatImTopping;
    }
    public Nuts(){
        super();
        whatImTopping = null;
    }

    @Override
    public String getName() {
        if(whatImTopping== null){
            return"";
        }
        if(whatImTopping instanceof Topping){
            return whatImTopping.getName() + " and " + NUTS;
        }
        return whatImTopping.getName() + " with " + NUTS;
    }

    @Override
    public double getPrice() {

        if(whatImTopping== null){
            return PRICE;
        }
        return whatImTopping.getPrice() + PRICE;
    }
}
