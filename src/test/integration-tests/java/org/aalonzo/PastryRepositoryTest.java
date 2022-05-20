package org.aalonzo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PastryRepositoryTest {
    @Autowired
    private PastryRepository repository;
    @Test
    public void newRepositoryHasZeroItems(){
        assertEquals(0, repository.count());
    }

}
