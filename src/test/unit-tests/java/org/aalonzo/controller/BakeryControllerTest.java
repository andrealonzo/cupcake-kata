package org.aalonzo.controller;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.PastryWithToppings;
import org.aalonzo.repository.BakeryOrderRepository;
import org.aalonzo.service.BakeryService;
import org.aalonzo.service.FakeBakeryOrderRepository;
import org.aalonzo.service.FakePastryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BakeryControllerTest {

    public static final String ORDER_1 = "order1";
    private final BakeryOrderRepository repository = new FakeBakeryOrderRepository();

    private final BakeryController controller = new BakeryController(new BakeryService(repository, new FakePastryRepository()));

    @BeforeEach
    public void setUp(){
        controller.deleteAll();
    }
    @Test
    public void newControllerHasNoOrders() {
        assertFalse(controller.findAll().iterator().hasNext());
    }
    @Test
    public void createOrder() {
        controller.add(ORDER_1);
        assertTrue(controller.findAll().iterator().hasNext());
        BakeryOrder bakeryOrder = controller.findAll().iterator().next();
        assertNotEquals(null, bakeryOrder.getId());
        assertEquals(ORDER_1, bakeryOrder.getName());
    }
    @Test
    public void findByOrder() {
        BakeryOrder order = controller.add(ORDER_1);
        assertEquals(ORDER_1, controller.findById(order.getId()).get().getName());
    }

    @Test
    public void findNonExistentOrder() {
        assertTrue(controller.findById(1).isEmpty());
    }
    @Test
    public void deleteOrder() {
        BakeryOrder order = controller.add(ORDER_1);
        assertEquals(1, controller.count());

        controller.delete(order.getId());
        assertEquals(0, controller.count());
    }

    @Test
    public void deleteAllOrders() {
        assertFalse(controller.findAll().iterator().hasNext());
        controller.add(ORDER_1);
        controller.add("order2");
        assertEquals(2, controller.count());
        controller.deleteAll();
        assertEquals(0, controller.count());
    }

    @Test
    public void addPastryToOrder(){
        PastryWithToppings pastry = new PastryWithToppings("Cupcake", 1.00);
        pastry.setId(1L);
        BakeryOrder order = controller.add(ORDER_1);
        controller.addPastryToOrder(1L, order.getId());
        assertEquals(1,controller.findById(order.getId()).get().getPastries().size());
        assertEquals(pastry.getName(),controller.findById(order.getId()).get().getPastries().get(0).getName());
    }
    @Test
    public void addNonExistentPastryToOrder(){
        long nonExistantPastryId = 10000L;
        PastryWithToppings pastry = new PastryWithToppings("Cupcake", 1.00);
        pastry.setId(nonExistantPastryId);
        BakeryOrder order = controller.add(ORDER_1);
        controller.addPastryToOrder(nonExistantPastryId, order.getId());
        assertEquals(0,controller.findById(order.getId()).get().getPastries().size());
    }

//    @Test
//    public void addToppingToPastryToOrder(){
//        long nonExistantPastryId = 10000L;
//        Pastry pastry = new Pastry("Cupcake", 1.00);
//        pastry.setId(nonExistantPastryId);
//        BakeryOrder order = controller.add(ORDER_1);
//        controller.addPastryToOrder(nonExistantPastryId, order.getId());
//        assertEquals(0,controller.findById(order.getId()).get().getPastries().size());
//    }

}
