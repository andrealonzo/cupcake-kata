package org.aalonzo;

import org.aalonzo.domain.Bakery;
import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BakeryTest {

    Bakery bakery = new Bakery();
    Pastry cookie = new Cookie();
    Pastry cupcake = new Cupcake();
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
