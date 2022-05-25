package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.domain.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BakeryServiceTest {

    public static final String ORDER_1 = "order1";
    public static final String ORDER_2 = "order2";
    public static final String COOKIE = "Cookie";
    public static final String NUTS = "Nuts";
    public static final String CHOCOLATE = "Chocolate";
    public static final String CUPCAKE = "Cupcake";
    FakePastryRepository fakePastryRepository = new FakePastryRepository();
    BakeryService service = new BakeryService(new FakeBakeryOrderRepository(), fakePastryRepository, new FakeToppingRepository());
    Pastry pastry1;
    Pastry pastry2;
    Topping topping1;
    Topping topping2;
    BakeryOrder bakeryOrder1;
    BakeryOrder bakeryOrder2;

    @BeforeEach
    public void setUp() {
        pastry1 = new Pastry(new PastryType(COOKIE, 2.0));
        pastry2 = new Pastry(new PastryType(CUPCAKE, 1.0));
        topping1 = new Topping(CHOCOLATE, .1);
        topping2 = new Topping(NUTS, .2);
        bakeryOrder1 = new BakeryOrder(ORDER_1);
        bakeryOrder2 = new BakeryOrder(ORDER_2);
    }

    @Test
    public void createNewOrder() {
        BakeryOrder order = service.add(ORDER_1);
        assertEquals(1, service.count());
        assertEquals(ORDER_1, service.findById(order.getId()).get().getName());
    }

    @Test
    public void addCookieToOrder() {
        BakeryOrder order = service.add(ORDER_1);
        order.add(pastry1);
        service.update(order);
        assertEquals(1, service.findById(order.getId()).get().getPastries().size());
        assertEquals(COOKIE, service.findById(order.getId()).get().getPastries().get(0).generateName());
    }

    @Test
    public void addMultipleOrders() {
        BakeryOrder order1 = service.add(ORDER_1);
        BakeryOrder order2 = service.add(ORDER_2);
        order1.add(pastry1);
        order2.add(pastry2);
        service.update(order1);
        service.update(order2);
        assertEquals(2, service.count());
        assertEquals(ORDER_1, service.findById(order1.getId()).get().getName());
        assertEquals(ORDER_2, service.findById(order2.getId()).get().getName());
        assertEquals(COOKIE, service.findById(order1.getId()).get().getPastries().get(0).generateName());
        assertEquals(CUPCAKE, service.findById(order2.getId()).get().getPastries().get(0).generateName());
    }

    @Test
    public void addToppingToPastryInOrder() {
        BakeryOrder order1 = service.add(ORDER_1);
        pastry1.addTopping(topping1);
        order1.add(pastry1);

        service.update(order1);
        assertEquals(ORDER_1, service.findById(order1.getId()).get().getName());
        assertEquals(COOKIE, service.findById(order1.getId()).get().getPastries().get(0).getName());
        assertEquals(CHOCOLATE, service.findById(order1.getId()).get().getPastries().get(0).getToppings().get(0).getName());
    }

    @Test
    public void viewMultipleOrders() {
        bakeryOrder1 = service.add(bakeryOrder1.getName());
        bakeryOrder2 = service.add(bakeryOrder2.getName());

        Collection<BakeryOrder> bakeryOrders = (Collection<BakeryOrder>) service.findAll();
        assertTrue(bakeryOrders.contains(bakeryOrder1));
        assertTrue(bakeryOrders.contains(bakeryOrder2));
    }

    @Test
    @Disabled
    public void viewPastriesInAnOrder() {

        bakeryOrder1 =  service.add(bakeryOrder1.getName());
        bakeryOrder1.add(pastry1);
        bakeryOrder1.add(pastry2);

        bakeryOrder1 =  service.add(bakeryOrder1.getName());
        service.update(bakeryOrder1);
        BakeryOrder actualBakeryOrder = service.findById(bakeryOrder1.getId()).get();
        assertEquals(pastry1, actualBakeryOrder.getPastries().get(0));
        assertEquals(pastry2, actualBakeryOrder.getPastries().get(1));
    }

    @Test
    @Disabled
    public void viewPastriesAndToppingsInAnOrder() {
        pastry1.addTopping(topping1);
        pastry1.addTopping(topping2);
        bakeryOrder1.add(pastry1);
        service.add(bakeryOrder1.getName());

        Iterator<BakeryOrder> iterator = service.findAll().iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(topping1, actualBakeryOrder.getPastries().get(0).getToppings().get(0));
        assertEquals(topping2, actualBakeryOrder.getPastries().get(0).getToppings().get(1));
    }

    @Test
    @Disabled
    public void getTotalPriceOfOrder() {
        pastry1.addTopping(topping1);
        pastry1.addTopping(topping2);
        bakeryOrder1.add(pastry1);
        service.add(bakeryOrder1.getName());

        Iterator<BakeryOrder> iterator = service.findAll().iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(2.3, actualBakeryOrder.getTotalPrice());
    }



}
