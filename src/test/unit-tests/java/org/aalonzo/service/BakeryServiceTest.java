package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class BakeryServiceTest {

    public static final String ORDER_1 = "order1";
    public static final String ORDER_2 = "order2";
    public static final String COOKIE = "Cookie";
    public static final String NUTS = "Nuts";
    public static final String CHOCOLATE = "Chocolate";
    public static final String CUPCAKE = "Cupcake";

    FakeBakeryRepository fakeRepo = new FakeBakeryRepository();
    BakeryService service = new BakeryService(fakeRepo);

    Pastry pastry1;
    Pastry pastry2;
    Topping topping1;
    Topping topping2;
    BakeryOrder bakeryOrder1;
    BakeryOrder bakeryOrder2;

    @BeforeEach
    public void setUp() {
        pastry1 = new Pastry(COOKIE, 2.0);
        pastry2 = new Pastry(CUPCAKE, 1.0);
        topping1 = new Topping(CHOCOLATE, .1);
        topping2 = new Topping(NUTS, .2);
        bakeryOrder1 = new BakeryOrder(ORDER_1);
        bakeryOrder2 = new BakeryOrder(ORDER_2);
    }

    @Test
    public void createNewOrder() {
        service.startNew(ORDER_1);
        assertEquals(1, fakeRepo.count());
        assertEquals(ORDER_1, fakeRepo.getBakeryOrders().get(ORDER_1).getName());
    }

    @Test
    public void addCookieToOrder() {
        BakeryOrder order = service.startNew(ORDER_1);
        order.add(pastry1);
        service.update(order);
        assertEquals(1, fakeRepo.getBakeryOrders().get(ORDER_1).getPastries().size());
        assertEquals(COOKIE, fakeRepo.getBakeryOrders().get(ORDER_1).getPastries().get(0).generateName());
    }

    @Test
    public void addMultipleOrders() {
        BakeryOrder order1 = service.startNew(ORDER_1);
        BakeryOrder order2 = service.startNew(ORDER_2);
        order1.add(pastry1);
        order2.add(pastry2);
        service.update(order1);
        service.update(order2);
        assertEquals(2, fakeRepo.getBakeryOrders().size());
        assertEquals(ORDER_1, fakeRepo.getBakeryOrders().get(ORDER_1).getName());
        assertEquals(ORDER_2, fakeRepo.getBakeryOrders().get(ORDER_2).getName());
        assertEquals(COOKIE, fakeRepo.getBakeryOrders().get(ORDER_1).getPastries().get(0).generateName());
        assertEquals(CUPCAKE, fakeRepo.getBakeryOrders().get(ORDER_2).getPastries().get(0).generateName());
    }

    @Test
    public void addToppingToPastryInOrder() {
        BakeryOrder order1 = service.startNew(ORDER_1);
        pastry1.addTopping(topping1);
        order1.add(pastry1);

        service.update(order1);
        assertEquals(ORDER_1, fakeRepo.getBakeryOrders().get(ORDER_1).getName());
        assertEquals(COOKIE, fakeRepo.getBakeryOrders().get(ORDER_1).getPastries().get(0).getName());
        assertEquals(CHOCOLATE, fakeRepo.getBakeryOrders().get(ORDER_1).getPastries().get(0).getToppings().get(0).getName());
    }

    @Test
    public void viewMultipleOrders() {

        fakeRepo.getBakeryOrders().put(bakeryOrder1.getName(), bakeryOrder1);
        fakeRepo.getBakeryOrders().put(bakeryOrder2.getName(), bakeryOrder2);
        Iterable<BakeryOrder> iterable = service.findAll();

        Collection<BakeryOrder> bakeryOrders = (Collection<BakeryOrder>) service.findAll();
        assertTrue(bakeryOrders.contains(bakeryOrder1));
        assertTrue(bakeryOrders.contains(bakeryOrder2));
    }

    @Test
    public void viewPastriesInAnOrder() {
        bakeryOrder1.add(pastry1);
        bakeryOrder1.add(pastry2);

        fakeRepo.getBakeryOrders().put(bakeryOrder1.getName(), bakeryOrder1);

        Iterator<BakeryOrder> iterator = service.findAll().iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(pastry1, actualBakeryOrder.getPastries().get(0));
        assertEquals(pastry2, actualBakeryOrder.getPastries().get(1));
    }

    @Test
    public void viewPastriesAndToppingsInAnOrder() {
        pastry1.addTopping(topping1);
        pastry1.addTopping(topping2);
        bakeryOrder1.add(pastry1);
        fakeRepo.getBakeryOrders().put(bakeryOrder1.getName(), bakeryOrder1);

        Iterator<BakeryOrder> iterator = service.findAll().iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(pastry1, actualBakeryOrder.getPastries().get(0));
    }


}
