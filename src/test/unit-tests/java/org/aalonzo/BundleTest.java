package org.aalonzo;

import org.aalonzo.domain.Pastry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTest  {

    Bundle bundle = new Bundle();
    @Test
    public void oneCupcakeBundle(){
        Pastry pastry = new Pastry("Cupcake", 1.0);
        bundle.add(pastry);
        assertEquals(.90, bundle.getPrice());
    }
    @Test
    public void oneCupcakeOneCookieBundle(){
        Pastry cupcake = new Pastry("Cupcake", 1.0);
        Pastry cookie = new Pastry("Cookie", 2.0);
        bundle.add(cupcake);
        bundle.add(cookie);
        assertEquals(2.70, bundle.getPrice());
    }

    @Test
    public void twoCupcakeOneCookieBundle(){
        Pastry cupcake1 = new Pastry("Cupcake", 1.0);
        Pastry cupcake2 = new Pastry("Cupcake", 1.0);
        Pastry cookie = new Pastry("Cookie", 2.0);
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        assertEquals(3.60, bundle.getPrice());
    }
    @Test
    public void bundleWithABundle(){
        Bundle outerBundle = new Bundle();
        Pastry cupcake1 = new Pastry("Cupcake", 1.0);
        Pastry cupcake2 = new Pastry("Cupcake", 1.0);
        Pastry cookie = new Pastry("Cookie", 2.0);
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        outerBundle.add(bundle);
        assertEquals(3.24, outerBundle.getPrice());
    }
}
