package org.aalonzo;

public class Chocolate extends Topping {

    public static final double PRICE = .1;
    private final Pastry whatImTopping;

    public Chocolate(Pastry whatImTopping) {
        super(whatImTopping);
        this.whatImTopping = whatImTopping;
    }


    @Override
    public String name() {
        if(whatImTopping instanceof Topping){
            return whatImTopping.name() + " and chocolate";
        }
        return whatImTopping.name() + " with chocolate";
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
