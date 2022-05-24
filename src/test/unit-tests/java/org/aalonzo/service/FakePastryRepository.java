package org.aalonzo.service;

import org.aalonzo.domain.PastryWithToppings;
import org.aalonzo.repository.PastryRepository;

import java.util.*;

public class FakePastryRepository implements PastryRepository {

    Map<Long, PastryWithToppings> pastries;
    public FakePastryRepository() {
        PastryWithToppings pastry = new PastryWithToppings("Cupcake", 1.00);
        pastry.setId(1L);
        pastries = new HashMap<>();
        pastries.put(pastry.getId(), pastry);
    }

    @Override
    public <S extends PastryWithToppings> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PastryWithToppings> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PastryWithToppings> findById(Long aLong) {

        return Optional.ofNullable(pastries.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PastryWithToppings> findAll() {
        return pastries.values();
    }

    @Override
    public Iterable<PastryWithToppings> findAllById(Iterable<Long> longs) {
        return pastries.values();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PastryWithToppings entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PastryWithToppings> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
