package com.prueba.bigview.gestionreservas.dtos;


import java.io.Serializable;
import java.util.Date;

import com.prueba.bigview.gestionreservas.enums.EstadoReserva;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa un DTO de una reserva.
 * 
 * Este DTO se utiliza para transferir información sobre la reserva
 * entre la capa de servicio y la capa de presentación.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private VueloDTO vuelo;
	private PersonaDTO persona;
	private Date fechaReserva;
	private String estado;

}
