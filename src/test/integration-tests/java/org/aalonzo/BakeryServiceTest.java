package org.aalonzo;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.service.BakeryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BakeryServiceTest {

    public static final String GENERIC_ORDER_NAME = "order1";
    //TODO find out how to mock so we don't have to load full context
    @Autowired
    BakeryRepository bakeryRepository;
    @Autowired
    PastryRepository pastryRepository;
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
        Cookie cookie = pastryRepository.save(new Cookie());
        order.add(cookie);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals(cookie.getName(), updatedOrder.getPastries().get(0).getName());
    }

    @Test
    public void addCupcakeToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Cupcake cupcake = pastryRepository.save(new Cupcake());
        order.add(cupcake);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals(cupcake.getName(), updatedOrder.getPastries().get(0).getName());
    }

    @Test
    public void addCupcakeWithNutsToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Cupcake cupcake = pastryRepository.save(new Cupcake());
        Pastry cupcakeWithNuts = pastryRepository.save(new Nuts(cupcake));

        order.add(cupcakeWithNuts);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals("Cupcake with nuts", updatedOrder.getPastries().get(0).getName());
        assertEquals(1.2, updatedOrder.calculateTotalPrice(), .01);
    }

    @Test
    public void addCookieWithNutsAndChocolateToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        Pastry Cookie = pastryRepository.save(new Cookie());
        Pastry cookieWithNuts = pastryRepository.save(new Nuts(Cookie));

        Pastry cupcakeWithNutsAndChocolate = pastryRepository.save(new Chocolate(cookieWithNuts));

        order.add(cupcakeWithNutsAndChocolate);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals("Cookie with nuts and chocolate", updatedOrder.getPastries().get(0).getName());
        assertEquals(2.3, updatedOrder.calculateTotalPrice(),.01);
    }

}
