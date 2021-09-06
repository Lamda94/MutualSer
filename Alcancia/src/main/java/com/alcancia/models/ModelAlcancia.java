package com.alcancia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*
    Definimos la clase que nos servirá como modelo para la estructura de los datos de la tabla alcancia
*/

///Definimos esta clase como de tipo entidad
@Entity
///Asignamos el nombre de la tabla que se generar basada en la estructura de los datos de esta clase
@Table(name="alcancia")
public class ModelAlcancia {
    
   ///Definimos el id de la tabla, le asignamos las restricciones necesarias y lo definimos como auto incrementable
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(unique = true, nullable = false)
   private Long id;
   
   ///Definimos el tipo de datos y restricciones para el campo denominacion 
   @Column(unique = true, nullable = false)
   private Integer denominacion;
   
   ///Definimos el tipo de datos y restricciones para el campo cantidad
   @Column(nullable = false)
   private Integer cantidad;
   
   ///Definimos el tipo de datos y restricciones para el campo total
   @Column(nullable = false)
   private Integer total;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(Integer denominacion) {
        this.denominacion = denominacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
