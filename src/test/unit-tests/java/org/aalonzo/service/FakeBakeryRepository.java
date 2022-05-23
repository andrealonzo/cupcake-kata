package org.aalonzo.service;


import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.repository.BakeryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakeBakeryRepository implements BakeryRepository {
    private final Map<Long, BakeryOrder> bakeryOrders;
    long id;

    public FakeBakeryRepository() {
        bakeryOrders = new HashMap<>();
        id = 1;
    }

    public Map<Long, BakeryOrder> getBakeryOrders() {
        return bakeryOrders;
    }

    @Override
    public <S extends BakeryOrder> S save(S entity) {
        if(entity.getId()==null){
            entity.setId(id++);
        }
        bakeryOrders.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends BakeryOrder> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<BakeryOrder> findById(Long aLong) {
        return Optional.ofNullable(bakeryOrders.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<BakeryOrder> findAll() {
        return bakeryOrders.values();
    }

    @Override
    public Iterable<BakeryOrder> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return bakeryOrders.size();
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(BakeryOrder entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends BakeryOrder> entities) {

    }

    @Override
    public void deleteAll() {
        bakeryOrders.clear();
    }
}
