package com.prueba.bigview.gestionreservas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.bigview.gestionreservas.entities.ReservaEntity;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Clase que contiene el método y variables de ReservaRepository
 *          
 */

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

}
