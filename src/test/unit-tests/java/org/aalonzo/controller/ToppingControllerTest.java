package org.aalonzo.controller;

import org.aalonzo.service.ToppingService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ToppingControllerTest {
    ToppingService mockService = mock(ToppingService.class);
    ToppingController controller = new ToppingController(mockService);
    @Test
    public void findAllCallsServiceFindAll(){
        controller.findAll();
        verify(mockService, times(1)).findAll();
    }
    @Test
    public void addCallsServiceAdd(){
        String type = "type";
        controller.add(type);
        verify(mockService, times(1)).add(type);
    }
}
