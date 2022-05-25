package org.aalonzo;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.repository.BakeryOrderRepository;
import org.aalonzo.repository.PastryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BakeryOrderRepositoryTest {
    @Autowired
    private PastryRepository pastryRepository;
    @Autowired
    private BakeryOrderRepository bakeryOrderRepository;
    @Test
    public void newRepositoryHasZeroItems(){
        assertEquals(0, bakeryOrderRepository.count());
    }
    @Test
    public void addOneOrderShowsOneInRepo(){
        BakeryOrder order = new BakeryOrder("order1");
        bakeryOrderRepository.save(order);
        assertEquals(1, bakeryOrderRepository.count());
    }


    @Test
    public void addOneOrderWithCupcakeCanRetrieveOrderAndCupcake(){
        BakeryOrder order = new BakeryOrder("order1");
        Pastry cupcake = new Pastry("Cupcake", 1.0);
        pastryRepository.save(cupcake);
        order.add(cupcake);
        bakeryOrderRepository.save(order);

        assertTrue(bakeryOrderRepository.findById(order.getId()).isPresent());
        BakeryOrder actualOrder = bakeryOrderRepository.findById(order.getId()).get();
        assertEquals(1, bakeryOrderRepository.count());
        assertEquals(order, actualOrder);
        assertEquals(cupcake, actualOrder.getPastries().get(0));
    }
}
