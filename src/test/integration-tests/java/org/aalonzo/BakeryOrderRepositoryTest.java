package org.aalonzo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BakeryOrderRepositoryTest {
    @Autowired
    private BakeryRepository repository;
    @Test
    public void newRepositoryHasZeroItems(){
        assertEquals(0, repository.count());
    }
    @Test
    public void addOneOrderShowsOneInRepo(){
        BakeryOrder order = new BakeryOrder("order1");
        repository.save(order);
        assertEquals(1, repository.count());
    }

    @Test
    public void addOneOrderCanRetrieveIt(){
        BakeryOrder order = new BakeryOrder("order1");
        repository.save(order);
        assertEquals(1, repository.count());
        BakeryOrder actualOrder = repository.findById(order.getId()).get();
        assertEquals(order, actualOrder);
    }
}
