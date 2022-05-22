package org.aalonzo;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    @Test
    public void cupcakeName(){
        Pastry cupcake = new Pastry("Cupcake", 1.0);

        assertEquals("Cupcake", cupcake.getName());

    }
    @Test
    public void cookieName(){
        Pastry cookie = new Pastry("Cookie", 2.0);

        assertEquals("Cookie", cookie.getName());

    }

    @Test
    public void cupcakeWithChocolate(){
        Pastry chocolateCupcake = new Chocolate(new Pastry("Cupcake", 1.0));
        assertEquals("Cupcake with chocolate", chocolateCupcake.getName());
    }
    @Test
    public void cookieWithChocolate(){
        Pastry chocolateCookie = new Chocolate(new Pastry("Cookie", 2.0));
        assertEquals("Cookie with chocolate", chocolateCookie.getName());

    }
    @Test
    public void cookieWithChocolateAndNuts(){
        Pastry chocolateCookieNuts = new Nuts(new Chocolate(new Pastry("Cookie", 2.0)));
        assertEquals("Cookie with chocolate and nuts", chocolateCookieNuts.getName());

    }
    @Test
    public void cookieWithNutsAndChocolate(){
        Pastry chocolateCookieNuts = new Chocolate(new Nuts(new Pastry("Cookie", 2.0)));
        assertEquals("Cookie with nuts and chocolate", chocolateCookieNuts.getName());
    }
    @Test
    public void cupcakeWithChocolateAndNutsAndChocolate(){
        Pastry cupcake = new Chocolate(new Nuts(new Chocolate(new Pastry("Cupcake", 1.0))));
        assertEquals("Cupcake with chocolate and nuts and chocolate", cupcake.getName());
    }


}
