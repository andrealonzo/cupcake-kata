package org.aalonzo.controller;

import org.aalonzo.domain.PastryType;
import org.aalonzo.service.PastryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class PastryTypeController {
    private final PastryTypeService service;

    @Autowired
    public PastryTypeController(PastryTypeService service) {
        this.service = service;
    }

    @GetMapping("/pastry_type")
    public @ResponseBody Iterable<PastryType> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/pastry_type")
    public @ResponseBody PastryType add(@RequestParam String name, @RequestParam double price){
        return service.add(name, price);
    }
    @DeleteMapping(path="/pastry_type/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/pastry_type/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }
}
