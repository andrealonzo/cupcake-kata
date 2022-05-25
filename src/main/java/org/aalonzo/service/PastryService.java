package org.aalonzo.service;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.PastryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PastryService {

    private final PastryRepository repository;
    private final PastryTypeRepository pastryTypeRepository;

    @Autowired
    public PastryService(PastryRepository repository, PastryTypeRepository pastryTypeRepository) {
        this.repository = repository;
        this.pastryTypeRepository = pastryTypeRepository;
    }

    public Iterable<Pastry> findAll() {
        return repository.findAll();
    }
    public Pastry add(String name, double price){
        PastryType pastryType = pastryTypeRepository.save(new PastryType(name, price));
        return repository.save(new Pastry(pastryType));
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}
