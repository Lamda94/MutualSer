/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alcancia.repositories;

import com.alcancia.models.ModelAlcancia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*
    Definimos una interface que nos permitira comunicarnos con la base de datos
*/
@Repository
public interface RepositorieAlcancia extends CrudRepository<ModelAlcancia, Long>{
    public abstract ModelAlcancia findByDenominacion(Integer denominacion);
}
