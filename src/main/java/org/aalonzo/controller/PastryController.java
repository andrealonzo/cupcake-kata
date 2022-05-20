package org.aalonzo.controller;

import org.aalonzo.PastryRepository;
import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class PastryController {

    @Autowired
    private PastryRepository repository;
    @GetMapping("/pastry")
    public @ResponseBody Iterable<Pastry> findAll(){
        return repository.findAll();
    }
    @PostMapping(path="/pastry")
    public @ResponseBody Pastry add(){
        Pastry pastry = new Cookie();
        repository.save(pastry);
        return pastry;
    }

}
