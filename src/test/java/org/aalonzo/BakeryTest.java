package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BakeryTest {
    @Test
    public void cupcakeName(){
        Cupcake cupcake = new Cupcake();
        assertEquals("Cupcake", cupcake.toString());

    }
    @Test
    public void cookieName(){
        Cookie cookie = new Cookie();
        assertEquals("Cookie", cookie.toString());

    }

    @Test
    public void cupcakeWithChocolate(){
        Cupcake chocolateCupcake = new Chocolate(new Cupcake());

        assertEquals("Cupcake with chocolate", chocolateCupcake.toString());

    }

}
