package org.aalonzo;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.Topping;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {
    @Test
    public void cupcakePrice() {
        Pastry cupcake = new Pastry("Cupcake", 1.0);
        assertEquals(1, cupcake.calculatePrice());
    }

    @Test
    public void cookiePrice() {
        Pastry cookie = new Pastry("Cookie", 2.0);
        assertEquals(2, cookie.calculatePrice());
    }

    @Test
    public void cupcakeWithChocolatePrice() {
        Pastry cupcake = new Pastry("Cupcake", 1.0);
        cupcake.addTopping(new Topping("chocolate", .1));
        assertEquals(1.1, cupcake.calculatePrice());
    }
    @Test
    public void cookieWithChocolatePrice() {
        Pastry cookie = new Pastry("Cookie", 2.0);
        cookie.addTopping(new Topping("chocolate", .1));
        assertEquals(2.1, cookie.calculatePrice());
    }

    @Test
    public void cookieWithNutsPrice() {
        Pastry cookie = new Pastry("Cookie", 2.0);
        cookie.addTopping(new Topping("nuts", .2));

        assertEquals(2.2, cookie.calculatePrice());
    }

}
