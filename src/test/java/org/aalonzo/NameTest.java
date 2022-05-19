package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    PastryService pastry = new PastryService();
    @Test
    public void cupcakeName(){
        Cupcake cupcake = new Cupcake();

        assertEquals("Cupcake", pastry.getName(cupcake));

    }
    @Test
    public void cookieName(){
        Cookie cookie = new Cookie();

        assertEquals("Cookie", pastry.getName(cookie));

    }

    @Test
    public void cupcakeWithChocolate(){
        Decorator chocolateCupcake = new Chocolate(new Cupcake());
        assertEquals("Cupcake with chocolate", pastry.getName(chocolateCupcake));
    }
    @Test
    public void cookieWithChocolate(){
        Decorator chocolateCookie = new Chocolate(new Cookie());
        assertEquals("Cookie with chocolate", pastry.getName(chocolateCookie));

    }
    @Test
    public void cookieWithChocolateAndNuts(){
        Decorator chocolateCookieNuts = new Nuts(new Chocolate(new Cookie()));
        assertEquals("Cookie with chocolate and nuts", pastry.getName(chocolateCookieNuts));

    }
    @Test
    public void cookieWithNutsAndChocolate(){
        Decorator chocolateCookieNuts = new Chocolate(new Nuts(new Cookie()));
        assertEquals("Cookie with nuts and chocolate", pastry.getName(chocolateCookieNuts));
    }
    @Test
    public void cupcakeWithChocolateAndNutsAndChocolate(){
        Decorator cupcake = new Chocolate(new Nuts(new Chocolate(new Cupcake())));
        assertEquals("Cupcake with chocolate and nuts and chocolate", pastry.getName(cupcake));
    }


}
