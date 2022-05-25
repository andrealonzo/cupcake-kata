package org.aalonzo.controller;

import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.FakePastryTypeRepository;
import org.aalonzo.service.PastryTypeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PastryTypeControllerTest {

    PastryTypeController controller = new PastryTypeController(new PastryTypeService(new FakePastryTypeRepository()));

    @Test
    public void newControllerHasNoItems(){
        Iterable<PastryType> pastryTypes= controller.findAll();
        assertFalse(pastryTypes.iterator().hasNext());
    }

    @Test
    public void testAddPastryType(){
        PastryType expectedPastryType = new PastryType("Cookie", 1.0);

        controller.add(expectedPastryType.getName(), expectedPastryType.getPrice());

        Iterable<PastryType> pastryTypes= controller.findAll();
        assertTrue(pastryTypes.iterator().hasNext());
        PastryType actualPastryType = pastryTypes.iterator().next();
        assertEquals(actualPastryType.getName(), expectedPastryType.getName());
        assertEquals(actualPastryType.getPrice(), expectedPastryType.getPrice());
    }

}
