package org.aalonzo;

public class Nuts extends Topping {

    private static final double PRICE = .2;
    private final Pastry whatImTopping;
    public Nuts(Pastry whatImTopping) {
        super(whatImTopping);
        this.whatImTopping = whatImTopping;
    }

    @Override
    public String name() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.name() + " and nuts";
        }
        return whatImTopping.name() + " with nuts";
    }

    @Override
    public Pastry getWhatImTopping() {
        return whatImTopping;
    }

    @Override
    public double price() {
        return whatImTopping.price() + PRICE;
    }
}
