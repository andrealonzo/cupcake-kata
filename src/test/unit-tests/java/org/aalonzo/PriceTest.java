package org.aalonzo;

import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {
    @Test
    public void cupcakePrice() {
        Pastry cupcake = new Pastry("Cupcake", 1.0);
        assertEquals(1, cupcake.getPrice());
    }

    @Test
    public void cookiePrice() {
        Pastry cookie = new Pastry("Cookie", 2.0);
        assertEquals(2, cookie.getPrice());
    }

    @Test
    public void cupcakeWithChocolatePrice() {
        Pastry cupcake = new Chocolate(new Pastry("Cupcake", 1.0));
        assertEquals(1.1, cupcake.getPrice());
    }
    @Test
    public void cookieWithChocolatePrice() {
        Pastry cookie = new Chocolate(new Pastry("Cookie", 2.0));
        assertEquals(2.1, cookie.getPrice());
    }

    @Test
    public void cookieWithNutsPrice() {
        Pastry cookie = new Nuts(new Pastry("Cookie", 2.0));
        assertEquals(2.2, cookie.getPrice());
    }

    @Test
    public void priceWithNullWhatImToppingIsNutsPrice() {
        Pastry topping = new Nuts();
        assertEquals(.2, topping.getPrice());
    }
    @Test
    public void priceWithNullWhatImToppingIsChocolatePrice() {
        Pastry topping = new Chocolate();
        assertEquals(.1, topping.getPrice());
    }
}
