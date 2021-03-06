package org.aalonzo.controller;

import org.aalonzo.domain.Pastry;
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
    public @ResponseBody Pastry add(@RequestParam Long pastryTypeId){
        return service.add(pastryTypeId);
    }
    @DeleteMapping(path="/pastry/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/pastry/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="World")String name){
        return String.format("Hello %s!",name);
    }
}

