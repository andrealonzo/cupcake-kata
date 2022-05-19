package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {
    @Test
    public void cupcakePrice() {
        Decorator cupcake = new Cupcake();
        assertEquals(1, cupcake.price());
    }

    @Test
    public void cookiePrice() {
        Decorator cookie = new Cookie();
        assertEquals(2, cookie.price());
    }

    @Test
    public void cupcakeWithChocolatePrice() {
        Decorator cupcake = new Chocolate(new Cupcake());
        assertEquals(1.1, cupcake.price());
    }
    @Test
    public void cookieWithChocolatePrice() {
        Decorator cookie = new Chocolate(new Cookie());
        assertEquals(2.1, cookie.price());
    }

    @Test
    public void cookieWithNutsPrice() {
        Decorator cookie = new Nuts(new Cookie());
        assertEquals(2.2, cookie.price());
    }
}
