package org.aalonzo.service;

import org.aalonzo.domain.Pastry;
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

    public Iterable<Pastry> findAll() {
        return repository.findAll();
    }
    public Pastry add(String name, double price){
        return repository.save(new Pastry(name, price));
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}
