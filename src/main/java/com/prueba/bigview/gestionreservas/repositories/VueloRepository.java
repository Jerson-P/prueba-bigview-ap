package com.prueba.bigview.gestionreservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.prueba.bigview.gestionreservas.entities.VueloEntity;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Clase que contiene el método y variables de VueloRepository
 *          
 */

@Repository
public interface VueloRepository extends JpaRepository<VueloEntity, Integer>, JpaSpecificationExecutor<VueloEntity> {
	
}
