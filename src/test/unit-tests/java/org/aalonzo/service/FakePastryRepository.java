package org.aalonzo.service;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakePastryRepository implements PastryRepository {

    Map<Long, Pastry> pastries;
    public FakePastryRepository() {
        Pastry pastry = new Pastry(new PastryType("Cupcake", 1.00));
        pastry.setId(1L);
        pastries = new HashMap<>();
        pastries.put(pastry.getId(), pastry);
    }

    @Override
    public <S extends Pastry> S save(S entity) {
        pastries.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public <S extends Pastry> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Pastry> findById(Long aLong) {

        return Optional.ofNullable(pastries.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Pastry> findAll() {
        return pastries.values();
    }

    @Override
    public Iterable<Pastry> findAllById(Iterable<Long> longs) {
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
    public void delete(Pastry entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Pastry> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
