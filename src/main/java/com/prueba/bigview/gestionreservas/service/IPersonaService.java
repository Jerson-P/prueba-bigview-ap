package com.prueba.bigview.gestionreservas.service;

import org.springframework.http.ResponseEntity;

import com.prueba.bigview.gestionreservas.dtos.PersonaDTO;
import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Esta interfaz es la capa intermedia entre la capa de presentación y
 *          la capa de acceso a datos. Esta oculta los detalles de
 *          implementación de la capa de acceso a datos.
 * 
 */

public interface IPersonaService {

	ResponseEntity<ResponseDTO> guardarPersona(PersonaDTO personaDTO);
        
    ResponseEntity<ResponseDTO> obtenerPersonaPorId(Integer id);
}
