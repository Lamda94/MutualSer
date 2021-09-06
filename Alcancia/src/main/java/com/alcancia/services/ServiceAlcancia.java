/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcancia.services;

import com.alcancia.models.ModelAlcancia;
import com.alcancia.repositories.RepositorieAlcancia;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAlcancia {
    @Autowired
    RepositorieAlcancia repositorieAlcancia;
    
    public ArrayList<ModelAlcancia> getAll(){
        Integer [] monedas = new Integer[]{50,100,200,500,1000};
        for (Integer moneda : monedas) {
            ModelAlcancia res = this.repositorieAlcancia.findByDenominacion(moneda);
            if (res == null) {
                ModelAlcancia a = new ModelAlcancia();
                a.setDenominacion(moneda);
                a.setCantidad(0);
                a.setTotal(0);
                this.repositorieAlcancia.save(a);
            }
        }
        return (ArrayList<ModelAlcancia>)this.repositorieAlcancia.findAll();
    }
    
    public ModelAlcancia save(ModelAlcancia alcancia){
        return this.repositorieAlcancia.save(alcancia);
    }
    
    public ModelAlcancia findByDenominacion(Integer denominacion){
        return this.repositorieAlcancia.findByDenominacion(denominacion);
    }
    
    public Optional<ModelAlcancia> findById(Long id){
        return this.repositorieAlcancia.findById(id);
    }
}
