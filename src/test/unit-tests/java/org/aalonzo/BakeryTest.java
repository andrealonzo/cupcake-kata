package org.aalonzo;

import org.aalonzo.domain.Bakery;
import org.aalonzo.domain.PastryWithToppings;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BakeryTest {

    Bakery bakery = new Bakery();
    PastryWithToppings cookie = new PastryWithToppings("Cookie", 2.0);
    PastryWithToppings cupcake = new PastryWithToppings("Cupcake", 1.0);
    @Test
    public void newBakeryHasNoPastries(){
        assertTrue(bakery.getAllPastries().isEmpty());
    }

    @Test
    public void addingCookieToBakeryReturnsACookie(){
        bakery.add(cookie);
        List<PastryWithToppings> pastries = bakery.getAllPastries();
        assertTrue(pastries.contains(cookie));

    }

    @Test
    public void addingCookieAndCupcakeToBakeryShowsBoth(){
        bakery.add(cookie);
        bakery.add(cupcake);
        List<PastryWithToppings> pastries = bakery.getAllPastries();
        assertTrue(pastries.contains(cookie));

    }
}
