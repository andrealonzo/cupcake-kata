package org.aalonzo;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.PastryTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PastryTypeRepositoryTest {
    @Autowired
    private PastryRepository repository;
    @Autowired
    private PastryTypeRepository pastryTypeRepository;
    @Test
    public void newRepositoryHasZeroItems(){
        assertEquals(0, repository.count());
    }
    @Test
    public void addCookie(){

        PastryType pastryType = pastryTypeRepository.save(new PastryType("Cookie", 2.0));
        Pastry cookie = new Pastry(pastryType);
        repository.save(cookie);
        assertEquals(1, repository.count());
    }
    @Test
    public void addCupCake(){

        PastryType pastryType = pastryTypeRepository.save(new PastryType("Cupcake", 1.0));
        Pastry cupcake = new Pastry(pastryType);
        repository.save(cupcake);
        assertEquals(1, repository.count());
    }

}
