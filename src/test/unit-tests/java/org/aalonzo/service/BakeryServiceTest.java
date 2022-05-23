package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.Topping;
import org.aalonzo.repository.BakeryRepository;
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

    FakeBakeryRepository fakeRepo   = new FakeBakeryRepository();
    BakeryService service = new BakeryService(fakeRepo);

    Pastry pastry1;
    Pastry pastry2;
    @BeforeEach
    public void setUp(){
        pastry1 = new Pastry(COOKIE, 2.0);
        pastry2 = new Pastry(CUPCAKE, 1.0);
    }

    @Test
    public void createNewOrder() {
        service.startNew(ORDER_1);
        assertEquals(1,fakeRepo.count());
        assertEquals(ORDER_1, fakeRepo.bakeryOrders.get(ORDER_1).getName());
    }

    @Test
    public void addCookieToOrder(){
        BakeryOrder order = service.startNew(ORDER_1);
        order.add(pastry1);
        service.update(order);
        assertEquals(1,fakeRepo.bakeryOrders.get(ORDER_1).getPastries().size());
        assertEquals(COOKIE,fakeRepo.bakeryOrders.get(ORDER_1).getPastries().get(0).generateName());
    }

    @Test
    public void addMultipleOrders(){
        BakeryOrder order1= service.startNew(ORDER_1);
        BakeryOrder order2 = service.startNew(ORDER_2);
        order1.add(pastry1);
        order2.add(pastry2);
        service.update(order1);
        service.update(order2);
        assertEquals(2,fakeRepo.bakeryOrders.size());
        assertEquals(ORDER_1,fakeRepo.bakeryOrders.get(ORDER_1).getName());
        assertEquals(ORDER_2,fakeRepo.bakeryOrders.get(ORDER_2).getName());
        assertEquals(COOKIE,fakeRepo.bakeryOrders.get(ORDER_1).getPastries().get(0).generateName());
        assertEquals(CUPCAKE,fakeRepo.bakeryOrders.get(ORDER_2).getPastries().get(0).generateName());
    }
    @Test
    public void addToppingToPastryInOrder(){
        BakeryOrder order1= service.startNew(ORDER_1);
        pastry1.addTopping(new Topping(CHOCOLATE, .1));
        order1.add(pastry1);

        service.update(order1);
        assertEquals(ORDER_1,fakeRepo.bakeryOrders.get(ORDER_1).getName());
        assertEquals(COOKIE,fakeRepo.bakeryOrders.get(ORDER_1).getPastries().get(0).getName());
        assertEquals(CHOCOLATE,fakeRepo.bakeryOrders.get(ORDER_1).getPastries().get(0).getToppings().get(0).getName());
    }

    @Test
    public void viewMultipleOrders(){
        BakeryOrder bakeryOrder = new BakeryOrder(ORDER_1);
        BakeryOrder bakeryOrder2 = new BakeryOrder(ORDER_2);

        fakeRepo.bakeryOrders.put(bakeryOrder.getName(), bakeryOrder);
        fakeRepo.bakeryOrders.put(bakeryOrder2.getName(), bakeryOrder2);
        Iterable<BakeryOrder> iterable = service.findAll();
        if(!(iterable instanceof Collection)){
            fail();
        }

        Collection<BakeryOrder> bakeryOrders = (Collection<BakeryOrder>)iterable;
        assertTrue(bakeryOrders.contains(bakeryOrder));
        assertTrue(bakeryOrders.contains(bakeryOrder2));
    }
    @Test
    public void viewPastriesInAnOrder(){
        BakeryOrder bakeryOrder = new BakeryOrder(ORDER_1);
        bakeryOrder.add(pastry1);
        bakeryOrder.add(pastry2);

        fakeRepo.bakeryOrders.put(bakeryOrder.getName(), bakeryOrder);

        Iterable<BakeryOrder> iterable = service.findAll();
        Iterator<BakeryOrder> iterator = iterable.iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(pastry1, actualBakeryOrder.getPastries().get(0));
        assertEquals(pastry2, actualBakeryOrder.getPastries().get(1));
    }
    @Test
    public void viewPastriesAndToppingsInAnOrder(){
        BakeryOrder bakeryOrder = new BakeryOrder(ORDER_1);
        Topping topping1 = new Topping(CHOCOLATE, .01);
        Topping topping2 = new Topping(NUTS, .02);
        bakeryOrder.add(pastry1);

        fakeRepo.bakeryOrders.put(bakeryOrder.getName(), bakeryOrder);

        Iterable<BakeryOrder> iterable = service.findAll();
        Iterator<BakeryOrder> iterator = iterable.iterator();
        assertTrue(iterator.hasNext());
        BakeryOrder actualBakeryOrder = iterator.next();
        assertEquals(pastry1, actualBakeryOrder.getPastries().get(0));
    }


    private static class FakeBakeryRepository implements BakeryRepository {
        private final Map<String,BakeryOrder> bakeryOrders;
        public FakeBakeryRepository() {
            bakeryOrders = new HashMap<>();
        }
        @Override
        public <S extends BakeryOrder> S save(S entity) {
            bakeryOrders.put(entity.getName(),entity);
            return entity;
        }

        @Override
        public <S extends BakeryOrder> Iterable<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public Optional<BakeryOrder> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public Iterable<BakeryOrder> findAll() {
            return bakeryOrders.values();
        }

        @Override
        public Iterable<BakeryOrder> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public long count() {
            return bakeryOrders.size();
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(BakeryOrder entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends BakeryOrder> entities) {

        }

        @Override
        public void deleteAll() {

        }
    }
}
