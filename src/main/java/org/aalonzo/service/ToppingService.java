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
    public Topping add(String type){
        Topping topping;
        if(type.equalsIgnoreCase("chocolate")){
            topping = new Topping("chocolate", .1);
        }else{
            topping = new Topping("nuts", .2);
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
