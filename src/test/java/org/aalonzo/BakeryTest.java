package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BakeryTest {
    @Test
    public void cupcakeName(){
        Cupcake cupcake = new Cupcake();
        assertEquals("cupcake", cupcake.toString());

    }

}
