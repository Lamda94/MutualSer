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
/*
    Definimos la clase CotrollerAlcancia 
    que nos permitirá controlar y direccionar las peticiones del cliente.
*/

///Configuramos los cors para dar acceso a la de nuestro front al backend.
@CrossOrigin(origins = "http://localhost:8080")
///Definimos nuestra clase como controlador.
@RestController
///Definimos el punto de entra a nuestra api atravez de este controlador.
@RequestMapping(path = "/Alcancia")
public class ControllerAlcancia {
    
    @Autowired
    ServiceAlcancia serviceAlcancia;
    
    ///Definimos el método que nos ayudara a controlar las respuestas a las peticiones en la ruta "/"
    @GetMapping(path="/")
    public ArrayList<ModelAlcancia> getAll(){
        return this.serviceAlcancia.getAll();
    }
    
    ///Definimos el método que nos ayudara a controlar las respuestas a las peticiones en la ruta "/Save"       
    @PostMapping(path="/save")
    public ModelAlcancia saveAndUpdate(@RequestBody ModelAlcancia alcancia){
        return this.serviceAlcancia.save(alcancia);
    }
    
    
    ///Definimos el método que nos ayudara a controlar las respuestas a las peticiones en la ruta "/denominacion/{denominacion}"
    @GetMapping(path="/denominacion/{denominacion}")
    public ModelAlcancia getByDenominacion(@PathVariable("denominacion") Integer denominacion){
        return this.serviceAlcancia.findByDenominacion(denominacion);
    }
    
    ///Definimos el método que nos ayudara a controlar las respuestas a las peticiones en la ruta "/{id}"
    @GetMapping(path="/{id}")
    public Optional<ModelAlcancia> getById(@PathVariable("id") Long id){
        return this.serviceAlcancia.findById(id);
    }
}
