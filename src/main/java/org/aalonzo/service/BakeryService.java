package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.repository.BakeryOrderRepository;
import org.aalonzo.repository.PastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BakeryService {

    public final BakeryOrderRepository bakeryOrderRepository;
    public final PastryRepository pastryRepository;
    @Autowired
    public BakeryService(@Qualifier("bakeryOrderRepository") BakeryOrderRepository bakeryOrderRepository, PastryRepository pastryRepository) {
        this.bakeryOrderRepository = bakeryOrderRepository;
        this.pastryRepository = pastryRepository;
    }

    public BakeryOrder add(String name) {
        return bakeryOrderRepository.save(new BakeryOrder(name));
    }

    public BakeryOrder update(BakeryOrder order) {
        return bakeryOrderRepository.save(order);
    }
    public Iterable<BakeryOrder> findAll() {
        bakeryOrderRepository.count();
        return bakeryOrderRepository.findAll();
    }
    public long count() {
        return bakeryOrderRepository.count();
    }
    public Optional<BakeryOrder> findById(Long aLong) {

        return bakeryOrderRepository.findById(aLong);
    }

    public void deleteAll() {
        bakeryOrderRepository.deleteAll();
    }

    public void deleteById(long id) {
        bakeryOrderRepository.deleteById(id);
    }

    public void addPastryToOrder(long pastryId, long orderId) {
        Optional<Pastry> pastry = pastryRepository.findById(pastryId);
        if(pastry.isPresent()){
            BakeryOrder order = bakeryOrderRepository.findById(orderId).get();
            order.add(pastry.get());
            update(order);
        }
    }
}
