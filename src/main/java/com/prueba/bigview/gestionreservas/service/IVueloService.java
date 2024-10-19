package com.prueba.bigview.gestionreservas.service;

import com.prueba.bigview.gestionreservas.dtos.VueloDTO;

import org.springframework.http.ResponseEntity;

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

public interface IVueloService {
	
	ResponseEntity<ResponseDTO> guardarVuelo(VueloDTO vueloDTO);
    
    ResponseEntity<ResponseDTO> obtenerVuelos();
    
    ResponseEntity<ResponseDTO> buscarVuelos(VueloDTO vueloDTO);
    
    ResponseEntity<ResponseDTO> obtenerVueloPorId(Integer id);
    
    ResponseEntity<ResponseDTO> actualizarVuelo(Integer id, VueloDTO vueloDTO);
    
    ResponseEntity<ResponseDTO> eliminarVuelo(Integer id);

}
