package org.aalonzo.service;

import org.aalonzo.domain.Topping;
import org.aalonzo.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {


    private final ToppingRepository repository;
    @Autowired
    public ToppingService(ToppingRepository repository) {
        this.repository = repository;
    }

    public Iterable<Topping> findAll() {
        return repository.findAll();
    }
    public Topping add(String type, double price){
        return repository.save(new Topping(type, price));
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }
}
