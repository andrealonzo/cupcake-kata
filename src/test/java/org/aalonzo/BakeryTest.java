package org.aalonzo;

import org.aalonzo.domain.Bakery;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BakeryTest {

    @Test
    public void newBakeryHasNoPastries(){
        Bakery bakery = new Bakery();
        assertTrue(bakery.getAllPastries().isEmpty());
    }

//    @Test
//    public void getAllPastries(){
//        Bakery bakery = new Bakery();
//        Pastry cookie = new Cookie();
//        Pastry cupcake = new Cupcake();
//        bakery.add(cookie);
//        bakery.add(cupcake);
//        List<Pastry> pastries = bakery.getAllPastries();
//        //assertFalse(pastries.isEmpty());
//        //assertFalse(pastries.isEmpty());
//
//    }
    //new bakery has no pastries
}
