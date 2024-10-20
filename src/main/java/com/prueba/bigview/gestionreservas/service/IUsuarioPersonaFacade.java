package com.prueba.bigview.gestionreservas.service;

import org.springframework.http.ResponseEntity;

import com.prueba.bigview.gestionreservas.dtos.ResponseDTO;
import com.prueba.bigview.gestionreservas.dtos.UsuarioPersonaDTO;

/**
 * @author Jerson Peña
 * @version 1.0
 * 
 *          Esta interfaz es la capa intermedia entre la capa de presentación y
 *          la capa de acceso a datos. Esta oculta los detalles de
 *          implementación de la capa de acceso a datos.
 * 
 */

public interface IUsuarioPersonaFacade {
	
    ResponseEntity<ResponseDTO> crearUsuarioPersona(UsuarioPersonaDTO usuarioPersonaDTO);
	
}
