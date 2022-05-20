package org.aalonzo.controller;

import org.aalonzo.PastryRepository;
import org.aalonzo.domain.pastry.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PastryController {

    @Autowired
    private PastryRepository repository;
    @GetMapping("/v1/pastry")
    public @ResponseBody Iterable<Pastry> getAllTasks(){
        return repository.findAll();
    }

}
