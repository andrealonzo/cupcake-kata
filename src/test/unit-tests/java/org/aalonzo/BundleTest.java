package org.aalonzo;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BundleTest  {

    Bundle bundle = new Bundle();
    @Test
    public void oneCupcakeBundle(){
        Pastry pastry = new Cupcake();
        bundle.add(pastry);
        assertEquals(.90, bundle.getPrice());
    }
    @Test
    public void oneCupcakeOneCookieBundle(){
        Pastry cupcake = new Cupcake();
        Pastry cookie = new Cookie();
        bundle.add(cupcake);
        bundle.add(cookie);
        assertEquals(2.70, bundle.getPrice());
    }

    @Test
    public void twoCupcakeOneCookieBundle(){
        Pastry cupcake1 = new Cupcake();
        Pastry cupcake2 = new Cupcake();
        Pastry cookie = new Cookie();
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        assertEquals(3.60, bundle.getPrice());
    }
    @Test
    public void bundleWithABundle(){
        Bundle outerBundle = new Bundle();
        Pastry cupcake1 = new Cupcake();
        Pastry cupcake2 = new Cupcake();
        Pastry cookie = new Cookie();
        bundle.add(cupcake1);
        bundle.add(cupcake2);
        bundle.add(cookie);
        outerBundle.add(bundle);
        assertEquals(3.24, outerBundle.getPrice());
    }
}
