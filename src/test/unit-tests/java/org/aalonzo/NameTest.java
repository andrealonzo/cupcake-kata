package org.aalonzo;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

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
        assertEquals("Cupcake with chocolate", chocolateCupcake.name());
    }
    @Test
    public void cookieWithChocolate(){
        Pastry chocolateCookie = new Chocolate(new Cookie());
        assertEquals("Cookie with chocolate", chocolateCookie.name());

    }
    @Test
    public void cookieWithChocolateAndNuts(){
        Pastry chocolateCookieNuts = new Nuts(new Chocolate(new Cookie()));
        assertEquals("Cookie with chocolate and nuts", chocolateCookieNuts.name());

    }
    @Test
    public void cookieWithNutsAndChocolate(){
        Pastry chocolateCookieNuts = new Chocolate(new Nuts(new Cookie()));
        assertEquals("Cookie with nuts and chocolate", chocolateCookieNuts.name());
    }
    @Test
    public void cupcakeWithChocolateAndNutsAndChocolate(){
        Pastry cupcake = new Chocolate(new Nuts(new Chocolate(new Cupcake())));
        assertEquals("Cupcake with chocolate and nuts and chocolate", cupcake.name());
    }


}