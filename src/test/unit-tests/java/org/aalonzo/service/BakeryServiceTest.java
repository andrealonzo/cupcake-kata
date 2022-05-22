package org.aalonzo.service;

import org.aalonzo.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.repository.BakeryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    @Disabled
    public void addCookieToOrder(){
        BakeryOrder order = service.startNew(GENERIC_ORDER_NAME);
        order.add(new Pastry("Cookie", 2.0));
        BakeryOrder updatedOrder = service.update(order);
        verify(mockRepo, times(2)).save(any());
    }
}
