package org.aalonzo.repository;

import org.aalonzo.domain.PastryType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FakePastryTypeRepository implements PastryTypeRepository{

    private final Map<Long, PastryType> pastryTypes;
    private long id;
    public FakePastryTypeRepository() {
        pastryTypes = new HashMap<>();
        id = 1;
    }

    public Map<Long, PastryType> getPastryTypes() {
        return pastryTypes;
    }

    @Override
    public <S extends PastryType> S save(S entity) {
        if(entity.getId()==null){
            entity.setId(id++);
        }
        pastryTypes.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends PastryType> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PastryType> findById(Long aLong) {
        return Optional.ofNullable(pastryTypes.get(aLong));
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<PastryType> findAll() {
        return pastryTypes.values();
    }

    @Override
    public Iterable<PastryType> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return pastryTypes.size();
    }

    @Override
    public void deleteById(Long aLong) {
        pastryTypes.remove(aLong);
    }

    @Override
    public void delete(PastryType entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PastryType> entities) {

    }

    @Override
    public void deleteAll() {
        pastryTypes.clear();
    }
}
