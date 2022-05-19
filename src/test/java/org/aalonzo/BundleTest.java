package org.aalonzo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTest  {

    Bundle bundle = new Bundle();
    @Test
    public void oneCupcakeBundle(){
        Decorator pastry = new Cupcake();
        bundle.add(pastry);
        assertEquals(.90, bundle.getPrice());
    }
    @Test
    public void oneCupcakeOneCookieBundle(){
        Decorator cupcake = new Cupcake();
        Decorator cookie = new Cookie();
        bundle.add(cupcake);
        bundle.add(cookie);
        assertEquals(2.70, bundle.getPrice());
    }

    @Test
    public void twoCupcakeOneCookieBundle(){
        Decorator cupcake1 = new Cupcake();
        Decorator cupcake2 = new Cupcake();
        Decorator cookie = new Cookie();
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        assertEquals(3.60, bundle.getPrice());
    }
}
