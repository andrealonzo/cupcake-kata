package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {


    @Test
    @Disabled
    public void buyingNothingCostsNothing(){
        Order order = new Order();
        double price = order.calculateTotalPrice();
        assertEquals(0, price, .01);
    }

    @Test
    @Disabled
    public void addPastryOrderGetPrice(){
        Order order = new Order();
        Pastry pastry = new FakePastry();
        order.add(pastry);
        double price = order.calculateTotalPrice();
        assertEquals(1, price, .01);
    }

    private class FakePastry implements Pastry {
        @Override
        public double price() {
            return 1;
        }

        @Override
        public String name() {
            return "fake pastry";
        }
    }
}
