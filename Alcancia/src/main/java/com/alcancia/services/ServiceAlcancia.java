package com.alcancia.services;

import com.alcancia.models.ModelAlcancia;
import com.alcancia.repositories.RepositorieAlcancia;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    Definimos la clase donde desarrollaremos la lógica necesaria para poder dar respuesta a cada uno de los recursos
    solicitados por el cliente.
*/

///Definimos esta clase como service
@Service
public class ServiceAlcancia {
    @Autowired
    ///Instanciamos la interface RepositorieAlcancia para poder hacer uso de cada uno de sus métodos
    RepositorieAlcancia repositorieAlcancia;
    
    //Método que nos permite devolver los datos almacenados en la base de datos alcancía
    public ArrayList<ModelAlcancia> getAll(){
        ///Declaramos un array que contiene una lista de las denominaciones permitidas en la aplicación 
        ///para poder validar que existan los datos necesarios para el correcto funcionamiento de la aplicación
        Integer [] monedas = new Integer[]{50,100,200,500,1000};
        
        ///Recorremos el array para validar si existe o no el registro de cada una de las denominaciones
        ///y en caso que no exista el registro se realiza el registro de esta.
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
    
    ///Función encargada de realizar los registros y actualización de los datos de la tabla alcancía
    public ModelAlcancia save(ModelAlcancia alcancia){
        //Validamos si trata de hacer un update o crear un registro nuevo 
        if(alcancia.getId() != null){
            Integer deno = alcancia.getDenominacion();
            ModelAlcancia a = this.findByDenominacion(deno);
            a.setCantidad(a.getCantidad()+alcancia.getCantidad());
            a.setTotal(a.getCantidad()*deno);
            return this.repositorieAlcancia.save(a);
        }else{
            return this.repositorieAlcancia.save(alcancia);
        }
    }
    
    ///Función que nos permite responde a la consulta de los datos de una denominación en específico
    public ModelAlcancia findByDenominacion(Integer denominacion){
        return this.repositorieAlcancia.findByDenominacion(denominacion);
    }
    
    ///Función que nos permite responde a la consulta de los datos de una denominación mediante su id
    public Optional<ModelAlcancia> findById(Long id){
        return this.repositorieAlcancia.findById(id);
    }
}
