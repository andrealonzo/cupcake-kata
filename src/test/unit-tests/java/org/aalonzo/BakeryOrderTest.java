package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BakeryOrderTest {


    @Test
    public void buyingNothingCostsNothing(){
        BakeryOrder order = new BakeryOrder();
        double price = order.calculateTotalPrice();
        assertEquals(0, price, .01);
    }

    @Test
    public void addPastryOrderGetPrice(){
        BakeryOrder order = new BakeryOrder();
        Pastry pastry = new FakePastry();
        order.add(pastry);
        double price = order.calculateTotalPrice();
        assertEquals(1, price, .01);
    }

    private static class FakePastry extends Pastry {
        @Override
        public double price() {
            return 1;
        }

        @Override
        public String getName() {
            return "fake pastry";
        }


    }
}
