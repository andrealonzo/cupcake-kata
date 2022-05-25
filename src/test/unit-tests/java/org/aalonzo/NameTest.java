package org.aalonzo;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.domain.Topping;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameTest {

    @Test
    public void cupcakeName() {
        Pastry cupcake = new Pastry(new PastryType("Cupcake", 1.0));
        assertEquals("Cupcake", cupcake.generateName());

    }

    @Test
    public void cookieName() {
        Pastry cookie = new Pastry(new PastryType("Cookie", 2.0));
        assertEquals("Cookie", cookie.generateName());

    }

    @Test
    public void cupcakeWithChocolate() {
        Pastry cupcake = new Pastry(new PastryType("Cupcake", 1.0));
        cupcake.addTopping(new Topping("chocolate", .1));
        assertEquals("Cupcake with chocolate", cupcake.generateName());
    }

    @Test
    public void cookieWithChocolate() {
        Pastry chocolateCookie = new Pastry(new PastryType("Cookie", 2.0));
        chocolateCookie.addTopping(new Topping("chocolate", .1));
        assertEquals("Cookie with chocolate", chocolateCookie.generateName());

    }

    @Test
    public void cookieWithChocolateAndNuts() {
        Pastry chocolateCookieNuts = new Pastry(new PastryType("Cookie", 2.0));
        chocolateCookieNuts.addTopping(new Topping("chocolate", .1));
        chocolateCookieNuts.addTopping(new Topping("nuts", .2));
        assertEquals("Cookie with chocolate and nuts", chocolateCookieNuts.generateName());

    }

    @Test
    public void cookieWithNutsAndChocolate() {
        Pastry chocolateCookieNuts = new Pastry(new PastryType("Cookie", 2.0));
        chocolateCookieNuts.addTopping(new Topping("nuts", .2));
        chocolateCookieNuts.addTopping(new Topping("chocolate", .1));
        assertEquals("Cookie with nuts and chocolate", chocolateCookieNuts.generateName());
    }

    @Test
    public void cupcakeWithChocolateAndNutsAndChocolate() {
        Pastry cupcake = new Pastry(new PastryType("Cupcake", 1.0));
        cupcake.addTopping(new Topping("chocolate", .1));
        cupcake.addTopping(new Topping("nuts", .2));
        cupcake.addTopping(new Topping("chocolate", .1));
        assertEquals("Cupcake with chocolate and nuts and chocolate", cupcake.generateName());
    }


}
