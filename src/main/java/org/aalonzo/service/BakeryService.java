package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.repository.BakeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BakeryService {

    public final BakeryRepository repository;
    @Autowired
    public BakeryService(@Qualifier("bakeryRepository") BakeryRepository repository) {
        this.repository = repository;
    }

    public BakeryOrder add(String name) {
        return repository.save(new BakeryOrder(name));
    }

    public BakeryOrder update(BakeryOrder order) {
        return repository.save(order);
    }
    public Iterable<BakeryOrder> findAll() {
        repository.count();
        return repository.findAll();
    }
    public long count() {
        return repository.count();
    }
    public Optional<BakeryOrder> findById(Long aLong) {
        return repository.findById(aLong);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void deleteById(long id) {
    }
}
