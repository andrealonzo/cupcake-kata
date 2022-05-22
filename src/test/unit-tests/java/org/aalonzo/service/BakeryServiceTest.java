package org.aalonzo.service;

import org.aalonzo.BakeryOrder;
import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.service.BakeryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BakeryServiceTest {

    public static final String GENERIC_ORDER_NAME = "order1";
    //TODO find out how to mock so we don't have to load full context

    BakeryRepository mockRepo = mock(BakeryRepository.class);
    BakeryService service = new BakeryService(mockRepo);

    @Test
    public void createNewOrder() {
        service.startNew(GENERIC_ORDER_NAME);
        verify(mockRepo, times(1)).save(any());
    }

    @Test
    public void addCookieToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        order.add(new Cookie());
        BakeryOrder updatedOrder = service.update(order);
        verify(mockRepo, times(2)).save(any());
    }
}
