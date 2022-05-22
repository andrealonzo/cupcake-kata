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
    public Pastry add(String type){
        Pastry pastry;
        if(type.equalsIgnoreCase("cookie")){
            pastry = new Pastry("Cookie", 2.0);
        }else{
            pastry = new Pastry("Cupcake", 1.0);
        }
        repository.save(pastry);
        return pastry;
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}
