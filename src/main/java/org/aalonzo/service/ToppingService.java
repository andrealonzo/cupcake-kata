package org.aalonzo.service;

import org.aalonzo.domain.topping.Chocolate;
import org.aalonzo.domain.topping.Nuts;
import org.aalonzo.domain.topping.Topping;
import org.aalonzo.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {


    private ToppingRepository repository;
    @Autowired
    public ToppingService(ToppingRepository repository) {
        this.repository = repository;
    }

    public Iterable<Topping> findAll() {
        return repository.findAll();
    }
    public Topping add(String type){
        Topping topping;
        if(type.equalsIgnoreCase("chocolate")){
            topping = new Chocolate();
        }else{
            topping = new Nuts();
        }
        repository.save(topping);
        return topping;
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }
}
