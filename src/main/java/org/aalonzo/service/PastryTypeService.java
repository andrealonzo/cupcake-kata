package org.aalonzo.service;

import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastryTypeService {

    private final PastryTypeRepository repository;

    @Autowired
    public PastryTypeService(PastryTypeRepository repository) {
        this.repository = repository;
    }

    public Iterable<PastryType> findAll() {
        return repository.findAll();
    }
    public PastryType add(String name, double price){
        return repository.save(new PastryType(name, price));
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }
}
