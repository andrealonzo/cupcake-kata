package org.aalonzo.service;

import org.aalonzo.domain.PastryWithToppings;
import org.aalonzo.repository.PastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastryService {

    private final PastryRepository repository;

    @Autowired
    public PastryService(PastryRepository repository) {
        this.repository = repository;
    }

    public Iterable<PastryWithToppings> findAll() {
        return repository.findAll();
    }
    public PastryWithToppings add(String name, double price){
        return repository.save(new PastryWithToppings(name, price));
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}
