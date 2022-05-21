package org.aalonzo.service;

import org.aalonzo.BakeryOrder;
import org.aalonzo.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BakeryService {

    @Autowired
    BakeryRepository repository;
    public BakeryOrder startNew(String name) {
        return repository.save(new BakeryOrder(name));
    }

    public BakeryOrder update(BakeryOrder order) {
        return repository.save(order);
    }
}
