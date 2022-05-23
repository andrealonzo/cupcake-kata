package org.aalonzo;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.Topping;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.ToppingRepository;
import org.aalonzo.service.BakeryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BakeryServiceIntegrationTest {

    public static final String GENERIC_ORDER_NAME = "order1";
    //TODO convert this to an E2E test
    @Autowired
    BakeryRepository bakeryRepository;
    @Autowired
    PastryRepository pastryRepository;
    @Autowired
    ToppingRepository toppingRepository;
    @Autowired
    BakeryService service;
    @Test
    public void createNewOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        assertTrue(bakeryRepository.findById(order.getId()).isPresent());
        assertEquals(GENERIC_ORDER_NAME, bakeryRepository.findById(order.getId()).get().getName());
    }

    @Test
    public void addCookieToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Pastry cookie = pastryRepository.save(new Pastry("Cookie", 2.0));
        order.add(cookie);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals(cookie.generateName(), updatedOrder.getPastries().get(0).generateName());
    }

    @Test
    public void addCupcakeToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Pastry cupcake = pastryRepository.save(new Pastry("Cupcake", 1.0));
        order.add(cupcake);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals(cupcake.generateName(), updatedOrder.getPastries().get(0).generateName());
    }

    @Test
    public void addCupcakeWithNutsToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Pastry cupcake = pastryRepository.save(new Pastry("Cupcake", 1.0));
        Topping nuts = toppingRepository.save(new Topping("nuts", .2));
        cupcake.addTopping(nuts);
        Pastry cupcakeWithNuts = pastryRepository.save(cupcake);

        order.add(cupcakeWithNuts);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals("Cupcake with nuts", updatedOrder.getPastries().get(0).generateName());
        assertEquals(1.2, updatedOrder.calculateTotalPrice(), .01);
    }

    @Test
    public void addCookieWithNutsAndChocolateToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Pastry cookie = pastryRepository.save(new Pastry("Cookie", 2.0));
        Topping nuts = toppingRepository.save(new Topping("nuts", .2));
        Topping chocolate = toppingRepository.save(new Topping("chocolate", .1));
        cookie.addTopping(nuts);
        cookie.addTopping(chocolate);

        Pastry cupcakeWithNutsAndChocolate = pastryRepository.save(cookie);
        order.add(cupcakeWithNutsAndChocolate);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals("Cookie with nuts and chocolate", updatedOrder.getPastries().get(0).generateName());
        assertEquals(2.3, updatedOrder.calculateTotalPrice(),.01);
    }

}
