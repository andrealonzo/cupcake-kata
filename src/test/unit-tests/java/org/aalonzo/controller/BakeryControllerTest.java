package org.aalonzo.controller;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.service.BakeryService;
import org.aalonzo.service.FakeBakeryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@AutoConfigureMockMvc
public class BakeryControllerTest {

    public static final String ORDER_1 = "order1";
    private BakeryRepository repository = new FakeBakeryRepository();

    private BakeryController controller = new BakeryController(new BakeryService(repository));

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

}
