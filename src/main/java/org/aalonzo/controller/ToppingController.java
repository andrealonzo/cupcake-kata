package org.aalonzo.controller;

import org.aalonzo.domain.Topping;
import org.aalonzo.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class ToppingController {
    private ToppingService service;

    @Autowired
    public ToppingController(ToppingService service) {
        this.service = service;
    }

    @GetMapping("/topping")
    public @ResponseBody Iterable<Topping> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/topping")
    public @ResponseBody Topping add(@RequestParam String name, @RequestParam double price){
        return service.add(name,price);
    }
    @DeleteMapping(path="/topping/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/topping/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }



}
