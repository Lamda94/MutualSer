package com.alcancia.controllers;

import com.alcancia.models.ModelAlcancia;
import com.alcancia.services.ServiceAlcancia;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(path = "/Alcancia")
public class ControllerAlcancia {
    
    @Autowired
    ServiceAlcancia serviceAlcancia;
    
    @GetMapping(path="/")
    public ArrayList<ModelAlcancia> getAll(){
        return this.serviceAlcancia.getAll();
    }
    
    @PostMapping(path="/save")
    public ModelAlcancia saveAndUpdate(@RequestBody ModelAlcancia alcancia){
        if(alcancia.getId() != null){
            alcancia.setTotal(alcancia.getCantidad()*alcancia.getDenominacion());
        }
        System.out.println(alcancia.getTotal()+"--"+alcancia.getId());
        return this.serviceAlcancia.save(alcancia);
    }
    
    @GetMapping(path="/denominacion/{denominacion}")
    public ModelAlcancia getByDenominacion(@PathVariable("denominacion") Integer denominacion){
        return this.serviceAlcancia.findByDenominacion(denominacion);
    }
    
    @GetMapping(path="/{id}")
    public Optional<ModelAlcancia> getById(@PathVariable("id") Long id){
        return this.serviceAlcancia.findById(id);
    }
}
