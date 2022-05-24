package org.aalonzo.service;

import org.aalonzo.domain.Topping;
import org.aalonzo.repository.ToppingRepository;

import java.util.Optional;

public class FakeToppingRepository implements ToppingRepository {
    @Override
    public <S extends Topping> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Topping> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Topping> findById(Long aLong) {
        Topping topping = new Topping("Chocolate", .10);
        topping.setId(2L);
        return Optional.of(topping);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Topping> findAll() {
        return null;
    }

    @Override
    public Iterable<Topping> findAllById(Iterable<Long> longs) {

        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Topping entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Topping> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
