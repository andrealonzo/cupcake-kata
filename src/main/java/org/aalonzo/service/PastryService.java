package org.aalonzo.service;

import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.repository.PastryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastryService {

    @Autowired
    private PastryRepository repository;
    public Iterable<Pastry> findAll() {
        return repository.findAll();
    }
    public Pastry add(String type){
        Pastry pastry;
        if(type.equalsIgnoreCase("cookie")){
            pastry = new Cookie();
        }else{
            pastry = new Cupcake();
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
