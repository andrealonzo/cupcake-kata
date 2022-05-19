package org.aalonzo;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {
    @Test
    public void cupcakePrice() {
        Pastry cupcake = new Cupcake();
        assertEquals(1, cupcake.price());
    }

    @Test
    public void cookiePrice() {
        Pastry cookie = new Cookie();
        assertEquals(2, cookie.price());
    }

    @Test
    public void cupcakeWithChocolatePrice() {
        Pastry cupcake = new Chocolate(new Cupcake());
        assertEquals(1.1, cupcake.price());
    }
    @Test
    public void cookieWithChocolatePrice() {
        Pastry cookie = new Chocolate(new Cookie());
        assertEquals(2.1, cookie.price());
    }

    @Test
    public void cookieWithNutsPrice() {
        Pastry cookie = new Nuts(new Cookie());
        assertEquals(2.2, cookie.price());
    }
}
