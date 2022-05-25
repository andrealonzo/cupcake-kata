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

    @Test
    public void testDeleteAddedPastry(){
        PastryType expectedPastryType = new PastryType("Cookie", 1.0);
        PastryType addedPastryType =  controller.add(expectedPastryType.getName(), expectedPastryType.getPrice());
        Iterable<PastryType> pastryTypes= controller.findAll();
        assertTrue(pastryTypes.iterator().hasNext());

        controller.delete(addedPastryType.getId());

        Iterable<PastryType> actualPastryTypes= controller.findAll();
        assertFalse(actualPastryTypes.iterator().hasNext());

    }
    @Test
    public void testDeleteAllPastries(){
        PastryType expectedPastryType = new PastryType("Cookie", 1.0);
        controller.add(expectedPastryType.getName(), expectedPastryType.getPrice());
        Iterable<PastryType> pastryTypes= controller.findAll();
        assertTrue(pastryTypes.iterator().hasNext());

        controller.deleteAll();

        Iterable<PastryType> actualPastryTypes= controller.findAll();
        assertFalse(actualPastryTypes.iterator().hasNext());

    }
}
