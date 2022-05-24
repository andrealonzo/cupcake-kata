package org.aalonzo.controller;

import org.aalonzo.domain.PastryWithToppings;
import org.aalonzo.service.PastryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class PastryController {
    @Autowired
    private PastryService service;
    @GetMapping("/pastry")
    public @ResponseBody Iterable<PastryWithToppings> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/pastry")
    public @ResponseBody PastryWithToppings add(@RequestParam String name, @RequestParam double price){
        return service.add(name, price);
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
