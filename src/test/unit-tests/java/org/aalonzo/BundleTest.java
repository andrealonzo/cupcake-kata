package org.aalonzo;

import org.aalonzo.domain.PastryWithToppings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTest  {

    Bundle bundle = new Bundle();
    @Test
    public void oneCupcakeBundle(){
        PastryWithToppings pastry = new PastryWithToppings("Cupcake", 1.0);
        bundle.add(pastry);
        assertEquals(.90, bundle.calculatePrice());
    }
    @Test
    public void oneCupcakeOneCookieBundle(){
        PastryWithToppings cupcake = new PastryWithToppings("Cupcake", 1.0);
        PastryWithToppings cookie = new PastryWithToppings("Cookie", 2.0);
        bundle.add(cupcake);
        bundle.add(cookie);
        assertEquals(2.70, bundle.calculatePrice());
    }

    @Test
    public void twoCupcakeOneCookieBundle(){
        PastryWithToppings cupcake1 = new PastryWithToppings("Cupcake", 1.0);
        PastryWithToppings cupcake2 = new PastryWithToppings("Cupcake", 1.0);
        PastryWithToppings cookie = new PastryWithToppings("Cookie", 2.0);
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        assertEquals(3.60, bundle.calculatePrice());
    }
    @Test
    public void bundleWithABundle(){
        Bundle outerBundle = new Bundle();
        PastryWithToppings cupcake1 = new PastryWithToppings("Cupcake", 1.0);
        PastryWithToppings cupcake2 = new PastryWithToppings("Cupcake", 1.0);
        PastryWithToppings cookie = new PastryWithToppings("Cookie", 2.0);
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        outerBundle.add(bundle);
        assertEquals(3.24, outerBundle.calculatePrice());
    }
}
