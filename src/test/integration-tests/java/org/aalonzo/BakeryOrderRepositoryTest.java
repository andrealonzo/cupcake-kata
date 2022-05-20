package org.aalonzo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BakeryOrderRepositoryTest {
    @Autowired
    private BakeryRepository repository;
    @Test
    public void simpleTest(){

        assertEquals(0, repository.count());

    }
}
