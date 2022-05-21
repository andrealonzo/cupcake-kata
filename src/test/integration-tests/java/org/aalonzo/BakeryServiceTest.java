package org.aalonzo;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.service.BakeryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BakeryServiceTest {

    //TODO find out how to mock so we don't have to load full context
    @Autowired
    BakeryRepository bakeryRepository;
    @Autowired
    PastryRepository pastryRepository;
    @Autowired
    BakeryService service;
    @Test
    public void createNewOrder(){
        BakeryOrder order = service.startNew("order1");
        assertTrue(bakeryRepository.findById(order.getId()).isPresent());
        assertEquals("order1", bakeryRepository.findById(order.getId()).get().getName());
    }

    @Test
    public void addCookieToOrder(){
        BakeryOrder order = service.startNew("order1");
        Cookie cookie = pastryRepository.save(new Cookie());
        order.add(cookie);
        BakeryOrder updatedOrder = service.update(order);
        assertEquals(1, updatedOrder.getPastries().size());
        assertEquals(cookie.getName(), updatedOrder.getPastries().get(0).getName());
    }

}
