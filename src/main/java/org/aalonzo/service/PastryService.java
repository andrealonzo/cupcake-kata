package org.aalonzo.service;

import org.aalonzo.domain.Pastry;
import org.aalonzo.domain.PastryType;
import org.aalonzo.repository.PastryRepository;
import org.aalonzo.repository.PastryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Pastry add(Long pastryTypeId){
        Optional<PastryType> pastryType= pastryTypeRepository.findById(pastryTypeId);
        return pastryType.map(type -> repository.save(new Pastry(type))).orElse(null);
    }
    public void deleteAll(){
        repository.deleteAll();
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}
