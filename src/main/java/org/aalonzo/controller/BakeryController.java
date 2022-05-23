package org.aalonzo.controller;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.domain.Pastry;
import org.aalonzo.repository.BakeryRepository;
import org.aalonzo.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1")
public class BakeryController {

    private BakeryService service;

    @Autowired
    public BakeryController(BakeryService service) {
        this.service = service;
    }

    @GetMapping("/bakery")
    public @ResponseBody Iterable<BakeryOrder> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/bakery")
    public @ResponseBody BakeryOrder add(@RequestParam String name){
        return service.add(name);
    }
    @DeleteMapping(path="/bakery/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/bakery/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }

    public long count() {
        return service.count();
    }
}
