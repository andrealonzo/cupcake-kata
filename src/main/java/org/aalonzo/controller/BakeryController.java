package org.aalonzo.controller;

import org.aalonzo.domain.BakeryOrder;
import org.aalonzo.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1")
public class BakeryController {

    private final BakeryService service;

    @Autowired
    public BakeryController(BakeryService service) {
        this.service = service;
    }

    @GetMapping("/bakery/order")
    public @ResponseBody Iterable<BakeryOrder> findAll(){
        return service.findAll();
    }
    @PostMapping(path="/bakery/order")
    public @ResponseBody BakeryOrder add(@RequestParam String name){
        return service.add(name);
    }
    @DeleteMapping(path="/bakery/order/delete/all")
    public @ResponseBody void deleteAll(){
        service.deleteAll();
    }

    @DeleteMapping(path="/bakery/order/delete")
    public @ResponseBody void delete(@RequestParam long id){
        service.deleteById(id);
    }

    public long count() {
        return service.count();
    }
    @DeleteMapping(path="/bakery/order/add/pastry")
    public void addPastryToOrder(@RequestParam long pastryId, @RequestParam long orderId) {
        service.addPastryToOrder(pastryId,orderId);

    }

    @GetMapping(path="/bakery/order/id")
    public Optional<BakeryOrder> findById(@RequestParam long id) {
        return service.findById(id);
    }

    public void addToppingToPastry(Long pastryId, Long toppingId) {
        service.addToppingToPastry(pastryId, toppingId);
    }
}
