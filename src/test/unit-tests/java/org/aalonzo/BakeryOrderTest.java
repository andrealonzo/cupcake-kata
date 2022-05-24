package org.aalonzo;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.PastryWithToppings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BakeryOrderTest {

    @Test
    public void buyingNothingCostsNothing() {
        BakeryOrder order = new BakeryOrder();
        double price = order.calculateTotalPrice();
        assertEquals(0, price, .01);
    }

    @Test
    public void addPastryOrderGetPrice() {
        BakeryOrder order = new BakeryOrder();
        PastryWithToppings pastry = new PastryWithToppings("Cookie", 1);
        order.add(pastry);
        double price = order.calculateTotalPrice();
        assertEquals(1, price, .01);
    }
}

