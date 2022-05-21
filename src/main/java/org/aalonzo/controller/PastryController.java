package org.aalonzo.controller;

import org.aalonzo.respository.PastryRepository;
import org.aalonzo.domain.pastry.Cookie;
import org.aalonzo.domain.pastry.Cupcake;
import org.aalonzo.domain.pastry.Pastry;
import org.aalonzo.service.PastryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class PastryController {
    @Autowired
    private PastryService service;
    @GetMapping("/pastry")
    public @ResponseBody Iterable<Pastry> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/pastry")
    public @ResponseBody Pastry add(@RequestParam String type){
        return service.add(type);
    }
    @DeleteMapping(path="/pastry/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/pastry/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }



}
