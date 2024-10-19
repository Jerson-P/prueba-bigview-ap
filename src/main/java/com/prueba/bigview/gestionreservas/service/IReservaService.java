package com.prueba.bigview.gestionreservas.service;

import org.springframework.http.ResponseEntity;

import com.prueba.bigview.gestionreservas.dtos.ReservaDTO;
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

public interface IReservaService {
	
	ResponseEntity<ResponseDTO> guardarReserva(final ReservaDTO reserva);
	
    ResponseEntity<ResponseDTO> obtenerReservas();
    
    ResponseEntity<ResponseDTO> obtenerReservaPorId(Integer id);
    
    ResponseEntity<ResponseDTO> actualizarReserva(Integer id, final ReservaDTO reserva);
    
    ResponseEntity<ResponseDTO> eliminarReserva(Integer id);
}
