package org.aalonzo;

import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.repository.PastryRepository;
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
    @Test
    public void addCookie(){
        Pastry cookie = new Pastry("Cookie", 2.0);
        repository.save(cookie);
        assertEquals(1, repository.count());
    }
    @Test
    public void addCupCake(){
        Pastry cupcake = new Cupcake();
        repository.save(cupcake);
        assertEquals(1, repository.count());
    }

}
