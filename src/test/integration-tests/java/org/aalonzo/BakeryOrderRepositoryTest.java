package org.aalonzo;

import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BakeryOrderRepositoryTest {
    @Autowired
    private PastryRepository pastryRepository;
    @Autowired
    private BakeryRepository bakeryRepository;
    @Test
    public void newRepositoryHasZeroItems(){
        assertEquals(0, bakeryRepository.count());
    }
    @Test
    public void addOneOrderShowsOneInRepo(){
        BakeryOrder order = new BakeryOrder("order1");
        bakeryRepository.save(order);
        assertEquals(1, bakeryRepository.count());
    }


    @Test
    public void addOneOrderWithCupcakeCanRetrieveOrderAndCupcake(){
        BakeryOrder order = new BakeryOrder("order1");
        Pastry cupcake = new Cupcake();
        pastryRepository.save(cupcake);
        order.add(cupcake);
        bakeryRepository.save(order);

        BakeryOrder actualOrder = bakeryRepository.findById(order.getId()).get();
        assertEquals(1, bakeryRepository.count());
        assertEquals(order, actualOrder);
        assertEquals(cupcake, actualOrder.getPastries().get(0));
    }
}
