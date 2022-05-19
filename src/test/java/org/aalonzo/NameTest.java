package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    PastryService pastry = new PastryService();
    @Test
    public void cupcakeName(){
        Pastry cupcake = new Cupcake();

        assertEquals("Cupcake", cupcake.name());

    }
    @Test
    public void cookieName(){
        Pastry cookie = new Cookie();

        assertEquals("Cookie", cookie.name());

    }

    @Test
    public void cupcakeWithChocolate(){
        Pastry chocolateCupcake = new Chocolate(new Cupcake());
        assertEquals("Cupcake with chocolate", pastry.getName(chocolateCupcake));
    }
    @Test
    public void cookieWithChocolate(){
        Pastry chocolateCookie = new Chocolate(new Cookie());
        assertEquals("Cookie with chocolate", pastry.getName(chocolateCookie));

    }
    @Test
    public void cookieWithChocolateAndNuts(){
        Pastry chocolateCookieNuts = new Nuts(new Chocolate(new Cookie()));
        assertEquals("Cookie with chocolate and nuts", pastry.getName(chocolateCookieNuts));

    }
    @Test
    public void cookieWithNutsAndChocolate(){
        Pastry chocolateCookieNuts = new Chocolate(new Nuts(new Cookie()));
        assertEquals("Cookie with nuts and chocolate", pastry.getName(chocolateCookieNuts));
    }
    @Test
    public void cupcakeWithChocolateAndNutsAndChocolate(){
        Pastry cupcake = new Chocolate(new Nuts(new Chocolate(new Cupcake())));
        assertEquals("Cupcake with chocolate and nuts and chocolate", pastry.getName(cupcake));
    }


}
