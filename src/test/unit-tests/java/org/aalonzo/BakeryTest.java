package org.aalonzo;

import org.aalonzo.domain.Bakery;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BakeryTest {

    Bakery bakery = new Bakery();
    Pastry cookie = new Pastry(new PastryType("Cookie", 2.0));
    Pastry cupcake = new Pastry(new PastryType("Cupcake", 1.0));
    @Test
    public void newBakeryHasNoPastries(){
        assertTrue(bakery.getAllPastries().isEmpty());
    }

    @Test
    public void addingCookieToBakeryReturnsACookie(){
        bakery.add(cookie);
        List<Pastry> pastries = bakery.getAllPastries();
        assertTrue(pastries.contains(cookie));

    }

    @Test
    public void addingCookieAndCupcakeToBakeryShowsBoth(){
        bakery.add(cookie);
        bakery.add(cupcake);
        List<Pastry> pastries = bakery.getAllPastries();
        assertTrue(pastries.contains(cookie));

    }
}
