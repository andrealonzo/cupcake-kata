package org.aalonzo.service;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.Topping;
import org.aalonzo.repository.BakeryOrderRepository;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BakeryService {

    public final BakeryOrderRepository bakeryOrderRepository;
    public final PastryRepository pastryRepository;
    public final ToppingRepository toppingRepository;
    @Autowired
    public BakeryService(@Qualifier("bakeryOrderRepository") BakeryOrderRepository bakeryOrderRepository, PastryRepository pastryRepository, ToppingRepository toppingRepository) {
        this.bakeryOrderRepository = bakeryOrderRepository;
        this.pastryRepository = pastryRepository;
        this.toppingRepository= toppingRepository;
    }

    public BakeryOrder add(String name) {
        return bakeryOrderRepository.save(new BakeryOrder(name));
    }

    public BakeryOrder update(BakeryOrder order) {
        return bakeryOrderRepository.save(order);
    }
    public Iterable<BakeryOrder> findAll() {
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

    public Optional<Pastry> addToppingToPastry(Long pastryId, Long toppingId) {
        Optional<Pastry> optionalPastry = pastryRepository.findById(pastryId);
        Optional<Topping> topping = toppingRepository.findById(toppingId);
        if(topping.isPresent()){
            Pastry pastry = optionalPastry.get();
            pastry.addTopping(topping.get());
            return Optional.of(pastryRepository.save(pastry));
        }
        return optionalPastry;
    }
}
